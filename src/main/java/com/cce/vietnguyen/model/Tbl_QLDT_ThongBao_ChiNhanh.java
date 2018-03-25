


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
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_ThongBaoTuyenSinh;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_ChiNhanh;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_ThongBao_ChiNhanh")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_ThongBao_ChiNhanh implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Boolean co;
 
private Tbl_QLDT_TS_ThongBaoTuyenSinh thongBaoId;
 
private Tbl_QLDT_DM_ChiNhanh chiNhanhId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
  public Boolean getCo (){
return this.co;
}
public void setCo (Boolean co){
this.co= co;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="thongBaoId")
public Tbl_QLDT_TS_ThongBaoTuyenSinh getThongBaoId (){
return this.thongBaoId;
}
public void setThongBaoId (Tbl_QLDT_TS_ThongBaoTuyenSinh thongBaoId){
this.thongBaoId = thongBaoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="chiNhanhId")
public Tbl_QLDT_DM_ChiNhanh getChiNhanhId (){
return this.chiNhanhId;
}
public void setChiNhanhId (Tbl_QLDT_DM_ChiNhanh chiNhanhId){
this.chiNhanhId = chiNhanhId;
}
}//endClass
