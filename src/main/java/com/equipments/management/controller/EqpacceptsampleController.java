package com.equipments.management.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.equipments.management.domain.*;
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
@RequestMapping("/acceptsample")
public class EqpacceptsampleController {
    //添加日志器
    private static final Logger logger = LoggerFactory.getLogger(EqController.class);
    private static SqlSession sqlSession;
    private static SqlSessionFactory factory;

    protected final static String DATE_FORMATE = "yyyy-MM-dd";

    static{
        String resource = "mybatis-conf.xml";
        InputStream is = EqpacceptsampleController.class.getClassLoader().getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    public EqpacceptsampleController(){
        super();
    }


    @RequestMapping("/selectAcceptsample")
    @ResponseBody
    public void selectAcceptsample(HttpServletResponse response,
                          @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                          @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                          @RequestParam(value="patientname",defaultValue = "") String patientname,
                          @RequestParam(value="applino",defaultValue = "") String applino,
                          @RequestParam(value="specialrequire",defaultValue = "") String specialrequire,
                          @RequestParam(value="patientdiagkind",defaultValue = "") String patientdiagkind,
                          @RequestParam(value="sampleresult",defaultValue = "") String sampleresult){

        sqlSession = factory.openSession(true);

        Acceptsample acceptsample = new Acceptsample();

        //此处patientname相当于patientno

        if(!sampleresult.equals("")){
            acceptsample.setSampleresult(sampleresult);
        }

        PageHelper.startPage(page,rows);
        List<Acceptsample> acceptsampleList = sqlSession.selectList("com.equipments.management.mapper.AcceptsampleMapper.getAcceptsampleByAll",acceptsample);
        sqlSession.close();

        PagedResult<Acceptsample> pd = BeanUtil.toPagedResult(acceptsampleList);

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

    @RequestMapping("/selectAcceptsamplebyIds")
    @ResponseBody
    public void selectAcceptsamplebyIds(HttpServletResponse response,
                                   @RequestParam(value="pageNumber",defaultValue ="1") Integer page,
                                   @RequestParam(value="pageSize",defaultValue = "10") Integer rows,
                                        @RequestParam(value="ids") Integer[] ids){

        sqlSession = factory.openSession(true);


        PageHelper.startPage(page,rows);

        if(ids != null){
            List<Acceptsample> acceptsampleList = sqlSession.selectList("com.equipments.management.mapper.AcceptsampleMapper.selectByIds",ids);
            PagedResult<Acceptsample> pd = BeanUtil.toPagedResult(acceptsampleList);

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

    @RequestMapping("/updateAcceptsampleByIds")
    @ResponseBody
    public Map<String, Object> updateProductByIds(HttpServletResponse response,
                                                  @RequestParam(value="sampleno",defaultValue ="") String sampleno,
                                                  @RequestParam(value="sampledesc",defaultValue ="") String sampledesc,
                                                  @RequestParam(value="sampleresult",defaultValue ="") String sampleresult,
                                                  @RequestParam(value="advicekind",defaultValue ="") String advicekind,
                                                  @RequestParam(value="visualobservation",defaultValue ="") String visualobservation,
                                                  @RequestParam(value="deelresult",defaultValue ="") String deelresult,
                                                  @RequestParam(value="drawnum",defaultValue ="") String drawnum){

        sqlSession = factory.openSession(true);

        Acceptsample acceptsample = new Acceptsample();
        if(sampleno !=null && sampleno !=""){
            acceptsample.setSampleno(Integer.valueOf(sampleno));
        }
        if(sampledesc !=null){
            acceptsample.setSampledesc(sampledesc);
        }
        if(sampleresult !=null){
            acceptsample.setSampleresult(sampleresult);
        }
        if(advicekind !=null){
            acceptsample.setAdvicekind(advicekind);
        }
        if(visualobservation !=null){
            acceptsample.setVisualobservation(visualobservation);
        }
        if(deelresult !=null){
            acceptsample.setDeelresult(deelresult);
        }
        if(drawnum !=null && drawnum !=""){
            acceptsample.setDrawnum(Integer.valueOf(drawnum));
        }

        Map<String, Object> json = new HashMap<String, Object>();

        sqlSession.update("com.equipments.management.mapper.AcceptsampleMapper.updateAcceptsample",acceptsample);
        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        try{
            json.put("success",acceptsample);

        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }
    //删除Product记录
    @RequestMapping("/delAcceptsampleById")
    public void delProductById(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam(value="ids") Integer[] ids){
        sqlSession = factory.openSession(true);

        response.reset();
        response.setContentType("text/html;charset=UTF-8");
        //业务逻辑操作查询用户
        for(int i = 0;i<ids.length;i++){
            try {
                sqlSession.delete("com.equipments.management.mapper.AcceptsampleMapper.removeAcceptsampleById",ids[i]);
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
        Acceptsample acceptsample = new Acceptsample();

        //获得分页信息
        int count = sqlSession.selectOne("com.equipments.management.mapper.AcceptsampleMapper.countById");
        int pageNumber = count/rows +1;

        PageHelper.startPage(pageNumber,rows);

        sqlSession.insert("com.equipments.management.mapper.AcceptsampleMapper.addAcceptsample",acceptsample);
        List<Acceptsample> acceptsampleList = sqlSession.selectList("com.equipments.management.mapper.AcceptsampleMapper.getAllAcceptsamples");
        sqlSession.close();


        PagedResult<Acceptsample> pd = BeanUtil.toPagedResult(acceptsampleList);

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
     * insertSamplePhoto
     * **/
    @RequestMapping("/insertSamplePhoto")
    @ResponseBody
    public Map<String, Object> insertSamplePhoto(HttpServletResponse response,
                                  @RequestParam("sampleno") String sampleno,
                                  @RequestParam("filepath") String filepath,
                                  @RequestParam("filedesc") String filedesc
                                  ){

        sqlSession = factory.openSession(true);
        Samplephotodesc samplephotodesc = new Samplephotodesc();

        Map<String, Object> json = new HashMap<String, Object>();

        if(filedesc !=null){
            samplephotodesc.setFiledesc(filedesc);
        }
        if(filepath !=null){
            samplephotodesc.setFilepath(filepath);
        }
        if(sampleno !=null){
            samplephotodesc.setSampleno(Integer.valueOf(sampleno));
        }

        sqlSession.insert("com.equipments.management.mapper.SamplephotodescMapper.addSamplephotodesc",samplephotodesc);

        response.setContentType("text/html;charset=UTF-8");

        try{
            json.put("success", samplephotodesc);
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
