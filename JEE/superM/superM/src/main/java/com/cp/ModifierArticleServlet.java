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
 * Servlet implementation class ModifierArticleServlet
 */
public class ModifierArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
	
		request.getServletContext().getRequestDispatcher("/JSP/modifierArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String codebarreSTR=request.getParameter("code");
		String ref=(String) request.getParameter("ref");
		String libelle=(String) request.getParameter("lib");
		String prixSTR =  request.getParameter("prixht");
		String indicetvaSTR= request.getParameter("tva");
		Long codebarre=Long.parseLong(codebarreSTR);
		int prix=Integer.parseInt(prixSTR);
		int indice=Integer.parseInt(indicetvaSTR);

		
		 for(Article a :((ArrayList<Article>)session.getAttribute("article"))){
			 if(codebarre==a.getCodebarre()) {
				 a.setLibelle(libelle);
				 a.setReference(ref);
				 a.setPrixHT(prix);
				 if(indicetvaSTR.equals("0")) {
					 a.setTVA(550);
				 }else if(indicetvaSTR.equals("1")){
					 a.setTVA(2000);
				 }
				 request.getServletContext().getRequestDispatcher("/JSP/modifierArticle.jsp").forward(request, response);
			 }else {
				 System.out.println("erreur");
			 }
			
		 }
	}

}
