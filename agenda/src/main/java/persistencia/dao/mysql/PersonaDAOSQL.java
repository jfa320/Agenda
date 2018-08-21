package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.Localidad;
import dto.PersonaDTO;
import dto.Tipo;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono,email,cumple,idTipo,idLocalidad,calle,altura,piso,departamento) VALUES(?, ?, ?, ?, ?, ?,?, ?, ?, ?,?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	//private static final String update = "UPDATE personas SET nombre = ? , "+"telefono= ? ,"+"email= ? ,"+"cumple= ? ,"+"idTipo= ? ,"+"idLocalidad= ? ,"+"calle= ? ,"+"altura= ? ,"+"piso= ? ,"+ "departamento = ? "+ "WHERE idPersona = ?";;
		
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setString(5, persona.getCumpleaños());
			statement.setInt(6, persona.getTipo().getIdTipo());
			statement.setInt(7, persona.getLocalidad().getIdLocalidad());
			statement.setString(8, persona.getCalle());
			statement.setString(9, persona.getAltura());
			statement.setString(10, persona.getPiso());
			statement.setString(11, persona.getDepartamento());
			
			
			
			
			
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			chequeoUpdate = statement.executeUpdate();
	
			if(chequeoUpdate > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				
				TipoDAOSQL tipodaosql=new TipoDAOSQL();
				LocalidadDAOSQL localidaddaosql=new LocalidadDAOSQL();
				
				
				List<Tipo>tipos=tipodaosql.readAll();
				List<Localidad>localidades=localidaddaosql.readAll();
				
				int idTipo=resultSet.getInt("idTipo");
				int idLocalidad=resultSet.getInt("idLocalidad");
				
				Tipo tipo=null;
				Localidad localidad=null;
				
				for (Tipo t : tipos) 
				{
					if (t.getIdTipo()==idTipo)
						tipo=t;
					
				}
				
				for (Localidad l:localidades){
					if (l.getIdLocalidad()==idLocalidad){
						localidad=l;
					}
				}
				
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"),resultSet.getString("Email"),resultSet.getString("cumple"),tipo,localidad,resultSet.getString("calle"),resultSet.getString("altura"),resultSet.getString("piso"),resultSet.getString("departamento")));
				
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}

	
	public void update(PersonaDTO persona) {

		this.delete(persona);
		this.insert(persona);
	}
}

