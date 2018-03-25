


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
import com.cce.vietnguyen.model.Tbl_QLDT_BangDiem;
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_LichThi;
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_BangDiemController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_bangdiem", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_BangDiem .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_bangdiem/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_BangDiem .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_bangdiem/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_BangDiem obj = (Tbl_QLDT_BangDiem) genericDAO.get(Tbl_QLDT_BangDiem .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_bangdiem", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_BangDiem obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem", "them")){
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
@RequestMapping(value="/tbl_qldt_bangdiem/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_BangDiem .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_bangdiem", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_BangDiem obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem", "sua")){
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
@RequestMapping(value="/tbl_qldt_bangdiem/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_bangdiem", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_BangDiem .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "url" ) != null){
MyFilter con = new MyFilter();
con.setCol("url");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("url") + "%");
cons.add(con);
}
  if(request.getParameter( "danhsach" ) != null){
MyFilter con = new MyFilter();
con.setCol("danhsach");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("danhsach") + "%");
cons.add(con);
}
  if(request.getParameter( "canBoLuu" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoLuu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("canBoLuu") + "%");
cons.add(con);
}
  if(request.getParameter( "ma" ) != null){
MyFilter con = new MyFilter();
con.setCol("ma");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("ma").toString()));
cons.add(con);
}
if(request.getParameter( "fromMa" ) != null){
MyFilter con = new MyFilter();
con.setCol("ma");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromMa").toString()));
cons.add(con);
}
if(request.getParameter( "toMa" ) != null){
MyFilter con = new MyFilter();
con.setCol("ma");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toMa").toString()));
cons.add(con);
}
  if(request.getParameter( "canBoChamThi1" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoChamThi1");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("canBoChamThi1") + "%");
cons.add(con);
}
  if(request.getParameter( "canBoChamThi2" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoChamThi2");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("canBoChamThi2") + "%");
cons.add(con);
}
  if(request.getParameter( "siSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("siSo").toString()));
cons.add(con);
}
if(request.getParameter( "fromSiSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSiSo").toString()));
cons.add(con);
}
if(request.getParameter( "toSiSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSiSo").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "lichThiId" ) != null){
Tbl_QLDT_LichThi obj =
new ObjectMapper().readValue(
request.getParameter("lichThiId")
, Tbl_QLDT_LichThi.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("lichThiId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "siSoVang" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoVang");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("siSoVang").toString()));
cons.add(con);
}
if(request.getParameter( "fromSiSoVang" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoVang");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSiSoVang").toString()));
cons.add(con);
}
if(request.getParameter( "toSiSoVang" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoVang");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSiSoVang").toString()));
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

  if(request.getParameter( "ngayLuu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLuu");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayLuu").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayLuu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLuu");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayLuu").toString());
cons.add(con);
}
if(request.getParameter( "toNgayLuu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLuu");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayLuu").toString());
cons.add(con);
}

  if(request.getParameter( "khoaYN" ) != null && Boolean.parseBoolean(request.getParameter("khoaYN"))){
MyFilter con = new MyFilter();
con.setCol("khoaYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("khoaYN").toString()));
cons.add(con);
}

  if(request.getParameter( "huyYN" ) != null && Boolean.parseBoolean(request.getParameter("huyYN"))){
MyFilter con = new MyFilter();
con.setCol("huyYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("huyYN").toString()));
cons.add(con);
}

  if(request.getParameter( "canBoTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoTao");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("canBoTao") + "%");
cons.add(con);
}

return cons;
}
//việt
}