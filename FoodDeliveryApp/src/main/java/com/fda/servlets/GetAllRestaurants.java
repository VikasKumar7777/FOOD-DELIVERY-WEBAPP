package com.fda.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.fda.DAOImpl.restaurantDAOImpl;
import com.fda.pojo.restaurant;
import com.fda.DAO.restaurantDAO;

/**
 * Servlet implementation class GetAllRestaurants
 */
public class GetAllRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			restaurantDAO rdao = new restaurantDAOImpl();
			List<restaurant> allrestaurantlist=rdao.fetchAll();
			req.getSession().setAttribute("restaurantList", allrestaurantlist);
			resp.sendRedirect("Home.jsp");
		}
	
}
