package com.equipments.management.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.dao.KylinUtil;
import com.equipments.management.domain.Med;
import com.equipments.management.domain.Medquery;
import com.equipments.management.domain.Medsheng;
import com.equipments.management.domain.Medshengquery;
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
@RequestMapping("/shengyao")
public class EqshengyaoController {
    //添加日志器
    //private static final Logger logger = LoggerFactory.getLogger(EqController.class);
    private static SqlSession sqlSession;
    private static String statement;
    private static SqlSessionFactory factory;
    private static KylinUtil kylinUtil;

    protected final static String DATE_FORMATE = "yyyy-MM-dd";

    static{
        String resource = "mybatis-conf.xml";
        InputStream is = EqshengyaoController.class.getClassLoader().getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(is);

        try {
            kylinUtil = new KylinUtil();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EqshengyaoController(){
        super();
    }



    ///////////////////////////////////////////////
    //获得数据表Meds字典数据列一
    @RequestMapping("/getDistTongyongmingcheng")
    @ResponseBody
    public void getDistTongyongmingcheng(HttpServletResponse response,
                                         @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                         @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);



        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistTongyongmingcheng");
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



        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistYingwenming");
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



        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistLaiyuan");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistYuanliao");
        sqlSession.close();



        //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
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

        //PageHelper.startPage(page,rows);



        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistZhuangtai");
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
        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistLeibie001");
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
        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistLeibie002");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistLeibie003");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistGuanlileibie");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistChufangyao");
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
        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistChengfen");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistBiaozhunguidingguige");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistBiaozhunwaiguige");
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
        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistShiyongduixiang");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistYongtu");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistXianlianghuoxiuyao");
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

        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistPizhunshijian");
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
    //获得数据表Meds字典数据列十八
    @RequestMapping("/getDistBiaozhunyange")
    @ResponseBody
    public void getDistBiaozhunyange(HttpServletResponse response,
                                     @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                     @RequestParam(value="pageSize",defaultValue = "100") Integer rows
    ){
        sqlSession = factory.openSession(true);

        PageHelper.startPage(page,rows);
        List<String> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getDistBiaozhunyange");
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
                          @RequestParam(value="jianyanxiangmu",defaultValue = "") String jianyanxiangmu,
                          @RequestParam(value="pizhunriqi1",defaultValue = "") String pizhunriqi1,
                          @RequestParam(value="pizhunriqi2",defaultValue = "") String pizhunriqi2){

        sqlSession = factory.openSession(true);


        Medshengquery queryMedsheng = new Medshengquery();

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");

        if(!pizhunriqi1.equals("")){

            try {
                queryMedsheng.setPizhunriqi1(sdf1.parse(pizhunriqi1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!pizhunriqi2.equals("")){

            try {
                queryMedsheng.setPizhunriqi2(sdf2.parse(pizhunriqi2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(!beizhu.equals("")){
            queryMedsheng.setBeizhu(beizhu);
        }
        if(!biaozhunguidingguige.equals("")){
            queryMedsheng.setBiaozhunguidingguige(biaozhunguidingguige);
        }
        if(!biaozhunwaiguige.equals("")){
            queryMedsheng.setBiaozhunwaiguige(biaozhunwaiguige);
        }
        if(!biaozhunyange.equals("")){
            queryMedsheng.setBiaozhunyange(biaozhunyange);
        }
        if(!chengfen.equals("")){
            queryMedsheng.setChengfen(chengfen);
        }
        if(!chufangyao.equals("")){
            queryMedsheng.setChufangyao(chufangyao);
        }
        if(!guanlileibie.equals("")){
            queryMedsheng.setGuanlileibie(guanlileibie);
        }
        if(!laiyuan.equals("")){
            queryMedsheng.setLaiyuan(laiyuan);
        }
        if(!leibie001.equals("")){
            queryMedsheng.setLeibie001(leibie001);
        }
        if(!leibie002.equals("")){
            queryMedsheng.setLeibie002(leibie002);
        }
        if(!leibie003.equals("")){
            queryMedsheng.setLeibie003(leibie003);
        }
        if(!pizhunshijian.equals("")){
            queryMedsheng.setPizhunshijian(pizhunshijian);
        }
        if(!shiyongduixiang.equals("")){
            queryMedsheng.setShiyongduixiang(shiyongduixiang);
        }
        if(!tongyongmingcheng.equals("")){
            queryMedsheng.setTongyongmingcheng(tongyongmingcheng);
        }
        if(!xianlianghuoxiuyao.equals("")){
            queryMedsheng.setXianlianghuoxiuyao(xianlianghuoxiuyao);
        }
        if(!yingwenming.equals("")){
            queryMedsheng.setYingwenming(yingwenming);
        }
        if(!yongtu.equals("")){
            queryMedsheng.setYongtu(yongtu);
        }
        if(!yuanliao.equals("")){
            queryMedsheng.setYuanliao(yuanliao);
        }
        if(!zhuangtai.equals("")){
            queryMedsheng.setZhuangtai(zhuangtai);
        }
        //补充字段
        if(!shenbaodanwei.equals("")){
            queryMedsheng.setShenbaodanwei(shenbaodanwei);
        }
        if(!baocuntiaojian.equals("")){
            queryMedsheng.setBaocuntiaojian(baocuntiaojian);
        }
        if(!zhijileibie.equals("")){
            queryMedsheng.setZhijileibie(zhijileibie);
        }
        if(!fufangyufou.equals("")){
            queryMedsheng.setFufangyufou(fufangyufou);
        }
        if(!yuliu001.equals("")){
            queryMedsheng.setYuliu001(yuliu001);
        }
        if(!yuliu002.equals("")){
            queryMedsheng.setYuliu002(yuliu002);
        }
        if(!jinkouyuguochan.equals("")){
            queryMedsheng.setJinkouyuguochan(jinkouyuguochan);
        }
        if(!xiuyaoqi.equals("")){
            queryMedsheng.setXiuyaoqi(xiuyaoqi);
        }
        if(!jianyanxiangmu.equals("")){
            queryMedsheng.setJianyanxiangmu(jianyanxiangmu);
        }

        PageHelper.startPage(page,rows);
        List<Medsheng> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getMedByAll",queryMedsheng);
        sqlSession.close();

        PagedResult<Medsheng> pd = BeanUtil.toPagedResult(medList);

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
                sqlSession.delete("com.equipments.management.mapper.shengyaoMedMapper.removeMedById",ids[i]);
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

        int count = sqlSession.selectOne("com.equipments.management.mapper.shengyaoMedMapper.countById");
        int pageNumber = count/rows +1;
        PageHelper.startPage(pageNumber,rows);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0;i < len;i++){
            Medsheng med = new Medsheng() ;
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
            med.setJianyanxiangmu(jUser.getString("jianyanxiangmu"));
            //jUser.getString("");

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
            sqlSession.update("com.equipments.management.mapper.shengyaoMedMapper.updateMed",med);
        }
        List<Medsheng> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getMedByAll");
        sqlSession.close();
        PagedResult<Medsheng> pd = BeanUtil.toPagedResult(medList);

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
        Medsheng med = new Medsheng() ;

        //获得分页信息
        int count = sqlSession.selectOne("com.equipments.management.mapper.shengyaoMedMapper.countById");
        int pageNumber = count/rows +1;

        PageHelper.startPage(pageNumber,rows);

        sqlSession.insert("com.equipments.management.mapper.shengyaoMedMapper.addMed",med);
        List<Medsheng> medList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getMedByAll");
        sqlSession.close();


        PagedResult<Medsheng> pd = BeanUtil.toPagedResult(medList);

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
}
