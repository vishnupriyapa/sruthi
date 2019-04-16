package com.controller;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements DaoInterfaceee {
@Autowired
SessionFactory sessionFactory;


public void save(User user) {
	sessionFactory.getCurrentSession().save(user);
	System.out.println("save dao");
}



public List<User> list() {
	System.out.println("list dao");
	return 	sessionFactory.getCurrentSession().createQuery("from User").list();
}



public User fetchUser(int eid) {
	
	return sessionFactory.getCurrentSession().get(User.class,eid);
}



@Override
public void delete(int did) {
	sessionFactory.getCurrentSession().load(User.class,did);	
	System.out.println("delete dao");
}



@Override
public void update(User user) {
	SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update user set Username=?,city=?,phno=? where id=?").addEntity(User.class);
	query.setParameter(0,user.getUsername());
	query.setParameter(1,user.getCity());
	query.setParameter(2,user.getPhno());
	query.setParameter(3,user.getId());
	query.executeUpdate();
	System.out.println("update dao");

	
	
}

}
