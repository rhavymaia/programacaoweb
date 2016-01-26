package br.edu.ifpb.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TesteServlet
 */
@WebServlet("/TesteServlet")
public class TesteServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String[] esportes = {"futebol", "natação"};
		
		session.setAttribute("esportes", esportes);
		
		RequestDispatcher rq = 
				request.getRequestDispatcher("index.jsp");
		rq.forward(request, response);				
	}
}
