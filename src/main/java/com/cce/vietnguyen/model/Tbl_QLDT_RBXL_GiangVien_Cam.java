


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_NgayTrongTuan;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_RBXL_GiangVien_Cam")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_RBXL_GiangVien_Cam implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_GiangVien giangVienId;
 
private Tbl_QLDT_DM_NgayTrongTuan ngayId;
 
private Tbl_QLDT_DM_TietHoc tietBatDauId;
  private Integer soTiet;
  private Integer tuanDay;

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
@JoinColumn(name="giangVienId")
public Tbl_QLDT_GiangVien getGiangVienId (){
return this.giangVienId;
}
public void setGiangVienId (Tbl_QLDT_GiangVien giangVienId){
this.giangVienId = giangVienId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="ngayId")
public Tbl_QLDT_DM_NgayTrongTuan getNgayId (){
return this.ngayId;
}
public void setNgayId (Tbl_QLDT_DM_NgayTrongTuan ngayId){
this.ngayId = ngayId;
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
 
public Integer getTuanDay (){
return this.tuanDay;
}
public void setTuanDay (Integer tuanDay){
this.tuanDay= tuanDay;
}
}//endClass
