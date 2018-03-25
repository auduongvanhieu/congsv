


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
import com.cce.vietnguyen.model.Tbl_QLDT_HP_LopMonHoc_HocPhi;
 
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_HP_LopMonHoc_HocPhiController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_hp_lopmonhoc_hocphi", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_HP_LopMonHoc_HocPhi .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_hp_lopmonhoc_hocphi/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_lopmonhoc_hocphi", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_HP_LopMonHoc_HocPhi .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_hp_lopmonhoc_hocphi/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_lopmonhoc_hocphi", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_HP_LopMonHoc_HocPhi obj = (Tbl_QLDT_HP_LopMonHoc_HocPhi) genericDAO.get(Tbl_QLDT_HP_LopMonHoc_HocPhi .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_hp_lopmonhoc_hocphi", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_HP_LopMonHoc_HocPhi obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_lopmonhoc_hocphi", "them")){
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
@RequestMapping(value="/tbl_qldt_hp_lopmonhoc_hocphi/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_lopmonhoc_hocphi", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_HP_LopMonHoc_HocPhi .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_hp_lopmonhoc_hocphi", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_HP_LopMonHoc_HocPhi obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_lopmonhoc_hocphi", "sua")){
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
@RequestMapping(value="/tbl_qldt_hp_lopmonhoc_hocphi/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_lopmonhoc_hocphi", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_HP_LopMonHoc_HocPhi .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "donGiaTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTinChiLT");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGiaTinChiLT").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGiaTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTinChiLT");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGiaTinChiLT").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGiaTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTinChiLT");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGiaTinChiLT").toString()));
cons.add(con);
}
  if(request.getParameter( "donGiaTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTinChiTH");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGiaTinChiTH").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGiaTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTinChiTH");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGiaTinChiTH").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGiaTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaTinChiTH");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGiaTinChiTH").toString()));
cons.add(con);
}
  if(request.getParameter( "heSoTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoTinChiLT");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("heSoTinChiLT").toString()));
cons.add(con);
}
if(request.getParameter( "fromHeSoTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoTinChiLT");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHeSoTinChiLT").toString()));
cons.add(con);
}
if(request.getParameter( "toHeSoTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoTinChiLT");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHeSoTinChiLT").toString()));
cons.add(con);
}
  if(request.getParameter( "heSoTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoTinChiTH");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("heSoTinChiTH").toString()));
cons.add(con);
}
if(request.getParameter( "fromHeSoTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoTinChiTH");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHeSoTinChiTH").toString()));
cons.add(con);
}
if(request.getParameter( "toHeSoTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoTinChiTH");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHeSoTinChiTH").toString()));
cons.add(con);
}
  if(request.getParameter( "tongTien" ) != null){
MyFilter con = new MyFilter();
con.setCol("tongTien");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("tongTien").toString()));
cons.add(con);
}
if(request.getParameter( "fromTongTien" ) != null){
MyFilter con = new MyFilter();
con.setCol("tongTien");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromTongTien").toString()));
cons.add(con);
}
if(request.getParameter( "toTongTien" ) != null){
MyFilter con = new MyFilter();
con.setCol("tongTien");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toTongTien").toString()));
cons.add(con);
}
  if(request.getParameter( "lopMonHocId" ) != null){
MyFilter con = new MyFilter();
con.setCol("lopMonHocId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("lopMonHocId").toString()));
cons.add(con);
}
if(request.getParameter( "fromLopMonHocId" ) != null){
MyFilter con = new MyFilter();
con.setCol("lopMonHocId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromLopMonHocId").toString()));
cons.add(con);
}
if(request.getParameter( "toLopMonHocId" ) != null){
MyFilter con = new MyFilter();
con.setCol("lopMonHocId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toLopMonHocId").toString()));
cons.add(con);
}
  if(request.getParameter( "heSoPhongMay" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoPhongMay");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("heSoPhongMay").toString()));
cons.add(con);
}
if(request.getParameter( "fromHeSoPhongMay" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoPhongMay");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHeSoPhongMay").toString()));
cons.add(con);
}
if(request.getParameter( "toHeSoPhongMay" ) != null){
MyFilter con = new MyFilter();
con.setCol("heSoPhongMay");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHeSoPhongMay").toString()));
cons.add(con);
}
  if(request.getParameter( "khoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("khoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromKhoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toKhoaHoc").toString()));
cons.add(con);
}

return cons;
}
//việt
}