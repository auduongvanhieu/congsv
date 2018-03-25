


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
@Table (name="tbl_QLDT_DKMH_MonHocMoDangKy")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_MonHocMoDangKy implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double monHocId;
  private Double hocKyId;
  private Double coSoId;
  private Double giangVienId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getMonHocId (){
return this.monHocId;
}
public void setMonHocId (Double monHocId){
this.monHocId= monHocId;
}
 
public Double getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Double hocKyId){
this.hocKyId= hocKyId;
}
 
public Double getCoSoId (){
return this.coSoId;
}
public void setCoSoId (Double coSoId){
this.coSoId= coSoId;
}
 
public Double getGiangVienId (){
return this.giangVienId;
}
public void setGiangVienId (Double giangVienId){
this.giangVienId= giangVienId;
}
}//endClass
