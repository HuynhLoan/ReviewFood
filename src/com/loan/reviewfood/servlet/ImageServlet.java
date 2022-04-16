package com.loan.reviewfood.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loan.reviewfood.utlis.FileUtil;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/image")
@MultipartConfig(
fileSizeThreshold = 1024 * 1024 * 10,
maxFileSize = 1024 * 1024 * 50,
maxRequestSize = 1024 * 1024 * 100 )
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imageName = request.getParameter("imageName");
		
		FileInputStream fis =FileUtil.readImage(imageName);
		
		if(fis != null) {
			
			int b = 0;
			while((b = fis.read()) != -1) {
				response.getOutputStream().write(b);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileUtil.writeFile(request);
		
		response.sendRedirect(request.getContextPath() + "/homeServlet");
	}

}
