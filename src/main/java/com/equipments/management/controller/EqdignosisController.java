package com.equipments.management.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.domain.*;
import com.equipments.management.domain.gradation.*;
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
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/dignosis")
public class EqdignosisController {
    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqController.class);
    private static SqlSession sqlSession;
    private static SqlSessionFactory factory;

    protected final static String DATE_FORMATE = "yyyy-MM-dd";

    static{
        String resource = "mybatis-conf.xml";
        InputStream is = EqdignosisController.class.getClassLoader().getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    public EqdignosisController(){
        super();
    }
    /**
     *
     * @param response
     * @param page
     * @param rows
     * @param patientname
     * @param applino

     */
    @RequestMapping("/selectDiagnosisinfo")
    @ResponseBody
    public void selectDiagnosis(HttpServletResponse response,
                          @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                          @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                          @RequestParam(value="patientname",defaultValue = "") String patientname,
                          @RequestParam(value="applino",defaultValue = "") String applino,
                          @RequestParam(value="consultationif",defaultValue = "") String consultationif,
                          @RequestParam(value="diagnosisstatus",defaultValue = "") String diagnosisstatus){

        sqlSession = factory.openSession(true);

        Map<String,Object> tempParameters = new HashMap<String, Object>();


        if(applino !=null && !("".equals(applino))) {
            int temp = Integer.parseInt(applino);
            tempParameters.put("applino",temp);
        }

        if(patientname !=null && (applino ==null || "".equals(applino))) tempParameters.put("patientname",patientname);

        if(diagnosisstatus !=null) tempParameters.put("diagnosisstatus",diagnosisstatus);
        if(consultationif !=null) tempParameters.put("consultationif",consultationif);


        //此处patientname相当于patientno

        PageHelper.startPage(page,rows);
        List<Pathologydiagnosisinfo> pathologyreviewList = sqlSession.selectList("com.equipments.management.mapper.PathologyreviewMapper.selectDignosisDetail",tempParameters);
        sqlSession.close();

        PagedResult<Pathologydiagnosisinfo> pd = BeanUtil.toPagedResult(pathologyreviewList);

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


    @RequestMapping("/selectDignosisreportDetail")
    @ResponseBody
    public void selectDignosisreportDetail(HttpServletResponse response,
                                @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                @RequestParam(value="patientname",defaultValue = "") String patientname,
                                @RequestParam(value="patientdiagkind",defaultValue = "") String patientdiagkind,
                                @RequestParam(value="applino",defaultValue = "") String applino,
                                @RequestParam(value="reviewstatus",defaultValue = "") String reviewstatus,
                                @RequestParam(value="reviewdate001",defaultValue = "") String reviewdate001,
                                @RequestParam(value="reviewdate002",defaultValue = "") String reviewdate002){

        sqlSession = factory.openSession(true);

        Map<String,Object> tempParameters = new HashMap<String, Object>();

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
        if(!reviewdate001.equals("")){

            try {
                tempParameters.put("reviewdate001",sdf1.parse(reviewdate001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!reviewdate002.equals("")){

            try {
                tempParameters.put("reviewdate002",sdf1.parse(reviewdate002));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(applino !=null && !("".equals(applino))) {
            int temp = Integer.parseInt(applino);
            tempParameters.put("applino",temp);
        }

        if(patientname !=null && (applino ==null || "".equals(applino))) tempParameters.put("patientname",patientname);

        if(patientdiagkind !=null) tempParameters.put("patientdiagkind",patientdiagkind);
        if(reviewstatus !=null) tempParameters.put("reviewstatus",reviewstatus);


        //此处patientname相当于patientno

        PageHelper.startPage(page,rows);
        List<Pathologydiagnosisreport> pathologyreviewList = sqlSession.selectList("com.equipments.management.mapper.PathologyreviewMapper.selectDignosisreportDetail",tempParameters);
        sqlSession.close();

        PagedResult<Pathologydiagnosisreport> pd = BeanUtil.toPagedResult(pathologyreviewList);

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

    @RequestMapping("/selectAllDignosisreportDetail")
    @ResponseBody
    public void selectAllDignosisreportDetail(HttpServletResponse response,
                                   @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                   @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        sqlSession = factory.openSession(true);

        //此处patientname相当于patientno

        PageHelper.startPage(page,rows);
        List<Pathologydiagnosisreport> pathologyreviewList = sqlSession.selectList("com.equipments.management.mapper.PathologyreviewMapper.selectAllDignosisreportDetail");
        sqlSession.close();

        PagedResult<Pathologydiagnosisreport> pd = BeanUtil.toPagedResult(pathologyreviewList);

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

    @RequestMapping("/selectAllDiagnosis")
    @ResponseBody
    public void selectAllDiagnosis(HttpServletResponse response,
                                @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        sqlSession = factory.openSession(true);

        //此处patientname相当于patientno

        PageHelper.startPage(page,rows);
        List<Pathologydiagnosisinfo> pathologyreviewList = sqlSession.selectList("com.equipments.management.mapper.PathologyreviewMapper.selectAllDignosisDetail");
        sqlSession.close();

        PagedResult<Pathologydiagnosisinfo> pd = BeanUtil.toPagedResult(pathologyreviewList);

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
    @RequestMapping("/insertNewRecord")
    public void insertNewRecord(HttpServletResponse response,
                                @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        sqlSession = factory.openSession(true);
        Product product = new Product() ;

        //获得分页信息
        int count = sqlSession.selectOne("com.equipments.management.mapper.ProductMapper.countById");
        int pageNumber = count/rows +1;

        PageHelper.startPage(pageNumber,rows);

        sqlSession.insert("com.equipments.management.mapper.ProductMapper.addProduct",product);
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
    @RequestMapping("/selectDiagnosisdetail")
    @ResponseBody
    public void selectDiagnosisdetail(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam(value = "applino") String applino) {

        sqlSession = factory.openSession(true);

//		Patientinfo patientinfo = new Patientinfo();
//		patientinfo.setPatientno(Integer.valueOf(patient_no));

        DiagnosticDetailVO diagnosticDetailVO = new DiagnosticDetailVO();

        Patientappliquery patientappliquery = new Patientappliquery();
        patientappliquery.setApplino(Integer.valueOf(applino));
        List<Patientappli> newpatientappliList = sqlSession.selectList(
                "com.equipments.management.mapper.PatientappliMapper.getPatientappliByAllAvaliable", patientappliquery);

        Patientappli patientappli2 = newpatientappliList.get(0);
        Patientinfo patientinfo = patientappli2.getPatientinfo();
        diagnosticDetailVO.setName(patientinfo.getPatientname());
        diagnosticDetailVO.setAge(patientinfo.getAge()+"");
        diagnosticDetailVO.setHospitalizetionid(patientinfo.getHospitalizetionid()+"");
        diagnosticDetailVO.setSex(patientinfo.getGender());
        diagnosticDetailVO.setApplino(applino);

//		 List<Product> products = new ArrayList<Product>();
//		for (Patientappli patientappli2 : newpatientappliList) {
        Acceptsample acceptsample = new Acceptsample();
        acceptsample.setApplino(patientappli2);
        List<Acceptsample> acceptsampleList = sqlSession.selectList(
                "com.equipments.management.mapper.AcceptsampleMapper.getAcceptsampleByAll", acceptsample);
        for (Acceptsample acceptsample2 : acceptsampleList) {

            SampleVO sampleVO = new SampleVO();
            sampleVO.setSampleno(acceptsample2.getSampleno()+"");
            sampleVO.setVisualobservation(acceptsample2.getVisualobservation());

            Pathologydiagnosis pathologydiagnosis = new Pathologydiagnosis();
            acceptsample = new Acceptsample();
            acceptsample.setSampleno(acceptsample2.getSampleno());
            pathologydiagnosis.setSampleno(acceptsample);

            List<Pathologydiagnosis> pathologydiagnosis2 = sqlSession.selectList(
                    "com.equipments.management.mapper.PathologydiagnosisMapper.getPathologydiagnosisByAll", pathologydiagnosis);

            if(pathologydiagnosis2.size() > 0){
                sampleVO.setDiagnosismicroscope(pathologydiagnosis2.get(0).getDiagnosismicroscope());
                sampleVO.setDiagnosisspecial(pathologydiagnosis2.get(0).getDiagnosisspecial());
                sampleVO.setDiagnosispathology(pathologydiagnosis2.get(0).getDiagnosispathology());
                sampleVO.setDiagnosisnote(pathologydiagnosis2.get(0).getDiagnosisnote());
                sampleVO.setDiagnosisno(pathologydiagnosis2.get(0).getDiagnosisno()+"");
            }

            Pathologydraw pathologydraw = new Pathologydraw();
            pathologydraw.setSampleno(acceptsample2);
            List<Pathologydraw> pathologydrawList = sqlSession.selectList(
                    "com.equipments.management.mapper.PathologydrawMapper.getPathologydrawByAll", pathologydraw);
            for (Pathologydraw pathologydraw2 : pathologydrawList) {

                PathologydrawVO pathologydrawVO = new PathologydrawVO();
                pathologydrawVO.setDrawno(pathologydraw2.getDrawno()+"");
                pathologydrawVO.setShowDrawNo(patientappli2.getApplino() + "-" + acceptsample2.getSampleno() + "-" + pathologydraw2.getDrawno());

                Productquery productquery = new Productquery();
                productquery.setDrawno(pathologydraw2);
                List<Product> productList = sqlSession.selectList(
                        "com.equipments.management.mapper.ProductMapper.getProductByAllAvaliable", productquery);
                for (Product product : productList) {
                    ProductVO productVO = new ProductVO();
                    productVO.setProductno(product.getProductno()+"");
                    productVO.setShowSampleNo(patientappli2.getApplino() + "-" + acceptsample2.getSampleno());
                    productVO.setShowDrawNo(productVO.getShowSampleNo() + "-" + pathologydraw2.getDrawno());
                    productVO.setShowNo(productVO.getShowDrawNo() + "-" + product.getProductno());
                    productVO.setSampleDesc(acceptsample2.getSampledesc());
                    productVO.setDrawPos(pathologydraw2.getDrawposition());
                    productVO.setResultKind(product.getResultkind());

                    List<Map> docProds = sqlSession.selectList("com.equipments.management.mapper.DocsProductMapper.getDocsProductByProductNo", product.getProductno());
                    for (Map map : docProds) {
                        DocsProductVO docsProductVO = new DocsProductVO();
                        docsProductVO.setDocsproductid(map.get("docsproductid")+"");
                        docsProductVO.setProductno(map.get("productno")+"");
                        docsProductVO.setDocsfilename(map.get("docsfilename")+"");
                        docsProductVO.setSelected(map.get("selected")+"");
                        diagnosticDetailVO.getDocsProductVOs().add(docsProductVO);
                    }

                    pathologydrawVO.getProductVOs().add(productVO);
                }
                sampleVO.getPathologydrawVOs().add(pathologydrawVO);
            }
            diagnosticDetailVO.getSampleVOs().add(sampleVO);
        }
//		}

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(diagnosticDetailVO, SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @RequestMapping("/saveDiagnosis")
    @ResponseBody
    public void saveDiagnosis(HttpServletRequest request, HttpServletResponse response, @RequestBody List<JSONObject> sampleVOs){

        System.out.println(sampleVOs);

        HttpSession session = request.getSession();
        Staff staff = (Staff)session.getAttribute("staff");

        sqlSession = factory.openSession(true);

        for (int i = 0; i < sampleVOs.size(); i++) {
            JSONObject jso = sampleVOs.get(i);
            SampleVO sampleVO = JSONObject.toJavaObject(jso, SampleVO.class);
            Pathologydiagnosis pathologydiagnosis = new Pathologydiagnosis();
            Acceptsample acceptsample = new Acceptsample();
            acceptsample.setSampleno(Integer.valueOf(sampleVO.getSampleno()));
            pathologydiagnosis.setSampleno(acceptsample);
            pathologydiagnosis.setReportdoctorid(staff);
            pathologydiagnosis.setDiagnosismicroscope(sampleVO.getDiagnosismicroscope());
            pathologydiagnosis.setDiagnosisnote(sampleVO.getDiagnosisnote());
            pathologydiagnosis.setDiagnosispathology(sampleVO.getDiagnosispathology());
            pathologydiagnosis.setDiagnosisspecial(sampleVO.getDiagnosisspecial());
            pathologydiagnosis.setReportdate(new Date());
            System.out.println("______sampleVO.getDiagnosisno()"+ sampleVO.getDiagnosisno());
            if(sampleVO.getDiagnosisno().length() == 0){
                System.out.println("_____insert " + pathologydiagnosis);
                sqlSession.insert("com.equipments.management.mapper.PathologydiagnosisMapper.addPathologydiagnosis", pathologydiagnosis);
            }else{
                pathologydiagnosis.setDiagnosisno(Integer.valueOf(sampleVO.getDiagnosisno()));
                sqlSession.update("com.equipments.management.mapper.PathologydiagnosisMapper.updatePathologydiagnosis",pathologydiagnosis);
            }

        }

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString("ssss", SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @RequestMapping("/saveDoctorAdvice")
    @ResponseBody
    public void saveDoctorAdvice(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> map){

        sqlSession = factory.openSession(true);

        String adviceKind1 = "技术医嘱";
        String adviceNum1 = ""+map.get("shuliang");
        String adviceContent1 = ""+map.get("jishuyizhu");
        String adviceNote1 = ""+map.get("beizhu");

        String adviceKind2 = "特检医嘱";
        String adviceContent2 = ""+map.get("tejianyizhu");
        String adviceProgram2 = ""+map.get("jutixiangmu");
        String adviceNote2 = ""+map.get("tejianbeizhu");

        String diagnosisno = ""+map.get("diagnosisno");

        Pathologydiagnosis pathologydiagnosis = new Pathologydiagnosis();
        pathologydiagnosis.setDiagnosisno(Integer.valueOf(diagnosisno));

        Doctoradvice doctoradvice1 = new Doctoradvice();
        doctoradvice1.setDiagnosisno(pathologydiagnosis);
        doctoradvice1.setAdvicekind(adviceKind1);
        doctoradvice1.setAdvicecontent(adviceContent1);
        doctoradvice1.setAdvicenum(Integer.valueOf(adviceNum1));
        doctoradvice1.setAdvicenote(adviceNote1);
        doctoradvice1.setAdviceprogram("");

        sqlSession.insert("com.equipments.management.mapper.DoctoradviceMapper.addDoctoradvice", doctoradvice1);

        Doctoradvice doctoradvice2 = new Doctoradvice();
        doctoradvice2.setDiagnosisno(pathologydiagnosis);
        doctoradvice2.setAdvicekind(adviceKind2);
        doctoradvice2.setAdvicecontent(adviceContent2);
        doctoradvice2.setAdviceprogram(adviceProgram2);
        doctoradvice2.setAdvicenote(adviceNote2);
        doctoradvice2.setAdvicenum(Integer.valueOf(1));

        sqlSession.insert("com.equipments.management.mapper.DoctoradviceMapper.addDoctoradvice", doctoradvice2);

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString("ssss", SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @RequestMapping("/selectAdvice")
    @ResponseBody
    public void selectAdvice(HttpServletResponse response,
                             @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                             @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                             @RequestParam(value="diagnosisno",defaultValue = "") Integer diagnosisno){

        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);
        List<Map> l = sqlSession.selectList("com.equipments.management.mapper.DoctoradviceMapper.getDoctoradviceByDiagnosisnoTable",diagnosisno);

        sqlSession.close();

        PagedResult<Map> pd = BeanUtil.toPagedResult(l);

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

    @RequestMapping("/deleteAdvice")
    @ResponseBody
    public void deleteAdvice(HttpServletResponse response,
                             @RequestParam(value="adviceno",defaultValue ="") Integer adviceno){

        sqlSession = factory.openSession(true);

        Doctoradvice doctoradvice = new Doctoradvice();
        doctoradvice.setAdviceno(adviceno);

        sqlSession.delete("com.equipments.management.mapper.DoctoradviceMapper.removeDoctoradviceById", doctoradvice);
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString("ssss", SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    @RequestMapping("/savePicSel")
    @ResponseBody
    public void savePicSel(HttpServletRequest request, HttpServletResponse response, @RequestBody List<JSONObject> docsProductVOs){

        sqlSession = factory.openSession(true);


        for (int i = 0; i < docsProductVOs.size(); i++) {
            JSONObject jso = docsProductVOs.get(i);
            DocsProductVO doscProductVO = JSONObject.toJavaObject(jso, DocsProductVO.class);

            Map<String, Object> m = new HashMap<String, Object>();

            m.put("docsproductid", doscProductVO.getDocsproductid());
            m.put("selected", doscProductVO.getSelected());

            sqlSession.update("com.equipments.management.mapper.DocsProductMapper.updateDocsProduct", m);

        }

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString("ssss", SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
}
