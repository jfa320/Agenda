package presentacion.vista;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import persistencia.conexion.Conexion;



public class Vista
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private JButton btnEditarContacto;
	private DefaultTableModel modelPersonas;
	private JButton btnAbmLocalidades;
	private  String[] nombreColumnas = {"Nombre y apellido","Telefono","Email","Cumpleaños","Tipo Contacto","Localidad","Calle","Altura","Piso","Departamento"};
	private JButton btnAbmTipos;
	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 882, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 856, 330);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 836, 206);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(3).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(4).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(4).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(5).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(5).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(6).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(6).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(7).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(7).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(8).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(8).setResizable(false);
		
		
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 228, 89, 23);
		panel.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(290, 228, 89, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(418, 228, 89, 23);
		panel.add(btnReporte);
		
		btnEditarContacto = new JButton("Editar");
		btnEditarContacto.setBounds(145, 228, 89, 23);
		panel.add(btnEditarContacto);
		
		btnAbmLocalidades = new JButton("ABM Localidades");
		
		btnAbmLocalidades.setBounds(545, 228, 136, 23);
		panel.add(btnAbmLocalidades);
		
		btnAbmTipos = new JButton("ABM Tipos");
		btnAbmTipos.setBounds(710, 228, 136, 23);
		panel.add(btnAbmTipos);
		
		
	}
	
	public void show()
	{
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "Estas seguro que quieres salir de la Agenda!?", 
		             "Confirmacion", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}


	public JButton getBtnEditar() {
		return btnEditarContacto;
	}
	
	public JButton getBtnAbmLocalidades(){
		return btnAbmLocalidades;
	}
	
	public void alertaEditar(){
		JOptionPane.showMessageDialog(null, "Seleccione contacto a editar");
	}
	
	public JButton getBtnAbmTipos(){
		return this.btnAbmTipos;
	}
	
	public void setBtnAbmTipos(JButton btnAbmTipos){
		this.btnAbmLocalidades=btnAbmTipos;
	}
}