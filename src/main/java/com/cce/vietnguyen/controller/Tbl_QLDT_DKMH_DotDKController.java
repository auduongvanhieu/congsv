


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
import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_DotDK;
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
 
 
 
 
 
  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_DKMH_DotDKController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_dkmh_dotdk", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_DKMH_DotDK .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_dkmh_dotdk/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_dotdk", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DKMH_DotDK .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_dkmh_dotdk/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_dotdk", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_DKMH_DotDK obj = (Tbl_QLDT_DKMH_DotDK) genericDAO.get(Tbl_QLDT_DKMH_DotDK .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_dotdk", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_DKMH_DotDK obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_dotdk", "them")){
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
@RequestMapping(value="/tbl_qldt_dkmh_dotdk/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_dotdk", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_DKMH_DotDK .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_dotdk", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_DKMH_DotDK obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_dotdk", "sua")){
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
@RequestMapping(value="/tbl_qldt_dkmh_dotdk/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_dotdk", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_DKMH_DotDK .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "khoaDotDK" ) != null && Boolean.parseBoolean(request.getParameter("khoaDotDK"))){
MyFilter con = new MyFilter();
con.setCol("khoaDotDK");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("khoaDotDK").toString()));
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
  if(request.getParameter( "denKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("denKhoaHoc");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("denKhoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "fromDenKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("denKhoaHoc");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromDenKhoaHoc").toString()));
cons.add(con);
}
if(request.getParameter( "toDenKhoaHoc" ) != null){
MyFilter con = new MyFilter();
con.setCol("denKhoaHoc");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toDenKhoaHoc").toString()));
cons.add(con);
}
  if(request.getParameter( "quyen" ) != null){
MyFilter con = new MyFilter();
con.setCol("quyen");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("quyen") + "%");
cons.add(con);
}
  if(request.getParameter( "khoaId" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("khoaId").toString()));
cons.add(con);
}
if(request.getParameter( "fromKhoaId" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromKhoaId").toString()));
cons.add(con);
}
if(request.getParameter( "toKhoaId" ) != null){
MyFilter con = new MyFilter();
con.setCol("khoaId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toKhoaId").toString()));
cons.add(con);
}

return cons;
}
//việt
}