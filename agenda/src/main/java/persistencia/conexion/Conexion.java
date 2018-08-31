package persistencia.conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;



public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	
	
	private Conexion()
	{
		
		Runtime rt = Runtime.getRuntime();
		
		try {
			rt.exec("C://BD Laboratorio//mysql-5.7.19-win32//bin//mysqld");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try
		{
			
			
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","123456");
			log.info("ConexiÃ³n exitosa");
		}
		catch(Exception e)
		{
			log.error("ConexiÃ³n fallida", e);
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexiÃ³n!", e);
		}
		instancia = null;
	}
}
