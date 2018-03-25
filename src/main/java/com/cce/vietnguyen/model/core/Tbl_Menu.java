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
@Table(name = "tbl_Menu")
public class Tbl_Menu implements Serializable {
	private static final long serialVersionUID = -1989579066723007050L;

	private Long id;
	private String url;
	private String ten;
	private Tbl_Menu menuCha = null;
	private String hinh;
	private String menuId;
	private String nhom;
	private Integer stt;
	private Integer lvl;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "menuCha")
	public Tbl_Menu getMenuCha() {
		return menuCha;
	}

	public void setMenuCha(Tbl_Menu menuCha) {
		this.menuCha = menuCha;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getNhom() {
		return nhom;
	}

	public void setNhom(String nhom) {
		this.nhom = nhom;
	}


	public Integer getStt() {
		return stt;
	}

	public void setStt(Integer stt) {
		this.stt = stt;
	}

	public Integer getLvl() {
		return lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

}// endClass
