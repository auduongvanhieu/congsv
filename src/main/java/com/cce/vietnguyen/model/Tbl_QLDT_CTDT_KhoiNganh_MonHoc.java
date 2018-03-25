


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_KhoiNganh;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_NhomTuChon;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_CTDT_KhoiNganh_MonHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_CTDT_KhoiNganh_MonHoc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_CTDT_KhoiNganh khoiNganhId;
 
private Tbl_QLDT_CTDT_MonHoc monHocId;
  private String hocKy;
  private String loaiMH;
  private Integer stt;
  private String ghiChu;
 
private Tbl_QLDT_CTDT_NhomTuChon nhomTuChonId;

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
@JoinColumn(name="khoiNganhId")
public Tbl_QLDT_CTDT_KhoiNganh getKhoiNganhId (){
return this.khoiNganhId;
}
public void setKhoiNganhId (Tbl_QLDT_CTDT_KhoiNganh khoiNganhId){
this.khoiNganhId = khoiNganhId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHocId")
public Tbl_QLDT_CTDT_MonHoc getMonHocId (){
return this.monHocId;
}
public void setMonHocId (Tbl_QLDT_CTDT_MonHoc monHocId){
this.monHocId = monHocId;
}
 
public String getHocKy (){
return this.hocKy;
}
public void setHocKy (String hocKy){
this.hocKy= hocKy;
}
 
public String getLoaiMH (){
return this.loaiMH;
}
public void setLoaiMH (String loaiMH){
this.loaiMH= loaiMH;
}
 
public Integer getStt (){
return this.stt;
}
public void setStt (Integer stt){
this.stt= stt;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="nhomTuChonId")
public Tbl_QLDT_CTDT_NhomTuChon getNhomTuChonId (){
return this.nhomTuChonId;
}
public void setNhomTuChonId (Tbl_QLDT_CTDT_NhomTuChon nhomTuChonId){
this.nhomTuChonId = nhomTuChonId;
}
}//endClass
