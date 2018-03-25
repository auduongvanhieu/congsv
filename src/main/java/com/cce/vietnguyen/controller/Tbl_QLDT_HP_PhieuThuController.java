


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
import com.cce.vietnguyen.model.Tbl_QLDT_HP_PhieuThu;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
 

  import com.cce.vietnguyen.model.core.Tbl_CanBo;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_HP_PhieuThuController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_hp_phieuthu", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_HP_PhieuThu .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_hp_phieuthu/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_phieuthu", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_HP_PhieuThu .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_hp_phieuthu/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_phieuthu", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_HP_PhieuThu obj = (Tbl_QLDT_HP_PhieuThu) genericDAO.get(Tbl_QLDT_HP_PhieuThu .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_hp_phieuthu", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_HP_PhieuThu obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_phieuthu", "them")){
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
@RequestMapping(value="/tbl_qldt_hp_phieuthu/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_phieuthu", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_HP_PhieuThu .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_hp_phieuthu", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_HP_PhieuThu obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_phieuthu", "sua")){
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
@RequestMapping(value="/tbl_qldt_hp_phieuthu/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_hp_phieuthu", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_HP_PhieuThu .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "soTien" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTien");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("soTien").toString()));
cons.add(con);
}
if(request.getParameter( "fromSoTien" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTien");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromSoTien").toString()));
cons.add(con);
}
if(request.getParameter( "toSoTien" ) != null){
MyFilter con = new MyFilter();
con.setCol("soTien");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toSoTien").toString()));
cons.add(con);
}
  if(request.getParameter( "duDauKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("duDauKy");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("duDauKy").toString()));
cons.add(con);
}
if(request.getParameter( "fromDuDauKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("duDauKy");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromDuDauKy").toString()));
cons.add(con);
}
if(request.getParameter( "toDuDauKy" ) != null){
MyFilter con = new MyFilter();
con.setCol("duDauKy");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toDuDauKy").toString()));
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
  if(request.getParameter( "ghiChu" ) != null){
MyFilter con = new MyFilter();
con.setCol("ghiChu");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ghiChu") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayNop" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayNop");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayNop").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayNop" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayNop");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayNop").toString());
cons.add(con);
}
if(request.getParameter( "toNgayNop" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayNop");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayNop").toString());
cons.add(con);
}

  if(request.getParameter( "loaiPT" ) != null){
MyFilter con = new MyFilter();
con.setCol("loaiPT");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("loaiPT").toString()));
cons.add(con);
}
if(request.getParameter( "fromLoaiPT" ) != null){
MyFilter con = new MyFilter();
con.setCol("loaiPT");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromLoaiPT").toString()));
cons.add(con);
}
if(request.getParameter( "toLoaiPT" ) != null){
MyFilter con = new MyFilter();
con.setCol("loaiPT");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toLoaiPT").toString()));
cons.add(con);
}
  if(request.getParameter( "soBienLai" ) != null){
MyFilter con = new MyFilter();
con.setCol("soBienLai");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("soBienLai") + "%");
cons.add(con);
}
  if(request.getParameter( "soQuyen" ) != null){
MyFilter con = new MyFilter();
con.setCol("soQuyen");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("soQuyen") + "%");
cons.add(con);
}

return cons;
}
//việt
}