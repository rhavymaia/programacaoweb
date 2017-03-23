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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.ifpb.resteasyapp.dao.AlunoDAO;
import br.edu.ifpb.resteasyapp.entidade.Aluno;

@Path("aluno")
public class AlunoController {

	/**
	 * Cadastra o aluno no sistema.
	 * 
	 * @param aluno
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/inserir")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(Aluno aluno) {
		
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		//TODO: Regra de negócio e manipulação de dados nesse ponto. As informaçãos devem ser associadas
		// nesse ponto ao biuld (response).
		
		try {
			
			int idAluno = AlunoDAO.getInstance().insert(aluno);
			
			aluno.setId(idAluno);
			
			builder.status(Response.Status.OK).entity(aluno);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		// Resposta.
		return builder.build();
	}
	
	/**
	 * Retorna todos os alunos cadastrados.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Aluno> getAll() {
		
		// Retorno em formato de lista.
		// Desse modo o response sempre conterá o código de resposta OK.
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			
			//TODO: Regra de negócio e manipulação de dados nesse ponto.
			alunos = AlunoDAO.getInstance().getAll();
		
		} catch (SQLException e) {
			
			// TODO: Tratar a exceção.
		}
		
		// Será retornado ao cliente um conjunto de alunos no formato de Json.
		return alunos;
	}
	
	/**
	 * Recupera o alunos cadastrado no sistema através do seu id.
	 * 
	 * @param idAluno
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	public Response getAlunoById(@PathParam("id") int idAluno) {
		
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			// Regra de negócio e manipulação de dados nesse ponto.
			Aluno aluno = AlunoDAO.getInstance().getById(idAluno); 
			
			if (aluno != null) {
				
				// As informaçãos associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(aluno);
				
			} else {
				
				// Conteúdo não encontrado.
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}
}
