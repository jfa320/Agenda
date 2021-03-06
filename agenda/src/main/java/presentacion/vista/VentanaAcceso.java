package presentacion.vista;

import javax.swing.JFrame;

import presentacion.controlador.ControladorABMTipos;
import presentacion.controlador.ControladorAcceso;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class VentanaAcceso extends JFrame 
{
	
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	private JTextField textFieldPuerto;
	private JTextField textFieldIp;

	private JButton btnConectar;
	
	public VentanaAcceso() 
	{
		
		
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 315);
		
		
		getContentPane().setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(34, 48, 46, 14);
		getContentPane().add(lblUsuario);
		
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(34, 89, 79, 14);
		getContentPane().add(lblContraseña);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(34, 130, 46, 14);
		getContentPane().add(lblPuerto);
		
		JLabel lblIp = new JLabel("Ip");
		lblIp.setBounds(34, 169, 46, 14);
		getContentPane().add(lblIp);
		
		
		JLabel labelTitulo = new JLabel("Datos de acceso a la base de datos");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTitulo.setBounds(34, 11, 348, 14);
		getContentPane().add(labelTitulo);
		
		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(145, 226, 89, 23);
		btnConectar.setVisible(true);
		getContentPane().add(btnConectar);
		
		textFieldIp = new JTextField();
		textFieldIp.setColumns(10);
		textFieldIp.setBounds(145, 166, 86, 20);
		getContentPane().add(textFieldIp);
		
		
		textFieldPuerto = new JTextField();
		textFieldPuerto.setColumns(10);
		textFieldPuerto.setBounds(145, 127, 86, 20);
		getContentPane().add(textFieldPuerto);
		
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(145, 86, 86, 20);
		getContentPane().add(textFieldContraseña);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(145, 45, 86, 20);
		getContentPane().add(textFieldUsuario);
		
		textFieldUsuario.setColumns(10);
		textFieldPuerto.addKeyListener(new KeyAdapter()
		{
			   public void keyTyped(KeyEvent e)
			   {
				  
			      char caracter = e.getKeyChar();   
			      
			      if(((caracter < '0') || (caracter > '9')) &&(caracter != '\b')) 
			    	  e.consume();

			   }
			});
		
		
		
	
		
	}

	

	public JButton getBtnConectar() {
		return btnConectar;
	}

	public void setBtnConectar(JButton btnConectar) {
		this.btnConectar = btnConectar;
	}

	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}

	public void setTextFieldUsuario(JTextField textFieldUsuario) {
		this.textFieldUsuario = textFieldUsuario;
	}

	public JTextField getTextFieldContraseña() {
		return textFieldContraseña;
	}

	public void setTextFieldContraseña(JTextField textFieldContraseña) {
		this.textFieldContraseña = textFieldContraseña;
	}

	public JTextField getTextFieldPuerto() {
		return textFieldPuerto;
	}

	public void setTextFieldPuerto(JTextField textFieldPuerto) {
		this.textFieldPuerto = textFieldPuerto;
	}

	public JTextField getTextFieldIp() {
		return textFieldIp;
	}

	public void setTextFieldIp(JTextField textFieldIp) {
		this.textFieldIp = textFieldIp;
	}
}

