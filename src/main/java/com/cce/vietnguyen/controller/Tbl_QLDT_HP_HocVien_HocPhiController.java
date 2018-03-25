


package com.cce.vietnguyen.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.GenericRepository;
import com.cce.vietnguyen.repository.MyFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.cce.vietnguyen.model.Tbl_QLDT_HP_HocVien_HocPhi;
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
 
 
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_HP_HocVien_HocPhiController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_hp_hocvien_hocphi", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_HP_HocVien_HocPhi .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_hp_hocvien_hocphi/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_hocvien_hocphi", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
try{
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
if(pageSize == null || pageSize == 0)
pageSize = 20;
else if(pageSize == -1){
pageSize = 0;
}
if(page == 0)
page = 1;
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_HP_HocVien_HocPhi .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_hp_hocvien_hocphi/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_hocvien_hocphi", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_HP_HocVien_HocPhi obj = (Tbl_QLDT_HP_HocVien_HocPhi) genericDAO.get(Tbl_QLDT_HP_HocVien_HocPhi .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_hp_hocvien_hocphi", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_HP_HocVien_HocPhi obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_hocvien_hocphi", "them")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
try {
Long id = genericDAO.save(obj);
obj.setId(id);
return new ResponseEntity(obj, HttpStatus.OK);
}
catch (DataIntegrityViolationException e) {
System.out.println("object already exist");
return new ResponseEntity(HttpStatus.CONFLICT);
}
}
@RequestMapping(value="/tbl_qldt_hp_hocvien_hocphi/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_hocvien_hocphi", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_HP_HocVien_HocPhi .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_hp_hocvien_hocphi", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_HP_HocVien_HocPhi obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_hocvien_hocphi", "sua")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
try {
genericDAO.saveOrUpdate(obj);
return new ResponseEntity(obj, HttpStatus.OK);
}
catch (DataIntegrityViolationException e) {
System.out.println("object already exist");
return new ResponseEntity(HttpStatus.CONFLICT);
}
}
@RequestMapping(value="/tbl_qldt_hp_hocvien_hocphi/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_hocvien_hocphi", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_HP_HocVien_HocPhi .class, cons), HttpStatus.OK);
}
private List<MyFilter> buildFilter(HttpServletRequest request){
List<MyFilter> cons = new ArrayList<MyFilter>();
//variable
  try{
if(request.getParameter( "id" ) != null){
MyFilter con = new MyFilter();
con.setCol("id");
con.setOperator("eq");
con.setValue1(new Long(request.getParameter("id").toString()));
cons.add(con);
}
}catch(Exception e){}
  if(request.getParameter( "soMonHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soMonHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soMonHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoMonHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soMonHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoMonHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toSoMonHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soMonHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoMonHoc").toString()));
cons.add(con);
}
  if(request.getParameter( "soTinChi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChi");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soTinChi").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTinChi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChi");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoTinChi").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTinChi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChi");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoTinChi").toString()));
cons.add(con);
}
  if(request.getParameter( "hocPhi" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocPhi");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("hocPhi").toString()));
cons.add(con);
}
if(request.getParameter( "fromHocPhi" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocPhi");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHocPhi").toString()));
cons.add(con);
}
if(request.getParameter( "toHocPhi" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocPhi");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHocPhi").toString()));
cons.add(con);
}
  if(request.getParameter( "tienPhaiDong" ) != null){
MyFilter con = new MyFilter();
con.setCol("tienPhaiDong");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("tienPhaiDong").toString()));
cons.add(con);
}
if(request.getParameter( "fromTienPhaiDong" ) != null){
MyFilter con = new MyFilter();
con.setCol("tienPhaiDong");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromTienPhaiDong").toString()));
cons.add(con);
}
if(request.getParameter( "toTienPhaiDong" ) != null){
MyFilter con = new MyFilter();
con.setCol("tienPhaiDong");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toTienPhaiDong").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "hocKyId" ) != null){
Tbl_QLDT_HocKyTrongNam obj =
new ObjectMapper().readValue(
request.getParameter("hocKyId")
, Tbl_QLDT_HocKyTrongNam.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("hocKyId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "hocVienId" ) != null){
Tbl_QLDT_QLHV_HocVien obj =
new ObjectMapper().readValue(
request.getParameter("hocVienId")
, Tbl_QLDT_QLHV_HocVien.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("hocVienId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "soMonHocDuocMien" ) != null){
MyFilter con = new MyFilter();
con.setCol("soMonHocDuocMien");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soMonHocDuocMien").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoMonHocDuocMien" ) != null){
MyFilter con = new MyFilter();
con.setCol("soMonHocDuocMien");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoMonHocDuocMien").toString()));
cons.add(con);
}
if(request.getParameter( "toSoMonHocDuocMien" ) != null){
MyFilter con = new MyFilter();
con.setCol("soMonHocDuocMien");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoMonHocDuocMien").toString()));
cons.add(con);
}
  if(request.getParameter( "hocPhiTheoKyYN" ) != null && Boolean.parseBoolean(request.getParameter("hocPhiTheoKyYN"))){
MyFilter con = new MyFilter();
con.setCol("hocPhiTheoKyYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("hocPhiTheoKyYN").toString()));
cons.add(con);
}

  if(request.getParameter( "hoanTatHP" ) != null && Boolean.parseBoolean(request.getParameter("hoanTatHP"))){
MyFilter con = new MyFilter();
con.setCol("hoanTatHP");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("hoanTatHP").toString()));
cons.add(con);
}

  if(request.getParameter( "ngayTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTao");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayTao").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTao");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayTao").toString());
cons.add(con);
}
if(request.getParameter( "toNgayTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTao");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayTao").toString());
cons.add(con);
}

  try{
if(request.getParameter( "canBoTaoId" ) != null){
Tbl_CanBo obj =
new ObjectMapper().readValue(
request.getParameter("canBoTaoId")
, Tbl_CanBo.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("canBoTaoId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "soTienHVDong" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTienHVDong");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("soTienHVDong").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTienHVDong" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTienHVDong");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSoTienHVDong").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTienHVDong" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTienHVDong");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSoTienHVDong").toString()));
cons.add(con);
}
  if(request.getParameter( "camKethoanTatHP" ) != null && Boolean.parseBoolean(request.getParameter("camKethoanTatHP"))){
MyFilter con = new MyFilter();
con.setCol("camKethoanTatHP");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("camKethoanTatHP").toString()));
cons.add(con);
}

  if(request.getParameter( "maDonCamKet" ) != null){
MyFilter con = new MyFilter();
con.setCol("maDonCamKet");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maDonCamKet") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayCamKetDongHP" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCamKetDongHP");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayCamKetDongHP").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayCamKetDongHP" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCamKetDongHP");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayCamKetDongHP").toString());
cons.add(con);
}
if(request.getParameter( "toNgayCamKetDongHP" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCamKetDongHP");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayCamKetDongHP").toString());
cons.add(con);
}

  if(request.getParameter( "ngayCapNhat" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapNhat");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayCapNhat").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayCapNhat" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapNhat");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayCapNhat").toString());
cons.add(con);
}
if(request.getParameter( "toNgayCapNhat" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapNhat");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayCapNhat").toString());
cons.add(con);
}

  try{
if(request.getParameter( "canBoCapNhatId" ) != null){
Tbl_CanBo obj =
new ObjectMapper().readValue(
request.getParameter("canBoCapNhatId")
, Tbl_CanBo.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("canBoCapNhatId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
cons.add(con);
}
  if(request.getParameter( "soTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiLT");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("soTinChiLT").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiLT");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSoTinChiLT").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiLT");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSoTinChiLT").toString()));
cons.add(con);
}
  if(request.getParameter( "soTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiTH");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("soTinChiTH").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiTH");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSoTinChiTH").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiTH");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSoTinChiTH").toString()));
cons.add(con);
}
  if(request.getParameter( "donGiaLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaLT");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGiaLT").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGiaLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaLT");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGiaLT").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGiaLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaLT");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGiaLT").toString()));
cons.add(con);
}
  if(request.getParameter( "donGiaTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTH");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGiaTH").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGiaTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTH");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGiaTH").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGiaTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTH");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGiaTH").toString()));
cons.add(con);
}

return cons;
}
//việt
}