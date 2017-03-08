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
		
		// Json -> Entidade
		StringBuilder sb = lerRequestContentHTTP(request);
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(sb.toString(), Usuario.class);

		// Entidade -> Json		
		String json = gson.toJson(usuario);

		// Resposta
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.close();
	}
	
	public StringBuilder lerRequestContentHTTP(HttpServletRequest request) throws IOException {
		
		StringBuilder sb = new StringBuilder();
        String s;
        
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }
        
        return sb;
	}
}
