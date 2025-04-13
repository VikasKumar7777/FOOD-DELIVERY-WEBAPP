package com.fda.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fda.DAO.OrderItemsDAO;
import com.fda.pojo.OrderItems;
import com.fda.pojo.restaurant;
import com.fda.util.Connections;

public class OrderItemsDAOImpl implements OrderItemsDAO{
	
	
    private final String INSERT_ORDERITEMS_QUERY = "INSERT INTO orderitems (ordersid, menuid, quantity, itemtotal) VALUES (?, ?, ?, ?)";
    private final String FETCH_ORDERITEM_BY_ID_QUERY = "SELECT * FROM orderitems WHERE orderitemsid = ?";
    private final String FETCH_ALL_ORDERITEMS_QUERY = "SELECT * FROM orderitems";
    private final String UPDATE_ORDERITEM_QUERY = "UPDATE orderitems SET ordersid = ?, menuid = ?, quantity = ?, itemtotal = ? WHERE orderitemsid = ?";
    private final String DELETE_ORDERITEM_QUERY = "DELETE FROM orderitems WHERE orderitemsid = ?";
    
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private int status;
	private ResultSet resultSet;
	private OrderItems orderitem;
	private List<OrderItems> orderitemsList= new ArrayList<OrderItems>();
	
	public OrderItemsDAOImpl() {
		try {
			con=Connections.connectToDb();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderItem(OrderItems orderItem) {
       try {
		pstmt = con.prepareStatement(INSERT_ORDERITEMS_QUERY);
		pstmt.setInt(1, orderItem.getOrdersId());
		pstmt.setInt(2, orderItem.getMenuId());
		pstmt.setInt(3, orderItem.getQuantity());
		pstmt.setInt(4, orderItem.getItemTotal());
		status=pstmt.executeUpdate();
		if(status == 0) {
			System.out.println("FAILED ADDING ORDERITEM");
		}else {
			System.out.println("SUCCESSFULLY ADDED A NEW ORDERITEM");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	@Override
	public OrderItems getOrderItemById(int orderItemsId) {
		try {
			pstmt=con.prepareStatement(FETCH_ORDERITEM_BY_ID_QUERY);
			pstmt.setInt(1, orderItemsId);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
				orderitem = new OrderItems(
						resultSet.getInt("orderitemsid"),
						resultSet.getInt("ordersid"),
						resultSet.getInt("menuid"),
						resultSet.getInt("quantity"),
						resultSet.getInt("itemtotal")
	                );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderitem;
	}

	@Override
	public List<OrderItems> getAllOrderItems() {
		try {
			stmt = con.createStatement();
			resultSet=stmt.executeQuery(FETCH_ALL_ORDERITEMS_QUERY);
			while(resultSet.next()) {
				orderitemsList.add(new OrderItems(
						resultSet.getInt("orderitemsid"),
						resultSet.getInt("ordersid"),
						resultSet.getInt("menuid"),
						resultSet.getInt("quantity"),
	                    resultSet.getInt("itemtotal")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderitemsList;
	}

	@Override
	public boolean updateOrderItem(OrderItems orderItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteOrderItem(int orderItemsId) {
		try {
			pstmt = con.prepareStatement(DELETE_ORDERITEM_QUERY);
			pstmt.setInt(1, orderItemsId);
			int status = pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FAILED DELETING ORDERITEM");
			}else {
				System.out.println("SUCCESSFULLY DELETED ORDERITEM");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
