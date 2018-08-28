package presentacion.vista;



import javax.swing.JFrame;
import presentacion.controlador.Controlador;
import javax.swing.JLabel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JTextField textFieldAño;
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
	private JTextField textFieldServidor;
	private JTextField textFieldMes;
	private JTextField textFieldDia;
	
	public VentanaAMPersona(Controlador controlador) 
	{
		super();
		this.setControlador(controlador);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 488);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 50, 493, 373);
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
		
		textFieldAño = new JTextField();
		textFieldAño.setBounds(183, 290, 31, 20);
		panel.add(textFieldAño);
		textFieldAño.setColumns(10);
		
		
		textFieldAño.addKeyListener(new KeyAdapter()
		{
			   public void keyTyped(KeyEvent e)
			   {
				  
			      char caracter = e.getKeyChar();   
			      
			     
			    
			      
			       
			       if(((caracter < '0') || (caracter > '9')) &&(caracter != '\b')  && caracter!='-') 
			    	  e.consume();

			      if (textFieldAño.getText().length()== 4)
		    		  e.consume();
			      
			   }
			});
		
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(183, 259, 86, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(183, 42, 151, 20);
		panel.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		textFieldTelefono.addKeyListener(new KeyAdapter()
		{
			   public void keyTyped(KeyEvent e)
			   {
			      char caracter = e.getKeyChar();
			      if(((caracter < '0') ||
			         (caracter > '9')) &&
			         (caracter != '\b' ))
			      {
			         e.consume(); 
			      }
			   }
			});
		
		
		textFieldNombreApellido = new JTextField();
		textFieldNombreApellido.setBounds(183, 11, 151, 20);
		panel.add(textFieldNombreApellido);
		textFieldNombreApellido.setColumns(10);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(11, 166, 104, 20);
		panel.add(lblDepartamento);
		
		lblPiso = new JLabel("Piso");
		lblPiso.setBounds(11, 135, 57, 20);
		panel.add(lblPiso);
		
		lblTelefono = new JLabel("Telefono *");
		lblTelefono.setBounds(11, 42, 104, 20);
		panel.add(lblTelefono);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(11, 104, 57, 20);
		panel.add(lblAltura);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(11, 76, 46, 14);
		panel.add(lblCalle);
		
		lblTipoContacto = new JLabel("Tipo Contacto *");
		lblTipoContacto.setBounds(11, 197, 104, 20);
		panel.add(lblTipoContacto);
		
		lblCumpleaos = new JLabel("Cumpleaños *(AAAA-MM-DD)");
		lblCumpleaos.setBounds(10, 290, 163, 20);
		panel.add(lblCumpleaos);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 262, 46, 14);
		panel.add(lblEmail);
		
		lblLocalidad = new JLabel("Localidad * ");
		lblLocalidad.setBounds(10, 228, 71, 20);
		panel.add(lblLocalidad);
		
		lblNombreApellido = new JLabel("Nombre *");
		lblNombreApellido.setBounds(11, 11, 104, 20);
		panel.add(lblNombreApellido);
		
		btnAbmTipos = new JButton("ABM Tipos");
		btnAbmTipos.setBounds(344, 196, 139, 23);
		panel.add(btnAbmTipos);
		btnAbmTipos.addActionListener(controlador);
		
		btnAbmLocalidades = new JButton("ABM Localidades");
		btnAbmLocalidades.setBounds(344, 227, 139, 23);
		panel.add(btnAbmLocalidades);
		
		JLabel arroba = new JLabel("@");
		arroba.setBounds(271, 259, 24, 20);
		panel.add(arroba);
		
		textFieldServidor = new JTextField();
		textFieldServidor.setColumns(10);
		textFieldServidor.setBounds(289, 259, 63, 20);
		panel.add(textFieldServidor);
		
		JLabel label = new JLabel("-");
		label.setBounds(225, 290, 16, 20);
		panel.add(label);
		
		textFieldMes = new JTextField();
		textFieldMes.setColumns(10);
		textFieldMes.setBounds(238, 290, 31, 20);
		panel.add(textFieldMes);
		textFieldMes.addKeyListener(new KeyAdapter()
		{
			   public void keyTyped(KeyEvent e)
			   {
				  
			      char caracter = e.getKeyChar();   
			      
			     
			    
			      
			       
			       if(((caracter < '0') || (caracter > '9')) &&(caracter != '\b')  && caracter!='-') 
			    	  e.consume();

			      if (textFieldMes.getText().length()== 2)
		    		  e.consume();			      
			   }
			});
		
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(279, 290, 16, 20);
		panel.add(label_1);
		
		textFieldDia = new JTextField();
		textFieldDia.setColumns(10);
		textFieldDia.setBounds(299, 290, 31, 20);
		panel.add(textFieldDia);
		textFieldDia.addKeyListener(new KeyAdapter()
		{
			   public void keyTyped(KeyEvent e)
			   {
				  
			      char caracter = e.getKeyChar();   
			      
			     
			    
			      
			       
			       if(((caracter < '0') || (caracter > '9')) &&(caracter != '\b')  && caracter!='-') 
			    	  e.consume();

			      if (textFieldDia.getText().length()== 2)
		    		  e.consume();
			      
			   }
			});
		
		
		JLabel labelCamposObligatorios = new JLabel("Las etiquetas con *, son campos obligatorios");
		labelCamposObligatorios.setBounds(10, 11, 472, 20);
		getContentPane().add(labelCamposObligatorios);
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
	
	public JTextField getTextFieldAño(){
		return textFieldAño;
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
	
	public JTextField getTextFieldMes() {
		return textFieldMes;
	}



	public JTextField getTextFieldDia() {
		return textFieldDia;
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
	public void setTextFieldAño(String textFieldCumple){
		this.textFieldAño.setText(textFieldCumple);
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



	public JTextField getTextFieldServidor() {
		return textFieldServidor;
	}



	public JButton getBtnABMTipo() {
		return this.btnAbmTipos;
	}



	public void setTextFieldMes(String string) 
	{
		this.textFieldMes.setText(string);
		
	}



	public void setTextFieldDia(String string) {
		this.textFieldDia.setText(string);
		
	}



	public void setTextFieldServidor(String servidor) {
		this.textFieldServidor.setText(servidor);
		
	}
}