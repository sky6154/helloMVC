package com.kyeomjae.springmvc.dao;

import java.util.List;
import com.kyeomjae.springmvc.domain.User;

public interface UserDao {
	void add(User user);
	User get(String id);
	List<User> getAll();
	void deleteAll();
	int getCount();
	void update(User user);
}