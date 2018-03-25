


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_HeDaoTao;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_Nganh;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_ChuyenNganh;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_KhoiNganh;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSoXetTuyen;
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLHV_HocVienController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qlhv_hocvien", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLHV_HocVien .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qlhv_hocvien/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLHV_HocVien .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qlhv_hocvien/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
//ADVH 
//if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien", "xem")){
//return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//}
Tbl_QLDT_QLHV_HocVien obj = (Tbl_QLDT_QLHV_HocVien) genericDAO.get(Tbl_QLDT_QLHV_HocVien .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_hocvien", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLHV_HocVien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien", "them")){
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
@RequestMapping(value="/tbl_qldt_qlhv_hocvien/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLHV_HocVien .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_hocvien", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLHV_HocVien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien", "sua")){
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
@RequestMapping(value="/tbl_qldt_qlhv_hocvien/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLHV_HocVien .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "mshv" ) != null){
MyFilter con = new MyFilter();
con.setCol("mshv");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("mshv") + "%");
cons.add(con);
}
  if(request.getParameter( "ho" ) != null){
MyFilter con = new MyFilter();
con.setCol("ho");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ho") + "%");
cons.add(con);
}
  if(request.getParameter( "ten" ) != null){
MyFilter con = new MyFilter();
con.setCol("ten");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ten") + "%");
cons.add(con);
}
  if(request.getParameter( "hinhAnh" ) != null){
MyFilter con = new MyFilter();
con.setCol("hinhAnh");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("hinhAnh") + "%");
cons.add(con);
}
  if(request.getParameter( "maLop" ) != null){
MyFilter con = new MyFilter();
con.setCol("maLop");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maLop") + "%");
cons.add(con);
}
  try{
if(request.getParameter( "heDaoTaoId" ) != null){
Tbl_QLDT_CTDT_HeDaoTao obj =
new ObjectMapper().readValue(
request.getParameter("heDaoTaoId")
, Tbl_QLDT_CTDT_HeDaoTao.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("heDaoTaoId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "nganhId" ) != null){
Tbl_QLDT_CTDT_Nganh obj =
new ObjectMapper().readValue(
request.getParameter("nganhId")
, Tbl_QLDT_CTDT_Nganh.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("nganhId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "chuyenNganhId" ) != null){
Tbl_QLDT_CTDT_ChuyenNganh obj =
new ObjectMapper().readValue(
request.getParameter("chuyenNganhId")
, Tbl_QLDT_CTDT_ChuyenNganh.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("chuyenNganhId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "khoiNganhId" ) != null){
Tbl_QLDT_CTDT_KhoiNganh obj =
new ObjectMapper().readValue(
request.getParameter("khoiNganhId")
, Tbl_QLDT_CTDT_KhoiNganh.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("khoiNganhId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "namNhapHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("namNhapHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("namNhapHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromNamNhapHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("namNhapHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromNamNhapHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toNamNhapHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("namNhapHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toNamNhapHoc").toString()));
cons.add(con);
}
  if(request.getParameter( "khoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("khoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromKhoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toKhoaHoc").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "hoSoId" ) != null){
Tbl_QLDT_TS_HoSoXetTuyen obj =
new ObjectMapper().readValue(
request.getParameter("hoSoId")
, Tbl_QLDT_TS_HoSoXetTuyen.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("hoSoId.id");
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
  if(request.getParameter( "ngayLap" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLap");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayLap").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayLap" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLap");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayLap").toString());
cons.add(con);
}
if(request.getParameter( "toNgayLap" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLap");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayLap").toString());
cons.add(con);
}

  if(request.getParameter( "maTrangThai" ) != null){
MyFilter con = new MyFilter();
con.setCol("maTrangThai");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maTrangThai") + "%");
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

  if(request.getParameter( "email" ) != null){
MyFilter con = new MyFilter();
con.setCol("email");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("email") + "%");
cons.add(con);
}
  if(request.getParameter( "sdt" ) != null){
MyFilter con = new MyFilter();
con.setCol("sdt");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("sdt") + "%");
cons.add(con);
}
  if(request.getParameter( "cmnd" ) != null){
MyFilter con = new MyFilter();
con.setCol("cmnd");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("cmnd") + "%");
cons.add(con);
}
  if(request.getParameter( "gioiTinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("gioiTinh");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("gioiTinh").toString()));
cons.add(con);
}
if(request.getParameter( "fromGioiTinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("gioiTinh");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromGioiTinh").toString()));
cons.add(con);
}
if(request.getParameter( "toGioiTinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("gioiTinh");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toGioiTinh").toString()));
cons.add(con);
}

return cons;
}
//việt
}