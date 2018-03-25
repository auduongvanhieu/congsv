
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

import com.cce.vietnguyen.model.core.Tbl_Option;
import com.cce.vietnguyen.model.core.Tbl_OptionGroup;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.MyFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_OptionController {
	@Autowired
	private GenericDao genericDAO;

	@RequestMapping(value = "/tbl_option", method = RequestMethod.GET)
	public List getAll() {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");
			cons.add(con);
		}
		return genericDAO.findByCondition(Tbl_Option.class, cons, 20, 1);
	}

	@RequestMapping(value = "/tbl_option/find", method = RequestMethod.GET)
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
		if (request.getParameter("code") != null) {
			MyFilter con = new MyFilter();
			con.setCol("code");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("code") + "%");
			cons.add(con);
		}
		if (request.getParameter("name") != null) {
			MyFilter con = new MyFilter();
			con.setCol("name");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("name") + "%");
			cons.add(con);
		}
		try {
			if (request.getParameter("optionGroupId") != null) {
				Tbl_OptionGroup obj = new ObjectMapper().readValue(request.getParameter("optionGroupId"),
						Tbl_OptionGroup.class);
				if (obj.getId() != null && !obj.getId().equals(new Long(0))) {
					MyFilter con = new MyFilter();
					con.setCol("optionGroupId.id");
					con.setOperator("eq");
					con.setValue1(obj.getId());
					cons.add(con);
				}else if(obj.getCode() != null && !obj.getCode().equals("")){
					MyFilter con = new MyFilter();
					con.setCol("optionGroupId.code");
					con.setOperator("eq");
					con.setValue1(obj.getCode());
					cons.add(con);
				}
			}
		} catch (Exception e) {
		}
		try {

			if (request.getParameter("optionGroupId_Code") != null) {
				MyFilter con = new MyFilter();
				con.setCol("optionGroupId.code");
				con.setOperator("eq");
				con.setValue1(request.getParameter("optionGroupId_Code").toString());
				cons.add(con);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (request.getParameter("val") != null) {
			MyFilter con = new MyFilter();
			con.setCol("val");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("val") + "%");
			cons.add(con);
		}
		if (request.getParameter("factor") != null) {
			MyFilter con = new MyFilter();
			con.setCol("factor");
			con.setOperator("eq");
			con.setValue1(Double.parseDouble(request.getParameter("factor").toString()));
			cons.add(con);
		}
		try {
			if (request.getParameter("parentId") != null) {
				Tbl_Option obj = new ObjectMapper().readValue(request.getParameter("parentId"), Tbl_Option.class);
				if (obj.getId() != null && !obj.getId().equals(new Long(0))) {
					MyFilter con = new MyFilter();
					con.setCol("parentId.id");
					con.setOperator("eq");
					con.setValue1(obj.getId());
					cons.add(con);
				}
			}
		} catch (Exception e) {
		}
		if (request.getParameter("lvl") != null) {
			MyFilter con = new MyFilter();
			con.setCol("lvl");
			con.setOperator("eq");
			con.setValue1(Integer.parseInt(request.getParameter("lvl").toString()));
			cons.add(con);
		}
		if (request.getParameter("orderNo") != null) {
			MyFilter con = new MyFilter();
			con.setCol("orderNo");
			con.setOperator("eq");
			con.setValue1(Integer.parseInt(request.getParameter("orderNo").toString()));
			cons.add(con);
		}

		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("asc");
			con.setCol("orderNo");
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
		return genericDAO.findByCondition(Tbl_Option.class, cons, pageSize, page);
	}

	@RequestMapping(value = "/tbl_option/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {
		Tbl_Option obj = (Tbl_Option) genericDAO.get(Tbl_Option.class, id);
		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_option", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_Option obj) {
		Long id = genericDAO.save(obj);
		obj.setId(id);
		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_option/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteObj(@PathVariable Long id) {
		genericDAO.delete(Tbl_Option.class, id);
		return new ResponseEntity(id, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_option", method = RequestMethod.PUT)
	public ResponseEntity updateObj(@RequestBody Tbl_Option obj) {
		genericDAO.saveOrUpdate(obj);
		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_option/count", method = RequestMethod.GET)
	public Integer count(HttpServletRequest request) {
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
		if (request.getParameter("code") != null) {
			MyFilter con = new MyFilter();
			con.setCol("code");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("code") + "%");
			cons.add(con);
		}
		if (request.getParameter("name") != null) {
			MyFilter con = new MyFilter();
			con.setCol("name");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("name") + "%");
			cons.add(con);
		}
		try {
			if (request.getParameter("optionGroupId") != null) {
				Tbl_OptionGroup obj = new ObjectMapper().readValue(request.getParameter("optionGroupId"),
						Tbl_OptionGroup.class);
				if (obj.getId() != null && !obj.getId().equals(new Long(0))) {
					MyFilter con = new MyFilter();
					con.setCol("optionGroupId.id");
					con.setOperator("eq");
					con.setValue1(obj.getId());
					cons.add(con);
				}
			}
		} catch (Exception e) {
		}
		if (request.getParameter("val") != null) {
			MyFilter con = new MyFilter();
			con.setCol("val");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("val") + "%");
			cons.add(con);
		}
		try {
			if (request.getParameter("parentId") != null) {
				Tbl_Option obj = new ObjectMapper().readValue(request.getParameter("parentId"), Tbl_Option.class);
				if (obj.getId() != null && !obj.getId().equals(new Long(0))) {
					MyFilter con = new MyFilter();
					con.setCol("parentId.id");
					con.setOperator("eq");
					con.setValue1(obj.getId());
					cons.add(con);
				}
			}
		} catch (Exception e) {
		}
		if (request.getParameter("lvl") != null) {
			MyFilter con = new MyFilter();
			con.setCol("lvl");
			con.setOperator("eq");
			con.setValue1(request.getParameter("lvl"));
			cons.add(con);
		}
		if (request.getParameter("orderNo") != null) {
			MyFilter con = new MyFilter();
			con.setCol("orderNo");
			con.setOperator("eq");
			con.setValue1(request.getParameter("orderNo"));
			cons.add(con);
		}

		return genericDAO.countByCondition(Tbl_Option.class, cons);
	}
	// việt
}