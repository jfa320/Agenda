package dto;



public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String email;
	private String cumpleaños;
	private Tipo tipo_contacto;
	private Localidad localidad;
	private String calle;
	private String altura;
	private String piso;
	private String departamento;
	

	public PersonaDTO(int idPersona, String nombre, String telefono,String email,String cumpleaños,Tipo tipo_contacto,Localidad localidad,String calle, String altura,String piso,String departamento)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email=email;
		this.cumpleaños=cumpleaños;
		this.tipo_contacto=tipo_contacto;
		this.localidad=localidad;
		this.calle=calle;
		this.altura=altura;
		this.piso=piso;
		this.departamento=departamento;
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	

	@Override
	public String toString() {
		return "PersonaDTO [idPersona=" + idPersona + ", nombre=" + nombre + ", telefono=" + telefono + ", email="
				+ email + ", cumpleaños=" + cumpleaños + ", tipo_contacto=" + tipo_contacto + "]";
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String Email){
		this.email=Email;
	}
	
	public String getCumpleaños() {
		return cumpleaños;
	}

	public void setCumpleaños(String cumpleaños){
		this.cumpleaños=cumpleaños;
	}
	
	public Tipo getTipo() {
		return tipo_contacto;
	}
	
	public void setTipo(Tipo tipo){
		this.tipo_contacto=tipo;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad){
		this.localidad=localidad;
	}
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle){
		this.calle=calle;
	}
	
	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura){
		this.altura=altura;
	}
	
	public String getPiso() {
		return piso;
	}
	
	public void setPiso(String piso){
		this.piso=piso;
	}

	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento){
		this.departamento=departamento;
	}
}
