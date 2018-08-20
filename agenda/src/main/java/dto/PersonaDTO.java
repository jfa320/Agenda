package dto;
import java.util.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private Tipo tipo;
	private Domicilio domicilio;
	private String fechaDeCumpleaños;
	private String mail;
	

	public PersonaDTO(int idPersona, String nombre, String telefono,Tipo tipo,Domicilio domicilio,String fechaDeCumpleaños,String mail)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.tipo=tipo;
		this.domicilio=domicilio;
		this.fechaDeCumpleaños=fechaDeCumpleaños;
		this.mail=mail;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public String getFechaDeCumpleaños() {
		return fechaDeCumpleaños;
	}

	public void setFechaDeCumpleaños(String fechaDeCumpleaños) {
		this.fechaDeCumpleaños = fechaDeCumpleaños;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
