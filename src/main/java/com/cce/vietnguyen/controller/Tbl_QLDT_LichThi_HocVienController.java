


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
import com.cce.vietnguyen.model.Tbl_QLDT_LichThi_HocVien;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_LichThi;
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_LichThi_HocVienController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_lichthi_hocvien", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_LichThi_HocVien .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_lichthi_hocvien/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_hocvien", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_LichThi_HocVien .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_lichthi_hocvien/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_hocvien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_LichThi_HocVien obj = (Tbl_QLDT_LichThi_HocVien) genericDAO.get(Tbl_QLDT_LichThi_HocVien .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_lichthi_hocvien", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_LichThi_HocVien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_hocvien", "them")){
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
@RequestMapping(value="/tbl_qldt_lichthi_hocvien/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_hocvien", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_LichThi_HocVien .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_lichthi_hocvien", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_LichThi_HocVien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_hocvien", "sua")){
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
@RequestMapping(value="/tbl_qldt_lichthi_hocvien/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_lichthi_hocvien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_LichThi_HocVien .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "hocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("hocVienId").toString()));
cons.add(con);
}
if(request.getParameter( "fromHocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromHocVienId").toString()));
cons.add(con);
}
if(request.getParameter( "toHocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toHocVienId").toString()));
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

return cons;
}
//việt
}