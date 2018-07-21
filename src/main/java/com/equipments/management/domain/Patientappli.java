package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */

public class Patientappli {
    private Integer applino;

    private Patientinfo patientinfo;
    private String inspunitname;

    private Department inspdepartid;

    private Staff inspdoctid;
    private String patientkind;
    private String chargekind;
    private Float chargenum;
    private String specimentkind;
    private String patientdiagkind;
    private String diagnosisrecord;
    private Date applidate;

    //2018.06.30add
    private Date inspdate;
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

    private Staff applidoctorid;

    private String otherlookup;
    private String advicestatus;
    private Integer samplenum;

    private Staff acceptdoctorid;
    private Date acceptdate;
    private String acceptresult;

    private String inspmethodlist;

    private List<Inspmethod> inspmethodList;

    private List<Collectanatomy> collectanatomyList;

    //2018.7.7add
    private Integer drawnum;
    private Integer productsnum;

    public Integer getDrawnum() {
        return drawnum;
    }

    public void setDrawnum(Integer drawnum) {
        this.drawnum = drawnum;
    }

    public Integer getProductsnum() {
        return productsnum;
    }

    public void setProductsnum(Integer productsnum) {
        this.productsnum = productsnum;
    }

    public String getInspmethodlist() {
        return inspmethodlist;
    }

    public void setInspmethodlist(String inspmethodlist) {
        this.inspmethodlist = inspmethodlist;
    }

    @Override
    public String toString() {
        return "Patientappli{" +
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
                ", applidate=" + applidate +
                ", inspdate=" + inspdate +
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
                ", acceptdate=" + acceptdate +
                ", acceptresult='" + acceptresult + '\'' +
                ", inspmethodlist='" + inspmethodlist + '\'' +
                ", inspmethodList=" + inspmethodList +
                ", collectanatomyList=" + collectanatomyList +
                ", drawnum=" + drawnum +
                ", productsnum=" + productsnum +
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

    public Date getApplidate() {
        return applidate;
    }

    public void setApplidate(Date applidate) {
        this.applidate = applidate;
    }

    public Date getInspdate() {
        return inspdate;
    }

    public void setInspdate(Date inspdate) {
        this.inspdate = inspdate;
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

    public Date getAcceptdate() {
        return acceptdate;
    }

    public void setAcceptdate(Date acceptdate) {
        this.acceptdate = acceptdate;
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

    public Patientappli(){
    }
}
