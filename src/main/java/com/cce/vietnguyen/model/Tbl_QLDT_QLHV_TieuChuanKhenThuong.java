


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_KhoiNganh;
 
 
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLHV_TieuChuanKhenThuong")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_TieuChuanKhenThuong implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
 
private Tbl_QLDT_CTDT_KhoiNganh khoiNganhId;
  private Integer soTinChiMin;
  private Double diemLoaiKha;
  private Double diemLoaiGioi;
  private Double phanTramKha;
  private Double phanTramGioi;

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
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="khoiNganhId")
public Tbl_QLDT_CTDT_KhoiNganh getKhoiNganhId (){
return this.khoiNganhId;
}
public void setKhoiNganhId (Tbl_QLDT_CTDT_KhoiNganh khoiNganhId){
this.khoiNganhId = khoiNganhId;
}
 
public Integer getSoTinChiMin (){
return this.soTinChiMin;
}
public void setSoTinChiMin (Integer soTinChiMin){
this.soTinChiMin= soTinChiMin;
}
 
public Double getDiemLoaiKha (){
return this.diemLoaiKha;
}
public void setDiemLoaiKha (Double diemLoaiKha){
this.diemLoaiKha= diemLoaiKha;
}
 
public Double getDiemLoaiGioi (){
return this.diemLoaiGioi;
}
public void setDiemLoaiGioi (Double diemLoaiGioi){
this.diemLoaiGioi= diemLoaiGioi;
}
 
public Double getPhanTramKha (){
return this.phanTramKha;
}
public void setPhanTramKha (Double phanTramKha){
this.phanTramKha= phanTramKha;
}
 
public Double getPhanTramGioi (){
return this.phanTramGioi;
}
public void setPhanTramGioi (Double phanTramGioi){
this.phanTramGioi= phanTramGioi;
}
}//endClass
