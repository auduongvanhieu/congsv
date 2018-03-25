


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganhController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qlhv_donxinchuyentruong_chuyennganh/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qlhv_donxinchuyentruong_chuyennganh/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh obj = (Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh) genericDAO.get(Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", "them")){
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
@RequestMapping(value="/tbl_qldt_qlhv_donxinchuyentruong_chuyennganh/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", "sua")){
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
@RequestMapping(value="/tbl_qldt_qlhv_donxinchuyentruong_chuyennganh/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_donxinchuyentruong_chuyennganh", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLHV_DonXinChuyenTruong_ChuyenNganh .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "yKienNoiChuyenDen" ) != null){
MyFilter con = new MyFilter();
con.setCol("yKienNoiChuyenDen");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("yKienNoiChuyenDen") + "%");
cons.add(con);
}
  if(request.getParameter( "yKienNoiChuyenDi" ) != null){
MyFilter con = new MyFilter();
con.setCol("yKienNoiChuyenDi");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("yKienNoiChuyenDi") + "%");
cons.add(con);
}
  if(request.getParameter( "dongYChuyenDiYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("dongYChuyenDiYN");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("dongYChuyenDiYN").toString()));
cons.add(con);
}
if(request.getParameter( "fromDongYChuyenDiYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("dongYChuyenDiYN");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromDongYChuyenDiYN").toString()));
cons.add(con);
}
if(request.getParameter( "toDongYChuyenDiYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("dongYChuyenDiYN");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toDongYChuyenDiYN").toString()));
cons.add(con);
}
  if(request.getParameter( "dongYTiepNhanYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("dongYTiepNhanYN");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("dongYTiepNhanYN").toString()));
cons.add(con);
}
if(request.getParameter( "fromDongYTiepNhanYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("dongYTiepNhanYN");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromDongYTiepNhanYN").toString()));
cons.add(con);
}
if(request.getParameter( "toDongYTiepNhanYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("dongYTiepNhanYN");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toDongYTiepNhanYN").toString()));
cons.add(con);
}
  if(request.getParameter( "lyDo" ) != null){
MyFilter con = new MyFilter();
con.setCol("lyDo");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("lyDo") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayCapNhat" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapNhat");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayCapNhat").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayCapNhat" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapNhat");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayCapNhat").toString());
cons.add(con);
}
if(request.getParameter( "toNgayCapNhat" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCapNhat");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayCapNhat").toString());
cons.add(con);
}

  if(request.getParameter( "ngayLamDon" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLamDon");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayLamDon").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayLamDon" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLamDon");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayLamDon").toString());
cons.add(con);
}
if(request.getParameter( "toNgayLamDon" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayLamDon");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayLamDon").toString());
cons.add(con);
}

  if(request.getParameter( "noiDung" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiDung");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiDung") + "%");
cons.add(con);
}
  if(request.getParameter( "sangKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangKhoaHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("sangKhoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromSangKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangKhoaHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSangKhoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toSangKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangKhoaHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSangKhoaHoc").toString()));
cons.add(con);
}
  if(request.getParameter( "sangTruong" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangTruong");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("sangTruong") + "%");
cons.add(con);
}
  if(request.getParameter( "tuKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuKhoaHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("tuKhoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuKhoaHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromTuKhoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toTuKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuKhoaHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toTuKhoaHoc").toString()));
cons.add(con);
}
  if(request.getParameter( "tuTruong" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuTruong");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("tuTruong") + "%");
cons.add(con);
}
  if(request.getParameter( "canBoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("canBoId").toString()));
cons.add(con);
}
if(request.getParameter( "fromCanBoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromCanBoId").toString()));
cons.add(con);
}
if(request.getParameter( "toCanBoId" ) != null){
MyFilter con = new MyFilter();
con.setCol("canBoId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toCanBoId").toString()));
cons.add(con);
}
  if(request.getParameter( "hocKyApDungId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyApDungId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("hocKyApDungId").toString()));
cons.add(con);
}
if(request.getParameter( "fromHocKyApDungId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyApDungId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHocKyApDungId").toString()));
cons.add(con);
}
if(request.getParameter( "toHocKyApDungId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyApDungId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHocKyApDungId").toString()));
cons.add(con);
}
  if(request.getParameter( "hocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("hocVienId").toString()));
cons.add(con);
}
if(request.getParameter( "fromHocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHocVienId").toString()));
cons.add(con);
}
if(request.getParameter( "toHocVienId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocVienId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHocVienId").toString()));
cons.add(con);
}
  if(request.getParameter( "sangChuyenNganh" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangChuyenNganh");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("sangChuyenNganh").toString()));
cons.add(con);
}
if(request.getParameter( "fromSangChuyenNganh" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangChuyenNganh");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSangChuyenNganh").toString()));
cons.add(con);
}
if(request.getParameter( "toSangChuyenNganh" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangChuyenNganh");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSangChuyenNganh").toString()));
cons.add(con);
}
  if(request.getParameter( "sangNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangNganhId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("sangNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "fromSangNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangNganhId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSangNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "toSangNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("sangNganhId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSangNganhId").toString()));
cons.add(con);
}
  if(request.getParameter( "tuChuyenNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuChuyenNganhId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("tuChuyenNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuChuyenNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuChuyenNganhId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromTuChuyenNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "toTuChuyenNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuChuyenNganhId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toTuChuyenNganhId").toString()));
cons.add(con);
}
  if(request.getParameter( "tuNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuNganhId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("tuNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuNganhId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromTuNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "toTuNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuNganhId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toTuNganhId").toString()));
cons.add(con);
}

return cons;
}
//việt
}