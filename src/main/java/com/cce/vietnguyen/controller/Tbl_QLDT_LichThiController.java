


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
import com.cce.vietnguyen.model.Tbl_QLDT_LichThi;
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Phong;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_LichThiController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_lichthi", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_LichThi .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_lichthi/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_LichThi .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_lichthi/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_LichThi obj = (Tbl_QLDT_LichThi) genericDAO.get(Tbl_QLDT_LichThi .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_lichthi", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_LichThi obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi", "them")){
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
@RequestMapping(value="/tbl_qldt_lichthi/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_LichThi .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_lichthi", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_LichThi obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi", "sua")){
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
@RequestMapping(value="/tbl_qldt_lichthi/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_LichThi .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayThi");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayThi").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayThi");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayThi").toString());
cons.add(con);
}
if(request.getParameter( "toNgayThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayThi");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayThi").toString());
cons.add(con);
}

  if(request.getParameter( "thoiGian" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGian");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("thoiGian").toString()));
cons.add(con);
}
if(request.getParameter( "fromThoiGian" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGian");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromThoiGian").toString()));
cons.add(con);
}
if(request.getParameter( "toThoiGian" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGian");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toThoiGian").toString()));
cons.add(con);
}
  if(request.getParameter( "maNhom" ) != null){
MyFilter con = new MyFilter();
con.setCol("maNhom");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maNhom") + "%");
cons.add(con);
}
  try{
if(request.getParameter( "lopId" ) != null){
Tbl_QLDT_TKB_LopMonHoc obj =
new ObjectMapper().readValue(
request.getParameter("lopId")
, Tbl_QLDT_TKB_LopMonHoc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("lopId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "phongId" ) != null){
Tbl_QLDT_DM_Phong obj =
new ObjectMapper().readValue(
request.getParameter("phongId")
, Tbl_QLDT_DM_Phong.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("phongId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "tietThiId" ) != null){
Tbl_QLDT_DM_TietHoc obj =
new ObjectMapper().readValue(
request.getParameter("tietThiId")
, Tbl_QLDT_DM_TietHoc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("tietThiId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "gioBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("gioBatDau");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("gioBatDau") + "%");
cons.add(con);
}
  if(request.getParameter( "loaiThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("loaiThi");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("loaiThi") + "%");
cons.add(con);
}
  if(request.getParameter( "hinhThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("hinhThuc");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("hinhThuc") + "%");
cons.add(con);
}
  if(request.getParameter( "canBoCoiThi1" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoCoiThi1");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("canBoCoiThi1") + "%");
cons.add(con);
}
  if(request.getParameter( "canBoCoiThi2" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoCoiThi2");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("canBoCoiThi2") + "%");
cons.add(con);
}
  if(request.getParameter( "siSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("siSo").toString()));
cons.add(con);
}
if(request.getParameter( "fromSiSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSiSo").toString()));
cons.add(con);
}
if(request.getParameter( "toSiSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSiSo").toString()));
cons.add(con);
}
  if(request.getParameter( "thayDoi" ) != null){
MyFilter con = new MyFilter();
con.setCol("thayDoi");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("thayDoi").toString()));
cons.add(con);
}
if(request.getParameter( "fromThayDoi" ) != null){
MyFilter con = new MyFilter();
con.setCol("thayDoi");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromThayDoi").toString()));
cons.add(con);
}
if(request.getParameter( "toThayDoi" ) != null){
MyFilter con = new MyFilter();
con.setCol("thayDoi");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toThayDoi").toString()));
cons.add(con);
}

return cons;
}
//việt
}