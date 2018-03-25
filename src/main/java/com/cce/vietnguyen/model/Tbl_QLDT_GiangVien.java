


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
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_Khoa;
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_GiangVien")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_GiangVien implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
 
private Tbl_QLDT_CTDT_Khoa khoaId;
  private Boolean gvCoHuuYN;
  private Double heSoChucDanh;
  private String username;
  private String password;
  private String maSoThue;

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
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="khoaId")
public Tbl_QLDT_CTDT_Khoa getKhoaId (){
return this.khoaId;
}
public void setKhoaId (Tbl_QLDT_CTDT_Khoa khoaId){
this.khoaId = khoaId;
}
  public Boolean getGvCoHuuYN (){
return this.gvCoHuuYN;
}
public void setGvCoHuuYN (Boolean gvCoHuuYN){
this.gvCoHuuYN= gvCoHuuYN;
}
 
public Double getHeSoChucDanh (){
return this.heSoChucDanh;
}
public void setHeSoChucDanh (Double heSoChucDanh){
this.heSoChucDanh= heSoChucDanh;
}
 
public String getUsername (){
return this.username;
}
public void setUsername (String username){
this.username= username;
}
 
public String getPassword (){
return this.password;
}
public void setPassword (String password){
this.password= password;
}
 
public String getMaSoThue (){
return this.maSoThue;
}
public void setMaSoThue (String maSoThue){
this.maSoThue= maSoThue;
}
}//endClass
