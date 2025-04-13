package com.fda.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fda.util.Connections;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.fda.DAOImpl.userDAOImpl;
import com.fda.pojo.user;
import com.fda.DAO.userDAO;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//fetching email and password from user login form
		String userEmail = req.getParameter("Email");
		String userPassword =req.getParameter("Password");
		
		//validation user details with db data
		userDAO userDAO = new userDAOImpl();
		user userData = userDAO.fetchUserUsingEmail(userEmail);
		if(userData != null) {
			System.out.println("user exists");
			if(userData.getPassword().equals(userPassword)) {
				System.out.println("password correct");
				 req.getSession().setAttribute("loggedInUser", userData); 
				 resp.sendRedirect("GetAllRestaurants");

				 
			}else {
				System.out.println("password wrong");
			}
		}else {
			System.out.println("email doesnt exists");
		}
		
		
	}
	

}
