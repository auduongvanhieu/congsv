


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
 
 
 
 
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_MonHocMoDangKy;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_DKMH_HocVien_DangKy_MonHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_HocVien_DangKy_MonHoc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String maDieuChinh;
  private String ketQua;
  private Integer xacNhanYN;
  private Date ngayDangKy;
  private Double hocPhi;
  private String ketQuaDKLyDo;
  private Integer khoaKetQuaYN;
  private String tinhTrang;
  private String ketQuaXepLop;
  private String lyDoXepLop;
  private Double hocVienId;
 
private Tbl_QLDT_DKMH_MonHocMoDangKy monHocMoDangKyId;
  private Double hocKyId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getMaDieuChinh (){
return this.maDieuChinh;
}
public void setMaDieuChinh (String maDieuChinh){
this.maDieuChinh= maDieuChinh;
}
 
public String getKetQua (){
return this.ketQua;
}
public void setKetQua (String ketQua){
this.ketQua= ketQua;
}
 
public Integer getXacNhanYN (){
return this.xacNhanYN;
}
public void setXacNhanYN (Integer xacNhanYN){
this.xacNhanYN= xacNhanYN;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayDangKy (){
return this.ngayDangKy;
}
public void setNgayDangKy (Date ngayDangKy){
this.ngayDangKy= ngayDangKy;
}
 
public Double getHocPhi (){
return this.hocPhi;
}
public void setHocPhi (Double hocPhi){
this.hocPhi= hocPhi;
}
 
public String getKetQuaDKLyDo (){
return this.ketQuaDKLyDo;
}
public void setKetQuaDKLyDo (String ketQuaDKLyDo){
this.ketQuaDKLyDo= ketQuaDKLyDo;
}
 
public Integer getKhoaKetQuaYN (){
return this.khoaKetQuaYN;
}
public void setKhoaKetQuaYN (Integer khoaKetQuaYN){
this.khoaKetQuaYN= khoaKetQuaYN;
}
 
public String getTinhTrang (){
return this.tinhTrang;
}
public void setTinhTrang (String tinhTrang){
this.tinhTrang= tinhTrang;
}
 
public String getKetQuaXepLop (){
return this.ketQuaXepLop;
}
public void setKetQuaXepLop (String ketQuaXepLop){
this.ketQuaXepLop= ketQuaXepLop;
}
 
public String getLyDoXepLop (){
return this.lyDoXepLop;
}
public void setLyDoXepLop (String lyDoXepLop){
this.lyDoXepLop= lyDoXepLop;
}
 
public Double getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Double hocVienId){
this.hocVienId= hocVienId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHocMoDangKyId")
public Tbl_QLDT_DKMH_MonHocMoDangKy getMonHocMoDangKyId (){
return this.monHocMoDangKyId;
}
public void setMonHocMoDangKyId (Tbl_QLDT_DKMH_MonHocMoDangKy monHocMoDangKyId){
this.monHocMoDangKyId = monHocMoDangKyId;
}
 
public Double getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Double hocKyId){
this.hocKyId= hocKyId;
}
}//endClass
