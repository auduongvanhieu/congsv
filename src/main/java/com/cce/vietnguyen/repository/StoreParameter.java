package com.cce.vietnguyen.repository;

import javax.persistence.ParameterMode;

public class StoreParameter {
	private String name;
	private Class clazz;
	private Object val;
	
	private ParameterMode mode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public Object getVal() {
		return val;
	}
	public void setVal(Object val) {
		this.val = val;
	}
	public ParameterMode getMode() {
		return mode;
	}
	public void setMode(ParameterMode mode) {
		this.mode = mode;
	}
	
	
	
	
	
	
	
	
	

}
