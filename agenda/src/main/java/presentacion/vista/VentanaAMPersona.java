package presentacion.vista;



import javax.swing.JFrame;
import presentacion.controlador.Controlador;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class VentanaAMPersona extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private Controlador controlador;
	private JTextField textFieldNombreApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JTextField textFieldCumple;
	private JTextField textFieldCalle;
	private JTextField textFieldAltura;
	private JTextField textFieldPiso;
	private JTextField textFieldDepartamento;
	
	private JLabel lblNombreApellido;
	private JLabel lblLocalidad;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblCumpleaos;
	private JLabel lblTipoContacto;
	private JLabel lblCalle;
	private JLabel lblAltura;
	private JLabel lblPiso;
	private JLabel lblDepartamento;
	private JButton btnGuardarCambios;
	private JComboBox<String> comboBoxTipo;
	private JComboBox<String> comboBoxLocalidad;
	private JButton btnAbmLocalidades;
	private JButton btnAbmTipos; 
	
	public VentanaAMPersona(Controlador controlador) 
	{
		super();
		this.setControlador(controlador);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 410);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 493, 373);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		comboBoxLocalidad = new JComboBox<String>();
		comboBoxLocalidad.setBounds(183, 228, 151, 20);
		panel.add(comboBoxLocalidad);
		
		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setBounds(183, 197, 151, 20);
		panel.add(comboBoxTipo);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setBounds(183, 166, 151, 20);
		panel.add(textFieldDepartamento);
		textFieldDepartamento.setColumns(10);
		
		btnGuardarCambios = new JButton("Guardar");
		btnGuardarCambios.setBounds(225, 324, 162, 23);
		panel.add(btnGuardarCambios);
		btnGuardarCambios.addActionListener(controlador);
		
		
		textFieldPiso = new JTextField();
		textFieldPiso.setBounds(183, 135, 151, 20);
		panel.add(textFieldPiso);
		textFieldPiso.setColumns(10);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(183, 104, 151, 20);
		panel.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setBounds(183, 73, 151, 20);
		panel.add(textFieldCalle);
		textFieldCalle.setColumns(10);
		
		textFieldCumple = new JTextField();
		textFieldCumple.setBounds(183, 290, 151, 20);
		panel.add(textFieldCumple);
		textFieldCumple.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(183, 259, 151, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(183, 42, 151, 20);
		panel.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldNombreApellido = new JTextField();
		textFieldNombreApellido.setBounds(183, 11, 151, 20);
		panel.add(textFieldNombreApellido);
		textFieldNombreApellido.setColumns(10);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(29, 163, 104, 20);
		panel.add(lblDepartamento);
		
		lblPiso = new JLabel("Piso");
		lblPiso.setBounds(29, 132, 57, 20);
		panel.add(lblPiso);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(29, 42, 86, 20);
		panel.add(lblTelefono);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(29, 101, 57, 20);
		panel.add(lblAltura);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(29, 76, 46, 14);
		panel.add(lblCalle);
		
		lblTipoContacto = new JLabel("Tipo Contacto");
		lblTipoContacto.setBounds(29, 194, 104, 20);
		panel.add(lblTipoContacto);
		
		lblCumpleaos = new JLabel("Cumpleaños");
		lblCumpleaos.setBounds(29, 288, 71, 20);
		panel.add(lblCumpleaos);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(29, 262, 46, 14);
		panel.add(lblEmail);
		
		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(29, 228, 71, 20);
		panel.add(lblLocalidad);
		
		lblNombreApellido = new JLabel("Nombre y Apellido");
		lblNombreApellido.setBounds(29, 11, 104, 20);
		panel.add(lblNombreApellido);
		
		btnAbmTipos = new JButton("ABM Tipos");
		btnAbmTipos.setBounds(344, 196, 139, 23);
		panel.add(btnAbmTipos);
		btnAbmTipos.addActionListener(controlador);
		
		btnAbmLocalidades = new JButton("ABM Localidades");
		btnAbmLocalidades.setBounds(344, 227, 139, 23);
		panel.add(btnAbmLocalidades);
		btnAbmLocalidades.addActionListener(controlador);
			
		setVisible(true);
	}
	
	

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	
	public JTextField getTextFieldNombreApellido(){
		return textFieldNombreApellido;
	}
	public void setTextFieldNombreApellido(String NombreApellido){
		textFieldNombreApellido.setText(NombreApellido);
	}
	
	public JTextField getTextFieldTelefono(){
		return textFieldTelefono;
	}
	
	public JTextField getTextFieldEmail(){
		return textFieldEmail;
	}
	
	public JTextField getTextFieldCumple(){
		return textFieldCumple;
	}
	public JTextField getTextFieldCalle(){
		return textFieldCalle;
	}
	
	public JTextField getTextFieldAltura(){
		return textFieldAltura;
	}
	public JTextField getTextFieldPiso(){
		return textFieldPiso;
	}
	public JTextField getTextFieldDepartamento(){
		return textFieldDepartamento;
	}
	
	public JComboBox<String> getComboBoxTipo(){
		return comboBoxTipo;
	}
	
	public JComboBox<String> getComboBoxLocalidad(){
		return comboBoxLocalidad;
	}
	
	
	public void setTextFieldTelefono(String textFieldTelefono){
		this.textFieldTelefono.setText(textFieldTelefono);
	}
	
	public void setTextFieldEmail(String textFieldEmail){
		this.textFieldEmail.setText(textFieldEmail);
	}
	public void setTextFieldCumple(String textFieldCumple){
		this.textFieldCumple.setText(textFieldCumple);
	}
	public void setTextFieldCalle(String textFieldCalle){
		this.textFieldCalle.setText(textFieldCalle);
	}
	public void setTextFieldAltura(String textFieldAltura){
		this.textFieldAltura.setText(textFieldAltura);
	}
	public void setTextFieldPiso(String textFieldPiso){
		this.textFieldPiso.setText(textFieldPiso);
	}
	public void setTextFieldDepartamento(String textFieldDepartamento){
		this.textFieldDepartamento.setText(textFieldDepartamento);
	}



	public JButton getButtonGuardar() {
		return this.btnGuardarCambios;
	}



	public JButton getBtnABMLocalidad() {
		return this.btnAbmLocalidades;
	}



	public JButton getBtnABMTipo() {
		return this.btnAbmTipos;
	}
}