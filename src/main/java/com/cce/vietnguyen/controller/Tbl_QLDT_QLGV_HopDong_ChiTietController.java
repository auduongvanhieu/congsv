


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLGV_HopDong_ChiTiet;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLGV_HopDong;
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLGV_HopDong_ChiTietController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qlgv_hopdong_chitiet", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLGV_HopDong_ChiTiet .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qlgv_hopdong_chitiet/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong_chitiet", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLGV_HopDong_ChiTiet .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qlgv_hopdong_chitiet/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong_chitiet", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_QLGV_HopDong_ChiTiet obj = (Tbl_QLDT_QLGV_HopDong_ChiTiet) genericDAO.get(Tbl_QLDT_QLGV_HopDong_ChiTiet .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlgv_hopdong_chitiet", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLGV_HopDong_ChiTiet obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong_chitiet", "them")){
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
@RequestMapping(value="/tbl_qldt_qlgv_hopdong_chitiet/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong_chitiet", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLGV_HopDong_ChiTiet .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlgv_hopdong_chitiet", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLGV_HopDong_ChiTiet obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong_chitiet", "sua")){
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
@RequestMapping(value="/tbl_qldt_qlgv_hopdong_chitiet/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong_chitiet", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLGV_HopDong_ChiTiet .class, cons), HttpStatus.OK);
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
if(request.getParameter( "hopDongId" ) != null){
Tbl_QLDT_QLGV_HopDong obj =
new ObjectMapper().readValue(
request.getParameter("hopDongId")
, Tbl_QLDT_QLGV_HopDong.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("hopDongId.id");
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
  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
cons.add(con);
}
  if(request.getParameter( "soLuong" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuong");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soLuong").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoLuong" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuong");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoLuong").toString()));
cons.add(con);
}
if(request.getParameter( "toSoLuong" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuong");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoLuong").toString()));
cons.add(con);
}
  if(request.getParameter( "donVi" ) != null){
MyFilter con = new MyFilter();
con.setCol("donVi");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("donVi") + "%");
cons.add(con);
}
  if(request.getParameter( "donGia" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGia");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGia").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGia" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGia");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGia").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGia" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGia");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGia").toString()));
cons.add(con);
}
  if(request.getParameter( "khoanMucKhacYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoanMucKhacYN");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("khoanMucKhacYN").toString()));
cons.add(con);
}
if(request.getParameter( "fromKhoanMucKhacYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoanMucKhacYN");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromKhoanMucKhacYN").toString()));
cons.add(con);
}
if(request.getParameter( "toKhoanMucKhacYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoanMucKhacYN");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toKhoanMucKhacYN").toString()));
cons.add(con);
}
  if(request.getParameter( "tenKhoanMuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tenKhoanMuc");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("tenKhoanMuc") + "%");
cons.add(con);
}
  if(request.getParameter( "donGia2" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGia2");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGia2").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGia2" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGia2");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGia2").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGia2" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGia2");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGia2").toString()));
cons.add(con);
}
  if(request.getParameter( "soLuong2" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuong2");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soLuong2").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoLuong2" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuong2");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoLuong2").toString()));
cons.add(con);
}
if(request.getParameter( "toSoLuong2" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuong2");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoLuong2").toString()));
cons.add(con);
}

return cons;
}
//việt
}