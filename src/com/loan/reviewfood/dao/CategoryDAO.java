package com.loan.reviewfood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.loan.reviewfood.entity.Category;
import com.loan.reviewfood.utlis.DatabaseConnectionUtil;

public class CategoryDAO {

	public void insertCategory(Category category) {
		
		String sql = "INSERT INTO `category` (`categoryname`) VALUES (?)";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, category.getCategoryname());
			
			System.out.println(preparedStatement.executeUpdate());
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCategory(int id) {
		
		String deleteSql = "DELETE FROM `category` WHERE id = ?";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCategory(Category category) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSql = "UPDATE `category` SET categoryname = ? WHERE id = ? ";
		try {
			connection = DatabaseConnectionUtil.getConnection();
			
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, category.getCategoryname());
			preparedStatement.setInt(2, category.getId());
			
			System.out.println(preparedStatement.executeUpdate());
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Category> getAll(){
		ArrayList<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM `category`";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
    		ResultSet resultSet = statement.executeQuery(sql);
    		while(resultSet.next()) {
    			Category category = new Category();
    			
    			category.setId(resultSet.getInt("id"));
    			category.setCategoryname(resultSet.getString("categoryname"));
    			categories.add(category);
    		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	public ArrayList<Category> getName(){
		ArrayList<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM `category` ORDER BY `categoryname`";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Category category = new Category();
				 category.setId(resultSet.getInt("id"));
				 category.setCategoryname(resultSet.getString("categoryname"));
				 categories.add(category);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}return categories;
	}
	
	public Category findById(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnectionUtil.getConnection();
			String sql = "SELECT * FROM `category` WHERE id = "+id;
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Category category = convertToCategory(resultSet);
				return category;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Category convertToCategory(ResultSet rs) {
		Category category = new Category();
		try {
			category.setId(rs.getInt(1));
			category.setCategoryname(rs.getString(2));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}
}
