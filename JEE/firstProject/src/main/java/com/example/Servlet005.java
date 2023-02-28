package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet005
 */
public class Servlet005 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet005() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/Servlet005.html").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param1=request.getParameter("Nom");		
		String param2=request.getParameter("Prenom");		
		String param3=request.getParameter("Age");
		int value;
		try {
			value=Integer.parseInt(param3);
			value=value*12;
		param3=String.valueOf(value);
		}catch(NumberFormatException e) {
			value=0;
		}
		response.getWriter().append("Nom : ").append(param1.toUpperCase());
		response.getWriter().append(" Prenom : ").append(param2);
		response.getWriter().append(" Age : ").append(param3);
	}

}
