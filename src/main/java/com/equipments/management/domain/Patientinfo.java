package com.equipments.management.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/19.
 */

public class Patientinfo {
    private Integer patientno;
    private Integer treatno;
    private String patientname;
    private String gender;
    private Integer age;
    private String patientmarriage;
    private Integer outpatientid;
    private Integer hospitalizetionid;
    private Integer departmentid;
    private Integer bedid;
    private String contactinfoaddr;
    private String contactinfotel;
    private String contactinfoemail;

    private String advicedictor;
    private String inforclinical;

    //2018-6-30 add
    private String ethnic;
    private String career;
    private String identinumber;
    private String source;
    private String ward;
    private String contactinfoaddrprovince;
    private String contactinfoaddrcity;
    private String contactinfoaddrdistinct;

    public Integer getPatientno() {
        return patientno;
    }

    public void setPatientno(Integer patientno) {
        this.patientno = patientno;
    }

    public Integer getTreatno() {
        return treatno;
    }

    public void setTreatno(Integer treatno) {
        this.treatno = treatno;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPatientmarriage() {
        return patientmarriage;
    }

    public void setPatientmarriage(String patientmarriage) {
        this.patientmarriage = patientmarriage;
    }

    public Integer getOutpatientid() {
        return outpatientid;
    }

    public void setOutpatientid(Integer outpatientid) {
        this.outpatientid = outpatientid;
    }

    public Integer getHospitalizetionid() {
        return hospitalizetionid;
    }

    public void setHospitalizetionid(Integer hospitalizetionid) {
        this.hospitalizetionid = hospitalizetionid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getBedid() {
        return bedid;
    }

    public void setBedid(Integer bedid) {
        this.bedid = bedid;
    }

    public String getContactinfoaddr() {
        return contactinfoaddr;
    }

    public void setContactinfoaddr(String contactinfoaddr) {
        this.contactinfoaddr = contactinfoaddr;
    }

    public String getContactinfotel() {
        return contactinfotel;
    }

    public void setContactinfotel(String contactinfotel) {
        this.contactinfotel = contactinfotel;
    }

    public String getContactinfoemail() {
        return contactinfoemail;
    }

    public void setContactinfoemail(String contactinfoemail) {
        this.contactinfoemail = contactinfoemail;
    }


    public String getAdvicedictor() {
        return advicedictor;
    }

    public void setAdvicedictor(String advicedictor) {
        this.advicedictor = advicedictor;
    }

    public String getInforclinical() {
        return inforclinical;
    }

    public void setInforclinical(String inforclinical) {
        this.inforclinical = inforclinical;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getIdentinumber() {
        return identinumber;
    }

    public void setIdentinumber(String identinumber) {
        this.identinumber = identinumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getContactinfoaddrprovince() {
        return contactinfoaddrprovince;
    }

    public void setContactinfoaddrprovince(String contactinfoaddrprovince) {
        this.contactinfoaddrprovince = contactinfoaddrprovince;
    }

    public String getContactinfoaddrcity() {
        return contactinfoaddrcity;
    }

    public void setContactinfoaddrcity(String contactinfoaddrcity) {
        this.contactinfoaddrcity = contactinfoaddrcity;
    }

    public String getContactinfoaddrdistinct() {
        return contactinfoaddrdistinct;
    }

    public void setContactinfoaddrdistinct(String contactinfoaddrdistinct) {
        this.contactinfoaddrdistinct = contactinfoaddrdistinct;
    }

    @Override
    public String toString() {
        return "Patientinfo{" +
                "patientno=" + patientno +
                ", treatno=" + treatno +
                ", patientname='" + patientname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", patientmarriage='" + patientmarriage + '\'' +
                ", outpatientid=" + outpatientid +
                ", hospitalizetionid=" + hospitalizetionid +
                ", departmentid=" + departmentid +
                ", bedid=" + bedid +
                ", contactinfoaddr='" + contactinfoaddr + '\'' +
                ", contactinfotel='" + contactinfotel + '\'' +
                ", contactinfoemail='" + contactinfoemail + '\'' +
                ", advicedictor='" + advicedictor + '\'' +
                ", inforclinical='" + inforclinical + '\'' +
                ", ethnic='" + ethnic + '\'' +
                ", career='" + career + '\'' +
                ", identinumber='" + identinumber + '\'' +
                ", source='" + source + '\'' +
                ", ward='" + ward + '\'' +
                ", contactinfoaddrprovince='" + contactinfoaddrprovince + '\'' +
                ", contactinfoaddrcity='" + contactinfoaddrcity + '\'' +
                ", contactinfoaddrdistinct='" + contactinfoaddrdistinct + '\'' +
                '}';
    }
    public Patientinfo(){}
}
