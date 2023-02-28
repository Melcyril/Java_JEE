package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class gameServlet
 */
public class gameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/JSP/jeu.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int proposition= Integer.parseInt(request.getParameter("choix"));
		HttpSession session = request.getSession(true);
		int mystere= (Integer) session.getAttribute("mystere");
		int tentatives= (Integer) session.getAttribute("tentative");
		
		tentatives=tentatives+1;
		session.setAttribute("tentative",tentatives);
		
		if(proposition<mystere)
			request.setAttribute("message", "Trop petit");
		else if(proposition>mystere)
			request.setAttribute("message", "Trop grand");
		else {
			request.setAttribute("gagne", true);
			request.setAttribute("message","bravo ! Trouvé en "+tentatives+" tentatives.");
		}
		this.getServletContext().getRequestDispatcher("/JSP/jeu.jsp").forward(request, response);
		/*String choix=request.getParameter("choix");
		int nbchoix=Integer.parseInt(choix);
	
		
		session.setAttribute("nbressai", (int) session.getAttribute("nbressai")+1);
		System.out.println(session.getAttribute("nbressai"));
		*/
	}

}
