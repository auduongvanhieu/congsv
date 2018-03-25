


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_KhoiNganh;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TKB_LopMonHoc_KhoiNganh")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TKB_LopMonHoc_KhoiNganh implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_TKB_LopMonHoc lopMonHocId;
 
private Tbl_QLDT_CTDT_KhoiNganh khoiNganhId;

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
@JoinColumn(name="lopMonHocId")
public Tbl_QLDT_TKB_LopMonHoc getLopMonHocId (){
return this.lopMonHocId;
}
public void setLopMonHocId (Tbl_QLDT_TKB_LopMonHoc lopMonHocId){
this.lopMonHocId = lopMonHocId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="khoiNganhId")
public Tbl_QLDT_CTDT_KhoiNganh getKhoiNganhId (){
return this.khoiNganhId;
}
public void setKhoiNganhId (Tbl_QLDT_CTDT_KhoiNganh khoiNganhId){
this.khoiNganhId = khoiNganhId;
}
}//endClass
