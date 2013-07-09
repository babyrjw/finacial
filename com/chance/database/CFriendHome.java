package com.chance.database;

// Generated 2013-7-9 14:38:41 by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CFriend.
 * @see com.chance.database.CFriend
 * @author Hibernate Tools
 */
@Stateless
public class CFriendHome {

	private static final Log log = LogFactory.getLog(CFriendHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CFriend transientInstance) {
		log.debug("persisting CFriend instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CFriend persistentInstance) {
		log.debug("removing CFriend instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CFriend merge(CFriend detachedInstance) {
		log.debug("merging CFriend instance");
		try {
			CFriend result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CFriend findById(Long id) {
		log.debug("getting CFriend instance with id: " + id);
		try {
			CFriend instance = entityManager.find(CFriend.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
