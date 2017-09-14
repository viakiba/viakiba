package com.longma.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.longma.entity.User;

@Repository
public class UserDao {
	
	public User queryUser(SessionFactory sessionFactory,User user){
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		beginTransaction.begin();
		Object object = openSession.get(User.class,user.age);
		beginTransaction.commit();
		openSession.close();
		return (User) object;
	}
	
	public void addUser(SessionFactory sessionFactory, User user){
		Session openSession = sessionFactory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		beginTransaction.begin();
		openSession.save(user);
		beginTransaction.commit();
		openSession.close();
	}
}
