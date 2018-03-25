


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
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TKB_LopMonHoc_HocVien")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TKB_LopMonHoc_HocVien implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double diemCK;
  private Double diemGK;
  private Double diemCC;
  private Double diemThiLai1;
  private Double diemThiLai2;
  private Double tongdiem;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
 
private Tbl_QLDT_TKB_LopMonHoc lopMonHocId;
  private String maNhom;
  private Date ngayCapNhat;
 
private Tbl_CanBo canBoId;
  private String ghiChu;
  private String maTrangThai;
  private Integer camThiYN;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getDiemCK (){
return this.diemCK;
}
public void setDiemCK (Double diemCK){
this.diemCK= diemCK;
}
 
public Double getDiemGK (){
return this.diemGK;
}
public void setDiemGK (Double diemGK){
this.diemGK= diemGK;
}
 
public Double getDiemCC (){
return this.diemCC;
}
public void setDiemCC (Double diemCC){
this.diemCC= diemCC;
}
 
public Double getDiemThiLai1 (){
return this.diemThiLai1;
}
public void setDiemThiLai1 (Double diemThiLai1){
this.diemThiLai1= diemThiLai1;
}
 
public Double getDiemThiLai2 (){
return this.diemThiLai2;
}
public void setDiemThiLai2 (Double diemThiLai2){
this.diemThiLai2= diemThiLai2;
}
 
public Double getTongdiem (){
return this.tongdiem;
}
public void setTongdiem (Double tongdiem){
this.tongdiem= tongdiem;
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
@JoinColumn(name="lopMonHocId")
public Tbl_QLDT_TKB_LopMonHoc getLopMonHocId (){
return this.lopMonHocId;
}
public void setLopMonHocId (Tbl_QLDT_TKB_LopMonHoc lopMonHocId){
this.lopMonHocId = lopMonHocId;
}
 
public String getMaNhom (){
return this.maNhom;
}
public void setMaNhom (String maNhom){
this.maNhom= maNhom;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapNhat (){
return this.ngayCapNhat;
}
public void setNgayCapNhat (Date ngayCapNhat){
this.ngayCapNhat= ngayCapNhat;
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
 
public String getMaTrangThai (){
return this.maTrangThai;
}
public void setMaTrangThai (String maTrangThai){
this.maTrangThai= maTrangThai;
}
 
public Integer getCamThiYN (){
return this.camThiYN;
}
public void setCamThiYN (Integer camThiYN){
this.camThiYN= camThiYN;
}
}//endClass
