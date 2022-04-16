package com.loan.reviewfood.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loan.reviewfood.entity.Category;
import com.loan.reviewfood.service.CategoryService;

/**
 * Servlet implementation class UpdateCategoryServlet
 */
@WebServlet("/updateCategory")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		CategoryService categoryService = new CategoryService();
		Category category = categoryService.getCategory(id);
		
		request.setAttribute("category", category);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateCategory.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String categoryname = (String) request.getParameter("categoryname");
		
		CategoryService categoryService = new CategoryService();
		categoryService.updateCategory(id, categoryname);
		
		response.sendRedirect(request.getContextPath() + "/category");
	}

}
