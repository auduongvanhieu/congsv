


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
import com.cce.vietnguyen.model.Tbl_qldt_ts_hoso_hocba;
 
 
 
  import com.cce.vietnguyen.model.Tbl_qldt_ts_dm_hockythpt;
  import com.cce.vietnguyen.model.Tbl_qldt_ts_dm_monhoc;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_qldt_ts_hoso_hocbaController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_ts_hoso_hocba", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_qldt_ts_hoso_hocba .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_hocba/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_hocba", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_qldt_ts_hoso_hocba .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_ts_hoso_hocba/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_hocba", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_qldt_ts_hoso_hocba obj = (Tbl_qldt_ts_hoso_hocba) genericDAO.get(Tbl_qldt_ts_hoso_hocba .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_hocba", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_qldt_ts_hoso_hocba obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_hocba", "them")){
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
@RequestMapping(value="/tbl_qldt_ts_hoso_hocba/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_hocba", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_qldt_ts_hoso_hocba .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_hocba", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_qldt_ts_hoso_hocba obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_hocba", "sua")){
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
@RequestMapping(value="/tbl_qldt_ts_hoso_hocba/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_hocba", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_qldt_ts_hoso_hocba .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "diem" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diem").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiem" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiem").toString()));
cons.add(con);
}
if(request.getParameter( "toDiem" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiem").toString()));
cons.add(con);
}
  if(request.getParameter( "hoSoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hoSoId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("hoSoId").toString()));
cons.add(con);
}
if(request.getParameter( "fromHoSoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hoSoId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHoSoId").toString()));
cons.add(con);
}
if(request.getParameter( "toHoSoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hoSoId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHoSoId").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "hocKyId" ) != null){
Tbl_qldt_ts_dm_hockythpt obj =
new ObjectMapper().readValue(
request.getParameter("hocKyId")
, Tbl_qldt_ts_dm_hockythpt.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("hocKyId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "monHocId" ) != null){
Tbl_qldt_ts_dm_monhoc obj =
new ObjectMapper().readValue(
request.getParameter("monHocId")
, Tbl_qldt_ts_dm_monhoc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("monHocId.id");
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