package com.cce.vietnguyen.controller.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cce.vietnguyen.model.core.Tbl_HTMLReport;
import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.GenericRepository;
import com.cce.vietnguyen.repository.MyFilter;

@RestController
public class TblQLDTHTMLReportController {

	@Autowired
	private GenericDao genericDAO;
	
	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping(value = "/tbl_qldt_htmlreport", method = RequestMethod.GET)
	public List getAll(@AuthenticationPrincipal Tbl_TaiKhoan user) {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");

			cons.add(con);
		}
		return genericDAO.findByCondition(Tbl_HTMLReport.class, cons, 20, 1);
	}

	@RequestMapping(value = "/tbl_qldt_htmlreport/find", method = RequestMethod.GET)
	public List find(@AuthenticationPrincipal Tbl_TaiKhoan user
			, @RequestParam(required = false) Integer pageSize
			, @RequestParam(required = false) Integer page
			, HttpServletRequest request) {

		
		try {

			List<MyFilter> cons = new ArrayList<MyFilter>();
			if (request.getParameter("ma") != null) {
				MyFilter con = new MyFilter();
				con.setCol("ma");
				con.setOperator("like");
				con.setValue1("%" + (String) request.getParameter("ma") + "%");
				cons.add(con);
			}
			if (request.getParameter("ten") != null) {
				MyFilter con = new MyFilter();
				con.setCol("ten");
				con.setOperator("like");
				con.setValue1("%" + (String) request.getParameter("ten") + "%");
				cons.add(con);
			}

			try {

				if (request.getParameter("type") != null) {
					MyFilter con = new MyFilter();
					con.setCol("type");
					con.setOperator("eq");
					con.setValue1(request.getParameter("type"));
					cons.add(con);
				}
			} catch (Exception e) {
				// TODO: handle exception
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

			return genericDAO.findByCondition(Tbl_HTMLReport.class, cons, pageSize, page);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return null;
		}
	}

	@RequestMapping(value = "/tbl_qldt_htmlreport/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {
		Tbl_HTMLReport obj = (Tbl_HTMLReport) genericDAO.get(Tbl_HTMLReport.class, id);

		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_qldt_htmlreport", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_HTMLReport obj) {
		System.out.println("ma quan ly: " + obj.getMa());
		Long id = genericDAO.save(obj);
		obj.setId(id);

		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_qldt_htmlreport/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		genericDAO.delete(Tbl_HTMLReport.class, id);

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@RequestMapping(value = "/tbl_qldt_htmlreport", method = RequestMethod.PUT)
	public ResponseEntity updateObj(@RequestBody Tbl_HTMLReport obj) {
		genericDAO.saveOrUpdate(obj);

		return new ResponseEntity(obj, HttpStatus.OK);
	}

}