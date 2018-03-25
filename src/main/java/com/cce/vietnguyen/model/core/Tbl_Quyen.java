package com.cce.vietnguyen.model.core;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tbl_Quyen")
public class Tbl_Quyen implements Serializable {
	private static final long serialVersionUID = -1989579066723007050L;

	@Id
	@GeneratedValue
	private Long id;
	private String ma;
	private String ten;
	private String ghiChu;

	@Transient
	private List<Tbl_Quyen_Menu> tbl_Quyen_Menus = new ArrayList<>();

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

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<Tbl_Quyen_Menu> getTbl_Quyen_Menus() {
		return tbl_Quyen_Menus;
	}

	public void setTbl_Quyen_Menus(List<Tbl_Quyen_Menu> tbl_Quyen_Menus) {
		this.tbl_Quyen_Menus = tbl_Quyen_Menus;
	}

}// endClass
