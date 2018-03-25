


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_DM_GiayTo;
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_BienNhanHoSo;
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TS_BienNhanHoSo_GiayTo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TS_BienNhanHoSo_GiayTo implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_TS_DM_GiayTo giayToId;
 
private Tbl_QLDT_TS_BienNhanHoSo bienNhanId;
  private Boolean co;
  private Double hoSoId;

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
@JoinColumn(name="giayToId")
public Tbl_QLDT_TS_DM_GiayTo getGiayToId (){
return this.giayToId;
}
public void setGiayToId (Tbl_QLDT_TS_DM_GiayTo giayToId){
this.giayToId = giayToId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="bienNhanId")
public Tbl_QLDT_TS_BienNhanHoSo getBienNhanId (){
return this.bienNhanId;
}
public void setBienNhanId (Tbl_QLDT_TS_BienNhanHoSo bienNhanId){
this.bienNhanId = bienNhanId;
}
  public Boolean getCo (){
return this.co;
}
public void setCo (Boolean co){
this.co= co;
}
 
public Double getHoSoId (){
return this.hoSoId;
}
public void setHoSoId (Double hoSoId){
this.hoSoId= hoSoId;
}
}//endClass
