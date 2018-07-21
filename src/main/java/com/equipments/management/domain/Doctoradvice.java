package com.equipments.management.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/3.
 */

public class Doctoradvice {
    private Integer adviceno;

    private Pathologydiagnosis diagnosisno;
    private String advicekind;
    private String adviceprogram;
    private String advicecontent;
    private String advicenote;
    private Integer advicenum;


    public Doctoradvice() {
    }

    @Override
    public String toString() {
        return "Doctoradvice{" +
                "adviceno=" + adviceno +
                ", diagnosisno=" + diagnosisno +
                ", advicekind='" + advicekind + '\'' +
                ", adviceprogram='" + adviceprogram + '\'' +
                ", advicecontent='" + advicecontent + '\'' +
                ", advicenote='" + advicenote + '\'' +
                ", advicenum=" + advicenum +
                '}';
    }

    public Integer getAdviceno() {
        return adviceno;
    }

    public void setAdviceno(Integer adviceno) {
        this.adviceno = adviceno;
    }

    public Pathologydiagnosis getDiagnosisno() {
        return diagnosisno;
    }

    public void setDiagnosisno(Pathologydiagnosis diagnosisno) {
        this.diagnosisno = diagnosisno;
    }

    public String getAdvicekind() {
        return advicekind;
    }

    public void setAdvicekind(String advicekind) {
        this.advicekind = advicekind;
    }

    public String getAdviceprogram() {
        return adviceprogram;
    }

    public void setAdviceprogram(String adviceprogram) {
        this.adviceprogram = adviceprogram;
    }

    public String getAdvicecontent() {
        return advicecontent;
    }

    public void setAdvicecontent(String advicecontent) {
        this.advicecontent = advicecontent;
    }

    public String getAdvicenote() {
        return advicenote;
    }

    public void setAdvicenote(String advicenote) {
        this.advicenote = advicenote;
    }

    public Integer getAdvicenum() {
        return advicenum;
    }

    public void setAdvicenum(Integer advicenum) {
        this.advicenum = advicenum;
    }
}
