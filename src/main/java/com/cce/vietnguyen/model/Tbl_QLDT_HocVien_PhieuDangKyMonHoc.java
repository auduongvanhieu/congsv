
package com.cce.vietnguyen.model;

import java.io.Serializable;
import java.sql.Types;
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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
import com.cce.vietnguyen.model.core.Tbl_CanBo;
import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;

/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table(name = "tbl_QLDT_HocVien_PhieuDangKyMonHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_HocVien_PhieuDangKyMonHoc implements Serializable {
	private static final long serialVersionUID = -1989579066723007050L;
	// variable

	private Long id;
	private Date ngayNop;

	private Tbl_QLDT_QLHV_HocVien hocVienId;

	private Tbl_QLDT_HocKyTrongNam hocKyId;

	private Tbl_CanBo canBoNhanId;

	// get/set

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonFormat(pattern = "dd-MM-yyyy")
	public Date getNgayNop() {
		return this.ngayNop;
	}

	public void setNgayNop(Date ngayNop) {
		this.ngayNop = ngayNop;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hocVienId")
	public Tbl_QLDT_QLHV_HocVien getHocVienId() {
		return this.hocVienId;
	}

	public void setHocVienId(Tbl_QLDT_QLHV_HocVien hocVienId) {
		this.hocVienId = hocVienId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hocKyId")
	public Tbl_QLDT_HocKyTrongNam getHocKyId() {
		return this.hocKyId;
	}

	public void setHocKyId(Tbl_QLDT_HocKyTrongNam hocKyId) {
		this.hocKyId = hocKyId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "canBoNhanId")
	public Tbl_CanBo getCanBoNhanId() {
		return this.canBoNhanId;
	}

	public void setCanBoNhanId(Tbl_CanBo canBoNhanId) {
		this.canBoNhanId = canBoNhanId;
	}
}// endClass
