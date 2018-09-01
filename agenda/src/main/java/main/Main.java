package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.controlador.ControladorAcceso;
import presentacion.vista.VentanaAcceso;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		Properties p=new Properties();
		p.load(new FileReader("C:\\Users\\ferna\\Desktop\\acceso.properties"));
		
		if (!p.getProperty("validacion").equals("true"))
		{
				VentanaAcceso ventana=new VentanaAcceso();
		
				ControladorAcceso controladorAcceso=new ControladorAcceso(ventana);
		}
		else
		{
			Vista vista = new Vista();
			Agenda modelo = new Agenda(new DAOSQLFactory());
			Controlador controlador = new Controlador(vista, modelo);
			controlador.inicializar();
			
		}
		
	
		
		
		
	}
}
