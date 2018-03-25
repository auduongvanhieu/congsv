


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
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_ThongBaoTuyenSinh;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_Nganh;
 
 
 
 
 
 
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TS_HoSoXetTuyen")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TS_HoSoXetTuyen implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ho;
  private String ten;
  private String email;
  private String diaChi;
  private String soDienThoai;
 
private Tbl_QLDT_TS_ThongBaoTuyenSinh dotTuyenSinhId;
 
private Tbl_QLDT_CTDT_Nganh nganhId;
  private String soBaoDanh;
  private String maTruongThiDH;
  private String khoiThi;
  private Double diemMon1;
  private Double diemMon2;
  private Double diemMon3;
  private Double diemUuTien;
  private Double diemThiDH;
  private Integer namThi;
  private Boolean dangKyOnlineYN;
  private Date ngayDangKy;
  private Double canBoId;

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
 
public String getHo (){
return this.ho;
}
public void setHo (String ho){
this.ho= ho;
}
 
public String getTen (){
return this.ten;
}
public void setTen (String ten){
this.ten= ten;
}
 
public String getEmail (){
return this.email;
}
public void setEmail (String email){
this.email= email;
}
 
public String getDiaChi (){
return this.diaChi;
}
public void setDiaChi (String diaChi){
this.diaChi= diaChi;
}
 
public String getSoDienThoai (){
return this.soDienThoai;
}
public void setSoDienThoai (String soDienThoai){
this.soDienThoai= soDienThoai;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="dotTuyenSinhId")
public Tbl_QLDT_TS_ThongBaoTuyenSinh getDotTuyenSinhId (){
return this.dotTuyenSinhId;
}
public void setDotTuyenSinhId (Tbl_QLDT_TS_ThongBaoTuyenSinh dotTuyenSinhId){
this.dotTuyenSinhId = dotTuyenSinhId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="nganhId")
public Tbl_QLDT_CTDT_Nganh getNganhId (){
return this.nganhId;
}
public void setNganhId (Tbl_QLDT_CTDT_Nganh nganhId){
this.nganhId = nganhId;
}
 
public String getSoBaoDanh (){
return this.soBaoDanh;
}
public void setSoBaoDanh (String soBaoDanh){
this.soBaoDanh= soBaoDanh;
}
 
public String getMaTruongThiDH (){
return this.maTruongThiDH;
}
public void setMaTruongThiDH (String maTruongThiDH){
this.maTruongThiDH= maTruongThiDH;
}
 
public String getKhoiThi (){
return this.khoiThi;
}
public void setKhoiThi (String khoiThi){
this.khoiThi= khoiThi;
}
 
public Double getDiemMon1 (){
return this.diemMon1;
}
public void setDiemMon1 (Double diemMon1){
this.diemMon1= diemMon1;
}
 
public Double getDiemMon2 (){
return this.diemMon2;
}
public void setDiemMon2 (Double diemMon2){
this.diemMon2= diemMon2;
}
 
public Double getDiemMon3 (){
return this.diemMon3;
}
public void setDiemMon3 (Double diemMon3){
this.diemMon3= diemMon3;
}
 
public Double getDiemUuTien (){
return this.diemUuTien;
}
public void setDiemUuTien (Double diemUuTien){
this.diemUuTien= diemUuTien;
}
 
public Double getDiemThiDH (){
return this.diemThiDH;
}
public void setDiemThiDH (Double diemThiDH){
this.diemThiDH= diemThiDH;
}
 
public Integer getNamThi (){
return this.namThi;
}
public void setNamThi (Integer namThi){
this.namThi= namThi;
}
  public Boolean getDangKyOnlineYN (){
return this.dangKyOnlineYN;
}
public void setDangKyOnlineYN (Boolean dangKyOnlineYN){
this.dangKyOnlineYN= dangKyOnlineYN;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayDangKy (){
return this.ngayDangKy;
}
public void setNgayDangKy (Date ngayDangKy){
this.ngayDangKy= ngayDangKy;
}
 
public Double getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Double canBoId){
this.canBoId= canBoId;
}
}//endClass
