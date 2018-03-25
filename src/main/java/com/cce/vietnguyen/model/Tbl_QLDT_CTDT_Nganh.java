


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
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_HeDaoTao;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_CTDT_Nganh")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_CTDT_Nganh implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
  private String khoiThi;
 
private Tbl_QLDT_CTDT_Khoa khoaId;
 
private Tbl_QLDT_CTDT_HeDaoTao heDaoTaoId;
  private String tenTA;

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
 
public String getKhoiThi (){
return this.khoiThi;
}
public void setKhoiThi (String khoiThi){
this.khoiThi= khoiThi;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="khoaId")
public Tbl_QLDT_CTDT_Khoa getKhoaId (){
return this.khoaId;
}
public void setKhoaId (Tbl_QLDT_CTDT_Khoa khoaId){
this.khoaId = khoaId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="heDaoTaoId")
public Tbl_QLDT_CTDT_HeDaoTao getHeDaoTaoId (){
return this.heDaoTaoId;
}
public void setHeDaoTaoId (Tbl_QLDT_CTDT_HeDaoTao heDaoTaoId){
this.heDaoTaoId = heDaoTaoId;
}
 
public String getTenTA (){
return this.tenTA;
}
public void setTenTA (String tenTA){
this.tenTA= tenTA;
}
}//endClass
