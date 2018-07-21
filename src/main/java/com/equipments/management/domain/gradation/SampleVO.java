package com.equipments.management.domain.gradation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhangp
 *
 */
public class SampleVO {
	
	private String sampleno = "";
	
	private String visualobservation = "";
	
    private String diagnosismicroscope = "";
    
    private String diagnosisspecial = "";
    
    private String diagnosispathology = "";
    
    private String diagnosisnote = "";
    
    private String diagnosisno = "";
	
	private List<PathologydrawVO> pathologydrawVOs = new ArrayList<PathologydrawVO>();
	
	public String getSampleno() {
		return sampleno;
	}

	public void setSampleno(String sampleno) {
		this.sampleno = sampleno;
	}

	public List<PathologydrawVO> getPathologydrawVOs() {
		return pathologydrawVOs;
	}

	public void setPathologydrawVOs(List<PathologydrawVO> pathologydrawVOs) {
		this.pathologydrawVOs = pathologydrawVOs;
	}

	public String getVisualobservation() {
		return visualobservation;
	}

	public void setVisualobservation(String visualobservation) {
		this.visualobservation = visualobservation;
	}

	public String getDiagnosismicroscope() {
		return diagnosismicroscope;
	}

	public void setDiagnosismicroscope(String diagnosismicroscope) {
		this.diagnosismicroscope = diagnosismicroscope;
	}

	public String getDiagnosisspecial() {
		return diagnosisspecial;
	}

	public void setDiagnosisspecial(String diagnosisspecial) {
		this.diagnosisspecial = diagnosisspecial;
	}

	public String getDiagnosispathology() {
		return diagnosispathology;
	}

	public void setDiagnosispathology(String diagnosispathology) {
		this.diagnosispathology = diagnosispathology;
	}

	public String getDiagnosisnote() {
		return diagnosisnote;
	}

	public void setDiagnosisnote(String diagnosisnote) {
		this.diagnosisnote = diagnosisnote;
	}

	public String getDiagnosisno() {
		return diagnosisno;
	}

	public void setDiagnosisno(String diagnosisno) {
		this.diagnosisno = diagnosisno;
	}

}
