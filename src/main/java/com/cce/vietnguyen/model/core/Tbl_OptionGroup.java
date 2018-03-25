
package com.cce.vietnguyen.model.core;

import java.io.Serializable;
import java.sql.Types;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name = "tbl_OptionGroup")
public class Tbl_OptionGroup implements Serializable {
	private static final long serialVersionUID = -1989579066723007050L;
	// variable

	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parentId")
	@Fetch(FetchMode.JOIN)
	private Tbl_OptionGroup parentId;


	// get/set
	public Long getId() {
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

	public Tbl_OptionGroup getParentId() {
		return this.parentId;
	}

	public void setParentId(Tbl_OptionGroup parentId) {
		this.parentId = parentId;
	}

}// endClass
