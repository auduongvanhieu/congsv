package com.cce.vietnguyen.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cce.vietnguyen.model.core.Tbl_Quyen_ChiTiet;
import com.cce.vietnguyen.model.core.Tbl_TaiKhoan;
import com.sun.org.apache.xpath.internal.operations.Bool;

@Repository
public class GenericRepositoryImpl implements GenericRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Boolean checkRight2(Tbl_TaiKhoan user, String tableCode, String actionCode){
		Boolean checkRight = false;
		String spName = "EXEC sp_GENERAL_CheckRight @taiKhoanId = :taiKhoanId, "
				+ " @nhomQuyenId = :nhomQuyenId,"
				+ " @tableCode = :tableCode, "
				+ " @actionCode = :actionCode ";
	
		try {
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery(spName);
			// Set the parameters of the stored procedure.
			{
				query.setParameter("taiKhoanId", user.getId().toString());
				query.setParameter("nhomQuyenId", user.getNhomQuyenId().getId().toString());
				query.setParameter("tableCode", tableCode);
				query.setParameter("actionCode", actionCode);
			}
			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

			List<Map<String, Object>> rs = query.list();
			
			if(rs != null && rs.size() > 0 && rs.get(0).get("acceptYN").toString().equals("1")){
				checkRight = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return checkRight;
	}

	@Transactional
	public Boolean checkRight_OrgUnit(Tbl_TaiKhoan user, String tableCode, String actionCode){
		return checkRight(user, tableCode + "_orgunit", actionCode);
	}
	@Transactional
	public Boolean checkRight(Tbl_TaiKhoan user, String tableCode, String actionCode){

		Boolean checkRight = false;
		try {
			StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_GENERAL_CheckRight");

			storedProcedure.registerStoredProcedureParameter("p_taiKhoanId", Long.class, ParameterMode.IN);
			storedProcedure.setParameter("p_taiKhoanId", user.getId());

			storedProcedure.registerStoredProcedureParameter("p_nhomQuyenId", Long.class, ParameterMode.IN);
			storedProcedure.setParameter("p_nhomQuyenId", user.getNhomQuyenId().getId());

			storedProcedure.registerStoredProcedureParameter("p_tableCode", String.class, ParameterMode.IN);
			storedProcedure.setParameter("p_tableCode", tableCode);
			
			storedProcedure.registerStoredProcedureParameter("p_actionCode", String.class, ParameterMode.IN);
			storedProcedure.setParameter("p_actionCode", actionCode);



			// Call the stored procedure.
			List<Object[]> rs = storedProcedure.getResultList();
			if(rs != null && rs.size() > 0 ){
				System.out.println(rs.get(0)[0].toString()); 
				if(rs.get(0)[0].toString().equals("1"))
					checkRight = true;
			}
			return checkRight;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	
		
	}

	@Transactional
	public List callStoreProcedure(String spName, List<StoreParameter> params, Class resultClass) {

		try {
			StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(spName);

			if (resultClass != null)
				storedProcedure = entityManager.createStoredProcedureQuery(spName, resultClass);

			// Set the parameters of the stored procedure.
			for (StoreParameter p : params) {
				if (p.getMode() == null) {
					p.setMode(ParameterMode.IN);
				}
				storedProcedure.registerStoredProcedureParameter(p.getName(), p.getClazz(), p.getMode());
				storedProcedure.setParameter(p.getName(), p.getVal());

			}

			// Call the stored procedure.
			List storedProcedureResults = storedProcedure.getResultList();
			return storedProcedureResults;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		// Use Java 8's cool new functional programming paradigm to map the
		// objects from the stored procedure results
		// return storedProcedureResults.stream().map(result -> new MyObject(
		// (Integer) result[0],
		// (String) result[1]
		// )).collect(Collectors.toList());

	}

	@Transactional
	public Long deleteByQuery(String q) {

		javax.persistence.Query query = entityManager.createQuery(q);

		long rows = query.executeUpdate();

		System.out.println("Rows deleted: " + rows);

		return rows;
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Map<String, Object>> querySQL_AliasTransformer(String sql, Map<String, Object> parameters, int pageSize,
			int page) {
		try {
			List<Map<String, Object>> objs;
			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

			if (parameters != null && parameters.size() > 0) {
				Set<String> set = parameters.keySet();
				Iterator<String> i = set.iterator();
				while (i.hasNext()) {
					String key = i.next();
					query = query.setParameter(key, parameters.get(key));
				}
			}
			if (pageSize != 0) {
				query = query.setFirstResult(pageSize * (page - 1)).setMaxResults(pageSize);
			}

			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

			objs = query.list();
			return objs;

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
		// sessionFactory.getCurrentSession()
		// .createSQLQuery(sql)
		// .setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
	}

	@Transactional
	public List<Map<String, Object>> querySQL_AliasTransformer_Parameter(String sql, List<StoreParameter> params,
			int pageSize, int page) {
		try {
			List<Map<String, Object>> objs;
			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			// Set the parameters of the stored procedure.
			for (StoreParameter p : params) {
				if (p.getMode() == null) {
					p.setMode(ParameterMode.IN);
				}
				query.setParameter(p.getName(), p.getVal());

			}

			if (pageSize != 0) {
				query = query.setFirstResult(pageSize * (page - 1)).setMaxResults(pageSize);
			}

			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

			objs = query.list();
			return objs;

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
		// sessionFactory.getCurrentSession()
		// .createSQLQuery(sql)
		// .setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
	}

}
