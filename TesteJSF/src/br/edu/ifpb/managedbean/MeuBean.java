package br.edu.ifpb.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ViewScoped
@ManagedBean
public class MeuBean {

	private Logger logger = LogManager.getLogger(MeuBean.class);
	
	private String palavra;
	
	List<String> palavras;
	
	public MeuBean() {
		
		this.palavras = new ArrayList<String>();
	}
	
	public String buscar() {
		
		logger.info("Palavra: " + palavra);
		
		return null;
	}
	
	public void listenerKeyup(AjaxBehaviorEvent e) {
		
		System.out.println("Palavra: " + palavra);
		
		logger.info("Palavra: " + palavra);
		
		palavras.add(palavra);
	}

	public List<String> getPalavras() {		
		return palavras;
	}

	public void setPalavras(List<String> palavras) {
		this.palavras = palavras;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
}
