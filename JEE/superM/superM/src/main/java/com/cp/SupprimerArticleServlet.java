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
 * Servlet implementation class SupprimerArticleServlet
 */
public class SupprimerArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getServletContext().getRequestDispatcher("/JSP/supprimerArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String codebarreSTR=request.getParameter("code");
		Long codebarre=Long.parseLong(codebarreSTR);
;

		ArrayList<Article> article = new ArrayList<Article>();
		int i=0;
		 for(Article a :((ArrayList<Article>)session.getAttribute("article"))){
			 
			 if(codebarre!=a.getCodebarre()) {
				 article.add(a);
			 }
		 i++;
		 }
		 session.removeAttribute("article");
		 session.setAttribute("article", article);
		 request.getServletContext().getRequestDispatcher("/JSP/supprimerArticle.jsp").forward(request, response);
	}

}
