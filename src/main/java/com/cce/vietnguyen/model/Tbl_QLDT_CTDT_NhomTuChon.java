


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
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_KhoiNganh;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_CTDT_NhomTuChon")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_CTDT_NhomTuChon implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
  private Double soTinChi;
 
private Tbl_QLDT_CTDT_KhoiNganh khoiNganhId;
  private Integer hocKy;

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
 
public Double getSoTinChi (){
return this.soTinChi;
}
public void setSoTinChi (Double soTinChi){
this.soTinChi= soTinChi;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="khoiNganhId")
public Tbl_QLDT_CTDT_KhoiNganh getKhoiNganhId (){
return this.khoiNganhId;
}
public void setKhoiNganhId (Tbl_QLDT_CTDT_KhoiNganh khoiNganhId){
this.khoiNganhId = khoiNganhId;
}
 
public Integer getHocKy (){
return this.hocKy;
}
public void setHocKy (Integer hocKy){
this.hocKy= hocKy;
}
}//endClass
