


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
import com.cce.vietnguyen.model.Tbl_QLDT_TN_QuyDinhChuanDauRa;
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_LoaiChungChi;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_HeDaoTao;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_Nganh;
  import com.cce.vietnguyen.model.core.Tbl_CanBo;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TN_QuyDinhChuanDauRaController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_tn_quydinhchuandaura", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TN_QuyDinhChuanDauRa .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_tn_quydinhchuandaura/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_quydinhchuandaura", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TN_QuyDinhChuanDauRa .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_tn_quydinhchuandaura/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_quydinhchuandaura", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_TN_QuyDinhChuanDauRa obj = (Tbl_QLDT_TN_QuyDinhChuanDauRa) genericDAO.get(Tbl_QLDT_TN_QuyDinhChuanDauRa .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tn_quydinhchuandaura", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TN_QuyDinhChuanDauRa obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_quydinhchuandaura", "them")){
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
@RequestMapping(value="/tbl_qldt_tn_quydinhchuandaura/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_quydinhchuandaura", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TN_QuyDinhChuanDauRa .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tn_quydinhchuandaura", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TN_QuyDinhChuanDauRa obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_quydinhchuandaura", "sua")){
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
@RequestMapping(value="/tbl_qldt_tn_quydinhchuandaura/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tn_quydinhchuandaura", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TN_QuyDinhChuanDauRa .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "ngayApDung" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayApDung");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayApDung").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayApDung" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayApDung");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayApDung").toString());
cons.add(con);
}
if(request.getParameter( "toNgayApDung" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayApDung");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayApDung").toString());
cons.add(con);
}

  if(request.getParameter( "ngayKhoa" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKhoa");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayKhoa").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayKhoa" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKhoa");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayKhoa").toString());
cons.add(con);
}
if(request.getParameter( "toNgayKhoa" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayKhoa");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayKhoa").toString());
cons.add(con);
}

  if(request.getParameter( "khoaYN" ) != null && Boolean.parseBoolean(request.getParameter("khoaYN"))){
MyFilter con = new MyFilter();
con.setCol("khoaYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("khoaYN").toString()));
cons.add(con);
}

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

  try{
if(request.getParameter( "loaiChungChiId" ) != null){
Tbl_QLDT_DM_LoaiChungChi obj =
new ObjectMapper().readValue(
request.getParameter("loaiChungChiId")
, Tbl_QLDT_DM_LoaiChungChi.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("loaiChungChiId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "diemDat" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemDat");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diemDat").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiemDat" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemDat");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiemDat").toString()));
cons.add(con);
}
if(request.getParameter( "toDiemDat" ) != null){
MyFilter con = new MyFilter();
con.setCol("diemDat");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiemDat").toString()));
cons.add(con);
}
  try{
if(request.getParameter( "heDaoTaoId" ) != null){
Tbl_QLDT_CTDT_HeDaoTao obj =
new ObjectMapper().readValue(
request.getParameter("heDaoTaoId")
, Tbl_QLDT_CTDT_HeDaoTao.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("heDaoTaoId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "nganhId" ) != null){
Tbl_QLDT_CTDT_Nganh obj =
new ObjectMapper().readValue(
request.getParameter("nganhId")
, Tbl_QLDT_CTDT_Nganh.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("nganhId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
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