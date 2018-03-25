


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
import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien_ThongTinGiangVien;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_GiangVien_ThongTinGiangVienController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_giangvien_thongtingiangvien", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_GiangVien_ThongTinGiangVien .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_giangvien_thongtingiangvien/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_giangvien_thongtingiangvien", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_GiangVien_ThongTinGiangVien .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_giangvien_thongtingiangvien/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_giangvien_thongtingiangvien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_GiangVien_ThongTinGiangVien obj = (Tbl_QLDT_GiangVien_ThongTinGiangVien) genericDAO.get(Tbl_QLDT_GiangVien_ThongTinGiangVien .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_giangvien_thongtingiangvien", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_GiangVien_ThongTinGiangVien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_giangvien_thongtingiangvien", "them")){
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
@RequestMapping(value="/tbl_qldt_giangvien_thongtingiangvien/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_giangvien_thongtingiangvien", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_GiangVien_ThongTinGiangVien .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_giangvien_thongtingiangvien", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_GiangVien_ThongTinGiangVien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_giangvien_thongtingiangvien", "sua")){
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
@RequestMapping(value="/tbl_qldt_giangvien_thongtingiangvien/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_giangvien_thongtingiangvien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_GiangVien_ThongTinGiangVien .class, cons), HttpStatus.OK);
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
  try{
if(request.getParameter( "giangVienId" ) != null){
Tbl_QLDT_GiangVien obj =
new ObjectMapper().readValue(
request.getParameter("giangVienId")
, Tbl_QLDT_GiangVien.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("giangVienId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "email" ) != null){
MyFilter con = new MyFilter();
con.setCol("email");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("email") + "%");
cons.add(con);
}
  if(request.getParameter( "soDienThoai" ) != null){
MyFilter con = new MyFilter();
con.setCol("soDienThoai");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("soDienThoai") + "%");
cons.add(con);
}
  if(request.getParameter( "diaChiCongTac" ) != null){
MyFilter con = new MyFilter();
con.setCol("diaChiCongTac");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("diaChiCongTac") + "%");
cons.add(con);
}
  if(request.getParameter( "diaChi" ) != null){
MyFilter con = new MyFilter();
con.setCol("diaChi");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("diaChi") + "%");
cons.add(con);
}
  if(request.getParameter( "ngaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngaySinh").toString());
cons.add(con);
}
if(request.getParameter( "fromNgaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgaySinh").toString());
cons.add(con);
}
if(request.getParameter( "toNgaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgaySinh").toString());
cons.add(con);
}

  if(request.getParameter( "noiSinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiSinh");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiSinh") + "%");
cons.add(con);
}
  if(request.getParameter( "hocHam" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocHam");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("hocHam") + "%");
cons.add(con);
}
  if(request.getParameter( "hocVi" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVi");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("hocVi") + "%");
cons.add(con);
}
  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
cons.add(con);
}
  if(request.getParameter( "cmnd" ) != null){
MyFilter con = new MyFilter();
con.setCol("cmnd");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("cmnd") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayCapCMND" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapCMND");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayCapCMND").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayCapCMND" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapCMND");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayCapCMND").toString());
cons.add(con);
}
if(request.getParameter( "toNgayCapCMND" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapCMND");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayCapCMND").toString());
cons.add(con);
}

  if(request.getParameter( "noiCapCMND" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiCapCMND");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiCapCMND") + "%");
cons.add(con);
}
  if(request.getParameter( "maTaiKhoanNganHang" ) != null){
MyFilter con = new MyFilter();
con.setCol("maTaiKhoanNganHang");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maTaiKhoanNganHang") + "%");
cons.add(con);
}
  if(request.getParameter( "nganHang" ) != null){
MyFilter con = new MyFilter();
con.setCol("nganHang");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("nganHang") + "%");
cons.add(con);
}
  if(request.getParameter( "chiNhanhNganHang" ) != null){
MyFilter con = new MyFilter();
con.setCol("chiNhanhNganHang");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("chiNhanhNganHang") + "%");
cons.add(con);
}
  if(request.getParameter( "luongThoaThuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("luongThoaThuan");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("luongThoaThuan").toString()));
cons.add(con);
}
if(request.getParameter( "fromLuongThoaThuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("luongThoaThuan");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromLuongThoaThuan").toString()));
cons.add(con);
}
if(request.getParameter( "toLuongThoaThuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("luongThoaThuan");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toLuongThoaThuan").toString()));
cons.add(con);
}
  if(request.getParameter( "thuLaoChamBai" ) != null){
MyFilter con = new MyFilter();
con.setCol("thuLaoChamBai");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("thuLaoChamBai").toString()));
cons.add(con);
}
if(request.getParameter( "fromThuLaoChamBai" ) != null){
MyFilter con = new MyFilter();
con.setCol("thuLaoChamBai");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromThuLaoChamBai").toString()));
cons.add(con);
}
if(request.getParameter( "toThuLaoChamBai" ) != null){
MyFilter con = new MyFilter();
con.setCol("thuLaoChamBai");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toThuLaoChamBai").toString()));
cons.add(con);
}

return cons;
}
//việt
}