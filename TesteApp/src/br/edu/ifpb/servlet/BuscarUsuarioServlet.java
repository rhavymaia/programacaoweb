package br.edu.ifpb.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuscarUsuarioServlet
 */
@WebServlet("/BuscarUsuarioServlet")
public class BuscarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		String[] disciplinas = getDisciplinas(Integer.valueOf(id));
		
		request.setAttribute("disciplinas", disciplinas);
		
		double valor = 1.0;
		request.setAttribute("valor", valor);
		
		RequestDispatcher rq = request.getRequestDispatcher("disciplinas.jsp");
		rq.forward(request, response);
	}
	
	private String[] getDisciplinas(Integer id) {
		
		Map alunos = new HashMap<Integer, String[]>();
		
		String[] disciplinas1 = {"matemática", "programação web"};
		String[] disciplinas2 = {"Inglês", "programação móvel"};
		
		alunos.put(1, disciplinas1);
		alunos.put(2, disciplinas2);
		
		return (String[]) alunos.get(id);
	}

}
