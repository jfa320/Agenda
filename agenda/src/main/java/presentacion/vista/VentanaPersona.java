package presentacion.vista;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	
	private JTextField txtCalle;
	private JTextField txtAltura;
	
	private JTextField txtPiso;
	private JTextField txtDepto;
	
	private JComboBox<String>  comboBox_tipoContacto;
	private JComboBox<String> comboBox_localidad;
	private JButton btnAgregarPersona;
	private Controlador controlador;
	
	
	
	

	public VentanaPersona(Controlador controlador) 
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307,500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellidor");
		lblNombreYApellido.setBounds(10, 10, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 50, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 90, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 130, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 170, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(10, 210, 113, 14);
		panel.add(lblDepto);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 10, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 50, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		
		txtCalle = new JTextField();
		txtCalle.setBounds(133, 90, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(133, 130, 164, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(133, 170, 164, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(133, 210, 164, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		
		
		
		
		
		
		 comboBox_tipoContacto = new JComboBox<String>();
		
		comboBox_tipoContacto.setBounds(133, 252, 164, 20);
		panel.add(comboBox_tipoContacto);
		
		
		
		
		JLabel lblTipoContacto = new JLabel("Tipo contacto");
		lblTipoContacto.setBounds(10, 255, 113, 14);
		panel.add(lblTipoContacto);
		
		comboBox_localidad = new JComboBox<String>();
		comboBox_localidad.setBounds(133, 283, 164, 20);
		panel.add(comboBox_localidad);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 286, 113, 14);
		panel.add(lblLocalidad);
		
		
		
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(208, 346, 89, 23);
		panel.add(btnAgregarPersona);
		
		
		
		this.setVisible(true);
		
		
		
		
		
	}
	
	public String getComboBox_tipoContacto() {
		return comboBox_tipoContacto.getSelectedItem().toString();
	}

	public String getComboBox_localidad() {
		return comboBox_localidad.getSelectedItem().toString();
	}

	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	public JTextField getTxtPiso() {
		return txtPiso;
	}

	public JTextField getTxtDepto() {
		return txtDepto;
	}
	
	
	
}

