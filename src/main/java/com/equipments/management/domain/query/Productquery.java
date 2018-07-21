package com.equipments.management.domain.query;

import com.equipments.management.domain.Pathologydraw;
import com.equipments.management.domain.Patientinfo;
import com.equipments.management.domain.Staff;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/20.
 */
public class Productquery {
    private Integer productno;
    private Pathologydraw drawno;
    private String productdesc;
    private String productstatus;
    private Staff productdoctorid;
    private String resultkind;
    private Date productdate;
    private String productnote;

    private Date productdate001;
    private Date productdate002;

    public String getProductnote() {
        return productnote;
    }

    public void setProductnote(String productnote) {
        this.productnote = productnote;
    }

    public Integer getProductno() {
        return productno;
    }

    public void setProductno(Integer productno) {
        this.productno = productno;
    }

    public Pathologydraw getDrawno() {
        return drawno;
    }

    public void setDrawno(Pathologydraw drawno) {
        this.drawno = drawno;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    public Staff getProductdoctorid() {
        return productdoctorid;
    }

    public void setProductdoctorid(Staff productdoctorid) {
        this.productdoctorid = productdoctorid;
    }

    public String getResultkind() {
        return resultkind;
    }

    public void setResultkind(String resultkind) {
        this.resultkind = resultkind;
    }

    public Date getProductdate() {
        return productdate;
    }

    public void setProductdate(Date productdate) {
        this.productdate = productdate;
    }

    public Date getProductdate001() {
        return productdate001;
    }

    public void setProductdate001(Date productdate001) {
        this.productdate001 = productdate001;
    }

    public Date getProductdate002() {
        return productdate002;
    }

    public void setProductdate002(Date productdate002) {
        this.productdate002 = productdate002;
    }

    @Override
    public String toString() {
        return "Productquery{" +
                "productno=" + productno +
                ", drawno=" + drawno +
                ", productdesc='" + productdesc + '\'' +
                ", productstatus='" + productstatus + '\'' +
                ", productdoctorid=" + productdoctorid +
                ", resultkind='" + resultkind + '\'' +
                ", productdate=" + productdate +
                ", productnote='" + productnote + '\'' +
                ", productdate001=" + productdate001 +
                ", productdate002=" + productdate002 +
                '}';
    }

    public Productquery(){}
}
