package com.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceImpl implements ServiceInterface {
@Autowired
DaoInterfaceee dao;

@Override
public void save(User user) {
	dao.save(user);
	
}

@Override
public List<User> list() {
	return dao.list();
}

@Override
public User fetchById(int eid) {
	
	return dao.fetchUser(eid);
}


public void delete(int did) {
dao.delete(did);
}

@Override
public void update(User user) {
	dao.update(user);
}
}
