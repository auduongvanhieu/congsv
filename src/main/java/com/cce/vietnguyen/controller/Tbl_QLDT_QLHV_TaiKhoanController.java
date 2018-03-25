


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_TaiKhoan;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;

  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLHV_TaiKhoanController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qlhv_taikhoan", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLHV_TaiKhoan .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qlhv_taikhoan/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_taikhoan", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLHV_TaiKhoan .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qlhv_taikhoan/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_taikhoan", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_QLHV_TaiKhoan obj = (Tbl_QLDT_QLHV_TaiKhoan) genericDAO.get(Tbl_QLDT_QLHV_TaiKhoan .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_taikhoan", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLHV_TaiKhoan obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_taikhoan", "them")){
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
@RequestMapping(value="/tbl_qldt_qlhv_taikhoan/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_taikhoan", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLHV_TaiKhoan .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_taikhoan", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLHV_TaiKhoan obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_taikhoan", "sua")){
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
@RequestMapping(value="/tbl_qldt_qlhv_taikhoan/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_taikhoan", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLHV_TaiKhoan .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "soDuTaiKhoan" ) != null){
MyFilter con = new MyFilter();
con.setCol("soDuTaiKhoan");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("soDuTaiKhoan").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoDuTaiKhoan" ) != null){
MyFilter con = new MyFilter();
con.setCol("soDuTaiKhoan");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSoDuTaiKhoan").toString()));
cons.add(con);
}
if(request.getParameter( "toSoDuTaiKhoan" ) != null){
MyFilter con = new MyFilter();
con.setCol("soDuTaiKhoan");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSoDuTaiKhoan").toString()));
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
  if(request.getParameter( "ghiNo" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiNo");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("ghiNo").toString()));
cons.add(con);
}
if(request.getParameter( "fromGhiNo" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiNo");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromGhiNo").toString()));
cons.add(con);
}
if(request.getParameter( "toGhiNo" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiNo");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toGhiNo").toString()));
cons.add(con);
}
  if(request.getParameter( "ghiCo" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiCo");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("ghiCo").toString()));
cons.add(con);
}
if(request.getParameter( "fromGhiCo" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiCo");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromGhiCo").toString()));
cons.add(con);
}
if(request.getParameter( "toGhiCo" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiCo");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toGhiCo").toString()));
cons.add(con);
}

return cons;
}
//việt
}