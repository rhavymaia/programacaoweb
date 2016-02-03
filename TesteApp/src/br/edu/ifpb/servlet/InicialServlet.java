package br.edu.ifpb.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.dao.PessoaDAO;
import br.edu.ifpb.entidade.Pessoa;

/**
 * Servlet implementation class InicialServlet
 */
@WebServlet("/InicialServlet")
public class InicialServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
				
		try {
			
			Pessoa pessoa1 = new Pessoa(1, "Matheus Vasconcelos", "Endereço");		
			PessoaDAO pessoaDao = PessoaDAO.getInstance();
			pessoaDao.insert(pessoa1);
			
			PessoaDAO.getInstance().insert(pessoa1);		
		
			Pessoa pessoa2 = new Pessoa(2, "Juan Barros", "Endereço");
			PessoaDAO.getInstance().insert(pessoa2);
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			pessoas.add(pessoa1);
			pessoas.add(pessoa2);
			
			request.setAttribute("pessoas", pessoas);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher rq = request.getRequestDispatcher("index.jsp");
		rq.forward(request, response);
	}

}
