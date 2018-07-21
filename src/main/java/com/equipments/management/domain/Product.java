package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/28.
 */

public class Product {
    private Integer productno;

    private Pathologydraw drawno;
    private String productdesc;
    private String productstatus;

    private Staff productdoctorid;
    private String resultkind;
    private Date productdate;
    private String productnote;

    //2018.7.5add
    private String productfile;
    private String thumbnailfile;

    private Staff scandoctorid;
    private Date scandate;

    private String productrequire;
    private String storeposition;
    private String productquality;
    private String unlawreason;
    private String productadvice;

    public String getProductrequire() {
        return productrequire;
    }

    public void setProductrequire(String productrequire) {
        this.productrequire = productrequire;
    }

    public String getStoreposition() {
        return storeposition;
    }

    public void setStoreposition(String storeposition) {
        this.storeposition = storeposition;
    }

    public String getProductquality() {
        return productquality;
    }

    public void setProductquality(String productquality) {
        this.productquality = productquality;
    }

    public String getUnlawreason() {
        return unlawreason;
    }

    public void setUnlawreason(String unlawreason) {
        this.unlawreason = unlawreason;
    }

    public String getProductadvice() {
        return productadvice;
    }

    public void setProductadvice(String productadvice) {
        this.productadvice = productadvice;
    }

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

    public String getProductfile() {
        return productfile;
    }

    public void setProductfile(String productfile) {
        this.productfile = productfile;
    }

    public String getThumbnailfile() {
        return thumbnailfile;
    }

    public void setThumbnailfile(String thumbnailfile) {
        this.thumbnailfile = thumbnailfile;
    }

    public Staff getScandoctorid() {
        return scandoctorid;
    }

    public void setScandoctorid(Staff scandoctorid) {
        this.scandoctorid = scandoctorid;
    }

    public Date getScandate() {
        return scandate;
    }

    public void setScandate(Date scandate) {
        this.scandate = scandate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productno=" + productno +
                ", drawno=" + drawno +
                ", productdesc='" + productdesc + '\'' +
                ", productstatus='" + productstatus + '\'' +
                ", productdoctorid=" + productdoctorid +
                ", resultkind='" + resultkind + '\'' +
                ", productdate=" + productdate +
                ", productnote='" + productnote + '\'' +
                ", productfile='" + productfile + '\'' +
                ", thumbnailfile='" + thumbnailfile + '\'' +
                ", scandoctorid=" + scandoctorid +
                ", scandate=" + scandate +
                ", productrequire='" + productrequire + '\'' +
                ", storeposition='" + storeposition + '\'' +
                ", productquality='" + productquality + '\'' +
                ", unlawreason='" + unlawreason + '\'' +
                ", productadvice='" + productadvice + '\'' +
                '}';
    }

    public Product() {
    }
}
