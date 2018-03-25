


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
@Table (name="tbl_QLDT_BangDiem_ChiTiet")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_BangDiem_ChiTiet implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Integer stt;
  private Double hocVienId;
  private Double bangDiemId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Integer getStt (){
return this.stt;
}
public void setStt (Integer stt){
this.stt= stt;
}
 
public Double getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Double hocVienId){
this.hocVienId= hocVienId;
}
 
public Double getBangDiemId (){
return this.bangDiemId;
}
public void setBangDiemId (Double bangDiemId){
this.bangDiemId= bangDiemId;
}
}//endClass
