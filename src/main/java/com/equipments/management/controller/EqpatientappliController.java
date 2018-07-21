package com.equipments.management.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.dao.KylinUtil;
import com.equipments.management.domain.*;
import com.equipments.management.domain.gradation.Patientinfo001;
import com.equipments.management.domain.query.Patientappliquery;
import com.equipments.management.util.BeanUtil;
import com.equipments.management.util.POIUtil;
import com.equipments.management.util.PagedResult;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/patientappli")
public class EqpatientappliController {
    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqController.class);
    private static SqlSession sqlSession;
    private static SqlSessionFactory factory;

    protected final static String DATE_FORMATE = "yyyy-MM-dd";

    static{
        String resource = "mybatis-conf.xml";
        InputStream is = EqpatientappliController.class.getClassLoader().getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    public EqpatientappliController(){
        super();
    }


    @RequestMapping("/selectPatientappli")
    @ResponseBody
    public void selectPatientappli(HttpServletResponse response,
                          @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                          @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                          @RequestParam(value="hospitalizetionid",defaultValue = "") String hospitalizetionid,
                          @RequestParam(value="patientdiagkind",defaultValue = "") String patientdiagkind,
                          @RequestParam(value="applino",defaultValue = "") String applino,
                          @RequestParam(value="inspmethod",defaultValue = "") String inspmethod,
                          @RequestParam(value="inspdepartid",defaultValue = "") String inspdepartid1,
                          @RequestParam(value="specialrequire",defaultValue = "") String specialrequire,
                          @RequestParam(value="inspdate001",defaultValue = "") String inspdate001,
                          @RequestParam(value="inspdate002",defaultValue = "") String inspdate002,
                          @RequestParam(value="acceptdate001",defaultValue = "") String acceptdate001,
                          @RequestParam(value="acceptdate002",defaultValue = "") String acceptdate002){

        sqlSession = factory.openSession(true);

        Patientappliquery patientappliquery = new Patientappliquery();

        SimpleDateFormat inspdate001_sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat inspdate002_sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat acceptdate001_sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat acceptdate002_sdf = new SimpleDateFormat("yyyy-MM-dd");

        if(!inspdate001.equals("")){

            try {
                patientappliquery.setInspdate001(inspdate001_sdf.parse(inspdate001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!inspdate002.equals("")){

            try {
                patientappliquery.setInspdate002(inspdate002_sdf.parse(inspdate002));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!acceptdate001.equals("")){

            try {
                patientappliquery.setApplidate001(acceptdate001_sdf.parse(acceptdate001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!acceptdate002.equals("")){

            try {
                patientappliquery.setApplidate002(acceptdate002_sdf.parse(acceptdate002));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        if(!patientdiagkind.equals("")){
            patientappliquery.setPatientdiagkind(patientdiagkind);
            //patientappli.setPatientdiagkind(patientdiagkind);
        }
        if(!specialrequire.equals("")){
            patientappliquery.setSpecialrequire(specialrequire);
            //patientappli.setSpecialrequire(specialrequire);
        }
        if(!applino.equals("")){
            patientappliquery.setApplino(Integer.valueOf(applino));
            //patientappli.setApplino(Integer.valueOf(applino));
        }
        if(!hospitalizetionid.equals("")){
            Patientinfo patientinfo = sqlSession.selectOne("com.equipments.management.mapper.PatientinfoMapper.getPatientinfoByHospitalizetionid",Integer.valueOf(hospitalizetionid));
            if(patientinfo != null){
                patientappliquery.setPatientinfo(patientinfo);
            }
        }
        if(!inspdepartid1.equals("")){
            Department inspdepartid = sqlSession.selectOne("com.equipments.management.mapper.DepartmentMapper.getDepartmentById",Integer.valueOf(inspdepartid1));
            if(inspdepartid != null){
                patientappliquery.setInspdepartid(inspdepartid);
            }
        }
        /*
        if(!inspmethod.equals("")){
            Inspmethod tempInspmethod = sqlSession.selectOne("com.equipments.management.mapper.InspmethodMapper.getInspmethodById",Integer.valueOf(inspmethod));
            if(tempInspmethod != null){
                patientappliquery.setInspdepartid(department);
            }
            if(!item.getInspmethodList().toString().contains(inspmethod)){
                //continue;
                newpatientappliList.remove(item);
            }
        }
        */

        PageHelper.startPage(page,rows);
        List<Patientappli> newpatientappliList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.getPatientappliByAllAvaliable",patientappliquery);
        //List<Patientappli> patientappliList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.getPatientappliByAll",patientappli);
        sqlSession.close();


        PagedResult<Patientappli> pd = BeanUtil.toPagedResult(newpatientappliList);
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

    @RequestMapping("/getPatientinfoByAllAvaliable")
    @ResponseBody
    public void getPatientinfoByAllAvaliable(HttpServletResponse response,
                                   @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                   @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                   @RequestParam(value="hospitalizetionid",defaultValue = "") String hospitalizetionid,
                                   @RequestParam(value="patientdiagkind",defaultValue = "") String patientdiagkind,
                                   @RequestParam(value="applino",defaultValue = "") String applino,
                                   @RequestParam(value="inspmethod",defaultValue = "") String dicinspmethodname,
                                   @RequestParam(value="inspdepartid",defaultValue = "") String inspdepartid1,
                                   @RequestParam(value="specialrequire",defaultValue = "") String specialrequire,
                                   @RequestParam(value="inspdate001",defaultValue = "") String inspdate001,
                                   @RequestParam(value="inspdate002",defaultValue = "") String inspdate002,
                                   @RequestParam(value="acceptdate001",defaultValue = "") String acceptdate001,
                                   @RequestParam(value="acceptdate002",defaultValue = "") String acceptdate002){

        sqlSession = factory.openSession(true);


        HashMap<String,Object> map = new HashMap<String, Object>();
        SimpleDateFormat inspdate001_sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat inspdate002_sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat acceptdate001_sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat acceptdate002_sdf = new SimpleDateFormat("yyyy-MM-dd");

        if(!inspdate001.equals("")){
            try {
                map.put("inspdate001",inspdate001_sdf.parse(inspdate001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!inspdate002.equals("")){

            try {
                map.put("inspdate002",inspdate002_sdf.parse(inspdate002));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!acceptdate001.equals("")){
            try {
                map.put("acceptdate001",acceptdate001_sdf.parse(acceptdate001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!acceptdate002.equals("")){
            try {
                map.put("acceptdate002",acceptdate002_sdf.parse(acceptdate002));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(!patientdiagkind.equals("")){
            map.put("patientdiagkind",patientdiagkind);
        }

        if(!specialrequire.equals("")){
            map.put("specialrequire",specialrequire);
        }
        if(!applino.equals("")){
            map.put("applino",Integer.valueOf(applino));
        }
        if(!hospitalizetionid.equals("")){
            map.put("hospitalizetionid",Integer.valueOf(hospitalizetionid));
        }
        if(!inspdepartid1.equals("")){
            map.put("deptname",Integer.valueOf(inspdepartid1));
        }
        if(!dicinspmethodname.equals("")){
            map.put("dicinspmethodname",dicinspmethodname);
        }

        PageHelper.startPage(page,rows);
        List<Patientinfo001> patientinfo001List = sqlSession.selectList("com.equipments.management.mapper.PatientinfoMapper.getPatientinfoByAllAvaliable",map);
        sqlSession.close();


        PagedResult<Patientinfo001> pd = BeanUtil.toPagedResult(patientinfo001List);
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

    @RequestMapping("/updatePatientappliByIds")
    public void updatePatientinfoByIds(HttpServletResponse response,
                                       @RequestParam("rowLists") String rowLists,
                                       @RequestParam("lengthRecords") Integer len,
                                       @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                       @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        JSONArray jsonArray = JSONArray.parseArray(rowLists);

        sqlSession = factory.openSession(true);

        int count = sqlSession.selectOne("com.equipments.management.mapper.PatientappliMapper.countById");
        int pageNumber = count/rows +1;
        PageHelper.startPage(pageNumber,rows);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for(int i = 0;i < len;i++){
            Patientappli patientappli = new Patientappli();
            com.alibaba.fastjson.JSONObject jUser = jsonArray.getJSONObject(i);

            patientappli.setApplino(jUser.getInteger("applino"));
            Patientinfo patientinfo = new Patientinfo();
            patientinfo.setPatientno(jUser.getInteger("patientinfo"));
            patientappli.setPatientinfo(patientinfo);
            patientappli.setInspunitname(jUser.getString("inspunitname"));
            Department inspdepartid = new Department();
            inspdepartid.setNo(jUser.getInteger("inspdepartid"));
            patientappli.setInspdepartid(inspdepartid);
            Staff inspdoctid = new Staff();
            inspdoctid.setId(jUser.getInteger("inspdoctid"));
            patientappli.setInspdoctid(inspdoctid);
            Staff applidoctorid = new Staff();
            applidoctorid.setId(jUser.getInteger("applidoctorid"));
            patientappli.setInspdoctid(applidoctorid);
            patientappli.setPatientkind(jUser.getString("patientkind"));
            patientappli.setChargekind(jUser.getString("chargekind"));
            patientappli.setChargenum(jUser.getFloat("chargenum"));
            patientappli.setSpecimentkind(jUser.getString("specimentkind"));
            patientappli.setPatientkind(jUser.getString("patientdiagkind"));
            patientappli.setDiagnosisrecord(jUser.getString("diagnosisrecord"));
            patientappli.setApplisymptom(jUser.getString("applisymptom"));

            patientappli.setApplisigns(jUser.getString("applisigns"));
            patientappli.setOtherdiagnosis(jUser.getString("otherdiagnosis"));
            patientappli.setPathologyexamif(jUser.getString("pathologyexamif"));

            patientappli.setCancerfoundplace(jUser.getString("cancerfoundplace"));
            patientappli.setCancerfoundsize(jUser.getString("cancerfoundsize"));
            patientappli.setTransferif(jUser.getString("transferif"));
            patientappli.setTransferplace(jUser.getString("transferplace"));
            patientappli.setChemotherapyif(jUser.getString("chemotherapyif"));
            patientappli.setCancernowsize(jUser.getString("cancernowsize"));
            patientappli.setMenstrualcycle(jUser.getInteger("menstrualcycle"));
            patientappli.setMenstrualduration(jUser.getInteger("menstrualduration"));
            patientappli.setCycletreatmentif(jUser.getString("cycletreatmentif"));
            patientappli.setCycletreatmenttime(jUser.getInteger("cycletreatmenttime"));
            patientappli.setCycletreatmentdose(jUser.getInteger("cycletreatmentdose"));
            patientappli.setBirthnum(jUser.getInteger("birthnum"));
            patientappli.setProductnum(jUser.getInteger("productnum"));
            patientappli.setContraceptionif(jUser.getString("contraceptionif"));
            patientappli.setContraceptionmethod(jUser.getString("contraceptionmethod"));
            patientappli.setIodinetreatmentif(jUser.getString("iodinetreatmentif"));

            patientappli.setThiouraciltreatmentif(jUser.getString("thiouraciltreatmentif"));
            patientappli.setLabresult(jUser.getString("labresult"));
            patientappli.setSurgeryseen(jUser.getString("surgeryseen"));
            patientappli.setSpecialrequire(jUser.getString("specialrequire"));

            String applidate = jUser.getString("applidate");
            if(applidate!=null){
                Date tempDate = null;
                try {
                    tempDate = formatter.parse(applidate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                patientappli.setApplidate(tempDate);
            }
            String inspdate = jUser.getString("inspdate");
            if(applidate!=null){
                Date tempDate = null;
                try {
                    tempDate = formatter.parse(inspdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                patientappli.setInspdate(tempDate);
            }
            String cancerfounddate = jUser.getString("cancerfounddate");
            if(applidate!=null){
                Date tempDate = null;
                try {
                    tempDate = formatter.parse(cancerfounddate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                patientappli.setCancerfounddate(tempDate);
            }
            String cancernowdate = jUser.getString("cancernowdate");
            if(applidate!=null){
                Date tempDate = null;
                try {
                    tempDate = formatter.parse(cancernowdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                patientappli.setCancernowdate(tempDate);
            }
            String lastmenstrualdate = jUser.getString("lastmenstrualdate");
            if(applidate!=null){
                Date tempDate = null;
                try {
                    tempDate = formatter.parse(lastmenstrualdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                patientappli.setLastmenstrualdate(tempDate);
            }

            //jUser.getString("");
            sqlSession.update("com.equipments.management.mapper.PatientappliMapper.updatePatientappli",patientappli);
        }
        List<Patientinfo> patientinfoList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.getAllPatientapplis");
        sqlSession.close();
        PagedResult<Patientinfo> pd = BeanUtil.toPagedResult(patientinfoList);

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
    //删除Patientappli记录
    @RequestMapping("/delPatientappliById")
    public void delPatientinfoById(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value="ids") Integer[] ids){
        sqlSession = factory.openSession(true);

        response.reset();
        response.setContentType("text/html;charset=UTF-8");
        //业务逻辑操作查询用户
        for(int i = 0;i<ids.length;i++){
            try {
                sqlSession.delete("com.equipments.management.mapper.PatientinfoMapper.removePatientappliById",ids[i]);
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
        Patientappli patientappli = new Patientappli() ;

        //获得分页信息
        int count = sqlSession.selectOne("com.equipments.management.mapper.PatientappliMapper.countById");
        int pageNumber = count/rows +1;

        PageHelper.startPage(pageNumber,rows);

        sqlSession.insert("com.equipments.management.mapper.PatientappliMapper.addPatientappli",patientappli);
        List<Patientappli> patientappliList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.getAllPatientapplis");
        sqlSession.close();


        PagedResult<Patientappli> pd = BeanUtil.toPagedResult(patientappliList);

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


    /**取材及组织处理
     姓名，年龄，病理号，申请单类型，检查方法，特殊要求，送检标本数，状态

     */
    @RequestMapping("/selectPatientInfoDetail")
    @ResponseBody
    public void selectPatientInfoDetail(HttpServletResponse response,
                                   @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                   @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                   @RequestParam(value="patientname",defaultValue = "") String patientname,
                                   @RequestParam(value="applino",defaultValue = "") String applino,
                                   @RequestParam(value="inspmethod",defaultValue = "") String inspmethod,
                                   @RequestParam(value="advicestatus",defaultValue = "") String advicestatus,
                                   @RequestParam(value="specialrequire",defaultValue = "") String specialrequire){

        sqlSession = factory.openSession(true);
        Patientappliresultdetail patientappliresultdetail = new Patientappliresultdetail();
        //HashedMap mapParameter = new HashedMap();
        Patientinfo patientinfo = new Patientinfo();
        patientappliresultdetail.setPatientinfo(patientinfo);
        //patientname
        if(!patientname.equals("")){
            patientappliresultdetail.getPatientinfo().setPatientname(patientname);
        }
        //applino
        if(!applino.equals("")){
            patientappliresultdetail.setApplino(Integer.valueOf(applino));
        }
        //inspmethod

        //advicestatus
        if(!advicestatus.equals("")){
            patientappliresultdetail.setAdvicestatus(advicestatus);
        }
        //specialrequire
        if(!specialrequire.equals("")){
            patientappliresultdetail.setSpecialrequire(specialrequire);
        }


        PageHelper.startPage(page,rows);
        List<Patientappliresultdetail> newpatientappliList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.selectPatientInfoDetail",patientappliresultdetail);
        sqlSession.close();

        logger.info("--------------------------------------------------");
        logger.info(newpatientappliList.toString());
        PagedResult<Patientappliresultdetail> pd = BeanUtil.toPagedResult(newpatientappliList);
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

    //getPatientappliByAllAvaliableSeveralConditions
    /**取材及组织处理
     姓名，年龄，病理号，申请单类型，检查方法，特殊要求，送检标本数，状态

     */
    @RequestMapping("/getPatientappliByAllAvaliableSeveralConditions")
    @ResponseBody
    public void getPatientappliByAllAvaliableSeveralConditions(HttpServletResponse response,
                                        @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                        @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                        @RequestParam(value="patientname",defaultValue = "") String patientname,
                                        @RequestParam(value="applino",defaultValue = "") String applino,
                                        @RequestParam(value="inspmethod",defaultValue = "") String inspmethod,
                                        @RequestParam(value="advicestatus",defaultValue = "") String advicestatus,
                                        @RequestParam(value="specialrequire",defaultValue = "") String specialrequire){

        sqlSession = factory.openSession(true);

        Patientappliquery patientappliquery = new Patientappliquery();

        //patientname
        if(!patientname.equals("")){
            patientappliquery.getPatientinfo().setPatientname(patientname);
        }
        //applino
        if(!applino.equals("")){
            patientappliquery.setApplino(Integer.valueOf(applino));
        }
        //inspmethod

        //advicestatus
        if(!advicestatus.equals("")){
            patientappliquery.setAdvicestatus(advicestatus);
        }
        //specialrequire
        if(!specialrequire.equals("")){
            patientappliquery.setSpecialrequire(specialrequire);
        }


        PageHelper.startPage(page,rows);
        List<Patientappli> newpatientappliList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.getPatientappliByAllAvaliable",patientappliquery);
        sqlSession.close();


        PagedResult<Patientappli> pd = BeanUtil.toPagedResult(newpatientappliList);
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
    @RequestMapping("/updatePatientappliByAllAvaliableSeveralConditions")
    @ResponseBody
    public Map<String,Object> updatePatientappliByAllAvaliableSeveralConditions(HttpServletResponse response,
                                                               @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                                               @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                                               @RequestParam(value="acceptresult",defaultValue = "") String acceptresult,
                                                               @RequestParam(value="applino",defaultValue = "") String applino){

        sqlSession = factory.openSession(true);

        HashMap<String,Object> map = new HashMap<String,Object>();

        Patientappli patientappli = new Patientappli();

        //applino
        if(!applino.equals("")){
            patientappli.setApplino(Integer.valueOf(applino));
        }
        if(!acceptresult.equals("")){
            patientappli.setAcceptresult(acceptresult);
        }
        try{
            Integer tempReturn = sqlSession.update("com.equipments.management.mapper.PatientappliMapper.updatePatientappli",patientappli);
            sqlSession.close();
            map.put("success",tempReturn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /*
    * 001新申请病例
    *
    *
    *
    * */
    @RequestMapping("/getPatientappliByAcceptstatus001")
    public void getPatientappliByAcceptstatus001(HttpServletResponse response,
                                                                  @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                                                  @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                                                  @RequestParam(value="acceptresult",defaultValue = "等待签收") String acceptresult){

        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);
        List<Patientappli> newpatientappliList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.selectPatientappliValuesbyAcceptresult",acceptresult);
        sqlSession.close();


        PagedResult<Patientappli> pd = BeanUtil.toPagedResult(newpatientappliList);
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
    /*
    * 002冰冻申请
    *
    *
    *
    * */
    @RequestMapping("/getPatientappliByAcceptstatus002")
    public void getPatientappliByAcceptstatus002(HttpServletResponse response,
                                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                                 @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                                 @RequestParam(value="patientdiagkind",defaultValue = "快速冰冻") String patientdiagkind,
                                                 @RequestParam(value="acceptresult",defaultValue = "等待签收") String acceptresult){

        sqlSession = factory.openSession(true);

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("acceptresult",acceptresult);
        map.put("patientdiagkind",patientdiagkind);

        PageHelper.startPage(page,rows);
        List<Patientappli> newpatientappliList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.selectPatientappliValuesbyTwo",map);
        sqlSession.close();


        PagedResult<Patientappli> pd = BeanUtil.toPagedResult(newpatientappliList);
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
    /*
        * 003冰冻申请
        *
        *
        *
        * */
    @RequestMapping("/getPatientappliByAcceptstatus003")
    public void getPatientappliByAcceptstatus003(HttpServletResponse response,
                                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                                 @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                                 @RequestParam(value="patientdiagkind",defaultValue = "病理会诊") String patientdiagkind){

        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);
        List<Patientappli> newpatientappliList = sqlSession.selectList("com.equipments.management.mapper.PatientappliMapper.selectPatientappliValuesbyPatientdiagkind",patientdiagkind);
        sqlSession.close();


        PagedResult<Patientappli> pd = BeanUtil.toPagedResult(newpatientappliList);
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

    /*
        * 004未写报告
        *
        *
        *
        * */
    @RequestMapping("/getPatientappliByAcceptstatus004")
    public void getPatientappliByAcceptstatus004(HttpServletResponse response,
                                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                                 @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                                 @RequestParam(value="diagnosisstatus",defaultValue = "已保存") String diagnosisstatus){

        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);
        List<Map> l = sqlSession.selectList("com.equipments.management.mapper.ProductMapper.getMapResultByDiagnosis",diagnosisstatus);

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

    /*
    * 005未审核报告
    *
    *
    *
    * */
    @RequestMapping("/getPatientappliByAcceptstatus005")
    public void getPatientappliByAcceptstatus005(HttpServletResponse response,
                                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                                 @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                                 @RequestParam(value="diagnosisstatus",defaultValue = "待审核") String diagnosisstatus){

        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);
        List<Map> l = sqlSession.selectList("com.equipments.management.mapper.ProductMapper.getMapResultByDiagnosis",diagnosisstatus);

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

    /*
    * 006未打印报告
    *
    *
    *
    * */
    @RequestMapping("/getPatientappliByAcceptstatus006")
    public void getPatientappliByAcceptstatus006(HttpServletResponse response,
                                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                                 @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                                 @RequestParam(value="reviewstatus",defaultValue = "未打印") String reviewstatus){

        sqlSession = factory.openSession(true);

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("reviewstatus",reviewstatus);
        PageHelper.startPage(page,rows);
        List<Map> l = sqlSession.selectList("com.equipments.management.mapper.ProductMapper.getMapResultByDiagnosis123",map);
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

    @RequestMapping("/updatePatientappliByAllAvaliableSeveralConditions001")
    @ResponseBody
    public void updatePatientappliByAllAvaliableSeveralConditions001(HttpServletResponse response,
                                                                  @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                                                  @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                                                  @RequestParam(value="acceptresult",defaultValue = "") String acceptresult,
                                                                  @RequestParam(value="applino",defaultValue = "") String applino){

        sqlSession = factory.openSession(true);

        Patientappli patientappli = new Patientappli();

        //applino
        if(!applino.equals("")){
            patientappli.setApplino(Integer.valueOf(applino));
        }
        if(!acceptresult.equals("")){
            patientappli.setAcceptresult(acceptresult);
        }
        try{
            sqlSession.update("com.equipments.management.mapper.PatientappliMapper.updatePatientappli",patientappli);
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    * selectCount001
    * 申请待处理
    * */
    @RequestMapping("/selectCount001")
    @ResponseBody
    public Map<String,Object> selectCount001(HttpServletResponse response,
                                                                     @RequestParam(value="acceptresult",defaultValue = "等待签收") String acceptresult){

        sqlSession = factory.openSession(true);

        Map<String,Object> map = new HashMap<String,Object>();
        //applino
        if(!acceptresult.equals("")){
            map.put("acceptresult",acceptresult);
        }

        try{
            Integer count = sqlSession.selectOne("com.equipments.management.mapper.SystemMapper.getSysMsgCountinPatientappli001",map);
            map.put("count",count);
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /*
    * selectCount002
    * 冰冻待处理
    * */
    @RequestMapping("/selectCount002")
    @ResponseBody
    public Map<String,Object> selectCount002(HttpServletResponse response,
                                             @RequestParam(value="acceptresult",defaultValue = "等待签收") String acceptresult,
                                             @RequestParam(value="patientdiagkind",defaultValue = "快速冰冻") String patientdiagkind){

        sqlSession = factory.openSession(true);

        Map<String,Object> map = new HashMap<String,Object>();
        //applino
        if(!acceptresult.equals("")){
            map.put("acceptresult",acceptresult);
        }
        if(!patientdiagkind.equals("")){
            map.put("patientdiagkind",patientdiagkind);
        }

        try{
            Integer count = sqlSession.selectOne("com.equipments.management.mapper.SystemMapper.getSysMsgCountinPatientappli",map);
            map.put("count",count);
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /*
    * selectCount003
    * 会诊申请
    * */
    @RequestMapping("/selectCount003")
    @ResponseBody
    public Map<String,Object> selectCount003(HttpServletResponse response,
                                             @RequestParam(value="acceptresult",defaultValue = "等待签收") String acceptresult,
                                             @RequestParam(value="patientdiagkind",defaultValue = "病理会诊") String patientdiagkind){

        sqlSession = factory.openSession(true);

        Map<String,Object> map = new HashMap<String,Object>();
        //applino
        if(!acceptresult.equals("")){
            map.put("acceptresult",acceptresult);
        }
        if(!patientdiagkind.equals("")){
            map.put("patientdiagkind",patientdiagkind);
        }

        try{
            Integer count = sqlSession.selectOne("com.equipments.management.mapper.SystemMapper.getSysMsgCountinPatientappli",map);
            map.put("count",count);
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    /*
    * selectCount004
    * 未完成报告
    * */
    @RequestMapping("/selectCount004")
    @ResponseBody
    public Map<String,Object> selectCount004(HttpServletResponse response,
                                             @RequestParam(value="diagnosisstatus",defaultValue = "已保存") String diagnosisstatus){

        sqlSession = factory.openSession(true);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("diagnosisstatus",diagnosisstatus);

        try{
            Integer count = sqlSession.selectOne("com.equipments.management.mapper.SystemMapper.getSysMsgCountinPathologyreview001",map);
            map.put("count",count);
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /*
    * selectCount005
    * 未完成报告
    * */
    @RequestMapping("/selectCount005")
    @ResponseBody
    public Map<String,Object> selectCount005(HttpServletResponse response,
                                             @RequestParam(value="diagnosisstatus",defaultValue = "待审核") String diagnosisstatus){

        sqlSession = factory.openSession(true);

        Map<String,Object> map = new HashMap<String,Object>();
        //applino
        if(!diagnosisstatus.equals("")){
            map.put("diagnosisstatus",diagnosisstatus);
        }

        try{
            Integer count = sqlSession.selectOne("com.equipments.management.mapper.SystemMapper.getSysMsgCountinPathologyreview001",map);
            map.put("count",count);
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    /*
    * selectCount006
    * 未完成报告
    * */
    @RequestMapping("/selectCount006")
    @ResponseBody
    public Map<String,Object> selectCount006(HttpServletResponse response,
                                             @RequestParam(value="reviewstatus",defaultValue = "未打印") String reviewstatus){

        sqlSession = factory.openSession(true);

        Map<String,Object> map = new HashMap<String,Object>();
        //applino
        if(!reviewstatus.equals("")){
            map.put("reviewstatus",reviewstatus);
        }

        try{
            Integer count = sqlSession.selectOne("com.equipments.management.mapper.SystemMapper.getSysMsgCountinPathologyreview",map);
            map.put("count",count);
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
