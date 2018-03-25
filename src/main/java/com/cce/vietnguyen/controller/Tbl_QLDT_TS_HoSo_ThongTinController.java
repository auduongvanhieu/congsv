


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
import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSo_ThongTin;
 
 
 
 
 
 
 
 
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_DanToc;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TonGiao;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_TruongTHPT;
  import com.cce.vietnguyen.model.Tbl_QLDT_DM_Huyen;
 
  import com.cce.vietnguyen.model.Tbl_QLDT_TS_HoSoXetTuyen;
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_QLDT_TS_HoSo_ThongTinController {
@Autowired
private GenericDao genericDAO;
@Autowired
private GenericRepository genericRepository;
@RequestMapping(value="/tbl_qldt_ts_hoso_thongtin", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_QLDT_TS_HoSo_ThongTin .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_thongtin/find", method = RequestMethod.GET)
public ResponseEntity find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_thongtin", "xem")){
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
return new ResponseEntity(genericDAO.findByCondition(Tbl_QLDT_TS_HoSo_ThongTin .class, cons, pageSize, page), HttpStatus.OK);
}catch(Exception e){
e.printStackTrace();
return new ResponseEntity(HttpStatus.BAD_REQUEST);
}
}
@RequestMapping(value="/tbl_qldt_ts_hoso_thongtin/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_thongtin", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
Tbl_QLDT_TS_HoSo_ThongTin obj = (Tbl_QLDT_TS_HoSo_ThongTin) genericDAO.get(Tbl_QLDT_TS_HoSo_ThongTin .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_thongtin", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_QLDT_TS_HoSo_ThongTin obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_thongtin", "them")){
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
@RequestMapping(value="/tbl_qldt_ts_hoso_thongtin/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_thongtin", "xoa")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
genericDAO.delete(Tbl_QLDT_TS_HoSo_ThongTin .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_qldt_ts_hoso_thongtin", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_QLDT_TS_HoSo_ThongTin obj
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_thongtin", "sua")){
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
@RequestMapping(value="/tbl_qldt_ts_hoso_thongtin/count", method = RequestMethod.GET)
public ResponseEntity count(HttpServletRequest request
,@AuthenticationPrincipal Tbl_TaiKhoan user) {
if(!genericRepository.checkRight(user, "tbl_qldt_ts_hoso_thongtin", "xem")){
return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
}
List<MyFilter> cons = new ArrayList<MyFilter>();
cons = buildFilter(request);
return new ResponseEntity(genericDAO.countByCondition(Tbl_QLDT_TS_HoSo_ThongTin .class, cons), HttpStatus.OK);
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
  if(request.getParameter( "diaChiLienLac" ) != null){
MyFilter con = new MyFilter();
con.setCol("diaChiLienLac");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("diaChiLienLac") + "%");
cons.add(con);
}
  if(request.getParameter( "ngaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngaySinh").toString());
cons.add(con);
}
if(request.getParameter( "fromNgaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgaySinh").toString());
cons.add(con);
}
if(request.getParameter( "toNgaySinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngaySinh");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgaySinh").toString());
cons.add(con);
}

  if(request.getParameter( "noiSinh" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiSinh");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiSinh") + "%");
cons.add(con);
}
  if(request.getParameter( "gioiTinh" ) != null && Boolean.parseBoolean(request.getParameter("gioiTinh"))){
MyFilter con = new MyFilter();
con.setCol("gioiTinh");
con.setOperator("eq");
con.setValue1(Boolean.parseBoolean(request.getParameter("gioiTinh").toString()));
cons.add(con);
}

  if(request.getParameter( "cmnd" ) != null){
MyFilter con = new MyFilter();
con.setCol("cmnd");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("cmnd") + "%");
cons.add(con);
}
  if(request.getParameter( "ngayCap" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCap");
con.setType("Date");
con.setOperator("eq");
con.setValue1(request.getParameter("ngayCap").toString());
cons.add(con);
}
if(request.getParameter( "fromNgayCap" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCap");
con.setType("Date");
con.setOperator("ge");
con.setValue1(request.getParameter("fromNgayCap").toString());
cons.add(con);
}
if(request.getParameter( "toNgayCap" ) != null){
MyFilter con = new MyFilter();
con.setCol("ngayCap");
con.setType("Date");
con.setOperator("le");
con.setValue1(request.getParameter("toNgayCap").toString());
cons.add(con);
}

  if(request.getParameter( "noiCap" ) != null){
MyFilter con = new MyFilter();
con.setCol("noiCap");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("noiCap") + "%");
cons.add(con);
}
  try{
if(request.getParameter( "danTocId" ) != null){
Tbl_QLDT_DM_DanToc obj =
new ObjectMapper().readValue(
request.getParameter("danTocId")
, Tbl_QLDT_DM_DanToc.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("danTocId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "tonGiaoId" ) != null){
Tbl_QLDT_DM_TonGiao obj =
new ObjectMapper().readValue(
request.getParameter("tonGiaoId")
, Tbl_QLDT_DM_TonGiao.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("tonGiaoId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "truongTHPTId" ) != null){
Tbl_QLDT_DM_TruongTHPT obj =
new ObjectMapper().readValue(
request.getParameter("truongTHPTId")
, Tbl_QLDT_DM_TruongTHPT.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("truongTHPTId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  try{
if(request.getParameter( "huyenId" ) != null){
Tbl_QLDT_DM_Huyen obj =
new ObjectMapper().readValue(
request.getParameter("huyenId")
, Tbl_QLDT_DM_Huyen.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("huyenId.id");
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
  try{
if(request.getParameter( "hoSoId" ) != null){
Tbl_QLDT_TS_HoSoXetTuyen obj =
new ObjectMapper().readValue(
request.getParameter("hoSoId")
, Tbl_QLDT_TS_HoSoXetTuyen.class
);
if(obj.getId() != null && !obj.getId().equals(new Long(0))){
MyFilter con = new MyFilter();
con.setCol("hoSoId.id");
con.setOperator("eq");
con.setValue1(obj.getId());
cons.add(con);
}
}
}catch(Exception e){}
  if(request.getParameter( "namTN" ) != null){
MyFilter con = new MyFilter();
con.setCol("namTN");
con.setOperator("eq");
con.setValue1(Integer.parseInt(request.getParameter("namTN").toString()));
cons.add(con);
}
if(request.getParameter( "fromNamTN" ) != null){
MyFilter con = new MyFilter();
con.setCol("namTN");
con.setOperator("ge");
con.setValue1(Integer.parseInt(request.getParameter("fromNamTN").toString()));
cons.add(con);
}
if(request.getParameter( "toNamTN" ) != null){
MyFilter con = new MyFilter();
con.setCol("namTN");
con.setOperator("le");
con.setValue1(Integer.parseInt(request.getParameter("toNamTN").toString()));
cons.add(con);
}

return cons;
}
//việt
}