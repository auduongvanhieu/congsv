


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
import com.cce.vietnguyen.model.Tbl_QLDT_TKB_TuanHoc;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TKB_TuanHocController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_tkb_tuanhoc", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TKB_TuanHoc .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_tkb_tuanhoc/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_tuanhoc", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TKB_TuanHoc .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_tkb_tuanhoc/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
    //advh
//if(!genericRepository.checkRight(user, "tbl_qldt_tkb_tuanhoc", "xem")){
//return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//}
Tbl_QLDT_TKB_TuanHoc obj = (Tbl_QLDT_TKB_TuanHoc) genericDAO.get(Tbl_QLDT_TKB_TuanHoc .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_tuanhoc", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TKB_TuanHoc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_tuanhoc", "them")){
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
@RequestMapping(value="/tbl_qldt_tkb_tuanhoc/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_tuanhoc", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TKB_TuanHoc .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_tuanhoc", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TKB_TuanHoc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_tuanhoc", "sua")){
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
@RequestMapping(value="/tbl_qldt_tkb_tuanhoc/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_tuanhoc", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TKB_TuanHoc .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "tuanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("tuanHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromTuanHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toTuanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toTuanHoc").toString()));
cons.add(con);
}
  if(request.getParameter( "ngayDauTuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayDauTuan");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayDauTuan").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayDauTuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayDauTuan");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayDauTuan").toString());
cons.add(con);
}
if(request.getParameter( "toNgayDauTuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayDauTuan");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayDauTuan").toString());
cons.add(con);
}

  if(request.getParameter( "thoiKhoaBieuId" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiKhoaBieuId");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("thoiKhoaBieuId").toString()));
cons.add(con);
}
if(request.getParameter( "fromThoiKhoaBieuId" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiKhoaBieuId");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromThoiKhoaBieuId").toString()));
cons.add(con);
}
if(request.getParameter( "toThoiKhoaBieuId" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiKhoaBieuId");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toThoiKhoaBieuId").toString()));
cons.add(con);
}
  if(request.getParameter( "ngayTrongTuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTrongTuan");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayTrongTuan").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayTrongTuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTrongTuan");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayTrongTuan").toString());
cons.add(con);
}
if(request.getParameter( "toNgayTrongTuan" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTrongTuan");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayTrongTuan").toString());
cons.add(con);
}


return cons;
}
//việt
}