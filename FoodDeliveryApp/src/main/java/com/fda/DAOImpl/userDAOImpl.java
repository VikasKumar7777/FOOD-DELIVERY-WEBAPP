package com.fda.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fda.DAO.userDAO;
import com.fda.pojo.user;
import com.fda.util.Connections;

public class userDAOImpl implements userDAO {
	
	
	//SQL QUERIES
	private final String INSERT_QUERY="INSERT INTO `user` ( `username`, `email`, `password`, `mobile`) VALUES (?, ?,?,?)";
	private final String FETCHUSER_QUERY="SELECT * FROM `user` WHERE `uid`=?";
	private final String FETCHUSERBYEMAIL_QUERY="SELECT * FROM `user` WHERE `email`=?";
	private final String FETCHALL_QUERY="SELECT * FROM `user`";
	private final String DELETEUSER_QUERY="Delete FROM `user` WHERE `uid`=?" ;
	
	List<user> userList=new ArrayList<user>();
	
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private user user;
	private Connection con;
	

	public userDAOImpl() {
		try {
			con = Connections.connectToDb();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void insertUser(user user) {
		try {
			pstmt=con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, user.getMobile());
			int status=pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FALIED");
			}else {
				System.out.println("SUCCESS");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<user> fetchAll() {
		try {
			stmt = con.createStatement();
			resultSet=stmt.executeQuery(FETCHALL_QUERY);
			while(resultSet.next()) {
				userList.add( new user(resultSet.getInt("uid"),resultSet.getString("username"),resultSet.getString("email") , resultSet.getString("password"), resultSet.getInt("mobile")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	@Override
	public user fetchUser(int id) {
		try {
			pstmt=con.prepareStatement(FETCHUSER_QUERY);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
				user=new user(resultSet.getInt("uid"),resultSet.getString("username"),resultSet.getString("email") , resultSet.getString("password"), resultSet.getInt("mobile"));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	

	@Override
	public void deleteUser(int id) {
		try {
			pstmt=con.prepareStatement(DELETEUSER_QUERY);
			pstmt.setInt(1, id);
			int status = pstmt.executeUpdate();
			if(status == 0) {
				System.out.println("FAILED DELETING USER");
			}else {
				System.out.println("SUCCESSFULLY DELETED USER");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public user fetchUserUsingEmail(String email) {
		try {
			pstmt=con.prepareStatement(FETCHUSERBYEMAIL_QUERY);
			pstmt.setString(1, email);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
				user=new user(resultSet.getInt("uid"),resultSet.getString("username"),resultSet.getString("email") , resultSet.getString("password"), resultSet.getInt("mobile"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
