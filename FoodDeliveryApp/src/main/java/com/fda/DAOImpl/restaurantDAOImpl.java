package com.fda.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fda.DAO.restaurantDAO;
import com.fda.pojo.restaurant;
import com.fda.pojo.user;
import com.fda.util.Connections;

public class restaurantDAOImpl implements restaurantDAO {
	
	//SQL QUERIES
	private final String INSERT_QUERY = "INSERT INTO `restaurant` (`name`, `cusineType`, `address`, `ratings`, `deliverytime`, `isActive`) VALUES (?, ?, ?, ?, ?, ?)";
	private final String FETCH_RESTAURANT_QUERY = "SELECT * FROM `restaurant` WHERE `restaurantId` = ?";
	private final String FETCH_ALL_QUERY = "SELECT * FROM `restaurant`";
	private final String DELETE_RESTAURANT_QUERY = "DELETE FROM `restaurant` WHERE `restaurantId` = ?";
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;
	private List<restaurant> restaurantList=new ArrayList<restaurant>();
	private restaurant restaurant;

	public restaurantDAOImpl() {
		try {
			con=Connections.connectToDb();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public void insertRestaurant(restaurant restaurant) {
		try {
			pstmt=con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getCusineType());
			pstmt.setString(3, restaurant.getAddress());
			pstmt.setInt(4, restaurant.getRating());
			pstmt.setInt(5, restaurant.getDeliveryTime());
			pstmt.setInt(6, restaurant.getIsActive());
			status=pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FAILED ADDING RESTAURANT");
			}else {
				System.out.println("SUCCESSFULLY ADDED A NEW RESTAURANT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<restaurant> fetchAll() {
		try {
			stmt = con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_QUERY);
			while(resultSet.next()) {
				restaurantList.add(new restaurant(resultSet.getInt("restaurantId"),resultSet.getString("name"),resultSet.getString("cusineType") , resultSet.getString("address"), resultSet.getInt("ratings"),resultSet.getInt("deliverytime"),resultSet.getInt("isActive"),resultSet.getBytes("image")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurantList;
	}


	@Override
	public restaurant fetchRestaurant(int id) {
		try {
			pstmt=con.prepareStatement(FETCH_RESTAURANT_QUERY);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
				restaurant = new restaurant(resultSet.getInt("restaurantId"),resultSet.getString("name"),resultSet.getString("cusineType") , resultSet.getString("address"), resultSet.getInt("ratings"),resultSet.getInt("deliverytime"),resultSet.getInt("isActive"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}


	@Override
	public void deleteRestaurant(int id) {
		try {
			pstmt = con.prepareStatement(DELETE_RESTAURANT_QUERY);
			pstmt.setInt(1, id);
			int status = pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FAILED DELETING RESTAURANT");
			}else {
				System.out.println("SUCCESSFULLY DELETED RESTAURANT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
