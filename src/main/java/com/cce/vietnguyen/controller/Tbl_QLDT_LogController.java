


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
import com.cce.vietnguyen.model.Tbl_QLDT_Log;
 
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_LogController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_log", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_Log .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_log/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_log", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_Log .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_log/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_log", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_Log obj = (Tbl_QLDT_Log) genericDAO.get(Tbl_QLDT_Log .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_log", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_Log obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_log", "them")){
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
@RequestMapping(value="/tbl_qldt_log/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_log", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_Log .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_log", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_Log obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_log", "sua")){
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
@RequestMapping(value="/tbl_qldt_log/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_log", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_Log .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "newData" ) != null){
MyFilter con = new MyFilter();
con.setCol("newData");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("newData") + "%");
cons.add(con);
}
  if(request.getParameter( "oldData" ) != null){
MyFilter con = new MyFilter();
con.setCol("oldData");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("oldData") + "%");
cons.add(con);
}
  if(request.getParameter( "tableName" ) != null){
MyFilter con = new MyFilter();
con.setCol("tableName");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("tableName") + "%");
cons.add(con);
}
  if(request.getParameter( "timeLog" ) != null){
MyFilter con = new MyFilter();
con.setCol("timeLog");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("timeLog").toString());
cons.add(con);
}
if(request.getParameter( "fromTimeLog" ) != null){
MyFilter con = new MyFilter();
con.setCol("timeLog");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromTimeLog").toString());
cons.add(con);
}
if(request.getParameter( "toTimeLog" ) != null){
MyFilter con = new MyFilter();
con.setCol("timeLog");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toTimeLog").toString());
cons.add(con);
}

  if(request.getParameter( "username" ) != null){
MyFilter con = new MyFilter();
con.setCol("username");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("username") + "%");
cons.add(con);
}
  if(request.getParameter( "dataId" ) != null){
MyFilter con = new MyFilter();
con.setCol("dataId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("dataId").toString()));
cons.add(con);
}
if(request.getParameter( "fromDataId" ) != null){
MyFilter con = new MyFilter();
con.setCol("dataId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDataId").toString()));
cons.add(con);
}
if(request.getParameter( "toDataId" ) != null){
MyFilter con = new MyFilter();
con.setCol("dataId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDataId").toString()));
cons.add(con);
}
  if(request.getParameter( "description" ) != null){
MyFilter con = new MyFilter();
con.setCol("description");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("description") + "%");
cons.add(con);
}
  if(request.getParameter( "op" ) != null){
MyFilter con = new MyFilter();
con.setCol("op");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("op") + "%");
cons.add(con);
}

return cons;
}
//việt
}