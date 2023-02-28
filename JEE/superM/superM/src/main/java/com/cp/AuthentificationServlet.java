package com.cp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Servlet implementation class AuthentificationServlet
 */
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		request.getServletContext().getRequestDispatcher("/JSP/authentification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Utilisateur
		String[] tableau_user= {"user1","user2"};
		String[] tableau_mdp= {"user1","user2"};
		HttpSession session = request.getSession(true);
		String login=request.getParameter("username");
		String mdp=(String) request.getParameter("password");
		if(login.equals("admin")&&mdp.equals("admin")){
			session.setAttribute("login", login);
			session.setAttribute("niveau", 0);
			request.getServletContext().getRequestDispatcher("/InitServlet").forward(request, response);
		}else {
			for(int i=0;i<tableau_user.length;i++) {		
					if(tableau_user[i].equals(login)) {						
						if(tableau_mdp[i].equals(mdp)) {
							session.setAttribute("login", login);
							
							request.getServletContext().getRequestDispatcher("/InitServlet").forward(request, response);
						}
					}else {
						
						request.getServletContext().getRequestDispatcher("/JSP/authentification.jsp").forward(request, response);
					}
				
			}
		}
	}

}
