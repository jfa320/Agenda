package dto;

public class Localidad {

	private int idLocalidad;
	private String nombre;
	
	Localidad(int idLocalidad,String nombre){
		this.idLocalidad=idLocalidad;
		this.nombre=nombre;
	}
	
	public int getIdLocalidad(){
		return this.idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad){
		this.idLocalidad=idLocalidad;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
}
