


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
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_BoMon;
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_CTDT_MonHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_CTDT_MonHoc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ten;
  private String ghiChu;
  private Double soTinChi;
  private Double soTinChiLT;
  private Double soTinChiTH;
  private String maMonHoc;
  private Integer soTietHoc;
 
private Tbl_QLDT_CTDT_BoMon boMonId;
  private Double phanTramDanhGiaCK;
  private Double phanTramDanhGiaGK;
  private Double phanTramChuyenCan;
  private Integer soBuoi;
  private String loaiPhong;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getTen (){
return this.ten;
}
public void setTen (String ten){
this.ten= ten;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
public Double getSoTinChi (){
return this.soTinChi;
}
public void setSoTinChi (Double soTinChi){
this.soTinChi= soTinChi;
}
 
public Double getSoTinChiLT (){
return this.soTinChiLT;
}
public void setSoTinChiLT (Double soTinChiLT){
this.soTinChiLT= soTinChiLT;
}
 
public Double getSoTinChiTH (){
return this.soTinChiTH;
}
public void setSoTinChiTH (Double soTinChiTH){
this.soTinChiTH= soTinChiTH;
}
 
public String getMaMonHoc (){
return this.maMonHoc;
}
public void setMaMonHoc (String maMonHoc){
this.maMonHoc= maMonHoc;
}
 
public Integer getSoTietHoc (){
return this.soTietHoc;
}
public void setSoTietHoc (Integer soTietHoc){
this.soTietHoc= soTietHoc;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="boMonId")
public Tbl_QLDT_CTDT_BoMon getBoMonId (){
return this.boMonId;
}
public void setBoMonId (Tbl_QLDT_CTDT_BoMon boMonId){
this.boMonId = boMonId;
}
 
public Double getPhanTramDanhGiaCK (){
return this.phanTramDanhGiaCK;
}
public void setPhanTramDanhGiaCK (Double phanTramDanhGiaCK){
this.phanTramDanhGiaCK= phanTramDanhGiaCK;
}
 
public Double getPhanTramDanhGiaGK (){
return this.phanTramDanhGiaGK;
}
public void setPhanTramDanhGiaGK (Double phanTramDanhGiaGK){
this.phanTramDanhGiaGK= phanTramDanhGiaGK;
}
 
public Double getPhanTramChuyenCan (){
return this.phanTramChuyenCan;
}
public void setPhanTramChuyenCan (Double phanTramChuyenCan){
this.phanTramChuyenCan= phanTramChuyenCan;
}
 
public Integer getSoBuoi (){
return this.soBuoi;
}
public void setSoBuoi (Integer soBuoi){
this.soBuoi= soBuoi;
}
 
public String getLoaiPhong (){
return this.loaiPhong;
}
public void setLoaiPhong (String loaiPhong){
this.loaiPhong= loaiPhong;
}
}//endClass
