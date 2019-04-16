package com.controller;

import java.util.List;

public interface DaoInterfaceee {

	void save(User user);

	List<User> list();

	User fetchUser(int eid);

	void delete(int did);

	void update(User user);

}
