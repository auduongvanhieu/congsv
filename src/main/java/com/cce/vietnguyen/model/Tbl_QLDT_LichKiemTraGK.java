


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
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Phong;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_LichKiemTraGK")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_LichKiemTraGK implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ghiChu;
  private Date ngayThi;
  private Integer thoiGian;
 
private Tbl_QLDT_TKB_LopMonHoc lopId;
 
private Tbl_QLDT_DM_TietHoc tietThiId;
 
private Tbl_QLDT_DM_Phong phongId;
  private Integer nhomId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayThi (){
return this.ngayThi;
}
public void setNgayThi (Date ngayThi){
this.ngayThi= ngayThi;
}
 
public Integer getThoiGian (){
return this.thoiGian;
}
public void setThoiGian (Integer thoiGian){
this.thoiGian= thoiGian;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lopId")
public Tbl_QLDT_TKB_LopMonHoc getLopId (){
return this.lopId;
}
public void setLopId (Tbl_QLDT_TKB_LopMonHoc lopId){
this.lopId = lopId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="tietThiId")
public Tbl_QLDT_DM_TietHoc getTietThiId (){
return this.tietThiId;
}
public void setTietThiId (Tbl_QLDT_DM_TietHoc tietThiId){
this.tietThiId = tietThiId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="phongId")
public Tbl_QLDT_DM_Phong getPhongId (){
return this.phongId;
}
public void setPhongId (Tbl_QLDT_DM_Phong phongId){
this.phongId = phongId;
}
 
public Integer getNhomId (){
return this.nhomId;
}
public void setNhomId (Integer nhomId){
this.nhomId= nhomId;
}
}//endClass
