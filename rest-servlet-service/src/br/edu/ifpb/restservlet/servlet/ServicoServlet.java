package br.edu.ifpb.restservlet.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class ServicoServlet
 */
@WebServlet("/servicoservlet")
public class ServicoServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer stringBuffer = new StringBuffer();
		String line = null;

		// Leitura do conteúdo do pacote da requisição HTTP.
		BufferedReader reader = request.getReader();
		
		while ((line = reader.readLine()) != null) {
			stringBuffer.append(line);
		}
			
		// Conversão para JSONObject
		JSONObject json = new JSONObject(stringBuffer.toString());
		
		String nome = json.getString("nome");
		String senha = json.getString("senha");		

		PrintWriter pw = response.getWriter();
		
		if (nome.toLowerCase().trim().equals("fulano") 
				&& senha.trim().equals("123")) {			
			
			try {
				
				pw.write("{'key': '" + criptografarSha256("IFPB") + "'}");
				response.setStatus(200);
				
			} catch (NoSuchAlgorithmException e) {
				
				e.printStackTrace();
			}			
			
		} else {
			
			response.setStatus(500);
			pw.write("{'mensagem': 'Usuário ou senha incorretos'}");
		}	

		pw.close();
	}
	
	public static String criptografarSha256(String valorPlano)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(valorPlano.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();

		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}

		String senha = hexString.toString();

		return senha;
	}
}
