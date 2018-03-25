


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
import com.cce.vietnguyen.model.Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLDiem_DonXinChuyenDiem;
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTietController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_qldiem_donxinchuyendiem_chitiet", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_qldiem_donxinchuyendiem_chitiet/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qldiem_donxinchuyendiem_chitiet", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_qldiem_donxinchuyendiem_chitiet/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qldiem_donxinchuyendiem_chitiet", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet obj = (Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet) genericDAO.get(Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qldiem_donxinchuyendiem_chitiet", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qldiem_donxinchuyendiem_chitiet", "them")){
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
@RequestMapping(value="/tbl_qldt_qldiem_donxinchuyendiem_chitiet/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qldiem_donxinchuyendiem_chitiet", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_qldiem_donxinchuyendiem_chitiet", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qldiem_donxinchuyendiem_chitiet", "sua")){
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
@RequestMapping(value="/tbl_qldt_qldiem_donxinchuyendiem_chitiet/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_qldiem_donxinchuyendiem_chitiet", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_QLDiem_DonXinChuyenDiem_ChiTiet .class, cons), HttpStatus.OK);
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
if(request.getParameter( "donXinChuyenDiemId" ) != null){
Tbl_QLDT_QLDiem_DonXinChuyenDiem obj =
new ObjectMapper().readValue(
request.getParameter("donXinChuyenDiemId")
, Tbl_QLDT_QLDiem_DonXinChuyenDiem.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("donXinChuyenDiemId.id");
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
  if(request.getParameter( "chapNhanYN" ) != null && Boolean.parseBoolean(request.getParameter("chapNhanYN"))){
MyFilter con = new MyFilter();
con.setCol("chapNhanYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("chapNhanYN").toString()));
cons.add(con);
}

  if(request.getParameter( "lyDo" ) != null){
MyFilter con = new MyFilter();
con.setCol("lyDo");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("lyDo") + "%");
cons.add(con);
}
  if(request.getParameter( "diem" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("diem").toString()));
cons.add(con);
}
if(request.getParameter( "fromDiem" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDiem").toString()));
cons.add(con);
}
if(request.getParameter( "toDiem" ) != null){
MyFilter con = new MyFilter();
con.setCol("diem");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDiem").toString()));
cons.add(con);
}

return cons;
}
//việt
}