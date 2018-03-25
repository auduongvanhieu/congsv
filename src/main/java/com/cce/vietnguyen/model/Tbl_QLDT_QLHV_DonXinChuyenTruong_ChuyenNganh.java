


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
@Table (name="tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String yKienNoiChuyenDen;
  private String yKienNoiChuyenDi;
  private Integer dongYChuyenDiYN;
  private Integer dongYTiepNhanYN;
  private String lyDo;
  private Date ngayCapNhat;
  private Date ngayLamDon;
  private String noiDung;
  private Integer sangKhoaHoc;
  private String sangTruong;
  private Integer tuKhoaHoc;
  private String tuTruong;
  private Double canBoId;
  private Double hocKyApDungId;
  private Double hocVienId;
  private Double sangChuyenNganh;
  private Double sangNganhId;
  private Double tuChuyenNganhId;
  private Double tuNganhId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getYKienNoiChuyenDen (){
return this.yKienNoiChuyenDen;
}
public void setYKienNoiChuyenDen (String yKienNoiChuyenDen){
this.yKienNoiChuyenDen= yKienNoiChuyenDen;
}
 
public String getYKienNoiChuyenDi (){
return this.yKienNoiChuyenDi;
}
public void setYKienNoiChuyenDi (String yKienNoiChuyenDi){
this.yKienNoiChuyenDi= yKienNoiChuyenDi;
}
 
public Integer getDongYChuyenDiYN (){
return this.dongYChuyenDiYN;
}
public void setDongYChuyenDiYN (Integer dongYChuyenDiYN){
this.dongYChuyenDiYN= dongYChuyenDiYN;
}
 
public Integer getDongYTiepNhanYN (){
return this.dongYTiepNhanYN;
}
public void setDongYTiepNhanYN (Integer dongYTiepNhanYN){
this.dongYTiepNhanYN= dongYTiepNhanYN;
}
 
public String getLyDo (){
return this.lyDo;
}
public void setLyDo (String lyDo){
this.lyDo= lyDo;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapNhat (){
return this.ngayCapNhat;
}
public void setNgayCapNhat (Date ngayCapNhat){
this.ngayCapNhat= ngayCapNhat;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayLamDon (){
return this.ngayLamDon;
}
public void setNgayLamDon (Date ngayLamDon){
this.ngayLamDon= ngayLamDon;
}
 
public String getNoiDung (){
return this.noiDung;
}
public void setNoiDung (String noiDung){
this.noiDung= noiDung;
}
 
public Integer getSangKhoaHoc (){
return this.sangKhoaHoc;
}
public void setSangKhoaHoc (Integer sangKhoaHoc){
this.sangKhoaHoc= sangKhoaHoc;
}
 
public String getSangTruong (){
return this.sangTruong;
}
public void setSangTruong (String sangTruong){
this.sangTruong= sangTruong;
}
 
public Integer getTuKhoaHoc (){
return this.tuKhoaHoc;
}
public void setTuKhoaHoc (Integer tuKhoaHoc){
this.tuKhoaHoc= tuKhoaHoc;
}
 
public String getTuTruong (){
return this.tuTruong;
}
public void setTuTruong (String tuTruong){
this.tuTruong= tuTruong;
}
 
public Double getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Double canBoId){
this.canBoId= canBoId;
}
 
public Double getHocKyApDungId (){
return this.hocKyApDungId;
}
public void setHocKyApDungId (Double hocKyApDungId){
this.hocKyApDungId= hocKyApDungId;
}
 
public Double getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Double hocVienId){
this.hocVienId= hocVienId;
}
 
public Double getSangChuyenNganh (){
return this.sangChuyenNganh;
}
public void setSangChuyenNganh (Double sangChuyenNganh){
this.sangChuyenNganh= sangChuyenNganh;
}
 
public Double getSangNganhId (){
return this.sangNganhId;
}
public void setSangNganhId (Double sangNganhId){
this.sangNganhId= sangNganhId;
}
 
public Double getTuChuyenNganhId (){
return this.tuChuyenNganhId;
}
public void setTuChuyenNganhId (Double tuChuyenNganhId){
this.tuChuyenNganhId= tuChuyenNganhId;
}
 
public Double getTuNganhId (){
return this.tuNganhId;
}
public void setTuNganhId (Double tuNganhId){
this.tuNganhId= tuNganhId;
}
}//endClass
