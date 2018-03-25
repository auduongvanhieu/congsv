


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
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TonGiao;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_DanToc;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_SoYeuLyLich")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_SoYeuLyLich implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String email;
  private String diaChi;
  private String dienThoai;
  private Date ngaySinh;
  private String noiSinh;
  private String tamTru;
 
private Tbl_QLDT_DM_TonGiao tonGiaoId;
 
private Tbl_QLDT_DM_DanToc danTocId;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getEmail (){
return this.email;
}
public void setEmail (String email){
this.email= email;
}
 
public String getDiaChi (){
return this.diaChi;
}
public void setDiaChi (String diaChi){
this.diaChi= diaChi;
}
 
public String getDienThoai (){
return this.dienThoai;
}
public void setDienThoai (String dienThoai){
this.dienThoai= dienThoai;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgaySinh (){
return this.ngaySinh;
}
public void setNgaySinh (Date ngaySinh){
this.ngaySinh= ngaySinh;
}
 
public String getNoiSinh (){
return this.noiSinh;
}
public void setNoiSinh (String noiSinh){
this.noiSinh= noiSinh;
}
 
public String getTamTru (){
return this.tamTru;
}
public void setTamTru (String tamTru){
this.tamTru= tamTru;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="tonGiaoId")
public Tbl_QLDT_DM_TonGiao getTonGiaoId (){
return this.tonGiaoId;
}
public void setTonGiaoId (Tbl_QLDT_DM_TonGiao tonGiaoId){
this.tonGiaoId = tonGiaoId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="danTocId")
public Tbl_QLDT_DM_DanToc getDanTocId (){
return this.danTocId;
}
public void setDanTocId (Tbl_QLDT_DM_DanToc danTocId){
this.danTocId = danTocId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
}//endClass
