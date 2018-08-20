package presentacion.vista;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

public class VentanaTipo extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador controlador;
	
	private JButton btnConfirmarTipo;
	
	private JTextField txtNombre;
	
	
	public VentanaTipo(Controlador controlador) 
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 443,500);
		contentPane.add(panel);
		panel.setLayout(null);
		this.setVisible(true);
		
		JLabel lblNombreYApellido = new JLabel("Nombre");
		lblNombreYApellido.setBounds(10, 10, 113, 14);
		panel.add(lblNombreYApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 10, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnConfirmarTipo = new JButton("Agregar");
		btnConfirmarTipo.addActionListener(this.controlador);
		btnConfirmarTipo.setBounds(208, 66, 89, 23);
		panel.add(btnConfirmarTipo);
		
	}
	

	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public JButton getBtnConfirmarTipo() {
		return btnConfirmarTipo;
	}

}