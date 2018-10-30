package com.equipments.management.controller;

//import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.domain.*;
import com.equipments.management.dto.ExportDoc;
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


    @RequestMapping("/selectAllTask")
    @ResponseBody
    public void selectAllTask(HttpServletResponse response,HttpServletRequest request){
        sqlSession = factory.openSession(true);

        List<Task> taskList = sqlSession.selectList("com.equipments.management.mapper.TaskMapper.getAllTask");
        sqlSession.close();

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
    public void insertTask(
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

        sqlSession.insert("com.equipments.management.mapper.TaskMapper.addTask",task);
        sqlSession.close();
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
    public void deleteTask(
            @RequestParam("task_id") String taskid){
        sqlSession = factory.openSession(true);

        Task task = new Task();
        if(taskid !=null){
            task.setId(Integer.parseInt(taskid));
        }

        sqlSession.delete("com.equipments.management.mapper.TaskMapper.removeTaskById",task);
        sqlSession.close();
    }
}
