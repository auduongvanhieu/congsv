


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
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Phong;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_LichThi")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_LichThi implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ghiChu;
  private Date ngayThi;
  private Integer thoiGian;
  private String maNhom;
 
private Tbl_QLDT_TKB_LopMonHoc lopId;
 
private Tbl_QLDT_DM_Phong phongId;
 
private Tbl_QLDT_DM_TietHoc tietThiId;
  private String gioBatDau;
  private String loaiThi;
  private String hinhThuc;
  private String canBoCoiThi1;
  private String canBoCoiThi2;
  private Integer siSo;
  private Integer thayDoi;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayThi (){
return this.ngayThi;
}
public void setNgayThi (Date ngayThi){
this.ngayThi= ngayThi;
}
 
public Integer getThoiGian (){
return this.thoiGian;
}
public void setThoiGian (Integer thoiGian){
this.thoiGian= thoiGian;
}
 
public String getMaNhom (){
return this.maNhom;
}
public void setMaNhom (String maNhom){
this.maNhom= maNhom;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lopId")
public Tbl_QLDT_TKB_LopMonHoc getLopId (){
return this.lopId;
}
public void setLopId (Tbl_QLDT_TKB_LopMonHoc lopId){
this.lopId = lopId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="phongId")
public Tbl_QLDT_DM_Phong getPhongId (){
return this.phongId;
}
public void setPhongId (Tbl_QLDT_DM_Phong phongId){
this.phongId = phongId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="tietThiId")
public Tbl_QLDT_DM_TietHoc getTietThiId (){
return this.tietThiId;
}
public void setTietThiId (Tbl_QLDT_DM_TietHoc tietThiId){
this.tietThiId = tietThiId;
}
 
public String getGioBatDau (){
return this.gioBatDau;
}
public void setGioBatDau (String gioBatDau){
this.gioBatDau= gioBatDau;
}
 
public String getLoaiThi (){
return this.loaiThi;
}
public void setLoaiThi (String loaiThi){
this.loaiThi= loaiThi;
}
 
public String getHinhThuc (){
return this.hinhThuc;
}
public void setHinhThuc (String hinhThuc){
this.hinhThuc= hinhThuc;
}
 
public String getCanBoCoiThi1 (){
return this.canBoCoiThi1;
}
public void setCanBoCoiThi1 (String canBoCoiThi1){
this.canBoCoiThi1= canBoCoiThi1;
}
 
public String getCanBoCoiThi2 (){
return this.canBoCoiThi2;
}
public void setCanBoCoiThi2 (String canBoCoiThi2){
this.canBoCoiThi2= canBoCoiThi2;
}
 
public Integer getSiSo (){
return this.siSo;
}
public void setSiSo (Integer siSo){
this.siSo= siSo;
}
 
public Integer getThayDoi (){
return this.thayDoi;
}
public void setThayDoi (Integer thayDoi){
this.thayDoi= thayDoi;
}
}//endClass
