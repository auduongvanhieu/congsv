package com.cce.vietnguyen.controller.core;

import java.security.Principal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cce.vietnguyen.model.core.Tbl_Menu;
import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.MyFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Tbl_MenuController {

	@Autowired
	private GenericDao genericDAO;

	@RequestMapping(value = "/tbl_menu", method = RequestMethod.GET)
	public List getAll() {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("asc");
			con.setCol("nhom");

			cons.add(con);
		}
		//
		return genericDAO.findByCondition(Tbl_Menu.class, cons, 20, 1);
	}
	@RequestMapping(value = "/tbl_menu/getByUser", method = RequestMethod.GET)
	public ResponseEntity getByUser(
			HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user
		) {

		try {

			String hql = "select distinct(o.menuId) from Tbl_Quyen_Menu o where 1=1 ";
			hql += " and o.quyenId.id in ("
					+ " select qnq.quyenId.id "
					+ " from Tbl_Quyen_NhomQuyen qnq"
					+ " where qnq.nhomQuyenId.id  = " + user.getNhomQuyenId().getId()
					+ " ) ";
			
			
			List objs = genericDAO.queryHQL(hql, null);
			return new ResponseEntity(objs, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value = "/tbl_menu/find", method = RequestMethod.GET)
	public ResponseEntity find(
			@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page,
			HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user
		) {

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
			if (request.getParameter("menuCha") != null) {
				Tbl_Menu menuCha = new ObjectMapper().readValue(request.getParameter("menuCha"), Tbl_Menu.class);
				MyFilter con = new MyFilter();

				if (menuCha.getId() == null) {
					con.setCol("menuCha");
					con.setOperator("isNull");
					cons.add(con);
				} else {
					con.setCol("menuCha.id");
					con.setOperator("eq");
					con.setValue1(menuCha.getId());
					cons.add(con);
				}
			}

			{
				MyFilter con = new MyFilter();
				con.setOperator("order");
				con.setValue1("asc");
				con.setCol("nhom");

				cons.add(con);
			}

			if (pageSize == null || pageSize == 0)
				pageSize = 20;
			// no pageing
			else if (pageSize == -1) {
				pageSize = 0;
			}

			if (page == 0)
				page = 1;

			List objs = genericDAO.findByCondition(Tbl_Menu.class, cons, pageSize, page);
			return new ResponseEntity(objs, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_menu/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {

		try {

			Tbl_Menu obj = (Tbl_Menu) genericDAO.get(Tbl_Menu.class, id);

			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_menu", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_Menu obj) {

		try {
			if (obj.getMenuCha() != null)
				obj.setLvl(obj.getMenuCha().getLvl() + 1);
			else
				obj.setLvl(0);

			if (obj.getMenuCha() != null)
				obj.setNhom(obj.getMenuCha().getNhom() + "." + obj.getStt());
			else
				obj.setNhom(obj.getStt() + "");

			Long id = genericDAO.save(obj);
			obj.setId(id);

			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_menu/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCustomer(@PathVariable Long id) {
		try {

			genericDAO.delete(Tbl_Menu.class, id);

			return new ResponseEntity(id, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/tbl_menu", method = RequestMethod.PUT)
	public ResponseEntity updateObj(@RequestBody Tbl_Menu obj) {
		try {

			if (obj.getMenuCha() != null)
				obj.setLvl(obj.getMenuCha().getLvl() + 1);
			else
				obj.setLvl(0);
			NumberFormat formatter = new DecimalFormat("00");

			if (obj.getMenuCha() != null)
				obj.setNhom(obj.getMenuCha().getNhom() + "." + formatter.format(obj.getStt()));
			else
				obj.setNhom(formatter.format(obj.getStt()));

			genericDAO.saveOrUpdate(obj);
			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_menu/count", method = RequestMethod.GET)
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
		if (request.getParameter("sTT") != null) {
			MyFilter con = new MyFilter();
			con.setCol("sTT");
			con.setOperator("eq");
			con.setValue1(request.getParameter("sTT"));
			cons.add(con);
		}
		if (request.getParameter("hinh") != null) {
			MyFilter con = new MyFilter();
			con.setCol("hinh");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("hinh") + "%");
			cons.add(con);
		}
		if (request.getParameter("menuId") != null) {
			MyFilter con = new MyFilter();
			con.setCol("menuId");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("menuId") + "%");
			cons.add(con);
		}
		if (request.getParameter("nhom") != null) {
			MyFilter con = new MyFilter();
			con.setCol("nhom");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("nhom") + "%");
			cons.add(con);
		}
		if (request.getParameter("ten") != null) {
			MyFilter con = new MyFilter();
			con.setCol("ten");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("ten") + "%");
			cons.add(con);
		}
		if (request.getParameter("url") != null) {
			MyFilter con = new MyFilter();
			con.setCol("url");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("url") + "%");
			cons.add(con);
		}
		try {
			if (request.getParameter("menuCha") != null) {
				Tbl_Menu obj = new ObjectMapper().readValue(request.getParameter("menuCha"), Tbl_Menu.class);
				if (obj.getId() != null && !obj.getId().equals(new Long(0))) {
					MyFilter con = new MyFilter();
					con.setCol("menuCha.id");
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

		return genericDAO.countByCondition(Tbl_Menu.class, cons);
	}

}