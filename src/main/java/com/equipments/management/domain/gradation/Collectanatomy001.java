package com.equipments.management.domain.gradation;

import com.equipments.management.domain.Diccollectanatomy;

import java.util.List;

/**
 * Created by Administrator on 2018/7/7.
 */
public class Collectanatomy001 {
    private Integer collectanatomyno;
    private Integer applino;

    private List<Diccollectanatomy> diccollectanatomyList;

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

    public List<Diccollectanatomy> getDiccollectanatomyList() {
        return diccollectanatomyList;
    }

    public void setDiccollectanatomyList(List<Diccollectanatomy> diccollectanatomyList) {
        this.diccollectanatomyList = diccollectanatomyList;
    }

    @Override
    public String toString() {
        return "Collectanatomy001{" +
                "collectanatomyno=" + collectanatomyno +
                ", applino=" + applino +
                ", diccollectanatomyList=" + diccollectanatomyList +
                '}';
    }

    public Collectanatomy001() {
    }
}
