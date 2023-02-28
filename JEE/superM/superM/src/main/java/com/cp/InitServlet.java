package com.cp;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;






/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);

		Article a1=new Article(1000,"sh50","Steack haché",500,1);
		Article a2=new Article(2000,"pas70","Casserole",2000,0);
		
		/*
	   System.out.println(a1.getCodebarre()+" "+a1.getReference()+" "+a1.getLibelle()+" "+a1.getPrixHT()+a1.getTVA());
		request.setAttribute("articlec",a1.getCodebarre());
		request.setAttribute("articler",a1.getReference());
		request.setAttribute("articlel",a1.getLibelle());
		request.setAttribute("articlep",a1.getPrixHT());
		request.setAttribute("articlet",a1.getTVA());
		*/
	    ArrayList<Article> article = (ArrayList<Article>) session.getAttribute("article");
		if(article==null) {	
			article= new ArrayList<Article>();
	    	article.add(a1);
	    	article.add(a2);
	    	 session.setAttribute("article", article);
		}else if ((ArrayList<Article>)session.getAttribute("newarticle") != null){
			article.addAll((ArrayList<Article>)session.getAttribute("newarticle"));
			session.setAttribute("article",article );
			session.removeAttribute("newarticle");
		}
	   
	    /*
	    if ((ArrayList<Article>)request.getAttribute("newarticle") != null){
	    	article.addAll((ArrayList<Article>)request.getAttribute("newarticle"));
	    	 request.setAttribute("article",article);
	    }else {
	    	 request.setAttribute("article",article);
	    }
	   */
	
	    
	

	    
	   request.getServletContext().getRequestDispatcher("/JSP/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
