package com.loan.reviewfood.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loan.reviewfood.entity.Category;
import com.loan.reviewfood.entity.Food;
import com.loan.reviewfood.service.CategoryService;
import com.loan.reviewfood.service.FoodService;

/**
 * Servlet implementation class GetFoodByCategory
 */
@WebServlet("/getFoodByCategory")
public class GetFoodByCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFoodByCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryService categoryService = new CategoryService();
		List<Category> categories = categoryService.getName();
		request.setAttribute("categories", categories);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		FoodService foodService = new FoodService();
		List<Food> foods = foodService.getFoodByCategory(id);
		
		request.setAttribute("foods", foods);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/getfoodbycategory.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryService categoryService = new CategoryService();
		List<Category> categories = categoryService.getName();
		request.setAttribute("categories", categories);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/getfoodbycategory.jsp");
		dispatcher.forward(request, response);
	}

}
