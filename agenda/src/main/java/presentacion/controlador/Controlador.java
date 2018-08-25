package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaABMLocalidades;
import presentacion.vista.VentanaABMTipos;
import presentacion.vista.VentanaAMPersona;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaTipo;
import presentacion.vista.Vista;
import dto.Localidad;
import dto.PersonaDTO;
import dto.Tipo;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private VentanaAMPersona ventanaPersona; 
		

		private Agenda agenda;
		private List<Localidad> localidades_en_tabla;
		private List<Tipo> tipos_en_tabla;
		private VentanaAMPersona ventanaEditar;
		private VentanaABMLocalidades ventanaABMLocalidades;
		private ControladorABMLocalidades controladorABMLocalidades;
		private VentanaABMTipos ventanaABMTipos;
		private ControladorABMTipos controladorABMTipos;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.vista.getBtnEditar().addActionListener(this);
			this.vista.getBtnAbmLocalidades().addActionListener(this);
			this.vista.getBtnAbmTipos().addActionListener(this);
			this.agenda = agenda;
			this.personas_en_tabla = agenda.obtenerPersonas();
		}
		
		public void inicializar()
		{
			this.llenarTabla();
			this.vista.show();
			
		}
		
		private void llenarComboBox(){
			this.ventanaPersona.getComboBoxLocalidad().removeAllItems();
			this.ventanaPersona.getComboBoxTipo().removeAllItems();
			this.localidades_en_tabla=agenda.obtenerLocalidades();
			
			for (int i = 0; i < this.localidades_en_tabla.size(); i ++){

				this.ventanaPersona.getComboBoxLocalidad().addItem(this.localidades_en_tabla.get(i).getNombre());
			}
			
			this.tipos_en_tabla=agenda.obtenerTipos();
			for (int i = 0; i < this.tipos_en_tabla.size(); i ++){
				
				this.ventanaPersona.getComboBoxTipo().addItem(this.tipos_en_tabla.get(i).getNombre());
			}
			
		}
		
		private void llenarComboBoxEditables(Localidad localidad,Tipo tipo){
			this.ventanaEditar.getComboBoxLocalidad().removeAllItems();
			this.ventanaEditar.getComboBoxTipo().removeAllItems();
			this.localidades_en_tabla=agenda.obtenerLocalidades();
			
			this.ventanaEditar.getComboBoxLocalidad().insertItemAt(localidad.getNombre(), 0);
			
			this.ventanaEditar.getComboBoxLocalidad().setSelectedIndex(0);
			
			for (int i = 0; i < this.localidades_en_tabla.size(); i ++){
				if(!this.localidades_en_tabla.get(i).getNombre().equals(localidad.getNombre())){
					this.ventanaEditar.getComboBoxLocalidad().addItem(this.localidades_en_tabla.get(i).getNombre());}

			}
			
			
			
			this.tipos_en_tabla=agenda.obtenerTipos();
			
			this.ventanaEditar.getComboBoxTipo().insertItemAt(tipo.getNombre(), 0);
			this.ventanaEditar.getComboBoxTipo().setSelectedIndex(0);
			for (int i = 0; i < this.tipos_en_tabla.size(); i ++){
				if(!this.tipos_en_tabla.get(i).getNombre().equals(tipo.getNombre())){
					this.ventanaEditar.getComboBoxTipo().addItem(this.tipos_en_tabla.get(i).getNombre());}
			}
			
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				System.out.println(this.personas_en_tabla.get(i));
				Object[] fila = {this.personas_en_tabla.get(i).getNombre(), this.personas_en_tabla.get(i).getTelefono(),this.personas_en_tabla.get(i).getEmail(),this.personas_en_tabla.get(i).getCumpleaños(),this.personas_en_tabla.get(i).getTipo().getNombre(),this.personas_en_tabla.get(i).getLocalidad().getNombre(),
								 this.personas_en_tabla.get(i).getCalle(),this.personas_en_tabla.get(i).getAltura(),this.personas_en_tabla.get(i).getPiso(),this.personas_en_tabla.get(i).getDepartamento()};
				this.vista.getModelPersonas().addRow(fila);
			}				
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			
			
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				System.out.println(agenda);
			
				
				this.ventanaPersona = new VentanaAMPersona(this);
				this.llenarComboBox();
			}
			else if(e.getSource()== this.vista.getBtnEditar())
			{				
				if(this.vista.getTablaPersonas().getSelectedRow()>=0){
					this.ventanaEditar=new VentanaAMPersona(this);
					this.llenarCamposEditables(this.vista.getTablaPersonas().getSelectedRow());}
				else{
					this.vista.alertaEditar();
				}
			}
			
			
			else if(!(this.ventanaEditar==null) && e.getSource()==this.ventanaEditar.getButtonGuardar()){
				this.ventanaEditar.dispose();
				
				this.actualizarDatosEditados();
				this.llenarTabla();
			}
			
			else if(e.getSource() == this.vista.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
				}
				
				this.llenarTabla();
			}
			else if(e.getSource() == this.vista.getBtnReporte())
			{				
				ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
				reporte.mostrar();				
			}
			
			else if(e.getSource() == this.vista.getBtnAbmLocalidades())
			{				
				this.ventanaABMLocalidades=new VentanaABMLocalidades(controladorABMLocalidades);
				this.controladorABMLocalidades=new ControladorABMLocalidades(ventanaABMLocalidades,agenda);
			}
			
			else if(e.getSource() == this.vista.getBtnAbmTipos())
			{				
				this.ventanaABMTipos=new VentanaABMTipos(controladorABMTipos);
				this.controladorABMTipos=new ControladorABMTipos(ventanaABMTipos,agenda);
			}
			
			else if(!(this.ventanaPersona==null) && e.getSource() == this.ventanaPersona.getButtonGuardar())
			{	
				if (verificarDatosTelefono() &&	verificarDatosNombre() &&verificarDatosCumpleaños() && verificarComboBox())
					
					
				{
					PersonaDTO nuevaPersona;
				Tipo nuevoTipo=null;
				Localidad nuevaLocalidad=null;
				List <Tipo> tipos=agenda.obtenerTipos();
				List<Localidad> localidades=agenda.obtenerLocalidades();
				
				for (int i = 0; i < tipos.size(); i ++){
					
					if (tipos.get(i).getNombre().equals(ventanaPersona.getComboBoxTipo().getSelectedItem().toString()))
					{
		
						nuevoTipo=new Tipo(tipos.get(i).getIdTipo(),tipos.get(i).getNombre());
					}
				}
				
				for (int i = 0; i < localidades.size(); i ++){
					
					if (localidades.get(i).getNombre().equals(ventanaPersona.getComboBoxLocalidad().getSelectedItem().toString()))
					{
		
						nuevaLocalidad=new Localidad(localidades.get(i).getIdLocalidad(),localidades.get(i).getNombre());
					}
				}
				
				
				
				nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTextFieldNombreApellido().getText(), ventanaPersona.getTextFieldTelefono().getText(),ventanaPersona.getTextFieldEmail().getText(),ventanaPersona.getTextFieldCumple().getText(),nuevoTipo,nuevaLocalidad,ventanaPersona.getTextFieldCalle().getText(),ventanaPersona.getTextFieldAltura().getText(),ventanaPersona.getTextFieldPiso().getText(),ventanaPersona.getTextFieldDepartamento().getText());
			
				
				this.agenda.agregarPersona(nuevaPersona);
				this.llenarTabla();
				this.ventanaPersona.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "Falta completar campos obligatorios *");
				
			}
			else if(!(this.ventanaPersona==null) && e.getSource()== this.ventanaPersona.getBtnABMLocalidad())
			{
				
				this.ventanaABMLocalidades = new VentanaABMLocalidades(controladorABMLocalidades);
				this.controladorABMLocalidades=new ControladorABMLocalidades(ventanaABMLocalidades,agenda);
			}
			else if (!(this.ventanaPersona==null) && e.getSource()==this.ventanaPersona.getBtnABMTipo())
			{
				this.ventanaABMTipos = new VentanaABMTipos(controladorABMTipos);
				this.controladorABMTipos=new ControladorABMTipos(ventanaABMTipos,agenda);
				
//				System.out.println("ventanaTipo");
//				this.ventanaTipo = new VentanaTipo(this);
			}
//			else if (!(this.ventanaTipo==null) && e.getSource()==this.ventanaTipo.getBtnConfirmarTipo()  )
//			{
//				
//				Tipo nuevoTipo;
//				nuevoTipo=new Tipo(0,ventanaTipo.getTxtNombre().getText());
//				this.agenda.agregarTipo(nuevoTipo);
//				this.llenarComboBox();
//				this.ventanaTipo.dispose();
//			}
			

//			else if (!(this.ventanaPersona==null) && e.getSource()==this.ventanaPersona.getBtnABMLocalidad())
//			{
//				
//				Localidad localidad=null;
//					
//				List<Localidad> localidades=agenda.obtenerLocalidades();
//				for (int i = 0; i < localidades.size(); i ++){
//					
//				if (localidades.get(i).getNombre().equals(ventanaPersona.getComboBoxLocalidad().getSelectedItem().toString()))
//					{
//		
//					localidad=new Localidad(localidades.get(i).getIdLocalidad(),localidades.get(i).getNombre());
//					}
//					
//					
//				}
//				
//				
//
//				this.llenarComboBox();
//			}
			else if (!(this.ventanaPersona==null) && e.getSource()==this.ventanaPersona.getBtnABMTipo())
			{
				
				Tipo tipo=null;
				
				List<Tipo> tipos=agenda.obtenerTipos();
				for (int i = 0; i < tipos.size(); i ++){
				
				if (tipos.get(i).getNombre().equals(ventanaPersona.getComboBoxTipo().getSelectedItem().toString()))
				{
	
					tipo=new Tipo(tipos.get(i).getIdTipo(),tipos.get(i).getNombre());
				}
				
				
			}
			
			
			this.agenda.eliminarTipo(tipo);
			this.llenarComboBox();
			}
			
			
			
			
			
		}

		
		private void actualizarDatosEditados() {

			PersonaDTO persona=personas_en_tabla.get(this.vista.getTablaPersonas().getSelectedRow());
			
			
			agenda.borrarPersona(persona);
			
			
			persona.setNombre(this.ventanaEditar.getTextFieldNombreApellido().getText());
			persona.setTelefono(this.ventanaEditar.getTextFieldTelefono().getText());
			persona.setEmail(this.ventanaEditar.getTextFieldEmail().getText());
			persona.setCumpleaños(this.ventanaEditar.getTextFieldCumple().getText());
			persona.setCalle(this.ventanaEditar.getTextFieldCalle().getText());
			persona.setAltura(this.ventanaEditar.getTextFieldAltura().getText());
			persona.setPiso(this.ventanaEditar.getTextFieldPiso().getText());
			persona.setDepartamento(this.ventanaEditar.getTextFieldDepartamento().getText());
			
			Tipo tipo=null;	
			String cambioTipo=this.ventanaEditar.getComboBoxTipo().getSelectedItem().toString();	
			for(int i=0;i<this.tipos_en_tabla.size();i++){
				if (this.tipos_en_tabla.get(i).getNombre().equals(cambioTipo)){
					tipo=tipos_en_tabla.get(i);
				}
			}
			
			Localidad localidad=null;	
			String cambioLocalidad=this.ventanaEditar.getComboBoxLocalidad().getSelectedItem().toString();	
			for(int i=0;i<this.localidades_en_tabla.size();i++){
				if (this.localidades_en_tabla.get(i).getNombre().equals(cambioLocalidad)){
					localidad=localidades_en_tabla.get(i);
				}
			}
			
			persona.setTipo(tipo);
			persona.setLocalidad(localidad);
			
			agenda.agregarPersona(persona);
		}

		private void llenarCamposEditables(int indice) {
			
				PersonaDTO persona=personas_en_tabla.get(indice);
				ventanaEditar.setTextFieldNombreApellido(persona.getNombre());
				ventanaEditar.setTextFieldTelefono(persona.getTelefono());
				ventanaEditar.setTextFieldEmail(persona.getEmail());
				ventanaEditar.setTextFieldCumple(persona.getCumpleaños());
				ventanaEditar.setTextFieldCalle(persona.getCalle());
				ventanaEditar.setTextFieldAltura(persona.getAltura());
				ventanaEditar.setTextFieldPiso(persona.getPiso());
				ventanaEditar.setTextFieldDepartamento(persona.getDepartamento());
				
				
				this.llenarComboBoxEditables(persona.getLocalidad(),persona.getTipo());
		
		}
		private boolean verificarDatosTelefono()
		{
			
			return !this.ventanaPersona.getTextFieldTelefono().getText().isEmpty();
		
		}
		private boolean verificarDatosNombre()
		{
			return !this.ventanaPersona.getTextFieldNombreApellido().getText().isEmpty();
		
		}
		private boolean verificarDatosCumpleaños()
		{
			return !this.ventanaPersona.getTextFieldCumple().getText().isEmpty();
		
		}
		private boolean verificarComboBox() 
		{
			if (this.ventanaPersona.getComboBoxLocalidad().getSelectedItem() == null || this.ventanaPersona.getComboBoxTipo().getSelectedItem()==null )
				return false;
			return true;
			
		}

}