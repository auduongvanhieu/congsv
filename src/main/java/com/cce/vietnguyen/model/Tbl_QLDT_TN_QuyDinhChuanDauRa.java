


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
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_LoaiChungChi;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_HeDaoTao;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_Nganh;
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TN_QuyDinhChuanDauRa")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TN_QuyDinhChuanDauRa implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Date ngayApDung;
  private Date ngayKhoa;
  private Boolean khoaYN;
  private Date ngayTao;
 
private Tbl_QLDT_DM_LoaiChungChi loaiChungChiId;
  private Double diemDat;
 
private Tbl_QLDT_CTDT_HeDaoTao heDaoTaoId;
 
private Tbl_QLDT_CTDT_Nganh nganhId;
 
private Tbl_CanBo canBoId;

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
public Date getNgayApDung (){
return this.ngayApDung;
}
public void setNgayApDung (Date ngayApDung){
this.ngayApDung= ngayApDung;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayKhoa (){
return this.ngayKhoa;
}
public void setNgayKhoa (Date ngayKhoa){
this.ngayKhoa= ngayKhoa;
}
  public Boolean getKhoaYN (){
return this.khoaYN;
}
public void setKhoaYN (Boolean khoaYN){
this.khoaYN= khoaYN;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayTao (){
return this.ngayTao;
}
public void setNgayTao (Date ngayTao){
this.ngayTao= ngayTao;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="loaiChungChiId")
public Tbl_QLDT_DM_LoaiChungChi getLoaiChungChiId (){
return this.loaiChungChiId;
}
public void setLoaiChungChiId (Tbl_QLDT_DM_LoaiChungChi loaiChungChiId){
this.loaiChungChiId = loaiChungChiId;
}
 
public Double getDiemDat (){
return this.diemDat;
}
public void setDiemDat (Double diemDat){
this.diemDat= diemDat;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="heDaoTaoId")
public Tbl_QLDT_CTDT_HeDaoTao getHeDaoTaoId (){
return this.heDaoTaoId;
}
public void setHeDaoTaoId (Tbl_QLDT_CTDT_HeDaoTao heDaoTaoId){
this.heDaoTaoId = heDaoTaoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="nganhId")
public Tbl_QLDT_CTDT_Nganh getNganhId (){
return this.nganhId;
}
public void setNganhId (Tbl_QLDT_CTDT_Nganh nganhId){
this.nganhId = nganhId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoId")
public Tbl_CanBo getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Tbl_CanBo canBoId){
this.canBoId = canBoId;
}
}//endClass
