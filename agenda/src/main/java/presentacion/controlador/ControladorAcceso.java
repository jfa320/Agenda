package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Properties;

import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.VentanaAcceso;
import presentacion.vista.VentanaTipo;
import presentacion.vista.Vista;

public class ControladorAcceso implements ActionListener
{
		private VentanaAcceso ventana;
		private Properties config;
		
		public ControladorAcceso(VentanaAcceso ventana)
		{
			this.ventana=ventana;
			this.ventana.getBtnConectar().addActionListener(this);
		}

		

		@Override
		public void actionPerformed(ActionEvent evento) 
		{
			
			if(evento.getSource()==this.ventana.getBtnConectar())
			{
				
				Properties p = new Properties();
				try 
				{
					p.load(new FileReader("C:\\Users\\ferna\\Desktop\\acceso.properties"));
				}
				catch (IOException e)
				{
					
					e.printStackTrace();
				}
				
				
				
				
				p.put("usuario", this.ventana.getTextFieldUsuario().getText());
				p.put("contraseña", this.ventana.getTextFieldContraseña().getText());
				p.put("puerto", this.ventana.getTextFieldPuerto().getText());
				p.put("validacion", "");
				
				FileOutputStream out = null;
				try {
					out = new FileOutputStream("C:\\Users\\ferna\\Desktop\\acceso.properties");
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
				
				Vista vista = new Vista();
				Agenda modelo = new Agenda(new DAOSQLFactory());
				Controlador controlador = new Controlador(vista, modelo);
				controlador.inicializar();
				
				
				
			}
			
		}


		public Properties getConfig() {
			return config;
		}


		public void setConfig(Properties config) {
			this.config = config;
		}


		
		
}
