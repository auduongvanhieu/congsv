package com.cce.vietnguyen.repository;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.ParameterMode;

/**
 * Created with IntelliJ IDEA. Tbl_TaiKhoan: thanhng_adm Date: 10.07.15 Time:
 * 11:44 To change this template use File | Settings | File Templates.
 */

@Transactional
@Repository("genericDao")
public class GenericDao<T> {

	@Value("${app.dateformat}")
	private String dateformat;

	@Autowired
	private SessionFactory sessionFactory;

	public Long save(T obj) {
		return (Long) sessionFactory.getCurrentSession().save(obj);
	}

	public void saveWithoutReturn(T obj) {
		sessionFactory.getCurrentSession().save(obj);
	}

	public void saveOrUpdate(T obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	public T get(Class<T> clazz, Long id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	public T get(Class<T> clazz, String id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	public Collection<T> query(String sql) {
		return sessionFactory.getCurrentSession().createQuery(sql).list();
	}

	public Collection<T> queryDistinct(String sql, int pageNo, int pageSize) {
		return sessionFactory.getCurrentSession().createQuery(sql).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.setMaxResults(pageSize).setFirstResult((pageNo - 1) * pageSize).list();
	}

	public Collection<T> query(String sql, int pageNo, int pageSize) {

		return sessionFactory.getCurrentSession().createQuery(sql).setMaxResults(pageSize)
				.setFirstResult((pageNo - 1) * pageSize).list();

		// return sessionFactory.getCurrentSession().createQuery(sql).list();
	}

	public Collection<T> query(String hql, List<StoreParameter> params, int pageNo, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		// Set the parameters of the stored procedure.
		for (StoreParameter p : params) {
			query.setParameter(p.getName(), p.getVal());
		}

		return query.setMaxResults(pageSize).setFirstResult((pageNo - 1) * pageSize).list();
		// return sessionFactory.getCurrentSession().createQuery(sql).list();
	}

	public List<T> findByCondition(Class cclass, List<MyFilter> cons, int pageSize, int page) {
		String delimiter = "\\.";

		List<String> aliasList = new ArrayList<String>();

		String alias = "a";

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(cclass, alias);
		aliasList.add(alias);

		if (cons != null) {
			for (MyFilter con : cons) {
				

				String[] tbls = con.getCol().split(delimiter);
				int i = 0;
				String curentAlias = alias;
				for (i = 0; i < tbls.length - 1; i++) {
					if (i == 0) {
						if (!aliasList.contains(tbls[i])) {
							criteria.createCriteria(alias + "." + tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					} else {
						if (!aliasList.contains(tbls[i])) {
							criteria.createCriteria(tbls[i - 1] + "." + tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					}
					curentAlias = tbls[i];
				}

				String property = "";
				if (tbls.length > 1)
					property = tbls[i];
				else
					property = con.getCol();
				
				Criterion c = BuildRestriction(con, curentAlias, property);
				if(c != null){
					criteria.add(c);
				}
				

				// OR
				else if (con.getOperator().equals("or")) {

					Disjunction disjunction = Restrictions.disjunction();
					for(MyFilter orCon : (List<MyFilter>)con.getOrCons()){
						tbls = orCon.getCol().split(delimiter);
						i = 0;
						
						for (i = 0; i < tbls.length - 1; i++) {
							if (i == 0) {
								if (!aliasList.contains(tbls[i])) {
									criteria.createCriteria(alias + "." + tbls[i], tbls[i]);
									aliasList.add(tbls[i]);
								}
							} else {
								if (!aliasList.contains(tbls[i])) {
									criteria.createCriteria(tbls[i - 1] + "." + tbls[i], tbls[i]);
									aliasList.add(tbls[i]);
								}
							}
							curentAlias = tbls[i];
						}

						property = "";
						if (tbls.length > 1)
							property = tbls[i];
						else
							property = orCon.getCol();
						c = BuildRestriction(orCon, curentAlias, property);
						if(c != null){
							disjunction.add(c);
						}

					}
					
					criteria.add(disjunction);
				}

			} // for

			/// Order- distinct
			ProjectionList projList = Projections.projectionList();
			for (MyFilter con : cons) {
				String[] tbls = con.getCol().split(delimiter);

				int i = 0;
				String curentAlias = alias;
				for (i = 0; i < tbls.length - 1; i++) {
					if (i == 0) {
						if (!aliasList.contains(tbls[i])) {
							criteria.createCriteria(alias + "." + tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					} else {
						if (!aliasList.contains(tbls[i])) {
							criteria.createCriteria(tbls[i - 1] + "." + tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					}
					curentAlias = tbls[i];
				}

				String property = "";
				if (tbls.length > 1)
					property = tbls[i];
				else
					property = con.getCol();

				// order
				if (con.getOperator().equals("order")) {
					if (con.getValue1().equals("asc"))
						criteria.addOrder(Order.asc(curentAlias + "." + property));
					else if (con.getValue1().equals("desc"))
						criteria.addOrder(Order.desc(curentAlias + "." + property));
				}
				// groupby
				else if (con.getOperator().equals("groupby")) {
					projList.add(Projections.groupProperty(curentAlias + "." + property));
				}
				// projection
				else if (con.getOperator().equals("projection")) {
					projList.add(Projections.property(curentAlias + "." + property));
				}
				// sum
				else if (con.getOperator().equals("sum")) {
					projList.add(Projections.sum(curentAlias + "." + property));
				}
				// count
				else if (con.getOperator().equals("count")) {
					projList.add(Projections.count(curentAlias + "." + property));
				}
				// max
				else if (con.getOperator().equals("max")) {
					projList.add(Projections.max(curentAlias + "." + property));
				}
				// min
				else if (con.getOperator().equals("min")) {
					projList.add(Projections.min(curentAlias + "." + property));
				}
				// avg
				else if (con.getOperator().equals("avg")) {
					projList.add(Projections.avg(curentAlias + "." + property));
				}
			} // for

			if (projList.getLength() > 0)
				criteria.setProjection(projList);
		} // if
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (pageSize == 0)
			return criteria.list();

		return criteria.setFirstResult(pageSize * (page - 1)).setMaxResults(pageSize).list();

	}
	
	private Criterion BuildRestriction(MyFilter con, String curentAlias, String property){

		
		Object value1 = con.getValue1();
		Object value2 = con.getValue2();
		if (con.getType() != null && con.getType().toLowerCase().equals("date")) {
			try {
				if (dateformat == null || dateformat.equals("")) {
					dateformat = "dd-MM-yyyy";
				}

				DateFormat format1 = new SimpleDateFormat(dateformat);
				DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

				if (con.getValue1() != null && !con.getValue1().equals("")
						&& MyFilter.isValidDate(con.getValue1().toString(), dateformat)) {
					Date temp1 = format1.parse(con.getValue1().toString());
					String dateStr1 = format2.format(temp1);
					Date startDate = format2.parse(dateStr1);

					value1 = new Date(startDate.getTime());
				}

				if (con.getValue2() != null && !con.getValue2().equals("")
						&& MyFilter.isValidDate(con.getValue2().toString(), dateformat)) {
					Date temp2 = format1.parse(con.getValue2().toString());
					String dateStr2 = format2.format(temp2);
					Date endDate = format2.parse(dateStr2);
					value2 = new Date(endDate.getTime());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (con.getOperator().equals("eq")) {
			return (Criterion)(Restrictions.eq(curentAlias + "." + property, value1));
		}

		else if (con.getOperator().equals("eqOrIsNull")) {
			return (Criterion)(Restrictions.eqOrIsNull(curentAlias + "." + property, value1));
		}
		else if (con.getOperator().equals("like")) {
			return  (Criterion)(Restrictions.like(curentAlias + "." + property, value1).ignoreCase());
		}

		else if (con.getOperator().equals("ge")) {
			return  (Criterion)(Restrictions.ge(curentAlias + "." + property, value1));
		} // great than or equal

		else if (con.getOperator().equals("gt")) {
			return  (Criterion)(Restrictions.gt(curentAlias + "." + property, value1));
		} // great than

		else if (con.getOperator().equals("le")) {
			return  (Criterion)(Restrictions.le(curentAlias + "." + property, value1));
		} // less or equal

		else if (con.getOperator().equals("lt")) {
			return  (Criterion)(Restrictions.lt(curentAlias + "." + property, value1));
		} // less than

		else if (con.getOperator().equals("between")) {
			return (Restrictions.between(curentAlias + "." + property, value1, value2));

		} // between

		else if (con.getOperator().equals("inList")) {
			Object[] listVal = (Object[]) value1;
			return (Restrictions.in(curentAlias + "." + property, listVal));

		} // between
		

		else if (con.getOperator().equals("in")) {
			String[] temp = value1.toString().split(";");

			if (con.getType() != null) {
				if (con.getType().toLowerCase().equals("string")) {
					return (Restrictions.in(curentAlias + "." + property, temp));

				} else if (con.getType().toLowerCase().equals("long")) {

					Long[] ids = new Long[temp.length];
					for (int ii = 0; ii < temp.length; ii++) {
						try {
							if (!temp[ii].equals(""))
								ids[ii] = new Long(temp[ii]);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					return (Restrictions.in(curentAlias + "." + property, ids));

				} else if (con.getType().toLowerCase().equals("double")) {

					Double[] ids = new Double[temp.length];
					for (int ii = 0; ii < temp.length; ii++) {
						try {
							if (!temp[ii].equals(""))
								ids[ii] = new Double(temp[ii]);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					return (Restrictions.in(curentAlias + "." + property, ids));

				}
			}
			// Object[] ids = new Object[temp.length];
			// for(int ii =0; ii < temp.length ; ii++){
			// try{
			// if(!temp[ii].equals(""))
			// ids[ii] = new Object(temp[ii]);
			// }catch (Exception e) {
			// // TODO: handle exception
			// e.printStackTrace();
			// }
			// }
			//
			// return (Restrictions.in(curentAlias + "." +property,
			// ids));

		} // in list

		else if (con.getOperator().equals("ne")) {
			return  (Criterion)(Restrictions.ne(curentAlias + "." + property, value1));

		} // notEqual

		else if (con.getOperator().equals("isNull")) {
			return  (Criterion)(Restrictions.isNull(curentAlias + "." + property));

		} // isNull

		else if (con.getOperator().equals("isNotNull")) {
			return  (Criterion)(Restrictions.isNotNull(curentAlias + "." + property));

		} // isNotNull

			return null;
		
		
	}

	public Integer countByCondition(Class cclass, List<MyFilter> cons) {
		String delimiter = "\\.";

		List<String> aliasList = new ArrayList<String>();

		String alias = "a";

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(cclass, alias);
		aliasList.add(alias);

		if (cons != null) {
			for (MyFilter con : cons) {
				
				String[] tbls = con.getCol().split(delimiter);
				int i = 0;
				String curentAlias = alias;
				for (i = 0; i < tbls.length - 1; i++) {
					if (i == 0) {
						if (!aliasList.contains(tbls[i])) {
							criteria.createCriteria(alias + "." + tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					} else {
						if (!aliasList.contains(tbls[i])) {
							criteria.createCriteria(tbls[i - 1] + "." + tbls[i], tbls[i]);
							aliasList.add(tbls[i]);
						}
					}
					curentAlias = tbls[i];
				}

				String property = "";
				if (tbls.length > 1)
					property = tbls[i];
				else
					property = con.getCol();


				Criterion c = BuildRestriction(con, curentAlias, property);
				if(c != null){
					criteria.add(c);
				}
				
				// OR
				else if (con.getOperator().equals("or")) {

					Disjunction disjunction = Restrictions.disjunction();
					for(MyFilter orCon : (List<MyFilter>)con.getOrCons()){
						tbls = orCon.getCol().split(delimiter);
						i = 0;
						
						for (i = 0; i < tbls.length - 1; i++) {
							if (i == 0) {
								if (!aliasList.contains(tbls[i])) {
									criteria.createCriteria(alias + "." + tbls[i], tbls[i]);
									aliasList.add(tbls[i]);
								}
							} else {
								if (!aliasList.contains(tbls[i])) {
									criteria.createCriteria(tbls[i - 1] + "." + tbls[i], tbls[i]);
									aliasList.add(tbls[i]);
								}
							}
							curentAlias = tbls[i];
						}

						property = "";
						if (tbls.length > 1)
							property = tbls[i];
						else
							property = orCon.getCol();
						c = BuildRestriction(orCon, curentAlias, property);
						if(c != null){
							disjunction.add(c);
						}

					}
					
					criteria.add(disjunction);
				}


			} // for

		} // if

		criteria.setProjection(Projections.rowCount());

		Long result = new Long(criteria.uniqueResult().toString());
		if (result != null)
			return result.intValue();
		else
			return 0;
	}

	public void updateQuery(String sql) {
		sessionFactory.getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	public void delete(T obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	public void delete(Class<T> clazz, Long id) {
		T obj = (T) sessionFactory.getCurrentSession().get(clazz, id);
		sessionFactory.getCurrentSession().delete(obj);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Integer getPageCount(String sql, Integer max) {
		Long size = (Long) (sessionFactory.getCurrentSession().createQuery(sql).uniqueResult());

		System.out.println("size=" + size);

		Integer count = size.intValue();

		Integer numPage = count / max;

		if (count % max > 0)
			numPage++;

		System.out.println("pageNum=" + numPage);

		return numPage;
	}

	public Integer getIntegerValue(String sql) {
		BigDecimal agg = (BigDecimal) (sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult());

		if (agg != null) {
			return agg.intValue();
		} else {
			return 0;
		}
	}

	public List queryHQL(String hql, Map<String, Object> parameters) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.size() > 0) {
			Set<String> set = parameters.keySet();
			Iterator<String> i = set.iterator();
			while (i.hasNext()) {
				String key = i.next();
				query = query.setParameter(key, parameters.get(key));
			}
		}
		return query.list();
	}

	public List queryHQLPaging(String hql, Map<String, Object> parameters, int pageSize, int page) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.size() > 0) {
			Set<String> set = parameters.keySet();
			Iterator<String> i = set.iterator();
			while (i.hasNext()) {
				String key = i.next();
				query = query.setParameter(key, parameters.get(key));
			}
		}
		return query.setFirstResult(pageSize * (page - 1)).setMaxResults(pageSize).list();
	}

	public Object getUniqueResult(String sql) {
		return sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
	}

	@Transactional
	public Boolean executeSQLQuery(String sql) {
		try {
			Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
			int i = q.executeUpdate();

			if (i != 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}
}
