


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
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSoXetTuyen;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TS_BienNhanHoSo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TS_BienNhanHoSo implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ghiChu;
  private Date ngayNhan;
  private String soBienLai;
 
private Tbl_CanBo canBoId;
 
private Tbl_QLDT_TS_HoSoXetTuyen hoSoId;

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
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayNhan (){
return this.ngayNhan;
}
public void setNgayNhan (Date ngayNhan){
this.ngayNhan= ngayNhan;
}
 
public String getSoBienLai (){
return this.soBienLai;
}
public void setSoBienLai (String soBienLai){
this.soBienLai= soBienLai;
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
@JoinColumn(name="hoSoId")
public Tbl_QLDT_TS_HoSoXetTuyen getHoSoId (){
return this.hoSoId;
}
public void setHoSoId (Tbl_QLDT_TS_HoSoXetTuyen hoSoId){
this.hoSoId = hoSoId;
}
}//endClass
