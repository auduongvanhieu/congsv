


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
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TN_DotTotNghiep;
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TN_SoCapBangTotNghiep")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TN_SoCapBangTotNghiep implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String maBang;
  private Date ngayNhan;
  private Date ngayCap;
  private String ghiChu;
  private String xepLoaiTotNghiep;
 
private Tbl_QLDT_TN_DotTotNghiep dotTotNghiepId;
 
private Tbl_CanBo canBoGiaoBang;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
  private Boolean huyYN;
  private String huyLyDo;
  private String maLuuSo;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getMaBang (){
return this.maBang;
}
public void setMaBang (String maBang){
this.maBang= maBang;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayNhan (){
return this.ngayNhan;
}
public void setNgayNhan (Date ngayNhan){
this.ngayNhan= ngayNhan;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCap (){
return this.ngayCap;
}
public void setNgayCap (Date ngayCap){
this.ngayCap= ngayCap;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
public String getXepLoaiTotNghiep (){
return this.xepLoaiTotNghiep;
}
public void setXepLoaiTotNghiep (String xepLoaiTotNghiep){
this.xepLoaiTotNghiep= xepLoaiTotNghiep;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="dotTotNghiepId")
public Tbl_QLDT_TN_DotTotNghiep getDotTotNghiepId (){
return this.dotTotNghiepId;
}
public void setDotTotNghiepId (Tbl_QLDT_TN_DotTotNghiep dotTotNghiepId){
this.dotTotNghiepId = dotTotNghiepId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoGiaoBang")
public Tbl_CanBo getCanBoGiaoBang (){
return this.canBoGiaoBang;
}
public void setCanBoGiaoBang (Tbl_CanBo canBoGiaoBang){
this.canBoGiaoBang = canBoGiaoBang;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
  public Boolean getHuyYN (){
return this.huyYN;
}
public void setHuyYN (Boolean huyYN){
this.huyYN= huyYN;
}
 
public String getHuyLyDo (){
return this.huyLyDo;
}
public void setHuyLyDo (String huyLyDo){
this.huyLyDo= huyLyDo;
}
 
public String getMaLuuSo (){
return this.maLuuSo;
}
public void setMaLuuSo (String maLuuSo){
this.maLuuSo= maLuuSo;
}
}//endClass
