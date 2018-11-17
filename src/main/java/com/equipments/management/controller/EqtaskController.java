package com.equipments.management.controller;

//import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.domain.*;
import com.equipments.management.dto.ExportDoc;
import com.equipments.management.util.BeanUtil;
import com.equipments.management.util.PagedResult;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/task")
public class EqtaskController {

    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqtaskController.class);
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

    public EqtaskController(){
        super();
    }



    public static Logger getLogger() {
        return logger;
    }

    public static SqlSession getSqlSession() {
        return sqlSession;
    }

    public static void setSqlSession(SqlSession sqlSession) {
        EqtaskController.sqlSession = sqlSession;
    }

    public static String getStatement() {
        return statement;
    }

    public static void setStatement(String statement) {
        EqtaskController.statement = statement;
    }

    public static SqlSessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SqlSessionFactory factory) {
        EqtaskController.factory = factory;
    }

    public static String getDateFormate() {
        return DATE_FORMATE;
    }

    @Override
    public String toString() {
        return "EqController{}";
    }


    @RequestMapping("/selectTaskByAll")
    @ResponseBody
    public void selectTaskByAll(HttpServletResponse response,
                              HttpServletRequest request,
                              //@RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                              //@RequestParam(value="pageSize",defaultValue = "500") Integer rows,
                                @RequestParam(value="task_name_query",required=false) String name,
                                @RequestParam(value="task_tarcountry_query",required=false) String tarcountry,
                                @RequestParam(value="task_tarcity_query",required=false) String tarcity,
                                @RequestParam(value="task_cjcfbeg_query",required=false,defaultValue = "") String cjcfbeg,
                                @RequestParam(value="task_cjggend_query",required=false,defaultValue = "") String cjggend
    ){
        sqlSession = factory.openSession(false);

        Task tempTask = new Task();
        if(name != "" && name !=null){
            tempTask.setName(name);
        }
        if(tarcity != "" && tarcity != null){
            tempTask.setTarcity(tarcity);
        }
        if(tarcountry != "" && tarcountry != null){
            tempTask.setTarcountry(tarcountry);
        }

        //设置日期格式
        SimpleDateFormat datetimeParse=new SimpleDateFormat("yyyy-MM-dd");
        if(!cjcfbeg.equals("")){
            try {
                tempTask.setCjcfbeg(datetimeParse.parse(cjcfbeg));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!cjggend.equals("")){
            try {
                tempTask.setCjggend(datetimeParse.parse(cjggend));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //PageHelper.startPage(page,rows);
        List<Task> taskList = sqlSession.selectList("com.equipments.management.mapper.TaskMapper.getTaskByAll",tempTask);
        sqlSession.close();

        //PagedResult<Task> pd = BeanUtil.toPagedResult(taskList);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(taskList,SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @RequestMapping("/selectAllTask")
    @ResponseBody
    public void selectAllTask(HttpServletResponse response,
                              HttpServletRequest request
                              //@RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                              //@RequestParam(value="pageSize",defaultValue = "500") Integer rows
    ){
        sqlSession = factory.openSession(false);

        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info(request.getServletPath());
        logger.info(this.getClass().getClassLoader().getResource("/").getPath());
        logger.info(this.getClass().getResource("").getPath());
        logger.info(this.getClass().getClassLoader().getResource(".").getPath());
        logger.info(request.getServletPath());
        logger.info(request.getRequestURI());
        logger.info(request.getSession().getServletContext().getRealPath("/pdf/web"));
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");
        logger.info("----------------------------------------------------------");

        //PageHelper.startPage(page,rows);
        List<Task> taskList = sqlSession.selectList("com.equipments.management.mapper.TaskMapper.getAllTask");
        sqlSession.close();

        //PagedResult<Task> pd = BeanUtil.toPagedResult(taskList);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(taskList,SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @RequestMapping(value="/insertTask")
    @ResponseBody
    public void insertTask(
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(name="task_name",required=false) String taskname,
            @RequestParam(name="task_tarcountry",required=false) String tasktarcountry,
            @RequestParam(name="task_tarcity",required=false) String tasktarcity,
            @RequestParam(name="task_jiaoliutimu",required=false) String taskjiaoliutimu,
            @RequestParam(name="task_type",required=false) String tasktype,
            @RequestParam(name="task_cjcfbeg001",required=false) String taskcjcfbeg001,
            @RequestParam(name="task_cjggend001",required=false) String taskcjggend001,
            @RequestParam(name="task_lijingshijian001",required=false) String tasklijingshijian001,
            @RequestParam(name="task_rujingshijian001",required=false) String taskrujingshijian001,
            @RequestParam(name="task_significance",required=false) String tasksignificance,
            @RequestParam(name="task_temp",required=false) String tasktemp,
            @RequestParam("staff_id") String staffid
            ){
        sqlSession = factory.openSession(true);

        Task task = new Task();
        task.setName(taskname);
        task.setTarcountry(tasktarcountry);
        task.setTarcity(tasktarcity);
        task.setType(tasktype);
        task.setJiaoliutimu(taskjiaoliutimu);
        task.setSignificance(tasksignificance);
        task.setBeizhu(tasktemp);
        task.setZhuangtai("待初审");//新创建任务初始状态均为

        //设置日期格式
        SimpleDateFormat datetimeParse=new SimpleDateFormat("yyyy-MM-dd");
        if(!taskcjcfbeg001.equals("")){
            try {
                task.setCjcfbeg(datetimeParse.parse(taskcjcfbeg001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!taskcjggend001.equals("")){
            try {
                task.setCjggend(datetimeParse.parse(taskcjggend001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!tasklijingshijian001.equals("")){
            try {
                task.setLijingshijian(datetimeParse.parse(tasklijingshijian001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!taskrujingshijian001.equals("")){
            try {
                task.setRujingshijian(datetimeParse.parse(taskrujingshijian001));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        sqlSession.insert("com.equipments.management.mapper.TaskMapper.addTask",task);
        sqlSession.commit(true);
        List<Task> taskList = sqlSession.selectList("com.equipments.management.mapper.TaskMapper.getAllTaskLimit");

        List<Staffextend> staffextendList = null;

        sqlSession.insert("com.equipments.management.mapper.StaffextendMapper.addStaffextendCopyFromLastRecord",Integer.valueOf(staffid));
        sqlSession.commit(true);
        staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getAllStaffextendLimit",Integer.valueOf(staffid));

        Staffextend tempStaffextend = null;
        if(staffextendList !=null && taskList !=null){
            if(staffextendList.get(0) !=null && taskList.get(0) !=null){
                tempStaffextend = staffextendList.get(0);
                tempStaffextend.getTaskid().setId(taskList.get(0).getId());
                sqlSession.update("com.equipments.management.mapper.StaffextendMapper.updateStaffextend",tempStaffextend);


                //创建Baomi
                Baomi tempBaomi = new Baomi();
                tempBaomi.setTaskid(new Task());
                tempBaomi.getTaskid().setId(taskList.get(0).getId());
                tempBaomi.setStaffid(new Staff());
                tempBaomi.getStaffid().setId(Integer.valueOf(staffid));
                sqlSession.insert("com.equipments.management.mapper.BaomiMapper.addBaomi",tempBaomi);

                //创建文件夹
                String url = request.getSession().getServletContext().getRealPath("/outputfiles/");
                String dirFullName = url + taskList.get(0).getId().toString();
                File file = new File(dirFullName);
                if(!file.exists()){
                    file.mkdir();
                }
            }
        }

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(tempStaffextend,SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }


    @RequestMapping(value="/updateTask")
    public void updateTask(
            @RequestParam("task_name") String taskname,
            @RequestParam("task_tarcountry") String tasktarcountry,
            @RequestParam("task_tarcity") String tasktarcity,
            @RequestParam("task_jiaoliutimu") String taskjiaoliutimu,
            @RequestParam("task_type") String tasktype,
            @RequestParam("task_cjcfbeg001") String taskcjcfbeg001,
            @RequestParam("task_cjggend001") String taskcjggend001,
            @RequestParam("task_lijingshijian001") String tasklijingshijian001,
            @RequestParam("task_rujingshijian001") String taskrujingshijian001,
            @RequestParam("task_significance") String tasksignificance,
            @RequestParam("task_temp") String tasktemp){
        sqlSession = factory.openSession(true);

        Task task = new Task();
        task.setName(taskname);
        task.setTarcountry(tasktarcountry);
        task.setTarcity(tasktarcity);
        task.setType(tasktype);
        task.setJiaoliutimu(taskjiaoliutimu);
        task.setSignificance(tasksignificance);

        sqlSession.update("com.equipments.management.mapper.TaskMapper.updateTask",task);
        sqlSession.close();
    }
    @RequestMapping(value="/deleteTask")
    @ResponseBody
    public void deleteTask(
            HttpServletResponse response,
            HttpServletRequest request,
            @RequestParam(value="ids") Integer[] ids){
        sqlSession = factory.openSession(true);

        for(int i = 0;i<ids.length;i++){
           sqlSession.delete("com.equipments.management.mapper.TaskMapper.removeTaskById",ids[i]);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(ids,SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }

        sqlSession.close();
    }


    @RequestMapping(value="/test")
    public void insertTasktest(){
        sqlSession = factory.openSession(true);

        sqlSession.close();
    }
}
