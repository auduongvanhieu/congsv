


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
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TonGiao;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TruongTHPT;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Huyen;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSoXetTuyen;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TS_HoSo_ThongTin")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TS_HoSo_ThongTin implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String diaChiLienLac;
  private Date ngaySinh;
  private String noiSinh;
  private Boolean gioiTinh;
  private String cmnd;
  private Date ngayCap;
  private String noiCap;
 
private Tbl_QLDT_DM_DanToc danTocId;
 
private Tbl_QLDT_DM_TonGiao tonGiaoId;
 
private Tbl_QLDT_DM_TruongTHPT truongTHPTId;
 
private Tbl_QLDT_DM_Huyen huyenId;
  private String ghiChu;
 
private Tbl_QLDT_TS_HoSoXetTuyen hoSoId;
  private Integer namTN;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getDiaChiLienLac (){
return this.diaChiLienLac;
}
public void setDiaChiLienLac (String diaChiLienLac){
this.diaChiLienLac= diaChiLienLac;
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
  public Boolean getGioiTinh (){
return this.gioiTinh;
}
public void setGioiTinh (Boolean gioiTinh){
this.gioiTinh= gioiTinh;
}
 
public String getCmnd (){
return this.cmnd;
}
public void setCmnd (String cmnd){
this.cmnd= cmnd;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCap (){
return this.ngayCap;
}
public void setNgayCap (Date ngayCap){
this.ngayCap= ngayCap;
}
 
public String getNoiCap (){
return this.noiCap;
}
public void setNoiCap (String noiCap){
this.noiCap= noiCap;
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
@JoinColumn(name="tonGiaoId")
public Tbl_QLDT_DM_TonGiao getTonGiaoId (){
return this.tonGiaoId;
}
public void setTonGiaoId (Tbl_QLDT_DM_TonGiao tonGiaoId){
this.tonGiaoId = tonGiaoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="truongTHPTId")
public Tbl_QLDT_DM_TruongTHPT getTruongTHPTId (){
return this.truongTHPTId;
}
public void setTruongTHPTId (Tbl_QLDT_DM_TruongTHPT truongTHPTId){
this.truongTHPTId = truongTHPTId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="huyenId")
public Tbl_QLDT_DM_Huyen getHuyenId (){
return this.huyenId;
}
public void setHuyenId (Tbl_QLDT_DM_Huyen huyenId){
this.huyenId = huyenId;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hoSoId")
public Tbl_QLDT_TS_HoSoXetTuyen getHoSoId (){
return this.hoSoId;
}
public void setHoSoId (Tbl_QLDT_TS_HoSoXetTuyen hoSoId){
this.hoSoId = hoSoId;
}
 
public Integer getNamTN (){
return this.namTN;
}
public void setNamTN (Integer namTN){
this.namTN= namTN;
}
}//endClass
