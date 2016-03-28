package br.edu.ifpb.urnaeletronica.bean;

import java.util.List;

import br.edu.ifpb.urnaeletronica.dao.PessoaDAO;
import br.edu.ifpb.urnaeletronica.entidade.Pessoa;

public class PessoaBean {

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = PessoaDAO.getInstance().getAll();
		
		for (Pessoa pessoa: pessoas) {
			System.out.println(pessoa.getId());
			System.out.println(pessoa.getNome());
		}
		
	}
}
