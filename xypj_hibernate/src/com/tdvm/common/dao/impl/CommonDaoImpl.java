package com.tdvm.common.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tdvm.bean.PageInfo;
import com.tdvm.common.dao.CommonDao;

@Repository
public class CommonDaoImpl extends HibernateDaoSupport implements CommonDao {

	@Autowired
	private void setHibernateSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Object create(Object entity) {
		return getHibernateTemplate().save(entity);
	}

	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);

	}

	public void update(Object entity) {
		getHibernateTemplate().update(entity);

	}

	public Object getObjectById(Class<?> c, Serializable id) {
		return getHibernateTemplate().get(c, id);
	}

	public List<?> getListAndCountBySQL(final String sqlName,
			final Object[] values, final PageInfo pageBean, String whereSql) {

		List<?> list = getListBySQL(sqlName, values, null, whereSql);
		if (pageBean != null) {
			pageBean.setTotolPage(list.size());
		}

		return getListBySQL(sqlName, values, pageBean, whereSql);
	}

	private List<?> getListBySQL(final String sqlName, final Object[] values,
			final PageInfo pageBean, final String whereSql) {
		HibernateCallback<Object> selectCallback = new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) {

				Query query = session.getNamedQuery(sqlName);
				String sql = query.getQueryString();

				if (StringUtils.isNotBlank(whereSql)) {
					sql = sql + " " + whereSql;
				}

				SQLQuery sqlQuery = session.createSQLQuery(sql);

				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						sqlQuery.setParameter(i, values[i]);
					}
				}
				if (pageBean != null) {

					int firstResult = pageBean.getStart();// pageBean.getFirstResult();
					int pageSize =pageBean.getLength();// pageBean.getPageSize();
//					int currPage = pageBean.getCurrPage();
					System.out.println(firstResult);
					System.out.println(pageSize);
//					System.out.println(currPage);
					// return
					// query.setFirstResult(pageBean.getStartPage()).setMaxResults(pageBean.getEndPage()).list();
					return sqlQuery.setFirstResult(firstResult).setMaxResults(pageSize).list();
				} else {
					return sqlQuery.list();
				}
			}
		};
		List<?> list = (List<?>) getHibernateTemplate().executeFind(
				selectCallback);
		return list;
	}
	


	public Object getObjectByHQL(final String select, final Object[] values, final PageInfo pageInfo) {
		HibernateCallback<Object> selectCallback = new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(select);
				if (values != null) {
					for (int i = 0; i < values.length; i++)
						query.setParameter(i, values[i]);
				}
				if (pageInfo != null) {
					return query.setFirstResult(pageInfo.getStartPage()).setMaxResults(pageInfo.getEndPage())
							.uniqueResult();
				}
				return query.uniqueResult();
			}
		};
		return getHibernateTemplate().execute(selectCallback);
	}

	public Object getObjectByHQLAsCache(final String select, final Object[] values, final PageInfo pageInfo) {
		HibernateCallback<Object> selectCallback = new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(select);
				query.setCacheable(true);
				if (values != null) {
					for (int i = 0; i < values.length; i++)
						query.setParameter(i, values[i]);
				}
				if (pageInfo != null) {
					return query.setFirstResult(pageInfo.getStartPage()).setMaxResults(pageInfo.getEndPage())
							.uniqueResult();
				}
				return query.uniqueResult();
			}
		};
		return getHibernateTemplate().execute(selectCallback);
	}

	public List<?> getListBySQL(final String select, final Object[] values, final Class<?> c, final PageInfo pageInfo) {
		HibernateCallback<Object> selectCallback = new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) {
				Query query;
				if (c == null)
					query = session.createSQLQuery(select);
				else {
					Map<?, ?> map = session.getSessionFactory().getAllClassMetadata();
					if (map.containsKey(c.getName())) {
						query = session.createSQLQuery(select).addEntity(c);
					} else {
						query = session.createSQLQuery(select).setResultTransformer(Transformers.aliasToBean(c));
					}
				}
				if (values != null) {
					for (int i = 0; i < values.length; i++)
						query.setParameter(i, values[i]);
				}

				if (pageInfo != null) {
					return query.setFirstResult(pageInfo.getStartPage()).setMaxResults(pageInfo.getEndPage()).list();
				}

				return query.list();
			}
		};
		return (List<?>) getHibernateTemplate().execute(selectCallback);
	}

	public List<?> getListByHQL(final String select, final Object[] values, final PageInfo pageInfo) {

		HibernateCallback<Object> selectCallback = new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(select);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						query.setParameter(i, values[i]);
					}
				}
				if (pageInfo != null) {

					pageInfo.setTotolPage(query.list().size());
					return query.setFirstResult(pageInfo.getStartPage()).setMaxResults(pageInfo.getPageSize()).list();
				}

				return query.list();
			}
		};
		List<?> list = (List<?>) getHibernateTemplate().execute(selectCallback);
		return list;
	}

	public List<?> getListByHQLByCache(final String select, final Object[] values, final PageInfo pageInfo) {

		HibernateCallback<Object> selectCallback = new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(select);
				query.setCacheable(true);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						query.setParameter(i, values[i]);
					}
				}
				if (pageInfo != null) {
					pageInfo.setTotolPage(query.list().size());
					return query.setFirstResult(pageInfo.getStartPage()).setMaxResults(pageInfo.getPageSize()).list();
				}

				return query.list();
			}
		};
		List<?> list = (List<?>) getHibernateTemplate().execute(selectCallback);
		return list;
	}

	public void deleteByHQL(String hsql, String value) {

		Session session = this.getSessionFactory().openSession();

		session.createQuery(hsql).setString("value", value).executeUpdate();

		session.close();

	}
	
	public void insertBySql(final String select) {
		Session session = this.getSessionFactory().openSession();
		Query query = session.getNamedQuery(select);
		String sql = query.getQueryString();
		session.createSQLQuery(sql).executeUpdate(); 
		session.close();
	}


}
