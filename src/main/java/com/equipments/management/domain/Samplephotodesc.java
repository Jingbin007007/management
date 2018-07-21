package com.equipments.management.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/3.
 */

public class Samplephotodesc {
    private Integer photodescno;
    private Integer sampleno;
    private String filepath;
    private String filedesc;

    public Integer getPhotodescno() {
        return photodescno;
    }

    public void setPhotodescno(Integer photodescno) {
        this.photodescno = photodescno;
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
        return "Samplephotodesc{" +
                "photodescno=" + photodescno +
                ", sampleno=" + sampleno +
                ", filepath='" + filepath + '\'' +
                ", filedesc='" + filedesc + '\'' +
                '}';
    }

    public Samplephotodesc() {
    }
}
