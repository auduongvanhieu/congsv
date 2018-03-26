


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
import com.cce.vietnguyen.model.Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TietHoc;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TKB_LopMonHoc;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Phong;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_NgayTrongTuan;
  import com.cce.vietnguyen.model.Tbl_QLDT_HocKyTrongNam;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TKB_ThoiKhoaBieuChinhThucController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_tkb_thoikhoabieuchinhthuc", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_tkb_thoikhoabieuchinhthuc/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_thoikhoabieuchinhthuc", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_tkb_thoikhoabieuchinhthuc/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
    //advh
//if(!genericRepository.checkRight(user, "tbl_qldt_tkb_thoikhoabieuchinhthuc", "xem")){
//return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//}
Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc obj = (Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc) genericDAO.get(Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_thoikhoabieuchinhthuc", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_thoikhoabieuchinhthuc", "them")){
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
@RequestMapping(value="/tbl_qldt_tkb_thoikhoabieuchinhthuc/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_thoikhoabieuchinhthuc", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_tkb_thoikhoabieuchinhthuc", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_thoikhoabieuchinhthuc", "sua")){
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
@RequestMapping(value="/tbl_qldt_tkb_thoikhoabieuchinhthuc/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_tkb_thoikhoabieuchinhthuc", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TKB_ThoiKhoaBieuChinhThuc .class, cons), HttpStatus.OK);
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
if(request.getParameter( "tietHocId" ) != null){
Tbl_QLDT_DM_TietHoc obj =
new ObjectMapper().readValue(
request.getParameter("tietHocId")
, Tbl_QLDT_DM_TietHoc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("tietHocId.id");
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
  try{
if(request.getParameter( "lopMonHocId" ) != null){
Tbl_QLDT_TKB_LopMonHoc obj =
new ObjectMapper().readValue(
request.getParameter("lopMonHocId")
, Tbl_QLDT_TKB_LopMonHoc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("lopMonHocId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "phongId" ) != null){
Tbl_QLDT_DM_Phong obj =
new ObjectMapper().readValue(
request.getParameter("phongId")
, Tbl_QLDT_DM_Phong.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("phongId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "ngayId" ) != null){
Tbl_QLDT_DM_NgayTrongTuan obj =
new ObjectMapper().readValue(
request.getParameter("ngayId")
, Tbl_QLDT_DM_NgayTrongTuan.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("ngayId.id");
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
  if(request.getParameter( "tuanHocStr" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanHocStr");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("tuanHocStr") + "%");
cons.add(con);
}
  if(request.getParameter( "tuanHocBinStr" ) != null){
MyFilter con = new MyFilter();
con.setCol("tuanHocBinStr");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("tuanHocBinStr") + "%");
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


return cons;
}
//việt
}