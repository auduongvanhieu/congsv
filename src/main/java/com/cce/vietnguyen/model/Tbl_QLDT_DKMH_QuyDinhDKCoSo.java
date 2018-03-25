


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
@Table (name="tbl_QLDT_DKMH_QuyDinhDKCoSo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_QuyDinhDKCoSo implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Integer khoaHoc;
  private Integer denKhoaHoc;
  private Integer duocDK;
  private Double chuyenNganhId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Integer getKhoaHoc (){
return this.khoaHoc;
}
public void setKhoaHoc (Integer khoaHoc){
this.khoaHoc= khoaHoc;
}
 
public Integer getDenKhoaHoc (){
return this.denKhoaHoc;
}
public void setDenKhoaHoc (Integer denKhoaHoc){
this.denKhoaHoc= denKhoaHoc;
}
 
public Integer getDuocDK (){
return this.duocDK;
}
public void setDuocDK (Integer duocDK){
this.duocDK= duocDK;
}
 
public Double getChuyenNganhId (){
return this.chuyenNganhId;
}
public void setChuyenNganhId (Double chuyenNganhId){
this.chuyenNganhId= chuyenNganhId;
}
}//endClass
