


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
import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSo_DiemTong;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSoXetTuyen;
 

  import com.cce.vietnguyen.model.core.Tbl_CanBo;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TS_HoSo_DiemTongController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_ts_hoso_diemtong", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TS_HoSo_DiemTong .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_diemtong/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_diemtong", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TS_HoSo_DiemTong .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_ts_hoso_diemtong/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_diemtong", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_TS_HoSo_DiemTong obj = (Tbl_QLDT_TS_HoSo_DiemTong) genericDAO.get(Tbl_QLDT_TS_HoSo_DiemTong .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_diemtong", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TS_HoSo_DiemTong obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_diemtong", "them")){
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
@RequestMapping(value="/tbl_qldt_ts_hoso_diemtong/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_diemtong", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TS_HoSo_DiemTong .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_diemtong", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TS_HoSo_DiemTong obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_diemtong", "sua")){
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
@RequestMapping(value="/tbl_qldt_ts_hoso_diemtong/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_diemtong", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TS_HoSo_DiemTong .class, cons), HttpStatus.OK);
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
if(request.getParameter( "hoSoId" ) != null){
Tbl_QLDT_TS_HoSoXetTuyen obj =
new ObjectMapper().readValue(
request.getParameter("hoSoId")
, Tbl_QLDT_TS_HoSoXetTuyen.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("hoSoId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "diemTong" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemTong");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemTong").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemTong" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemTong");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemTong").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemTong" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemTong");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemTong").toString()));
cons.add(con);
}
  if(request.getParameter( "diemXetTuyen" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemXetTuyen");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemXetTuyen").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemXetTuyen" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemXetTuyen");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemXetTuyen").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemXetTuyen" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemXetTuyen");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemXetTuyen").toString()));
cons.add(con);
}
  if(request.getParameter( "diemThiDH" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiDH");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemThiDH").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemThiDH" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiDH");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemThiDH").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemThiDH" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemThiDH");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemThiDH").toString()));
cons.add(con);
}
  if(request.getParameter( "diemXetTuyenDH" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemXetTuyenDH");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemXetTuyenDH").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemXetTuyenDH" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemXetTuyenDH");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemXetTuyenDH").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemXetTuyenDH" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemXetTuyenDH");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemXetTuyenDH").toString()));
cons.add(con);
}
  if(request.getParameter( "ketQua" ) != null){
MyFilter con = new MyFilter();
con.setCol("ketQua");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ketQua") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayXetTuyen" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayXetTuyen");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayXetTuyen").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayXetTuyen" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayXetTuyen");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayXetTuyen").toString());
cons.add(con);
}
if(request.getParameter( "toNgayXetTuyen" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayXetTuyen");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayXetTuyen").toString());
cons.add(con);
}

  try{
if(request.getParameter( "canBoId" ) != null){
Tbl_CanBo obj =
new ObjectMapper().readValue(
request.getParameter("canBoId")
, Tbl_CanBo.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("canBoId.id");
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