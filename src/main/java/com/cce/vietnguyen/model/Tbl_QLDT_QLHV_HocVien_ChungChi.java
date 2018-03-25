


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
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
import com.cce.vietnguyen.model.core.Tbl_CanBo;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLHV_HocVien_ChungChi")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_HocVien_ChungChi implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String soDiem;
  private Date ngayHetHan;
  private String noiCap;
  private Date ngayCap;
 
private com.cce.vietnguyen.model.core.Tbl_CanBo canBoId;
 
private Tbl_QLDT_DM_LoaiChungChi loaiChungChiId;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getSoDiem (){
return this.soDiem;
}
public void setSoDiem (String soDiem){
this.soDiem= soDiem;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayHetHan (){
return this.ngayHetHan;
}
public void setNgayHetHan (Date ngayHetHan){
this.ngayHetHan= ngayHetHan;
}
 
public String getNoiCap (){
return this.noiCap;
}
public void setNoiCap (String noiCap){
this.noiCap= noiCap;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCap (){
return this.ngayCap;
}
public void setNgayCap (Date ngayCap){
this.ngayCap= ngayCap;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoId")
public Tbl_CanBo getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Tbl_CanBo canBoId){
this.canBoId = canBoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="loaiChungChiId")
public Tbl_QLDT_DM_LoaiChungChi getLoaiChungChiId (){
return this.loaiChungChiId;
}
public void setLoaiChungChiId (Tbl_QLDT_DM_LoaiChungChi loaiChungChiId){
this.loaiChungChiId = loaiChungChiId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
}//endClass
