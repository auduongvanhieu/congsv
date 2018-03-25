


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
@Table (name="tbl_QLDT_TN_DotTotNghiep")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TN_DotTotNghiep implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ten;
  private String ma;
  private Date ngay;
  private Boolean khoaYN;
  private String noiDung;
  private Date ngayTao;
  private Double canBoId;
  private Integer khoaHoc;
  private Integer sttDotTN;

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
 
public String getMa (){
return this.ma;
}
public void setMa (String ma){
this.ma= ma;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgay (){
return this.ngay;
}
public void setNgay (Date ngay){
this.ngay= ngay;
}
  public Boolean getKhoaYN (){
return this.khoaYN;
}
public void setKhoaYN (Boolean khoaYN){
this.khoaYN= khoaYN;
}
 
public String getNoiDung (){
return this.noiDung;
}
public void setNoiDung (String noiDung){
this.noiDung= noiDung;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayTao (){
return this.ngayTao;
}
public void setNgayTao (Date ngayTao){
this.ngayTao= ngayTao;
}
 
public Double getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Double canBoId){
this.canBoId= canBoId;
}
 
public Integer getKhoaHoc (){
return this.khoaHoc;
}
public void setKhoaHoc (Integer khoaHoc){
this.khoaHoc= khoaHoc;
}
 
public Integer getSttDotTN (){
return this.sttDotTN;
}
public void setSttDotTN (Integer sttDotTN){
this.sttDotTN= sttDotTN;
}
}//endClass
