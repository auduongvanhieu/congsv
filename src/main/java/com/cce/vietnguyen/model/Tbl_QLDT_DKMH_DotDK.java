


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
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_DKMH_DotDK")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_DotDK implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
  private Date ngayBatDau;
  private Date ngayKetThuc;
  private Date ngayCapNhat;
  private String ghiChu;
  private Boolean khoaDotDK;
 
private Tbl_CanBo canBoId;
  private Integer khoaHoc;
  private Integer denKhoaHoc;
  private String quyen;
  private Double khoaId;

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
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayBatDau (){
return this.ngayBatDau;
}
public void setNgayBatDau (Date ngayBatDau){
this.ngayBatDau= ngayBatDau;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayKetThuc (){
return this.ngayKetThuc;
}
public void setNgayKetThuc (Date ngayKetThuc){
this.ngayKetThuc= ngayKetThuc;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapNhat (){
return this.ngayCapNhat;
}
public void setNgayCapNhat (Date ngayCapNhat){
this.ngayCapNhat= ngayCapNhat;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
  public Boolean getKhoaDotDK (){
return this.khoaDotDK;
}
public void setKhoaDotDK (Boolean khoaDotDK){
this.khoaDotDK= khoaDotDK;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoId")
public Tbl_CanBo getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Tbl_CanBo canBoId){
this.canBoId = canBoId;
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
 
public String getQuyen (){
return this.quyen;
}
public void setQuyen (String quyen){
this.quyen= quyen;
}
 
public Double getKhoaId (){
return this.khoaId;
}
public void setKhoaId (Double khoaId){
this.khoaId= khoaId;
}
}//endClass
