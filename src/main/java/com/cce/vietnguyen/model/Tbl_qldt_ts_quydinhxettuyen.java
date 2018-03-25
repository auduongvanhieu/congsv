


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
 
 
  import com.cce.vietnguyen.model.Tbl_qldt_ts_dm_hanhkiem;
  import com.cce.vietnguyen.model.Tbl_qldt_ts_khoituyensinh;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_qldt_ts_quydinhxettuyen")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_qldt_ts_quydinhxettuyen implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double diemDat;
 
private Tbl_qldt_ts_dm_hanhkiem hanhKiemId;
 
private Tbl_qldt_ts_khoituyensinh khoiTuyenSinhId;
  private Double nganhId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getDiemDat (){
return this.diemDat;
}
public void setDiemDat (Double diemDat){
this.diemDat= diemDat;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hanhKiemId")
public Tbl_qldt_ts_dm_hanhkiem getHanhKiemId (){
return this.hanhKiemId;
}
public void setHanhKiemId (Tbl_qldt_ts_dm_hanhkiem hanhKiemId){
this.hanhKiemId = hanhKiemId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="khoiTuyenSinhId")
public Tbl_qldt_ts_khoituyensinh getKhoiTuyenSinhId (){
return this.khoiTuyenSinhId;
}
public void setKhoiTuyenSinhId (Tbl_qldt_ts_khoituyensinh khoiTuyenSinhId){
this.khoiTuyenSinhId = khoiTuyenSinhId;
}
 
public Double getNganhId (){
return this.nganhId;
}
public void setNganhId (Double nganhId){
this.nganhId= nganhId;
}
}//endClass
