package com.equipments.management.domain.gradation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhangp
 *
 */
public class DiagnosticDetailVO {
	
	private String name = "";
	
	private String sex = "";
	
	private String age = "";
	
	private String hospitalizetionid = "'";
	
	private String applino = "";
	
	private List<SampleVO> sampleVOs = new ArrayList<SampleVO>();
	
	private List<DocsProductVO> docsProductVOs = new ArrayList<DocsProductVO>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHospitalizetionid() {
		return hospitalizetionid;
	}

	public void setHospitalizetionid(String hospitalizetionid) {
		this.hospitalizetionid = hospitalizetionid;
	}

	public String getApplino() {
		return applino;
	}

	public void setApplino(String applino) {
		this.applino = applino;
	}

	public List<SampleVO> getSampleVOs() {
		return sampleVOs;
	}

	public void setSampleVOs(List<SampleVO> sampleVOs) {
		this.sampleVOs = sampleVOs;
	}

	public List<DocsProductVO> getDocsProductVOs() {
		return docsProductVOs;
	}

	public void setDocsProductVOs(List<DocsProductVO> docsProductVOs) {
		this.docsProductVOs = docsProductVOs;
	}

	@Override
	public String toString() {
		return "DiagnosticDetailVO [name=" + name + ", sex=" + sex + ", age=" + age + ", hospitalizetionid="
				+ hospitalizetionid + ", applino=" + applino + ", sampleVOs=" + sampleVOs + ", docsProductVOs="
				+ docsProductVOs + "]";
	}
	
}
