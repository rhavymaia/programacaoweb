package br.edu.ifpb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.dao.PessoaDAO;
import br.edu.ifpb.entidade.Pessoa;

/**
 * Servlet implementation class CadastrarPessoaServlet
 */
@WebServlet("/CadastrarPessoaServlet")
public class CadastrarPessoaServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// Cadastro de Pessoa.
			Pessoa pessoa = new Pessoa();
			pessoa.setNome("José");
			pessoa.setEndereco("Rua das Alamedas, 501 - Campina Grande - Paraíba");
			
			Integer id = PessoaDAO.getInstance().insert(pessoa);
			pessoa.setId(id);
			
			request.setAttribute("pessoa", pessoa);
			
			RequestDispatcher rq = request.getRequestDispatcher("pessoa.jsp");
			rq.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
