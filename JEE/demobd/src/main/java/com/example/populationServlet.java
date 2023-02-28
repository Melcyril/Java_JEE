package com.example;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Servlet implementation class populationServlet
 */
public class populationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public populationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/formationDB");
		} catch (Exception e) {
			throw new UnavailableException(e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("/JSP/population.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			s = con.createStatement();
			rs = s.executeQuery("SELECT * FROM country WHERE population > " + request.getParameter("nbhabitant"));
			ArrayList<Pays> pays = new ArrayList<Pays>();
			while (rs.next()) {
				String nom = rs.getString("Name");
				String continent = rs.getString("Continent");
				double superficie = rs.getDouble("SurfaceArea");
				int population = rs.getInt("Population");

				pays.add(new Pays(nom, continent, superficie, population));
			}
			request.setAttribute("pays", pays);
			request.setAttribute("populationMin", request.getParameter("nbhabitant"));
			// Traitements sur le ResultSet
		} catch (SQLException e) {
			response.sendError(500, "Erreur BD " + e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		;

		request.getRequestDispatcher("/JSP/affichage_population.jsp").forward(request, response);
	}

}
