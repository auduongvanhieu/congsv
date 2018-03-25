


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
import com.cce.vietnguyen.model.Tbl_QLDT_TS_ThongBaoTuyenSinh;
 
 
 
 
 
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TS_ThongBaoTuyenSinhController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_ts_thongbaotuyensinh", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TS_ThongBaoTuyenSinh .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_ts_thongbaotuyensinh/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_thongbaotuyensinh", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TS_ThongBaoTuyenSinh .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_ts_thongbaotuyensinh/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_thongbaotuyensinh", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_TS_ThongBaoTuyenSinh obj = (Tbl_QLDT_TS_ThongBaoTuyenSinh) genericDAO.get(Tbl_QLDT_TS_ThongBaoTuyenSinh .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_thongbaotuyensinh", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TS_ThongBaoTuyenSinh obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_thongbaotuyensinh", "them")){
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
@RequestMapping(value="/tbl_qldt_ts_thongbaotuyensinh/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_thongbaotuyensinh", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TS_ThongBaoTuyenSinh .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_thongbaotuyensinh", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TS_ThongBaoTuyenSinh obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_thongbaotuyensinh", "sua")){
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
@RequestMapping(value="/tbl_qldt_ts_thongbaotuyensinh/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_thongbaotuyensinh", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TS_ThongBaoTuyenSinh .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "hinhAnh" ) != null){
MyFilter con = new MyFilter();
con.setCol("hinhAnh");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("hinhAnh") + "%");
cons.add(con);
}
  if(request.getParameter( "noiDung" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiDung");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiDung") + "%");
cons.add(con);
}
  if(request.getParameter( "thoiGianBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianBatDau");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("thoiGianBatDau").toString());
cons.add(con);
}
if(request.getParameter( "fromThoiGianBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianBatDau");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromThoiGianBatDau").toString());
cons.add(con);
}
if(request.getParameter( "toThoiGianBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianBatDau");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toThoiGianBatDau").toString());
cons.add(con);
}

  if(request.getParameter( "thoiGianKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianKetThuc");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("thoiGianKetThuc").toString());
cons.add(con);
}
if(request.getParameter( "fromThoiGianKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianKetThuc");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromThoiGianKetThuc").toString());
cons.add(con);
}
if(request.getParameter( "toThoiGianKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("thoiGianKetThuc");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toThoiGianKetThuc").toString());
cons.add(con);
}

  if(request.getParameter( "ngayCongBoKetQua" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCongBoKetQua");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayCongBoKetQua").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayCongBoKetQua" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCongBoKetQua");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayCongBoKetQua").toString());
cons.add(con);
}
if(request.getParameter( "toNgayCongBoKetQua" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCongBoKetQua");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayCongBoKetQua").toString());
cons.add(con);
}

  if(request.getParameter( "ngayHoanTatThuTuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayHoanTatThuTuc");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayHoanTatThuTuc").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayHoanTatThuTuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayHoanTatThuTuc");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayHoanTatThuTuc").toString());
cons.add(con);
}
if(request.getParameter( "toNgayHoanTatThuTuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayHoanTatThuTuc");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayHoanTatThuTuc").toString());
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