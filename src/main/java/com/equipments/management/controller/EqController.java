package com.equipments.management.controller;

//import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.dao.KylinUtil;
import com.equipments.management.domain.*;
import com.equipments.management.domain.gradation.Patientinfo001;
import com.equipments.management.service.Trunctable;
import com.equipments.management.util.BeanUtil;
import com.equipments.management.util.ExportExcel;
import com.equipments.management.util.POIUtil;
import com.equipments.management.util.PagedResult;
import com.github.pagehelper.PageHelper;


import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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


/**
 * Created by Administrator on 2017/5/2.
 */
@Controller
public class EqController {

    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqController.class);
    private static SqlSession sqlSession;
    private static String statement;
    private static SqlSessionFactory factory;

    protected final static String DATE_FORMATE = "yyyy-MM-dd";

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

    public EqController(){
        super();
    }

    //登录界面login.jsp
    @RequestMapping(value = "/login")
    public String loginForm(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String password,
            HttpServletRequest request){
        logger.info("登录名："+loginname+" 密码："+password);

        Map<String,Object> tempMap = new HashMap<String, Object>();
        tempMap.put("loginname",loginname);
        tempMap.put("password",password);

        //获得连接池
        sqlSession = factory.openSession(true);
        List<Staff> staffList = sqlSession.selectList("com.equipments.management.mapper.StaffMapper.getStaffByAll",tempMap);

        sqlSession.close();
        if(staffList.isEmpty()){
            //logger.info("--------------register-------------------");
            return "register";
        }
        else{
            //logger.info("-----------------index-------------------");
            HttpSession session = request.getSession();
            session.setAttribute("staff",staffList.get(0));
            //return "userFace002";
            return "index";
        }
    }
    @RequestMapping(value="/registerStaff")
    public String registerStaff(
            @RequestParam("username") String loginname,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("grade") String grade,
            @RequestParam("phone") String phone,
            @RequestParam("sex") String sex,
            @RequestParam("age") String age,
            @RequestParam("email") String email,
            Model model){
        sqlSession = factory.openSession(true);
        Staff staff = new Staff();


        staff.setLoginname(loginname);
        staff.setGrade(Integer.valueOf(grade));
        staff.setName(name);
        staff.setPhone(phone);
        staff.setPassword(password);
        staff.setSex(sex);
        staff.setAge(Integer.valueOf(age));
        //staff.setState(state);
        staff.setEmail(email);

        //logger.info("---------------receice Staff-------------------");
        //logger.info(staff.toString());

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("loginname",staff.getLoginname());
        /**
         map.put("grade",staff.getGrade());
         map.put("name",staff.getName());
         map.put("phone",staff.getPhone());
         map.put("password",staff.getPassword());
         */

        List<Staff> staffList = sqlSession.selectList("com.equipments.management.mapper.StaffMapper.getStaffByAll",map);


        if(staffList.isEmpty()){
            sqlSession.insert("com.equipments.management.mapper.StaffMapper.addStaff",staff);
            model.addAttribute("staff",staff);
            sqlSession.close();
            //return "userFace002";
            return "index";
        }
        else{
            sqlSession.close();
            return "register";
        }
    }

    @RequestMapping("/index")
    public String mainForm(Model model){
        return "userFace002";
    }

    //中药主界面
    @RequestMapping("/userFace002zhongyao")
    public String zhongyaomainForm(Model model){

        return "userFace002zhongyao";
    }
    /**
     * 前端判断用户名重复
     * */
    @RequestMapping("/testUserName")
    public void testUserName(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("username") String loginname){
        sqlSession = factory.openSession(true);
        Map<String,Object> tempMap = new HashMap<String, Object>();
        tempMap.put("loginname",loginname);
        List<Staff> staffList = sqlSession.selectList("com.equipments.management.mapper.StaffMapper.getStaffByAll",tempMap);
        sqlSession.close();

        //logger.info("--------------------testUserName------------------------");

        //准备输出结果：Boolean
        response.reset();
        response.setContentType("text/html;charset=UTF-8");
        //业务逻辑操作查询用户
        if(staffList.isEmpty()){
            try {
                response.getWriter().print(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                response.getWriter().print(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * getStaffByLoginname
     * **/
    @RequestMapping("/getUsername")
    @ResponseBody
    public void getUsername(HttpServletResponse response,HttpServletRequest request){
        sqlSession = factory.openSession(true);
        HttpSession session = request.getSession();
        Staff staff = (Staff)session.getAttribute("staff");

        Staff staffList = sqlSession.selectOne("com.equipments.management.mapper.StaffMapper.getStaffById",staff.getId());
        sqlSession.close();

        //pageNo = 1;
        //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(staffList.getName(),SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    /**
     * 测试Page
     * **/
    @RequestMapping("/queryByPage")
    @ResponseBody
    public void queryByPage(HttpServletResponse response,
                            @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                            @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                            @RequestParam(value="sortName",defaultValue = "staff_id") String sortName,
                            @RequestParam(value="sortOrder",defaultValue = "asc") String sortOrder){
        sqlSession = factory.openSession(true);

        //logger.info("------------------------------------");

        //传输排序数据如果为索引，单独进行映射处理
        if(sortName.equals("department.name")){
            sortName = "staff_department_id";
        }
        String orderByStr = sortName + " " + sortOrder;
        //logger.info(orderByStr);
        PageHelper.orderBy(orderByStr);
        PageHelper.startPage(page,rows);

        List<Staff> staffList = sqlSession.selectList("com.equipments.management.mapper.StaffMapper.getAllStaff");
        sqlSession.close();

        PagedResult<Staff> pd = BeanUtil.toPagedResult(staffList);


        //pageNo = 1;
        //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(pd,SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @RequestMapping("/editByPage")
    public void editByPage(@RequestParam(value="strJson") String strJson,
                           @RequestParam(value="strField") String strField,
                           @RequestParam(value="strOldValue") String strOldValue){


        Object succesResponse = JSON.parse(strJson);
        Map map = (Map)succesResponse;
        Object temp = map.get(strField);
    }

    //测试文件上传
    @RequestMapping("/springUpload")
    public String springUpload(HttpServletRequest request,
                               Model model) throws IOException {
        long  startTime=System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                String fileSize = String.valueOf(file.getSize()/1024/1024);
                if(file!=null)
                {
                    String path="E:/Upload/"+String.valueOf(System.currentTimeMillis())+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                    model.addAttribute("fileName",file.getOriginalFilename());
                    model.addAttribute("fileSize",fileSize);
                }

            }

        }
        long  endTime=System.currentTimeMillis();
        return "upload_test";
    }

    /**
     * saveStaffById
     * **/
    @RequestMapping("/saveStaffById")
    public void saveStaffById(HttpServletResponse response,
                              @RequestParam("modiRecords[]") List<String> modifiedRecords,
                              @RequestParam("lengthRecords") Integer len){
        if(modifiedRecords !=null){
            sqlSession = factory.openSession(true);
            Staff staff = new Staff();

            if(len == 1){
                staff.setId(Integer.parseInt(modifiedRecords.get(0)));
                staff.setName(modifiedRecords.get(1));
                staff.setLoginname(modifiedRecords.get(2));
                staff.setEmail(modifiedRecords.get(3));
                sqlSession.update("com.equipments.management.mapper.StaffMapper.updateStaff",staff);
            }
            else{
                for(String tempStr:modifiedRecords){
                    String[] tempSplit = tempStr.split(",");

                    for(int i = 0;i<tempSplit.length;i++){
                        staff.setId(Integer.parseInt(tempSplit[0]));
                        staff.setName(tempSplit[1]);
                        staff.setLoginname(tempSplit[2]);
                        staff.setEmail(tempSplit[3]);
                        sqlSession.update("com.equipments.management.mapper.StaffMapper.updateStaff",staff);
                    }
                }
            }
            sqlSession.close();
        }
    }



    //获得数据表Meds字典数据
    @RequestMapping("/selectAllMeds")
    @ResponseBody
    public void selectAllSers(HttpServletResponse response,
                              @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                              @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);



        List<Med> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getAllMeds");
        sqlSession.close();



        PagedResult<Med> pd = BeanUtil.toPagedResult(medList);

        //pageNo = 1;
        //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
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

    //获得数据表Meds字典数据列一
    @RequestMapping("/getDistTongyongmingcheng")
    @ResponseBody
    public void getDistTongyongmingcheng(HttpServletResponse response,
                                         @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                         @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);



        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistTongyongmingcheng");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);

        //pageNo = 1;
        //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
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
    //获得数据表Meds字典数据列二
    @RequestMapping("/getDistYingwenming")
    @ResponseBody
    public void getDistYingwenming(HttpServletResponse response,
                                   @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                   @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistYingwenming");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);

        //pageNo = 1;
        //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
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
    //获得数据表Meds字典数据列三
    @RequestMapping("/getDistLaiyuan")
    @ResponseBody
    public void getDistLaiyuan(HttpServletResponse response,
                               @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                               @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistLaiyuan");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);

        //pageNo = 1;
        //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
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
    //获得数据表Meds字典数据列四
    @RequestMapping("/getDistYuanliao")
    @ResponseBody
    public void getDistYuanliao(HttpServletResponse response,
                                @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistYuanliao");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列五
    @RequestMapping("/getDistZhuangtai")
    @ResponseBody
    public void getDistZhuangtai(HttpServletResponse response,
                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                 @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistZhuangtai");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列六
    @RequestMapping("/getDistLeibie001")
    @ResponseBody
    public void getDistLeibie001(HttpServletResponse response,
                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                 @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistLeibie001");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列七
    @RequestMapping("/getDistLeibie002")
    @ResponseBody
    public void getDistLeibie002(HttpServletResponse response,
                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                 @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistLeibie002");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列八
    @RequestMapping("/getDistLeibie003")
    @ResponseBody
    public void getDistLeibie003(HttpServletResponse response,
                                 @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                 @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistLeibie003");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列九
    @RequestMapping("/getDistGuanlileibie")
    @ResponseBody
    public void getDistGuanlileibie(HttpServletResponse response,
                                    @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                    @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistGuanlileibie");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列十
    @RequestMapping("/getDistChufangyao")
    @ResponseBody
    public void getDistChufangyao(HttpServletResponse response,
                                  @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                  @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistChufangyao");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列十一
    @RequestMapping("/getDistChengfen")
    @ResponseBody
    public void getDistChengfen(HttpServletResponse response,
                                @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistChengfen");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);


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
    //获得数据表Meds字典数据列十二
    @RequestMapping("/getDistBiaozhunguidingguige")
    @ResponseBody
    public void getDistBiaozhunguidingguige(HttpServletResponse response,
                                            @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                            @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistBiaozhunguidingguige");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);

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
    //获得数据表Meds字典数据列十三
    @RequestMapping("/getDistBiaozhunwaiguige")
    @ResponseBody
    public void getDistBiaozhunwaiguige(HttpServletResponse response,
                                        @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                        @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistBiaozhunwaiguige");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列十四
    @RequestMapping("/getDistShiyongduixiang")
    @ResponseBody
    public void getDistShiyongduixiang(HttpServletResponse response,
                                       @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                       @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistShiyongduixiang");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);

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
    //获得数据表Meds字典数据列十五
    @RequestMapping("/getDistYongtu")
    @ResponseBody
    public void getDistYongtu(HttpServletResponse response,
                              @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                              @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistYongtu");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);

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
    //获得数据表Meds字典数据列十六
    @RequestMapping("/getDistXianlianghuoxiuyao")
    @ResponseBody
    public void getDistXianlianghuoxiuyao(HttpServletResponse response,
                                          @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                          @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistXianlianghuoxiuyao");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);

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
    //获得数据表Meds字典数据列十七
    @RequestMapping("/getDistPizhunshijian")
    @ResponseBody
    public void getDistPizhunshijian(HttpServletResponse response,
                                     @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                     @RequestParam(value="pageSize",defaultValue = "10") Integer rows
    ){
        sqlSession = factory.openSession(true);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistPizhunshijian");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            //out.println(JSON.toJSONString(pd, SerializerFeature.DisableCircularReferenceDetect));
            out.println(JSON.toJSONString(medList));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
    //获得数据表Meds字典数据列十八
    @RequestMapping("/getDistBiaozhunyange")
    @ResponseBody
    public void getDistBiaozhunyange(HttpServletResponse response,
                                     @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                     @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getDistBiaozhunyange");
        sqlSession.close();

        PagedResult<String> pd = BeanUtil.toPagedResult(medList);


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


    //获得数据表Meds数据
    @RequestMapping("/selectMeds")
    @ResponseBody
    public void selectSer(HttpServletResponse response,
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
                          @RequestParam(value="pizhunriqi1") String pizhunriqi1,
                          @RequestParam(value="pizhunriqi2") String pizhunriqi2
    ){
        sqlSession = factory.openSession(true);


        Medquery queryMed = new Medquery();

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

        PageHelper.startPage(page,rows);
        List<Med> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getMedByAll",queryMed);
        sqlSession.close();

        PagedResult<Med> pd = BeanUtil.toPagedResult(medList);

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

    //删除Med记录
    @RequestMapping("/delMedById")
    public void delSerById(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value="ids") Integer[] ids){
        sqlSession = factory.openSession(true);

        response.reset();
        response.setContentType("text/html;charset=UTF-8");
        //业务逻辑操作查询用户
        for(int i = 0;i<ids.length;i++){
            try {
                sqlSession.delete("com.equipments.management.mapper.MedMapper.removeMedById",ids[i]);
                response.getWriter().print(true);
                sqlSession.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        Med med = new Med();
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
                            sqlSession.update("com.equipments.management.mapper.MedMapper.updateMed",med);
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

    /**
     * updateMedsByIds
     * **/
    @RequestMapping("/updateMedsByIds")
    public void updateMedsByIds(HttpServletResponse response,
                                @RequestParam("rowLists") String rowLists,
                                @RequestParam("lengthRecords") Integer len,
                                @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        JSONArray jsonArray = JSONArray.parseArray(rowLists);

        sqlSession = factory.openSession(true);

        int count = sqlSession.selectOne("com.equipments.management.mapper.MedMapper.countById");
        int pageNumber = count/rows +1;
        PageHelper.startPage(pageNumber,rows);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for(int i = 0;i < len;i++){
            Med med = new Med();
            com.alibaba.fastjson.JSONObject jUser = jsonArray.getJSONObject(i);
            med.setId(jUser.getInteger("id"));
            med.setTongyongmingcheng(jUser.getString("tongyongmingcheng"));
            med.setBeizhu(jUser.getString("beizhu"));
            med.setBiaozhunguidingguige(jUser.getString("biaozhunguidingguige"));
            med.setBiaozhunwaiguige(jUser.getString("biaozhunwaiguige"));
            med.setBiaozhunyange(jUser.getString("biaozhunyange"));
            med.setChengfen(jUser.getString("chengfen"));
            med.setChufangyao(jUser.getString("chufangyao"));
            med.setGuanlileibie(jUser.getString("guanlileibie"));
            med.setLaiyuan(jUser.getString("laiyuan"));
            med.setLeibie001(jUser.getString("leibie001"));
            med.setLeibie002(jUser.getString("leibie002"));
            med.setLeibie003(jUser.getString("leibie003"));
            med.setPizhunshijian(jUser.getString("pizhunshijian"));
            med.setShiyongduixiang(jUser.getString("shiyongduixiang"));
            med.setXianlianghuoxiuyao(jUser.getString("xianlianghuoxiuyao"));
            med.setYingwenming(jUser.getString("yingwenming"));
            med.setYongtu(jUser.getString("yongtu"));
            med.setYuanliao(jUser.getString("yuanliao"));
            med.setZhuangtai(jUser.getString("zhuangtai"));

            med.setShenbaodanwei(jUser.getString("shenbaodanwei"));
            med.setBaocuntiaojian(jUser.getString("baocuntiaojian"));
            med.setZhijileibie(jUser.getString("zhijileibie"));
            med.setFufangyufou(jUser.getString("fufangyufou"));
            med.setYuliu001(jUser.getString("yuliu001"));
            med.setYuliu002(jUser.getString("yuliu002"));
            med.setJinkouyuguochan(jUser.getString("jinkouyuguochan"));
            med.setXiuyaoqi(jUser.getString("xiuyaoqi"));

            String strDate = jUser.getString("pizhunriqi");
            if(strDate!=null){
                Date tempDate = null;
                try {
                    tempDate = formatter.parse(strDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                med.setPizhunriqi(tempDate);
            }
            //jUser.getString("");
            sqlSession.update("com.equipments.management.mapper.MedMapper.updateMed",med);
        }
        List<Med> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getMedByAll");
        sqlSession.close();
        PagedResult<Med> pd = BeanUtil.toPagedResult(medList);

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
     * insertNewRecord
     * **/
    @RequestMapping("/insertNewRecord")
    public void insertNewRecord(HttpServletResponse response,
                                @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        sqlSession = factory.openSession(true);
        Med med = new Med();

        //获得分页信息
        int count = sqlSession.selectOne("com.equipments.management.mapper.MedMapper.countById");
        int pageNumber = count/rows +1;
        PageHelper.startPage(pageNumber,rows);

        sqlSession.insert("com.equipments.management.mapper.MedMapper.addMed",med);
        List<Med> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getMedByAll");
        sqlSession.close();


        PagedResult<Med> pd = BeanUtil.toPagedResult(medList);

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
    public Map<String, Object> updatePhoto(HttpServletRequest request,HttpServletResponse response,
                                           @RequestParam("input-b9") MultipartFile myFile,
                                           @RequestParam("fileid") Integer fileid){
        //fileid
        Map<String, Object> json = new HashMap<String, Object>();
        sqlSession = factory.openSession(true);
        Med med = new Med();
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
            sqlSession.update("com.equipments.management.mapper.MedMapper.updateMed",med);
            json.put("success", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return json ;
    }

    /*
    * adminappendfiles 将数据存储到 List<String[]> listStrings中
    *
    */

    @RequestMapping("/adminappendfiles")
    @ResponseBody
    public Map<String, Object> appendExcel(HttpServletRequest request,
                                           HttpServletResponse response,
                                           @RequestParam("input-b9") MultipartFile myFile,
                                           @RequestParam(value = "tablename",defaultValue = "huayao") String tablename){


        Map<String, Object> json = new HashMap<String, Object>();

        sqlSession = factory.openSession(true);
        List<String[]> listStrings = new LinkedList<String[]>();

        json = POIUtil.insertTables(json,tablename,listStrings,sqlSession,myFile);

        sqlSession.close();
        return json ;
    }

    @RequestMapping("/selectMedsAll")
    @ResponseBody
    public List<Medsheng> selectMedsAll(HttpServletResponse response,
                                        @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                        @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                        @RequestParam(value="baohancanshu",defaultValue = "") String baohancanshu,
                                        @RequestParam(value="laiyuan",defaultValue = "") String laiyuan
    ){

        sqlSession = factory.openSession(true);

        List<Medsheng> shengmedList = Trunctable.deelwithTempTable(page,rows,baohancanshu,laiyuan,sqlSession);
        //获得分页信息
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        return shengmedList;
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
                              @RequestParam(value="pizhunriqi1",defaultValue = "") String pizhunriqi1,
                              @RequestParam(value="pizhunriqi2",defaultValue = "") String pizhunriqi2) throws IOException {
        //Map<String, Object> json = new HashMap<String, Object>();
        sqlSession = factory.openSession(true);
        Medquery queryMed = new Medquery();

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

        String[] tempheaders = {"id","通用名称","英文名","来源","原料","状态","一类类别","二类类别","三类类别","管理类别","处方药","成分","标准规定规格","标准外规格","适用对象","用途","限量或休药","批准时间","标准沿革","备注","pdf文件路径","申报单位","保存条件","制剂类别","复方与否","预留一","预留二","进口或国产","休药期","批准日期"};
        List<String> headers = new ArrayList<String>();

        for(String temp:tempheaders){
            headers.add(temp);
        }

        List<Med> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getMedByAll",queryMed);
        sqlSession.close();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String filename = "huayao" + df.format(new Date()) +".xls";
        response.setContentType("text/html;charset=UTF-8");
        POIUtil.test(response,"huayao",headers,medList,filename);
        //json.put("success","下载成功");
        //return json;
    }

    //获得数据表Patientinfo数据
    @RequestMapping("/selectPatientinfo")
    @ResponseBody
    public void selectPatientinfo(HttpServletResponse response,
                                  @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                  @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                  @RequestParam(value="patientno",defaultValue = "") Integer patientno,
                                  @RequestParam(value="treatno",defaultValue = "") Integer treatno,
                                  @RequestParam(value="patientname",defaultValue = "") String patientname,
                                  @RequestParam(value="gender",defaultValue = "") String gender,
                                  @RequestParam(value="age",defaultValue = "") Integer age,
                                  @RequestParam(value="patientmarriage",defaultValue = "") String patientmarriage,
                                  @RequestParam(value="outpatientid",defaultValue = "") Integer outpatientid,
                                  @RequestParam(value="hospitalizetionid",defaultValue = "") Integer hospitalizetionid,
                                  @RequestParam(value="departmentid",defaultValue = "") Integer departmentid,
                                  @RequestParam(value="bedid",defaultValue = "") Integer bedid
    ){
        sqlSession = factory.openSession(true);

        Patientinfo patientinfo = new Patientinfo();

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");

        if(patientno !=null){
            patientinfo.setPatientno(patientno);
        }

        if(treatno !=null){
            patientinfo.setTreatno(treatno);
        }

        if(!patientname.equals("")){
            patientinfo.setPatientname(patientname);
        }

        if(!gender.equals("")){
            patientinfo.setGender(gender);
        }
        if(!patientmarriage.equals("")){
            patientinfo.setPatientmarriage(patientmarriage);
        }
        if(outpatientid !=null){
            patientinfo.setOutpatientid(outpatientid);
        }
        if(hospitalizetionid !=null){
            patientinfo.setHospitalizetionid(hospitalizetionid);
        }
        if(departmentid !=null){
            patientinfo.setDepartmentid(departmentid);
        }
        if(bedid !=null){
            patientinfo.setBedid(bedid);
        }

        PageHelper.startPage(page,rows);
        List<Patientinfo> patientinfoList = sqlSession.selectList("com.equipments.management.mapper.PatientinfoMapper.getPatientinfoByAll",patientinfo);
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

    /**
     * 插入新患者记录
     * **/
    @RequestMapping("/insertNewPatientinfo")
    public void insertNewPatientinfo(HttpServletResponse response,
                                     @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                     @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        sqlSession = factory.openSession(true);
        Patientinfo patientinfo = new Patientinfo();

        //获得分页信息
        int count = sqlSession.selectOne("com.equipments.management.mapper.PatientinfoMapper.countById");
        int pageNumber = count/rows +1;
        PageHelper.startPage(pageNumber,rows);

        sqlSession.insert("com.equipments.management.mapper.PatientinfoMapper.addPatientinfo",patientinfo);
        List<Patientinfo> patientinfoList = sqlSession.selectList("com.equipments.management.mapper.PatientinfoMapper.getAllPatientinfos");
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
    /**
     * 更新Patientinfo
     * **/
    @RequestMapping("/updatePatientinfoByIds")
    public void updatePatientinfoByIds(HttpServletResponse response,
                                       @RequestParam("rowLists") String rowLists,
                                       @RequestParam("lengthRecords") Integer len,
                                       @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                       @RequestParam(value="pageSize",defaultValue = "10") Integer rows){

        JSONArray jsonArray = JSONArray.parseArray(rowLists);

        sqlSession = factory.openSession(true);

        int count = sqlSession.selectOne("com.equipments.management.mapper.PatientinfoMapper.countById");
        int pageNumber = count/rows +1;
        PageHelper.startPage(pageNumber,rows);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for(int i = 0;i < len;i++){
            Patientinfo patientinfo = new Patientinfo();
            com.alibaba.fastjson.JSONObject jUser = jsonArray.getJSONObject(i);

            patientinfo.setPatientno(jUser.getInteger("patientno"));
            patientinfo.setTreatno(jUser.getInteger("treatno"));
            patientinfo.setPatientname(jUser.getString("patientname"));
            patientinfo.setGender(jUser.getString("gender"));
            patientinfo.setAge(jUser.getInteger("age"));
            patientinfo.setPatientmarriage(jUser.getString("patientmarriage"));
            patientinfo.setOutpatientid(jUser.getInteger("outpatientid"));
            patientinfo.setHospitalizetionid(jUser.getInteger("hospitalizetionid"));
            patientinfo.setDepartmentid(jUser.getInteger("departmentid"));
            patientinfo.setBedid(jUser.getInteger("bedid"));
            patientinfo.setContactinfoaddr(jUser.getString("contactinfoaddr"));
            patientinfo.setContactinfotel(jUser.getString("contactinfotel"));
            patientinfo.setContactinfoemail(jUser.getString("contactinfoemail"));


            patientinfo.setAdvicedictor(jUser.getString("advicedictor"));
            patientinfo.setInforclinical(jUser.getString("inforclinical"));



            //jUser.getString("");
            sqlSession.update("com.equipments.management.mapper.PatientinfoMapper.updatePatientinfo",patientinfo);
        }
        List<Patientinfo> patientinfoList = sqlSession.selectList("com.equipments.management.mapper.PatientinfoMapper.getAllPatientinfos");
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
    //删除Patientinfo记录
    @RequestMapping("/delPatientinfoById")
    public void delPatientinfoById(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value="ids") Integer[] ids){
        sqlSession = factory.openSession(true);

        response.reset();
        response.setContentType("text/html;charset=UTF-8");
        //业务逻辑操作查询用户
        for(int i = 0;i<ids.length;i++){
            try {
                sqlSession.delete("com.equipments.management.mapper.PatientinfoMapper.removePatientinfoById",ids[i]);
                response.getWriter().print(true);
                sqlSession.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //获得医生列表
    @RequestMapping("/getStaffName")
    @ResponseBody
    public void getStaffName(HttpServletResponse response){

        sqlSession = factory.openSession(true);

        //获得分页信息
        List<Staff> staffList = sqlSession.selectList("com.equipments.management.mapper.StaffMapper.getAllStaff");
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.println(JSON.toJSONString(staffList, SerializerFeature.DisableCircularReferenceDetect));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }




    //测试
    @RequestMapping("/selectPathologyreviewAll")
    @ResponseBody
    public void selectPathologyreviewAll(HttpServletResponse response,
                                         @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                         @RequestParam(value="pageSize",defaultValue = "10") Integer rows
    ){

        sqlSession = factory.openSession(true);

        //获得分页信息
        List<Pathologydraw> docsproductList = sqlSession.selectList("com.equipments.management.mapper.PathologydrawMapper.getAllPathologydraws");
        int pageNumber = docsproductList.size()/rows +1;

        PageHelper.startPage(pageNumber,rows);

        sqlSession.close();


        PagedResult<Pathologydraw> pd = BeanUtil.toPagedResult(docsproductList);

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
    //getAllPatientinfoNames
    @RequestMapping("/getAllPatientinfoNames")
    @ResponseBody
    public void getAllPatientinfoNames(HttpServletResponse response,
                                      @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer rows
    ){

        sqlSession = factory.openSession(true);

        //获得分页信息
        List<String> stringList = sqlSession.selectList("com.equipments.management.mapper.PatientinfoMapper.getAllPatientinfoNames");
        int pageNumber = stringList.size()/rows +1;

        PageHelper.startPage(pageNumber,rows);

        sqlSession.close();


        PagedResult<String> pd = BeanUtil.toPagedResult(stringList);

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

    //测试
    @RequestMapping("/selectPatientinfoByNo")
    @ResponseBody
    public void selectPatientinfoByNo(HttpServletResponse response,
                                      @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                      @RequestParam(value="patientno",defaultValue = "0") String patientno
    ){

        sqlSession = factory.openSession(true);

        //获得分页信息
        List<Patientinfo001> patientinfo001List = sqlSession.selectList("com.equipments.management.mapper.PatientinfoMapper.getPatientinfoByPatientno",Integer.parseInt(patientno));
        int pageNumber = patientinfo001List.size()/rows +1;

        PageHelper.startPage(pageNumber,rows);

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

    //测试
    @RequestMapping("/selectAllDepartments")
    @ResponseBody
    public void selectDepartmentNames(HttpServletResponse response,
                                         @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                         @RequestParam(value="pageSize",defaultValue = "10") Integer rows
    ){

        sqlSession = factory.openSession(true);

        //获得分页信息
        List<Department> departmentList = sqlSession.selectList("com.equipments.management.mapper.DepartmentMapper.getAllDepartments");
        int pageNumber = departmentList.size()/rows +1;

        PageHelper.startPage(pageNumber,rows);

        sqlSession.close();


        PagedResult<Department> pd = BeanUtil.toPagedResult(departmentList);

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


    @RequestMapping("/selectAllInspmethods")
    @ResponseBody
    public void selectAllInspmethods(HttpServletResponse response,
                                      @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer rows
    ){

        sqlSession = factory.openSession(true);

        //获得分页信息
        List<Inspmethod> inspmethodList = sqlSession.selectList("com.equipments.management.mapper.InspmethodMapper.getAllInspmethods");
        int pageNumber = inspmethodList.size()/rows +1;

        PageHelper.startPage(pageNumber,rows);

        sqlSession.close();


        PagedResult<Inspmethod> pd = BeanUtil.toPagedResult(inspmethodList);

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
}
