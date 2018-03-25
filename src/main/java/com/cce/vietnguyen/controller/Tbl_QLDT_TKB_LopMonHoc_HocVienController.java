


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
import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc_HocVien;
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
 

  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TKB_LopMonHoc_HocVienController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc_hocvien", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TKB_LopMonHoc_HocVien .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc_hocvien/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc_hocvien", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TKB_LopMonHoc_HocVien .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc_hocvien/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc_hocvien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_TKB_LopMonHoc_HocVien obj = (Tbl_QLDT_TKB_LopMonHoc_HocVien) genericDAO.get(Tbl_QLDT_TKB_LopMonHoc_HocVien .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc_hocvien", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TKB_LopMonHoc_HocVien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc_hocvien", "them")){
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
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc_hocvien/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc_hocvien", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TKB_LopMonHoc_HocVien .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc_hocvien", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TKB_LopMonHoc_HocVien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc_hocvien", "sua")){
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
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc_hocvien/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc_hocvien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TKB_LopMonHoc_HocVien .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "diemCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemCK");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemCK").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemCK");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemCK").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemCK");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemCK").toString()));
cons.add(con);
}
  if(request.getParameter( "diemGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemGK");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemGK").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemGK");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemGK").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemGK");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemGK").toString()));
cons.add(con);
}
  if(request.getParameter( "diemCC" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemCC");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemCC").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemCC" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemCC");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemCC").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemCC" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemCC");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemCC").toString()));
cons.add(con);
}
  if(request.getParameter( "diemThiLai1" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiLai1");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemThiLai1").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemThiLai1" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiLai1");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemThiLai1").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemThiLai1" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiLai1");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemThiLai1").toString()));
cons.add(con);
}
  if(request.getParameter( "diemThiLai2" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiLai2");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemThiLai2").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemThiLai2" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiLai2");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemThiLai2").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemThiLai2" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiLai2");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemThiLai2").toString()));
cons.add(con);
}
  if(request.getParameter( "tongdiem" ) != null){
MyFilter con = new MyFilter();
con.setCol("tongdiem");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("tongdiem").toString()));
cons.add(con);
}
if(request.getParameter( "fromTongdiem" ) != null){
MyFilter con = new MyFilter();
con.setCol("tongdiem");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromTongdiem").toString()));
cons.add(con);
}
if(request.getParameter( "toTongdiem" ) != null){
MyFilter con = new MyFilter();
con.setCol("tongdiem");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toTongdiem").toString()));
cons.add(con);
}
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
  try{
if(request.getParameter( "lopMonHocId" ) != null){
Tbl_QLDT_TKB_LopMonHoc obj =
new ObjectMapper().readValue(
request.getParameter("lopMonHocId")
, Tbl_QLDT_TKB_LopMonHoc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("lopMonHocId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "maNhom" ) != null){
MyFilter con = new MyFilter();
con.setCol("maNhom");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maNhom") + "%");
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
if(request.getParameter( "canBoId" ) != null){
Tbl_CanBo obj =
new ObjectMapper().readValue(
request.getParameter("canBoId")
, Tbl_CanBo.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("canBoId.id");
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
  if(request.getParameter( "maTrangThai" ) != null){
MyFilter con = new MyFilter();
con.setCol("maTrangThai");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maTrangThai") + "%");
cons.add(con);
}
  if(request.getParameter( "camThiYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("camThiYN");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("camThiYN").toString()));
cons.add(con);
}
if(request.getParameter( "fromCamThiYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("camThiYN");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromCamThiYN").toString()));
cons.add(con);
}
if(request.getParameter( "toCamThiYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("camThiYN");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toCamThiYN").toString()));
cons.add(con);
}

return cons;
}
//việt
}