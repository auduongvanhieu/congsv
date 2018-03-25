


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
import com.cce.vietnguyen.model.Tbl_qldt_ts_quydinhxettuyen;
 
 
  import com.cce.vietnguyen.model.Tbl_qldt_ts_dm_hanhkiem;
  import com.cce.vietnguyen.model.Tbl_qldt_ts_khoituyensinh;
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_qldt_ts_quydinhxettuyenController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_ts_quydinhxettuyen", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_qldt_ts_quydinhxettuyen .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_ts_quydinhxettuyen/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_quydinhxettuyen", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_qldt_ts_quydinhxettuyen .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_ts_quydinhxettuyen/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_quydinhxettuyen", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_qldt_ts_quydinhxettuyen obj = (Tbl_qldt_ts_quydinhxettuyen) genericDAO.get(Tbl_qldt_ts_quydinhxettuyen .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_quydinhxettuyen", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_qldt_ts_quydinhxettuyen obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_quydinhxettuyen", "them")){
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
@RequestMapping(value="/tbl_qldt_ts_quydinhxettuyen/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_quydinhxettuyen", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_qldt_ts_quydinhxettuyen .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_quydinhxettuyen", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_qldt_ts_quydinhxettuyen obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_quydinhxettuyen", "sua")){
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
@RequestMapping(value="/tbl_qldt_ts_quydinhxettuyen/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_quydinhxettuyen", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_qldt_ts_quydinhxettuyen .class, cons), HttpStatus.OK);
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
if(request.getParameter( "hanhKiemId" ) != null){
Tbl_qldt_ts_dm_hanhkiem obj =
new ObjectMapper().readValue(
request.getParameter("hanhKiemId")
, Tbl_qldt_ts_dm_hanhkiem.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("hanhKiemId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "khoiTuyenSinhId" ) != null){
Tbl_qldt_ts_khoituyensinh obj =
new ObjectMapper().readValue(
request.getParameter("khoiTuyenSinhId")
, Tbl_qldt_ts_khoituyensinh.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("khoiTuyenSinhId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "nganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("nganhId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("nganhId").toString()));
cons.add(con);
}
if(request.getParameter( "fromNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("nganhId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "toNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("nganhId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toNganhId").toString()));
cons.add(con);
}

return cons;
}
//việt
}