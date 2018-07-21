package com.equipments.management.domain.gradation;

import com.equipments.management.domain.Acceptsample;
import com.equipments.management.domain.Drawphotodesc;
import com.equipments.management.domain.Staff;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/7.
 */
public class Pathologydraw001 {
    private Integer drawno;

    private String drawdesc;
    private String drawposition;
    private String drawkind;
    private Date drawdate;
    private Integer productnum;
    private String drawnote;

    private List<Drawphotodesc> drawphotodescList;
    private List<Product001> product001List;
    private Staff drawdoctorid;

    @Override
    public String toString() {
        return "Pathologydraw001{" +
                "drawno=" + drawno +
                ", drawdesc='" + drawdesc + '\'' +
                ", drawposition='" + drawposition + '\'' +
                ", drawkind='" + drawkind + '\'' +
                ", drawdate=" + drawdate +
                ", productnum=" + productnum +
                ", drawnote='" + drawnote + '\'' +
                ", drawphotodescList=" + drawphotodescList +
                ", product001List=" + product001List +
                ", drawdoctorid=" + drawdoctorid +
                '}';
    }

    public String getDrawnote() {
        return drawnote;
    }

    public void setDrawnote(String drawnote) {
        this.drawnote = drawnote;
    }

    public List<Product001> getProduct001List() {
        return product001List;
    }

    public void setProduct001List(List<Product001> product001List) {
        this.product001List = product001List;
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

    public Pathologydraw001(){}
}
