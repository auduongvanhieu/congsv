


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
import com.cce.vietnguyen.model.Tbl_QLDT_RBXL_GiangVien_Cam;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_NgayTrongTuan;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_RBXL_GiangVien_CamController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_rbxl_giangvien_cam", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_RBXL_GiangVien_Cam .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_rbxl_giangvien_cam/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_rbxl_giangvien_cam", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_RBXL_GiangVien_Cam .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_rbxl_giangvien_cam/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_rbxl_giangvien_cam", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_RBXL_GiangVien_Cam obj = (Tbl_QLDT_RBXL_GiangVien_Cam) genericDAO.get(Tbl_QLDT_RBXL_GiangVien_Cam .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_rbxl_giangvien_cam", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_RBXL_GiangVien_Cam obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_rbxl_giangvien_cam", "them")){
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
@RequestMapping(value="/tbl_qldt_rbxl_giangvien_cam/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_rbxl_giangvien_cam", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_RBXL_GiangVien_Cam .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_rbxl_giangvien_cam", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_RBXL_GiangVien_Cam obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_rbxl_giangvien_cam", "sua")){
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
@RequestMapping(value="/tbl_qldt_rbxl_giangvien_cam/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_rbxl_giangvien_cam", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_RBXL_GiangVien_Cam .class, cons), HttpStatus.OK);
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
  try{
if(request.getParameter( "giangVienId" ) != null){
Tbl_QLDT_GiangVien obj =
new ObjectMapper().readValue(
request.getParameter("giangVienId")
, Tbl_QLDT_GiangVien.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("giangVienId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "ngayId" ) != null){
Tbl_QLDT_DM_NgayTrongTuan obj =
new ObjectMapper().readValue(
request.getParameter("ngayId")
, Tbl_QLDT_DM_NgayTrongTuan.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("ngayId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "tietBatDauId" ) != null){
Tbl_QLDT_DM_TietHoc obj =
new ObjectMapper().readValue(
request.getParameter("tietBatDauId")
, Tbl_QLDT_DM_TietHoc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("tietBatDauId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "soTiet" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soTiet").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTiet" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoTiet").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTiet" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoTiet").toString()));
cons.add(con);
}
  if(request.getParameter( "tuanDay" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanDay");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("tuanDay").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuanDay" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanDay");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromTuanDay").toString()));
cons.add(con);
}
if(request.getParameter( "toTuanDay" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanDay");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toTuanDay").toString()));
cons.add(con);
}

return cons;
}
//việt
}