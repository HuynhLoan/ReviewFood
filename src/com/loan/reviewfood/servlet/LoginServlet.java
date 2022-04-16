package com.loan.reviewfood.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loan.reviewfood.entity.Category;
import com.loan.reviewfood.entity.User;
import com.loan.reviewfood.service.CategoryService;
import com.loan.reviewfood.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CategoryService categoryService = new CategoryService();
		List<Category> categories = categoryService.getName();
		request.setAttribute("categories", categories);
		
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		UserService userService = new UserService();
		User user = userService.findByUsernameAndPassword(username, password);
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("role", user.getRole());
			response.sendRedirect(request.getContextPath()+ "/homeServlet");
		}else {
			request.setAttribute("error", "Failed");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
