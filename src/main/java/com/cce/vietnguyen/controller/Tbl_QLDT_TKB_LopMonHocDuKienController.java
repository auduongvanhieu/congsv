


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
import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHocDuKien;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_GiangVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TKB_LopMonHocDuKienController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_tkb_lopmonhocdukien", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TKB_LopMonHocDuKien .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhocdukien/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhocdukien", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TKB_LopMonHocDuKien .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhocdukien/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhocdukien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_TKB_LopMonHocDuKien obj = (Tbl_QLDT_TKB_LopMonHocDuKien) genericDAO.get(Tbl_QLDT_TKB_LopMonHocDuKien .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhocdukien", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TKB_LopMonHocDuKien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhocdukien", "them")){
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
@RequestMapping(value="/tbl_qldt_tkb_lopmonhocdukien/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhocdukien", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TKB_LopMonHocDuKien .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_lopmonhocdukien", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TKB_LopMonHocDuKien obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhocdukien", "sua")){
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
@RequestMapping(value="/tbl_qldt_tkb_lopmonhocdukien/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_lopmonhocdukien", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TKB_LopMonHocDuKien .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "maLop" ) != null){
MyFilter con = new MyFilter();
con.setCol("maLop");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maLop") + "%");
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
  if(request.getParameter( "soSVDangKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("soSVDangKy");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soSVDangKy").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoSVDangKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("soSVDangKy");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoSVDangKy").toString()));
cons.add(con);
}
if(request.getParameter( "toSoSVDangKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("soSVDangKy");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoSVDangKy").toString()));
cons.add(con);
}
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
  if(request.getParameter( "moLopYN" ) != null && Boolean.parseBoolean(request.getParameter("moLopYN"))){
MyFilter con = new MyFilter();
con.setCol("moLopYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("moLopYN").toString()));
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

return cons;
}
//việt
}