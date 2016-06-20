package haust.vk.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author vk
 *
 * 2016年6月20日
 */
public class HibernateUtils {
	private static SessionFactory sf;
	
	static{
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession(){
		return sf.openSession();
	}
}
