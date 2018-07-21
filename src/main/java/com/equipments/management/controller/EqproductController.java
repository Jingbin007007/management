package com.equipments.management.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.domain.*;
import com.equipments.management.domain.query.Patientappliquery;
import com.equipments.management.domain.query.Productquery;
import com.equipments.management.util.BeanUtil;
import com.equipments.management.util.POIUtil;
import com.equipments.management.util.PagedResult;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/product")
public class EqproductController {
    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqController.class);
    private static SqlSession sqlSession;
    private static SqlSessionFactory factory;

    protected final static String DATE_FORMATE = "yyyy-MM-dd";

    static{
        String resource = "mybatis-conf.xml";
        InputStream is = EqproductController.class.getClassLoader().getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    public EqproductController(){
        super();
    }


    @RequestMapping("/selectProductByIds")
    @ResponseBody
    public void selectProductByIds(HttpServletResponse response,
                                         @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                         @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                         @RequestParam(value="ids") Integer[] ids){

        sqlSession = factory.openSession(true);


        PageHelper.startPage(page,rows);


        for(Integer temp:ids){
            logger.info("-----------------+--------------------");
            logger.info(String.valueOf(temp));
        }

        if(ids != null){
            List<Product> productList = sqlSession.selectList("com.equipments.management.mapper.ProductMapper.selectByIds",ids);
            PagedResult<Product> pd = BeanUtil.toPagedResult(productList);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try{
                out = response.getWriter();
                out.println(JSON.toJSONString(pd, SerializerFeature.DisableCircularReferenceDetect));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                out.close();
            }
        }
        sqlSession.close();
    }

    /**
     *
     * @param response
     * @param page
     * @param rows
     * @param productno
     * @param patientname
     * @param applino
     * @param specialrequire
     * @param productstatus
     * @param resultkind
     * @param productdate001
     * @param productdate002
     */
    @RequestMapping("/selectProduct")
    @ResponseBody
    public void selectProduct(HttpServletResponse response,
                          @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                          @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                          @RequestParam(value="productno",defaultValue = "") String productno,
                          @RequestParam(value="patientname",defaultValue = "") String patientname,
                          @RequestParam(value="applino",defaultValue = "") String applino,
                          @RequestParam(value="specialrequire",defaultValue = "") String specialrequire,
                          @RequestParam(value="productstatus",defaultValue = "") String productstatus,
                          @RequestParam(value="resultkind",defaultValue = "") String resultkind,
                              @RequestParam(value="productdesc",defaultValue = "") String productdesc,
                              @RequestParam(value="scanstatus",defaultValue = "") String scanstatus,
                          @RequestParam(value="productdate001",defaultValue = "") String productdate001,
                          @RequestParam(value="productdate002",defaultValue = "") String productdate002){

        sqlSession = factory.openSession(true);

        Productquery productquery = new Productquery();

        SimpleDateFormat productdate001_sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat productdate002_sdf = new SimpleDateFormat("yyyy-MM-dd");

        if(!productdate001.equals("")){

            try {
                productquery.setProductdate001(productdate001_sdf.parse(productdate001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!productdate002.equals("")){

            try {
                productquery.setProductdate002(productdate002_sdf.parse(productdate002));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //此处patientname相当于patientno
        if(!productstatus.equals("")){
            productquery.setProductstatus(productstatus);
        }
        if(!resultkind.equals("")){
            productquery.setResultkind(resultkind);
        }
        if(!productno.equals("")){
            productquery.setProductno(Integer.valueOf(productno));
        }

        PageHelper.startPage(page,rows);
        List<Product> productList = sqlSession.selectList("com.equipments.management.mapper.ProductMapper.getProductByAllAvaliable",productquery);
        sqlSession.close();

        PagedResult<Product> pd = BeanUtil.toPagedResult(productList);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(pd, SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }



    //预览pdf文件
    @RequestMapping("/displayPDF/{file_name}/{file_ext}")
    public void displayPDF(HttpServletRequest request,
                           HttpServletResponse response,
                           @PathVariable String file_name,
                           @PathVariable String file_ext) {
        try {
            String url = request.getSession().getServletContext().getRealPath("/pdf/web");
            String pdfpath = file_name + "." + file_ext;

            File file = new File(url + "\\" + pdfpath);
            FileInputStream fileInputStream = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment;fileName=test.pdf");
            response.setContentType("multipart/form-data");
            OutputStream outputStream = response.getOutputStream();
            IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //上传文件
    @RequestMapping(value = "/loadfile")
    public String upload(HttpServletRequest request,
                         @RequestParam(value="id",defaultValue = "1") Integer id){

        sqlSession = factory.openSession(true);
        Medsheng med = new Medsheng() ;
        med.setId(id);

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String mytempFileName = file.getOriginalFilename();
                    String myFileName = null;
                    try {
                        myFileName = new String(mytempFileName.getBytes("utf-8"),"utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if((myFileName.trim())!=""){
                        //System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = file.getOriginalFilename();
                        //定义上传路径
                        String pathName = request.getSession().getServletContext().getRealPath("");
                        String path = pathName + "\\" + fileName;
                        File localFile = new File(path);
                        try {
                            file.transferTo(localFile);
                            med.setPdfpath(path);

                            //设置根据ID设置上传文件名称
                            sqlSession.update("com.equipments.management.mapper.shengyaoMedMapper.updateMed",med);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return "wrong";
                        }
                    }
                }
                else{

                    return "wrong";
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                Integer resulttime = new Integer(finaltime - pre);

            }

        }
        sqlSession.close();
        return "ok";
    }


    @RequestMapping("/updateBatchProductbyIds")
    @ResponseBody
    public void updateBatchProductbyIds(HttpServletResponse response,
                                        @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                        @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                        @RequestParam(value="ids") int[] ids){

        sqlSession = factory.openSession(true);
        PageHelper.startPage(page,rows);

        if(ids != null){
            //sqlSession.update("com.equipments.management.mapper.ProductMapper.updateBatch",ids);
            Product product = new Product();
            product.setProductstatus("未扫描");
            for(int i =0;i<ids.length;i++){
                product.setProductno(ids[i]);
                sqlSession.update("com.equipments.management.mapper.ProductMapper.updateProduct",product);
            }
            List<Product> productList = sqlSession.selectList("com.equipments.management.mapper.ProductMapper.getAllProducts");
            PagedResult<Product> pd = BeanUtil.toPagedResult(productList);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try{
                out = response.getWriter();
                out.println(JSON.toJSONString(pd, SerializerFeature.DisableCircularReferenceDetect));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                out.close();
            }
        }
        sqlSession.close();
    }



    @RequestMapping("/updateProductByIds")
    public void updateProductByIds(HttpServletResponse response,
                                       @RequestParam("rowLists") String rowLists,
                                       @RequestParam("lengthRecords") Integer len,
                                       @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                       @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        JSONArray jsonArray = JSONArray.parseArray(rowLists);

        sqlSession = factory.openSession(true);

        int count = sqlSession.selectOne("com.equipments.management.mapper.ProductMapper.countById");
        int pageNumber = count/rows +1;
        PageHelper.startPage(pageNumber,rows);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for(int i = 0;i < len;i++){
            Product product = new Product();
            com.alibaba.fastjson.JSONObject jUser = jsonArray.getJSONObject(i);

            Pathologydraw pathologydraw = new Pathologydraw();
            Staff staff = new Staff();
            pathologydraw.setDrawno(jUser.getInteger("drawno"));
            product.setDrawno(pathologydraw);
            product.setProductdesc(jUser.getString("productdesc"));
            product.setProductstatus(jUser.getString("productstatus"));
            product.setResultkind(jUser.getString("resultkind"));
            staff.setId(jUser.getInteger("productdoctorid"));
            product.setProductdoctorid(staff);
            product.setProductno(jUser.getInteger("productno"));
            String productdate = jUser.getString("productdate");
            if(productdate!=null){
                Date tempDate = null;
                try {
                    tempDate = formatter.parse(productdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                product.setProductdate(tempDate);
            }

            //jUser.getString("");
            sqlSession.update("com.equipments.management.mapper.PatientappliMapper.updatePatientappli",product);
        }
        List<Product> productList = sqlSession.selectList("com.equipments.management.mapper.ProductMapper.getAllProducts");
        sqlSession.close();
        PagedResult<Product> pd = BeanUtil.toPagedResult(productList);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(pd, SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @RequestMapping("/updateProductNote")
    @ResponseBody
    public String updateProductNote(HttpServletResponse response,
                                   @RequestParam("drawnote") String drawnote,
                                  @RequestParam("drawno") String drawno,
                                   @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                   @RequestParam(value="pageSize",defaultValue = "10") Integer rows){
        sqlSession = factory.openSession(true);

        HashMap<String,Object> map = new HashMap<String, Object>();

        Pathologydraw pathologydraw = new Pathologydraw();
        if(drawno != null && !drawno.equals("") && !drawno.equals("null")){
            pathologydraw.setDrawno(Integer.valueOf(drawno));
        }
        if(drawnote != null && !drawnote.equals("") && !drawnote.equals("null")){
            pathologydraw.setDrawnote(drawnote);
        }

        try{
            sqlSession.update("com.equipments.management.mapper.PathologydrawMapper.updatePathologydraw",pathologydraw);
        }catch (Exception e){
            e.printStackTrace();
        }
        sqlSession.close();
        return "success";
    }

    @RequestMapping("/updateProductByNote001")
    @ResponseBody
    public String updateProductByNote001(HttpServletResponse response,
                                    @RequestParam("productdesc") String productdesc,
                                    @RequestParam("productno") String productno,
                                    @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                    @RequestParam(value="pageSize",defaultValue = "10") Integer rows){
        sqlSession = factory.openSession(true);
        logger.info("-----------------------------------------------------------------");
        logger.info("-----------------------------------------------------------------");
        logger.info("-----------------------------------------------------------------");
        logger.info("-----------------------------------------------------------------");
        logger.info("-----------------------------------------------------------------");
        logger.info("-----------------------------------------------------------------");
        Product product = new Product();
        if(productno != null && !productno.equals("") && !productno.equals("null")){
            product.setProductno(Integer.valueOf(productno));
        }
        if(productdesc != null && !productdesc.equals("") && !productdesc.equals("null")){
            product.setProductdesc(productdesc);
        }

        try{
            sqlSession.update("com.equipments.management.mapper.ProductMapper.updateProduct",product);
        }catch (Exception e){
            e.printStackTrace();
        }
        sqlSession.close();
        return "success";
    }

    //删除Product记录
    @RequestMapping("/delProductById")
    public void delProductById(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value="ids") Integer[] ids){
        sqlSession = factory.openSession(true);

        response.reset();
        response.setContentType("text/html;charset=UTF-8");
        //业务逻辑操作查询用户
        for(int i = 0;i<ids.length;i++){
            try {
                sqlSession.delete("com.equipments.management.mapper.ProductMapper.removeProductById",ids[i]);
                response.getWriter().print(true);
                sqlSession.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * insertNewRecord
     * **/
    @RequestMapping("/insertNewProduct")
    @ResponseBody
    public Map<String,Object> insertNewProduct(HttpServletResponse response,
                                @RequestParam(value="resultkind",defaultValue = "") String resultkind,
                                @RequestParam(value="productnote",defaultValue = "") String productnote,
                                @RequestParam(value="drawno",defaultValue = "") String drawno,
                                               @RequestParam(value="productdoctorid",defaultValue = "") String productdoctorid,
                                               @RequestParam(value="productdesc",defaultValue = "") String productdesc,
                                               @RequestParam(value="productstatus",defaultValue = "待处理") String productstatus,
                                               @RequestParam(value="productdate",defaultValue = "") String productdate,
                                               @RequestParam(value="productfile",defaultValue = "") String productfile,
                                               @RequestParam(value="thumbnailfile",defaultValue = "") String thumbnailfile,
                                               @RequestParam(value="scandoctorid",defaultValue = "") String scandoctorid,
                                               @RequestParam(value="scandate",defaultValue = "") String scandate
                                              ){
        HashMap<String,Object> map = new HashMap<String, Object>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Product product = new Product();
        if(productdate != null && !productdate.equals("") && !productdate.equals("null")){
            Date tempDate = null;
            try {
                tempDate = formatter.parse(productdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            product.setProductdate(tempDate);
        }else{
            Date tempDate = new Date();
            try {
                tempDate = formatter.parse(tempDate.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            product.setProductdate(tempDate);
        }
        if(scandate !=null){
            Date tempDate1 = null;
            try {
                tempDate1 = formatter.parse(scandate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            product.setScandate(tempDate1);
        }else{
            Date tempDate1 = new Date();
            try {
                tempDate1 = formatter.parse(tempDate1.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            product.setScandate(tempDate1);
        }
        sqlSession = factory.openSession(true);

        if(resultkind !=null){
            product.setResultkind(resultkind);
        }
        if(productnote !=null){
            product.setProductnote(productnote);
        }
        if(drawno != null && !drawno.equals("") && !drawno.equals("null")){
            Pathologydraw pathologydraw = new Pathologydraw();
            pathologydraw.setDrawno(Integer.valueOf(drawno));
            product.setDrawno(pathologydraw);
        }
        //productdoctorid
        if(productdoctorid != null && !productdoctorid.equals("") && !productdoctorid.equals("null")){
            Staff productdoctor = new Staff();
            productdoctor.setId(Integer.valueOf(productdoctorid));
            product.setProductdoctorid(productdoctor);
        }else{
            Staff productdoctor = new Staff();
            productdoctor.setId(Integer.valueOf(9));
            product.setProductdoctorid(productdoctor);
        }
        //productdesc
        if(productdesc !=null){
            product.setProductdesc(productdesc);
        }
        //productstatus
        if(productdesc !=null){
            product.setProductdesc(productstatus);
        }
        //productfile
        if(productfile !=null){
            product.setProductfile(productfile);
        }
        //thumbnailfile
        if(thumbnailfile !=null){
            product.setThumbnailfile(thumbnailfile);
        }
        //scandoctorid
        if(scandoctorid != null && !scandoctorid.equals("") && !scandoctorid.equals("null")){
            Staff scandoctor = new Staff();
            scandoctor.setId(Integer.valueOf(scandoctorid));
            product.setScandoctorid(scandoctor);
        }else{
            Staff scandoctor = new Staff();
            scandoctor.setId(Integer.valueOf(9));
            product.setScandoctorid(scandoctor);
        }

        try{
            sqlSession.insert("com.equipments.management.mapper.ProductMapper.addProduct",product);
        }catch (Exception e){
            e.printStackTrace();
        }
        map.put("success",product);
        sqlSession.close();
        return map;
    }

    @RequestMapping("/admin/upload/files")
    @ResponseBody
    public Map<String, Object> updatePhoto(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam("input-b9") MultipartFile myFile,
                                           @RequestParam("fileid") Integer fileid){
        //fileid
        Map<String, Object> json = new HashMap<String, Object>();
        sqlSession = factory.openSession(true);
        Medsheng med = new Medsheng() ;
        med.setId(fileid);

        try {
            String url = request.getSession().getServletContext().getRealPath("/pdf/web");

            //String path = name + "." + ext;
            String path = myFile.getOriginalFilename();
            File file = new File(url);
            if(!file.exists()){
                file.mkdirs();
            }
            System.out.println("----------getOriginalFilename-----------");
            System.out.println(myFile.getOriginalFilename());
            myFile.transferTo(new File(url + "\\" + path));

            med.setPdfpath(path);
            //保存如表
            sqlSession.update("com.equipments.management.mapper.shengyaoMedMapper.updateMed",med);
            json.put("success", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return json ;
    }

    @RequestMapping("/downloadExcel")
    //@ResponseBody
    public void downloadExcel(HttpServletRequest request,
                              HttpServletResponse response,
                              @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                              @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                              @RequestParam(value="tongyongmingcheng",defaultValue = "") String tongyongmingcheng,
                              @RequestParam(value="yingwenming",defaultValue = "") String yingwenming,
                              @RequestParam(value="laiyuan",defaultValue = "") String laiyuan,
                              @RequestParam(value="yuanliao",defaultValue = "") String yuanliao,
                              @RequestParam(value="zhuangtai",defaultValue = "") String zhuangtai,
                              @RequestParam(value="leibie001",defaultValue = "") String leibie001,
                              @RequestParam(value="leibie002",defaultValue = "") String leibie002,
                              @RequestParam(value="leibie003",defaultValue = "") String leibie003,
                              @RequestParam(value="guanlileibie",defaultValue = "") String guanlileibie,
                              @RequestParam(value="chufangyao",defaultValue = "") String chufangyao,
                              @RequestParam(value="chengfen",defaultValue = "") String chengfen,
                              @RequestParam(value="biaozhunguidingguige",defaultValue = "") String biaozhunguidingguige,
                              @RequestParam(value="biaozhunwaiguige",defaultValue = "") String biaozhunwaiguige,
                              @RequestParam(value="shiyongduixiang",defaultValue = "") String shiyongduixiang,
                              @RequestParam(value="yongtu",defaultValue = "") String yongtu,
                              @RequestParam(value="xianlianghuoxiuyao",defaultValue = "") String xianlianghuoxiuyao,
                              @RequestParam(value="pizhunshijian",defaultValue = "") String pizhunshijian,
                              @RequestParam(value="biaozhunyange",defaultValue = "") String biaozhunyange,
                              @RequestParam(value="beizhu",defaultValue = "") String beizhu,
                              @RequestParam(value="shenbaodanwei",defaultValue = "") String shenbaodanwei,
                              @RequestParam(value="baocuntiaojian",defaultValue = "") String baocuntiaojian,
                              @RequestParam(value="zhijileibie",defaultValue = "") String zhijileibie,
                              @RequestParam(value="fufangyufou",defaultValue = "") String fufangyufou,
                              @RequestParam(value="yuliu001",defaultValue = "") String yuliu001,
                              @RequestParam(value="yuliu002",defaultValue = "") String yuliu002,
                              @RequestParam(value="jinkouyuguochan",defaultValue = "") String jinkouyuguochan,
                              @RequestParam(value="xiuyaoqi",defaultValue = "") String xiuyaoqi,
                              @RequestParam(value="jianyanxiangmu",defaultValue = "") String jianyanxiangmu,
                              @RequestParam(value="pizhunriqi1",defaultValue = "") String pizhunriqi1,
                              @RequestParam(value="pizhunriqi2",defaultValue = "") String pizhunriqi2) throws IOException {
        //Map<String, Object> json = new HashMap<String, Object>();
        sqlSession = factory.openSession(true);
        Medshengquery queryMed = new Medshengquery();

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
        if(!pizhunriqi1.equals("")){

            try {
                queryMed.setPizhunriqi1(sdf1.parse(pizhunriqi1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!pizhunriqi2.equals("")){

            try {
                queryMed.setPizhunriqi2(sdf2.parse(pizhunriqi2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(!jianyanxiangmu.equals("")){
            queryMed.setJianyanxiangmu(jianyanxiangmu);
        }
        if(!beizhu.equals("")){
            queryMed.setBeizhu(beizhu);
        }
        if(!biaozhunguidingguige.equals("")){
            queryMed.setBiaozhunguidingguige(biaozhunguidingguige);
        }
        if(!biaozhunwaiguige.equals("")){
            queryMed.setBiaozhunwaiguige(biaozhunwaiguige);
        }
        if(!biaozhunyange.equals("")){
            queryMed.setBiaozhunyange(biaozhunyange);
        }
        if(!chengfen.equals("")){
            queryMed.setChengfen(chengfen);
        }
        if(!chufangyao.equals("")){
            queryMed.setChufangyao(chufangyao);
        }
        if(!guanlileibie.equals("")){
            queryMed.setGuanlileibie(guanlileibie);
        }
        if(!laiyuan.equals("")){
            queryMed.setLaiyuan(laiyuan);
        }
        if(!leibie001.equals("")){
            queryMed.setLeibie001(leibie001);
        }
        if(!leibie002.equals("")){
            queryMed.setLeibie002(leibie002);
        }
        if(!leibie003.equals("")){
            queryMed.setLeibie003(leibie003);
        }
        if(!pizhunshijian.equals("")){
            queryMed.setPizhunshijian(pizhunshijian);
        }
        if(!shiyongduixiang.equals("")){
            queryMed.setShiyongduixiang(shiyongduixiang);
        }
        if(!tongyongmingcheng.equals("")){
            queryMed.setTongyongmingcheng(tongyongmingcheng);
        }
        if(!xianlianghuoxiuyao.equals("")){
            queryMed.setXianlianghuoxiuyao(xianlianghuoxiuyao);
        }
        if(!yingwenming.equals("")){
            queryMed.setYingwenming(yingwenming);
        }
        if(!yongtu.equals("")){
            queryMed.setYongtu(yongtu);
        }
        if(!yuanliao.equals("")){
            queryMed.setYuanliao(yuanliao);
        }
        if(!zhuangtai.equals("")){
            queryMed.setZhuangtai(zhuangtai);
        }
        //补充字段
        if(!shenbaodanwei.equals("")){
            queryMed.setShenbaodanwei(shenbaodanwei);
        }
        if(!baocuntiaojian.equals("")){
            queryMed.setBaocuntiaojian(baocuntiaojian);
        }
        if(!zhijileibie.equals("")){
            queryMed.setZhijileibie(zhijileibie);
        }
        if(!fufangyufou.equals("")){
            queryMed.setFufangyufou(fufangyufou);
        }
        if(!yuliu001.equals("")){
            queryMed.setYuliu001(yuliu001);
        }
        if(!yuliu002.equals("")){
            queryMed.setYuliu002(yuliu002);
        }
        if(!jinkouyuguochan.equals("")){
            queryMed.setJinkouyuguochan(jinkouyuguochan);
        }
        if(!xiuyaoqi.equals("")){
            queryMed.setXiuyaoqi(xiuyaoqi);
        }

        String[] tempheaders = {"id","通用名称","英文名","来源","原料","状态","一类类别","二类类别","三类类别","管理类别","处方药","成分","标准规定规格","标准外规格","适用对象","用途","限量或休药","批准时间","标准沿革","备注","pdf文件路径","申报单位","保存条件","制剂类别","复方与否","预留一","预留二","进口或国产","休药期","检验项目","批准日期"};
        List<String> headers = new ArrayList<String>();

        for(String temp:tempheaders){
            headers.add(temp);
        }

        List<Medsheng> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getMedByAll",queryMed);
        sqlSession.close();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String filename = "shengyao" + df.format(new Date()) +".xls";
        response.setContentType("text/html;charset=UTF-8");
        POIUtil.test_shengyao(response,"shengyao",headers,medList,filename);
        //json.put("success","下载成功");
        //return json;
    }
}
