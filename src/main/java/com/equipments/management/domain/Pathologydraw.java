package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/20.
 */

public class Pathologydraw {
    private Integer drawno;

    private Acceptsample sampleno;
    private String drawdesc;
    private String drawposition;
    private Staff drawdoctorid;
    private String drawkind;
    private Date drawdate;
    private Integer productnum;
    private String drawnote;

    private List<Drawphotodesc> drawphotodescList;

    @Override
    public String toString() {
        return "Pathologydraw{" +
                "drawno=" + drawno +
                ", sampleno=" + sampleno +
                ", drawdesc='" + drawdesc + '\'' +
                ", drawposition='" + drawposition + '\'' +
                ", drawdoctorid=" + drawdoctorid +
                ", drawkind='" + drawkind + '\'' +
                ", drawdate=" + drawdate +
                ", productnum=" + productnum +
                ", drawnote='" + drawnote + '\'' +
                ", drawphotodescList=" + drawphotodescList +
                '}';
    }

    public String getDrawnote() {
        return drawnote;
    }

    public void setDrawnote(String drawnote) {
        this.drawnote = drawnote;
    }

    public Integer getProductnum() {
        return productnum;
    }

    public void setProductnum(Integer productnum) {
        this.productnum = productnum;
    }

    public List<Drawphotodesc> getDrawphotodescList() {
        return drawphotodescList;
    }

    public void setDrawphotodescList(List<Drawphotodesc> drawphotodescList) {
        this.drawphotodescList = drawphotodescList;
    }

    public Integer getDrawno() {
        return drawno;
    }

    public void setDrawno(Integer drawno) {
        this.drawno = drawno;
    }

    public Acceptsample getSampleno() {
        return sampleno;
    }

    public void setSampleno(Acceptsample sampleno) {
        this.sampleno = sampleno;
    }

    public String getDrawdesc() {
        return drawdesc;
    }

    public void setDrawdesc(String drawdesc) {
        this.drawdesc = drawdesc;
    }

    public String getDrawposition() {
        return drawposition;
    }

    public void setDrawposition(String drawposition) {
        this.drawposition = drawposition;
    }

    public Staff getDrawdoctorid() {
        return drawdoctorid;
    }

    public void setDrawdoctorid(Staff drawdoctorid) {
        this.drawdoctorid = drawdoctorid;
    }

    public String getDrawkind() {
        return drawkind;
    }

    public void setDrawkind(String drawkind) {
        this.drawkind = drawkind;
    }

    public Date getDrawdate() {
        return drawdate;
    }

    public void setDrawdate(Date drawdate) {
        this.drawdate = drawdate;
    }

    public Pathologydraw(){}
}
