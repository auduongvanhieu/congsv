package com.cce.vietnguyen.model.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "Tbl_TaiKhoan")
public class Tbl_TaiKhoan implements Serializable {
	private static final long serialVersionUID = -1989579066723007050L;

	private Long id;
	private String login;
	private String password;
	private Tbl_NhomQuyen nhomQuyenId = null;
	private Tbl_CanBo canBoId = null;
	private Tbl_QLDT_QLHV_HocVien hocVienId;
	private Tbl_QLDT_GiangVien giangVienId;

	public Tbl_TaiKhoan() {
	}

	public Tbl_TaiKhoan(Tbl_TaiKhoan u) {
		super();
		this.id = u.getId();
		this.login = u.getLogin();
		this.password = u.getPassword();
		this.nhomQuyenId = u.getNhomQuyenId();
		this.canBoId = u.getCanBoId();
		this.hocVienId = u.getHocVienId();
		this.giangVienId = u.getGiangVienId();
	}


	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	@NotEmpty
	@Column(unique = true, nullable = false)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	@NotEmpty
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "maNhomQuyen")
	public Tbl_NhomQuyen getNhomQuyenId() {
		return nhomQuyenId;
	}

	public void setNhomQuyenId(Tbl_NhomQuyen nhomQuyenId) {
		this.nhomQuyenId = nhomQuyenId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CanBoId")
	public Tbl_CanBo getCanBoId() {
		return canBoId;
	}

	public void setCanBoId(Tbl_CanBo canBoId) {
		this.canBoId = canBoId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hocVienId")
	public Tbl_QLDT_QLHV_HocVien getHocVienId() {
		return hocVienId;
	}

	public void setHocVienId(Tbl_QLDT_QLHV_HocVien hocVienId) {
		this.hocVienId = hocVienId;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "giangVienId")
	public Tbl_QLDT_GiangVien getGiangVienId() {
		return giangVienId;
	}

	public void setGiangVienId(Tbl_QLDT_GiangVien giangVienId) {
		this.giangVienId = giangVienId;
	}
	
	
	
	


}// endClass
