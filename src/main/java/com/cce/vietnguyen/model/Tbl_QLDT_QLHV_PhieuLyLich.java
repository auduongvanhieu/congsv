


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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_DanToc;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TonGiao;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLHV_PhieuLyLich")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_PhieuLyLich implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Date ngaySinh;
  private String noiSinh;
  private String cmnd;
  private Date ngayCapCMND;
  private String noiCap;
  private String dienThoai;
  private String hinhAnh;
  private Boolean gioiTinh;
  private String thuongTru;
  private String choOHiennay;
  private String thongtinDoan;
  private String thongtinDang;
  private String thongtinQD;
 
private Tbl_QLDT_DM_DanToc danTocId;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
 
private Tbl_QLDT_DM_TonGiao tonGiaoId;

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
public Date getNgaySinh (){
return this.ngaySinh;
}
public void setNgaySinh (Date ngaySinh){
this.ngaySinh= ngaySinh;
}
 
public String getNoiSinh (){
return this.noiSinh;
}
public void setNoiSinh (String noiSinh){
this.noiSinh= noiSinh;
}
 
public String getCmnd (){
return this.cmnd;
}
public void setCmnd (String cmnd){
this.cmnd= cmnd;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapCMND (){
return this.ngayCapCMND;
}
public void setNgayCapCMND (Date ngayCapCMND){
this.ngayCapCMND= ngayCapCMND;
}
 
public String getNoiCap (){
return this.noiCap;
}
public void setNoiCap (String noiCap){
this.noiCap= noiCap;
}
 
public String getDienThoai (){
return this.dienThoai;
}
public void setDienThoai (String dienThoai){
this.dienThoai= dienThoai;
}
 
public String getHinhAnh (){
return this.hinhAnh;
}
public void setHinhAnh (String hinhAnh){
this.hinhAnh= hinhAnh;
}
  public Boolean getGioiTinh (){
return this.gioiTinh;
}
public void setGioiTinh (Boolean gioiTinh){
this.gioiTinh= gioiTinh;
}
 
public String getThuongTru (){
return this.thuongTru;
}
public void setThuongTru (String thuongTru){
this.thuongTru= thuongTru;
}
 
public String getChoOHiennay (){
return this.choOHiennay;
}
public void setChoOHiennay (String choOHiennay){
this.choOHiennay= choOHiennay;
}
 
public String getThongtinDoan (){
return this.thongtinDoan;
}
public void setThongtinDoan (String thongtinDoan){
this.thongtinDoan= thongtinDoan;
}
 
public String getThongtinDang (){
return this.thongtinDang;
}
public void setThongtinDang (String thongtinDang){
this.thongtinDang= thongtinDang;
}
 
public String getThongtinQD (){
return this.thongtinQD;
}
public void setThongtinQD (String thongtinQD){
this.thongtinQD= thongtinQD;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="danTocId")
public Tbl_QLDT_DM_DanToc getDanTocId (){
return this.danTocId;
}
public void setDanTocId (Tbl_QLDT_DM_DanToc danTocId){
this.danTocId = danTocId;
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
@JoinColumn(name="tonGiaoId")
public Tbl_QLDT_DM_TonGiao getTonGiaoId (){
return this.tonGiaoId;
}
public void setTonGiaoId (Tbl_QLDT_DM_TonGiao tonGiaoId){
this.tonGiaoId = tonGiaoId;
}
}//endClass
