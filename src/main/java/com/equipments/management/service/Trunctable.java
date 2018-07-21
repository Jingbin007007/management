package com.equipments.management.service;

import com.equipments.management.domain.Med;
import com.equipments.management.domain.Medquery;
import com.equipments.management.domain.Medsheng;
import com.equipments.management.domain.Medshengquery;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 */
public class Trunctable {
    public static List<Medsheng>  deelwithTempTable(Integer page, Integer rows, String baohancanshu, String laiyuan, SqlSession sqlSession){
        //sqlSession.delete("com.equipments.management.mapper.tempyaoMedMapper.removeAllMed");

        Medquery med = new Medquery();
        Medshengquery medsheng = new Medshengquery();

        med.setZhuangtai(baohancanshu);
        med.setYuanliao(baohancanshu);
        med.setYongtu(baohancanshu);
        med.setYingwenming(baohancanshu);
        med.setXianlianghuoxiuyao(baohancanshu);
        med.setShiyongduixiang(baohancanshu);
        med.setPizhunshijian(baohancanshu);
        med.setLeibie003(baohancanshu);
        med.setLeibie001(baohancanshu);
        med.setLaiyuan(baohancanshu);
        med.setTongyongmingcheng(baohancanshu);
        med.setBaocuntiaojian(baohancanshu);
        med.setBeizhu(baohancanshu);
        med.setBiaozhunguidingguige(baohancanshu);
        med.setBiaozhunwaiguige(baohancanshu);
        med.setBiaozhunyange(baohancanshu);
        med.setChengfen(baohancanshu);
        med.setChufangyao(baohancanshu);
        med.setFufangyufou(baohancanshu);
        med.setGuanlileibie(baohancanshu);
        med.setJinkouyuguochan(baohancanshu);
        med.setLeibie002(baohancanshu);
        med.setShenbaodanwei(baohancanshu);
        med.setXiuyaoqi(baohancanshu);
        med.setYuliu001(baohancanshu);
        med.setYuliu002(baohancanshu);
        med.setZhijileibie(baohancanshu);

        medsheng.setZhuangtai(baohancanshu);
        medsheng.setYuanliao(baohancanshu);
        medsheng.setYongtu(baohancanshu);
        medsheng.setYingwenming(baohancanshu);
        medsheng.setXianlianghuoxiuyao(baohancanshu);
        medsheng.setShiyongduixiang(baohancanshu);
        medsheng.setPizhunshijian(baohancanshu);
        medsheng.setLeibie003(baohancanshu);
        medsheng.setLeibie001(baohancanshu);
        medsheng.setLaiyuan(baohancanshu);
        medsheng.setTongyongmingcheng(baohancanshu);
        medsheng.setBaocuntiaojian(baohancanshu);
        medsheng.setBeizhu(baohancanshu);
        medsheng.setBiaozhunguidingguige(baohancanshu);
        medsheng.setBiaozhunwaiguige(baohancanshu);
        medsheng.setBiaozhunyange(baohancanshu);
        medsheng.setChengfen(baohancanshu);
        medsheng.setChufangyao(baohancanshu);
        medsheng.setFufangyufou(baohancanshu);
        medsheng.setGuanlileibie(baohancanshu);
        medsheng.setJinkouyuguochan(baohancanshu);
        medsheng.setLeibie002(baohancanshu);
        medsheng.setShenbaodanwei(baohancanshu);
        medsheng.setXiuyaoqi(baohancanshu);
        medsheng.setYuliu001(baohancanshu);
        medsheng.setYuliu002(baohancanshu);
        medsheng.setZhijileibie(baohancanshu);
        medsheng.setJianyanxiangmu(baohancanshu);

        List<Med> medList = sqlSession.selectList("com.equipments.management.mapper.MedMapper.getMedByAllOr",med);
        List<Med> zhongmedList = sqlSession.selectList("com.equipments.management.mapper.zhongyaoMedMapper.getMedByAllOr",med);
        List<Medsheng> shengmedList = sqlSession.selectList("com.equipments.management.mapper.shengyaoMedMapper.getMedByAllOr",medsheng);

        for(Med temp:medList){
            Medsheng tempshengMed = new Medsheng();

            tempshengMed.setId(temp.getId());
            tempshengMed.setZhuangtai(temp.getZhuangtai());
            tempshengMed.setYuanliao(temp.getYuanliao());
            tempshengMed.setYongtu(temp.getYongtu());
            tempshengMed.setYingwenming(temp.getYingwenming());
            tempshengMed.setXianlianghuoxiuyao(temp.getXianlianghuoxiuyao());
            tempshengMed.setShiyongduixiang(temp.getShiyongduixiang());
            tempshengMed.setPizhunshijian(temp.getPizhunshijian());
            tempshengMed.setLeibie003(temp.getLeibie003());
            tempshengMed.setLeibie001(temp.getLeibie001());
            tempshengMed.setLaiyuan(temp.getLaiyuan());
            tempshengMed.setTongyongmingcheng(temp.getTongyongmingcheng());
            tempshengMed.setBaocuntiaojian(temp.getBaocuntiaojian());
            tempshengMed.setBeizhu(temp.getBeizhu());
            tempshengMed.setBiaozhunguidingguige(temp.getBiaozhunguidingguige());
            tempshengMed.setBiaozhunwaiguige(temp.getBiaozhunwaiguige());
            tempshengMed.setBiaozhunyange(temp.getBiaozhunyange());
            tempshengMed.setChengfen(temp.getChengfen());
            tempshengMed.setChufangyao(temp.getChufangyao());
            tempshengMed.setFufangyufou(temp.getFufangyufou());
            tempshengMed.setGuanlileibie(temp.getGuanlileibie());
            tempshengMed.setJinkouyuguochan(temp.getJinkouyuguochan());
            tempshengMed.setLeibie002(temp.getLeibie002());
            tempshengMed.setShenbaodanwei(temp.getShenbaodanwei());
            tempshengMed.setXiuyaoqi(temp.getXiuyaoqi());
            tempshengMed.setYuliu001(temp.getYuliu001());
            tempshengMed.setYuliu002(temp.getYuliu002());
            tempshengMed.setZhijileibie(temp.getZhijileibie());
            tempshengMed.setPdfpath(temp.getPdfpath());
            shengmedList.add(tempshengMed);
        }

        for(Med temp:zhongmedList){
            Medsheng tempshengMed = new Medsheng();

            tempshengMed.setId(temp.getId());
            tempshengMed.setZhuangtai(temp.getZhuangtai());
            tempshengMed.setYuanliao(temp.getYuanliao());
            tempshengMed.setYongtu(temp.getYongtu());
            tempshengMed.setYingwenming(temp.getYingwenming());
            tempshengMed.setXianlianghuoxiuyao(temp.getXianlianghuoxiuyao());
            tempshengMed.setShiyongduixiang(temp.getShiyongduixiang());
            tempshengMed.setPizhunshijian(temp.getPizhunshijian());
            tempshengMed.setLeibie003(temp.getLeibie003());
            tempshengMed.setLeibie001(temp.getLeibie001());
            tempshengMed.setLaiyuan(temp.getLaiyuan());
            tempshengMed.setTongyongmingcheng(temp.getTongyongmingcheng());
            tempshengMed.setBaocuntiaojian(temp.getBaocuntiaojian());
            tempshengMed.setBeizhu(temp.getBeizhu());
            tempshengMed.setBiaozhunguidingguige(temp.getBiaozhunguidingguige());
            tempshengMed.setBiaozhunwaiguige(temp.getBiaozhunwaiguige());
            tempshengMed.setBiaozhunyange(temp.getBiaozhunyange());
            tempshengMed.setChengfen(temp.getChengfen());
            tempshengMed.setChufangyao(temp.getChufangyao());
            tempshengMed.setFufangyufou(temp.getFufangyufou());
            tempshengMed.setGuanlileibie(temp.getGuanlileibie());
            tempshengMed.setJinkouyuguochan(temp.getJinkouyuguochan());
            tempshengMed.setLeibie002(temp.getLeibie002());
            tempshengMed.setShenbaodanwei(temp.getShenbaodanwei());
            tempshengMed.setXiuyaoqi(temp.getXiuyaoqi());
            tempshengMed.setYuliu001(temp.getYuliu001());
            tempshengMed.setYuliu002(temp.getYuliu002());
            tempshengMed.setZhijileibie(temp.getZhijileibie());
            tempshengMed.setPdfpath(temp.getPdfpath());
            shengmedList.add(tempshengMed);
        }

        return shengmedList;
    }
}
