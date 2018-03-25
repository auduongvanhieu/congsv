


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
import com.cce.vietnguyen.model.Tbl_QLDT_SoYeuLyLich;
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TonGiao;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_DanToc;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_SoYeuLyLichController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_soyeulylich", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_SoYeuLyLich .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_soyeulylich/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_soyeulylich", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_SoYeuLyLich .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_soyeulylich/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_soyeulylich", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_SoYeuLyLich obj = (Tbl_QLDT_SoYeuLyLich) genericDAO.get(Tbl_QLDT_SoYeuLyLich .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_soyeulylich", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_SoYeuLyLich obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_soyeulylich", "them")){
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
@RequestMapping(value="/tbl_qldt_soyeulylich/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_soyeulylich", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_SoYeuLyLich .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_soyeulylich", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_SoYeuLyLich obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_soyeulylich", "sua")){
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
@RequestMapping(value="/tbl_qldt_soyeulylich/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_soyeulylich", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_SoYeuLyLich .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "email" ) != null){
MyFilter con = new MyFilter();
con.setCol("email");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("email") + "%");
cons.add(con);
}
  if(request.getParameter( "diaChi" ) != null){
MyFilter con = new MyFilter();
con.setCol("diaChi");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("diaChi") + "%");
cons.add(con);
}
  if(request.getParameter( "dienThoai" ) != null){
MyFilter con = new MyFilter();
con.setCol("dienThoai");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("dienThoai") + "%");
cons.add(con);
}
  if(request.getParameter( "ngaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngaySinh").toString());
cons.add(con);
}
if(request.getParameter( "fromNgaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgaySinh").toString());
cons.add(con);
}
if(request.getParameter( "toNgaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgaySinh").toString());
cons.add(con);
}

  if(request.getParameter( "noiSinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiSinh");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiSinh") + "%");
cons.add(con);
}
  if(request.getParameter( "tamTru" ) != null){
MyFilter con = new MyFilter();
con.setCol("tamTru");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("tamTru") + "%");
cons.add(con);
}
  try{
if(request.getParameter( "tonGiaoId" ) != null){
Tbl_QLDT_DM_TonGiao obj =
new ObjectMapper().readValue(
request.getParameter("tonGiaoId")
, Tbl_QLDT_DM_TonGiao.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("tonGiaoId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "danTocId" ) != null){
Tbl_QLDT_DM_DanToc obj =
new ObjectMapper().readValue(
request.getParameter("danTocId")
, Tbl_QLDT_DM_DanToc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("danTocId.id");
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