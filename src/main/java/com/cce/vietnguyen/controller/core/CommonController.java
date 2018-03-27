
package com.cce.vietnguyen.controller.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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

import com.cce.vietnguyen.model.core.Tbl_CanBo;
import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.GenericRepository;
import com.cce.vietnguyen.repository.MyFilter;
import com.cce.vietnguyen.repository.StoreParameter;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CommonController {
	@Autowired
	private GenericDao genericDAO;
	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping(value = "/common/autocomplete", method = RequestMethod.GET)
	public List autocomplete(@RequestParam(required = true) String pack, @RequestParam(required = true) String tbl,
			@RequestParam(required = false) String q) {

		String hql = "select t from " + StringUtils.capitalize(tbl).replaceAll(" ", "") + " t ";
		hql += " where 1=1 ";
		try {
			Class clazz = Class.forName(pack + tbl);
			try {

				if (clazz.getDeclaredField("code") != null && clazz.getDeclaredField("name") != null) {
					hql += " and (t.code like :key or t.name like :key )";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if (clazz.getDeclaredField("ma") != null && clazz.getDeclaredField("ten") != null) {
					hql += " and (t.ma like :key or t.ten like :key )";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Map<String, Object> params = new HashMap<>();
		params.put("key", "%" + q + "%");

		return genericDAO.queryHQL(hql, params);
	}

	@RequestMapping(value = "/common/checkright", method = RequestMethod.GET)
	public Boolean checkRight(
			  @RequestParam(required = false) String objStr
			, @RequestParam(required = false) String actionStr

			, @AuthenticationPrincipal Tbl_TaiKhoan user) {

			return genericRepository.checkRight(user, objStr, actionStr);
	
		
	}
	


	@RequestMapping(value = "/common/vw/{name}", method = RequestMethod.POST)
	public ResponseEntity view(@PathVariable("name") String viewName, @RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page, @RequestBody List<MyFilter> filters,
			HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user) {
		
		
		if (!genericRepository.checkRight(user, viewName, "xem")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}

		String sql = "select t.*  from " + StringUtils.capitalize(viewName).replaceAll(" ", "") + " t ";
		sql += " where 1=1 ";

		Map<String, Object> params = new HashMap<>();
		int i = 0;
		for (MyFilter f : filters) {
			if (!f.getOperator().toLowerCase().equals("order")) {
				i++;
				sql += " AND " + f.getCol() + " ";
				sql += " " + f.getOperator() + " ";
				sql += " :" + f.getCol() + i + " ";
				params.put(f.getCol() + i, "" + f.getValue1() + "");
			}
		}
		sql += " ORDER BY 1 ";
		i = 0;
		for (MyFilter f : filters) {
			if (f.getOperator().toLowerCase().equals("order")) {
				i++;
				sql += " ," + f.getCol() + " ";
				sql += " " + f.getValue1() + " ";
			}
		}

		return new ResponseEntity(
				genericRepository.querySQL_AliasTransformer(sql, params, pageSize, page),
				HttpStatus.OK
		);
	}
	

	@RequestMapping(value = "/common/sp/{name}", method = RequestMethod.POST)
	public ResponseEntity callSP(
			@PathVariable("name") String spName, @RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page, @RequestBody List<MyFilter> filters,
			HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user) {
		//advh
//		if (user == null || user.getId().equals(new Long(0))) {
//			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//		}
                //advh
//		if (!genericRepository.checkRight(user, spName, "xem")) {
//			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//		}
		
		List<StoreParameter> params = new ArrayList<>();
		for (MyFilter f : filters) {
			{
				
				try {
					StoreParameter p = new StoreParameter();
					p.setName(f.getCol());
					p.setVal(f.getValue1().toString());
					p.setClazz(String.class);

					params.add(p);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		}

		
		return new ResponseEntity(
				genericRepository.callStoreProcedure(spName, params, null),
				HttpStatus.OK
		);

	}

	@RequestMapping(value = "/common/sp/micro/{name}", method = RequestMethod.POST)
	public ResponseEntity call_SP_Alias(
			@PathVariable("name") String spName, @RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page, @RequestBody List<MyFilter> filters,
			HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user) {
		
		if (user == null || user.getId().equals(new Long(0))) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}

		if (!genericRepository.checkRight(user, spName, "xem")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		

		String sql = "EXEC  " + spName + " ";

		Map<String, Object> params = new HashMap<>();
		int i = 0;
		for (MyFilter f : filters) {
			{
				i++;
				
				sql += "@" +f.getCol() +" = :" + f.getCol() + " ";
				if(i < filters.size()){
					sql += ", ";
				}

				params.put(f.getCol(), "" + f.getValue1() + "");
			}
			

		}
		sql += " ";
		
		List<Map<String, Object>> results = genericRepository.querySQL_AliasTransformer(sql, params, pageSize, page);

		return new ResponseEntity(
				results,
				HttpStatus.OK
		);

		

	}


	@RequestMapping(value = "/common/sp/my/{name}", method = RequestMethod.POST)
	public ResponseEntity call_SP_MySQL(
			@PathVariable("name") String spName, @RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page, @RequestBody List<MyFilter> filters,
			HttpServletRequest request,
			@AuthenticationPrincipal Tbl_TaiKhoan user) {
		
		if (user == null || user.getId().equals(new Long(0))) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}

		if (!genericRepository.checkRight(user, spName, "xem")) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		

		String sql = "EXEC  " + spName + " ";

		Map<String, Object> params = new HashMap<>();
		int i = 0;
		for (MyFilter f : filters) {
			{
				i++;
				
				sql += "@" +f.getCol() +" = :" + f.getCol() + " ";
				if(i < filters.size()){
					sql += ", ";
				}

				params.put(f.getCol(), "" + f.getValue1() + "");
			}
			

		}
		sql += " ";
		

		return new ResponseEntity(
				genericRepository.querySQL_AliasTransformer(sql, params, pageSize, page),
				HttpStatus.OK
		);

		

	}



}
