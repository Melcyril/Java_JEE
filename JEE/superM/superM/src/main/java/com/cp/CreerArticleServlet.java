package com.cp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
/**
 * Servlet implementation class CreerArticleServlet
 */
public class CreerArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
	
		request.getServletContext().getRequestDispatcher("/JSP/creerArticle.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession(true);
		HttpSession session = request.getSession(true);
		String codebarreSTR=request.getParameter("code");
		String ref=(String) request.getParameter("ref");
		String libelle=(String) request.getParameter("lib");
		String prixSTR =  request.getParameter("prixht");
		String indicetvaSTR= request.getParameter("tva");
		Long codebarre=Long.parseLong(codebarreSTR);
		int prix=Integer.parseInt(prixSTR);
		int indice=Integer.parseInt(indicetvaSTR);
		System.out.println(codebarreSTR);
		 ArrayList<Article> listarticles = new ArrayList<Article>();
		//List<Article> articles = (ArrayList<Article>)request.getAttribute("article");
		Article newarticle=new Article(codebarre,ref,libelle,prix,indice);
		//ArrayList<Article> article = (ArrayList<Article>) session.getAttribute("article");
		try {
		 for(Article p :((ArrayList<Article>)session.getAttribute("article"))){
			 if(codebarre==p.getCodebarre()) {
				 String erreur="";
				 session.setAttribute("erreur", erreur);
				 
			 }
		 }
		 if(session.getAttribute("erreur") != null) {
			 session.removeAttribute("erreur");
			 request.getServletContext().getRequestDispatcher("/JSP/creerArticle.jsp").forward(request, response);
		 }else {
			 listarticles.add(newarticle);
		 	session.setAttribute("newarticle",listarticles);
		 	request.getServletContext().getRequestDispatcher("/InitServlet").forward(request, response);
			
		 }
		}catch(Exception e) {
			
		}
		
	   
	    //request.setAttribute("article",articles);

	
	
		
		

		
		//h.put(j.getCodebarre(), j);
		//request.setAttribute("article", h);

		
	}

}
