


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
@Table (name="tbl_QLDT_DM_ChiNhanh")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DM_ChiNhanh implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String email;
  private String ten;
  private String diaChi;
  private String dienThoai;
  private String fax;

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
 
public String getDienThoai (){
return this.dienThoai;
}
public void setDienThoai (String dienThoai){
this.dienThoai= dienThoai;
}
 
public String getFax (){
return this.fax;
}
public void setFax (String fax){
this.fax= fax;
}
}//endClass
