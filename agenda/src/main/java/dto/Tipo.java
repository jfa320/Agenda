package dto;

public class Tipo {
	private int idTipo;
	private String tipo;
	
	public Tipo(int idTipo,String tipo){
		this.idTipo=idTipo;
		this.tipo=tipo;
		
	}
	
	public int getIdTipo(){
		return this.idTipo;
	}
	
	public void setIdTipo(int idTipo){
		this.idTipo=idTipo;
	}
	
	public String getTipo(String tipo){
		return this.tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	
	
}
