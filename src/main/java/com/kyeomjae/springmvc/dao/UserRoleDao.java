package com.kyeomjae.springmvc.dao;

import com.kyeomjae.springmvc.domain.UserRole;

public interface UserRoleDao {
	void add(UserRole userRole);
	UserRole get(String userId);
	void update(UserRole userRole);
}