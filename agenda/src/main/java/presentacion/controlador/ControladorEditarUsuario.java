package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import presentacion.vista.VentanaAcceso;
import presentacion.vista.VentanaEditarUsuario;

public class ControladorEditarUsuario  implements ActionListener
{
	private VentanaEditarUsuario ventana;
	private Properties config;
	
	public ControladorEditarUsuario(VentanaEditarUsuario ventana)
	{
		this.ventana=ventana;
		this.ventana.getBtnGuardar().addActionListener(this);
		config = new Properties();
		try 
		{
			config.load(new FileReader(System.getProperty("user.dir")+"\\acceso.properties"));
		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento)
	{

		if(evento.getSource()==this.ventana.getBtnGuardar())
		{
				
			File archivo = new File(System.getProperty("user.dir")+"\\queryEditarUsuario.txt");
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(archivo));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.write( ("set password for '"+config.getProperty("usuario")+"'@'"+ config.getProperty("ip")+"'='"+this.ventana.getTextFieldContraseña().getText()+"';")+ ("update user set user='"+this.ventana.getTextFieldUsuario().getText()+"' where user='"+this.config.getProperty("usuario")+"';")+ ("flush privileges;"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			Runtime rt = Runtime.getRuntime();
			try 
			{
				rt.exec("C:\\Users\\ferna\\Desktop\\inicializar.bat");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}	
				
		}
		
		
		
		
	
	
	
}
