


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_TieuChuanKhenThuong;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_KhoiNganh;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLHV_TieuChuanKhenThuongController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qlhv_tieuchuankhenthuong", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLHV_TieuChuanKhenThuong .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qlhv_tieuchuankhenthuong/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_tieuchuankhenthuong", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLHV_TieuChuanKhenThuong .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qlhv_tieuchuankhenthuong/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_tieuchuankhenthuong", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_QLHV_TieuChuanKhenThuong obj = (Tbl_QLDT_QLHV_TieuChuanKhenThuong) genericDAO.get(Tbl_QLDT_QLHV_TieuChuanKhenThuong .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_tieuchuankhenthuong", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLHV_TieuChuanKhenThuong obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_tieuchuankhenthuong", "them")){
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
@RequestMapping(value="/tbl_qldt_qlhv_tieuchuankhenthuong/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_tieuchuankhenthuong", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLHV_TieuChuanKhenThuong .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_tieuchuankhenthuong", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLHV_TieuChuanKhenThuong obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_tieuchuankhenthuong", "sua")){
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
@RequestMapping(value="/tbl_qldt_qlhv_tieuchuankhenthuong/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_tieuchuankhenthuong", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLHV_TieuChuanKhenThuong .class, cons), HttpStatus.OK);
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
if(request.getParameter( "hocKyId" ) != null){
Tbl_QLDT_HocKyTrongNam obj =
new ObjectMapper().readValue(
request.getParameter("hocKyId")
, Tbl_QLDT_HocKyTrongNam.class
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
if(request.getParameter( "khoiNganhId" ) != null){
Tbl_QLDT_CTDT_KhoiNganh obj =
new ObjectMapper().readValue(
request.getParameter("khoiNganhId")
, Tbl_QLDT_CTDT_KhoiNganh.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("khoiNganhId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "soTinChiMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiMin");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soTinChiMin").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTinChiMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiMin");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoTinChiMin").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTinChiMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiMin");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoTinChiMin").toString()));
cons.add(con);
}
  if(request.getParameter( "diemLoaiKha" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemLoaiKha");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemLoaiKha").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemLoaiKha" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemLoaiKha");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemLoaiKha").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemLoaiKha" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemLoaiKha");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemLoaiKha").toString()));
cons.add(con);
}
  if(request.getParameter( "diemLoaiGioi" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemLoaiGioi");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemLoaiGioi").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemLoaiGioi" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemLoaiGioi");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemLoaiGioi").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemLoaiGioi" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemLoaiGioi");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemLoaiGioi").toString()));
cons.add(con);
}
  if(request.getParameter( "phanTramKha" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramKha");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("phanTramKha").toString()));
cons.add(con);
}
if(request.getParameter( "fromPhanTramKha" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramKha");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromPhanTramKha").toString()));
cons.add(con);
}
if(request.getParameter( "toPhanTramKha" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramKha");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toPhanTramKha").toString()));
cons.add(con);
}
  if(request.getParameter( "phanTramGioi" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramGioi");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("phanTramGioi").toString()));
cons.add(con);
}
if(request.getParameter( "fromPhanTramGioi" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramGioi");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromPhanTramGioi").toString()));
cons.add(con);
}
if(request.getParameter( "toPhanTramGioi" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramGioi");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toPhanTramGioi").toString()));
cons.add(con);
}

return cons;
}
//việt
}