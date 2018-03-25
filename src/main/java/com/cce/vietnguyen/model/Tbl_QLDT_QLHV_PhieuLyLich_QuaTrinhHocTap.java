


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
@Table (name="tbl_QLDT_QLHV_PhieuLyLich_QuaTrinhHocTap")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_PhieuLyLich_QuaTrinhHocTap implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String bangCap;
  private String thanhTich;
  private String kyLuat;
 
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
 
public String getBangCap (){
return this.bangCap;
}
public void setBangCap (String bangCap){
this.bangCap= bangCap;
}
 
public String getThanhTich (){
return this.thanhTich;
}
public void setThanhTich (String thanhTich){
this.thanhTich= thanhTich;
}
 
public String getKyLuat (){
return this.kyLuat;
}
public void setKyLuat (String kyLuat){
this.kyLuat= kyLuat;
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
