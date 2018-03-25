


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
 
 
 
 
 
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TS_ThongBaoTuyenSinh")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TS_ThongBaoTuyenSinh implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
  private String hinhAnh;
  private String noiDung;
  private Date thoiGianBatDau;
  private Date thoiGianKetThuc;
  private Date ngayCongBoKetQua;
  private Date ngayHoanTatThuTuc;
  private Integer khoaHoc;

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
 
public String getHinhAnh (){
return this.hinhAnh;
}
public void setHinhAnh (String hinhAnh){
this.hinhAnh= hinhAnh;
}
 
public String getNoiDung (){
return this.noiDung;
}
public void setNoiDung (String noiDung){
this.noiDung= noiDung;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getThoiGianBatDau (){
return this.thoiGianBatDau;
}
public void setThoiGianBatDau (Date thoiGianBatDau){
this.thoiGianBatDau= thoiGianBatDau;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getThoiGianKetThuc (){
return this.thoiGianKetThuc;
}
public void setThoiGianKetThuc (Date thoiGianKetThuc){
this.thoiGianKetThuc= thoiGianKetThuc;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCongBoKetQua (){
return this.ngayCongBoKetQua;
}
public void setNgayCongBoKetQua (Date ngayCongBoKetQua){
this.ngayCongBoKetQua= ngayCongBoKetQua;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayHoanTatThuTuc (){
return this.ngayHoanTatThuTuc;
}
public void setNgayHoanTatThuTuc (Date ngayHoanTatThuTuc){
this.ngayHoanTatThuTuc= ngayHoanTatThuTuc;
}
 
public Integer getKhoaHoc (){
return this.khoaHoc;
}
public void setKhoaHoc (Integer khoaHoc){
this.khoaHoc= khoaHoc;
}
}//endClass
