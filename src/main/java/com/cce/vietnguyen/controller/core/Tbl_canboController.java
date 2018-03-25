
package com.cce.vietnguyen.controller.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.cce.vietnguyen.model.core.Tbl_CanBo;
import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_canboController {
	@Autowired
	private GenericDao genericDAO;
	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping(value = "/tbl_canbo", method = RequestMethod.GET)
	public List getAll() {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");
			cons.add(con);
		}
		return genericDAO.findByCondition(Tbl_CanBo.class, cons, 20, 1);
	}

	@RequestMapping(value = "/tbl_canbo/find", method = RequestMethod.GET)
	public ResponseEntity find(@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page, HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_canbo", "xem")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}

		try {
			List<MyFilter> cons = new ArrayList<MyFilter>();
			cons = buildFilter(request);
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
			return new ResponseEntity(genericDAO.findByCondition(Tbl_CanBo.class, cons, pageSize, page), HttpStatus.OK);
		} catch (

		Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/tbl_canbo/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_canbo", "xem")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		Tbl_CanBo obj = (Tbl_CanBo) genericDAO.get(Tbl_CanBo.class, id);
		return new ResponseEntity(obj, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_canbo", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_CanBo obj, @AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_canbo", "them")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			Long id = genericDAO.save(obj);
			obj.setId(id);
			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			System.out.println("object already exist");
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/tbl_canbo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteObj(@PathVariable Long id, @AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_canbo", "xoa")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		genericDAO.delete(Tbl_CanBo.class, id);
		return new ResponseEntity(id, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_canbo", method = RequestMethod.PUT)
	public ResponseEntity updateObj(@RequestBody Tbl_CanBo obj, @AuthenticationPrincipal Tbl_TaiKhoan user) {

		if (!user.getCanBoId().getId().equals(obj.getId())) {
			if (!genericRepository.checkRight(user, "tbl_canbo", "sua")) {
				return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
			}
		}
		try {
			genericDAO.saveOrUpdate(obj);
			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			System.out.println("object already exist");
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/tbl_canbo/count", method = RequestMethod.GET)
	public ResponseEntity count(HttpServletRequest request, @AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_canbo", "xem")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		List<MyFilter> cons = new ArrayList<MyFilter>();
		cons = buildFilter(request);
		return new ResponseEntity(genericDAO.countByCondition(Tbl_CanBo.class, cons), HttpStatus.OK);
	}

	private List<MyFilter> buildFilter(HttpServletRequest request) {

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
		if (request.getParameter("maQuanLy") != null) {
			MyFilter con = new MyFilter();
			con.setCol("maQuanLy");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("maQuanLy") + "%");
			cons.add(con);
		}
		if (request.getParameter("ten") != null) {
			MyFilter con = new MyFilter();
			con.setCol("ten");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("ten") + "%");
			cons.add(con);
		}
		if (request.getParameter("ngaySinh") != null) {
			MyFilter con = new MyFilter();
			con.setCol("ngaySinh");
			con.setType("Date");
			con.setOperator("eq");
			con.setValue1(request.getParameter("ngaySinh").toString());
			cons.add(con);
		}

		if (request.getParameter("noiSinh") != null) {
			MyFilter con = new MyFilter();
			con.setCol("noiSinh");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("noiSinh") + "%");
			cons.add(con);
		}
		if (request.getParameter("diaChi") != null) {
			MyFilter con = new MyFilter();
			con.setCol("diaChi");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("diaChi") + "%");
			cons.add(con);
		}
		if (request.getParameter("dienThoai") != null) {
			MyFilter con = new MyFilter();
			con.setCol("dienThoai");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("dienThoai") + "%");
			cons.add(con);
		}
		if (request.getParameter("ghiChu") != null) {
			MyFilter con = new MyFilter();
			con.setCol("ghiChu");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("ghiChu") + "%");
			cons.add(con);
		}
		if (request.getParameter("ngheNghiep") != null) {
			MyFilter con = new MyFilter();
			con.setCol("ngheNghiep");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("ngheNghiep") + "%");
			cons.add(con);
		}
		if (request.getParameter("noiLam") != null) {
			MyFilter con = new MyFilter();
			con.setCol("noiLam");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("noiLam") + "%");
			cons.add(con);
		}
		if (request.getParameter("trinhDo") != null) {
			MyFilter con = new MyFilter();
			con.setCol("trinhDo");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("trinhDo") + "%");
			cons.add(con);
		}
		if (request.getParameter("ma") != null) {
			MyFilter con = new MyFilter();
			con.setCol("ma");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("ma") + "%");
			cons.add(con);
		}

		return cons;
	}
	// việt
}