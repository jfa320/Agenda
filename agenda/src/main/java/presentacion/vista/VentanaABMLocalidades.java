package presentacion.vista;

import javax.swing.JFrame;

import presentacion.controlador.Controlador;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VentanaABMLocalidades extends JFrame 
{
	private static final long serialVersionUID = 1L;

	private Controlador controlador;
	private JTable table;
	private  String[] nombreColumnas = {"Nombre de Localidad"};
	private DefaultTableModel modelLocalidades;
	

	public VentanaABMLocalidades(Controlador controlador) 
	{
		super();
		this.controlador = controlador;
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 410);
		
		
		getContentPane().setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(20, 283, 89, 23);
		getContentPane().add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(290, 283, 89, 23);
		getContentPane().add(btnBorrar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(166, 283, 89, 23);
		getContentPane().add(btnEditar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 383, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		modelLocalidades = new DefaultTableModel(null,nombreColumnas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 363, 245);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(modelLocalidades);
	}
}

