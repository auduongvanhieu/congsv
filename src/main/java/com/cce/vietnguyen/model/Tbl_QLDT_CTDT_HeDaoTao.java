


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
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_HinhThucDaoTao;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_CTDT_HeDaoTao")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_CTDT_HeDaoTao implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
  private String tenTA;
 
private Tbl_QLDT_CTDT_HinhThucDaoTao hinhThucDaoTaoId;

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
 
public String getTenTA (){
return this.tenTA;
}
public void setTenTA (String tenTA){
this.tenTA= tenTA;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hinhThucDaoTaoId")
public Tbl_QLDT_CTDT_HinhThucDaoTao getHinhThucDaoTaoId (){
return this.hinhThucDaoTaoId;
}
public void setHinhThucDaoTaoId (Tbl_QLDT_CTDT_HinhThucDaoTao hinhThucDaoTaoId){
this.hinhThucDaoTaoId = hinhThucDaoTaoId;
}
}//endClass
