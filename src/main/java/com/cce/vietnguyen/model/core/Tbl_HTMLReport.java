package com.cce.vietnguyen.model.core;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "tbl_qldt_htmlreport")
public class Tbl_HTMLReport implements Serializable {
	private static final long serialVersionUID = -1989579066723007050L;

	private Long id;
	private String ma;
	private String ten;
	private String css;
	private String javascript;
	private String header;
	private String body;
	private String footer;
	private String bodySql;
	private String headerSql;
	private String description;
	private String type;
	private String fileTemplate;
	private Tbl_Option reportGroupOptionId;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getJavascript() {
		return javascript;
	}

	public void setJavascript(String javascript) {
		this.javascript = javascript;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getBodySql() {
		return bodySql;
	}

	public void setBodySql(String bodySql) {
		this.bodySql = bodySql;
	}

	public String getHeaderSql() {
		return headerSql;
	}

	public void setHeaderSql(String headerSql) {
		this.headerSql = headerSql;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileTemplate() {
		return fileTemplate;
	}

	public void setFileTemplate(String fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "groupOptionId")
	public Tbl_Option getReportGroupOptionId() {
		return reportGroupOptionId;
	}

	public void setReportGroupOptionId(Tbl_Option reportGroupOptionId) {
		this.reportGroupOptionId = reportGroupOptionId;
	}

}// endClass
