package com.equipments.management.domain.gradation;

import com.equipments.management.domain.Dicinspmethod;

import java.util.List;

/**
 * Created by Administrator on 2018/7/7.
 */
public class Inspmethod001 {
    private Integer inspmethodno;
    private Integer applino;

    private List<Dicinspmethod> dicinspmethodList;

    public Integer getInspmethodno() {
        return inspmethodno;
    }

    public void setInspmethodno(Integer inspmethodno) {
        this.inspmethodno = inspmethodno;
    }

    public Integer getApplino() {
        return applino;
    }

    public void setApplino(Integer applino) {
        this.applino = applino;
    }

    public List<Dicinspmethod> getDicinspmethodList() {
        return dicinspmethodList;
    }

    public void setDicinspmethodList(List<Dicinspmethod> dicinspmethodList) {
        this.dicinspmethodList = dicinspmethodList;
    }

    @Override
    public String toString() {
        return "Inspmethod001{" +
                "inspmethodno=" + inspmethodno +
                ", applino=" + applino +
                ", dicinspmethodList=" + dicinspmethodList +
                '}';
    }

    public Inspmethod001() {
    }
}
