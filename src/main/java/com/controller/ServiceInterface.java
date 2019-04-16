package com.controller;

import java.util.List;

public interface ServiceInterface {

	void save(User user);

	List<User> list();

	User fetchById(int eid);

	void delete(int did);

	void update(User user);

}
