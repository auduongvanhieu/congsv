


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
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_DKMH_HocVien_CoSo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_HocVien_CoSo implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String ma;
 
private Tbl_QLDT_DM_CoSo coSoId;
  private Double hocKyId;
  private Double hocVienId;

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
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="coSoId")
public Tbl_QLDT_DM_CoSo getCoSoId (){
return this.coSoId;
}
public void setCoSoId (Tbl_QLDT_DM_CoSo coSoId){
this.coSoId = coSoId;
}
 
public Double getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Double hocKyId){
this.hocKyId= hocKyId;
}
 
public Double getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Double hocVienId){
this.hocVienId= hocVienId;
}
}//endClass
