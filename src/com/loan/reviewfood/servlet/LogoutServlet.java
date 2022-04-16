package com.loan.reviewfood.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loan.reviewfood.entity.Category;
import com.loan.reviewfood.service.CategoryService;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/login");
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
