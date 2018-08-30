package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.Localidad;
import presentacion.vista.VentanaABMLocalidades;

import presentacion.vista.VentanaLocalidad;
import modelo.Agenda;


public class ControladorABMLocalidades implements ActionListener {

	
	
	private VentanaABMLocalidades vistaABM;
	private Agenda agenda;
	private List<Localidad> localidades;
	private VentanaLocalidad ventanaLocalidad;
	private VentanaLocalidad ventanaEditarLocalidad;
	private Controlador controlador;


	public ControladorABMLocalidades(VentanaABMLocalidades vistaABM, Agenda agenda,Controlador controlador)
	{
		this.vistaABM = vistaABM;
		this.controlador=controlador;
		this.agenda = agenda;
		this.localidades=agenda.obtenerLocalidades();
		
		
		this.llenarTabla();
		this.vistaABM.getBtnAgregar().addActionListener(this);
		this.vistaABM.getBtnEditar().addActionListener(this);
		this.vistaABM.getBtnBorrar().addActionListener(this);
	}
	
	private void llenarTabla() {
		this.vistaABM.getModelLocalidades().setRowCount(0);
		this.vistaABM.getModelLocalidades().setColumnCount(0);
		this.vistaABM.getModelLocalidades().setColumnIdentifiers(this.vistaABM.getNombreColumnas());
		this.localidades=agenda.obtenerLocalidades();
		for (int i = 0; i < this.localidades.size(); i ++)
		{
			
			Object[] fila={localidades.get(i).getNombre()};
			this.vistaABM.getModelLocalidades().addRow(fila);
		}	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vistaABM.getBtnAgregar()){
			this.ventanaLocalidad=new VentanaLocalidad(this);
		}
		
		
		else if(e.getSource()==this.vistaABM.getBtnEditar()){
			if(this.vistaABM.getTable().getSelectedRow()>=0){
				this.ventanaEditarLocalidad=new VentanaLocalidad(this);
				this.llenarCamposEditables(this.vistaABM.getTable().getSelectedRow());}
			else{
				this.vistaABM.alertaEditar();
			}
		}
		
		
		else if(e.getSource()==this.vistaABM.getBtnBorrar()){
			if(this.vistaABM.getTable().getSelectedRow()>=0){
				
				
				if(agenda.borrarLocalidad(localidadEnFila(this.vistaABM.getTable().getSelectedRow()))){
					this.llenarTabla();
					controlador.llenarComboBox();
				}
				
				else{
					this.vistaABM.alertaClavesForaneas();
				}
				
			}
				
			else{
				this.vistaABM.alertaBorrar();
			}
			
		}
	
		
		else if(!(this.ventanaLocalidad==null) && e.getSource()==this.ventanaLocalidad.getBtnConfirmarLocalidad()){
			Localidad nuevaLocalidad=new Localidad(0,this.ventanaLocalidad.getTxtNombre().getText());
			if (verificarNuevaLocalidad(nuevaLocalidad))
			{
				agenda.agregarLocalidad(nuevaLocalidad);
			
			
				this.llenarTabla();
				this.ventanaLocalidad.dispose();
				
				this.controlador.llenarComboBox();
			}
			else
				JOptionPane.showMessageDialog(null, "Esa localidad no es valida");
			
		}
		else if (!(this.ventanaEditarLocalidad==null) && e.getSource()==this.ventanaEditarLocalidad.getBtnConfirmarLocalidad()){
			this.ventanaEditarLocalidad.dispose();
			this.actualizarDatosEditados();
			this.llenarTabla();
			this.controlador.llenarComboBox();
		}
	}

	private Localidad localidadEnFila(int selectedRow) {
		Localidad localidad=this.localidades.get(selectedRow);
		return localidad ;
	}

	private void actualizarDatosEditados() {
		Localidad localidad=localidades.get(this.vistaABM.getTable().getSelectedRow());
		
			localidad.setNombre(this.ventanaEditarLocalidad.getTxtNombre().getText());
			agenda.editarLocalidad(localidad);
	}

	private void llenarCamposEditables(int selectedRow) {
		Localidad localidad=this.localidades.get(selectedRow);
		this.ventanaEditarLocalidad.setTxtNombre(localidad.getNombre());
	}

	private boolean verificarNuevaLocalidad(Localidad nuevaLocalidad)
	{
		if (nuevaLocalidad.getNombre().equals(""))
			return false;
		
		for (Localidad localidad:this.agenda.obtenerLocalidades())
		{
			if (nuevaLocalidad.getNombre().equals(localidad.getNombre()))
				return false;
		}
		return true;
			
	}
}
