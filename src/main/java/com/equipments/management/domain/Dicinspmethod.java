package com.equipments.management.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/3.
 */

public class Dicinspmethod {
    private Integer dicinspmethodno;
    private String dicinspmethodname;
    private String dicinspmethoddesc;

    public Integer getDisinspmethodno() {
        return dicinspmethodno;
    }

    public void setDisinspmethodno(Integer dicinspmethodno) {
        this.dicinspmethodno = dicinspmethodno;
    }

    public String getDisinspmethodname() {
        return dicinspmethodname;
    }

    public void setDisinspmethodname(String dicinspmethodname) {
        this.dicinspmethodname = dicinspmethodname;
    }

    public String getDisinspmethoddesc() {
        return dicinspmethoddesc;
    }

    public void setDisinspmethoddesc(String dicinspmethoddesc) {
        this.dicinspmethoddesc = dicinspmethoddesc;
    }

    @Override
    public String toString() {
        return "Dicinspmethod{" +
                "dicinspmethodno=" + dicinspmethodno +
                ", dicinspmethodname='" + dicinspmethodname + '\'' +
                ", dicinspmethoddesc='" + dicinspmethoddesc + '\'' +
                '}';
    }

    public Dicinspmethod() {
    }
}
