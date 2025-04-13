package com.fda.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fda.DAO.OrderHistoryDAO;
import com.fda.pojo.OrderHistory;
import com.fda.util.Connections;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
	
	
    private final String INSERT_ORDERHISTORY_QUERY = "INSERT INTO orderhistory (orderid, userid, restaurantid, total, status) VALUES (?, ?, ?, ?, ?)";
    private final String FETCH_ORDERHISTORY_BY_ID_QUERY = "SELECT * FROM orderhistory WHERE orderhistoryid = ?";
    private final String FETCH_ALL_ORDERHISTORIES_QUERY = "SELECT * FROM orderhistory";
    private final String UPDATE_ORDERHISTORY_QUERY = "UPDATE orderhistory SET orderid = ?, userid = ?, restaurantid = ?, total = ?, status = ? WHERE orderhistoryid = ?";
    private final String DELETE_ORDERHISTORY_QUERY = "DELETE FROM orderhistory WHERE orderhistoryid = ?";
    
    
	private PreparedStatement pstmt;
	private int status;
	private ResultSet resultSet;
	private OrderHistory orderHistory;
	private Statement stmt;
	private List<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();
	private Connection con;
	
	public OrderHistoryDAOImpl() {
		try {
			con = Connections.connectToDb();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		try {
			pstmt=con.prepareStatement(INSERT_ORDERHISTORY_QUERY);
            pstmt.setInt(1, orderHistory.getOrderId());
            pstmt.setInt(2, orderHistory.getUserId());
            pstmt.setInt(3, orderHistory.getRestaurantId());
            pstmt.setInt(4, orderHistory.getTotal());
            pstmt.setString(5, orderHistory.getStatus());
			status=pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FAILED ADDING ORDERHISTORY");
			}else {
				System.out.println("SUCCESSFULLY ADDED A NEW ORDERHISTORY");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderHistory getOrderHistoryById(int orderHistoryId) {
		try {
			pstmt=con.prepareStatement(FETCH_ORDERHISTORY_BY_ID_QUERY);
			pstmt.setInt(1, orderHistoryId);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
                orderHistory = new OrderHistory(
                		resultSet.getInt("orderhistoryid"),
                		resultSet.getInt("orderid"),
                		resultSet.getInt("userid"),
                		resultSet.getInt("restaurantid"),
                		resultSet.getInt("total"),
                		resultSet.getString("status")
                    );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderHistory;
	}

	@Override
	public List<OrderHistory> getAllOrderHistories() {
		try {
			stmt = con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_ORDERHISTORIES_QUERY);
			while(resultSet.next()) {
				orderHistoryList .add(new OrderHistory(
						resultSet.getInt("orderhistoryid"),
						resultSet.getInt("orderid"),
						resultSet.getInt("userid"),
						resultSet.getInt("restaurantid"),
						resultSet.getInt("total"),
						resultSet.getString("status")
	                ));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderHistoryList;
	}

	@Override
	public boolean updateOrderHistory(OrderHistory orderHistory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		try {
			pstmt = con.prepareStatement(DELETE_ORDERHISTORY_QUERY);
			pstmt.setInt(1, orderHistoryId);
			status = pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FAILED DELETING ORDERHISTORY");
			}else {
				System.out.println("SUCCESSFULLY DELETED ORDERHISTORY");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
