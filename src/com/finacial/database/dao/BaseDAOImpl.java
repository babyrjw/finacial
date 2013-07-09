package com.finacial.database.dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * @author joseph
 * @since 11/15/12  4:11 PM
 */
public class BaseDAOImpl<E, PK extends Serializable> implements BaseDAO<E, PK> {
	private SessionFactory sessionFactory;
	protected Order order=null;

	@Override
	public E find(PK id) {
		return (E) getSession().get(getEntityClass(), id);
	}

	@Override
	public E load(PK id) {
		return (E) getSession().load(getEntityClass(), id);
	}

	@Override
	public List<E> findByProperty(String key, Object value) {
		return addOrderCriteria(getSession().createCriteria(getEntityClass()).add(Restrictions.eq(key, value))).setCacheable(true).list();
	}

	@Override
	public List<E> findByProperties(Map<String, Object> properties) {
		Criteria c = getSession().createCriteria(getEntityClass());
		for (String key:properties.keySet())
			c.add(Restrictions.eq(key,properties.get(key)));
		return c.setCacheable(true).list();
	}

	@Override
	public List<E> findByExample(E example) {
		return addOrderCriteria(getSession().createCriteria(getEntityClass()).setCacheable(true).add(Example.create(example))).list();
	}

	@Override
	public List<E> findAll() {
		return addOrderCriteria(getSession().createCriteria(getEntityClass())).setCacheable(true).list();
	}
	public Pager findPageByExample(int pageNo, int pageSize, E example)  
	{  
	    Pager pager = null;  
	    try  
	    {  
	        Criteria criteria = this.getSession().createCriteria(this.getEntityClass());  
	  
	        if (example != null)  
	        {  
	            criteria.add(Example.create(example).enableLike());  
	        }  
	  
	        // 获取根据条件分页查询的总行数  
	        int rowCount = (Integer) criteria.setProjection(  
	                Projections.rowCount()).uniqueResult();  
	        criteria.setProjection(null);  
	  
	        criteria.setFirstResult((pageNo - 1) * pageSize);  
	        criteria.setMaxResults(pageSize);  
	  
	        List<E> result = criteria.list();  
	  
	        pager = new Pager(pageSize, pageNo, rowCount, result);  
	  
	    } catch (RuntimeException re)  
	    {  
	        throw re;  
	    } finally  
	    {  
	        return pager;  
	    }  
	  
	}  
	@Override
	public Pager<E> findPageByMap(int pageNo, int pageSize, Map map){
		Pager pager = null;  
		try  
		{  
			Criteria criteria = this.getSession().createCriteria(this.getEntityClass());  

			if (map != null)  
			{  
				Set<String> keys = map.keySet();  
				for (String key : keys)  
				{  
					criteria.add(Restrictions.like(key, map.get(key)));  
				}  
			}  

			// 获取根据条件分页查询的总行数  
			int rowCount = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();  
			criteria.setProjection(null);  

			criteria.setFirstResult((pageNo - 1) * pageSize);  
			criteria.setMaxResults(pageSize);  

			List<E> result = criteria.list();  

			pager = new Pager(pageSize, pageNo, rowCount, result);  

		} catch (RuntimeException re)  
		{  
			throw re;  
		} finally  
		{  
			return pager;  
		}  
	}
	@Override
	public PK save(E entity) {
		return (PK) getSession().save(entity);
	}

	@Override
	public List<PK> save(List<E> entities) {
		List<PK> ids=new LinkedList<PK>();
		for(E e:entities){
			ids.add(save(e));
		}
		return ids;
	}

	@Override
	public void saveOrUpdate(E entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdate(List<E> entities) {
		for(E e:entities){
			saveOrUpdate(e);
		}
	}

	@Override
	public void delete(E entity) {
		getSession().delete(entity);
	}

	@Override
	public void update(E entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(List<E> entities) {
		for(E e:entities){
			delete(e);
		}
	}

	@Override
	public void deleteByProperty(String key, Object value) {
		Session session=getSession();
		List<E> l=session.createCriteria(getEntityClass()).add(Restrictions.eq(key,value)).list();
		if(null!=l&&0<l.size())
			for(E e:l){
				session.delete(e);
			}
	}

	@Override
	public void deleteByProperties(Map<String, Object> properties) {
		Session session=getSession();
		Criteria c = session.createCriteria(getEntityClass());
		for (String key:properties.keySet())
			c.add(Restrictions.eq(key,properties.get(key)));
		List<E> l=c.list();
		if(null!=l&&0<l.size())
			for(E e:l){
				session.delete(e);
			}
	}

	@Override
	public void update(List<E> entities) {
		for(E e:entities){
			update(e);
		}
	}

	@Override
	public void updateProperties(Map<String, Object> properties, Map<String,Object> whereClause) {
		if(1<=properties.size()&&whereClause.size()>=1) {
			String queryString="update "+getEntityClass().getSimpleName()+" set "+concatMapForHQL(properties) +" where "+concatMapForHQL(whereClause," and ");
			System.out.println(queryString);
			getSession().createQuery(queryString)
			.setProperties(properties).setProperties(whereClause).executeUpdate();
		}
	}

	@Override
	public int executeUpdate(String queryString) {
		return getSession().createQuery(queryString).executeUpdate();
	}

	@Override
	public List<E> executeFind(String queryString) {
		return getSession().createQuery(queryString).setCacheable(true).list();
	}

	/**
	 * @return 获取 M 的Class类型，等于M.class
	 */
	private Class getEntityClass() {
		return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected   Session getSession() {
		Session session;
		try{
			session = sessionFactory.getCurrentSession();
		}catch (HibernateException e){
			session=sessionFactory.openSession();
		}
		session.setCacheMode(CacheMode.NORMAL);
		//事务必须是开启的，否则获取不到
		return session;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	protected Criteria addOrderCriteria(Criteria criteria){
		if (null!=order) {
			criteria.addOrder(order);
		}
		return criteria;
	}
	private String concatMapForHQL(Map<String, Object> m,String separator){
		if(null== separator) separator =",";
		List<String> keys = new ArrayList<String>(m.keySet());
		String joins = keys.get(0)+"=:"+keys.get(0);
		for (String k : keys.subList(1,keys.size()))
			joins+=separator+k+"=:"+k.trim();
		return joins;
	}
	private String concatMapForHQL(Map<String, Object> m){
		return concatMapForHQL(m,",");
	}

}
