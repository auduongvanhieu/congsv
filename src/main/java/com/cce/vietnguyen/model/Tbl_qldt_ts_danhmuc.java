


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
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_qldt_ts_danhmuc;
  import com.cce.vietnguyen.model.Tbl_qldt_ts_loaidanhmuc;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_qldt_ts_danhmuc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_qldt_ts_danhmuc implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private Double diemUuTien;
  private String ma;
  private String ten;
 
private Tbl_qldt_ts_danhmuc danhMucChaId;
 
private Tbl_qldt_ts_loaidanhmuc loaiDanhMucId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public Double getDiemUuTien (){
return this.diemUuTien;
}
public void setDiemUuTien (Double diemUuTien){
this.diemUuTien= diemUuTien;
}
 
public String getMa (){
return this.ma;
}
public void setMa (String ma){
this.ma= ma;
}
 
public String getTen (){
return this.ten;
}
public void setTen (String ten){
this.ten= ten;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="danhMucChaId")
public Tbl_qldt_ts_danhmuc getDanhMucChaId (){
return this.danhMucChaId;
}
public void setDanhMucChaId (Tbl_qldt_ts_danhmuc danhMucChaId){
this.danhMucChaId = danhMucChaId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="loaiDanhMucId")
public Tbl_qldt_ts_loaidanhmuc getLoaiDanhMucId (){
return this.loaiDanhMucId;
}
public void setLoaiDanhMucId (Tbl_qldt_ts_loaidanhmuc loaiDanhMucId){
this.loaiDanhMucId = loaiDanhMucId;
}
}//endClass
