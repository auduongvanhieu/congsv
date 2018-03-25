


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TN_DotTotNghiep;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TN_DotTotNghiep_DanhSach")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TN_DotTotNghiep_DanhSach implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_TN_DotTotNghiep dotTotNghiepId;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
  private String xepLoaiTotNghiep;
  private Boolean duocTotNghiepYN;
  private String ghiChu;
  private Double diemTB;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="dotTotNghiepId")
public Tbl_QLDT_TN_DotTotNghiep getDotTotNghiepId (){
return this.dotTotNghiepId;
}
public void setDotTotNghiepId (Tbl_QLDT_TN_DotTotNghiep dotTotNghiepId){
this.dotTotNghiepId = dotTotNghiepId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
 
public String getXepLoaiTotNghiep (){
return this.xepLoaiTotNghiep;
}
public void setXepLoaiTotNghiep (String xepLoaiTotNghiep){
this.xepLoaiTotNghiep= xepLoaiTotNghiep;
}
  public Boolean getDuocTotNghiepYN (){
return this.duocTotNghiepYN;
}
public void setDuocTotNghiepYN (Boolean duocTotNghiepYN){
this.duocTotNghiepYN= duocTotNghiepYN;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
public Double getDiemTB (){
return this.diemTB;
}
public void setDiemTB (Double diemTB){
this.diemTB= diemTB;
}
}//endClass
