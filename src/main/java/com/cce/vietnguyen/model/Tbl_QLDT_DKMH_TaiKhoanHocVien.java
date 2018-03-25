


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_DKMH_TaiKhoanHocVien")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_TaiKhoanHocVien implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
  private String username;
  private String password;
  private Boolean khoaTaiKhoan;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
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
  public Boolean getKhoaTaiKhoan (){
return this.khoaTaiKhoan;
}
public void setKhoaTaiKhoan (Boolean khoaTaiKhoan){
this.khoaTaiKhoan= khoaTaiKhoan;
}
}//endClass
