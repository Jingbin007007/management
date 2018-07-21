package com.equipments.management.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/3.
 */

public class Drawphotodesc {
    private Integer photodescno;
    private Integer drawno;
    private String filepath;
    private String filedesc;

    public Drawphotodesc() {
    }

    @Override
    public String toString() {
        return "Drawphotodesc{" +
                "photodescno=" + photodescno +
                ", drawno=" + drawno +
                ", filepath='" + filepath + '\'' +
                ", filedesc='" + filedesc + '\'' +
                '}';
    }

    public Integer getPhotodescno() {
        return photodescno;
    }

    public void setPhotodescno(Integer photodescno) {
        this.photodescno = photodescno;
    }

    public Integer getDrawno() {
        return drawno;
    }

    public void setDrawno(Integer drawno) {
        this.drawno = drawno;
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
}
