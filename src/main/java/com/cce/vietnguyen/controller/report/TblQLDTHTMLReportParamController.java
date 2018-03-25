package com.cce.vietnguyen.controller.report;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.cce.vietnguyen.model.core.Tbl_HTMLReport_Param;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.GenericRepository;
import com.cce.vietnguyen.repository.MyFilter;

@RestController
public class TblQLDTHTMLReportParamController {

	
	@Autowired
	private GenericDao genericDAO;


	@RequestMapping(value="/tbl_qldt_htmlreport_param", method = RequestMethod.GET)
	public List getAll() {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");
			
			cons.add(con);
		}
		return genericDAO.findByCondition(Tbl_HTMLReport_Param.class, cons, 20, 1);
	}

	@RequestMapping(value="/tbl_qldt_htmlreport_param/find", method = RequestMethod.GET)
	public List find(@RequestParam(required = false) Integer pageSize
			,@RequestParam(required = false) Integer page
			,HttpServletRequest request) {
		
		List<MyFilter> cons = new ArrayList<MyFilter>();
		if(request.getParameter("ma") != null){
			MyFilter con = new MyFilter();
			con.setCol("ma");
			con.setOperator("like");
			con.setValue1("%" +(String)request.getParameter("ma") + "%");
			cons.add(con);
		}
		if(request.getParameter("ten") != null){
			MyFilter con = new MyFilter();
			con.setCol("ten");
			con.setOperator("like");
			con.setValue1("%" +(String)request.getParameter("ten") + "%");
			cons.add(con);
		}
		
		try {

			if(request.getParameter("reportId") != null){
				MyFilter con = new MyFilter();
				con.setCol("reportId.id");
				con.setOperator("eq");
				con.setValue1(new Long(request.getParameter("reportId").toString()));
				cons.add(con);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("stt");
			
			cons.add(con);
		}

		if(pageSize == null || pageSize == 0)
			pageSize = 20;
		else if(pageSize == -1){
			pageSize = 0;
		}
		
		if(page == 0)
			page = 1;		
		
		return genericDAO.findByCondition(Tbl_HTMLReport_Param.class, cons, pageSize, page);
	}

	@RequestMapping(value="/tbl_qldt_htmlreport_param/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {
		Tbl_HTMLReport_Param obj = (Tbl_HTMLReport_Param) genericDAO.get(Tbl_HTMLReport_Param.class, id);

		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value="/tbl_qldt_htmlreport_param", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_HTMLReport_Param obj) {
		
		Long id = genericDAO.save(obj);
		obj.setId(id);

		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value="/tbl_qldt_htmlreport_param/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCustomer(@PathVariable Long id) {
		
		genericDAO.delete(Tbl_HTMLReport_Param.class,id);
		
		return new ResponseEntity(id, HttpStatus.OK);

	}

	@RequestMapping(value="/tbl_qldt_htmlreport_param", method = RequestMethod.PUT)
	public ResponseEntity updateObj( @RequestBody Tbl_HTMLReport_Param obj) {
		
		genericDAO.saveOrUpdate(obj);
		
		return new ResponseEntity(obj, HttpStatus.OK);
	}

}