
package com.cce.vietnguyen.controller.core;

import com.alibaba.fastjson.JSONObject;
import com.cce.vietnguyen.model.Tbl_QLDT_DKMH_HocVien_DangKy_LopMonHoc;
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;

import com.cce.vietnguyen.model.core.Tbl_CanBo;
import com.cce.vietnguyen.model.core.Tbl_NhomQuyen;
import com.cce.vietnguyen.util.Constants;
import java.util.HashMap;

/*
* Controller Template: Template/Server/ControllerTemplate.java
*/
@RestController
public class Tbl_TaiKhoanController {
	@Autowired
	private GenericDao genericDAO;
	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping(value = "/tbl_taikhoan", method = RequestMethod.GET)
	public List getAll() {
		List<MyFilter> cons = new ArrayList<MyFilter>();
		{
			MyFilter con = new MyFilter();
			con.setOperator("order");
			con.setValue1("desc");
			con.setCol("id");
			cons.add(con);
		}
		return genericDAO.findByCondition(Tbl_TaiKhoan.class, cons, 20, 1);
	}

	@RequestMapping(value = "/tbl_taikhoan/find", method = RequestMethod.GET)
	public ResponseEntity find(@RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page, HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_taikhoan", "xem")) {
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
			return new ResponseEntity(genericDAO.findByCondition(Tbl_TaiKhoan.class, cons, pageSize, page),
					HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/tbl_taikhoan/{id}", method = RequestMethod.GET)
	public ResponseEntity getObjById(@PathVariable("id") Long id, HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_taikhoan", "xem")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		Tbl_TaiKhoan obj = (Tbl_TaiKhoan) genericDAO.get(Tbl_TaiKhoan.class, id);
		return new ResponseEntity(obj, HttpStatus.OK);
	}
	@Autowired
	private  BCryptPasswordEncoder encoder;
	@RequestMapping(value = "/tbl_taikhoan", method = RequestMethod.POST)
	public ResponseEntity createObj(@RequestBody Tbl_TaiKhoan obj, @AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_taikhoan", "them")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			obj.setPassword(encoder.encode(obj.getPassword()));
			
			
			Long id = genericDAO.save(obj);
			obj.setId(id);
			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			System.out.println("object already exist");
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/tbl_taikhoan/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteObj(@PathVariable Long id, @AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_taikhoan", "xoa")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		genericDAO.delete(Tbl_TaiKhoan.class, id);
		return new ResponseEntity(id, HttpStatus.OK);
	}

	@RequestMapping(value = "/tbl_taikhoan", method = RequestMethod.PUT)
	public ResponseEntity updateObj(@RequestBody Tbl_TaiKhoan obj, @AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_taikhoan", "sua")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			if(obj != null && !obj.getPassword().equals("")){
			obj.setPassword(encoder.encode(obj.getPassword()));
			}else{
				Tbl_TaiKhoan tk = (Tbl_TaiKhoan) genericDAO.get(Tbl_TaiKhoan.class, obj.getId());
				obj.setPassword(tk.getPassword());
			}
			
			genericDAO.saveOrUpdate(obj);
			return new ResponseEntity(obj, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			System.out.println("object already exist");
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/tbl_taikhoan/count", method = RequestMethod.GET)
	public ResponseEntity count(HttpServletRequest request, @AuthenticationPrincipal Tbl_TaiKhoan user) {
		if (!genericRepository.checkRight(user, "tbl_taikhoan", "xem")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		List<MyFilter> cons = new ArrayList<MyFilter>();
		cons = buildFilter(request);
		return new ResponseEntity(genericDAO.countByCondition(Tbl_TaiKhoan.class, cons),HttpStatus.OK);
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
		if (request.getParameter("password") != null) {
			MyFilter con = new MyFilter();
			con.setCol("password");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("password") + "%");
			cons.add(con);
		}
		if (request.getParameter("login") != null) {
			MyFilter con = new MyFilter();
			con.setCol("login");
			con.setOperator("like");
			con.setValue1("%" + (String) request.getParameter("login") + "%");
			cons.add(con);
		}
		try {
			if (request.getParameter("canBoId") != null) {
				Tbl_CanBo obj = new ObjectMapper().readValue(request.getParameter("canBoId"), Tbl_CanBo.class);
				if (obj.getId() != null && !obj.getId().equals(new Long(0))) {
					MyFilter con = new MyFilter();
					con.setCol("canBoId.id");
					con.setOperator("eq");
					con.setValue1(obj.getId());
					cons.add(con);
				}
			}
		} catch (Exception e) {
		}
		try {
			if (request.getParameter("nhomQuyenId") != null) {
				Tbl_NhomQuyen obj = new ObjectMapper().readValue(request.getParameter("nhomQuyenId"),
						Tbl_NhomQuyen.class);
				if (obj.getId() != null && !obj.getId().equals(new Long(0))) {
					MyFilter con = new MyFilter();
					con.setCol("nhomQuyenId.id");
					con.setOperator("eq");
					con.setValue1(obj.getId());
					cons.add(con);
				}
			}
		} catch (Exception e) {
		}

		return cons;
	}
        //Create by Hieu
        @RequestMapping(value = "/tbl_taikhoan_doimatkhau", method = RequestMethod.PUT)
	public String updateObjDoiMatKhau(@RequestBody List<Tbl_TaiKhoan> objs, @AuthenticationPrincipal Tbl_TaiKhoan user) {
//		if (!genericRepository.checkRight(user, "tbl_taikhoan", "sua")) {
//			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE).toString();
//		}
           HashMap<String,Object> result=new HashMap();
           
            try {
                
                List<MyFilter> cons = new ArrayList<MyFilter>();
                cons = buildFilterTaiKhoan(objs.get(0));
                List<Tbl_TaiKhoan> obj_orgins= genericDAO.findByCondition(Tbl_TaiKhoan.class, cons, 20, 1);
                
                if(encoder.matches(objs.get(0).getPassword(), obj_orgins.get(0).getPassword()))
                {
                    Tbl_TaiKhoan obj=obj_orgins.get(0);
                    obj.setPassword(encoder.encode(objs.get(1).getPassword()));
                    genericDAO.saveOrUpdate(obj);

                    //Báo kết quả thành công
                    result.put(Constants.RESULT_FLAG, "false");
                    result.put(Constants.RESULT_MESSAGE,Constants.UPDATE_PASSWORD_SUCCESS);
                    return (new JSONObject(result)).toString();
                }
                else
                {
                     //Báo sai mật khẩu cũ
                    result.put(Constants.RESULT_FLAG, "false");
                    result.put(Constants.RESULT_MESSAGE,Constants.FAIL_OLD_PASSWORD);
                    return (new JSONObject(result)).toString();
                }

                
            } catch (DataIntegrityViolationException e) {
                //Báo lỗi
                result.put(Constants.RESULT_FLAG, "false");
                result.put(Constants.RESULT_MESSAGE,Constants.EXCEPTION);
                return (new JSONObject(result)).toString();
            }
	}
        private List<MyFilter> buildFilterTaiKhoan(Tbl_TaiKhoan request) {
        List<MyFilter> cons = new ArrayList<MyFilter>();
        if (request.getLogin()!= null) {
                MyFilter con = new MyFilter();
                con.setCol("login");
                con.setOperator("eq");
                con.setValue1( request.getLogin());
                cons.add(con);
            }
//        if (request.getPassword() != null) {
//                MyFilter con = new MyFilter();
//                con.setCol("password");
//                con.setOperator("eq");
//                con.setValue1(request.getPassword());
//                cons.add(con);
//            }
        return cons;
    }
}