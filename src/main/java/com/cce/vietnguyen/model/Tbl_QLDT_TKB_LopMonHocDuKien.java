


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
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TKB_LopMonHocDuKien")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TKB_LopMonHocDuKien implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ghiChu;
 
private Tbl_QLDT_GiangVien giaoVienId;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
 
private Tbl_QLDT_CTDT_MonHoc monHocId;
  private Integer soTiet;
  private String maLop;
  private Integer siSoMax;
  private Integer soSVDangKy;
  private Integer tuanBatDau;
  private Integer tuanKetThuc;
  private Integer tuanHoc;
  private Boolean moLopYN;
 
private Tbl_QLDT_DM_CoSo coSoId;
  private Integer soBuoi;
  private Integer soTiet1;
  private Integer soTiet2;
  private Integer soTiet3;
  private Integer tuanThi;

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
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="giaoVienId")
public Tbl_QLDT_GiangVien getGiaoVienId (){
return this.giaoVienId;
}
public void setGiaoVienId (Tbl_QLDT_GiangVien giaoVienId){
this.giaoVienId = giaoVienId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHocId")
public Tbl_QLDT_CTDT_MonHoc getMonHocId (){
return this.monHocId;
}
public void setMonHocId (Tbl_QLDT_CTDT_MonHoc monHocId){
this.monHocId = monHocId;
}
 
public Integer getSoTiet (){
return this.soTiet;
}
public void setSoTiet (Integer soTiet){
this.soTiet= soTiet;
}
 
public String getMaLop (){
return this.maLop;
}
public void setMaLop (String maLop){
this.maLop= maLop;
}
 
public Integer getSiSoMax (){
return this.siSoMax;
}
public void setSiSoMax (Integer siSoMax){
this.siSoMax= siSoMax;
}
 
public Integer getSoSVDangKy (){
return this.soSVDangKy;
}
public void setSoSVDangKy (Integer soSVDangKy){
this.soSVDangKy= soSVDangKy;
}
 
public Integer getTuanBatDau (){
return this.tuanBatDau;
}
public void setTuanBatDau (Integer tuanBatDau){
this.tuanBatDau= tuanBatDau;
}
 
public Integer getTuanKetThuc (){
return this.tuanKetThuc;
}
public void setTuanKetThuc (Integer tuanKetThuc){
this.tuanKetThuc= tuanKetThuc;
}
 
public Integer getTuanHoc (){
return this.tuanHoc;
}
public void setTuanHoc (Integer tuanHoc){
this.tuanHoc= tuanHoc;
}
  public Boolean getMoLopYN (){
return this.moLopYN;
}
public void setMoLopYN (Boolean moLopYN){
this.moLopYN= moLopYN;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="coSoId")
public Tbl_QLDT_DM_CoSo getCoSoId (){
return this.coSoId;
}
public void setCoSoId (Tbl_QLDT_DM_CoSo coSoId){
this.coSoId = coSoId;
}
 
public Integer getSoBuoi (){
return this.soBuoi;
}
public void setSoBuoi (Integer soBuoi){
this.soBuoi= soBuoi;
}
 
public Integer getSoTiet1 (){
return this.soTiet1;
}
public void setSoTiet1 (Integer soTiet1){
this.soTiet1= soTiet1;
}
 
public Integer getSoTiet2 (){
return this.soTiet2;
}
public void setSoTiet2 (Integer soTiet2){
this.soTiet2= soTiet2;
}
 
public Integer getSoTiet3 (){
return this.soTiet3;
}
public void setSoTiet3 (Integer soTiet3){
this.soTiet3= soTiet3;
}
 
public Integer getTuanThi (){
return this.tuanThi;
}
public void setTuanThi (Integer tuanThi){
this.tuanThi= tuanThi;
}
}//endClass
