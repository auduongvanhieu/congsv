package com.cce.vietnguyen.repository;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class MyFilter<ValueClass> {
	private String col;
	private ValueClass value1;
	private ValueClass value2;
	private String operator;
	private String type;
	
	private List<MyFilter> orCons;
	

	public List<MyFilter> getOrCons() {
		return orCons;
	}
	public void setOrCons(List<MyFilter> orCons) {
		this.orCons = orCons;
	}
	/**
	 * @return the col
	 */
	public String getCol() {
		return col;
	}
	/**
	 * @param col the col to set
	 */
	public void setCol(String col) {
		this.col = col;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public ValueClass getValue1() {
		return value1;
	}
	public void setValue1(ValueClass value1) {
		this.value1 = value1;
	}
	public ValueClass getValue2() {
		return value2;
	}
	public void setValue2(ValueClass value2) {
		this.value2 = value2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
    public static boolean isValidDate(String inDate, String dateformat) {

	    if (inDate == null)
	      return false;

	    //set the format to use as a constructor argument
	    SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);
	    
	    if (inDate.trim().length() != dateFormat.toPattern().length())
	      return false;

	    dateFormat.setLenient(false);
	    
	    try {
	      //parse the inDate parameter
	      dateFormat.parse(inDate.trim());
	    }
	    catch(Exception e){
			return false;
		}
	    return true;
	}
}
