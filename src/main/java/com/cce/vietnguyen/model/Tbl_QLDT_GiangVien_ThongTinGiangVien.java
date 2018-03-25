


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_GiangVien_ThongTinGiangVien")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_GiangVien_ThongTinGiangVien implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_GiangVien giangVienId;
  private String email;
  private String soDienThoai;
  private String diaChiCongTac;
  private String diaChi;
  private Date ngaySinh;
  private String noiSinh;
  private String hocHam;
  private String hocVi;
  private String ghiChu;
  private String cmnd;
  private Date ngayCapCMND;
  private String noiCapCMND;
  private String maTaiKhoanNganHang;
  private String nganHang;
  private String chiNhanhNganHang;
  private Integer luongThoaThuan;
  private Integer thuLaoChamBai;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="giangVienId")
public Tbl_QLDT_GiangVien getGiangVienId (){
return this.giangVienId;
}
public void setGiangVienId (Tbl_QLDT_GiangVien giangVienId){
this.giangVienId = giangVienId;
}
 
public String getEmail (){
return this.email;
}
public void setEmail (String email){
this.email= email;
}
 
public String getSoDienThoai (){
return this.soDienThoai;
}
public void setSoDienThoai (String soDienThoai){
this.soDienThoai= soDienThoai;
}
 
public String getDiaChiCongTac (){
return this.diaChiCongTac;
}
public void setDiaChiCongTac (String diaChiCongTac){
this.diaChiCongTac= diaChiCongTac;
}
 
public String getDiaChi (){
return this.diaChi;
}
public void setDiaChi (String diaChi){
this.diaChi= diaChi;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgaySinh (){
return this.ngaySinh;
}
public void setNgaySinh (Date ngaySinh){
this.ngaySinh= ngaySinh;
}
 
public String getNoiSinh (){
return this.noiSinh;
}
public void setNoiSinh (String noiSinh){
this.noiSinh= noiSinh;
}
 
public String getHocHam (){
return this.hocHam;
}
public void setHocHam (String hocHam){
this.hocHam= hocHam;
}
 
public String getHocVi (){
return this.hocVi;
}
public void setHocVi (String hocVi){
this.hocVi= hocVi;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
public String getCmnd (){
return this.cmnd;
}
public void setCmnd (String cmnd){
this.cmnd= cmnd;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapCMND (){
return this.ngayCapCMND;
}
public void setNgayCapCMND (Date ngayCapCMND){
this.ngayCapCMND= ngayCapCMND;
}
 
public String getNoiCapCMND (){
return this.noiCapCMND;
}
public void setNoiCapCMND (String noiCapCMND){
this.noiCapCMND= noiCapCMND;
}
 
public String getMaTaiKhoanNganHang (){
return this.maTaiKhoanNganHang;
}
public void setMaTaiKhoanNganHang (String maTaiKhoanNganHang){
this.maTaiKhoanNganHang= maTaiKhoanNganHang;
}
 
public String getNganHang (){
return this.nganHang;
}
public void setNganHang (String nganHang){
this.nganHang= nganHang;
}
 
public String getChiNhanhNganHang (){
return this.chiNhanhNganHang;
}
public void setChiNhanhNganHang (String chiNhanhNganHang){
this.chiNhanhNganHang= chiNhanhNganHang;
}
 
public Integer getLuongThoaThuan (){
return this.luongThoaThuan;
}
public void setLuongThoaThuan (Integer luongThoaThuan){
this.luongThoaThuan= luongThoaThuan;
}
 
public Integer getThuLaoChamBai (){
return this.thuLaoChamBai;
}
public void setThuLaoChamBai (Integer thuLaoChamBai){
this.thuLaoChamBai= thuLaoChamBai;
}
}//endClass
