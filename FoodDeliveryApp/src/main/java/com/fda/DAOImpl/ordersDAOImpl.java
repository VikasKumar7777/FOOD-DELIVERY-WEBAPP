package com.fda.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fda.DAO.ordersDAO;
import com.fda.pojo.orders;
import com.fda.util.Connections;

public class ordersDAOImpl implements ordersDAO {

	private final String INSERT_ORDER_QUERY = "INSERT INTO `orders` (`userid`, `restaurantid`, `menuid`, `quantity`, `total`, `paymentmode`, `date&time`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String FETCH_ORDER_BY_ID_QUERY = "SELECT * FROM `orders` WHERE `orderid` = ?";
	private final String FETCH_ALL_ORDERS_QUERY = "SELECT * FROM `orders`";
	private final String DELETE_ORDER_QUERY = "DELETE FROM `orders` WHERE `orderid` = ?";
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private ResultSet resultSet;
	private orders orders;
	private Statement stmt;
	private List<orders> ordersList = new ArrayList<orders>();


	public ordersDAOImpl() {
		try {
			con=Connections.connectToDb();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addOrder(orders orders) {
        try {
            pstmt = con.prepareStatement(INSERT_ORDER_QUERY);
            pstmt.setInt(1, orders.getUserId());
            pstmt.setInt(2, orders.getRestaurantId());
            pstmt.setInt(3, orders.getMenuId());
            pstmt.setInt(4, orders.getQuantity());
            pstmt.setInt(5, orders.getTotal());
            pstmt.setString(6, orders.getPaymentMode());
            pstmt.setTimestamp(7, Timestamp.valueOf(orders.getDateTime()));
            pstmt.setString(8, orders.getStatus());
			status=pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FAILED ADDING ORDER");
			}else {
				System.out.println("SUCCESSFULLY ADDED A NEW ORDER");
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public orders getOrderById(int orderId) {
		try {
			pstmt=con.prepareStatement(FETCH_ORDER_BY_ID_QUERY);
			pstmt.setInt(1, orderId);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
				orders = new orders(
						resultSet.getInt("userid"),
						resultSet.getInt("restaurantid"),
						resultSet.getInt("menuid"),
						resultSet.getInt("quantity"),
						resultSet.getInt("total"),
						resultSet.getString("paymentmode"),
						resultSet.getTimestamp("date&time").toLocalDateTime(),
						resultSet.getString("status")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<orders> getAllOrders() {
		try {
			stmt = con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_ORDERS_QUERY);
			while(resultSet.next()) {
				ordersList.add(new orders(
						resultSet.getInt("orderId"),
						resultSet.getInt("userid"),
						resultSet.getInt("restaurantid"),
						resultSet.getInt("menuid"),
						resultSet.getInt("quantity"),
						resultSet.getInt("total"),
						resultSet.getString("paymentmode"),
						resultSet.getTimestamp("date&time").toLocalDateTime(),
						resultSet.getString("status")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	@Override
	public boolean updateOrder(orders orders) {
		return false;
	}

	@Override
	public void deleteOrder(int orderId) {
		try {
			pstmt = con.prepareStatement(DELETE_ORDER_QUERY);
			pstmt.setInt(1, orderId);
			int status = pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FAILED DELETING ORDER");
			}else {
				System.out.println("SUCCESSFULLY DELETED ORDER");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
