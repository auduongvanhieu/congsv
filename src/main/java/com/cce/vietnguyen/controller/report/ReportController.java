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

import com.cce.vietnguyen.model.core.Tbl_HTMLReport;
import com.cce.vietnguyen.model.core.Tbl_HTMLReport_Param;
import com.cce.vietnguyen.repository.GenericDao;
import com.cce.vietnguyen.repository.GenericRepository;
import com.cce.vietnguyen.repository.MyFilter;

@RestController
public class ReportController {

	
	@Autowired
	private GenericDao genericDAO;

	@Autowired
	private GenericRepository genericRepository;

	@RequestMapping(value="/report/param/autocomplete", method = RequestMethod.GET)
	public List<Map<String, Object>> autocomplete(
			@RequestParam(required = true) Long id
			,@RequestParam(required = true) String q
			,HttpServletRequest request) {
		Tbl_HTMLReport_Param param = (Tbl_HTMLReport_Param) genericDAO.get(Tbl_HTMLReport_Param.class, id);
		

        String sql = param.getParamSql();
        
        String key = "{" + param.getParamVariable() + "}";
        if(sql != null && sql.contains(key)) {
            sql = sql.replace(key, q);
        }
        
		sql.replaceAll("delete", "");
		sql.replaceAll("update", "");
		sql.replaceAll("insert", "");
		sql.replaceAll("grant", "");
		sql.replaceAll("invoke", "");
		sql.replaceAll("exec", "");
		
		Map<String,Object> parameters = new HashMap<String, Object>();
//		parameters.put(param.getParamVariable(), q);
		
		List<Map<String, Object>> obj 
 					= genericRepository.querySQL_AliasTransformer(sql,parameters, 0, 0);

		return obj;
		
	}


	@RequestMapping(value="/report/bodydata/{id}", method = RequestMethod.POST)
	public List<Map<String, Object>> getBodyData(
			@PathVariable("id") Long id
			,@RequestBody List<Tbl_HTMLReport_Param> params
			,HttpServletRequest request) {
		
		//get report
		Tbl_HTMLReport report = (Tbl_HTMLReport) genericDAO.get(Tbl_HTMLReport.class, id);
		
		//check right
		
		//-- end check right
		
		//get data
        String sql = buildSql(report.getBodySql(), params);
		
		Map<String,Object> parameters = new HashMap<String, Object>();
//		parameters.put(param.getParamVariable(), q);
		
		List<Map<String, Object>> obj 
 					= genericRepository.querySQL_AliasTransformer(sql,parameters, 0, 0);

		return obj;
	}
	@RequestMapping(value="/report/headerdata/{id}", method = RequestMethod.GET)
	public List<Map<String, Object>> getHeaderData(
			@PathVariable("id") Long id
			,@RequestBody List<Tbl_HTMLReport_Param> params
			,HttpServletRequest request) {
		
		//get report
		Tbl_HTMLReport report = (Tbl_HTMLReport) genericDAO.get(Tbl_HTMLReport.class, id);
		
		//get data
        String sql = buildSql(report.getHeader(), params);
        
		Map<String,Object> parameters = new HashMap<String, Object>();
//		parameters.put(param.getParamVariable(), q);
		
		List<Map<String, Object>> obj 
 					= genericRepository.querySQL_AliasTransformer(sql,parameters, 0, 0);

		return obj;
	}
	
	private String buildSql(String sql, List<Tbl_HTMLReport_Param> params){
		for(Tbl_HTMLReport_Param p : params){
        	String key = "{" + p.getTen() + "}";
            if(sql != null && sql.contains(key)) {
            	if(p.getValue() == null){
            		sql = sql.replace(key, "");
            	}else{
            		sql = sql.replace(key, p.getValue().toString());
            	}
            }
        }

		sql.replaceAll("delete", "");
		sql.replaceAll("update", "");
		sql.replaceAll("insert", "");
		sql.replaceAll("grant", "");
		sql.replaceAll("invoke", "");
		sql.replaceAll("exec", "");
		
		return sql;
	}

}