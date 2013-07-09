package com.chance.database;

// Generated 2013-7-9 14:38:41 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CUser.
 * @see com.chance.database.CUser
 * @author Hibernate Tools
 */
@Stateless
public class CUserHome {

	private static final Log log = LogFactory.getLog(CUserHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CUser transientInstance) {
		log.debug("persisting CUser instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CUser persistentInstance) {
		log.debug("removing CUser instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CUser merge(CUser detachedInstance) {
		log.debug("merging CUser instance");
		try {
			CUser result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CUser findById(Integer id) {
		log.debug("getting CUser instance with id: " + id);
		try {
			CUser instance = entityManager.find(CUser.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
