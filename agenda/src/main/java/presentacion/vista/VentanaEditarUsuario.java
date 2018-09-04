package presentacion.vista;

import javax.swing.JFrame;


import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;


public class VentanaEditarUsuario extends JFrame 
{
	
	
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	private JButton btnGuardar;

	public VentanaEditarUsuario() 
	{
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 275, 220);
		
		
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(32, 39, 46, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraseña.setBounds(32, 95, 64, 14);
		getContentPane().add(lblContraseña);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(131, 36, 86, 20);
		getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(131, 92, 86, 20);
		getContentPane().add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(83, 149, 89, 23);
		getContentPane().add(btnGuardar);
		
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

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
}

