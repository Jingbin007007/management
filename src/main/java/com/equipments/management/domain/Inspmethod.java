package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/3.
 */

public class Inspmethod {
    private Integer inspmethodno;
    private Integer applino;

    private Dicinspmethod dicinspmethodno;

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

    public Dicinspmethod getDicinspmethodno() {
        return dicinspmethodno;
    }

    public void setDicinspmethodno(Dicinspmethod dicinspmethodno) {
        this.dicinspmethodno = dicinspmethodno;
    }

    @Override
    public String toString() {
        return "Inspmethod{" +
                "inspmethodno=" + inspmethodno +
                ", applino=" + applino +
                ", dicinspmethodno=" + dicinspmethodno +
                '}';
    }

    public Inspmethod() {
    }
}
