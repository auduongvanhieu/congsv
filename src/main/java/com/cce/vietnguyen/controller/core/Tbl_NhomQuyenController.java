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

import com.cce.vietnguyen.model.core.Tbl_NhomQuyen;
import com.cce.vietnguyen.model.core.Tbl_Quyen;
import com.cce.vietnguyen.model.core.Tbl_Quyen_NhomQuyen;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.MyFilter;

@RestController
public class Tbl_NhomQuyenController {

	@Autowired
	private GenericDao genericDAO;

	@RequestMapping(value = "/tbl_nhomquyen", method = RequestMethod.GET)
	public List getAll() {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");

			cons.add(con);
		}
		return genericDAO.findByCondition(Tbl_NhomQuyen.class, cons, 20, 1);
	}

	@RequestMapping(value = "/tbl_nhomquyen/find", method = RequestMethod.GET)
	public ResponseEntity find(@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page, HttpServletRequest request) {

		try {

			List<MyFilter> cons = new ArrayList<MyFilter>();
			if (request.getParameter("ma") != null) {
				MyFilter con = new MyFilter();
				con.setCol("ma");
				con.setOperator("like");
				con.setValue1("%" + (String) request.getParameter("ma") + "%");
				cons.add(con);
			}
			if (request.getParameter("name") != null) {
				MyFilter con = new MyFilter();
				con.setCol("name");
				con.setOperator("like");
				con.setValue1("%" + (String) request.getParameter("name") + "%");
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
			else if (pageSize == -1) {
				pageSize = 0;
			}

			if (page == 0)
				page = 1;
			
			List objs = genericDAO.findByCondition(Tbl_NhomQuyen.class, cons, pageSize, page);
			return new ResponseEntity(objs,	HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_nhomquyen/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request) {

		try {

			Tbl_NhomQuyen obj = (Tbl_NhomQuyen) genericDAO.get(Tbl_NhomQuyen.class, id);

			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_nhomquyen", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_NhomQuyen obj) {

		try {

			Long id = genericDAO.save(obj);
			obj.setId(id);

			//insert new reference
			for(Tbl_Quyen quyen : obj.getTblQuyens()){
				Tbl_Quyen_NhomQuyen quyenNhomQuyen = new Tbl_Quyen_NhomQuyen();
				quyenNhomQuyen.setNhomQuyenId(obj);
				quyenNhomQuyen.setQuyenId(quyen);
				
				Long idd = genericDAO.save(quyenNhomQuyen);
				quyenNhomQuyen.setId(idd);
				obj.getTblQuyenNhomQuyens().add(quyenNhomQuyen);
				
			}
			

			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/tbl_nhomquyen/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteObj(@PathVariable Long id) {
		try {

			genericDAO.delete(Tbl_NhomQuyen.class, id);

			return new ResponseEntity(id, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/tbl_nhomquyen", method = RequestMethod.PUT)
	public ResponseEntity updateObj(@RequestBody Tbl_NhomQuyen obj) {
		try {
			//update obj
			genericDAO.saveOrUpdate(obj);
			//delete old refefence
			for(Tbl_Quyen_NhomQuyen it : obj.getTblQuyenNhomQuyens()){
				genericDAO.delete(Tbl_Quyen_NhomQuyen.class, it.getId());
			}
			obj.getTblQuyenNhomQuyens().clear();
			
			//insert new reference
			for(Tbl_Quyen quyen : obj.getTblQuyens()){
				Tbl_Quyen_NhomQuyen quyenNhomQuyen = new Tbl_Quyen_NhomQuyen();
				quyenNhomQuyen.setNhomQuyenId(obj);
				quyenNhomQuyen.setQuyenId(quyen);
				
				Long idd = genericDAO.save(quyenNhomQuyen);
				quyenNhomQuyen.setId(idd);
				obj.getTblQuyenNhomQuyens().add(quyenNhomQuyen);
				
			}
			
			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}