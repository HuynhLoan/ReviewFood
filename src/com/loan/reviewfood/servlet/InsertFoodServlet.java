package com.loan.reviewfood.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loan.reviewfood.service.FoodService;
import com.loan.reviewfood.utlis.FileUtil;

/**
 * Servlet implementation class InsertFoodServlet
 */
@WebServlet("/insertFood")
@MultipartConfig(
fileSizeThreshold = 1024 * 1024 * 10,
maxFileSize = 1024 * 1024 * 50,
maxRequestSize = 1024 * 1024 * 100 )
public class InsertFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/insertfood.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fileName = FileUtil.writeFile(request);
		
		String name = (String) request.getParameter("name");
		String price = (String) request.getParameter("price");
		String review = (String) request.getParameter("review");
		int categoryid = Integer.parseInt(request.getParameter("categoryid"));
		String address = (String) request.getParameter("address");
		
		FoodService foodService = new FoodService();
		foodService.insertFood(fileName, name, price, review, categoryid, address);
		
		response.sendRedirect(request.getContextPath() + "/admin");
	}

}
