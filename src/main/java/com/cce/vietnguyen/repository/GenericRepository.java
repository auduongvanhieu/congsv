package com.cce.vietnguyen.repository;

import java.util.List;
import java.util.Map;

import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;

public interface GenericRepository {
	List callStoreProcedure(String spName,List<StoreParameter> params, Class resultClass);
	public Long deleteByQuery(String q);
	public Boolean checkRight(Tbl_TaiKhoan user, String tableCode, String actionCode);
	public Boolean checkRight_OrgUnit(Tbl_TaiKhoan user, String tableCode, String actionCode);
	public Boolean checkRight2(Tbl_TaiKhoan user, String tableCode, String actionCode);
	public List<Map<String, Object>> querySQL_AliasTransformer
	(String sql, Map<String, Object> parameters, int pageSize, int page);
}
