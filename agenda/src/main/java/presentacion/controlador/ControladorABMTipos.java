package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.Tipo;
import presentacion.vista.VentanaABMTipos;

import presentacion.vista.VentanaTipo;
import modelo.Agenda;


public class ControladorABMTipos implements ActionListener {

	private VentanaABMTipos vistaABM;
	private Agenda agenda;
	private List<Tipo> tipos;
	private VentanaTipo ventanaTipo;
	private VentanaTipo ventanaEditarTipo;
	private Controlador controlador;



	public ControladorABMTipos(VentanaABMTipos vistaABM, Agenda agenda,Controlador controlador)
	{
		this.vistaABM = vistaABM;
		
		this.agenda = agenda;
		this.tipos=agenda.obtenerTipos();
		this.controlador=controlador;
		
		this.llenarTabla();
		this.vistaABM.getBtnAgregar().addActionListener(this);
		this.vistaABM.getBtnEditar().addActionListener(this);
		this.vistaABM.getBtnBorrar().addActionListener(this);
	}
	
	
	
	private void llenarTabla() {
		this.vistaABM.getModelTipos().setRowCount(0);
		this.vistaABM.getModelTipos().setColumnCount(0);
		this.vistaABM.getModelTipos().setColumnIdentifiers(this.vistaABM.getNombreColumnas());
		this.tipos=agenda.obtenerTipos();
		for (int i = 0; i < this.tipos.size(); i ++)
		{
			
			Object[] fila={tipos.get(i).getNombre()};
			this.vistaABM.getModelTipos().addRow(fila);
		}	
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vistaABM.getBtnAgregar()){
			this.ventanaTipo=new VentanaTipo(this);
		}
		else if(e.getSource()==this.vistaABM.getBtnEditar()){
			if(this.vistaABM.getTable().getSelectedRow()>=0){
				this.ventanaEditarTipo=new VentanaTipo(this);
				this.llenarCamposEditables(this.vistaABM.getTable().getSelectedRow());}
			else{
				this.vistaABM.alertaEditar();
			}
		}
		else if(e.getSource()==this.vistaABM.getBtnBorrar()){
			if(this.vistaABM.getTable().getSelectedRow()>=0){
				
				
				if(agenda.eliminarTipo(tipoEnFila(this.vistaABM.getTable().getSelectedRow()))){
					this.llenarTabla();
					this.controlador.llenarComboBox();
				}
				else{
					this.vistaABM.alertaClavesForaneas();
				}
			}
			else{
				this.vistaABM.alertaBorrar();
			}
		}
		
		
		else if(!(this.ventanaTipo==null) && e.getSource()==this.ventanaTipo.getBtnConfirmarTipo()){
			Tipo nuevoTipo=new Tipo(0,this.ventanaTipo.getTxtNombre().getText());
			
			if (verificarNuevoTipo(nuevoTipo))
			{
				agenda.agregarTipo(nuevoTipo);
				this.llenarTabla();
				this.ventanaTipo.dispose();
				this.controlador.llenarComboBox();
			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Ese tipo de contacto no es valido");
			}
			
		}
		else if (!(this.ventanaEditarTipo==null) && e.getSource()==this.ventanaEditarTipo.getBtnConfirmarTipo()){
			this.ventanaEditarTipo.dispose();
			this.actualizarDatosEditados();
			this.llenarTabla();
			this.controlador.llenarComboBox();
		}
		
	}

	private Tipo tipoEnFila(int selectedRow) {
		Tipo tipo=this.tipos.get(selectedRow);
		return tipo ;
	}

	private void actualizarDatosEditados() {
		Tipo tipo=tipos.get(this.vistaABM.getTable().getSelectedRow());
		 
		tipo.setTipo(this.ventanaEditarTipo.getTxtNombre().getText());
		agenda.editarTipo(tipo);
	
		
	}

	private void llenarCamposEditables(int selectedRow) {
		Tipo localidad=this.tipos.get(selectedRow);
		this.ventanaEditarTipo.setTxtNombre(localidad.getNombre());
	}
	
	
	private boolean verificarNuevoTipo(Tipo nuevoTipo)
	{
		if (nuevoTipo.getNombre().equals(""))
			return false;
		for (Tipo tipo:this.agenda.obtenerTipos())
		{
			if (nuevoTipo.getNombre().equals(tipo.getNombre()))
				return false;
		}
		return true;
			
	}
	
	
}
