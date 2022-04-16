package com.loan.reviewfood.utlis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/review_food?characterEncoding=UTF8";
	private static final String USER = "root";
	private static final String PASS = "123456789";
	
	public static Connection getConnection(){
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	return DriverManager.getConnection(URL, USER, PASS);
	} catch (SQLException | ClassNotFoundException e) {
	throw new RuntimeException("Error connecting to the database", e);
	}
	}
}
