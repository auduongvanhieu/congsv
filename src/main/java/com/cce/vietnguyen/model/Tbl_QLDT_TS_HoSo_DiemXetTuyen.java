


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSoXetTuyen;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_ThangDiem;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_TS_HoSo_DiemXetTuyen")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_TS_HoSo_DiemXetTuyen implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_TS_HoSoXetTuyen hoSoId;
 
private Tbl_QLDT_DM_ThangDiem thangDiemId;

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
@JoinColumn(name="hoSoId")
public Tbl_QLDT_TS_HoSoXetTuyen getHoSoId (){
return this.hoSoId;
}
public void setHoSoId (Tbl_QLDT_TS_HoSoXetTuyen hoSoId){
this.hoSoId = hoSoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="thangDiemId")
public Tbl_QLDT_DM_ThangDiem getThangDiemId (){
return this.thangDiemId;
}
public void setThangDiemId (Tbl_QLDT_DM_ThangDiem thangDiemId){
this.thangDiemId = thangDiemId;
}
}//endClass
