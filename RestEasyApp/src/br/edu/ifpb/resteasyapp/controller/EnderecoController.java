package br.edu.ifpb.resteasyapp.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.edu.ifpb.resteasyapp.dao.AlunoDAO;
import br.edu.ifpb.resteasyapp.dao.EnderecoDAO;
import br.edu.ifpb.resteasyapp.entidade.Aluno;
import br.edu.ifpb.resteasyapp.entidade.Endereco;

@Path("endereco")
public class EnderecoController {

	@GET
	@Path("/listar/logradouro/{logradouro}")
	@Produces("application/json")
	public Response getEnderecoByLogradouro(@PathParam("logradouro") String logradouro) {

		// Preparando a resposta. Provisoriamente o sistema preparará a resposta
		// como requisição incorreta.
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		try {
			
			// Validação			
			if (logradouro != null && !logradouro.isEmpty()) {
				
				List<Endereco> enderecos = EnderecoDAO.getInstance()
						.getEnderecoByLogradouro(logradouro);
				
				builder.status(Response.Status.OK)
					.entity(enderecos);
			}			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		// Resposta
		return builder.build();
	}
}
