


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
import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_QuyDinhDKCoSo;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_DKMH_QuyDinhDKCoSoController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_dkmh_quydinhdkcoso", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_DKMH_QuyDinhDKCoSo .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_dkmh_quydinhdkcoso/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_quydinhdkcoso", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DKMH_QuyDinhDKCoSo .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_dkmh_quydinhdkcoso/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_quydinhdkcoso", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_DKMH_QuyDinhDKCoSo obj = (Tbl_QLDT_DKMH_QuyDinhDKCoSo) genericDAO.get(Tbl_QLDT_DKMH_QuyDinhDKCoSo .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_quydinhdkcoso", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_DKMH_QuyDinhDKCoSo obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_quydinhdkcoso", "them")){
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
@RequestMapping(value="/tbl_qldt_dkmh_quydinhdkcoso/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_quydinhdkcoso", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_DKMH_QuyDinhDKCoSo .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_quydinhdkcoso", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_DKMH_QuyDinhDKCoSo obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_quydinhdkcoso", "sua")){
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
@RequestMapping(value="/tbl_qldt_dkmh_quydinhdkcoso/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_quydinhdkcoso", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_DKMH_QuyDinhDKCoSo .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "duocDK" ) != null){
MyFilter con = new MyFilter();
con.setCol("duocDK");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("duocDK").toString()));
cons.add(con);
}
if(request.getParameter( "fromDuocDK" ) != null){
MyFilter con = new MyFilter();
con.setCol("duocDK");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromDuocDK").toString()));
cons.add(con);
}
if(request.getParameter( "toDuocDK" ) != null){
MyFilter con = new MyFilter();
con.setCol("duocDK");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toDuocDK").toString()));
cons.add(con);
}
  if(request.getParameter( "chuyenNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("chuyenNganhId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("chuyenNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "fromChuyenNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("chuyenNganhId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromChuyenNganhId").toString()));
cons.add(con);
}
if(request.getParameter( "toChuyenNganhId" ) != null){
MyFilter con = new MyFilter();
con.setCol("chuyenNganhId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toChuyenNganhId").toString()));
cons.add(con);
}

return cons;
}
//việt
}