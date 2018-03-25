


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
import com.cce.vietnguyen.model.Tbl_QLDT_LichThi_Temp;
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_PhongThi;
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_LichThi_TempController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_lichthi_temp", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_LichThi_Temp .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_lichthi_temp/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_temp", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_LichThi_Temp .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_lichthi_temp/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_temp", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_LichThi_Temp obj = (Tbl_QLDT_LichThi_Temp) genericDAO.get(Tbl_QLDT_LichThi_Temp .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_lichthi_temp", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_LichThi_Temp obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_temp", "them")){
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
@RequestMapping(value="/tbl_qldt_lichthi_temp/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_temp", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_LichThi_Temp .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_lichthi_temp", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_LichThi_Temp obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_temp", "sua")){
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
@RequestMapping(value="/tbl_qldt_lichthi_temp/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_temp", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_LichThi_Temp .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "nguoiTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("nguoiTao");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("nguoiTao").toString()));
cons.add(con);
}
if(request.getParameter( "fromNguoiTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("nguoiTao");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromNguoiTao").toString()));
cons.add(con);
}
if(request.getParameter( "toNguoiTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("nguoiTao");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toNguoiTao").toString()));
cons.add(con);
}
  if(request.getParameter( "nhomId" ) != null){
MyFilter con = new MyFilter();
con.setCol("nhomId");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("nhomId").toString()));
cons.add(con);
}
if(request.getParameter( "fromNhomId" ) != null){
MyFilter con = new MyFilter();
con.setCol("nhomId");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromNhomId").toString()));
cons.add(con);
}
if(request.getParameter( "toNhomId" ) != null){
MyFilter con = new MyFilter();
con.setCol("nhomId");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toNhomId").toString()));
cons.add(con);
}
  if(request.getParameter( "tietThiId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tietThiId");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("tietThiId").toString()));
cons.add(con);
}
if(request.getParameter( "fromTietThiId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tietThiId");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromTietThiId").toString()));
cons.add(con);
}
if(request.getParameter( "toTietThiId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tietThiId");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toTietThiId").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "phongId" ) != null){
Tbl_QLDT_DM_PhongThi obj =
new ObjectMapper().readValue(
request.getParameter("phongId")
, Tbl_QLDT_DM_PhongThi.class
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
  if(request.getParameter( "lopId" ) != null){
MyFilter con = new MyFilter();
con.setCol("lopId");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("lopId").toString()));
cons.add(con);
}
if(request.getParameter( "fromLopId" ) != null){
MyFilter con = new MyFilter();
con.setCol("lopId");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromLopId").toString()));
cons.add(con);
}
if(request.getParameter( "toLopId" ) != null){
MyFilter con = new MyFilter();
con.setCol("lopId");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toLopId").toString()));
cons.add(con);
}

return cons;
}
//việt
}