


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
import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_MonHocMoDangKy;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_DKMH_MonHocMoDangKyController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_dkmh_monhocmodangky", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_DKMH_MonHocMoDangKy .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_dkmh_monhocmodangky/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_monhocmodangky", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DKMH_MonHocMoDangKy .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_dkmh_monhocmodangky/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_monhocmodangky", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_DKMH_MonHocMoDangKy obj = (Tbl_QLDT_DKMH_MonHocMoDangKy) genericDAO.get(Tbl_QLDT_DKMH_MonHocMoDangKy .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_monhocmodangky", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_DKMH_MonHocMoDangKy obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_monhocmodangky", "them")){
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
@RequestMapping(value="/tbl_qldt_dkmh_monhocmodangky/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_monhocmodangky", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_DKMH_MonHocMoDangKy .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_monhocmodangky", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_DKMH_MonHocMoDangKy obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_monhocmodangky", "sua")){
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
@RequestMapping(value="/tbl_qldt_dkmh_monhocmodangky/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_monhocmodangky", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_DKMH_MonHocMoDangKy .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "monHocId" ) != null){
MyFilter con = new MyFilter();
con.setCol("monHocId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("monHocId").toString()));
cons.add(con);
}
if(request.getParameter( "fromMonHocId" ) != null){
MyFilter con = new MyFilter();
con.setCol("monHocId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromMonHocId").toString()));
cons.add(con);
}
if(request.getParameter( "toMonHocId" ) != null){
MyFilter con = new MyFilter();
con.setCol("monHocId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toMonHocId").toString()));
cons.add(con);
}
  if(request.getParameter( "hocKyId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("hocKyId").toString()));
cons.add(con);
}
if(request.getParameter( "fromHocKyId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHocKyId").toString()));
cons.add(con);
}
if(request.getParameter( "toHocKyId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHocKyId").toString()));
cons.add(con);
}
  if(request.getParameter( "coSoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("coSoId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("coSoId").toString()));
cons.add(con);
}
if(request.getParameter( "fromCoSoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("coSoId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromCoSoId").toString()));
cons.add(con);
}
if(request.getParameter( "toCoSoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("coSoId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toCoSoId").toString()));
cons.add(con);
}
  if(request.getParameter( "giangVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("giangVienId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("giangVienId").toString()));
cons.add(con);
}
if(request.getParameter( "fromGiangVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("giangVienId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromGiangVienId").toString()));
cons.add(con);
}
if(request.getParameter( "toGiangVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("giangVienId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toGiangVienId").toString()));
cons.add(con);
}

return cons;
}
//việt
}