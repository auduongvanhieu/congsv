


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
 
 
  import com.cce.vietnguyen.model.Tbl_qldt_ts_khoituyensinh;
  import com.cce.vietnguyen.model.Tbl_qldt_ts_dm_monhoc;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_qldt_ts_khoituyensinh_monhoc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_qldt_ts_khoituyensinh_monhoc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double diemToiThieu;
 
private Tbl_qldt_ts_khoituyensinh khoiTuyenSinhId;
 
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
 
public Double getDiemToiThieu (){
return this.diemToiThieu;
}
public void setDiemToiThieu (Double diemToiThieu){
this.diemToiThieu= diemToiThieu;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="khoiTuyenSinhId")
public Tbl_qldt_ts_khoituyensinh getKhoiTuyenSinhId (){
return this.khoiTuyenSinhId;
}
public void setKhoiTuyenSinhId (Tbl_qldt_ts_khoituyensinh khoiTuyenSinhId){
this.khoiTuyenSinhId = khoiTuyenSinhId;
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
