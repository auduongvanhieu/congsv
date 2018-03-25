
package com.cce.vietnguyen.model.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Types;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.cce.vietnguyen.model.core.Tbl_Option;
import com.cce.vietnguyen.model.core.Tbl_OptionGroup;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table(name = "tbl_Option")
public class Tbl_Option implements Serializable {
	private static final long serialVersionUID = -1989579066723007050L;
	// variable

	private Long id;
	private String code;
	private String name;

	private Tbl_OptionGroup optionGroupId;
	private String val;

	private Tbl_Option parentId;
	private Integer lvl;
	private Integer orderNo;
	private String icon;
	private Double factor;


//get/set
	@Id
	@GeneratedValue
  public Long getId (){
return this.id;
}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "optionGroupId")
	@Fetch(FetchMode.JOIN)
	public Tbl_OptionGroup getOptionGroupId() {
		return this.optionGroupId;
	}

	public void setOptionGroupId(Tbl_OptionGroup optionGroupId) {
		this.optionGroupId = optionGroupId;
	}

	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	public Tbl_Option getParentId() {
		return this.parentId;
	}

	public void setParentId(Tbl_Option parentId) {
		this.parentId = parentId;
	}

	public Integer getLvl() {
		return this.lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}


}// endClass
