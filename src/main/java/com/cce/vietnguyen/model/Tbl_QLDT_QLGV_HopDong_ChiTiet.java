


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLGV_HopDong;
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
 
 
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLGV_HopDong_ChiTiet")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLGV_HopDong_ChiTiet implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_QLGV_HopDong hopDongId;
 
private Tbl_QLDT_TKB_LopMonHoc lopMonHocId;
  private String ghiChu;
  private Integer soLuong;
  private String donVi;
  private Double donGia;
  private Integer khoanMucKhacYN;
  private String tenKhoanMuc;
  private Double donGia2;
  private Integer soLuong2;

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
@JoinColumn(name="hopDongId")
public Tbl_QLDT_QLGV_HopDong getHopDongId (){
return this.hopDongId;
}
public void setHopDongId (Tbl_QLDT_QLGV_HopDong hopDongId){
this.hopDongId = hopDongId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lopMonHocId")
public Tbl_QLDT_TKB_LopMonHoc getLopMonHocId (){
return this.lopMonHocId;
}
public void setLopMonHocId (Tbl_QLDT_TKB_LopMonHoc lopMonHocId){
this.lopMonHocId = lopMonHocId;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
public Integer getSoLuong (){
return this.soLuong;
}
public void setSoLuong (Integer soLuong){
this.soLuong= soLuong;
}
 
public String getDonVi (){
return this.donVi;
}
public void setDonVi (String donVi){
this.donVi= donVi;
}
 
public Double getDonGia (){
return this.donGia;
}
public void setDonGia (Double donGia){
this.donGia= donGia;
}
 
public Integer getKhoanMucKhacYN (){
return this.khoanMucKhacYN;
}
public void setKhoanMucKhacYN (Integer khoanMucKhacYN){
this.khoanMucKhacYN= khoanMucKhacYN;
}
 
public String getTenKhoanMuc (){
return this.tenKhoanMuc;
}
public void setTenKhoanMuc (String tenKhoanMuc){
this.tenKhoanMuc= tenKhoanMuc;
}
 
public Double getDonGia2 (){
return this.donGia2;
}
public void setDonGia2 (Double donGia2){
this.donGia2= donGia2;
}
 
public Integer getSoLuong2 (){
return this.soLuong2;
}
public void setSoLuong2 (Integer soLuong2){
this.soLuong2= soLuong2;
}
}//endClass
