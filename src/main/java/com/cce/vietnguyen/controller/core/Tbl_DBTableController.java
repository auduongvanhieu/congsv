
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

import com.cce.vietnguyen.model.core.Tbl_DBTable;
import com.cce.vietnguyen.model.core.Tbl_Menu;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.MyFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_DBTableController {
	@Autowired
	private GenericDao genericDAO;

	@RequestMapping(value = "/tbl_dbtable", method = RequestMethod.GET)
	public List getAll() {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");
			cons.add(con);
		}
		return genericDAO.findByCondition(Tbl_DBTable.class, cons, 20, 1);
	}

	@RequestMapping(value = "/tbl_dbtable/find", method = RequestMethod.GET)
	public List find(@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) Integer page,
			HttpServletRequest request) {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		// variable
		try {
			if (request.getParameter("id") != null) {
				MyFilter con = new MyFilter();
				con.setCol("id");
				con.setOperator("eq");
				con.setValue1(new Long(request.getParameter("id").toString()));
				cons.add(con);
			}
		} catch (Exception e) {
		}
		if (request.getParameter("ten") != null) {
			MyFilter con = new MyFilter();
			con.setCol("ten");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("ten") + "%");
			cons.add(con);
		}
		if (request.getParameter("tenTV") != null) {
			MyFilter con = new MyFilter();
			con.setCol("tenTV");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("tenTV") + "%");
			cons.add(con);
		}

		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");
			cons.add(con);
		}
		if (pageSize == null || pageSize == 0)
			pageSize = 20;
		else if (pageSize == -1) {
			pageSize = 0;
		}
		if (page == 0)
			page = 1;
		return genericDAO.findByCondition(Tbl_DBTable.class, cons, pageSize, page);
	}

	@RequestMapping(value = "/tbl_dbtable/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {
		Tbl_DBTable obj = (Tbl_DBTable) genericDAO.get(Tbl_DBTable.class, id);
		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_dbtable", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_DBTable obj) {
		Long id = genericDAO.save(obj);
		obj.setId(id);
		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_dbtable/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteObj(@PathVariable Long id) {
		genericDAO.delete(Tbl_DBTable.class, id);
		return new ResponseEntity(id, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_dbtable", method = RequestMethod.PUT)
	public ResponseEntity updateObj(@RequestBody Tbl_DBTable obj) {
		genericDAO.saveOrUpdate(obj);
		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_dbtable/count", method = RequestMethod.GET)
	public Integer find(HttpServletRequest request) {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		// variable
		try {
			if (request.getParameter("id") != null) {
				MyFilter con = new MyFilter();
				con.setCol("id");
				con.setOperator("eq");
				con.setValue1(new Long(request.getParameter("id").toString()));
				cons.add(con);
			}
		} catch (Exception e) {
		}
		if (request.getParameter("ten") != null) {
			MyFilter con = new MyFilter();
			con.setCol("ten");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("ten") + "%");
			cons.add(con);
		}
		if (request.getParameter("tenTV") != null) {
			MyFilter con = new MyFilter();
			con.setCol("tenTV");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("tenTV") + "%");
			cons.add(con);
		}

		return genericDAO.countByCondition(Tbl_DBTable.class, cons);
	}
}