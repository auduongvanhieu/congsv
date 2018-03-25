


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
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_HP_HocVien_HocPhi;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_HP_HocVien_HocPhi_MonHoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_HP_HocVien_HocPhi_MonHoc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double hocPhiMonHoc;
  private Boolean mienMon;
  private Double thanhTien;
 
private Tbl_QLDT_CTDT_MonHoc monHocId;
 
private Tbl_QLDT_HP_HocVien_HocPhi hocVienHocPhiId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getHocPhiMonHoc (){
return this.hocPhiMonHoc;
}
public void setHocPhiMonHoc (Double hocPhiMonHoc){
this.hocPhiMonHoc= hocPhiMonHoc;
}
  public Boolean getMienMon (){
return this.mienMon;
}
public void setMienMon (Boolean mienMon){
this.mienMon= mienMon;
}
 
public Double getThanhTien (){
return this.thanhTien;
}
public void setThanhTien (Double thanhTien){
this.thanhTien= thanhTien;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHocId")
public Tbl_QLDT_CTDT_MonHoc getMonHocId (){
return this.monHocId;
}
public void setMonHocId (Tbl_QLDT_CTDT_MonHoc monHocId){
this.monHocId = monHocId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienHocPhiId")
public Tbl_QLDT_HP_HocVien_HocPhi getHocVienHocPhiId (){
return this.hocVienHocPhiId;
}
public void setHocVienHocPhiId (Tbl_QLDT_HP_HocVien_HocPhi hocVienHocPhiId){
this.hocVienHocPhiId = hocVienHocPhiId;
}
}//endClass
