


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
@Table (name="tbl_QLDT_RBXL_LopMonHoc_Cam")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_RBXL_LopMonHoc_Cam implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Integer tuanHoc;
  private Integer soTiet;
  private Double ngayId;
  private Double tietBatDauId;
  private Double lopMonHocId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Integer getTuanHoc (){
return this.tuanHoc;
}
public void setTuanHoc (Integer tuanHoc){
this.tuanHoc= tuanHoc;
}
 
public Integer getSoTiet (){
return this.soTiet;
}
public void setSoTiet (Integer soTiet){
this.soTiet= soTiet;
}
 
public Double getNgayId (){
return this.ngayId;
}
public void setNgayId (Double ngayId){
this.ngayId= ngayId;
}
 
public Double getTietBatDauId (){
return this.tietBatDauId;
}
public void setTietBatDauId (Double tietBatDauId){
this.tietBatDauId= tietBatDauId;
}
 
public Double getLopMonHocId (){
return this.lopMonHocId;
}
public void setLopMonHocId (Double lopMonHocId){
this.lopMonHocId= lopMonHocId;
}
}//endClass
