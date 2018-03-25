


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
@Table (name="tbl_QLDT_QLHV_TaiKhoan")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_TaiKhoan implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double soDuTaiKhoan;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
  private Date ngayCapNhat;
 
private Tbl_CanBo canBoId;
  private Double ghiNo;
  private Double ghiCo;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getSoDuTaiKhoan (){
return this.soDuTaiKhoan;
}
public void setSoDuTaiKhoan (Double soDuTaiKhoan){
this.soDuTaiKhoan= soDuTaiKhoan;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapNhat (){
return this.ngayCapNhat;
}
public void setNgayCapNhat (Date ngayCapNhat){
this.ngayCapNhat= ngayCapNhat;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoId")
public Tbl_CanBo getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Tbl_CanBo canBoId){
this.canBoId = canBoId;
}
 
public Double getGhiNo (){
return this.ghiNo;
}
public void setGhiNo (Double ghiNo){
this.ghiNo= ghiNo;
}
 
public Double getGhiCo (){
return this.ghiCo;
}
public void setGhiCo (Double ghiCo){
this.ghiCo= ghiCo;
}
}//endClass
