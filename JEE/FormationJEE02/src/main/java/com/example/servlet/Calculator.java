package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.example.model.Operation;

/**
 * Servlet implementation class Calculator
 */
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/html/calculator.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		String nombre1 = request.getParameter("nombre1");
		String nombre2 = request.getParameter("nombre2");

		System.out.println("On est dans la servlet");
		
		float n1 = Float.parseFloat(nombre1);
		float n2 = Float.parseFloat(nombre2);
		
		float resultat = 0;
		
		if(operation.equals("add"))
			resultat = n1 + n2;
		else if(operation.equals("sub"))
			resultat = n1 - n2;
		else if(operation.equals("mul"))
			resultat = n1 * n2;
		else if(operation.equals("div"))
			resultat = n1 * n2;
		
		// On crée l'objet Operation correspondant
		Operation op = new Operation(n1, n2, operation, resultat);
		
		// On récupère la session de l'utilisateur
		HttpSession session = request.getSession(true);
		
		// On récupère dans la session l'historique des opérations (ArrayList)
		ArrayList<Operation> historique = (ArrayList<Operation>) session.getAttribute("historique");
		if(historique == null) // Cas où la session est fraichement créée
			historique = new ArrayList<Operation>();
		
		// On ajoute l'opération à l'historique
		historique.add(op);
		
		// On stocke l'historique dans la session
		session.setAttribute("historique", historique);
				
		response.getWriter().append("Résultat : ")
					.append(String.valueOf(resultat))
					.append("\n");
		
		for(Operation o : historique) {
			response.getWriter().append(o.toString()).append("\n");				
		}
		
		/*for(int i = 0 ; i < historique.size() ; i++) {
			response.getWriter().append(historique.get(i).toString()).append("\n");
		}*/
			
	}

}
