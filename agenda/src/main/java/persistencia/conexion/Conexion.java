package persistencia.conexion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;



public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	
	private String usuario="";
	private String contraseña="";
	private String puerto="";
	private Conexion() 
	{
		
	
		try
		{
			Properties p=new Properties();
			p.load(new FileReader(System.getProperty("user.dir")+"\\acceso.properties"));
			
			
			
			this.usuario=p.getProperty("usuario");
			this.contraseña=p.getProperty("contraseña");
			this.puerto=p.getProperty("puerto");

			
			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/agenda",usuario,contraseña);
			
			
			
			log.info("ConexiÃ³n exitosa");
			
			p.put("validacion", "true");
			

			FileOutputStream out = null;
			try {
				out = new FileOutputStream(System.getProperty("user.dir")+"\\acceso.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				p.store(out, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		catch(Exception e)
		{
			Properties p=new Properties();
			try {
				p.load(new FileReader(System.getProperty("user.dir")+"\\acceso.properties"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			p.put("validacion","false");
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
