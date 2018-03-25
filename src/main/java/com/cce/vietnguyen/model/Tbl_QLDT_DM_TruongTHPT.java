


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
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Tinh;
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_DM_TruongTHPT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DM_TruongTHPT implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
 
private Tbl_QLDT_DM_Tinh tinhId;
  private String diaChi;
  private String sdt;

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
@JoinColumn(name="tinhId")
public Tbl_QLDT_DM_Tinh getTinhId (){
return this.tinhId;
}
public void setTinhId (Tbl_QLDT_DM_Tinh tinhId){
this.tinhId = tinhId;
}
 
public String getDiaChi (){
return this.diaChi;
}
public void setDiaChi (String diaChi){
this.diaChi= diaChi;
}
 
public String getSdt (){
return this.sdt;
}
public void setSdt (String sdt){
this.sdt= sdt;
}
}//endClass
