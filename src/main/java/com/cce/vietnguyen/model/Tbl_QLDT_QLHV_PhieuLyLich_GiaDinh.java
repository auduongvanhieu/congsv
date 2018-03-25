


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
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLHV_PhieuLyLich_GiaDinh")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_PhieuLyLich_GiaDinh implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ghiChu;
  private String hoTen;
  private String thuongTru;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
  private String loaiQuanHe;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
public String getHoTen (){
return this.hoTen;
}
public void setHoTen (String hoTen){
this.hoTen= hoTen;
}
 
public String getThuongTru (){
return this.thuongTru;
}
public void setThuongTru (String thuongTru){
this.thuongTru= thuongTru;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
 
public String getLoaiQuanHe (){
return this.loaiQuanHe;
}
public void setLoaiQuanHe (String loaiQuanHe){
this.loaiQuanHe= loaiQuanHe;
}
}//endClass
