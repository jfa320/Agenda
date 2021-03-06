package persistencia.dao.mysql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Localidad;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOSQL implements LocalidadDAO
{
	private static final String insert = "INSERT INTO localidades(idLocalidad, nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM localidades WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidades";
	private static final String update = "UPDATE localidades SET nombre=? WHERE idLocalidad = ?";
	public boolean insert(Localidad localidad)
	{
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, localidad.getIdLocalidad());
			statement.setString(2, localidad.getNombre());
			
			
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(Localidad localidad_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(localidad_a_eliminar.getIdLocalidad()));
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
	
	public List<Localidad> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				
				localidades.add(new Localidad(resultSet.getInt("idLocalidad"), resultSet.getString("Nombre")));
				
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidades;
	}
	public boolean update(Localidad localidad_a_editar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, (localidad_a_editar.getNombre()));
			statement.setString(2, Integer.toString(localidad_a_editar.getIdLocalidad()));
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
	
}