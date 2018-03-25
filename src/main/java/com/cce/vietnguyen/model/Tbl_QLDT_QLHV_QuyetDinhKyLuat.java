


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
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLHV_QuyetDinhKyLuat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_QuyetDinhKyLuat implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
  private Date ngayKy;
  private Date tuNgay;
  private Date denNgay;
  private String noiDung;
  private Boolean khongXetTotNgiepYN;
 
private Tbl_CanBo canBoId;
 
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
 
public String getMa (){
return this.ma;
}
public void setMa (String ma){
this.ma= ma;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayKy (){
return this.ngayKy;
}
public void setNgayKy (Date ngayKy){
this.ngayKy= ngayKy;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getTuNgay (){
return this.tuNgay;
}
public void setTuNgay (Date tuNgay){
this.tuNgay= tuNgay;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getDenNgay (){
return this.denNgay;
}
public void setDenNgay (Date denNgay){
this.denNgay= denNgay;
}
 
public String getNoiDung (){
return this.noiDung;
}
public void setNoiDung (String noiDung){
this.noiDung= noiDung;
}
  public Boolean getKhongXetTotNgiepYN (){
return this.khongXetTotNgiepYN;
}
public void setKhongXetTotNgiepYN (Boolean khongXetTotNgiepYN){
this.khongXetTotNgiepYN= khongXetTotNgiepYN;
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
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
}//endClass
