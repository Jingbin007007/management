package com.equipments.management.domain.gradation;

import java.util.ArrayList;
import java.util.List;

public class PathologydrawVO {
	
	private String drawno = "";
	
	private String showDrawNo = "";
	
	private List<ProductVO> productVOs = new ArrayList<ProductVO>();

	public String getDrawno() {
		return drawno;
	}

	public void setDrawno(String drawno) {
		this.drawno = drawno;
	}

	public List<ProductVO> getProductVOs() {
		return productVOs;
	}

	public void setProductVOs(List<ProductVO> productVOs) {
		this.productVOs = productVOs;
	}

	public String getShowDrawNo() {
		return showDrawNo;
	}

	public void setShowDrawNo(String showDrawNo) {
		this.showDrawNo = showDrawNo;
	}

}
