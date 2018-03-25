


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
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_DotDK;
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHocDuKien;
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
/*
*Object Template: Template/Server/ObbjectTemplate.java
*/
@Entity
@Table (name="tbl_QLDT_DKMH_KetQuaDK")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tbl_QLDT_DKMH_KetQuaDK implements Serializable {
private static final long serialVersionUID = -1989579066723007050L;
//variable
 
private Long id;
 
private Tbl_QLDT_QLHV_HocVien hocVienId;
 
private Tbl_QLDT_DKMH_DotDK dotDKId;
 
private Tbl_QLDT_TKB_LopMonHocDuKien lopDuKienId;
  private String maDieuChinh;
  private Boolean khoaMonHocYN;
  private String ketQua;
  private String ketQuaLyDo;
  private Boolean xacNhanYN;
  private Date ngayCapNhat;
  private Double hocPhi;
 
private Tbl_QLDT_CTDT_MonHoc monHocId;
 
private Tbl_QLDT_HocKyTrongNam hocKyId;
  private String ketQuaTKB;
  private String ketQuaLyDoTKB;
 
private Tbl_QLDT_DM_CoSo coSoId;

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
@JoinColumn(name="hocVienId")
public Tbl_QLDT_QLHV_HocVien getHocVienId (){
return this.hocVienId;
}
public void setHocVienId (Tbl_QLDT_QLHV_HocVien hocVienId){
this.hocVienId = hocVienId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="dotDKId")
public Tbl_QLDT_DKMH_DotDK getDotDKId (){
return this.dotDKId;
}
public void setDotDKId (Tbl_QLDT_DKMH_DotDK dotDKId){
this.dotDKId = dotDKId;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="lopDuKienId")
public Tbl_QLDT_TKB_LopMonHocDuKien getLopDuKienId (){
return this.lopDuKienId;
}
public void setLopDuKienId (Tbl_QLDT_TKB_LopMonHocDuKien lopDuKienId){
this.lopDuKienId = lopDuKienId;
}
 
public String getMaDieuChinh (){
return this.maDieuChinh;
}
public void setMaDieuChinh (String maDieuChinh){
this.maDieuChinh= maDieuChinh;
}
  public Boolean getKhoaMonHocYN (){
return this.khoaMonHocYN;
}
public void setKhoaMonHocYN (Boolean khoaMonHocYN){
this.khoaMonHocYN= khoaMonHocYN;
}
 
public String getKetQua (){
return this.ketQua;
}
public void setKetQua (String ketQua){
this.ketQua= ketQua;
}
 
public String getKetQuaLyDo (){
return this.ketQuaLyDo;
}
public void setKetQuaLyDo (String ketQuaLyDo){
this.ketQuaLyDo= ketQuaLyDo;
}
  public Boolean getXacNhanYN (){
return this.xacNhanYN;
}
public void setXacNhanYN (Boolean xacNhanYN){
this.xacNhanYN= xacNhanYN;
}
 
@JsonFormat(pattern = "dd-MM-yyyy")
public Date getNgayCapNhat (){
return this.ngayCapNhat;
}
public void setNgayCapNhat (Date ngayCapNhat){
this.ngayCapNhat= ngayCapNhat;
}
 
public Double getHocPhi (){
return this.hocPhi;
}
public void setHocPhi (Double hocPhi){
this.hocPhi= hocPhi;
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
@JoinColumn(name="hocKyId")
public Tbl_QLDT_HocKyTrongNam getHocKyId (){
return this.hocKyId;
}
public void setHocKyId (Tbl_QLDT_HocKyTrongNam hocKyId){
this.hocKyId = hocKyId;
}
 
public String getKetQuaTKB (){
return this.ketQuaTKB;
}
public void setKetQuaTKB (String ketQuaTKB){
this.ketQuaTKB= ketQuaTKB;
}
 
public String getKetQuaLyDoTKB (){
return this.ketQuaLyDoTKB;
}
public void setKetQuaLyDoTKB (String ketQuaLyDoTKB){
this.ketQuaLyDoTKB= ketQuaLyDoTKB;
}
 
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="coSoId")
public Tbl_QLDT_DM_CoSo getCoSoId (){
return this.coSoId;
}
public void setCoSoId (Tbl_QLDT_DM_CoSo coSoId){
this.coSoId = coSoId;
}
}//endClass
