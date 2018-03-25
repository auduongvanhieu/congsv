


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
import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_BoMon;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_CTDT_MonHocController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_ctdt_monhoc", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_CTDT_MonHoc .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_ctdt_monhoc/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ctdt_monhoc", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_CTDT_MonHoc .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_ctdt_monhoc/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ctdt_monhoc", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_CTDT_MonHoc obj = (Tbl_QLDT_CTDT_MonHoc) genericDAO.get(Tbl_QLDT_CTDT_MonHoc .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ctdt_monhoc", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_CTDT_MonHoc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ctdt_monhoc", "them")){
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
@RequestMapping(value="/tbl_qldt_ctdt_monhoc/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ctdt_monhoc", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_CTDT_MonHoc .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ctdt_monhoc", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_CTDT_MonHoc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ctdt_monhoc", "sua")){
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
@RequestMapping(value="/tbl_qldt_ctdt_monhoc/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ctdt_monhoc", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_CTDT_MonHoc .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "ten" ) != null){
MyFilter con = new MyFilter();
con.setCol("ten");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ten") + "%");
cons.add(con);
}
  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
cons.add(con);
}
  if(request.getParameter( "soTinChi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChi");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("soTinChi").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTinChi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChi");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSoTinChi").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTinChi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChi");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSoTinChi").toString()));
cons.add(con);
}
  if(request.getParameter( "soTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiLT");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("soTinChiLT").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiLT");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSoTinChiLT").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTinChiLT" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiLT");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSoTinChiLT").toString()));
cons.add(con);
}
  if(request.getParameter( "soTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiTH");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("soTinChiTH").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiTH");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSoTinChiTH").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTinChiTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTinChiTH");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSoTinChiTH").toString()));
cons.add(con);
}
  if(request.getParameter( "maMonHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("maMonHoc");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maMonHoc") + "%");
cons.add(con);
}
  if(request.getParameter( "soTietHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTietHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soTietHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTietHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTietHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoTietHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTietHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTietHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoTietHoc").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "boMonId" ) != null){
Tbl_QLDT_CTDT_BoMon obj =
new ObjectMapper().readValue(
request.getParameter("boMonId")
, Tbl_QLDT_CTDT_BoMon.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("boMonId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "phanTramDanhGiaCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramDanhGiaCK");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("phanTramDanhGiaCK").toString()));
cons.add(con);
}
if(request.getParameter( "fromPhanTramDanhGiaCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramDanhGiaCK");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromPhanTramDanhGiaCK").toString()));
cons.add(con);
}
if(request.getParameter( "toPhanTramDanhGiaCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramDanhGiaCK");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toPhanTramDanhGiaCK").toString()));
cons.add(con);
}
  if(request.getParameter( "phanTramDanhGiaGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramDanhGiaGK");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("phanTramDanhGiaGK").toString()));
cons.add(con);
}
if(request.getParameter( "fromPhanTramDanhGiaGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramDanhGiaGK");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromPhanTramDanhGiaGK").toString()));
cons.add(con);
}
if(request.getParameter( "toPhanTramDanhGiaGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramDanhGiaGK");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toPhanTramDanhGiaGK").toString()));
cons.add(con);
}
  if(request.getParameter( "phanTramChuyenCan" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramChuyenCan");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("phanTramChuyenCan").toString()));
cons.add(con);
}
if(request.getParameter( "fromPhanTramChuyenCan" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramChuyenCan");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromPhanTramChuyenCan").toString()));
cons.add(con);
}
if(request.getParameter( "toPhanTramChuyenCan" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramChuyenCan");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toPhanTramChuyenCan").toString()));
cons.add(con);
}
  if(request.getParameter( "soBuoi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soBuoi");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soBuoi").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoBuoi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soBuoi");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoBuoi").toString()));
cons.add(con);
}
if(request.getParameter( "toSoBuoi" ) != null){
MyFilter con = new MyFilter();
con.setCol("soBuoi");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoBuoi").toString()));
cons.add(con);
}
  if(request.getParameter( "loaiPhong" ) != null){
MyFilter con = new MyFilter();
con.setCol("loaiPhong");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("loaiPhong") + "%");
cons.add(con);
}

return cons;
}
//việt
}