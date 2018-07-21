package com.equipments.management.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/8.
 */

public class Department {
    /**
     * DEPT_NO
     DEPT_CODE
     DEPT_NAME
     DEPT_ALIAS
     DEPT_GRADE
     * */
    private Integer no;
    private String code;
    private String name;
    private String alias;
    private Integer grade;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Department{" +
                "no=" + no +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", grade=" + grade +
                '}';
    }
}
