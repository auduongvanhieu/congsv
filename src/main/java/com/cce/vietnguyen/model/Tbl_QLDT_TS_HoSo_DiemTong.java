


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSoXetTuyen;
 
 
 
 
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TS_HoSo_DiemTong")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TS_HoSo_DiemTong implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_TS_HoSoXetTuyen hoSoId;
  private Double diemTong;
  private Double diemXetTuyen;
  private Double diemThiDH;
  private Double diemXetTuyenDH;
  private String ketQua;
  private Date ngayXetTuyen;
 
private Tbl_CanBo canBoId;

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
@JoinColumn(name="hoSoId")
public Tbl_QLDT_TS_HoSoXetTuyen getHoSoId (){
return this.hoSoId;
}
public void setHoSoId (Tbl_QLDT_TS_HoSoXetTuyen hoSoId){
this.hoSoId = hoSoId;
}
 
public Double getDiemTong (){
return this.diemTong;
}
public void setDiemTong (Double diemTong){
this.diemTong= diemTong;
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
 
public Double getDiemXetTuyenDH (){
return this.diemXetTuyenDH;
}
public void setDiemXetTuyenDH (Double diemXetTuyenDH){
this.diemXetTuyenDH= diemXetTuyenDH;
}
 
public String getKetQua (){
return this.ketQua;
}
public void setKetQua (String ketQua){
this.ketQua= ketQua;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayXetTuyen (){
return this.ngayXetTuyen;
}
public void setNgayXetTuyen (Date ngayXetTuyen){
this.ngayXetTuyen= ngayXetTuyen;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="canBoId")
public Tbl_CanBo getCanBoId (){
return this.canBoId;
}
public void setCanBoId (Tbl_CanBo canBoId){
this.canBoId = canBoId;
}
}//endClass
