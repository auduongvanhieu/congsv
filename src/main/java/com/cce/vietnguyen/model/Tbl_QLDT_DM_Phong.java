


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
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_DM_Phong")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DM_Phong implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
  private Integer soLuongHV;
 
private Tbl_QLDT_DM_CoSo coSoId;
  private String loaiPhong;
  private Integer soLuongMin;

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
 
public Integer getSoLuongHV (){
return this.soLuongHV;
}
public void setSoLuongHV (Integer soLuongHV){
this.soLuongHV= soLuongHV;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="coSoId")
public Tbl_QLDT_DM_CoSo getCoSoId (){
return this.coSoId;
}
public void setCoSoId (Tbl_QLDT_DM_CoSo coSoId){
this.coSoId = coSoId;
}
 
public String getLoaiPhong (){
return this.loaiPhong;
}
public void setLoaiPhong (String loaiPhong){
this.loaiPhong= loaiPhong;
}
 
public Integer getSoLuongMin (){
return this.soLuongMin;
}
public void setSoLuongMin (Integer soLuongMin){
this.soLuongMin= soLuongMin;
}
}//endClass
