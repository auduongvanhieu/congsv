


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
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
 
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_HocVien_TamDung_HocKy")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_HocVien_TamDung_HocKy implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String lyDo;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
  private Integer qdPDT;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getLyDo (){
return this.lyDo;
}
public void setLyDo (String lyDo){
this.lyDo= lyDo;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
 
public Integer getQdPDT (){
return this.qdPDT;
}
public void setQdPDT (Integer qdPDT){
this.qdPDT= qdPDT;
}
}//endClass
