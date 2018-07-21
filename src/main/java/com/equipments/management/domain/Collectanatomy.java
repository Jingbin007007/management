package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/2.
 */

public class Collectanatomy {
    private Integer collectanatomyno;
    private Integer applino;

    private Diccollectanatomy collectno;

    public Integer getCollectanatomyno() {
        return collectanatomyno;
    }

    public void setCollectanatomyno(Integer collectanatomyno) {
        this.collectanatomyno = collectanatomyno;
    }

    public Integer getApplino() {
        return applino;
    }

    public void setApplino(Integer applino) {
        this.applino = applino;
    }

    public Diccollectanatomy getCollectno() {
        return collectno;
    }

    public void setCollectno(Diccollectanatomy collectno) {
        this.collectno = collectno;
    }

    @Override
    public String toString() {
        return "Collectanatomy{" +
                "collectanatomyno=" + collectanatomyno +
                ", applino=" + applino +
                ", collectno=" + collectno +
                '}';
    }

    public Collectanatomy() {
    }
}
