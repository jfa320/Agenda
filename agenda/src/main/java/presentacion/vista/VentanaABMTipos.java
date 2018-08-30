package presentacion.vista;

import javax.swing.JFrame;

import presentacion.controlador.ControladorABMTipos;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VentanaABMTipos extends JFrame 
{
	private static final long serialVersionUID = 1L;

	private ControladorABMTipos controlador;
	private JTable table;
	private  String[] nombreColumnas = {"Nombre de Tipo"};
	private DefaultTableModel modelTipos;
	
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnEditar;
	private JPanel panel;
	private JScrollPane scrollPane;

	public VentanaABMTipos(ControladorABMTipos controlador) 
	{
		super();
		this.controlador = controlador;
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 375);
		
		
		getContentPane().setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(20, 283, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(290, 283, 89, 23);
		getContentPane().add(btnBorrar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(164, 283, 89, 23);
		getContentPane().add(btnEditar);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 408, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		modelTipos = new DefaultTableModel(null,nombreColumnas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 388, 245);
		panel.add(scrollPane);
		
		table = new JTable(modelTipos);
		scrollPane.setViewportView(table);
		
		
	}
	
	public ControladorABMTipos getControlador(){
		return controlador;
	}
	public JTable getTable(){
		return table;
	}
	public String[] getNombreColumnas(){
		return nombreColumnas;
	}
	public DefaultTableModel getModelTipos(){
		return modelTipos;
	}
	public JButton getBtnAgregar(){
		return btnAgregar;
	}
	public JButton getBtnBorrar(){
		return btnBorrar;
	}
	public JButton getBtnEditar(){
		return btnEditar;
	}
	public JPanel getPanel(){
		return panel;
	}
	public JScrollPane getScrollPane(){
		return scrollPane;
	}
	
	public void setControlador(ControladorABMTipos controlador){
		this.controlador=controlador;
	}
	public void setTable(JTable table){
		this.table=table;
	}
	public void setNombreColumnas(String[] nombreColumnas){
		this.nombreColumnas=nombreColumnas;
	}
	public void setDefaultTableModel(DefaultTableModel modelTipos){
		this.modelTipos=modelTipos;
	}
	public void setBtnAgregar(JButton btnAgregar){
		this.btnAgregar=btnAgregar;
	}
	public void setBtnBorrar(JButton btnBorrar){
		this.btnBorrar=btnBorrar;
	}
	public void setBtnEditar(JButton btnEditar){
		this.btnEditar=btnEditar;
	}
	public void setPanel(JPanel panel){
		this.panel=panel;
	}
	public void setScrollPane(JScrollPane scrollPane){
		this.scrollPane=scrollPane;
	}

	public void alertaEditar() {
		JOptionPane.showMessageDialog(null, "Seleccione tipo a editar");
		
	}

	public void alertaBorrar() {
		JOptionPane.showMessageDialog(null, "Seleccione tipo a borrar");
		
	}

	public void alertaClavesForaneas() {
		JOptionPane.showMessageDialog(null, "No es posible borrar este tipo porque esta asociado a una persona");
	}
	
}

