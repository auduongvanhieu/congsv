


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_QuyetDinhKyLuat;

import com.cce.vietnguyen.model.core.Tbl_CanBo;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLHV_QuyetDinhKyLuatController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qlhv_quyetdinhkyluat", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLHV_QuyetDinhKyLuat .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qlhv_quyetdinhkyluat/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_quyetdinhkyluat", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLHV_QuyetDinhKyLuat .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qlhv_quyetdinhkyluat/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_quyetdinhkyluat", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_QLHV_QuyetDinhKyLuat obj = (Tbl_QLDT_QLHV_QuyetDinhKyLuat) genericDAO.get(Tbl_QLDT_QLHV_QuyetDinhKyLuat .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_quyetdinhkyluat", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLHV_QuyetDinhKyLuat obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_quyetdinhkyluat", "them")){
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
@RequestMapping(value="/tbl_qldt_qlhv_quyetdinhkyluat/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_quyetdinhkyluat", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLHV_QuyetDinhKyLuat .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_quyetdinhkyluat", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLHV_QuyetDinhKyLuat obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_quyetdinhkyluat", "sua")){
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
@RequestMapping(value="/tbl_qldt_qlhv_quyetdinhkyluat/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_quyetdinhkyluat", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLHV_QuyetDinhKyLuat .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "ngayKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKy");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayKy").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKy");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayKy").toString());
cons.add(con);
}
if(request.getParameter( "toNgayKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKy");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayKy").toString());
cons.add(con);
}

  if(request.getParameter( "tuNgay" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuNgay");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("tuNgay").toString());
cons.add(con);
}
if(request.getParameter( "fromTuNgay" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuNgay");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromTuNgay").toString());
cons.add(con);
}
if(request.getParameter( "toTuNgay" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuNgay");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toTuNgay").toString());
cons.add(con);
}

  if(request.getParameter( "denNgay" ) != null){
MyFilter con = new MyFilter();
con.setCol("denNgay");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("denNgay").toString());
cons.add(con);
}
if(request.getParameter( "fromDenNgay" ) != null){
MyFilter con = new MyFilter();
con.setCol("denNgay");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromDenNgay").toString());
cons.add(con);
}
if(request.getParameter( "toDenNgay" ) != null){
MyFilter con = new MyFilter();
con.setCol("denNgay");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toDenNgay").toString());
cons.add(con);
}

  if(request.getParameter( "noiDung" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiDung");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiDung") + "%");
cons.add(con);
}
  if(request.getParameter( "khongXetTotNgiepYN" ) != null && Boolean.parseBoolean(request.getParameter("khongXetTotNgiepYN"))){
MyFilter con = new MyFilter();
con.setCol("khongXetTotNgiepYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("khongXetTotNgiepYN").toString()));
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

return cons;
}
//việt
}