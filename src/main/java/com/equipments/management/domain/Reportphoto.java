package com.equipments.management.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/3.
 */

public class Reportphoto {
    private Integer reportphotono;
    private Integer sampleno;
    private String filepath;
    private String filedesc;

    public Integer getReportphotono() {
        return reportphotono;
    }

    public void setReportphotono(Integer reportphotono) {
        this.reportphotono = reportphotono;
    }

    public Integer getSampleno() {
        return sampleno;
    }

    public void setSampleno(Integer sampleno) {
        this.sampleno = sampleno;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFiledesc() {
        return filedesc;
    }

    public void setFiledesc(String filedesc) {
        this.filedesc = filedesc;
    }

    @Override
    public String toString() {
        return "Reportphoto{" +
                "reportphotono=" + reportphotono +
                ", sampleno=" + sampleno +
                ", filepath='" + filepath + '\'' +
                ", filedesc='" + filedesc + '\'' +
                '}';
    }

    public Reportphoto() {
    }
}
