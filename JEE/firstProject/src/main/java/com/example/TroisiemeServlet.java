package com.example;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TroisiemeServlet
 */
public class TroisiemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TroisiemeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
