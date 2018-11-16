package com.equipments.management.controller;

//import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
@RequestMapping("/staffextend")
public class EqstaffextendController {

    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqstaffextendController.class);
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

    public EqstaffextendController(){
        super();
    }



    public static Logger getLogger() {
        return logger;
    }

    public static SqlSession getSqlSession() {
        return sqlSession;
    }

    public static void setSqlSession(SqlSession sqlSession) {
        EqstaffextendController.sqlSession = sqlSession;
    }

    public static String getStatement() {
        return statement;
    }

    public static void setStatement(String statement) {
        EqstaffextendController.statement = statement;
    }

    public static SqlSessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SqlSessionFactory factory) {
        EqstaffextendController.factory = factory;
    }

    public static String getDateFormate() {
        return DATE_FORMATE;
    }

    @Override
    public String toString() {
        return "EqController{}";
    }


    @RequestMapping("/selectAllStaffextend")
    @ResponseBody
    public void selectAllStaffextend(HttpServletResponse response,HttpServletRequest request){
        sqlSession = factory.openSession(true);

        List<Staffextend> staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getAllStaffextend");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(staffextendList,SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }


    /*
    * 通过Staff.id获得最新的Task记录以及对应的Staffextend记录
    *
    * */
    @RequestMapping("/selectStaffextendByStaffLimit")
    @ResponseBody
    public void selectStaffextendByStaffLimit(HttpServletResponse response,
                                              HttpServletRequest request,
                                              @RequestParam("staff_id") String staffid){
        sqlSession = factory.openSession(true);
        List<Staffextend> staffextendList = null;
        if(staffid !=null){
            staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getStaffextendByStaffLimit",Integer.valueOf(staffid));
            logger.info("---------------staffextendList----------------");
            logger.info(staffextendList.get(0).toString());
        }

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(staffextendList,SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    /*
    @RequestMapping(value="/insertStaffextend")
    public void insertStaffextend(
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
    */

    @RequestMapping(value="/updateStaffextend")
    @ResponseBody
    public void updateStaffextend(
            HttpServletResponse response,
            @RequestParam(name="extend_id",required=false) String extendid,
            @RequestParam("staff_id") String staffid,
            @RequestParam(name="task_id",required=false) String taskid,
            @RequestParam(name="extend_nation",required=false) String nation,
            @RequestParam(name="extend_educationle",required=false) String educationle,
            @RequestParam(name="extend_qkbzwhzc",required=false) String qkbzwhzc,
            @RequestParam(name="extend_qkbjxhjb",required=false) String qkbjxhjb,
            @RequestParam(name="extend_zzmianmao",required=false) String zzmianmao,
            @RequestParam(name="extend_bysjbyyx",required=false) String bysjbyyx,
            @RequestParam(name="extend_wgysp",required=false) String wgysp,
            @RequestParam(name="extend_gzjlsj001",required=false) String gzjlsj001,
            @RequestParam(name="extend_gzjlsj002",required=false) String gzjlsj002,
            @RequestParam(name="extend_gzjlsj003",required=false) String gzjlsj003,
            @RequestParam(name="extend_gzjlsj004",required=false) String gzjlsj004,
            @RequestParam(name="extend_gzjlsj005",required=false) String gzjlsj005,
            @RequestParam(name="extend_gzjlcsgzjzw001",required=false) String gzjlcsgzjzw001,
            @RequestParam(name="extend_gzjlcsgzjzw002",required=false) String gzjlcsgzjzw002,
            @RequestParam(name="extend_gzjlcsgzjzw003",required=false) String gzjlcsgzjzw003,
            @RequestParam(name="extend_gzjlcsgzjzw004",required=false) String gzjlcsgzjzw004,
            @RequestParam(name="extend_gzjlcsgzjzw005",required=false) String gzjlcsgzjzw005,
            @RequestParam(name="extend_cgqksj001",required=false) String cgqksj001,
            @RequestParam(name="extend_cgqksj002",required=false) String cgqksj002,
            @RequestParam(name="extend_cgqksj003",required=false) String cgqksj003,
            @RequestParam(name="extend_cgqkgjjrw001",required=false) String cgqkgjjrw001,
            @RequestParam(name="extend_cgqkgjjrw002",required=false) String cgqkgjjrw002,
            @RequestParam(name="extend_cgqkgjjrw003",required=false) String cgqkgjjrw003,
            @RequestParam(name="extend_cgqkdwsf001",required=false) String cgqkdwsf001,
            @RequestParam(name="extend_cgqkdwsf002",required=false) String cgqkdwsf002,
            @RequestParam(name="extend_cgqkdwsf003",required=false) String cgqkdwsf003,
            @RequestParam(name="extend_jtqkxm001",required=false) String jtqkxm001,
            @RequestParam(name="extend_jtqkxm002",required=false) String jtqkxm002,
            @RequestParam(name="extend_jtqkxm003",required=false) String jtqkxm003,
            @RequestParam(name="extend_jtqkgx001",required=false) String jtqkgx001,
            @RequestParam(name="extend_jtqkgx002",required=false) String jtqkgx002,
            @RequestParam(name="extend_jtqkgx003",required=false) String jtqkgx003,
            @RequestParam(name="extend_jtqkgzjzw001",required=false) String jtqkgzjzw001,
            @RequestParam(name="extend_jtqkgzjzw002",required=false) String jtqkgzjzw002,
            @RequestParam(name="extend_jtqkgzjzw003",required=false) String jtqkgzjzw003,
            @RequestParam(name="extend_jtqkgwf001",required=false) String jtqkgwf001,
            @RequestParam(name="extend_jtqkgwf002",required=false) String jtqkgwf002,
            @RequestParam(name="extend_jtqkgwf003",required=false) String jtqkgwf003,
            @RequestParam(name="staffdetail_yjfxcjgx",required=false) String yjfxcjgx,
            @RequestParam(name="staffdetail_grjjgdzd",required=false) String grjjgdzd,
            @RequestParam(name="task_swscmxm",required=false) String swscmxm,
            @RequestParam(name="task_swscmdh",required=false) String swscmdh,
            @RequestParam(name="extend_ywhuzhao",required=false) String ywhuzhao,
            @RequestParam(name="passport_huzhaozhonglei",required=false) String huzhaozhonglei,
            @RequestParam(name="passport_huzhaohao",required=false) String huzhaohao,
            @RequestParam(name="passport_fazhaoriqi",required=false) String fazhaoriqi,
            @RequestParam(name="passport_huzhaoyouxiaoqi",required=false) String huzhaoyouxiaoqi,
            @RequestParam(name="passport_yanqi",required=false) String yanqi,
            @RequestParam(name="passport_beizhu",required=false) String beizhu
            ){
        sqlSession = factory.openSession(true);

        //设置Staffextend对象
        List<Staffextend> tempQueryStaffextend = null;
        Staffextend tempStaffextend = new Staffextend();


        //设置Staff对象
        Staff tempStaff = new Staff();
        if(staffid !=null){
            tempQueryStaffextend = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getStaffextendByStaffLimit",Integer.valueOf(staffid));
            tempStaff.setId(Integer.valueOf(staffid));
            tempStaffextend.setStaffid(tempStaff);
        }
        else{
            logger.info("-----------------------staffid is null-------------------------");
            return;
        }
        if (extendid != null) {
            tempStaffextend.setExtendid(Integer.valueOf(extendid));
        } else {
            tempStaffextend.setExtendid(tempQueryStaffextend.get(0).getExtendid());
        }

        //设置Task对象
        Task tempTask = new Task();
        if (taskid != null) {
            tempTask.setId(Integer.valueOf(taskid));
            tempStaffextend.setTaskid(tempTask);
        } else {
            if (tempQueryStaffextend != null) {
                tempTask.setId(tempQueryStaffextend.get(0).getTaskid().getId());
                tempStaffextend.setTaskid(tempTask);
            }
        }

        /*
        * 成员变量设置
        * */
            if (nation != null) {
                tempStaffextend.setNation(nation);
            }

            if (educationle != null) {
                tempStaffextend.setEducationle(educationle);
            }

            if (qkbzwhzc != null) {
                tempStaffextend.setQkbzwhzc(qkbzwhzc);
            }

            if (qkbjxhjb != null) {
                tempStaffextend.setQkbjxhjb(qkbjxhjb);
            }

            if (zzmianmao != null) {
                tempStaffextend.setZzmianmao(zzmianmao);
            }

            if (bysjbyyx != null && bysjbyyx != "") {
                tempStaffextend.setBysjbyyx(bysjbyyx);
            }

            if (wgysp != null) {
                tempStaffextend.setWgysp(wgysp);
            }

            if (gzjlsj001 != null) {
                tempStaffextend.setGzjlsj001(gzjlsj001);
            }
            if (gzjlsj002 != null) {
                tempStaffextend.setGzjlsj002(gzjlsj002);
            }
            if (gzjlsj003 != null) {
                tempStaffextend.setGzjlsj003(gzjlsj003);
            }
            if (gzjlsj004 != null) {
                tempStaffextend.setGzjlsj004(gzjlsj004);
            }
            if (gzjlsj005 != null) {
                tempStaffextend.setGzjlsj005(gzjlsj005);
            }

            if (gzjlcsgzjzw001 != null) {
                tempStaffextend.setGzjlcsgzjzw001(gzjlcsgzjzw001);
            }
            if (gzjlcsgzjzw002 != null) {
                tempStaffextend.setGzjlcsgzjzw002(gzjlcsgzjzw002);
            }
            if (gzjlcsgzjzw003 != null) {
                tempStaffextend.setGzjlcsgzjzw003(gzjlcsgzjzw003);
            }
            if (gzjlcsgzjzw004 != null) {
                tempStaffextend.setGzjlcsgzjzw004(gzjlcsgzjzw004);
            }
            if (gzjlcsgzjzw005 != null) {
                tempStaffextend.setGzjlcsgzjzw005(gzjlcsgzjzw005);
            }

            if (cgqksj001 != null) {
                tempStaffextend.setCgqksj001(cgqksj001);
            }
            if (cgqksj002 != null) {
                tempStaffextend.setCgqksj002(cgqksj002);
            }
            if (cgqksj003 != null) {
                tempStaffextend.setCgqksj003(cgqksj003);
            }

            if (cgqkgjjrw001 != null) {
                tempStaffextend.setCgqkgjjrw001(cgqkgjjrw001);
            }
            if (cgqkgjjrw002 != null) {
                tempStaffextend.setCgqkgjjrw002(cgqkgjjrw002);
            }
            if (cgqkgjjrw003 != null) {
                tempStaffextend.setCgqkgjjrw003(cgqkgjjrw003);
            }

            if (cgqkdwsf001 != null) {
                tempStaffextend.setCgqkdwsf001(cgqkdwsf001);
            }
            if (cgqkdwsf002 != null) {
                tempStaffextend.setCgqkdwsf002(cgqkdwsf002);
            }
            if (cgqkdwsf003 != null) {
                tempStaffextend.setCgqkdwsf003(cgqkdwsf003);
            }

            if (jtqkxm001 != null) {
                tempStaffextend.setJtqkxm001(jtqkxm001);
            }
            if (jtqkxm002 != null) {
                tempStaffextend.setJtqkxm002(jtqkxm002);
            }
            if (jtqkxm003 != null) {
                tempStaffextend.setJtqkxm003(jtqkxm003);
            }

            if (jtqkgx001 != null) {
                tempStaffextend.setJtqkgx001(jtqkgx001);
            }
            if (jtqkgx002 != null) {
                tempStaffextend.setJtqkgx002(jtqkgx002);
            }
            if (jtqkgx003 != null) {
                tempStaffextend.setJtqkgx003(jtqkgx003);
            }

            if (jtqkgzjzw001 != null) {
                tempStaffextend.setJtqkgzjzw001(jtqkgzjzw001);
            }
            if (jtqkgzjzw002 != null) {
                tempStaffextend.setJtqkgzjzw002(jtqkgzjzw002);
            }
            if (jtqkgzjzw003 != null) {
                tempStaffextend.setJtqkgzjzw003(jtqkgzjzw003);
            }

            if (jtqkgwf001 != null) {
                tempStaffextend.setJtqkgwf001(jtqkgwf001);
            }
            if (jtqkgwf002 != null) {
                tempStaffextend.setJtqkgwf002(jtqkgwf002);
            }
            if (jtqkgwf003 != null) {
                tempStaffextend.setJtqkgwf003(jtqkgwf003);
            }

            if (yjfxcjgx != null) {
                tempStaffextend.setYjfxcjgx(yjfxcjgx);
            }

            if (grjjgdzd != null) {
                tempStaffextend.setGrjjgdzd(grjjgdzd);
            }

            if (swscmxm != null) {
                tempStaffextend.setSwscmxm(swscmxm);
            }

            if (swscmdh != null) {
                tempStaffextend.setSwscmdh(swscmdh);
            }

            if (ywhuzhao != null) {
                tempStaffextend.setYwhuzhao(ywhuzhao);
            }

            if (huzhaozhonglei != null) {
                tempStaffextend.setHuzhaozhonglei(huzhaozhonglei);
            }

            if (huzhaohao != null) {
                tempStaffextend.setHuzhaohao(huzhaohao);
            }

            if (fazhaoriqi != null && fazhaoriqi != "") {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date tempDate = null;

                try {
                    tempDate = formatter.parse(fazhaoriqi);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tempStaffextend.setFazhaoriqi(tempDate);
            }

            if (huzhaoyouxiaoqi != null && huzhaoyouxiaoqi != "") {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date tempDate = null;

                try {
                    tempDate = formatter.parse(huzhaoyouxiaoqi);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tempStaffextend.setHuzhaoyouxiaoqi(tempDate);
            }

            if (yanqi != null && yanqi != "") {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date tempDate = null;

                try {
                    tempDate = formatter.parse(yanqi);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tempStaffextend.setYanqi(tempDate);
            }

            if (beizhu != null && beizhu != "") {
                tempStaffextend.setBeizhu(beizhu);
            }
            sqlSession.update("com.equipments.management.mapper.StaffextendMapper.updateStaffextend", tempStaffextend);

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(tempStaffextend));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    @RequestMapping(value="/deleteStaffextend")
    public void deleteStaffextend(
            @RequestParam("task_id") String taskid){
        sqlSession = factory.openSession(true);

        /*
        Task task = new Task();
        if(taskid !=null){
            task.setId(Integer.parseInt(taskid));
        }

        sqlSession.delete("com.equipments.management.mapper.TaskMapper.removeTaskById",task);
        */
        sqlSession.close();
    }


    /*
    * 生成  模板.情况表
    *
    *
    * */
    /**
     * 生成-人员情况登记表
     *
     * */
    @RequestMapping("/outputQkb")
    @ResponseBody
    public void outputQkb(HttpServletResponse response,
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

                Map<String,Object> tempMap = new HashMap<String, Object>();
                tempMap.put("name",tempStaffextend.getStaffid().getName());
                //tempMap.put("zhicheng",tempStaffextend.getStaffid().getZhicheng());
                tempMap.put("gender",tempStaffextend.getStaffid().getGender());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                tempMap.put("birthyday",sdf.format(tempStaffextend.getStaffid().getBirthyday()));
                tempMap.put("birthplace",tempStaffextend.getStaffid().getBirthplace());
                tempMap.put("nation",tempStaffextend.getNation());
                tempMap.put("educationle",tempStaffextend.getEducationle());
                tempMap.put("qkbzwhzc",tempStaffextend.getQkbzwhzc());
                tempMap.put("qkbjxhjb",tempStaffextend.getQkbjxhjb());
                tempMap.put("zzmianmao",tempStaffextend.getZzmianmao());
                tempMap.put("bysjbyyx",tempStaffextend.getBysjbyyx());
                tempMap.put("wgysp",tempStaffextend.getWgysp());
                tempMap.put("jgzhwzgbz",tempStaffextend.getStaffid().getJgzid());

                tempMap.put("jgzid",tempStaffextend.getStaffid().getJgzid());

                tempMap.put("phone",tempStaffextend.getStaffid().getPhone());
                tempMap.put("ywhuzhao",tempStaffextend.getYwhuzhao());
                tempMap.put("huzhaohao",tempStaffextend.getHuzhaohao());
                tempMap.put("huzhaoyouxiaoqi",sdf.format(tempStaffextend.getHuzhaoyouxiaoqi()));
                tempMap.put("gzjlsj001",tempStaffextend.getGzjlsj001());
                tempMap.put("gzjlsj002",tempStaffextend.getGzjlsj002());
                tempMap.put("gzjlsj003",tempStaffextend.getGzjlsj003());
                tempMap.put("gzjlsj004",tempStaffextend.getGzjlsj004());
                tempMap.put("gzjlsj005",tempStaffextend.getGzjlsj005());
                tempMap.put("gzjlcsgzjzw001",tempStaffextend.getGzjlcsgzjzw001());
                tempMap.put("gzjlcsgzjzw002",tempStaffextend.getGzjlcsgzjzw002());
                tempMap.put("gzjlcsgzjzw003",tempStaffextend.getGzjlcsgzjzw003());
                tempMap.put("gzjlcsgzjzw004",tempStaffextend.getGzjlcsgzjzw004());
                tempMap.put("gzjlcsgzjzw005",tempStaffextend.getGzjlcsgzjzw005());
                tempMap.put("cgqksj001",tempStaffextend.getCgqksj001());
                tempMap.put("cgqksj002",tempStaffextend.getCgqksj002());
                tempMap.put("cgqksj003",tempStaffextend.getCgqksj003());
                tempMap.put("cgqkgjjrw001",tempStaffextend.getCgqkgjjrw001());
                tempMap.put("cgqkgjjrw002",tempStaffextend.getCgqkgjjrw002());
                tempMap.put("cgqkgjjrw003",tempStaffextend.getCgqkgjjrw003());
                tempMap.put("cgqkdwsf001",tempStaffextend.getCgqkdwsf001());
                tempMap.put("cgqkdwsf002",tempStaffextend.getCgqkdwsf002());
                tempMap.put("cgqkdwsf003",tempStaffextend.getCgqkdwsf003());
                tempMap.put("jtqkxm001",tempStaffextend.getJtqkxm001());
                tempMap.put("jtqkxm002",tempStaffextend.getJtqkxm002());
                tempMap.put("jtqkxm003",tempStaffextend.getJtqkxm003());
                tempMap.put("jtqkgx001",tempStaffextend.getJtqkgx001());
                tempMap.put("jtqkgx002",tempStaffextend.getJtqkgx002());
                tempMap.put("jtqkgx003",tempStaffextend.getJtqkgx003());
                tempMap.put("jtqkgzjzw001",tempStaffextend.getJtqkgzjzw001());
                tempMap.put("jtqkgzjzw002",tempStaffextend.getJtqkgzjzw002());
                tempMap.put("jtqkgzjzw003",tempStaffextend.getJtqkgzjzw003());
                tempMap.put("jtqkgwf001",tempStaffextend.getJtqkgwf001());
                tempMap.put("jtqkgwf002",tempStaffextend.getJtqkgwf002());
                tempMap.put("jtqkgwf003",tempStaffextend.getJtqkgwf003());

                tempMap.put("department",tempStaffextend.getStaffid().getDepartment().getName());
                tempMap.put("swscmxm",tempStaffextend.getSwscmxm());
                tempMap.put("swscmdh",tempStaffextend.getSwscmdh());

                ExportDoc maker = new ExportDoc("UTF-8");

                try {

                    String url = request.getSession().getServletContext().getRealPath("/outputfiles/") + tempStaffextend.getTaskid().getId().toString()+ "/";
                    //String url = "F:/output/";

                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                    String tempFileName = "sqrycgqkb-" + staffid + "-" + df.format(new Date()) +".doc";
                    String fileAddress = url + tempFileName;
                    logger.info("----------------------------fileAddress------------------------------");
                    logger.info(fileAddress);
                    maker.exportDoc(fileAddress,"sqrycgqkb.ftl",tempMap);

                    //保存文件名称到数据记录表
                    //tempStaffextend
                    Task tempTask = tempStaffextend.getTaskid();
                    tempTask.setCgryqkbaddr(tempFileName);
                    sqlSession.update("com.equipments.management.mapper.TaskMapper.updateTask",tempTask);

                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = null;
                    try{
                        out = response.getWriter();
                        out.println(JSON.toJSONString(tempFileName));
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
                out.println(JSON.toJSONString("FALSE"));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                out.close();
            }
        }
        sqlSession.close();
    }
}
