package br.edu.ifpb.minhaprimeiraappweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class MeuPrimeiroServlet
 */
@WebServlet(name = "MeuPrimeiroServlet", urlPatterns = { "/MeuPrimeiroServlet" })
public class MeuPrimeiroServlet extends HttpServlet {

	private static final long serialVersionUID = 8128554850791236136L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Meu servlet tá funfando!!");

		// Parâmetros de entrada enviados pelo usuário.
		String email = request.getParameter("email");
		String senha = request.getParameter("pass");

		// Entidade
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);

		// Entidade -> Json
		Gson gson = new Gson();
		String json = gson.toJson(usuario);

		// Resposta
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.close();
	}
}
