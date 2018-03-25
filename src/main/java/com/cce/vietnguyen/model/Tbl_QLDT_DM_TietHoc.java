


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
 
 
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_DM_TietHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DM_TietHoc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
  private String thoiGianBatDau;
  private String thoiGianKetThuc;
  private Integer thoiGianNghi;
  private String kyHieuGioHocTKB;
  private Integer stt;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getMa (){
return this.ma;
}
public void setMa (String ma){
this.ma= ma;
}
 
public String getTen (){
return this.ten;
}
public void setTen (String ten){
this.ten= ten;
}
 
public String getThoiGianBatDau (){
return this.thoiGianBatDau;
}
public void setThoiGianBatDau (String thoiGianBatDau){
this.thoiGianBatDau= thoiGianBatDau;
}
 
public String getThoiGianKetThuc (){
return this.thoiGianKetThuc;
}
public void setThoiGianKetThuc (String thoiGianKetThuc){
this.thoiGianKetThuc= thoiGianKetThuc;
}
 
public Integer getThoiGianNghi (){
return this.thoiGianNghi;
}
public void setThoiGianNghi (Integer thoiGianNghi){
this.thoiGianNghi= thoiGianNghi;
}
 
public String getKyHieuGioHocTKB (){
return this.kyHieuGioHocTKB;
}
public void setKyHieuGioHocTKB (String kyHieuGioHocTKB){
this.kyHieuGioHocTKB= kyHieuGioHocTKB;
}
 
public Integer getStt (){
return this.stt;
}
public void setStt (Integer stt){
this.stt= stt;
}
}//endClass
