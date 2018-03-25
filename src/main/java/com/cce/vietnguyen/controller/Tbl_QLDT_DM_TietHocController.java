


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
import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_DM_TietHocController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_dm_tiethoc", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_DM_TietHoc .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_dm_tiethoc/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_tiethoc", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DM_TietHoc .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_dm_tiethoc/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_tiethoc", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_DM_TietHoc obj = (Tbl_QLDT_DM_TietHoc) genericDAO.get(Tbl_QLDT_DM_TietHoc .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dm_tiethoc", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_DM_TietHoc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_tiethoc", "them")){
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
@RequestMapping(value="/tbl_qldt_dm_tiethoc/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_tiethoc", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_DM_TietHoc .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dm_tiethoc", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_DM_TietHoc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_tiethoc", "sua")){
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
@RequestMapping(value="/tbl_qldt_dm_tiethoc/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_tiethoc", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_DM_TietHoc .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "ma" ) != null){
MyFilter con = new MyFilter();
con.setCol("ma");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ma") + "%");
cons.add(con);
}
  if(request.getParameter( "ten" ) != null){
MyFilter con = new MyFilter();
con.setCol("ten");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ten") + "%");
cons.add(con);
}
  if(request.getParameter( "thoiGianBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianBatDau");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("thoiGianBatDau") + "%");
cons.add(con);
}
  if(request.getParameter( "thoiGianKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianKetThuc");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("thoiGianKetThuc") + "%");
cons.add(con);
}
  if(request.getParameter( "thoiGianNghi" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianNghi");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("thoiGianNghi").toString()));
cons.add(con);
}
if(request.getParameter( "fromThoiGianNghi" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianNghi");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromThoiGianNghi").toString()));
cons.add(con);
}
if(request.getParameter( "toThoiGianNghi" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianNghi");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toThoiGianNghi").toString()));
cons.add(con);
}
  if(request.getParameter( "kyHieuGioHocTKB" ) != null){
MyFilter con = new MyFilter();
con.setCol("kyHieuGioHocTKB");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("kyHieuGioHocTKB") + "%");
cons.add(con);
}
  if(request.getParameter( "stt" ) != null){
MyFilter con = new MyFilter();
con.setCol("stt");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("stt").toString()));
cons.add(con);
}
if(request.getParameter( "fromStt" ) != null){
MyFilter con = new MyFilter();
con.setCol("stt");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromStt").toString()));
cons.add(con);
}
if(request.getParameter( "toStt" ) != null){
MyFilter con = new MyFilter();
con.setCol("stt");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toStt").toString()));
cons.add(con);
}

return cons;
}
//việt
}