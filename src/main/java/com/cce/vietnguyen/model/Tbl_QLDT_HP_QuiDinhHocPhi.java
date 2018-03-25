


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
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_HeDaoTao;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_ChuyenNganh;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_HP_QuiDinhHocPhi")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_HP_QuiDinhHocPhi implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double donGiaTinChiLT;
  private Double donGiaTinChiTH;
  private Double hocPhiHocKy;
 
private Tbl_QLDT_CTDT_HeDaoTao heDaoTaoId;
 
private Tbl_QLDT_CTDT_ChuyenNganh chuyenNganhId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getDonGiaTinChiLT (){
return this.donGiaTinChiLT;
}
public void setDonGiaTinChiLT (Double donGiaTinChiLT){
this.donGiaTinChiLT= donGiaTinChiLT;
}
 
public Double getDonGiaTinChiTH (){
return this.donGiaTinChiTH;
}
public void setDonGiaTinChiTH (Double donGiaTinChiTH){
this.donGiaTinChiTH= donGiaTinChiTH;
}
 
public Double getHocPhiHocKy (){
return this.hocPhiHocKy;
}
public void setHocPhiHocKy (Double hocPhiHocKy){
this.hocPhiHocKy= hocPhiHocKy;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="heDaoTaoId")
public Tbl_QLDT_CTDT_HeDaoTao getHeDaoTaoId (){
return this.heDaoTaoId;
}
public void setHeDaoTaoId (Tbl_QLDT_CTDT_HeDaoTao heDaoTaoId){
this.heDaoTaoId = heDaoTaoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="chuyenNganhId")
public Tbl_QLDT_CTDT_ChuyenNganh getChuyenNganhId (){
return this.chuyenNganhId;
}
public void setChuyenNganhId (Tbl_QLDT_CTDT_ChuyenNganh chuyenNganhId){
this.chuyenNganhId = chuyenNganhId;
}
}//endClass
