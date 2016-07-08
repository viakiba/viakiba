package haust.vk.c_many2many;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App_inverse {
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Project.class)   
			.addClass(Developer.class)   // 测试时候使用
			.buildSessionFactory();
	}

	// 多对多
	//1. 设置inverse属性，对保存数据影响?
	// 有影响。
	// inverse=false ，有控制权，可以维护关联关系； 保存数据的时候会把对象关系插入中间表；
	// inverse=true,  没有控制权， 不会往中间表插入数据。
	@Test
	public void save() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		/*
		 * 模拟数据： 
			电商系统（曹吉，王春）
			OA系统（王春，老张）
		 */
		// 创建项目对象
		Project prj_ds = new Project();
		prj_ds.setPrj_name("电商系统");
		Project prj_oa = new Project();
		prj_oa.setPrj_name("OA系统");
		
		// 创建员工对象
		Developer dev_cj = new Developer();
		dev_cj.setD_name("曹吉");
		Developer dev_wc = new Developer();
		dev_wc.setD_name("王春");
		Developer dev_lz = new Developer();
		dev_lz.setD_name("老张");
		// 关系 【项目方】
		prj_ds.getDevelopers().add(dev_cj);
		prj_ds.getDevelopers().add(dev_wc); // 电商系统（曹吉，王春）
		prj_oa.getDevelopers().add(dev_wc);
		prj_oa.getDevelopers().add(dev_lz); // OA系统（王春，老张）
		
		
		// 保存
//		session.save(dev_cj);
//		session.save(dev_wc);
//		session.save(dev_lz);
		
		session.save(prj_ds);
		session.save(prj_oa);   // 必须要设置级联保存 
		
		session.getTransaction().commit();
		session.close();
	}
	
	//2 .设置inverse属性， 对获取数据影响？  无
	@Test
	public void get() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project prj = (Project) session.get(Project.class, 1);
		System.out.println(prj.getPrj_name());
		System.out.println(prj.getDevelopers());
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	//3. 设置inverse属性， 对解除关系影响？
	// 有影响。
	// inverse=false ,有控制权， 解除关系就是删除中间表的数据。
	// inverse=true, 没有控制权，不能解除关系。
	@Test
	public void removeRelation() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project prj = (Project) session.get(Project.class, 7);
		prj.getDevelopers().clear();
		
		session.getTransaction().commit();
		session.close();
	}
	
	

	//3. 设置inverse属性，对删除数据的影响?
	// inverse=false, 有控制权。 先删除中间表数据，再删除自身。
	// inverse=true, 没有控制权。 如果删除的数据有被引用，会报错！ 否则，才可以删除
	@Test
	public void deleteData() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project prj = (Project) session.get(Project.class, 1);
		session.delete(prj);
		
		session.getTransaction().commit();
		session.close();
	}
}
