package com.equipments.management.domain.gradation;

import com.equipments.management.domain.Pathologydiagnosis;

/**
 * Created by Administrator on 2018/7/7.
 */
public class Doctoradvice001 {
    private Integer adviceno;

    private String advicekind;
    private String adviceprogram;
    private String advicecontent;
    private String advicenote;
    private Integer advicenum;
    private Integer diagnosisno;

    public Doctoradvice001() {
    }

    @Override
    public String toString() {
        return "Doctoradvice001{" +
                "adviceno=" + adviceno +
                ", advicekind='" + advicekind + '\'' +
                ", adviceprogram='" + adviceprogram + '\'' +
                ", advicecontent='" + advicecontent + '\'' +
                ", advicenote='" + advicenote + '\'' +
                ", advicenum=" + advicenum +
                ", diagnosisno=" + diagnosisno +
                '}';
    }

    public Integer getDiagnosisno() {
        return diagnosisno;
    }

    public void setDiagnosisno(Integer diagnosisno) {
        this.diagnosisno = diagnosisno;
    }

    public Integer getAdviceno() {
        return adviceno;
    }

    public void setAdviceno(Integer adviceno) {
        this.adviceno = adviceno;
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
