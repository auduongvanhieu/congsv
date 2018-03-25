


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLDiem_DonXinChuyenDiem;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
 
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_QLDiem_DonXinChuyenDiem donXinChuyenDiemId;
 
private Tbl_QLDT_CTDT_MonHoc monHocId;
  private Boolean chapNhanYN;
  private String lyDo;
  private Double diem;

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
@JoinColumn(name="donXinChuyenDiemId")
public Tbl_QLDT_QLDiem_DonXinChuyenDiem getDonXinChuyenDiemId (){
return this.donXinChuyenDiemId;
}
public void setDonXinChuyenDiemId (Tbl_QLDT_QLDiem_DonXinChuyenDiem donXinChuyenDiemId){
this.donXinChuyenDiemId = donXinChuyenDiemId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHocId")
public Tbl_QLDT_CTDT_MonHoc getMonHocId (){
return this.monHocId;
}
public void setMonHocId (Tbl_QLDT_CTDT_MonHoc monHocId){
this.monHocId = monHocId;
}
  public Boolean getChapNhanYN (){
return this.chapNhanYN;
}
public void setChapNhanYN (Boolean chapNhanYN){
this.chapNhanYN= chapNhanYN;
}
 
public String getLyDo (){
return this.lyDo;
}
public void setLyDo (String lyDo){
this.lyDo= lyDo;
}
 
public Double getDiem (){
return this.diem;
}
public void setDiem (Double diem){
this.diem= diem;
}
}//endClass
