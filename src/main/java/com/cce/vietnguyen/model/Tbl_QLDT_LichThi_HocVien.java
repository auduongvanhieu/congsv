


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
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_LichThi;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_LichThi_HocVien")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_LichThi_HocVien implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Integer hocVienId;
 
private Tbl_QLDT_LichThi lichThiId;
  private Integer stt;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Integer getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Integer hocVienId){
this.hocVienId= hocVienId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lichThiId")
public Tbl_QLDT_LichThi getLichThiId (){
return this.lichThiId;
}
public void setLichThiId (Tbl_QLDT_LichThi lichThiId){
this.lichThiId = lichThiId;
}
 
public Integer getStt (){
return this.stt;
}
public void setStt (Integer stt){
this.stt= stt;
}
}//endClass
