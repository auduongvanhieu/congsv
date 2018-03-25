


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
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_ThongBaoTuyenSinh;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_Nganh;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TS_DM_DiemDat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TS_DM_DiemDat implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private String ten;
  private Double diemXetTuyen;
  private Double diemThiDH;
  private String khoiThi;
 
private Tbl_QLDT_TS_ThongBaoTuyenSinh thongBaoId;
 
private Tbl_QLDT_CTDT_Nganh nganhId;

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
 
public String getTen (){
return this.ten;
}
public void setTen (String ten){
this.ten= ten;
}
 
public Double getDiemXetTuyen (){
return this.diemXetTuyen;
}
public void setDiemXetTuyen (Double diemXetTuyen){
this.diemXetTuyen= diemXetTuyen;
}
 
public Double getDiemThiDH (){
return this.diemThiDH;
}
public void setDiemThiDH (Double diemThiDH){
this.diemThiDH= diemThiDH;
}
 
public String getKhoiThi (){
return this.khoiThi;
}
public void setKhoiThi (String khoiThi){
this.khoiThi= khoiThi;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="thongBaoId")
public Tbl_QLDT_TS_ThongBaoTuyenSinh getThongBaoId (){
return this.thongBaoId;
}
public void setThongBaoId (Tbl_QLDT_TS_ThongBaoTuyenSinh thongBaoId){
this.thongBaoId = thongBaoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="nganhId")
public Tbl_QLDT_CTDT_Nganh getNganhId (){
return this.nganhId;
}
public void setNganhId (Tbl_QLDT_CTDT_Nganh nganhId){
this.nganhId = nganhId;
}
}//endClass
