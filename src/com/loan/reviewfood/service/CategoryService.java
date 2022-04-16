package com.loan.reviewfood.service;

import java.util.List;

import com.loan.reviewfood.dao.CategoryDAO;
import com.loan.reviewfood.entity.Category;

public class CategoryService {

	public List<Category> getAll(){
		CategoryDAO categoryDao = new CategoryDAO();
		return categoryDao.getAll();
	}
	
	public List<Category> getName(){
		CategoryDAO categoryDAO = new CategoryDAO();
		return categoryDAO.getName();
	}
	
	public void insertCategory(String categoryname) {
		CategoryDAO categoryDAO = new CategoryDAO();
		Category newCategory = new Category();
		newCategory.setCategoryname(categoryname);
		
		categoryDAO.insertCategory(newCategory);
	}
	
	public void deleteCategory(int id) {
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.deleteCategory(id);
	}
	
	public void updateCategory(Integer id, String categoryname) {
		CategoryDAO categoryDAO = new CategoryDAO();
		
		Category category = new Category();
		category.setId(id);
		category.setCategoryname(categoryname);
		
		categoryDAO.updateCategory(category);
	}
	
	public Category getCategory(int id) {
		CategoryDAO categoryDAO = new CategoryDAO();
		return categoryDAO.findById(id);
	}
}
