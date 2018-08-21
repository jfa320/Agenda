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
	

	public PersonaDTO(int idPersona, String nombre, String telefono,String email,String cumpleaños,Tipo tipo_contacto,Localidad localidad)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email=email;
		this.cumpleaños=cumpleaños;
		this.tipo_contacto=tipo_contacto;
		this.localidad=localidad;
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

	public String getCumpleaños() {
		return cumpleaños;
	}

	public Tipo getTipo() {
		return tipo_contacto;
	}

	public Localidad getLocalidad() {
		return localidad;
	}
	
}
