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

import com.cce.vietnguyen.model.core.Tbl_Quyen_Menu;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.GenericRepository;
import com.cce.vietnguyen.repository.MyFilter;

@RestController
public class Tbl_Quyen_MenuController {

	@Autowired
	private GenericDao genericDAO;
	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping(value = "/tbl_quyen_menu", method = RequestMethod.GET)
	public List getAll() {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");

			cons.add(con);
		}
		return genericDAO.findByCondition(Tbl_Quyen_Menu.class, cons, 20, 1);
	}

	@RequestMapping(value = "/tbl_quyen_menu/find", method = RequestMethod.GET)
	public ResponseEntity find(@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page, HttpServletRequest request) {

		try {

			List<MyFilter> cons = new ArrayList<MyFilter>();
			if (request.getParameter("quyenId") != null && !request.getParameter("quyenId").toString().trim().equals("0")) {
				MyFilter con = new MyFilter();
				con.setCol("quyenId.id");
				con.setOperator("eq");
				con.setValue1(new Long(request.getParameter("quyenId").toString()));
				cons.add(con);
			}
			if (request.getParameter("menuId") != null && !request.getParameter("menuId").toString().trim().equals("0")) {
				MyFilter con = new MyFilter();
				con.setCol("menuId.id");
				con.setOperator("eq");
				con.setValue1(new Long(request.getParameter("menuId").toString()));
				cons.add(con);
			}

			{
				MyFilter con = new MyFilter();
				con.setOperator("order");
				con.setValue1("asc");
				con.setCol("id");

				cons.add(con);
			}

			if (pageSize == null || pageSize == 0)
				pageSize = 20;
			//no pageing
			else if (pageSize == -1) {
				pageSize = 0;
			}

			if (page == 0)
				page = 1;
			
			List objs = genericDAO.findByCondition(Tbl_Quyen_Menu.class, cons, pageSize, page);
			return new ResponseEntity(objs,	HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_quyen_menu/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {

		try {

			Tbl_Quyen_Menu obj = (Tbl_Quyen_Menu) genericDAO.get(Tbl_Quyen_Menu.class, id);

			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_quyen_menu", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_Quyen_Menu obj) {

		try {

			Long id = genericDAO.save(obj);
			obj.setId(id);

			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_quyen_menu/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCustomer(@PathVariable Long id) {
		try {

			genericDAO.delete(Tbl_Quyen_Menu.class, id);

			return new ResponseEntity(id, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/tbl_quyen_menu", method = RequestMethod.PUT)
	public ResponseEntity updateObj(@RequestBody Tbl_Quyen_Menu obj) {
		try {
			genericDAO.saveOrUpdate(obj);
			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/tbl_quyen_menu/saveAll/{quyenId}", method = RequestMethod.POST)
	public ResponseEntity saveAllObjs(@RequestBody List<Tbl_Quyen_Menu> objs,@PathVariable Long quyenId) {
		try {
			//delete old
			String q = "delete from Tbl_Quyen_Menu where quyenId = " + quyenId;
			genericRepository.deleteByQuery(q);
			
			for(Tbl_Quyen_Menu obj : objs){

					 Long objId = genericDAO.save(obj);
					 obj.setId(objId);
				
			}
			return new ResponseEntity(objs, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}