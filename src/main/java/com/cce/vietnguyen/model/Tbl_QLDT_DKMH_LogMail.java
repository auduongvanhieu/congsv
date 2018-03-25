


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
@Table (name="tbl_QLDT_DKMH_LogMail")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_LogMail implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String email;
  private String ghiChu;
  private Date ngayXacNhan;
  private String noiDung;
  private Double hocKyId;
  private Double hocVienId;
  private Double dotDKId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getEmail (){
return this.email;
}
public void setEmail (String email){
this.email= email;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayXacNhan (){
return this.ngayXacNhan;
}
public void setNgayXacNhan (Date ngayXacNhan){
this.ngayXacNhan= ngayXacNhan;
}
 
public String getNoiDung (){
return this.noiDung;
}
public void setNoiDung (String noiDung){
this.noiDung= noiDung;
}
 
public Double getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Double hocKyId){
this.hocKyId= hocKyId;
}
 
public Double getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Double hocVienId){
this.hocVienId= hocVienId;
}
 
public Double getDotDKId (){
return this.dotDKId;
}
public void setDotDKId (Double dotDKId){
this.dotDKId= dotDKId;
}
}//endClass
