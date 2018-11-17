package com.equipments.management.controller;

//import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.domain.Baomi;
import com.equipments.management.domain.Staff;
import com.equipments.management.domain.Staffextend;
import com.equipments.management.domain.Task;
import com.equipments.management.dto.ExportDoc;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2018/5/2.
 */
@Controller
@RequestMapping("/baomi")
public class EqbaomiController {

    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqbaomiController.class);
    private static SqlSession sqlSession;
    private static String statement;
    private static SqlSessionFactory factory;

    private final static String DATE_FORMATE = "yyyy-MM-dd";

    static{
        String resource = "mybatis-conf.xml";
        //InputStream is = EqController.class.getClassLoader().getResourceAsStream(resource);
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (is == null) {
            throw new IllegalArgumentException(
                    " is not visible from class loader.............................");
        }
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    public EqbaomiController(){
        super();
    }



    public static Logger getLogger() {
        return logger;
    }

    public static SqlSession getSqlSession() {
        return sqlSession;
    }

    public static void setSqlSession(SqlSession sqlSession) {
        EqbaomiController.sqlSession = sqlSession;
    }

    public static String getStatement() {
        return statement;
    }

    public static void setStatement(String statement) {
        EqbaomiController.statement = statement;
    }

    public static SqlSessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SqlSessionFactory factory) {
        EqbaomiController.factory = factory;
    }

    public static String getDateFormate() {
        return DATE_FORMATE;
    }

    @Override
    public String toString() {
        return "EqController{}";
    }


    /*
    * 通过Staff.id获得最新的Task记录以及对应的Baomi记录
    *
    * */
    @RequestMapping(value="/selectBaomiByStaffLimit")
    @ResponseBody
    public void selectBaomiByStaffLimit(HttpServletResponse response,
                                        @RequestParam("staff_id") String staffid){
        sqlSession = factory.openSession(false);

        List<Baomi> baomiList = null;
        List<Staffextend> staffextendList = null;
        Map<String,Object> tempMap = new HashMap<String, Object>();

        if(staffid !=null){
            staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getStaffextendByStaffLimit",Integer.valueOf(staffid));
            logger.info("---------------staffextendList----------------");
            logger.info(staffextendList.get(0).toString());
            if(staffextendList != null && staffextendList.get(0) != null){
                Staffextend queryStaffextend = staffextendList.get(0);
                Task tempTask = queryStaffextend.getTaskid();
                baomiList = sqlSession.selectList("com.equipments.management.mapper.BaomiMapper.getBaomiByTaskLimit",tempTask.getId());

                tempMap.put("Staffextend",queryStaffextend);
                tempMap.put("Baomi",baomiList.get(0));
            }
        }

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(tempMap,SerializerFeature.DisableCircularReferenceDetect));
            //out.println(JSON.toJSONString(staffextendList,SerializerFeature.DisableCircularReferenceDetect));
            //out.println(JSON.toJSONString("TRUE",SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }


    @RequestMapping(value="/updateBaomi")
    @ResponseBody
    public void updateBaomi(
            HttpServletResponse response,
            @RequestParam(name="baomi_id",required=false) String baomiid,
            @RequestParam("staff_id") String staffid,
            @RequestParam("task_id") String taskid,
            @RequestParam(name="baomi_zhiji",required=false) String zhiji,
            @RequestParam(name="baomi_buzhibie",required=false) String buzhibie,
            @RequestParam(name="baomi_jwtlbeg",required=false) String jwtlbeg,
            @RequestParam(name="baomi_jwtlend",required=false) String jwtlend,
            @RequestParam(name="baomi_xddzsblx1",required=false) String xddzsblx1,
            @RequestParam(name="baomi_xddzsbxh1",required=false) String xddzsbxh1,
            @RequestParam(name="baomi_xddzsbsmdj1",required=false) String xddzsbsmdj1,
            @RequestParam(name="baomi_xddzsblx2",required=false) String xddzsblx2,
            @RequestParam(name="baomi_xddzsbxh2",required=false) String xddzsbxh2,
            @RequestParam(name="baomi_xddzsbsmdj2",required=false) String xddzsbsmdj2,
            @RequestParam(name="baomi_xddzsbyf",required=false,defaultValue="0") String xddzsbyf,
            @RequestParam(name="baomi_xdsmzlmc1",required=false) String xdsmzlmc1,
            @RequestParam(name="baomi_xdsmzlfs1",required=false,defaultValue="0") String xdsmzlfs1,
            @RequestParam(name="baomi_xdsmzlsmdj",required=false) String xdsmzlsmdj1,
            @RequestParam(name="baomi_xdsmzlmc2",required=false) String xdsmzlmc2,
            @RequestParam(name="baomi_xdsmzlfs2",required=false,defaultValue="0") String xdsmzlfs2,
            @RequestParam(name="baomi_xdsmzlsmdj2",required=false) String xdsmzlsmdj2,
            @RequestParam(name="baomi_xdsmzlyf",required=false,defaultValue="0") String xdsmzlyf
            ){
        sqlSession = factory.openSession(true);

        logger.info("---------------------------------------");
        logger.info("---------------------------------------");
        logger.info(xdsmzlfs1);
        logger.info("---------------------------------------");
        logger.info("---------------------------------------");

        logger.info("---------------------------------------");
        logger.info("---------------------------------------");
        logger.info(xdsmzlfs2);
        logger.info("---------------------------------------");
        logger.info("---------------------------------------");

        //设置Baomi对象
        List<Baomi> tempQueryBaomi = null;
        Baomi tempBaomi = new Baomi();


        //设置Staff对象
        Staff tempStaff = new Staff();
        Task tempTask = new Task();
        if(taskid !=null){
            tempQueryBaomi = sqlSession.selectList("com.equipments.management.mapper.BaomiMapper.getBaomiByTaskLimit",Integer.valueOf(taskid));
            tempTask.setId(Integer.valueOf(taskid));
            tempBaomi.setTaskid(tempTask);
            if(tempQueryBaomi == null){
                tempStaff.setId(Integer.valueOf(staffid));
                tempBaomi.setStaffid(tempStaff);
                sqlSession.insert("com.equipments.management.mapper.BaomiMapper.addBaomi",tempBaomi);
                sqlSession.commit(true);
                tempQueryBaomi = sqlSession.selectList("com.equipments.management.mapper.BaomiMapper.getBaomiByTaskLimit",Integer.valueOf(taskid));
            }
        }
        else{
            logger.info("-----------------------taskid is null-------------------------");
            return;
        }



        if (baomiid != null) {
            tempBaomi.setId(Integer.valueOf(baomiid));
        } else {
            tempBaomi.setId(tempQueryBaomi.get(0).getId());
        }


        /*
        * 成员变量设置
        * */
            if (zhiji != null) {
                tempBaomi.setZhiji(zhiji);
            }
            if(buzhibie != null){
                tempBaomi.setBuzhibie(buzhibie);
            }
            //携带设备
            if(xddzsblx1 != null){
                tempBaomi.setXddzsblx1(xddzsblx1);
            }
            if(xddzsbxh1 != null){
                tempBaomi.setXddzsbxh1(xddzsbxh1);
            }
            if(xddzsbsmdj1 != null){
                tempBaomi.setXddzsbsmdj1(xddzsbsmdj1);
            }
            if(xddzsblx2 != null){
                tempBaomi.setXddzsblx2(xddzsblx2);
            }
            if(xddzsbxh2 != null){
                tempBaomi.setXddzsbxh2(xddzsbxh2);
            }
            if(xddzsbsmdj2 != null){
                tempBaomi.setXddzsbsmdj2(xddzsbsmdj2);
            }
            if(xddzsbyf != null){
                tempBaomi.setXddzsbyf(Integer.valueOf(xddzsbyf));
            }

            //涉密资料
            if(xdsmzlmc1 != null){
                tempBaomi.setXdsmzlmc1(xdsmzlmc1);
            }
            if(xdsmzlfs1 != null && xdsmzlfs1 != ""){
                tempBaomi.setXdsmzlfs1(Integer.valueOf(xdsmzlfs1));
            }
            if(xdsmzlsmdj1 != null){
                tempBaomi.setXdsmzlsmdj1(xdsmzlsmdj1);
            }
            if(xdsmzlmc2 != null){
                tempBaomi.setXdsmzlmc2(xdsmzlmc2);
            }
            if(xdsmzlfs2 != null && xdsmzlfs2 != ""){
                tempBaomi.setXdsmzlfs2(Integer.valueOf(xdsmzlfs2));
            }
            if(xdsmzlsmdj2 != null){
                tempBaomi.setXdsmzlsmdj2(xdsmzlsmdj2);
            }
            if(xdsmzlyf != null){
                tempBaomi.setXdsmzlyf(Integer.valueOf(xdsmzlyf));
            }


            if (jwtlbeg != null && jwtlbeg != "") {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date tempDate = null;

                try {
                    tempDate = formatter.parse(jwtlbeg);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tempBaomi.setJwtlbeg(tempDate);
            }

            if (jwtlend != null && jwtlend != "") {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date tempDate = null;

                try {
                    tempDate = formatter.parse(jwtlend);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tempBaomi.setJwtlend(tempDate);
            }

        sqlSession.update("com.equipments.management.mapper.BaomiMapper.updateBaomi", tempBaomi);
        Staffextend queryStaffextend = new Staffextend();

        List<Staffextend> staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getStaffextendByStaffLimit",Integer.valueOf(staffid));
        if(staffextendList !=null && staffextendList.get(0) !=null) {
            queryStaffextend = staffextendList.get(0);
        }

        Map<String,Object> tempMap = new HashMap<String, Object>();
        tempMap.put("Baomi",tempBaomi);
        tempMap.put("Staffextend",queryStaffextend);

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(tempMap,SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    /**
     * 生成-保密表
     *
     * */
    @RequestMapping("/outputBaomi")
    @ResponseBody
    public void outputBaomi(HttpServletResponse response,
                          HttpServletRequest request,
                          @RequestParam("staff_id") String staffid
                          ){
        sqlSession = factory.openSession(true);
        Staffextend tempStaffextend = null;
        List<Staffextend> staffextendList = null;
        Task tempTask = new Task();
        List<Baomi> baomiList = null;
        Baomi tempBaomi = new Baomi();
        Staff tempStaff = new Staff();

        if(staffid !=null){
            staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getStaffextendByStaffLimit",Integer.valueOf(staffid));
            if(staffextendList !=null && staffextendList.get(0) !=null){
                tempStaffextend = staffextendList.get(0);
                tempTask = sqlSession.selectOne("com.equipments.management.mapper.TaskMapper.getTaskById",tempStaffextend.getTaskid().getId());
                tempStaff = tempStaffextend.getStaffid();
                baomiList = sqlSession.selectList("com.equipments.management.mapper.BaomiMapper.getBaomiByTaskLimit",tempTask.getId());
                tempBaomi = baomiList.get(0);

                Map<String,Object> tempMap = new HashMap<String, Object>();
                tempMap.put("name",tempStaffextend.getStaffid().getName() + "");
                tempMap.put("zhiji",tempBaomi.getZhiji() + "");
                tempMap.put("buzhibie",tempBaomi.getBuzhibie() + "");
                tempMap.put("tarcountry",tempTask.getTarcountry() + "");
                tempMap.put("tarcity",tempTask.getTarcity() + "");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                tempMap.put("jwtlbeg",sdf.format(tempTask.getCjcfbeg()));
                tempMap.put("jwtlend",sdf.format(tempTask.getCjggend()));

                tempMap.put("xddzsblx1",tempBaomi.getXddzsblx1() + "");
                tempMap.put("xddzsblx2",tempBaomi.getXddzsblx2() + "");
                tempMap.put("xddzsbxh1",tempBaomi.getXddzsbxh1() + "");
                tempMap.put("xddzsbxh2",tempBaomi.getXddzsbxh2() + "");
                tempMap.put("xddzsbsmdj1",tempBaomi.getXddzsbsmdj1() + "");
                tempMap.put("xddzsbsmdj2",tempBaomi.getXddzsbsmdj2() + "");
                tempMap.put("xddzsbyf",tempBaomi.getXddzsbyf() + "");
                tempMap.put("duihao1",tempBaomi.getXddzsbyf() + "");

                tempMap.put("xdsmzlmc1",tempBaomi.getXdsmzlmc1() + "");
                tempMap.put("xdsmzlmc2",tempBaomi.getXdsmzlmc2() + "");
                tempMap.put("xdsmzlfs1",tempBaomi.getXdsmzlfs1() + "");
                tempMap.put("xdsmzlfs2",tempBaomi.getXdsmzlfs2() + "");
                tempMap.put("xdsmzlsmdj1",tempBaomi.getXdsmzlsmdj1() + "");
                tempMap.put("xdsmzlsmdj2",tempBaomi.getXdsmzlsmdj2() + "");
                tempMap.put("xdsmzlyf",tempBaomi.getXdsmzlyf() + "");
                tempMap.put("duihao2",tempBaomi.getXdsmzlyf() + "");

                ExportDoc maker = new ExportDoc("UTF-8");

                try {

                    String url = request.getSession().getServletContext().getRealPath("/outputfiles/") + tempStaffextend.getTaskid().getId().toString()+ "\\";
                    //String url = "F:/output/";

                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                    String tempFileName = "bmzrs-" + staffid + "-" + df.format(new Date()) +".doc";
                    String fileAddress = url + tempFileName;

                    maker.exportDoc(fileAddress,"bmzrs.ftl",tempMap);

                    //保存文件名称到数据记录表
                    tempTask = tempStaffextend.getTaskid();
                    tempTask.setBmzrsaddr(tempFileName);
                    logger.info("----------------------------tempTask------------------------------");
                    logger.info(tempTask.toString());
                    sqlSession.update("com.equipments.management.mapper.TaskMapper.updateTask",tempTask);

                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = null;
                    try{
                        out = response.getWriter();
                        out.println(JSON.toJSONString(tempFileName,SerializerFeature.DisableCircularReferenceDetect));
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            logger.info("-----------------------staffid is null-------------------------");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try{
                out = response.getWriter();
                out.println(JSON.toJSONString("FALSE",SerializerFeature.DisableCircularReferenceDetect));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                out.close();
            }
        }
        sqlSession.close();
    }


    @RequestMapping("/downBaomi")
    @ResponseBody
    public void downBaomi(HttpServletResponse response,
                        HttpServletRequest request,
                        @RequestParam("staff_id") String staffid
    ){
        sqlSession = factory.openSession(true);
        Staffextend tempStaffextend = null;
        List<Staffextend> staffextendList = null;

        //组装数据
        //Staff tempStaff = new Staff();
        if(staffid !=null){
            staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getStaffextendByStaffLimit",Integer.valueOf(staffid));
            if(staffextendList !=null && staffextendList.get(0) !=null){
                tempStaffextend = staffextendList.get(0);

                try {

                    String url = "/outputfiles/" + tempStaffextend.getTaskid().getId().toString()+ "/";
                    //String url = "F:/output/";

                    String tempFileName = tempStaffextend.getTaskid().getBmzrsaddr();
                    String fileAddress = url + tempFileName;

                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = null;
                    try{
                        out = response.getWriter();
                        out.println(JSON.toJSONString(fileAddress,SerializerFeature.DisableCircularReferenceDetect));
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            logger.info("-----------------------staffid is null-------------------------");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try{
                out = response.getWriter();
                out.println(JSON.toJSONString("FALSE",SerializerFeature.DisableCircularReferenceDetect));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                out.close();
            }
        }
        sqlSession.close();
    }


    @RequestMapping("/deleteBaomi")
    @ResponseBody
    public void deleteBaomi(HttpServletResponse response,
                          HttpServletRequest request,
                          @RequestParam("staff_id") String staffid
    ){
        sqlSession = factory.openSession(true);
        Staffextend tempStaffextend = null;
        List<Staffextend> staffextendList = null;

        //组装数据
        //Staff tempStaff = new Staff();
        if(staffid !=null){
            staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getStaffextendByStaffLimit",Integer.valueOf(staffid));
            if(staffextendList !=null && staffextendList.get(0) !=null){
                tempStaffextend = staffextendList.get(0);

                logger.info("---------------------------------");
                logger.info("---------------------------------");
                logger.info("---------------------------------");
                logger.info("---------------------------------");
                logger.info(tempStaffextend.toString());

                try {

                    String url = request.getSession().getServletContext().getRealPath("/outputfiles/") + tempStaffextend.getTaskid().getId().toString()+ "/";
                    //String url = "F:/output/";

                    String tempFileName = tempStaffextend.getTaskid().getBmzrsaddr();
                    String fileAddress = url + tempFileName;

                    File file = new File(fileAddress);

                    if(file.exists() && file.isFile()){
                        file.delete();
                        Task tempTask = tempStaffextend.getTaskid();
                        tempTask.setBmzrsaddr("");

                        logger.info("---------------Task--------------");
                        logger.info("---------------------------------");
                        logger.info("---------------------------------");
                        logger.info("---------------------------------");
                        logger.info(tempTask.toString());
                        sqlSession.update("com.equipments.management.mapper.TaskMapper.updateTask",tempTask);
                    }
                    else
                    {
                        logger.info("---------------Task--------------");
                        logger.info("---------------------------------");
                        logger.info("---------------------------------");
                        logger.info("---------------------------------");
                        logger.info("任务文件不存在！");
                    }

                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = null;
                    try{
                        out = response.getWriter();
                        out.println(JSON.toJSONString(fileAddress,SerializerFeature.DisableCircularReferenceDetect));
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            logger.info("-----------------------staffid is null-------------------------");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try{
                out = response.getWriter();
                out.println(JSON.toJSONString("FALSE",SerializerFeature.DisableCircularReferenceDetect));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                out.close();
            }
        }
        sqlSession.close();
    }
}
