


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
import com.cce.vietnguyen.model.Tbl_QLDT_TN_DotTotNghiep_DanhSach;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TN_DotTotNghiep;
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TN_DotTotNghiep_DanhSachController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep_danhsach", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TN_DotTotNghiep_DanhSach .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep_danhsach/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep_danhsach", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TN_DotTotNghiep_DanhSach .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep_danhsach/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep_danhsach", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_TN_DotTotNghiep_DanhSach obj = (Tbl_QLDT_TN_DotTotNghiep_DanhSach) genericDAO.get(Tbl_QLDT_TN_DotTotNghiep_DanhSach .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep_danhsach", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TN_DotTotNghiep_DanhSach obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep_danhsach", "them")){
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
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep_danhsach/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep_danhsach", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TN_DotTotNghiep_DanhSach .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep_danhsach", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TN_DotTotNghiep_DanhSach obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep_danhsach", "sua")){
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
@RequestMapping(value="/tbl_qldt_tn_dottotnghiep_danhsach/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_dottotnghiep_danhsach", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TN_DotTotNghiep_DanhSach .class, cons), HttpStatus.OK);
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
if(request.getParameter( "dotTotNghiepId" ) != null){
Tbl_QLDT_TN_DotTotNghiep obj =
new ObjectMapper().readValue(
request.getParameter("dotTotNghiepId")
, Tbl_QLDT_TN_DotTotNghiep.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("dotTotNghiepId.id");
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
  if(request.getParameter( "xepLoaiTotNghiep" ) != null){
MyFilter con = new MyFilter();
con.setCol("xepLoaiTotNghiep");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("xepLoaiTotNghiep") + "%");
cons.add(con);
}
  if(request.getParameter( "duocTotNghiepYN" ) != null && Boolean.parseBoolean(request.getParameter("duocTotNghiepYN"))){
MyFilter con = new MyFilter();
con.setCol("duocTotNghiepYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("duocTotNghiepYN").toString()));
cons.add(con);
}

  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
cons.add(con);
}
  if(request.getParameter( "diemTB" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemTB");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemTB").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemTB" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemTB");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemTB").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemTB" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemTB");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemTB").toString()));
cons.add(con);
}

return cons;
}
//việt
}