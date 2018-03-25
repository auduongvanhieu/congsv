


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
import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_KetQuaDK;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_QLHV_HocVien;
  import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_DotDK;
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHocDuKien;
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_CTDT_MonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_CoSo;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_DKMH_KetQuaDKController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_dkmh_ketquadk", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_DKMH_KetQuaDK .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_dkmh_ketquadk/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_ketquadk", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_DKMH_KetQuaDK .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_dkmh_ketquadk/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_ketquadk", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_DKMH_KetQuaDK obj = (Tbl_QLDT_DKMH_KetQuaDK) genericDAO.get(Tbl_QLDT_DKMH_KetQuaDK .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_ketquadk", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_DKMH_KetQuaDK obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_ketquadk", "them")){
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
@RequestMapping(value="/tbl_qldt_dkmh_ketquadk/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_ketquadk", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_DKMH_KetQuaDK .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_dkmh_ketquadk", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_DKMH_KetQuaDK obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_ketquadk", "sua")){
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
@RequestMapping(value="/tbl_qldt_dkmh_ketquadk/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_dkmh_ketquadk", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_DKMH_KetQuaDK .class, cons), HttpStatus.OK);
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
if(request.getParameter( "dotDKId" ) != null){
Tbl_QLDT_DKMH_DotDK obj =
new ObjectMapper().readValue(
request.getParameter("dotDKId")
, Tbl_QLDT_DKMH_DotDK.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("dotDKId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
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
  if(request.getParameter( "maDieuChinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("maDieuChinh");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("maDieuChinh") + "%");
cons.add(con);
}
  if(request.getParameter( "khoaMonHocYN" ) != null && Boolean.parseBoolean(request.getParameter("khoaMonHocYN"))){
MyFilter con = new MyFilter();
con.setCol("khoaMonHocYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("khoaMonHocYN").toString()));
cons.add(con);
}

  if(request.getParameter( "ketQua" ) != null){
MyFilter con = new MyFilter();
con.setCol("ketQua");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ketQua") + "%");
cons.add(con);
}
  if(request.getParameter( "ketQuaLyDo" ) != null){
MyFilter con = new MyFilter();
con.setCol("ketQuaLyDo");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ketQuaLyDo") + "%");
cons.add(con);
}
  if(request.getParameter( "xacNhanYN" ) != null && Boolean.parseBoolean(request.getParameter("xacNhanYN"))){
MyFilter con = new MyFilter();
con.setCol("xacNhanYN");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("xacNhanYN").toString()));
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

  if(request.getParameter( "hocPhi" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocPhi");
con.setOperator("eq");
con.setValue1(Double.parseDouble(request.getParameter("hocPhi").toString()));
cons.add(con);
}
if(request.getParameter( "fromHocPhi" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocPhi");
con.setOperator("ge");
con.setValue1(Double.parseDouble(request.getParameter("fromHocPhi").toString()));
cons.add(con);
}
if(request.getParameter( "toHocPhi" ) != null){
MyFilter con = new MyFilter();
con.setCol("hocPhi");
con.setOperator("le");
con.setValue1(Double.parseDouble(request.getParameter("toHocPhi").toString()));
cons.add(con);
}
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
  if(request.getParameter( "ketQuaTKB" ) != null){
MyFilter con = new MyFilter();
con.setCol("ketQuaTKB");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ketQuaTKB") + "%");
cons.add(con);
}
  if(request.getParameter( "ketQuaLyDoTKB" ) != null){
MyFilter con = new MyFilter();
con.setCol("ketQuaLyDoTKB");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("ketQuaLyDoTKB") + "%");
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

return cons;
}
//việt
}