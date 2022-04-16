package com.loan.reviewfood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.loan.reviewfood.entity.User;
import com.loan.reviewfood.utlis.DatabaseConnectionUtil;

public class UserDAO {
	
	public void insertUser(User user) {
		String sql = "INSERT INTO `user`(`username`, `email`, `password`, `role`) VALUES (?, ?, ?, ?)";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			System.out.println(preparedStatement.executeUpdate());

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isUsernameExists(String username) {
		Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;
    	try {
    		connection = DatabaseConnectionUtil.getConnection();
    		String sql = "SELECT * FROM `user` WHERE `username` = '"
					+ username + "'";
    		statement = connection.prepareStatement(sql);
    		resultSet = statement.executeQuery(sql);
    		while(resultSet.next()) {
    			return true;
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
	}

	public User findByUsernameAndPassword(String username, String password) {
		Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	try {
    		connection = DatabaseConnectionUtil.getConnection();
    		String sql = "SELECT * FROM `user` WHERE username = ? AND password = ?";
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setString(1, username);
    		preparedStatement.setString(2, password);
    		resultSet = preparedStatement.executeQuery();
    		while(resultSet.next()) {
    			User user = convertToUser(resultSet);
    			return user;
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
	}
	
	public ArrayList<User> getAllUser(){
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM `user`";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				User newUser = convertToUser(resultSet);
				userList.add(newUser);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	private static User convertToUser(ResultSet rs) throws SQLException {
		
		User user = new User();
		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setPassword(rs.getString(4));
		user.setRole(rs.getString(5));
		
		return user;
	}
}
