


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
@Table (name="tbl_QLDT_BangDiem")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_BangDiem implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
  private String url;
  private String danhsach;
  private String canBoLuu;
  private Integer ma;
  private String canBoChamThi1;
  private String canBoChamThi2;
  private Integer siSo;
 
private Tbl_QLDT_LichThi lichThiId;
  private Integer siSoVang;
  private Date ngayTao;
  private Date ngayLuu;
  private Boolean khoaYN;
  private Boolean huyYN;
  private String canBoTao;

//get/set
 
@Id
@GeneratedValue
public Long getId (){
return this.id;
}
public void setId (Long id){
this.id = id;
}
 
public String getUrl (){
return this.url;
}
public void setUrl (String url){
this.url= url;
}
 
public String getDanhsach (){
return this.danhsach;
}
public void setDanhsach (String danhsach){
this.danhsach= danhsach;
}
 
public String getCanBoLuu (){
return this.canBoLuu;
}
public void setCanBoLuu (String canBoLuu){
this.canBoLuu= canBoLuu;
}
 
public Integer getMa (){
return this.ma;
}
public void setMa (Integer ma){
this.ma= ma;
}
 
public String getCanBoChamThi1 (){
return this.canBoChamThi1;
}
public void setCanBoChamThi1 (String canBoChamThi1){
this.canBoChamThi1= canBoChamThi1;
}
 
public String getCanBoChamThi2 (){
return this.canBoChamThi2;
}
public void setCanBoChamThi2 (String canBoChamThi2){
this.canBoChamThi2= canBoChamThi2;
}
 
public Integer getSiSo (){
return this.siSo;
}
public void setSiSo (Integer siSo){
this.siSo= siSo;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lichThiId")
public Tbl_QLDT_LichThi getLichThiId (){
return this.lichThiId;
}
public void setLichThiId (Tbl_QLDT_LichThi lichThiId){
this.lichThiId = lichThiId;
}
 
public Integer getSiSoVang (){
return this.siSoVang;
}
public void setSiSoVang (Integer siSoVang){
this.siSoVang= siSoVang;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayTao (){
return this.ngayTao;
}
public void setNgayTao (Date ngayTao){
this.ngayTao= ngayTao;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayLuu (){
return this.ngayLuu;
}
public void setNgayLuu (Date ngayLuu){
this.ngayLuu= ngayLuu;
}
  public Boolean getKhoaYN (){
return this.khoaYN;
}
public void setKhoaYN (Boolean khoaYN){
this.khoaYN= khoaYN;
}
  public Boolean getHuyYN (){
return this.huyYN;
}
public void setHuyYN (Boolean huyYN){
this.huyYN= huyYN;
}
 
public String getCanBoTao (){
return this.canBoTao;
}
public void setCanBoTao (String canBoTao){
this.canBoTao= canBoTao;
}
}//endClass
