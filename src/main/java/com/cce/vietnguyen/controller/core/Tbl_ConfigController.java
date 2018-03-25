


package com.cce.vietnguyen.controller.core;
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

import com.cce.vietnguyen.model.core.Tbl_Config;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.MyFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
 
 
 
 
 

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_ConfigController {
@Autowired
private GenericDao genericDAO;
@RequestMapping(value="/tbl_config", method = RequestMethod.GET)
public List getAll() {
List<MyFilter> cons = new ArrayList<MyFilter>();
{
MyFilter con = new MyFilter();
con.setOperator("order");
con.setValue1("desc");
con.setCol("id");
cons.add(con);
}
return genericDAO.findByCondition(Tbl_Config .class, cons, 20, 1);
}
@RequestMapping(value="/tbl_config/find", method = RequestMethod.GET)
public List find(@RequestParam(required = false) Integer pageSize
,@RequestParam(required = false) Integer page
,HttpServletRequest request) {
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
  if(request.getParameter( "code" ) != null){
MyFilter con = new MyFilter();
con.setCol("code");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("code") + "%");
cons.add(con);
}
  if(request.getParameter( "name" ) != null){
MyFilter con = new MyFilter();
con.setCol("name");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("name") + "%");
cons.add(con);
}
  if(request.getParameter( "val" ) != null){
MyFilter con = new MyFilter();
con.setCol("val");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("val") + "%");
cons.add(con);
}
  if(request.getParameter( "note" ) != null){
MyFilter con = new MyFilter();
con.setCol("note");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("note") + "%");
cons.add(con);
}

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
return genericDAO.findByCondition(Tbl_Config .class, cons, pageSize, page);
}
@RequestMapping(value="/tbl_config/{id}", method = RequestMethod.GET)
public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {
Tbl_Config obj = (Tbl_Config) genericDAO.get(Tbl_Config .class, id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_config", method = RequestMethod.POST)
public ResponseEntity createObj(@RequestBody Tbl_Config obj) {
Long id = genericDAO.save(obj);
obj.setId(id);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_config/{id}", method = RequestMethod.DELETE)
public ResponseEntity deleteObj(@PathVariable Long id) {
genericDAO.delete(Tbl_Config .class,id);
return new ResponseEntity(id, HttpStatus.OK);
}
@RequestMapping(value="/tbl_config", method = RequestMethod.PUT)
public ResponseEntity updateObj( @RequestBody Tbl_Config obj) {
genericDAO.saveOrUpdate(obj);
return new ResponseEntity(obj, HttpStatus.OK);
}
@RequestMapping(value="/tbl_config/count", method = RequestMethod.GET)
public Integer count(HttpServletRequest request) {
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
  if(request.getParameter( "code" ) != null){
MyFilter con = new MyFilter();
con.setCol("code");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("code") + "%");
cons.add(con);
}
  if(request.getParameter( "name" ) != null){
MyFilter con = new MyFilter();
con.setCol("name");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("name") + "%");
cons.add(con);
}
  if(request.getParameter( "val" ) != null){
MyFilter con = new MyFilter();
con.setCol("val");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("val") + "%");
cons.add(con);
}
  if(request.getParameter( "note" ) != null){
MyFilter con = new MyFilter();
con.setCol("note");
con.setOperator("like");
con.setValue1("%" +(String)request.getParameter("note") + "%");
cons.add(con);
}

return genericDAO.countByCondition(Tbl_Config .class, cons);
}
//việt
}