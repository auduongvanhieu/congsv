


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
@Table (name="tbl_QLDT_TKB_TuanHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TKB_TuanHoc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Integer tuanHoc;
  private Date ngayDauTuan;
  private Integer thoiKhoaBieuId;
  private Date ngayTrongTuan;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Integer getTuanHoc (){
return this.tuanHoc;
}
public void setTuanHoc (Integer tuanHoc){
this.tuanHoc= tuanHoc;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayDauTuan (){
return this.ngayDauTuan;
}
public void setNgayDauTuan (Date ngayDauTuan){
this.ngayDauTuan= ngayDauTuan;
}
 
public Integer getThoiKhoaBieuId (){
return this.thoiKhoaBieuId;
}
public void setThoiKhoaBieuId (Integer thoiKhoaBieuId){
this.thoiKhoaBieuId= thoiKhoaBieuId;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayTrongTuan (){
return this.ngayTrongTuan;
}
public void setNgayTrongTuan (Date ngayTrongTuan){
this.ngayTrongTuan= ngayTrongTuan;
}
}//endClass
