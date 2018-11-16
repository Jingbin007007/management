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
                                        @RequestParam("task_id") String taskid){
        sqlSession = factory.openSession(true);

        List<Baomi> baomiList = null;
        List<Staffextend> staffextendList = null;


        if(taskid !=null){
            baomiList = sqlSession.selectList("com.equipments.management.mapper.BaomiMapper.getBaomiByTaskLimit",Integer.valueOf(taskid));
            logger.info("---------------staffextendList----------------");
            logger.info(baomiList.get(0).toString());
            if(baomiList != null && baomiList.get(0) != null){
                if(baomiList.get(0).getTaskid().getId() != null){
                    Staffextend queryStaffextend = new Staffextend();
                    queryStaffextend.setTaskid(baomiList.get(0).getTaskid());
                    staffextendList = sqlSession.selectList("com.equipments.management.mapper.StaffextendMapper.getStaffextendByAll",queryStaffextend);
                }
            }
        }

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(baomiList,SerializerFeature.DisableCircularReferenceDetect));
            out.println(JSON.toJSONString(staffextendList,SerializerFeature.DisableCircularReferenceDetect));
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
            @RequestParam(name="baomi_xddzsbyf",required=false) String xddzsbyf,
            @RequestParam(name="baomi_xdsmzlmc1",required=false) String xdsmzlmc1,
            @RequestParam(name="baomi_xdsmzlfs1",required=false) String xdsmzlfs1,
            @RequestParam(name="baomi_xdsmzlsmdj",required=false) String xdsmzlsmdj1,
            @RequestParam(name="baomi_xdsmzlmc2",required=false) String xdsmzlmc2,
            @RequestParam(name="baomi_xdsmzlfs2",required=false) String xdsmzlfs2,
            @RequestParam(name="baomi_xdsmzlsmdj2",required=false) String xdsmzlsmdj2,
            @RequestParam(name="baomi_xdsmzlyf",required=false) String xdsmzlyf
            ){
        sqlSession = factory.openSession(true);

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
            if(xdsmzlfs1 != null){
                tempBaomi.setXdsmzlfs1(Integer.valueOf(xdsmzlfs1));
            }
            if(xdsmzlsmdj1 != null){
                tempBaomi.setXdsmzlsmdj1(xdsmzlsmdj1);
            }
            if(xdsmzlmc2 != null){
                tempBaomi.setXdsmzlmc2(xdsmzlmc2);
            }
            if(xdsmzlfs2 != null){
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

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(tempBaomi));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    @RequestMapping(value="/deleteBaomi")
    public void deleteBaomi(
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
     * 生成-保密表
     *
     * */
    @RequestMapping("/outputBaomi")
    @ResponseBody
    public void outputQkb(HttpServletResponse response,
                          HttpServletRequest request,
                          @RequestParam("staff_id") String staffid
                          ){
        sqlSession = factory.openSession(false);
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
                    //String url = request.getSession().getServletContext().getRealPath("/output");
                    //String url = "F:/output/";
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                    String tempFileName = "sqrycgqkb-" + df.format(new Date()) +".doc";
                    //String fileAddress = url + tempFileName;
                    maker.exportDoc(tempFileName,"sqrycgqkb.ftl",tempMap);

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
