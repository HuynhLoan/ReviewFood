package com.loan.reviewfood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.loan.reviewfood.entity.Food;
import com.loan.reviewfood.utlis.DatabaseConnectionUtil;

public class FoodDAO {
	
	public void insertFood(Food food) {
		String sql = "INSERT INTO `food` (image, name, price, review, categoryid, address) VALUES (?, ?, ?, ?, ?, ?)";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, food.getImage());
			preparedStatement.setString(2, food.getName());
			preparedStatement.setString(3, food.getPrice());
			preparedStatement.setString(4, food.getReview());
			preparedStatement.setInt(5, food.getCategoryid());
			preparedStatement.setString(6, food.getAddress());
			
			System.out.println(preparedStatement.executeUpdate());
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public void deleteFood(int id) {
		
		String deleteSql = "DELETE FROM `food` WHERE id = ? ";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
    
    public void updateFood(Food food) {
    	Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSql = "UPDATE `food` SET image = ?,  name = ?, price = ?, review = ?, categoryid = ?, address = ? WHERE id = ? ";
    	try {
			connection = DatabaseConnectionUtil.getConnection();
		
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, food.getImage());
			preparedStatement.setString(2, food.getName());
			preparedStatement.setString(3, food.getPrice());
			preparedStatement.setString(4, food.getReview());
			preparedStatement.setInt(5, food.getCategoryid());
			preparedStatement.setString(6, food.getAddress());
			preparedStatement.setInt(7, food.getId());
			
			System.out.println(preparedStatement.executeUpdate());
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public Food findById(int id) {
    	Connection connection = null;
    	Statement statement = null;
    	ResultSet resultSet = null;
    	try {
    		connection = DatabaseConnectionUtil.getConnection();
    		String sql = "SELECT * FROM `food` WHERE id = "+id;
    		statement = connection.prepareStatement(sql);
    		resultSet = statement.executeQuery(sql);
    		while (resultSet.next()) {
    			Food food = convertToFood(resultSet);
    			return food;
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public ArrayList<Food> getAllFood(){
    	ArrayList<Food> foodList = new ArrayList<Food>();
    	
    	String getSql = "SELECT * FROM `food`";
    	Connection connection = DatabaseConnectionUtil.getConnection();
    	try {
    		Statement statement = connection.createStatement();
    		ResultSet resultSet = statement.executeQuery(getSql);
    		while(resultSet.next()) {
    			Food newFood = convertToFood(resultSet);
    			foodList.add(newFood);
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	return foodList;
    }
    
    public ArrayList<Food> getFoodByCategory(int categoryid){
    	ArrayList<Food> foodList = new ArrayList<Food>();
    	String sql = "SELECT * FROM `food` WHERE `categoryid` = " +categoryid ;

    	Connection connection = DatabaseConnectionUtil.getConnection();
    	try {
    		Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

    		while(resultSet.next()) {
    			
    			Food nFood = convertToFood(resultSet);
    			foodList.add(nFood);
    			
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	return foodList;
    }
    
    public ArrayList<Food> getFoodById(int id){
    	ArrayList<Food> foodList = new ArrayList<Food>();
    	String sql = "SELECT * FROM `food` WHERE `id` = " +id;
    	Connection connection = DatabaseConnectionUtil.getConnection();
    	try {
    		Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

    		while(resultSet.next()) {
    			
    			Food Foodnew = convertToFood(resultSet);
    			foodList.add(Foodnew);
    			
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
    	return foodList;
    }

	private Food convertToFood(ResultSet rs) {
		Food food = new Food();
		try {
			food.setId(rs.getInt(1));
			food.setImage(rs.getString(2));
			food.setName(rs.getString(3));
			food.setPrice(rs.getString(4));
			food.setReview(rs.getString(5));
			food.setCategoryid(rs.getInt(6));
			food.setAddress(rs.getString(7));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return food;
	}
	
	public ArrayList<Food> findFoodByName(String name){
		ArrayList<Food> foodList = new ArrayList<Food>();
		String searchSql = "SELECT * FROM `food` WHERE name LIKE '%"+name+"%' ";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(searchSql);
			while(resultSet.next()) {
				Food newFood = convertToFood(resultSet);
				foodList.add(newFood);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return foodList;
	}

}
