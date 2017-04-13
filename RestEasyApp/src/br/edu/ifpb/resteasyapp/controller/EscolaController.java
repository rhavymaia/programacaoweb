package br.edu.ifpb.resteasyapp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.ifpb.resteasyapp.dao.EscolaDAO;
import br.edu.ifpb.resteasyapp.entidade.Escola;

@Path("escola")
public class EscolaController {

	/**
	 * Cadastrar a Escola.
	 * 
	 * @param escola
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/inserir")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Escola escola) {
		
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		try {
			
			// Regra de negócio e manipulação de dados nesse ponto.
			int idEscola = EscolaDAO.getInstance().insert(escola);
			
			escola.setId(idEscola);
			
			// As informaçãos devem ser associadas nesse ponto ao build (response).
			builder.status(Response.Status.OK).entity(escola);
		
		} catch (SQLException e) {
			
			// Tratar a exceção.
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		// Resposta.
		return builder.build();
	}
	
	/**
	 * Listar todos as Escolas.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Escola> getAll() {
		
		// Retorno em formato de lista.
		// Desse modo o response sempre conterá o código de resposta OK.
		List<Escola> escolas = new ArrayList<Escola>();
		
		try {
			
			// Regra de negócio e manipulação de dados nesse ponto.
			escolas = EscolaDAO.getInstance().getAll();
		
		} catch (SQLException e) {
			
			// Tratar a exceção.
		}
		
		// Será retornado ao cliente um conjunto de alunos no formato de Json.
		return escolas;
	}
}
