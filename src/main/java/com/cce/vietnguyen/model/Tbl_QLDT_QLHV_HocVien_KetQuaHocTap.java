


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
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLHV_HocVien_KetQuaHocTap")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLHV_HocVien_KetQuaHocTap implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
 
private Tbl_QLDT_CTDT_MonHoc monHocId;
  private Double diem10;
  private Double diem4;
  private String diemChu;
  private String xepLoai;
  private Boolean datYN;
  private Date ngayCapNhat;
  private String ghiChu;
 
private Tbl_CanBo canBoId;
  private Integer soLanHoc;

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
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHocId")
public Tbl_QLDT_CTDT_MonHoc getMonHocId (){
return this.monHocId;
}
public void setMonHocId (Tbl_QLDT_CTDT_MonHoc monHocId){
this.monHocId = monHocId;
}
 
public Double getDiem10 (){
return this.diem10;
}
public void setDiem10 (Double diem10){
this.diem10= diem10;
}
 
public Double getDiem4 (){
return this.diem4;
}
public void setDiem4 (Double diem4){
this.diem4= diem4;
}
 
public String getDiemChu (){
return this.diemChu;
}
public void setDiemChu (String diemChu){
this.diemChu= diemChu;
}
 
public String getXepLoai (){
return this.xepLoai;
}
public void setXepLoai (String xepLoai){
this.xepLoai= xepLoai;
}
  public Boolean getDatYN (){
return this.datYN;
}
public void setDatYN (Boolean datYN){
this.datYN= datYN;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapNhat (){
return this.ngayCapNhat;
}
public void setNgayCapNhat (Date ngayCapNhat){
this.ngayCapNhat= ngayCapNhat;
}
 
public String getGhiChu (){
return this.ghiChu;
}
public void setGhiChu (String ghiChu){
this.ghiChu= ghiChu;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoId")
public Tbl_CanBo getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Tbl_CanBo canBoId){
this.canBoId = canBoId;
}
 
public Integer getSoLanHoc (){
return this.soLanHoc;
}
public void setSoLanHoc (Integer soLanHoc){
this.soLanHoc= soLanHoc;
}
}//endClass
