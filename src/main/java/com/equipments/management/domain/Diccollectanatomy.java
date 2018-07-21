package com.equipments.management.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/2.
 */

public class Diccollectanatomy {
    private Integer collectno;
    private String collectname;
    private String collectdesc;

    public Integer getCollectno() {
        return collectno;
    }

    public void setCollectno(Integer collectno) {
        this.collectno = collectno;
    }

    public String getCollectname() {
        return collectname;
    }

    public void setCollectname(String collectname) {
        this.collectname = collectname;
    }

    public String getCollectdesc() {
        return collectdesc;
    }

    public void setCollectdesc(String collectdesc) {
        this.collectdesc = collectdesc;
    }

    @Override
    public String toString() {
        return "Diccollectanatomy{" +
                "collectno=" + collectno +
                ", collectname='" + collectname + '\'' +
                ", collectdesc='" + collectdesc + '\'' +
                '}';
    }

    public Diccollectanatomy(){}
}
