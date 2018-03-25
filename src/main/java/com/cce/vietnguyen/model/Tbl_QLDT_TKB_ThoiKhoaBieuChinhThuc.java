


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Phong;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_NgayTrongTuan;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_DM_TietHoc tietHocId;
  private Integer soTiet;
 
private Tbl_QLDT_TKB_LopMonHoc lopMonHocId;
 
private Tbl_QLDT_DM_Phong phongId;
 
private Tbl_QLDT_DM_NgayTrongTuan ngayId;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
  private Integer tuanHoc;
  private String tuanHocStr;
  private String tuanHocBinStr;
  private Date ngayKetThuc;
  private Date ngayBatDau;

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
@JoinColumn(name="tietHocId")
public Tbl_QLDT_DM_TietHoc getTietHocId (){
return this.tietHocId;
}
public void setTietHocId (Tbl_QLDT_DM_TietHoc tietHocId){
this.tietHocId = tietHocId;
}
 
public Integer getSoTiet (){
return this.soTiet;
}
public void setSoTiet (Integer soTiet){
this.soTiet= soTiet;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lopMonHocId")
public Tbl_QLDT_TKB_LopMonHoc getLopMonHocId (){
return this.lopMonHocId;
}
public void setLopMonHocId (Tbl_QLDT_TKB_LopMonHoc lopMonHocId){
this.lopMonHocId = lopMonHocId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="phongId")
public Tbl_QLDT_DM_Phong getPhongId (){
return this.phongId;
}
public void setPhongId (Tbl_QLDT_DM_Phong phongId){
this.phongId = phongId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="ngayId")
public Tbl_QLDT_DM_NgayTrongTuan getNgayId (){
return this.ngayId;
}
public void setNgayId (Tbl_QLDT_DM_NgayTrongTuan ngayId){
this.ngayId = ngayId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
public Integer getTuanHoc (){
return this.tuanHoc;
}
public void setTuanHoc (Integer tuanHoc){
this.tuanHoc= tuanHoc;
}
 
public String getTuanHocStr (){
return this.tuanHocStr;
}
public void setTuanHocStr (String tuanHocStr){
this.tuanHocStr= tuanHocStr;
}
 
public String getTuanHocBinStr (){
return this.tuanHocBinStr;
}
public void setTuanHocBinStr (String tuanHocBinStr){
this.tuanHocBinStr= tuanHocBinStr;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayKetThuc (){
return this.ngayKetThuc;
}
public void setNgayKetThuc (Date ngayKetThuc){
this.ngayKetThuc= ngayKetThuc;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayBatDau (){
return this.ngayBatDau;
}
public void setNgayBatDau (Date ngayBatDau){
this.ngayBatDau= ngayBatDau;
}
}//endClass
