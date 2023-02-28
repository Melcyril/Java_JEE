package com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.rmi.server.Operation;
import java.util.ArrayList;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/formulaireCalcul.html").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		float resultat=0;
		String param1=request.getParameter("nb1");		
		String param2=request.getParameter("nb2");		
		String param3=request.getParameter("operation");
		param1 = remplacerCaractere(param1, ",", ".");
	
		param2=remplacerCaractere(param2, ",", ".");

		resultat=calcul(Float.parseFloat(param1),param3,Float.parseFloat(param2));
		response.getWriter().append("Le résultat de l'opération est : "+resultat);
		operation op= new operation(param1,param2,param3,String.valueOf(resultat));
	
		HttpSession session = request.getSession(true);

		ArrayList<operation> historique = (ArrayList<operation>) session.getAttribute("historique");
		if(historique==null)	
			historique= new ArrayList<operation>();
		
		historique.add(op);
		//On stocke
		session.setAttribute("historique", historique);
		response.getWriter().append("Resultat : ").append(String.valueOf(resultat)).append("\n");
		for(operation o : historique) {
			response.getWriter().append(o.toString()).append("\n");
		}
		
		
		
		
	}
    public static String remplacerCaractere(String chaine, String caractere_a_remplacer, String new_caractere) {
        if (chaine.indexOf(caractere_a_remplacer) != -1) {
            chaine = chaine.replaceAll(caractere_a_remplacer, new_caractere);
            return chaine;
        } else {
            return chaine;
        }
    }
    public static float calcul(float nombre1, String operateur, float nombre2) {
        float resultat = 0;
        if (operateur.contains("ajout")) {
            resultat = nombre1 + nombre2;
            return resultat;
        } else if (operateur.contains("difference")) {
            resultat = nombre1 - nombre2;
            return resultat;
        } else if (operateur.contains("multiplication")) {
            resultat = nombre1 * nombre2;
            return resultat;
        } else if (operateur.contains("division") || operateur.contains(":")) {
            if (nombre2 == 0) {
                System.out.println("Diviser par 0 est impossible");
            } else {
                resultat = nombre1 / nombre2;
                return resultat;
            }
        }
        return resultat;
    }
}
