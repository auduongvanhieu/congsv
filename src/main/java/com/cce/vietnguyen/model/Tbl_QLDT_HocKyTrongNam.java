


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
@Table (name="tbl_QLDT_HocKyTrongNam")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_HocKyTrongNam implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
  private Date ngayBatDau;
  private Date ngayKetThuc;
  private Integer tongTuanHoc;
  private Integer namHoc;
  private Date ngayHetHanHocPhi;

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
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayBatDau (){
return this.ngayBatDau;
}
public void setNgayBatDau (Date ngayBatDau){
this.ngayBatDau= ngayBatDau;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayKetThuc (){
return this.ngayKetThuc;
}
public void setNgayKetThuc (Date ngayKetThuc){
this.ngayKetThuc= ngayKetThuc;
}
 
public Integer getTongTuanHoc (){
return this.tongTuanHoc;
}
public void setTongTuanHoc (Integer tongTuanHoc){
this.tongTuanHoc= tongTuanHoc;
}
 
public Integer getNamHoc (){
return this.namHoc;
}
public void setNamHoc (Integer namHoc){
this.namHoc= namHoc;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayHetHanHocPhi (){
return this.ngayHetHanHocPhi;
}
public void setNgayHetHanHocPhi (Date ngayHetHanHocPhi){
this.ngayHetHanHocPhi= ngayHetHanHocPhi;
}
}//endClass
