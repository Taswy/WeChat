package util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import po.HibernateSessionFactory;
import po.WeixinTbl;
import dao.WeixinTblDAO;

public class DataUtil {
	public static String find(String openid){
		return findWeixin(openid).getMessage();
	}
	public static WeixinTbl findWeixin(String openid){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		WeixinTblDAO dao = new WeixinTblDAO();
		WeixinTbl result = null;
		List<WeixinTbl> list = dao.findByOpenid(openid);
		for( WeixinTbl weixin : list){
			result = weixin;
			session.flush();
			session.clear();
		}
		session.close();
		return result;
	}
	
	public static boolean changeByOpenid(String openid,String lastData){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		WeixinTblDAO dao = new WeixinTblDAO();
		List<WeixinTbl> list = dao.findByOpenid(openid);
		for(WeixinTbl weixin : list){
			weixin.setMessage(lastData);
			
			session.save(weixin);
			session.flush();
			session.clear();
			tx.commit();
		}
		session.close();
		return true;
	}
	public static boolean changeById(Integer id,String lastData){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		WeixinTblDAO dao = new WeixinTblDAO();
		WeixinTbl weixin = dao.findById(id);
			weixin.setMessage(lastData);
			session.save(weixin);
			session.flush();
			session.clear();
			tx.commit();
		session.close();
		return true;
	}
}
