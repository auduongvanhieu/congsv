package com.cce.vietnguyen.model.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tbl_qldt_htmlreport_param")
public class Tbl_HTMLReport_Param implements Serializable {
	private static final long serialVersionUID = -1989579066723007050L;

	private Long id;
	private Tbl_HTMLReport reportId = null;
	private String ten;
	private String label;
	private String type;
	private String paramSql;
	private String paramVariable;
	private Integer stt;

	private Object value;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reportId")
	public Tbl_HTMLReport getReportId() {
		return reportId;
	}

	public void setReportId(Tbl_HTMLReport reportId) {
		this.reportId = reportId;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParamSql() {
		return paramSql;
	}

	public void setParamSql(String paramSql) {
		this.paramSql = paramSql;
	}

	public String getParamVariable() {
		return paramVariable;
	}

	public void setParamVariable(String paramVariable) {
		this.paramVariable = paramVariable;
	}

	public Integer getStt() {
		return stt;
	}

	public void setStt(Integer stt) {
		this.stt = stt;
	}

	@Transient
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}// endClass
