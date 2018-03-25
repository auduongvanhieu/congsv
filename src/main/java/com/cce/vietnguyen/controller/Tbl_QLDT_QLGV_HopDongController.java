


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLGV_HopDong;
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;

  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLGV_HopDongController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qlgv_hopdong", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLGV_HopDong .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qlgv_hopdong/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLGV_HopDong .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qlgv_hopdong/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_QLGV_HopDong obj = (Tbl_QLDT_QLGV_HopDong) genericDAO.get(Tbl_QLDT_QLGV_HopDong .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlgv_hopdong", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLGV_HopDong obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong", "them")){
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
@RequestMapping(value="/tbl_qldt_qlgv_hopdong/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLGV_HopDong .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlgv_hopdong", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLGV_HopDong obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong", "sua")){
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
@RequestMapping(value="/tbl_qldt_qlgv_hopdong/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlgv_hopdong", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLGV_HopDong .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "soHopDong" ) != null){
MyFilter con = new MyFilter();
con.setCol("soHopDong");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("soHopDong") + "%");
cons.add(con);
}
  if(request.getParameter( "soPhuLuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soPhuLuc");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("soPhuLuc") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKy");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayKy").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKy");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayKy").toString());
cons.add(con);
}
if(request.getParameter( "toNgayKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKy");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayKy").toString());
cons.add(con);
}

  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
cons.add(con);
}
  if(request.getParameter( "ma" ) != null){
MyFilter con = new MyFilter();
con.setCol("ma");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ma") + "%");
cons.add(con);
}
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
  if(request.getParameter( "chucVu" ) != null){
MyFilter con = new MyFilter();
con.setCol("chucVu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("chucVu") + "%");
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
  if(request.getParameter( "ngayTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTao");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayTao").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTao");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayTao").toString());
cons.add(con);
}
if(request.getParameter( "toNgayTao" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayTao");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayTao").toString());
cons.add(con);
}

  if(request.getParameter( "donGiaGiangDay" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaGiangDay");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGiaGiangDay").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGiaGiangDay" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaGiangDay");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGiaGiangDay").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGiaGiangDay" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaGiangDay");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGiaGiangDay").toString()));
cons.add(con);
}
  if(request.getParameter( "donGiaChamBai" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaChamBai");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGiaChamBai").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGiaChamBai" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaChamBai");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGiaChamBai").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGiaChamBai" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaChamBai");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGiaChamBai").toString()));
cons.add(con);
}
  if(request.getParameter( "nguoiDaiDien" ) != null){
MyFilter con = new MyFilter();
con.setCol("nguoiDaiDien");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("nguoiDaiDien") + "%");
cons.add(con);
}
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
  if(request.getParameter( "huyYN" ) != null && Boolean.parseBoolean(request.getParameter("huyYN"))){
MyFilter con = new MyFilter();
con.setCol("huyYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("huyYN").toString()));
cons.add(con);
}

  if(request.getParameter( "donGiaGiangDayTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaGiangDayTH");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("donGiaGiangDayTH").toString()));
cons.add(con);
}
if(request.getParameter( "fromDonGiaGiangDayTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaGiangDayTH");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDonGiaGiangDayTH").toString()));
cons.add(con);
}
if(request.getParameter( "toDonGiaGiangDayTH" ) != null){
MyFilter con = new MyFilter();
con.setCol("donGiaGiangDayTH");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDonGiaGiangDayTH").toString()));
cons.add(con);
}

return cons;
}
//việt
}