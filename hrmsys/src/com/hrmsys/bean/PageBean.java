package com.hrmsys.bean;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

public class PageBean {
	private int totalProperty;
	private List root;
	
	public int getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}
	public List getRoot() {
		return root;
	}
	public void setRoot(List root) {
		this.root = root;
	}
	
}	
