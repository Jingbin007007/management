package com.equipments.management.util;

import com.equipments.management.domain.Med;
import com.equipments.management.domain.Medsheng;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/12/3.
 */
public class POIUtil {
    private static final Logger logger = LoggerFactory.getLogger(POIUtil.class);
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    /**
     * 读入excel文件，解析后返回
     * @param file
     */
    public static int getNumberOfFirstRow(MultipartFile file){
        Workbook workbook = getWorkBook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        return row.getPhysicalNumberOfCells();
    }
    public static List<String[]> readExcel(MultipartFile file) throws IOException {
        //检查文件
        checkFile(file);
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
        List<String[]> list = new ArrayList<String[]>();
        int tempNumberOfFirstRow = POIUtil.getNumberOfFirstRow(file);
        if(workbook != null){
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
                //获得当前sheet工作表
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){
                    continue;
                }
                //获得当前sheet的开始行
                int firstRowNum  = sheet.getFirstRowNum();
                //获得当前sheet的结束行
                int lastRowNum = sheet.getLastRowNum();
                //循环除了第一行的所有行
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
                    //获得当前行
                    Row row = sheet.getRow(rowNum);
                    if(row == null){
                        continue;
                    }
                    //获得当前行的开始列
                    int firstCellNum = row.getFirstCellNum();
                    //获得当前行的列数
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[tempNumberOfFirstRow];
                    //循环当前行
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                    }
                    list.add(cells);
                }
            }
            workbook.close();
        }
        return list;
    }
    public static void checkFile(MultipartFile file) throws IOException{
        //判断文件是否存在
        if(null == file){
            logger.error("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if(!fileName.endsWith(xls) && !fileName.endsWith(xlsx)){
            logger.error(fileName + "不是excel文件");
            throw new IOException(fileName + "不是excel文件");
        }
    }
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith(xls)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(xlsx)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return workbook;
    }
    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
    public static Map<String, Object> insertTables(Map<String, Object> json,String tableName, List<String[]> listStrings, SqlSession sqlSession, MultipartFile myFile){
        /*
         * tableName:化药
         * 字段列表：通用名称,英文名,来源,原料,状态,一类类别,二类类别,三类类别,管理类别,处方药,成分,标准规定规格,标准外规格,适用对象,用途,限量或休药,批准时间,标准沿革,备注,休药期,进口或国产,预留二,预留一,复方与否,制剂类别,保存条件,申报单位
         */
        int tempNumberOfFirstRow = POIUtil.getNumberOfFirstRow(myFile);
        if(tableName.equals("huayao")){
            try {
                Med med = new Med();
                //获得数据矩阵
                listStrings  = POIUtil.readExcel(myFile);
                logger.info("----------------测试数据-----------------");
                logger.info("----------------化药行数-----------------");
                logger.info(String.valueOf(listStrings.size()));
                for(String[] tempStrList:listStrings){
                    logger.info("-------------------列数----------------");
                    logger.info(String.valueOf(tempNumberOfFirstRow));
                    if(tempNumberOfFirstRow != 29){
                        json.put("error","表列数不满足");
                        return json;
                    }
                    logger.info("-----------------数据宽度--------------");
                    logger.info(String.valueOf(tempStrList.length));

                    if(tempStrList[0] != null)
                        med.setTongyongmingcheng(tempStrList[0]);
                    if(tempStrList[1] != null)
                        med.setYingwenming(tempStrList[1]);
                    if(tempStrList[2] != null)
                        med.setLaiyuan(tempStrList[2]);
                    if(tempStrList[3] != null)
                        med.setYuanliao(tempStrList[3]);
                    if(tempStrList[4] != null)
                        med.setZhuangtai(tempStrList[4]);
                    if(tempStrList[5] != null)
                        med.setLeibie001(tempStrList[5]);
                    if(tempStrList[6] != null)
                        med.setLeibie002(tempStrList[6]);
                    if(tempStrList[7] != null)
                        med.setLeibie003(tempStrList[7]);
                    if(tempStrList[8] != null)
                        med.setGuanlileibie(tempStrList[8]);
                    if(tempStrList[9] != null)
                        med.setChufangyao(tempStrList[9]);
                    if(tempStrList[10] != null)
                        med.setChengfen(tempStrList[10]);
                    if(tempStrList[11] != null)
                        med.setBiaozhunguidingguige(tempStrList[11]);
                    if(tempStrList[12] != null)
                        med.setBiaozhunwaiguige(tempStrList[12]);
                    if(tempStrList[13] != null)
                        med.setShiyongduixiang(tempStrList[13]);
                    if(tempStrList[14] != null)
                        med.setYongtu(tempStrList[14]);
                    if(tempStrList[15] != null)
                        med.setXianlianghuoxiuyao(tempStrList[15]);
                    if(tempStrList[16] != null)
                        med.setPizhunshijian(tempStrList[16]);
                    if(tempStrList[17] != null)
                        med.setBiaozhunyange(tempStrList[17]);
                    if(tempStrList[18] != null)
                        med.setBeizhu(tempStrList[18]);
                    if(tempStrList[19] != null)
                        med.setPdfpath(tempStrList[19]);
                    if(tempStrList[20] != null)
                        med.setShenbaodanwei(tempStrList[20]);
                    if(tempStrList[21] != null)
                        med.setBaocuntiaojian(tempStrList[21]);
                    if(tempStrList[22] != null)
                        med.setZhijileibie(tempStrList[22]);
                    if(tempStrList[23] != null)
                        med.setFufangyufou(tempStrList[23]);
                    if(tempStrList[24] != null)
                        med.setYuliu001(tempStrList[24]);
                    if(tempStrList[25] != null)
                        med.setYuliu002(tempStrList[25]);
                    if(tempStrList[26] != null)
                        med.setJinkouyuguochan(tempStrList[26]);
                    if(tempStrList[27] != null)
                        med.setXiuyaoqi(tempStrList[27]);

                        if((tempStrList[28] != null) && (!tempStrList[28].equals(""))){
                            Date tempDate = new Date(tempStrList[28]);
                            med.setPizhunriqi(tempDate);
                        }

                        List<Med> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getMedByAllEqual",med);

                        if(medList.isEmpty()){
                            sqlSession.insert("com.equipments.management.mapper.MedMapper.addMed",med);
                        }

                }
                json.put("success", "载入数据成功");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        /*
         *
         * tableName:中药
         * 字段列表：
         */
        if(tableName.equals("zhongyao")){
            try {
                Med med = new Med();
                //获得数据矩阵
                listStrings  = POIUtil.readExcel(myFile);
                logger.info("----------------中药行数-----------------");
                logger.info(String.valueOf(listStrings.size()));
                for(String[] tempStrList:listStrings){
                    logger.info("-------------------列数----------------");
                    logger.info(String.valueOf(tempStrList.length));
                    if(tempNumberOfFirstRow != 29){
                        json.put("error","表列数不满足");
                        return json;
                    }
                    if(tempStrList[0] != null)
                        med.setTongyongmingcheng(tempStrList[0]);
                    if(tempStrList[1] != null)
                        med.setYingwenming(tempStrList[1]);
                    if(tempStrList[2] != null)
                        med.setLaiyuan(tempStrList[2]);
                    if(tempStrList[3] != null)
                        med.setYuanliao(tempStrList[3]);
                    if(tempStrList[4] != null)
                        med.setZhuangtai(tempStrList[4]);
                    if(tempStrList[5] != null)
                        med.setLeibie001(tempStrList[5]);
                    if(tempStrList[6] != null)
                        med.setLeibie002(tempStrList[6]);
                    if(tempStrList[7] != null)
                        med.setLeibie003(tempStrList[7]);
                    if(tempStrList[8] != null)
                        med.setGuanlileibie(tempStrList[8]);
                    if(tempStrList[9] != null)
                        med.setChufangyao(tempStrList[9]);
                    if(tempStrList[10] != null)
                        med.setChengfen(tempStrList[10]);
                    if(tempStrList[11] != null)
                        med.setBiaozhunguidingguige(tempStrList[11]);
                    if(tempStrList[12] != null)
                        med.setBiaozhunwaiguige(tempStrList[12]);
                    if(tempStrList[13] != null)
                        med.setShiyongduixiang(tempStrList[13]);
                    if(tempStrList[14] != null)
                        med.setYongtu(tempStrList[14]);
                    if(tempStrList[15] != null)
                        med.setXianlianghuoxiuyao(tempStrList[15]);
                    if(tempStrList[16] != null)
                        med.setPizhunshijian(tempStrList[16]);
                    if(tempStrList[17] != null)
                        med.setBiaozhunyange(tempStrList[17]);
                    if(tempStrList[18] != null)
                        med.setBeizhu(tempStrList[18]);
                    if(tempStrList[19] != null)
                        med.setPdfpath(tempStrList[19]);
                    if(tempStrList[20] != null)
                        med.setShenbaodanwei(tempStrList[20]);
                    if(tempStrList[21] != null)
                        med.setBaocuntiaojian(tempStrList[21]);
                    if(tempStrList[22] != null)
                        med.setZhijileibie(tempStrList[22]);
                    if(tempStrList[23] != null)
                        med.setFufangyufou(tempStrList[23]);
                    if(tempStrList[24] != null)
                        med.setYuliu001(tempStrList[24]);
                    if(tempStrList[25] != null)
                        med.setYuliu002(tempStrList[25]);
                    if(tempStrList[26] != null)
                        med.setJinkouyuguochan(tempStrList[26]);
                    if(tempStrList[27] != null)
                        med.setXiuyaoqi(tempStrList[27]);
                    if((tempStrList[28] != null) && (!tempStrList[28].equals(""))){
                        Date tempDate = new Date(tempStrList[28]);
                        med.setPizhunriqi(tempDate);
                    }
                    List<Med> medList = sqlSession.selectList("com.equipments.management.mapper.zhongyaoMedMapper.getMedByAllEqual",med);

                    if(medList.isEmpty()){
                        sqlSession.insert("com.equipments.management.mapper.zhongyaoMedMapper.addMed",med);
                    }
                }
                json.put("success", "载入数据成功");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        /*
         *
         * tableName:生药
         * 字段列表：
         */
        if(tableName.equals("shengyao")){
            try {
                Medsheng med = new Medsheng();
                //获得数据矩阵
                listStrings  = POIUtil.readExcel(myFile);
                logger.info("----------------生药行数-----------------");
                logger.info(String.valueOf(listStrings.size()));
                for(String[] tempStrList:listStrings){
                    logger.info("-------------------列数----------------");
                    logger.info(String.valueOf(tempStrList.length));
                    if(tempNumberOfFirstRow != 30){
                        json.put("error","表列数不满足");
                        return json;
                    }
                    if(tempStrList[0] != null)
                        med.setTongyongmingcheng(tempStrList[0]);
                    if(tempStrList[1] != null)
                        med.setYingwenming(tempStrList[1]);
                    if(tempStrList[2] != null)
                        med.setLaiyuan(tempStrList[2]);
                    if(tempStrList[3] != null)
                        med.setYuanliao(tempStrList[3]);
                    if(tempStrList[4] != null)
                        med.setZhuangtai(tempStrList[4]);
                    if(tempStrList[5] != null)
                        med.setLeibie001(tempStrList[5]);
                    if(tempStrList[6] != null)
                        med.setLeibie002(tempStrList[6]);
                    if(tempStrList[7] != null)
                        med.setLeibie003(tempStrList[7]);
                    if(tempStrList[8] != null)
                        med.setGuanlileibie(tempStrList[8]);
                    if(tempStrList[9] != null)
                        med.setChufangyao(tempStrList[9]);
                    if(tempStrList[10] != null)
                        med.setChengfen(tempStrList[10]);
                    if(tempStrList[11] != null)
                        med.setBiaozhunguidingguige(tempStrList[11]);
                    if(tempStrList[12] != null)
                        med.setBiaozhunwaiguige(tempStrList[12]);
                    if(tempStrList[13] != null)
                        med.setShiyongduixiang(tempStrList[13]);
                    if(tempStrList[14] != null)
                        med.setYongtu(tempStrList[14]);
                    if(tempStrList[15] != null)
                        med.setXianlianghuoxiuyao(tempStrList[15]);
                    if(tempStrList[16] != null)
                        med.setPizhunshijian(tempStrList[16]);
                    if(tempStrList[17] != null)
                        med.setBiaozhunyange(tempStrList[17]);
                    if(tempStrList[18] != null)
                        med.setBeizhu(tempStrList[18]);
                    if(tempStrList[19] != null)
                        med.setPdfpath(tempStrList[19]);
                    if(tempStrList[20] != null)
                        med.setShenbaodanwei(tempStrList[20]);
                    if(tempStrList[21] != null)
                        med.setBaocuntiaojian(tempStrList[21]);
                    if(tempStrList[22] != null)
                        med.setZhijileibie(tempStrList[22]);
                    if(tempStrList[23] != null)
                        med.setFufangyufou(tempStrList[23]);
                    if(tempStrList[24] != null)
                        med.setYuliu001(tempStrList[24]);
                    if(tempStrList[25] != null)
                        med.setYuliu002(tempStrList[25]);
                    if(tempStrList[26] != null)
                        med.setJinkouyuguochan(tempStrList[26]);
                    if(tempStrList[27] != null)
                        med.setXiuyaoqi(tempStrList[27]);
                    if(tempStrList[28] != null)
                    med.setJianyanxiangmu(tempStrList[28]);
                    if((tempStrList[29] != null) && (!tempStrList[29].equals(""))){
                        Date tempDate = new Date(tempStrList[29]);
                        med.setPizhunriqi(tempDate);
                    }
                    List<Medsheng> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getMedByAllEqual",med);

                    if(medList.isEmpty()){
                        sqlSession.insert("com.equipments.management.mapper.shengyaoMedMapper.addMed",med);
                    }
                }
                json.put("success", "载入数据成功");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return json;
    }

    public void download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(
                    response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=utf8");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void test(HttpServletResponse response,
                            String sheetname,
                            List<String> headers,
                            List<Med> medList,
                            String path) throws IOException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet(sheetname);
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        for(int i = 0;i<headers.size();i++){
            row1.createCell(i).setCellValue(headers.get(i));
        }

        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        //sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        //在sheet里创建第二行

        for(int i=0;i<medList.size();i++){
            Med tempmed = medList.get(i);
            HSSFRow temprow = sheet.createRow(i+1);

            temprow.createCell(0).setCellValue(tempmed.getId());
            temprow.createCell(1).setCellValue(tempmed.getTongyongmingcheng());
            temprow.createCell(2).setCellValue(tempmed.getYingwenming());
            temprow.createCell(3).setCellValue(tempmed.getLaiyuan());
            temprow.createCell(4).setCellValue(tempmed.getYuanliao());
            temprow.createCell(5).setCellValue(tempmed.getZhuangtai());
            temprow.createCell(6).setCellValue(tempmed.getLeibie001());
            temprow.createCell(7).setCellValue(tempmed.getLeibie002());
            temprow.createCell(8).setCellValue(tempmed.getLeibie003());
            temprow.createCell(9).setCellValue(tempmed.getGuanlileibie());
            temprow.createCell(10).setCellValue(tempmed.getChufangyao());
            temprow.createCell(11).setCellValue(tempmed.getChengfen());
            temprow.createCell(12).setCellValue(tempmed.getBiaozhunguidingguige());
            temprow.createCell(13).setCellValue(tempmed.getBiaozhunwaiguige());
            temprow.createCell(14).setCellValue(tempmed.getShiyongduixiang());
            temprow.createCell(15).setCellValue(tempmed.getYongtu());
            temprow.createCell(16).setCellValue(tempmed.getXianlianghuoxiuyao());
            temprow.createCell(17).setCellValue(tempmed.getPizhunshijian());
            temprow.createCell(18).setCellValue(tempmed.getBiaozhunyange());
            temprow.createCell(19).setCellValue(tempmed.getBeizhu());
            temprow.createCell(20).setCellValue(tempmed.getPdfpath());
            temprow.createCell(21).setCellValue(tempmed.getShenbaodanwei());
            temprow.createCell(22).setCellValue(tempmed.getBaocuntiaojian());
            temprow.createCell(23).setCellValue(tempmed.getZhijileibie());
            temprow.createCell(24).setCellValue(tempmed.getFufangyufou());
            temprow.createCell(25).setCellValue(tempmed.getYuliu001());
            temprow.createCell(26).setCellValue(tempmed.getYuliu002());
            temprow.createCell(27).setCellValue(tempmed.getJinkouyuguochan());
            temprow.createCell(28).setCellValue(tempmed.getXiuyaoqi());

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date tempDate = tempmed.getPizhunriqi();
            if(tempDate !=null){
                //String tempStr = String.valueOf(tempDate.getYear()) + "-" + String.valueOf(tempDate.getMonth()) + "-" + String.valueOf(tempDate.getDay());
                String tempStr = sdf.format(tempDate);
                temprow.createCell(29).setCellValue(tempStr);
            }
        }

        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + path);
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();

    }

    public static void test_shengyao(HttpServletResponse response,
                            String sheetname,
                            List<String> headers,
                            List<Medsheng> medList,
                            String path) throws IOException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet(sheetname);
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        for(int i = 0;i<headers.size();i++){
            row1.createCell(i).setCellValue(headers.get(i));
        }

        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        //sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
        //在sheet里创建第二行
        for(int i=0;i<medList.size();i++){
            Medsheng tempmed = medList.get(i);
            HSSFRow temprow = sheet.createRow(i+1);

            temprow.createCell(0).setCellValue(tempmed.getId());
            temprow.createCell(1).setCellValue(tempmed.getTongyongmingcheng());
            temprow.createCell(2).setCellValue(tempmed.getYingwenming());
            temprow.createCell(3).setCellValue(tempmed.getLaiyuan());
            temprow.createCell(4).setCellValue(tempmed.getYuanliao());
            temprow.createCell(5).setCellValue(tempmed.getZhuangtai());
            temprow.createCell(6).setCellValue(tempmed.getLeibie001());
            temprow.createCell(7).setCellValue(tempmed.getLeibie002());
            temprow.createCell(8).setCellValue(tempmed.getLeibie003());
            temprow.createCell(9).setCellValue(tempmed.getGuanlileibie());
            temprow.createCell(10).setCellValue(tempmed.getChufangyao());
            temprow.createCell(11).setCellValue(tempmed.getChengfen());
            temprow.createCell(12).setCellValue(tempmed.getBiaozhunguidingguige());
            temprow.createCell(13).setCellValue(tempmed.getBiaozhunwaiguige());
            temprow.createCell(14).setCellValue(tempmed.getShiyongduixiang());
            temprow.createCell(15).setCellValue(tempmed.getYongtu());
            temprow.createCell(16).setCellValue(tempmed.getXianlianghuoxiuyao());
            temprow.createCell(17).setCellValue(tempmed.getPizhunshijian());
            temprow.createCell(18).setCellValue(tempmed.getBiaozhunyange());
            temprow.createCell(19).setCellValue(tempmed.getBeizhu());
            temprow.createCell(20).setCellValue(tempmed.getPdfpath());
            temprow.createCell(21).setCellValue(tempmed.getShenbaodanwei());
            temprow.createCell(22).setCellValue(tempmed.getBaocuntiaojian());
            temprow.createCell(23).setCellValue(tempmed.getZhijileibie());
            temprow.createCell(24).setCellValue(tempmed.getFufangyufou());
            temprow.createCell(25).setCellValue(tempmed.getYuliu001());
            temprow.createCell(26).setCellValue(tempmed.getYuliu002());
            temprow.createCell(27).setCellValue(tempmed.getJinkouyuguochan());
            temprow.createCell(28).setCellValue(tempmed.getXiuyaoqi());
            temprow.createCell(29).setCellValue(tempmed.getJianyanxiangmu());

            Date tempDate = tempmed.getPizhunriqi();
            if(tempDate !=null){
                String tempStr = String.valueOf(tempDate.getYear()) + "-" + String.valueOf(tempDate.getMonth()) + "-" + String.valueOf(tempDate.getDay());
                temprow.createCell(30).setCellValue(tempStr);
            }


        }
/*
        FileOutputStream fileOut = new FileOutputStream(path);
        wb.write(fileOut);
        fileOut.close();
*/
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + path);
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();

    }
}
