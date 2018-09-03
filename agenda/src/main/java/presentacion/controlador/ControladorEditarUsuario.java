package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
				
			File query = new File(System.getProperty("user.dir")+"\\queryEditarUsuario.txt");
			
			File bat = new File(System.getProperty("user.dir")+"\\editarUsuario.bat");
			
			BufferedWriter bwQuery = null;
			BufferedWriter bwBat = null;
			
			try 
			{
				bwQuery = new BufferedWriter(new FileWriter(query));
				bwBat = new BufferedWriter(new FileWriter(bat));
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bwQuery.write( ("set password for '"+config.getProperty("usuario")+"'@'"+ config.getProperty("ip")+"'='"+this.ventana.getTextFieldContraseña().getText()+"';"));
				bwQuery.newLine();
				bwQuery.write("flush privileges;");
				bwQuery.newLine();
				bwQuery.write("use mysql");
				bwQuery.newLine();
				bwQuery.write(("update user set user='"+this.ventana.getTextFieldUsuario().getText()+"' where user='"+this.config.getProperty("usuario")+"';"));
				bwQuery.newLine();
				bwQuery.write(("flush privileges;"));
				
				bwBat.write("cd c:\\mysql-5.7.19-winx64\\bin");
				bwBat.newLine();
				bwBat.write("mysql -u "+this.config.getProperty("usuario")+" -p"+this.config.getProperty("contraseña")+" < "+System.getProperty("user.dir")+"\\queryEditarUsuario.txt");
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try 
			{
				bwQuery.close();
				bwBat.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			Runtime rt = Runtime.getRuntime();
			try 
			{
				rt.exec(System.getProperty("user.dir")+"\\editarUsuario.bat");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			config.put("usuario", this.ventana.getTextFieldUsuario().getText());
			config.put("contraseña", this.ventana.getTextFieldContraseña().getText());

			FileOutputStream out = null;
			try {
				out = new FileOutputStream(System.getProperty("user.dir")+"\\acceso.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				config.store(out, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			this.ventana.dispose();
		}	
				
		}
		
		
		
		
	
	
	
}
