package com.equipments.management.domain.query;

import com.equipments.management.domain.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */
public class Patientappliquery {
    private Integer applino;
    private Patientinfo patientinfo;
    private String inspunitname;
    private Department inspdepartid;
    private Staff inspdoctid;
    private String patientkind;//病人类别，包括：住院、门诊、急诊、体检、转院
    private String chargekind;//费别：医保、自费
    private Float chargenum;
    private String specimentkind;
    private String patientdiagkind;//病理检查类型：本院常规病理；快速冰冻；病理会诊；尸检
    private String diagnosisrecord;
    private Date applidate001;//申请时间
    private Date applidate002;//申请时间，002标识较大的时间


    //2018.06.30add
    private Date inspdate001;//送检日期
    private Date inspdate002;

    private String applisymptom;
    private String applisigns;
    private String otherdiagnosis;
    private String pathologyexamif;
    private Date cancerfounddate;
    private String cancerfoundplace;
    private String cancerfoundsize;
    private String transferif;
    private String transferplace;
    private String chemotherapyif;
    private Date cancernowdate;
    private String cancernowsize;
    private Integer menstrualcycle;
    private Integer menstrualduration;
    private Date lastmenstrualdate;
    private String cycletreatmentif;
    private Integer cycletreatmenttime;
    private Integer cycletreatmentdose;
    private Integer birthnum;
    private Integer productnum;
    private String contraceptionif;
    private String contraceptionmethod;
    private String iodinetreatmentif;
    private String thiouraciltreatmentif;
    private String labresult;
    private String surgeryseen;
    private String specialrequire;
    private Staff applidoctorid;//申请医师

    private String otherlookup;
    private String advicestatus;
    private Integer samplenum;
    private Staff acceptdoctorid;

    private Date acceptdate001;
    private Date acceptdate002;
    private String acceptresult;

    private List<Inspmethod> inspmethodList;
    private List<Collectanatomy> collectanatomyList;

    @Override
    public String toString() {
        return "Patientappliquery{" +
                "applino=" + applino +
                ", patientinfo=" + patientinfo +
                ", inspunitname='" + inspunitname + '\'' +
                ", inspdepartid=" + inspdepartid +
                ", inspdoctid=" + inspdoctid +
                ", patientkind='" + patientkind + '\'' +
                ", chargekind='" + chargekind + '\'' +
                ", chargenum=" + chargenum +
                ", specimentkind='" + specimentkind + '\'' +
                ", patientdiagkind='" + patientdiagkind + '\'' +
                ", diagnosisrecord='" + diagnosisrecord + '\'' +
                ", applidate001=" + applidate001 +
                ", applidate002=" + applidate002 +
                ", inspdate001=" + inspdate001 +
                ", inspdate002=" + inspdate002 +
                ", applisymptom='" + applisymptom + '\'' +
                ", applisigns='" + applisigns + '\'' +
                ", otherdiagnosis='" + otherdiagnosis + '\'' +
                ", pathologyexamif='" + pathologyexamif + '\'' +
                ", cancerfounddate=" + cancerfounddate +
                ", cancerfoundplace='" + cancerfoundplace + '\'' +
                ", cancerfoundsize='" + cancerfoundsize + '\'' +
                ", transferif='" + transferif + '\'' +
                ", transferplace='" + transferplace + '\'' +
                ", chemotherapyif='" + chemotherapyif + '\'' +
                ", cancernowdate=" + cancernowdate +
                ", cancernowsize='" + cancernowsize + '\'' +
                ", menstrualcycle=" + menstrualcycle +
                ", menstrualduration=" + menstrualduration +
                ", lastmenstrualdate=" + lastmenstrualdate +
                ", cycletreatmentif='" + cycletreatmentif + '\'' +
                ", cycletreatmenttime=" + cycletreatmenttime +
                ", cycletreatmentdose=" + cycletreatmentdose +
                ", birthnum=" + birthnum +
                ", productnum=" + productnum +
                ", contraceptionif='" + contraceptionif + '\'' +
                ", contraceptionmethod='" + contraceptionmethod + '\'' +
                ", iodinetreatmentif='" + iodinetreatmentif + '\'' +
                ", thiouraciltreatmentif='" + thiouraciltreatmentif + '\'' +
                ", labresult='" + labresult + '\'' +
                ", surgeryseen='" + surgeryseen + '\'' +
                ", specialrequire='" + specialrequire + '\'' +
                ", applidoctorid=" + applidoctorid +
                ", otherlookup='" + otherlookup + '\'' +
                ", advicestatus='" + advicestatus + '\'' +
                ", samplenum=" + samplenum +
                ", acceptdoctorid=" + acceptdoctorid +
                ", acceptdate001=" + acceptdate001 +
                ", acceptdate002=" + acceptdate002 +
                ", acceptresult='" + acceptresult + '\'' +
                ", inspmethodList=" + inspmethodList +
                ", collectanatomyList=" + collectanatomyList +
                '}';
    }

    public Integer getApplino() {
        return applino;
    }

    public void setApplino(Integer applino) {
        this.applino = applino;
    }

    public Patientinfo getPatientinfo() {
        return patientinfo;
    }

    public void setPatientinfo(Patientinfo patientinfo) {
        this.patientinfo = patientinfo;
    }

    public String getInspunitname() {
        return inspunitname;
    }

    public void setInspunitname(String inspunitname) {
        this.inspunitname = inspunitname;
    }

    public Department getInspdepartid() {
        return inspdepartid;
    }

    public void setInspdepartid(Department inspdepartid) {
        this.inspdepartid = inspdepartid;
    }

    public Staff getInspdoctid() {
        return inspdoctid;
    }

    public void setInspdoctid(Staff inspdoctid) {
        this.inspdoctid = inspdoctid;
    }

    public String getPatientkind() {
        return patientkind;
    }

    public void setPatientkind(String patientkind) {
        this.patientkind = patientkind;
    }

    public String getChargekind() {
        return chargekind;
    }

    public void setChargekind(String chargekind) {
        this.chargekind = chargekind;
    }

    public Float getChargenum() {
        return chargenum;
    }

    public void setChargenum(Float chargenum) {
        this.chargenum = chargenum;
    }

    public String getSpecimentkind() {
        return specimentkind;
    }

    public void setSpecimentkind(String specimentkind) {
        this.specimentkind = specimentkind;
    }

    public String getPatientdiagkind() {
        return patientdiagkind;
    }

    public void setPatientdiagkind(String patientdiagkind) {
        this.patientdiagkind = patientdiagkind;
    }

    public String getDiagnosisrecord() {
        return diagnosisrecord;
    }

    public void setDiagnosisrecord(String diagnosisrecord) {
        this.diagnosisrecord = diagnosisrecord;
    }

    public Date getApplidate001() {
        return applidate001;
    }

    public void setApplidate001(Date applidate001) {
        this.applidate001 = applidate001;
    }

    public Date getApplidate002() {
        return applidate002;
    }

    public void setApplidate002(Date applidate002) {
        this.applidate002 = applidate002;
    }



    public Date getInspdate001() {
        return inspdate001;
    }

    public void setInspdate001(Date inspdate001) {
        this.inspdate001 = inspdate001;
    }

    public Date getInspdate002() {
        return inspdate002;
    }

    public void setInspdate002(Date inspdate002) {
        this.inspdate002 = inspdate002;
    }



    public String getApplisymptom() {
        return applisymptom;
    }

    public void setApplisymptom(String applisymptom) {
        this.applisymptom = applisymptom;
    }

    public String getApplisigns() {
        return applisigns;
    }

    public void setApplisigns(String applisigns) {
        this.applisigns = applisigns;
    }

    public String getOtherdiagnosis() {
        return otherdiagnosis;
    }

    public void setOtherdiagnosis(String otherdiagnosis) {
        this.otherdiagnosis = otherdiagnosis;
    }

    public String getPathologyexamif() {
        return pathologyexamif;
    }

    public void setPathologyexamif(String pathologyexamif) {
        this.pathologyexamif = pathologyexamif;
    }

    public Date getCancerfounddate() {
        return cancerfounddate;
    }

    public void setCancerfounddate(Date cancerfounddate) {
        this.cancerfounddate = cancerfounddate;
    }

    public String getCancerfoundplace() {
        return cancerfoundplace;
    }

    public void setCancerfoundplace(String cancerfoundplace) {
        this.cancerfoundplace = cancerfoundplace;
    }

    public String getCancerfoundsize() {
        return cancerfoundsize;
    }

    public void setCancerfoundsize(String cancerfoundsize) {
        this.cancerfoundsize = cancerfoundsize;
    }

    public String getTransferif() {
        return transferif;
    }

    public void setTransferif(String transferif) {
        this.transferif = transferif;
    }

    public String getTransferplace() {
        return transferplace;
    }

    public void setTransferplace(String transferplace) {
        this.transferplace = transferplace;
    }

    public String getChemotherapyif() {
        return chemotherapyif;
    }

    public void setChemotherapyif(String chemotherapyif) {
        this.chemotherapyif = chemotherapyif;
    }

    public Date getCancernowdate() {
        return cancernowdate;
    }

    public void setCancernowdate(Date cancernowdate) {
        this.cancernowdate = cancernowdate;
    }

    public String getCancernowsize() {
        return cancernowsize;
    }

    public void setCancernowsize(String cancernowsize) {
        this.cancernowsize = cancernowsize;
    }

    public Integer getMenstrualcycle() {
        return menstrualcycle;
    }

    public void setMenstrualcycle(Integer menstrualcycle) {
        this.menstrualcycle = menstrualcycle;
    }

    public Integer getMenstrualduration() {
        return menstrualduration;
    }

    public void setMenstrualduration(Integer menstrualduration) {
        this.menstrualduration = menstrualduration;
    }

    public Date getLastmenstrualdate() {
        return lastmenstrualdate;
    }

    public void setLastmenstrualdate(Date lastmenstrualdate) {
        this.lastmenstrualdate = lastmenstrualdate;
    }

    public String getCycletreatmentif() {
        return cycletreatmentif;
    }

    public void setCycletreatmentif(String cycletreatmentif) {
        this.cycletreatmentif = cycletreatmentif;
    }

    public Integer getCycletreatmenttime() {
        return cycletreatmenttime;
    }

    public void setCycletreatmenttime(Integer cycletreatmenttime) {
        this.cycletreatmenttime = cycletreatmenttime;
    }

    public Integer getCycletreatmentdose() {
        return cycletreatmentdose;
    }

    public void setCycletreatmentdose(Integer cycletreatmentdose) {
        this.cycletreatmentdose = cycletreatmentdose;
    }

    public Integer getBirthnum() {
        return birthnum;
    }

    public void setBirthnum(Integer birthnum) {
        this.birthnum = birthnum;
    }

    public Integer getProductnum() {
        return productnum;
    }

    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    public String getContraceptionif() {
        return contraceptionif;
    }

    public void setContraceptionif(String contraceptionif) {
        this.contraceptionif = contraceptionif;
    }

    public String getContraceptionmethod() {
        return contraceptionmethod;
    }

    public void setContraceptionmethod(String contraceptionmethod) {
        this.contraceptionmethod = contraceptionmethod;
    }

    public String getIodinetreatmentif() {
        return iodinetreatmentif;
    }

    public void setIodinetreatmentif(String iodinetreatmentif) {
        this.iodinetreatmentif = iodinetreatmentif;
    }

    public String getThiouraciltreatmentif() {
        return thiouraciltreatmentif;
    }

    public void setThiouraciltreatmentif(String thiouraciltreatmentif) {
        this.thiouraciltreatmentif = thiouraciltreatmentif;
    }

    public String getLabresult() {
        return labresult;
    }

    public void setLabresult(String labresult) {
        this.labresult = labresult;
    }

    public String getSurgeryseen() {
        return surgeryseen;
    }

    public void setSurgeryseen(String surgeryseen) {
        this.surgeryseen = surgeryseen;
    }

    public String getSpecialrequire() {
        return specialrequire;
    }

    public void setSpecialrequire(String specialrequire) {
        this.specialrequire = specialrequire;
    }

    public Staff getApplidoctorid() {
        return applidoctorid;
    }

    public void setApplidoctorid(Staff applidoctorid) {
        this.applidoctorid = applidoctorid;
    }

    public String getOtherlookup() {
        return otherlookup;
    }

    public void setOtherlookup(String otherlookup) {
        this.otherlookup = otherlookup;
    }

    public String getAdvicestatus() {
        return advicestatus;
    }

    public void setAdvicestatus(String advicestatus) {
        this.advicestatus = advicestatus;
    }

    public Integer getSamplenum() {
        return samplenum;
    }

    public void setSamplenum(Integer samplenum) {
        this.samplenum = samplenum;
    }

    public Staff getAcceptdoctorid() {
        return acceptdoctorid;
    }

    public void setAcceptdoctorid(Staff acceptdoctorid) {
        this.acceptdoctorid = acceptdoctorid;
    }


    public Date getAcceptdate001() {
        return acceptdate001;
    }

    public void setAcceptdate001(Date acceptdate001) {
        this.acceptdate001 = acceptdate001;
    }

    public Date getAcceptdate002() {
        return acceptdate002;
    }

    public void setAcceptdate002(Date acceptdate002) {
        this.acceptdate002 = acceptdate002;
    }

    public String getAcceptresult() {
        return acceptresult;
    }

    public void setAcceptresult(String acceptresult) {
        this.acceptresult = acceptresult;
    }

    public List<Inspmethod> getInspmethodList() {
        return inspmethodList;
    }

    public void setInspmethodList(List<Inspmethod> inspmethodList) {
        this.inspmethodList = inspmethodList;
    }

    public List<Collectanatomy> getCollectanatomyList() {
        return collectanatomyList;
    }

    public void setCollectanatomyList(List<Collectanatomy> collectanatomyList) {
        this.collectanatomyList = collectanatomyList;
    }

    public Patientappliquery(){
    }
}
