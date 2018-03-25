


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
import com.cce.vietnguyen.model.Tbl_QLDT_TN_DotTotNghiep;
 
 
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TN_DotTotNghiepController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TN_DotTotNghiep .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TN_DotTotNghiep .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_TN_DotTotNghiep obj = (Tbl_QLDT_TN_DotTotNghiep) genericDAO.get(Tbl_QLDT_TN_DotTotNghiep .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TN_DotTotNghiep obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep", "them")){
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
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TN_DotTotNghiep .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TN_DotTotNghiep obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep", "sua")){
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
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TN_DotTotNghiep .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "ten" ) != null){
MyFilter con = new MyFilter();
con.setCol("ten");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ten") + "%");
cons.add(con);
}
  if(request.getParameter( "ma" ) != null){
MyFilter con = new MyFilter();
con.setCol("ma");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ma") + "%");
cons.add(con);
}
  if(request.getParameter( "ngay" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngay");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngay").toString());
cons.add(con);
}
if(request.getParameter( "fromNgay" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngay");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgay").toString());
cons.add(con);
}
if(request.getParameter( "toNgay" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngay");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgay").toString());
cons.add(con);
}

  if(request.getParameter( "khoaYN" ) != null && Boolean.parseBoolean(request.getParameter("khoaYN"))){
MyFilter con = new MyFilter();
con.setCol("khoaYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("khoaYN").toString()));
cons.add(con);
}

  if(request.getParameter( "noiDung" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiDung");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiDung") + "%");
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

  if(request.getParameter( "canBoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("canBoId").toString()));
cons.add(con);
}
if(request.getParameter( "fromCanBoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromCanBoId").toString()));
cons.add(con);
}
if(request.getParameter( "toCanBoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toCanBoId").toString()));
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
  if(request.getParameter( "sttDotTN" ) != null){
MyFilter con = new MyFilter();
con.setCol("sttDotTN");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("sttDotTN").toString()));
cons.add(con);
}
if(request.getParameter( "fromSttDotTN" ) != null){
MyFilter con = new MyFilter();
con.setCol("sttDotTN");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSttDotTN").toString()));
cons.add(con);
}
if(request.getParameter( "toSttDotTN" ) != null){
MyFilter con = new MyFilter();
con.setCol("sttDotTN");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSttDotTN").toString()));
cons.add(con);
}

return cons;
}
//việt
}