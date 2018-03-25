


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
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLGV_HopDong")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLGV_HopDong implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String soHopDong;
  private String soPhuLuc;
  private Date ngayKy;
  private String ghiChu;
  private String ma;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
  private String chucVu;
 
private Tbl_CanBo canBoId;
  private Date ngayTao;
  private Double donGiaGiangDay;
  private Double donGiaChamBai;
  private String nguoiDaiDien;
 
private Tbl_QLDT_GiangVien giangVienId;
  private Boolean huyYN;
  private Double donGiaGiangDayTH;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getSoHopDong (){
return this.soHopDong;
}
public void setSoHopDong (String soHopDong){
this.soHopDong= soHopDong;
}
 
public String getSoPhuLuc (){
return this.soPhuLuc;
}
public void setSoPhuLuc (String soPhuLuc){
this.soPhuLuc= soPhuLuc;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayKy (){
return this.ngayKy;
}
public void setNgayKy (Date ngayKy){
this.ngayKy= ngayKy;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
public String getMa (){
return this.ma;
}
public void setMa (String ma){
this.ma= ma;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
public String getChucVu (){
return this.chucVu;
}
public void setChucVu (String chucVu){
this.chucVu= chucVu;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoId")
public Tbl_CanBo getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Tbl_CanBo canBoId){
this.canBoId = canBoId;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayTao (){
return this.ngayTao;
}
public void setNgayTao (Date ngayTao){
this.ngayTao= ngayTao;
}
 
public Double getDonGiaGiangDay (){
return this.donGiaGiangDay;
}
public void setDonGiaGiangDay (Double donGiaGiangDay){
this.donGiaGiangDay= donGiaGiangDay;
}
 
public Double getDonGiaChamBai (){
return this.donGiaChamBai;
}
public void setDonGiaChamBai (Double donGiaChamBai){
this.donGiaChamBai= donGiaChamBai;
}
 
public String getNguoiDaiDien (){
return this.nguoiDaiDien;
}
public void setNguoiDaiDien (String nguoiDaiDien){
this.nguoiDaiDien= nguoiDaiDien;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="giangVienId")
public Tbl_QLDT_GiangVien getGiangVienId (){
return this.giangVienId;
}
public void setGiangVienId (Tbl_QLDT_GiangVien giangVienId){
this.giangVienId = giangVienId;
}
  public Boolean getHuyYN (){
return this.huyYN;
}
public void setHuyYN (Boolean huyYN){
this.huyYN= huyYN;
}
 
public Double getDonGiaGiangDayTH (){
return this.donGiaGiangDayTH;
}
public void setDonGiaGiangDayTH (Double donGiaGiangDayTH){
this.donGiaGiangDayTH= donGiaGiangDayTH;
}
}//endClass
