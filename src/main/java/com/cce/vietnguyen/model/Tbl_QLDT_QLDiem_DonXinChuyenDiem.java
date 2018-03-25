


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
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLDiem_DonXinChuyenDiem")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLDiem_DonXinChuyenDiem implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private Date ngayNop;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
 
private Tbl_CanBo canBoNhanId;
  private Boolean daXetYN;
 
private Tbl_CanBo canBoXetId;
  private String trangThai;

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
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayNop (){
return this.ngayNop;
}
public void setNgayNop (Date ngayNop){
this.ngayNop= ngayNop;
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
@JoinColumn(name="canBoNhanId")
public Tbl_CanBo getCanBoNhanId (){
return this.canBoNhanId;
}
public void setCanBoNhanId (Tbl_CanBo canBoNhanId){
this.canBoNhanId = canBoNhanId;
}
  public Boolean getDaXetYN (){
return this.daXetYN;
}
public void setDaXetYN (Boolean daXetYN){
this.daXetYN= daXetYN;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoXetId")
public Tbl_CanBo getCanBoXetId (){
return this.canBoXetId;
}
public void setCanBoXetId (Tbl_CanBo canBoXetId){
this.canBoXetId = canBoXetId;
}
 
public String getTrangThai (){
return this.trangThai;
}
public void setTrangThai (String trangThai){
this.trangThai= trangThai;
}
}//endClass
