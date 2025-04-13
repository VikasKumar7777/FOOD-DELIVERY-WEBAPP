package com.fda.DAO;

import java.util.List;

import com.fda.pojo.user;

public interface userDAO {
	void insertUser(user user);
	List<user> fetchAll();
	user fetchUser(int id);
	user fetchUserUsingEmail(String email);
	void deleteUser(int id);
}
