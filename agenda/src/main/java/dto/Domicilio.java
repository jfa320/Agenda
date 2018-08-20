package dto;

public class Domicilio {
	
	private int idDomicilio;
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	private Localidad localidad;
	
	public Domicilio(int idDomicilio,String calle,String altura,Localidad localidad){
		this.idDomicilio=idDomicilio;
		this.calle=calle;
		this.altura=altura;
		this.localidad=localidad;
	}
	
	public int getIdDomicilio(){
		return this.idDomicilio;
	}
	public void setIdDomicilio(int idDomicilio){
		this.idDomicilio=idDomicilio;
	}
	
	public String getCalle(){
		return this.calle;
	}
	public void setCalle(String calle){
		this.calle=calle;
	}
	

	
	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepto(){
		return this.depto;
	}
	public void setDepto(String depto){
		this.depto=depto;
	}
	public Localidad getLocalidad(){
		return this.localidad;
	}
	public void setLocalidad(Localidad localidad){
		this.localidad=localidad;
	}
}
