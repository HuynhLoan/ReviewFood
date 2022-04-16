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
import com.loan.reviewfood.service.CategoryService;

/**
 * Servlet implementation class IndexAdminServlet
 */
@WebServlet("/indexAdmin")
public class IndexAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexAdminServlet() {
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
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/indexAdmin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryService = new CategoryService();
		List<Category> categories = categoryService.getName();
		request.setAttribute("categories", categories);
		
		doGet(request, response);
	}

}
