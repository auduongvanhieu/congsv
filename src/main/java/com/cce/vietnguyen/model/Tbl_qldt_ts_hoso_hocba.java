


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
 
 
 
  import com.cce.vietnguyen.model.Tbl_qldt_ts_dm_hockythpt;
  import com.cce.vietnguyen.model.Tbl_qldt_ts_dm_monhoc;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_qldt_ts_hoso_hocba")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_qldt_ts_hoso_hocba implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double diem;
  private Double hoSoId;
 
private Tbl_qldt_ts_dm_hockythpt hocKyId;
 
private Tbl_qldt_ts_dm_monhoc monHocId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getDiem (){
return this.diem;
}
public void setDiem (Double diem){
this.diem= diem;
}
 
public Double getHoSoId (){
return this.hoSoId;
}
public void setHoSoId (Double hoSoId){
this.hoSoId= hoSoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocKyId")
public Tbl_qldt_ts_dm_hockythpt getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_qldt_ts_dm_hockythpt hocKyId){
this.hocKyId = hocKyId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHocId")
public Tbl_qldt_ts_dm_monhoc getMonHocId (){
return this.monHocId;
}
public void setMonHocId (Tbl_qldt_ts_dm_monhoc monHocId){
this.monHocId = monHocId;
}
}//endClass
