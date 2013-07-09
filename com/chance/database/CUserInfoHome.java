package com.chance.database;

// Generated 2013-7-9 14:38:41 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CUserInfo.
 * @see com.chance.database.CUserInfo
 * @author Hibernate Tools
 */
@Stateless
public class CUserInfoHome {

	private static final Log log = LogFactory.getLog(CUserInfoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CUserInfo transientInstance) {
		log.debug("persisting CUserInfo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CUserInfo persistentInstance) {
		log.debug("removing CUserInfo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CUserInfo merge(CUserInfo detachedInstance) {
		log.debug("merging CUserInfo instance");
		try {
			CUserInfo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CUserInfo findById(Integer id) {
		log.debug("getting CUserInfo instance with id: " + id);
		try {
			CUserInfo instance = entityManager.find(CUserInfo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
