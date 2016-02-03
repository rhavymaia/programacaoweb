package br.edu.ifpb.entidade;

public class Veiculo {
	
	private int id;
	
	private String marca;
	
	private String placa;
	
	public Veiculo(int id, String marca, String placa){
		
		this.id= id;
		
		this.marca= marca;
		
		this.placa = placa;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
