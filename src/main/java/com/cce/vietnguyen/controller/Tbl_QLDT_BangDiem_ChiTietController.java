


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
import com.cce.vietnguyen.model.Tbl_QLDT_BangDiem_ChiTiet;
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_BangDiem_ChiTietController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_bangdiem_chitiet", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_BangDiem_ChiTiet .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_bangdiem_chitiet/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem_chitiet", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_BangDiem_ChiTiet .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_bangdiem_chitiet/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem_chitiet", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_BangDiem_ChiTiet obj = (Tbl_QLDT_BangDiem_ChiTiet) genericDAO.get(Tbl_QLDT_BangDiem_ChiTiet .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_bangdiem_chitiet", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_BangDiem_ChiTiet obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem_chitiet", "them")){
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
@RequestMapping(value="/tbl_qldt_bangdiem_chitiet/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem_chitiet", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_BangDiem_ChiTiet .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_bangdiem_chitiet", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_BangDiem_ChiTiet obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem_chitiet", "sua")){
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
@RequestMapping(value="/tbl_qldt_bangdiem_chitiet/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem_chitiet", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_BangDiem_ChiTiet .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "hocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("hocVienId").toString()));
cons.add(con);
}
if(request.getParameter( "fromHocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHocVienId").toString()));
cons.add(con);
}
if(request.getParameter( "toHocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHocVienId").toString()));
cons.add(con);
}
  if(request.getParameter( "bangDiemId" ) != null){
MyFilter con = new MyFilter();
con.setCol("bangDiemId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("bangDiemId").toString()));
cons.add(con);
}
if(request.getParameter( "fromBangDiemId" ) != null){
MyFilter con = new MyFilter();
con.setCol("bangDiemId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromBangDiemId").toString()));
cons.add(con);
}
if(request.getParameter( "toBangDiemId" ) != null){
MyFilter con = new MyFilter();
con.setCol("bangDiemId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toBangDiemId").toString()));
cons.add(con);
}

return cons;
}
//việt
}