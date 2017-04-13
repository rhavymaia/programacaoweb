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
import br.edu.ifpb.resteasyapp.dao.EscolaDAO;
import br.edu.ifpb.resteasyapp.entidade.Aluno;
import br.edu.ifpb.resteasyapp.entidade.Escola;

@Path("aluno")
public class AlunoController {

	/**
	 * Cadastrar aluno.
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
		
		// Regra de negócio e manipulação de dados nesse ponto.		
		try {
			
			// Recuperando valores completos da Escola.
			int idEscola = aluno.getEscola().getId();
			Escola escola = EscolaDAO.getInstance().getById(idEscola);
			aluno.setEscola(escola);
			
			// Inserção do Aluno.
			int idAluno = AlunoDAO.getInstance().insert(aluno);
			
			// As informaçãos devem ser associadas nesse ponto ao build (response).
			builder.status(Response.Status.OK).entity(aluno);
		
		} catch (SQLException e) {
			
			// Tratar a exceção.
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		// Resposta.
		return builder.build();
	}
	
	/**
	 * Listar todos os Alunos.
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
			
			// Tratar a exceção.
		}
		
		// Será retornado ao cliente um conjunto de alunos no formato de Json.
		return alunos;
	}
	
	/**
	 * Recuperar o aluno através do seu id.
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

			// Tratar a exceção.
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}
	
	/**
	 * Listar aluno através do nome.
	 * 
	 * @param nome
	 * @return
	 */
	@PermitAll
	@GET
	@Path("/listar/nome/{nome}")
	@Produces("application/json")
	public Response getAlunoByNome(@PathParam("nome") String nome) {
		
		// Preparando a resposta. Provisoriamente o sistema preparará a resposta como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			// Consultar o aluno pelo nome. Consulta disponível na entidade AlunoDAO.
			List<Aluno> alunos = AlunoDAO.getInstance().getByName(nome); 
			
			if (!alunos.isEmpty()) {
				
				// As informaçãos associadas ao build para o response.
				builder.status(Response.Status.OK);
				builder.entity(alunos);
				
			} else {
				
				// Conteúdo não encontrado.
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			// Tratar a exceção.
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Resposta
		return builder.build();
	}
}
