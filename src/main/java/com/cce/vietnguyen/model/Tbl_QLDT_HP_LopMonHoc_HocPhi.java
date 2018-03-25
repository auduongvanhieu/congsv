


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
@Table (name="tbl_QLDT_HP_LopMonHoc_HocPhi")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_HP_LopMonHoc_HocPhi implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double donGiaTinChiLT;
  private Double donGiaTinChiTH;
  private Double heSoTinChiLT;
  private Double heSoTinChiTH;
  private Double tongTien;
  private Double lopMonHocId;
  private Double heSoPhongMay;
  private Integer khoaHoc;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getDonGiaTinChiLT (){
return this.donGiaTinChiLT;
}
public void setDonGiaTinChiLT (Double donGiaTinChiLT){
this.donGiaTinChiLT= donGiaTinChiLT;
}
 
public Double getDonGiaTinChiTH (){
return this.donGiaTinChiTH;
}
public void setDonGiaTinChiTH (Double donGiaTinChiTH){
this.donGiaTinChiTH= donGiaTinChiTH;
}
 
public Double getHeSoTinChiLT (){
return this.heSoTinChiLT;
}
public void setHeSoTinChiLT (Double heSoTinChiLT){
this.heSoTinChiLT= heSoTinChiLT;
}
 
public Double getHeSoTinChiTH (){
return this.heSoTinChiTH;
}
public void setHeSoTinChiTH (Double heSoTinChiTH){
this.heSoTinChiTH= heSoTinChiTH;
}
 
public Double getTongTien (){
return this.tongTien;
}
public void setTongTien (Double tongTien){
this.tongTien= tongTien;
}
 
public Double getLopMonHocId (){
return this.lopMonHocId;
}
public void setLopMonHocId (Double lopMonHocId){
this.lopMonHocId= lopMonHocId;
}
 
public Double getHeSoPhongMay (){
return this.heSoPhongMay;
}
public void setHeSoPhongMay (Double heSoPhongMay){
this.heSoPhongMay= heSoPhongMay;
}
 
public Integer getKhoaHoc (){
return this.khoaHoc;
}
public void setKhoaHoc (Integer khoaHoc){
this.khoaHoc= khoaHoc;
}
}//endClass
