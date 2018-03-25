


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
 
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHocDuKien;
 
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TKB_LopMonHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TKB_LopMonHoc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ten;
  private String ghiChu;
 
private Tbl_QLDT_GiangVien giaoVienId;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
 
private Tbl_QLDT_CTDT_MonHoc monHocId;
  private String ma;
  private Date ngayBatDau;
  private Date ngayKetThuc;
  private Date ngayKiemTraGK;
  private Date ngayThi;
  private Double phanTramGK;
  private Double phanTramCK;
  private Double phanTramCC;
  private Integer siSo;
 
private Tbl_QLDT_TKB_LopMonHocDuKien lopDuKienId;
  private Integer tuanBatDau;
  private Integer tuanKetThuc;
  private Integer tuanThi;
  private Integer soTiet2;
  private Integer siSoMin;
  private Boolean moLopYN;
  private Integer soTiet1;
  private Integer soTiet3;
  private Integer soBuoi;
 
private Tbl_QLDT_DM_CoSo coSoId;
  private Integer soTiet;
  private Integer tuanHoc;
  private Integer siSoMax;
  private Double giaoVien2Id;
  private Integer khoaBangDiemYN;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getTen (){
return this.ten;
}
public void setTen (String ten){
this.ten= ten;
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
 
public String getMa (){
return this.ma;
}
public void setMa (String ma){
this.ma= ma;
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
public Date getNgayKiemTraGK (){
return this.ngayKiemTraGK;
}
public void setNgayKiemTraGK (Date ngayKiemTraGK){
this.ngayKiemTraGK= ngayKiemTraGK;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayThi (){
return this.ngayThi;
}
public void setNgayThi (Date ngayThi){
this.ngayThi= ngayThi;
}
 
public Double getPhanTramGK (){
return this.phanTramGK;
}
public void setPhanTramGK (Double phanTramGK){
this.phanTramGK= phanTramGK;
}
 
public Double getPhanTramCK (){
return this.phanTramCK;
}
public void setPhanTramCK (Double phanTramCK){
this.phanTramCK= phanTramCK;
}
 
public Double getPhanTramCC (){
return this.phanTramCC;
}
public void setPhanTramCC (Double phanTramCC){
this.phanTramCC= phanTramCC;
}
 
public Integer getSiSo (){
return this.siSo;
}
public void setSiSo (Integer siSo){
this.siSo= siSo;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lopDuKienId")
public Tbl_QLDT_TKB_LopMonHocDuKien getLopDuKienId (){
return this.lopDuKienId;
}
public void setLopDuKienId (Tbl_QLDT_TKB_LopMonHocDuKien lopDuKienId){
this.lopDuKienId = lopDuKienId;
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
 
public Integer getTuanThi (){
return this.tuanThi;
}
public void setTuanThi (Integer tuanThi){
this.tuanThi= tuanThi;
}
 
public Integer getSoTiet2 (){
return this.soTiet2;
}
public void setSoTiet2 (Integer soTiet2){
this.soTiet2= soTiet2;
}
 
public Integer getSiSoMin (){
return this.siSoMin;
}
public void setSiSoMin (Integer siSoMin){
this.siSoMin= siSoMin;
}
  public Boolean getMoLopYN (){
return this.moLopYN;
}
public void setMoLopYN (Boolean moLopYN){
this.moLopYN= moLopYN;
}
 
public Integer getSoTiet1 (){
return this.soTiet1;
}
public void setSoTiet1 (Integer soTiet1){
this.soTiet1= soTiet1;
}
 
public Integer getSoTiet3 (){
return this.soTiet3;
}
public void setSoTiet3 (Integer soTiet3){
this.soTiet3= soTiet3;
}
 
public Integer getSoBuoi (){
return this.soBuoi;
}
public void setSoBuoi (Integer soBuoi){
this.soBuoi= soBuoi;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="coSoId")
public Tbl_QLDT_DM_CoSo getCoSoId (){
return this.coSoId;
}
public void setCoSoId (Tbl_QLDT_DM_CoSo coSoId){
this.coSoId = coSoId;
}
 
public Integer getSoTiet (){
return this.soTiet;
}
public void setSoTiet (Integer soTiet){
this.soTiet= soTiet;
}
 
public Integer getTuanHoc (){
return this.tuanHoc;
}
public void setTuanHoc (Integer tuanHoc){
this.tuanHoc= tuanHoc;
}
 
public Integer getSiSoMax (){
return this.siSoMax;
}
public void setSiSoMax (Integer siSoMax){
this.siSoMax= siSoMax;
}
 
public Double getGiaoVien2Id (){
return this.giaoVien2Id;
}
public void setGiaoVien2Id (Double giaoVien2Id){
this.giaoVien2Id= giaoVien2Id;
}
 
public Integer getKhoaBangDiemYN (){
return this.khoaBangDiemYN;
}
public void setKhoaBangDiemYN (Integer khoaBangDiemYN){
this.khoaBangDiemYN= khoaBangDiemYN;
}
}//endClass
