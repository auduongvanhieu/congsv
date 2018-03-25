


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien_KetQuaHocTap;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 

  import com.cce.vietnguyen.model.core.Tbl_CanBo;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLHV_HocVien_KetQuaHocTapController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qlhv_hocvien_ketquahoctap", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLHV_HocVien_KetQuaHocTap .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qlhv_hocvien_ketquahoctap/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien_ketquahoctap", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLHV_HocVien_KetQuaHocTap .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qlhv_hocvien_ketquahoctap/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien_ketquahoctap", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_QLHV_HocVien_KetQuaHocTap obj = (Tbl_QLDT_QLHV_HocVien_KetQuaHocTap) genericDAO.get(Tbl_QLDT_QLHV_HocVien_KetQuaHocTap .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_hocvien_ketquahoctap", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLHV_HocVien_KetQuaHocTap obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien_ketquahoctap", "them")){
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
@RequestMapping(value="/tbl_qldt_qlhv_hocvien_ketquahoctap/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien_ketquahoctap", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLHV_HocVien_KetQuaHocTap .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qlhv_hocvien_ketquahoctap", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLHV_HocVien_KetQuaHocTap obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien_ketquahoctap", "sua")){
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
@RequestMapping(value="/tbl_qldt_qlhv_hocvien_ketquahoctap/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qlhv_hocvien_ketquahoctap", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLHV_HocVien_KetQuaHocTap .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "diem10" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem10");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diem10").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiem10" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem10");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiem10").toString()));
cons.add(con);
}
if(request.getParameter( "toDiem10" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem10");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiem10").toString()));
cons.add(con);
}
  if(request.getParameter( "diem4" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem4");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diem4").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiem4" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem4");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiem4").toString()));
cons.add(con);
}
if(request.getParameter( "toDiem4" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem4");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiem4").toString()));
cons.add(con);
}
  if(request.getParameter( "diemChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("diemChu") + "%");
cons.add(con);
}
  if(request.getParameter( "xepLoai" ) != null){
MyFilter con = new MyFilter();
con.setCol("xepLoai");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("xepLoai") + "%");
cons.add(con);
}
  if(request.getParameter( "datYN" ) != null && Boolean.parseBoolean(request.getParameter("datYN"))){
MyFilter con = new MyFilter();
con.setCol("datYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("datYN").toString()));
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

  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
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
  if(request.getParameter( "soLanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLanHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("soLanHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoLanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLanHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromSoLanHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toSoLanHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("soLanHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toSoLanHoc").toString()));
cons.add(con);
}

return cons;
}
//việt
}