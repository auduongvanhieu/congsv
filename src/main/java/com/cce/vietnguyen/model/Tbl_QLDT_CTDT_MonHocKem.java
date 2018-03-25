


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
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_CTDT_MonHocKem")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_CTDT_MonHocKem implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_CTDT_MonHoc monHocId;
 
private Tbl_QLDT_CTDT_MonHoc monHocKemId;

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
@JoinColumn(name="monHocId")
public Tbl_QLDT_CTDT_MonHoc getMonHocId (){
return this.monHocId;
}
public void setMonHocId (Tbl_QLDT_CTDT_MonHoc monHocId){
this.monHocId = monHocId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="monHocKemId")
public Tbl_QLDT_CTDT_MonHoc getMonHocKemId (){
return this.monHocKemId;
}
public void setMonHocKemId (Tbl_QLDT_CTDT_MonHoc monHocKemId){
this.monHocKemId = monHocKemId;
}
}//endClass
