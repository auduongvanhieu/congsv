


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
import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHocDuKien;
 
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TKB_LopMonHocController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TKB_LopMonHoc .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TKB_LopMonHoc .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
    //advh
//if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc", "xem")){
//return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//}
Tbl_QLDT_TKB_LopMonHoc obj = (Tbl_QLDT_TKB_LopMonHoc) genericDAO.get(Tbl_QLDT_TKB_LopMonHoc .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TKB_LopMonHoc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc", "them")){
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
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TKB_LopMonHoc .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TKB_LopMonHoc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc", "sua")){
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
@RequestMapping(value="/tbl_qldt_tkb_lopmonhoc/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhoc", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TKB_LopMonHoc .class, cons), HttpStatus.OK);
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
  try{
if(request.getParameter( "giaoVienId" ) != null){
Tbl_QLDT_GiangVien obj =
new ObjectMapper().readValue(
request.getParameter("giaoVienId")
, Tbl_QLDT_GiangVien.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("giaoVienId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
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
if(request.getParameter( "monHocId" ) != null){
Tbl_QLDT_CTDT_MonHoc obj =
new ObjectMapper().readValue(
request.getParameter("monHocId")
, Tbl_QLDT_CTDT_MonHoc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("monHocId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "ma" ) != null){
MyFilter con = new MyFilter();
con.setCol("ma");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ma") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayBatDau");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayBatDau").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayBatDau");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayBatDau").toString());
cons.add(con);
}
if(request.getParameter( "toNgayBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayBatDau");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayBatDau").toString());
cons.add(con);
}

  if(request.getParameter( "ngayKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKetThuc");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayKetThuc").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKetThuc");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayKetThuc").toString());
cons.add(con);
}
if(request.getParameter( "toNgayKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKetThuc");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayKetThuc").toString());
cons.add(con);
}

  if(request.getParameter( "ngayKiemTraGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKiemTraGK");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayKiemTraGK").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayKiemTraGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKiemTraGK");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayKiemTraGK").toString());
cons.add(con);
}
if(request.getParameter( "toNgayKiemTraGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKiemTraGK");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayKiemTraGK").toString());
cons.add(con);
}

  if(request.getParameter( "ngayThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayThi");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayThi").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayThi");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayThi").toString());
cons.add(con);
}
if(request.getParameter( "toNgayThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayThi");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayThi").toString());
cons.add(con);
}

  if(request.getParameter( "phanTramGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramGK");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("phanTramGK").toString()));
cons.add(con);
}
if(request.getParameter( "fromPhanTramGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramGK");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromPhanTramGK").toString()));
cons.add(con);
}
if(request.getParameter( "toPhanTramGK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramGK");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toPhanTramGK").toString()));
cons.add(con);
}
  if(request.getParameter( "phanTramCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramCK");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("phanTramCK").toString()));
cons.add(con);
}
if(request.getParameter( "fromPhanTramCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramCK");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromPhanTramCK").toString()));
cons.add(con);
}
if(request.getParameter( "toPhanTramCK" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramCK");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toPhanTramCK").toString()));
cons.add(con);
}
  if(request.getParameter( "phanTramCC" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramCC");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("phanTramCC").toString()));
cons.add(con);
}
if(request.getParameter( "fromPhanTramCC" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramCC");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromPhanTramCC").toString()));
cons.add(con);
}
if(request.getParameter( "toPhanTramCC" ) != null){
MyFilter con = new MyFilter();
con.setCol("phanTramCC");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toPhanTramCC").toString()));
cons.add(con);
}
  if(request.getParameter( "siSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("siSo").toString()));
cons.add(con);
}
if(request.getParameter( "fromSiSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSiSo").toString()));
cons.add(con);
}
if(request.getParameter( "toSiSo" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSo");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSiSo").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "lopDuKienId" ) != null){
Tbl_QLDT_TKB_LopMonHocDuKien obj =
new ObjectMapper().readValue(
request.getParameter("lopDuKienId")
, Tbl_QLDT_TKB_LopMonHocDuKien.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("lopDuKienId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "tuanBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanBatDau");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("tuanBatDau").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuanBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanBatDau");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromTuanBatDau").toString()));
cons.add(con);
}
if(request.getParameter( "toTuanBatDau" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanBatDau");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toTuanBatDau").toString()));
cons.add(con);
}
  if(request.getParameter( "tuanKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanKetThuc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("tuanKetThuc").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuanKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanKetThuc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromTuanKetThuc").toString()));
cons.add(con);
}
if(request.getParameter( "toTuanKetThuc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanKetThuc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toTuanKetThuc").toString()));
cons.add(con);
}
  if(request.getParameter( "tuanThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanThi");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("tuanThi").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuanThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanThi");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromTuanThi").toString()));
cons.add(con);
}
if(request.getParameter( "toTuanThi" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanThi");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toTuanThi").toString()));
cons.add(con);
}
  if(request.getParameter( "soTiet2" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet2");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soTiet2").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTiet2" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet2");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoTiet2").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTiet2" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet2");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoTiet2").toString()));
cons.add(con);
}
  if(request.getParameter( "siSoMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoMin");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("siSoMin").toString()));
cons.add(con);
}
if(request.getParameter( "fromSiSoMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoMin");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSiSoMin").toString()));
cons.add(con);
}
if(request.getParameter( "toSiSoMin" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoMin");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSiSoMin").toString()));
cons.add(con);
}
  if(request.getParameter( "moLopYN" ) != null && Boolean.parseBoolean(request.getParameter("moLopYN"))){
MyFilter con = new MyFilter();
con.setCol("moLopYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("moLopYN").toString()));
cons.add(con);
}

  if(request.getParameter( "soTiet1" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet1");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soTiet1").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTiet1" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet1");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoTiet1").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTiet1" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet1");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoTiet1").toString()));
cons.add(con);
}
  if(request.getParameter( "soTiet3" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet3");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soTiet3").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTiet3" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet3");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoTiet3").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTiet3" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTiet3");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoTiet3").toString()));
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
  try{
if(request.getParameter( "coSoId" ) != null){
Tbl_QLDT_DM_CoSo obj =
new ObjectMapper().readValue(
request.getParameter("coSoId")
, Tbl_QLDT_DM_CoSo.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("coSoId.id");
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
  if(request.getParameter( "tuanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("tuanHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromTuanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromTuanHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toTuanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toTuanHoc").toString()));
cons.add(con);
}
  if(request.getParameter( "siSoMax" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoMax");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("siSoMax").toString()));
cons.add(con);
}
if(request.getParameter( "fromSiSoMax" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoMax");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSiSoMax").toString()));
cons.add(con);
}
if(request.getParameter( "toSiSoMax" ) != null){
MyFilter con = new MyFilter();
con.setCol("siSoMax");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSiSoMax").toString()));
cons.add(con);
}
  if(request.getParameter( "giaoVien2Id" ) != null){
MyFilter con = new MyFilter();
con.setCol("giaoVien2Id");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("giaoVien2Id").toString()));
cons.add(con);
}
if(request.getParameter( "fromGiaoVien2Id" ) != null){
MyFilter con = new MyFilter();
con.setCol("giaoVien2Id");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromGiaoVien2Id").toString()));
cons.add(con);
}
if(request.getParameter( "toGiaoVien2Id" ) != null){
MyFilter con = new MyFilter();
con.setCol("giaoVien2Id");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toGiaoVien2Id").toString()));
cons.add(con);
}
  if(request.getParameter( "khoaBangDiemYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaBangDiemYN");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("khoaBangDiemYN").toString()));
cons.add(con);
}
if(request.getParameter( "fromKhoaBangDiemYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaBangDiemYN");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromKhoaBangDiemYN").toString()));
cons.add(con);
}
if(request.getParameter( "toKhoaBangDiemYN" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaBangDiemYN");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toKhoaBangDiemYN").toString()));
cons.add(con);
}

return cons;
}
//việt
}