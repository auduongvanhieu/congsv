


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
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_HeDaoTao;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_Nganh;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_ChuyenNganh;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_KhoiNganh;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSoXetTuyen;
 
 
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLHV_HocVien")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_HocVien implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String mshv;
  private String ho;
  private String ten;
  private String hinhAnh;
  private String maLop;
 
private Tbl_QLDT_CTDT_HeDaoTao heDaoTaoId;
 
private Tbl_QLDT_CTDT_Nganh nganhId;
 
private Tbl_QLDT_CTDT_ChuyenNganh chuyenNganhId;
 
private Tbl_QLDT_CTDT_KhoiNganh khoiNganhId;
  private Integer namNhapHoc;
  private Integer khoaHoc;
 
private Tbl_QLDT_TS_HoSoXetTuyen hoSoId;
  private String ghiChu;
  private Date ngayLap;
  private String maTrangThai;
  private Date ngaySinh;
  private String email;
  private String sdt;
  private String cmnd;
  private Integer gioiTinh;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getMshv (){
return this.mshv;
}
public void setMshv (String mshv){
this.mshv= mshv;
}
 
public String getHo (){
return this.ho;
}
public void setHo (String ho){
this.ho= ho;
}
 
public String getTen (){
return this.ten;
}
public void setTen (String ten){
this.ten= ten;
}
 
public String getHinhAnh (){
return this.hinhAnh;
}
public void setHinhAnh (String hinhAnh){
this.hinhAnh= hinhAnh;
}
 
public String getMaLop (){
return this.maLop;
}
public void setMaLop (String maLop){
this.maLop= maLop;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="heDaoTaoId")
public Tbl_QLDT_CTDT_HeDaoTao getHeDaoTaoId (){
return this.heDaoTaoId;
}
public void setHeDaoTaoId (Tbl_QLDT_CTDT_HeDaoTao heDaoTaoId){
this.heDaoTaoId = heDaoTaoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="nganhId")
public Tbl_QLDT_CTDT_Nganh getNganhId (){
return this.nganhId;
}
public void setNganhId (Tbl_QLDT_CTDT_Nganh nganhId){
this.nganhId = nganhId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="chuyenNganhId")
public Tbl_QLDT_CTDT_ChuyenNganh getChuyenNganhId (){
return this.chuyenNganhId;
}
public void setChuyenNganhId (Tbl_QLDT_CTDT_ChuyenNganh chuyenNganhId){
this.chuyenNganhId = chuyenNganhId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="khoiNganhId")
public Tbl_QLDT_CTDT_KhoiNganh getKhoiNganhId (){
return this.khoiNganhId;
}
public void setKhoiNganhId (Tbl_QLDT_CTDT_KhoiNganh khoiNganhId){
this.khoiNganhId = khoiNganhId;
}
 
public Integer getNamNhapHoc (){
return this.namNhapHoc;
}
public void setNamNhapHoc (Integer namNhapHoc){
this.namNhapHoc= namNhapHoc;
}
 
public Integer getKhoaHoc (){
return this.khoaHoc;
}
public void setKhoaHoc (Integer khoaHoc){
this.khoaHoc= khoaHoc;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hoSoId")
public Tbl_QLDT_TS_HoSoXetTuyen getHoSoId (){
return this.hoSoId;
}
public void setHoSoId (Tbl_QLDT_TS_HoSoXetTuyen hoSoId){
this.hoSoId = hoSoId;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayLap (){
return this.ngayLap;
}
public void setNgayLap (Date ngayLap){
this.ngayLap= ngayLap;
}
 
public String getMaTrangThai (){
return this.maTrangThai;
}
public void setMaTrangThai (String maTrangThai){
this.maTrangThai= maTrangThai;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgaySinh (){
return this.ngaySinh;
}
public void setNgaySinh (Date ngaySinh){
this.ngaySinh= ngaySinh;
}
 
public String getEmail (){
return this.email;
}
public void setEmail (String email){
this.email= email;
}
 
public String getSdt (){
return this.sdt;
}
public void setSdt (String sdt){
this.sdt= sdt;
}
 
public String getCmnd (){
return this.cmnd;
}
public void setCmnd (String cmnd){
this.cmnd= cmnd;
}
 
public Integer getGioiTinh (){
return this.gioiTinh;
}
public void setGioiTinh (Integer gioiTinh){
this.gioiTinh= gioiTinh;
}
}//endClass
