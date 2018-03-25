


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
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_HP_HocVien_HocPhi")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_HP_HocVien_HocPhi implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Integer soMonHoc;
  private Integer soTinChi;
  private Double hocPhi;
  private Double tienPhaiDong;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
  private Integer soMonHocDuocMien;
  private Boolean hocPhiTheoKyYN;
  private Boolean hoanTatHP;
  private Date ngayTao;
 
private Tbl_CanBo canBoTaoId;
  private Double soTienHVDong;
  private Boolean camKethoanTatHP;
  private String maDonCamKet;
  private Date ngayCamKetDongHP;
  private Date ngayCapNhat;
 
private Tbl_CanBo canBoCapNhatId;
  private String ghiChu;
  private Double soTinChiLT;
  private Double soTinChiTH;
  private Double donGiaLT;
  private Double donGiaTH;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Integer getSoMonHoc (){
return this.soMonHoc;
}
public void setSoMonHoc (Integer soMonHoc){
this.soMonHoc= soMonHoc;
}
 
public Integer getSoTinChi (){
return this.soTinChi;
}
public void setSoTinChi (Integer soTinChi){
this.soTinChi= soTinChi;
}
 
public Double getHocPhi (){
return this.hocPhi;
}
public void setHocPhi (Double hocPhi){
this.hocPhi= hocPhi;
}
 
public Double getTienPhaiDong (){
return this.tienPhaiDong;
}
public void setTienPhaiDong (Double tienPhaiDong){
this.tienPhaiDong= tienPhaiDong;
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
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
 
public Integer getSoMonHocDuocMien (){
return this.soMonHocDuocMien;
}
public void setSoMonHocDuocMien (Integer soMonHocDuocMien){
this.soMonHocDuocMien= soMonHocDuocMien;
}
  public Boolean getHocPhiTheoKyYN (){
return this.hocPhiTheoKyYN;
}
public void setHocPhiTheoKyYN (Boolean hocPhiTheoKyYN){
this.hocPhiTheoKyYN= hocPhiTheoKyYN;
}
  public Boolean getHoanTatHP (){
return this.hoanTatHP;
}
public void setHoanTatHP (Boolean hoanTatHP){
this.hoanTatHP= hoanTatHP;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayTao (){
return this.ngayTao;
}
public void setNgayTao (Date ngayTao){
this.ngayTao= ngayTao;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoTaoId")
public Tbl_CanBo getCanBoTaoId (){
return this.canBoTaoId;
}
public void setCanBoTaoId (Tbl_CanBo canBoTaoId){
this.canBoTaoId = canBoTaoId;
}
 
public Double getSoTienHVDong (){
return this.soTienHVDong;
}
public void setSoTienHVDong (Double soTienHVDong){
this.soTienHVDong= soTienHVDong;
}
  public Boolean getCamKethoanTatHP (){
return this.camKethoanTatHP;
}
public void setCamKethoanTatHP (Boolean camKethoanTatHP){
this.camKethoanTatHP= camKethoanTatHP;
}
 
public String getMaDonCamKet (){
return this.maDonCamKet;
}
public void setMaDonCamKet (String maDonCamKet){
this.maDonCamKet= maDonCamKet;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCamKetDongHP (){
return this.ngayCamKetDongHP;
}
public void setNgayCamKetDongHP (Date ngayCamKetDongHP){
this.ngayCamKetDongHP= ngayCamKetDongHP;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapNhat (){
return this.ngayCapNhat;
}
public void setNgayCapNhat (Date ngayCapNhat){
this.ngayCapNhat= ngayCapNhat;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoCapNhatId")
public Tbl_CanBo getCanBoCapNhatId (){
return this.canBoCapNhatId;
}
public void setCanBoCapNhatId (Tbl_CanBo canBoCapNhatId){
this.canBoCapNhatId = canBoCapNhatId;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
public Double getSoTinChiLT (){
return this.soTinChiLT;
}
public void setSoTinChiLT (Double soTinChiLT){
this.soTinChiLT= soTinChiLT;
}
 
public Double getSoTinChiTH (){
return this.soTinChiTH;
}
public void setSoTinChiTH (Double soTinChiTH){
this.soTinChiTH= soTinChiTH;
}
 
public Double getDonGiaLT (){
return this.donGiaLT;
}
public void setDonGiaLT (Double donGiaLT){
this.donGiaLT= donGiaLT;
}
 
public Double getDonGiaTH (){
return this.donGiaTH;
}
public void setDonGiaTH (Double donGiaTH){
this.donGiaTH= donGiaTH;
}
}//endClass
