package com.fda.check;

import com.fda.DAOImpl.userDAOImpl;
import com.fda.pojo.user;

import com.fda.DAO.userDAO;

public class dbcheck {
	public static void main(String[] args) {
		user u1=new user("test","test","test",123);
		userDAO udao=new userDAOImpl();
		udao.deleteUser(8);;
	}

}
