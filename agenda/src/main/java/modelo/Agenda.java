package modelo;

import java.util.List;

import dto.Localidad;
import dto.PersonaDTO;
import dto.Tipo;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	private LocalidadDAO localidad;
	private TipoDAO tipo;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.localidad=metodo_persistencia.createLocalidadDAO();
		this.tipo=metodo_persistencia.createTipoDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public void actualizarContacto(PersonaDTO persona){
		this.persona.update(persona);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	public List<Localidad> obtenerLocalidades()
	{
		return this.localidad.readAll();		
	}
	public void agregarLocalidad(Localidad nuevaLocalidad)
	{
		this.localidad.insert(nuevaLocalidad);
	}
	
	

	@Override
	public String toString() {
		return "Agenda [persona=" + persona + ", localidad=" + localidad + "]";
	}

	public void agregarTipo(Tipo nuevoTipo) {
		this.tipo.insert(nuevoTipo);
		
	}

	public List<Tipo> obtenerTipos() {
		
		return this.tipo.readAll();
	}
	public boolean eliminarTipo(Tipo tipo)
	{
		return this.tipo.delete(tipo);
	}

	public boolean borrarLocalidad(Localidad localidad) {
		return this.localidad.delete(localidad);
		
	}
	public boolean editarLocalidad (Localidad localidad)
	{
		return this.localidad.update(localidad);
	}
	
	public boolean editarTipo (Tipo tipo)
	{
		return this.tipo.update(tipo);
	}
	

	
}