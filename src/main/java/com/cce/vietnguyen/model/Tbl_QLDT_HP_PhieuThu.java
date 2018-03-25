


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
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
 
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_HP_PhieuThu")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_HP_PhieuThu implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
  private Double soTien;
  private Double duDauKy;
  private Date ngayTao;
 
private Tbl_CanBo canBoId;
  private String ghiChu;
  private Date ngayNop;
  private Integer loaiPT;
  private String soBienLai;
  private String soQuyen;

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
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
public Double getSoTien (){
return this.soTien;
}
public void setSoTien (Double soTien){
this.soTien= soTien;
}
 
public Double getDuDauKy (){
return this.duDauKy;
}
public void setDuDauKy (Double duDauKy){
this.duDauKy= duDauKy;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayTao (){
return this.ngayTao;
}
public void setNgayTao (Date ngayTao){
this.ngayTao= ngayTao;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoId")
public Tbl_CanBo getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Tbl_CanBo canBoId){
this.canBoId = canBoId;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayNop (){
return this.ngayNop;
}
public void setNgayNop (Date ngayNop){
this.ngayNop= ngayNop;
}
 
public Integer getLoaiPT (){
return this.loaiPT;
}
public void setLoaiPT (Integer loaiPT){
this.loaiPT= loaiPT;
}
 
public String getSoBienLai (){
return this.soBienLai;
}
public void setSoBienLai (String soBienLai){
this.soBienLai= soBienLai;
}
 
public String getSoQuyen (){
return this.soQuyen;
}
public void setSoQuyen (String soQuyen){
this.soQuyen= soQuyen;
}
}//endClass
