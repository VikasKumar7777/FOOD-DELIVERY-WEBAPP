package com.fda.servlets;

import java.io.IOException;

import com.fda.pojo.user;
import com.fda.DAO.userDAO;
import com.fda.DAOImpl.userDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signupUsername=req.getParameter("username");
		int signupMobile =Integer.parseInt(req.getParameter("mobilenumber"));
		String signupEmail = req.getParameter("Email");
		String signupPassword= req.getParameter("Password");
		
		user user = new user(signupUsername,signupEmail,signupPassword,signupMobile);
		userDAO userdao = new userDAOImpl();
		
		userdao.insertUser(user);
		
		req.getRequestDispatcher("UserLogin").forward(req, resp);
	}
}
