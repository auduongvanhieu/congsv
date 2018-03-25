


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
@Table (name="tbl_QLDT_DM_CoSo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DM_CoSo implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ten;
  private String diaChi;
  private String ma;
  private String sdt;
  private Boolean coSoChinhYN;
  private Boolean dangKyYN;

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
 
public String getDiaChi (){
return this.diaChi;
}
public void setDiaChi (String diaChi){
this.diaChi= diaChi;
}
 
public String getMa (){
return this.ma;
}
public void setMa (String ma){
this.ma= ma;
}
 
public String getSdt (){
return this.sdt;
}
public void setSdt (String sdt){
this.sdt= sdt;
}
  public Boolean getCoSoChinhYN (){
return this.coSoChinhYN;
}
public void setCoSoChinhYN (Boolean coSoChinhYN){
this.coSoChinhYN= coSoChinhYN;
}
  public Boolean getDangKyYN (){
return this.dangKyYN;
}
public void setDangKyYN (Boolean dangKyYN){
this.dangKyYN= dangKyYN;
}
}//endClass
