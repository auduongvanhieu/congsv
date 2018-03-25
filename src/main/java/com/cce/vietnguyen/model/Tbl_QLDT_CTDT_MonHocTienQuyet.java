


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_KhoiNganh;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_CTDT_MonHocTienQuyet")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_CTDT_MonHocTienQuyet implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_CTDT_MonHoc monHoc1Id;
 
private Tbl_QLDT_CTDT_MonHoc monHoc2Id;
  private String loaiTQ;
 
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
@JoinColumn(name="monHoc1Id")
public Tbl_QLDT_CTDT_MonHoc getMonHoc1Id (){
return this.monHoc1Id;
}
public void setMonHoc1Id (Tbl_QLDT_CTDT_MonHoc monHoc1Id){
this.monHoc1Id = monHoc1Id;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHoc2Id")
public Tbl_QLDT_CTDT_MonHoc getMonHoc2Id (){
return this.monHoc2Id;
}
public void setMonHoc2Id (Tbl_QLDT_CTDT_MonHoc monHoc2Id){
this.monHoc2Id = monHoc2Id;
}
 
public String getLoaiTQ (){
return this.loaiTQ;
}
public void setLoaiTQ (String loaiTQ){
this.loaiTQ= loaiTQ;
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
