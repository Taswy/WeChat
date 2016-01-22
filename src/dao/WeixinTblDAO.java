package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import po.WeixinTbl;

/**
 * A data access object (DAO) providing persistence and search support for
 * WeixinTbl entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * @see po.WeixinTbl
 * @author MyEclipse Persistence Tools
 */
public class WeixinTblDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(WeixinTblDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String OPENID = "openid";
	public static final String MESSAGE = "message";

	public void save(WeixinTbl transientInstance) {
		log.debug("saving WeixinTbl instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(WeixinTbl persistentInstance) {
		log.debug("deleting WeixinTbl instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WeixinTbl findById(java.lang.Integer id) {
		log.debug("getting WeixinTbl instance with id: " + id);
		try {
			WeixinTbl instance = (WeixinTbl) getSession().get("po.WeixinTbl",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(WeixinTbl instance) {
		log.debug("finding WeixinTbl instance by example");
		try {
			List results = getSession().createCriteria("po.WeixinTbl")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding WeixinTbl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from WeixinTbl as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByOpenid(Object openid) {
		return findByProperty(OPENID, openid);
	}

	public List findByMessage(Object message) {
		return findByProperty(MESSAGE, message);
	}

	public List findAll() {
		log.debug("finding all WeixinTbl instances");
		try {
			String queryString = "from WeixinTbl";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public WeixinTbl merge(WeixinTbl detachedInstance) {
		log.debug("merging WeixinTbl instance");
		try {
			WeixinTbl result = (WeixinTbl) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(WeixinTbl instance) {
		log.debug("attaching dirty WeixinTbl instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WeixinTbl instance) {
		log.debug("attaching clean WeixinTbl instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	public List search(String hsql) {
		System.out.println(hsql);
		Session session = getSession();
		List alist = null;
		try {
			alist = session.createQuery(hsql).list();
			session.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();                                                        
			throw ex;
		}
		return alist;
	}
}