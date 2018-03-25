


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
import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_HocVien_CoSo;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_DKMH_HocVien_CoSoController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_dkmh_hocvien_coso", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_CoSo .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_dkmh_hocvien_coso/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_coso", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DKMH_HocVien_CoSo .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_dkmh_hocvien_coso/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_coso", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_DKMH_HocVien_CoSo obj = (Tbl_QLDT_DKMH_HocVien_CoSo) genericDAO.get(Tbl_QLDT_DKMH_HocVien_CoSo .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_hocvien_coso", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_DKMH_HocVien_CoSo obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_coso", "them")){
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
@RequestMapping(value="/tbl_qldt_dkmh_hocvien_coso/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_coso", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_DKMH_HocVien_CoSo .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_hocvien_coso", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_DKMH_HocVien_CoSo obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_coso", "sua")){
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
@RequestMapping(value="/tbl_qldt_dkmh_hocvien_coso/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_hocvien_coso", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_DKMH_HocVien_CoSo .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "hocKyId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyId");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("hocKyId").toString()));
cons.add(con);
}
if(request.getParameter( "fromHocKyId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyId");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHocKyId").toString()));
cons.add(con);
}
if(request.getParameter( "toHocKyId" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocKyId");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHocKyId").toString()));
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

return cons;
}
//việt
}