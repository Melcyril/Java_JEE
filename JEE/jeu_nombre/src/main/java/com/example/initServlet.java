package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class initServlet
 */
public class initServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		this.getServletContext().getRequestDispatcher("/JSP/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Random random = new Random();
		//nombre alea de 1 à 100 random.nextInt(max)+min;

		int nombreAleatoire=1 + (int)(Math.random() * ((Integer.parseInt(request.getParameter("difficulte")) - 1) + 1));
		System.out.println(nombreAleatoire);
		//Recupération la session
		HttpSession session = request.getSession(true);
		session.setAttribute("mystere", nombreAleatoire);
		
		session.setAttribute("tentative", 0);
		//System.out.println(session.getAttribute("nbressai"));
		//On passe la main a une servlet
		this.getServletContext().getRequestDispatcher("/JSP/jeu.jsp").forward(request,response);
	}
}
