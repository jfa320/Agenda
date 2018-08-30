package persistencia.dao.mysql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Localidad;
import dto.Tipo;
import persistencia.conexion.Conexion;

import persistencia.dao.interfaz.TipoDAO;

public class TipoDAOSQL implements TipoDAO
{
	private static final String insert = "INSERT INTO tipos(idTipo, tipo) VALUES(?, ?)";
	private static final String delete = "DELETE FROM tipos WHERE idTipo = ?";
	private static final String readall = "SELECT * FROM tipos";
	private static final String update = "UPDATE tipos SET tipo=? WHERE idTipo = ?";
	public boolean insert(Tipo tipo)
	{
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, tipo.getIdTipo());
			statement.setString(2, tipo.getNombre());
			
			
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(Tipo tipo_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(tipo_a_eliminar.getIdTipo()));
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
	
	public List<Tipo> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Tipo> tipos = new ArrayList<Tipo>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				tipos.add(new Tipo(resultSet.getInt("idTipo"), resultSet.getString("tipo")));			
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return tipos;
	}
	
	public boolean update(Tipo tipo_a_editar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, (tipo_a_editar.getNombre()));
			statement.setString(2, Integer.toString(tipo_a_editar.getIdTipo()));
			
			System.out.println(tipo_a_editar.getIdTipo());
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