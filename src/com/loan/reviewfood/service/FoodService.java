package com.loan.reviewfood.service;

import java.util.List;

import com.loan.reviewfood.dao.FoodDAO;
import com.loan.reviewfood.entity.Food;

public class FoodService {

	public List<Food> getAllFood(){
		FoodDAO foodDAO = new FoodDAO();
		return foodDAO.getAllFood();
	}
	
	public List<Food> getFoodByCategory(int categoryid){
		FoodDAO foodDAO = new FoodDAO();
		return foodDAO.getFoodByCategory(categoryid);
	}
	
	public List<Food> getFoodById(int id){
		FoodDAO foodDAO = new FoodDAO();
		return foodDAO.getFoodById(id);
	}
	
	public void insertFood(String image, String name, String price, String review, Integer categoryid, String address) {
		FoodDAO foodDAO = new FoodDAO();
		Food newFood = new Food();
		newFood.setImage(image);
		newFood.setName(name);
		newFood.setPrice(price);
		newFood.setReview(review);
		newFood.setCategoryid(categoryid);
		newFood.setAddress(address);
		
		foodDAO.insertFood(newFood);
	}
	
	public List<Food> findFoodByName(String textSearch){
		FoodDAO foodDAO = new FoodDAO();
		return foodDAO.findFoodByName(textSearch);
	}
	
	public void deleteFood(int id) {
		FoodDAO foodDAO = new FoodDAO();
		foodDAO.deleteFood(id);
	}
	
	public void updateFood(Integer id, String image, String name, String price, String review, Integer categoryid, String address) {
		FoodDAO foodDAO = new FoodDAO();
		
		Food food = new Food();
		food.setId(id);
		food.setImage(image);
		food.setName(name);
		food.setPrice(price);
		food.setReview(review);
		food.setCategoryid(categoryid);
		food.setAddress(address);
		
		foodDAO.updateFood(food);
	}
	
	public Food getFood(int id) {
		FoodDAO foodDAO = new FoodDAO();
		return foodDAO.findById(id);
	}
	
}
