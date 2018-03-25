


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHocDuKien;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Phong;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_NgayTrongTuan;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TKB_ThoiKhoaBieuDuKien")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TKB_ThoiKhoaBieuDuKien implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_TKB_LopMonHocDuKien lopDuKienId;
  private Boolean daMoLop;
 
private Tbl_QLDT_DM_Phong phongId;
 
private Tbl_QLDT_DM_TietHoc tietBatDauId;
  private Integer soTiet;
  private Integer tuanHoc;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
 
private Tbl_QLDT_DM_NgayTrongTuan ngayId;

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
@JoinColumn(name="lopDuKienId")
public Tbl_QLDT_TKB_LopMonHocDuKien getLopDuKienId (){
return this.lopDuKienId;
}
public void setLopDuKienId (Tbl_QLDT_TKB_LopMonHocDuKien lopDuKienId){
this.lopDuKienId = lopDuKienId;
}
  public Boolean getDaMoLop (){
return this.daMoLop;
}
public void setDaMoLop (Boolean daMoLop){
this.daMoLop= daMoLop;
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
@JoinColumn(name="tietBatDauId")
public Tbl_QLDT_DM_TietHoc getTietBatDauId (){
return this.tietBatDauId;
}
public void setTietBatDauId (Tbl_QLDT_DM_TietHoc tietBatDauId){
this.tietBatDauId = tietBatDauId;
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
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="ngayId")
public Tbl_QLDT_DM_NgayTrongTuan getNgayId (){
return this.ngayId;
}
public void setNgayId (Tbl_QLDT_DM_NgayTrongTuan ngayId){
this.ngayId = ngayId;
}
}//endClass
