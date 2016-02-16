package br.edu.ifpb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.ifpb.entidade.Usuario;

@RequestScoped
@ManagedBean
public class UsuarioBean {

		private Usuario usuario;
		
		public UsuarioBean() {
			this.usuario = new Usuario();
		}

		public String cadastrar() {
			
			System.out.println(usuario.getNome());
			System.out.println(usuario.getIdade());
			
			return null;
		}
		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}	
	
}
