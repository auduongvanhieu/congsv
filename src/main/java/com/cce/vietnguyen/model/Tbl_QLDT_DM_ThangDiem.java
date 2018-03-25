


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
@Table (name="tbl_QLDT_DM_ThangDiem")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DM_ThangDiem implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ten;
  private Double diem;
  private Boolean tuyenThang;
  private Boolean suDungYN;
  private String ma;

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
 
public Double getDiem (){
return this.diem;
}
public void setDiem (Double diem){
this.diem= diem;
}
  public Boolean getTuyenThang (){
return this.tuyenThang;
}
public void setTuyenThang (Boolean tuyenThang){
this.tuyenThang= tuyenThang;
}
  public Boolean getSuDungYN (){
return this.suDungYN;
}
public void setSuDungYN (Boolean suDungYN){
this.suDungYN= suDungYN;
}
 
public String getMa (){
return this.ma;
}
public void setMa (String ma){
this.ma= ma;
}
}//endClass
