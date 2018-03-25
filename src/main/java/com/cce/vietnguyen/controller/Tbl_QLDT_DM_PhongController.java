


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
import com.cce.vietnguyen.model.Tbl_QLDT_DM_Phong;
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_DM_PhongController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_dm_phong", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_DM_Phong .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_dm_phong/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_phong", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DM_Phong .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_dm_phong/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_phong", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_DM_Phong obj = (Tbl_QLDT_DM_Phong) genericDAO.get(Tbl_QLDT_DM_Phong .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dm_phong", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_DM_Phong obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_phong", "them")){
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
@RequestMapping(value="/tbl_qldt_dm_phong/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_phong", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_DM_Phong .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dm_phong", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_DM_Phong obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_phong", "sua")){
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
@RequestMapping(value="/tbl_qldt_dm_phong/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dm_phong", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_DM_Phong .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "soLuongHV" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuongHV");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soLuongHV").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoLuongHV" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuongHV");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoLuongHV").toString()));
cons.add(con);
}
if(request.getParameter( "toSoLuongHV" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuongHV");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoLuongHV").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "coSoId" ) != null){
Tbl_QLDT_DM_CoSo obj =
new ObjectMapper().readValue(
request.getParameter("coSoId")
, Tbl_QLDT_DM_CoSo.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("coSoId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "loaiPhong" ) != null){
MyFilter con = new MyFilter();
con.setCol("loaiPhong");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("loaiPhong") + "%");
cons.add(con);
}
  if(request.getParameter( "soLuongMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuongMin");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soLuongMin").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoLuongMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuongMin");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoLuongMin").toString()));
cons.add(con);
}
if(request.getParameter( "toSoLuongMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLuongMin");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoLuongMin").toString()));
cons.add(con);
}

return cons;
}
//việt
}