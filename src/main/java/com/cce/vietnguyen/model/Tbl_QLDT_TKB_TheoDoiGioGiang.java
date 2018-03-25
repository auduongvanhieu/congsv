


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
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc;
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Phong;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TKB_TheoDoiGioGiang")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TKB_TheoDoiGioGiang implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Date ngay;
  private Integer tuanHoc;
  private String gioVaoLop;
  private String gioRaLop;
  private String ghiChu;
  private Date ngayCapNhat;
 
private Tbl_CanBo canBoId;
 
private Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc tkbId;
 
private Tbl_QLDT_TKB_LopMonHoc lopMonHocId;
  private Integer soTiet;
 
private Tbl_QLDT_DM_TietHoc tietBatDauId;
  private Integer soTietDK;
  private Boolean baoNghiYN;
 
private Tbl_QLDT_DM_Phong phongId;
  private Integer siSo;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgay (){
return this.ngay;
}
public void setNgay (Date ngay){
this.ngay= ngay;
}
 
public Integer getTuanHoc (){
return this.tuanHoc;
}
public void setTuanHoc (Integer tuanHoc){
this.tuanHoc= tuanHoc;
}
 
public String getGioVaoLop (){
return this.gioVaoLop;
}
public void setGioVaoLop (String gioVaoLop){
this.gioVaoLop= gioVaoLop;
}
 
public String getGioRaLop (){
return this.gioRaLop;
}
public void setGioRaLop (String gioRaLop){
this.gioRaLop= gioRaLop;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
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
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="tkbId")
public Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc getTkbId (){
return this.tkbId;
}
public void setTkbId (Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc tkbId){
this.tkbId = tkbId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lopMonHocId")
public Tbl_QLDT_TKB_LopMonHoc getLopMonHocId (){
return this.lopMonHocId;
}
public void setLopMonHocId (Tbl_QLDT_TKB_LopMonHoc lopMonHocId){
this.lopMonHocId = lopMonHocId;
}
 
public Integer getSoTiet (){
return this.soTiet;
}
public void setSoTiet (Integer soTiet){
this.soTiet= soTiet;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="tietBatDauId")
public Tbl_QLDT_DM_TietHoc getTietBatDauId (){
return this.tietBatDauId;
}
public void setTietBatDauId (Tbl_QLDT_DM_TietHoc tietBatDauId){
this.tietBatDauId = tietBatDauId;
}
 
public Integer getSoTietDK (){
return this.soTietDK;
}
public void setSoTietDK (Integer soTietDK){
this.soTietDK= soTietDK;
}
  public Boolean getBaoNghiYN (){
return this.baoNghiYN;
}
public void setBaoNghiYN (Boolean baoNghiYN){
this.baoNghiYN= baoNghiYN;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="phongId")
public Tbl_QLDT_DM_Phong getPhongId (){
return this.phongId;
}
public void setPhongId (Tbl_QLDT_DM_Phong phongId){
this.phongId = phongId;
}
 
public Integer getSiSo (){
return this.siSo;
}
public void setSiSo (Integer siSo){
this.siSo= siSo;
}
}//endClass
