package com.equipments.management.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.domain.*;
import com.equipments.management.domain.query.Patientappliquery;
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
@RequestMapping("/paologydraw")
public class EqpaologydrawController {
    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqController.class);
    private static SqlSession sqlSession;
    private static SqlSessionFactory factory;

    protected final static String DATE_FORMATE = "yyyy-MM-dd";

    static{
        String resource = "mybatis-conf.xml";
        InputStream is = EqpaologydrawController.class.getClassLoader().getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    public EqpaologydrawController(){
        super();
    }


    @RequestMapping("/selectPaologydraw")
    @ResponseBody
    public void selectPatientappli(HttpServletResponse response,
                          @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                          @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                          @RequestParam(value="sampleno",defaultValue = "") String sampleno){

        sqlSession = factory.openSession(true);
        Pathologydraw pathologydraw = new Pathologydraw();

        PageHelper.startPage(page,rows);
        if(!sampleno.equals("")){
            pathologydraw.setDrawno(Integer.valueOf(sampleno));
        }


        List<Pathologydraw> pathologydrawList = sqlSession.selectList("com.equipments.management.mapper.PathologydrawMapper.getPathologydrawByAll",pathologydraw);
        sqlSession.close();


        PagedResult<Pathologydraw> pd = BeanUtil.toPagedResult(pathologydrawList);
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


    @RequestMapping("/selectPathologydrawbyIds")
    @ResponseBody
    public void selectPathologydrawbyIds(HttpServletResponse response,
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
            List<Pathologydraw> pathologydrawList = sqlSession.selectList("com.equipments.management.mapper.PathologydrawMapper.selectByIds",ids);
            PagedResult<Pathologydraw> pd = BeanUtil.toPagedResult(pathologydrawList);

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


    /**
     * insertDrawPhoto
     * **/
    @RequestMapping("/insertDrawPhoto")
    @ResponseBody
    public Map<String, Object> insertDrawPhoto(HttpServletResponse response,
                                                 @RequestParam("drawno") String drawno,
                                                 @RequestParam("filepath") String filepath,
                                                 @RequestParam("filedesc") String filedesc
    ){

        sqlSession = factory.openSession(true);
        Drawphotodesc drawphotodesc = new Drawphotodesc();

        Map<String, Object> json = new HashMap<String, Object>();

        if(filedesc !=null){
            drawphotodesc.setFiledesc(filedesc);
        }
        if(filepath !=null){
            drawphotodesc.setFilepath(filepath);
        }
        if(drawno !=null){
            drawphotodesc.setDrawno(Integer.valueOf(drawno));
        }

        sqlSession.insert("com.equipments.management.mapper.DrawphotodescMapper.addDrawphotodesc",drawphotodesc);

        response.setContentType("text/html;charset=UTF-8");

        try{
            json.put("success", drawphotodesc);
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }


    /**
     * getTopNPathologydraw
     * **/
    @RequestMapping("/getTopNPathologydraw")
    @ResponseBody
    public Map<String, Object> getTopNPathologydraw(HttpServletResponse response
    ){

        sqlSession = factory.openSession(true);
        Pathologydraw pathologydraw = new Pathologydraw();

        Map<String, Object> json = new HashMap<String, Object>();



        Integer tempResult = sqlSession.selectOne("com.equipments.management.mapper.PathologydrawMapper.getTopNPathologydraw");

        response.setContentType("text/html;charset=UTF-8");

        try{
            json.put("success", tempResult);
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }

    /**
     * insertPathologyDraw
     * **/
    @RequestMapping("/insertPathologyDraw")
    @ResponseBody
    public Map<String, Object> insertPathologyDraw(HttpServletResponse response,
                                                 @RequestParam(value="sampleno",defaultValue ="") String sampleno,
                                                 @RequestParam(value="drawdesc",defaultValue ="") String drawdesc,
                                                 @RequestParam(value="drawposition",defaultValue ="") String drawposition,
                                                   @RequestParam(value="drawdoctorid",defaultValue ="") String drawdoctorid,
                                                   @RequestParam(value="drawkind",defaultValue ="") String drawkind,
                                                   @RequestParam(value="drawdate",defaultValue ="") String drawdate,
                                                   @RequestParam(value="productnum",defaultValue ="0") String productnum
    ){

        sqlSession = factory.openSession(true);
        Pathologydraw pathologydraw = new Pathologydraw();

        Map<String, Object> json = new HashMap<String, Object>();

        /*
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if(!drawdate.equals("")){
            try {
                pathologydraw.setDrawdate(sdf.parse(drawdate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(drawdesc !=null){
            pathologydraw.setDrawdesc(drawdesc);
        }

        if(drawposition !=null){
            pathologydraw.setDrawposition(drawposition);
        }
        if(drawdoctorid !=null && drawdoctorid !=""){
            Staff staff = new Staff();
            staff.setId(Integer.valueOf(drawdoctorid));
            pathologydraw.setDrawdoctorid(staff);
        }
        if(drawkind !=null){
            pathologydraw.setDrawkind(drawkind);
        }
        if(productnum !=null && productnum !=""){
            pathologydraw.setProductnum(Integer.valueOf(productnum));
        }
        */

        if(sampleno !=null && sampleno != ""){
            Acceptsample acceptsample = new Acceptsample();
            acceptsample.setSampleno(Integer.valueOf(sampleno));
            pathologydraw.setSampleno(acceptsample);
        }

        sqlSession.insert("com.equipments.management.mapper.PathologydrawMapper.addPathologydraw",pathologydraw);

        response.setContentType("text/html;charset=UTF-8");

        try{
            json.put("success", pathologydraw);
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
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
