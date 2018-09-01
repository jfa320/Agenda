package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import modelo.Agenda;
import presentacion.reportes.PersonaReporte;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaABMLocalidades;
import presentacion.vista.VentanaABMTipos;
import presentacion.vista.VentanaAMPersona;
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
		private int indicePersonaEditar;
		
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
		
		public void llenarComboBox(){
			
			if(! (this.ventanaPersona==null)){
				this.ventanaPersona.getComboBoxLocalidad().removeAllItems();
				this.ventanaPersona.getComboBoxTipo().removeAllItems();
				this.localidades_en_tabla=agenda.obtenerLocalidades();
				this.tipos_en_tabla=agenda.obtenerTipos();
				
				for (int i = 0; i < this.localidades_en_tabla.size(); i ++){
	
					this.ventanaPersona.getComboBoxLocalidad().addItem(this.localidades_en_tabla.get(i).getNombre());
				}
				
				for (int i = 0; i < this.tipos_en_tabla.size(); i ++){
					
					this.ventanaPersona.getComboBoxTipo().addItem(this.tipos_en_tabla.get(i).getNombre());
				}
			}
			
			if(!(this.ventanaEditar==null)){
				this.ventanaEditar.getComboBoxLocalidad().removeAllItems();
				this.ventanaEditar.getComboBoxTipo().removeAllItems();
				this.localidades_en_tabla=agenda.obtenerLocalidades();
				this.tipos_en_tabla=agenda.obtenerTipos();
				
				for (int i = 0; i < this.localidades_en_tabla.size(); i ++){
	
					this.ventanaEditar.getComboBoxLocalidad().addItem(this.localidades_en_tabla.get(i).getNombre());
				}
				
				for (int i = 0; i < this.tipos_en_tabla.size(); i ++){
					
					this.ventanaEditar.getComboBoxTipo().addItem(this.tipos_en_tabla.get(i).getNombre());
				}
				this.llenarCamposEditables(indicePersonaEditar);
				
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
		
		public void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			personas_en_tabla=agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				
				Object[] fila = {this.personas_en_tabla.get(i).getNombre(), this.personas_en_tabla.get(i).getTelefono(),this.personas_en_tabla.get(i).getEmail(),this.convertirFecha(this.personas_en_tabla.get(i).getCumpleaños()),this.personas_en_tabla.get(i).getTipo().getNombre(),this.personas_en_tabla.get(i).getLocalidad().getNombre(),
								 this.personas_en_tabla.get(i).getCalle(),this.personas_en_tabla.get(i).getAltura(),this.personas_en_tabla.get(i).getPiso(),this.personas_en_tabla.get(i).getDepartamento()};
				this.vista.getModelPersonas().addRow(fila);
			}				
		}
		


		private String convertirFecha(Date cumpleaños) {
			return String.valueOf(cumpleaños.getDate()) + "/" + (String.valueOf(cumpleaños.getMonth()+1)) + "/" +(String.valueOf(cumpleaños.getYear()+1900));
		}

		public void actionPerformed(ActionEvent e) 
		{
			
			
			if(e.getSource() == this.vista.getBtnAgregar())
			{
			
				this.ventanaPersona = new VentanaAMPersona(this);
				this.llenarComboBox();
			}
			else if(e.getSource()== this.vista.getBtnEditar())
			{				
				if(this.vista.getTablaPersonas().getSelectedRow()>=0){
					this.ventanaEditar=new VentanaAMPersona(this);
					indicePersonaEditar=this.vista.getTablaPersonas().getSelectedRow();
					this.llenarCamposEditables(indicePersonaEditar);}
				else{
					this.vista.alertaEditar();
				}
			}
			
			
			else if(!(this.ventanaEditar==null) && e.getSource()==this.ventanaEditar.getButtonGuardar()){
				this.ventanaEditar.dispose();
				
				this.actualizarDatosEditados();
				this.llenarTabla();
			}
			
			else if(!(this.ventanaEditar==null) && e.getSource()==this.ventanaEditar.getBtnABMLocalidad()){
				this.ventanaABMLocalidades=new VentanaABMLocalidades(controladorABMLocalidades);
				this.controladorABMLocalidades=new ControladorABMLocalidades(ventanaABMLocalidades,agenda,this);
				
				
			}
			
			else if(!(this.ventanaEditar==null) && e.getSource()==this.ventanaEditar.getBtnABMTipo()){
				this.ventanaABMTipos=new VentanaABMTipos(controladorABMTipos);
				this.controladorABMTipos=new ControladorABMTipos(ventanaABMTipos,agenda,this);
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
			
				
				
				ReporteAgenda reporte = new ReporteAgenda(generarListaReporte(agenda.obtenerPersonas()));
				reporte.mostrar();					
			}
			
			else if(e.getSource() == this.vista.getBtnAbmLocalidades())
			{				
				this.ventanaABMLocalidades=new VentanaABMLocalidades(controladorABMLocalidades);
				
				this.controladorABMLocalidades=new ControladorABMLocalidades(ventanaABMLocalidades,agenda,this);
				
				
				
				
			}
			
			else if(e.getSource() == this.vista.getBtnAbmTipos())
			{				
				this.ventanaABMTipos=new VentanaABMTipos(controladorABMTipos);
				this.controladorABMTipos=new ControladorABMTipos(ventanaABMTipos,agenda,this);
			}
			
			else if(!(this.ventanaPersona==null) && e.getSource() == this.ventanaPersona.getButtonGuardar())
			{	
				if (verificarCamposObligatorios(this.ventanaPersona))
				{
					PersonaDTO nuevaPersona=crearPersona(this.ventanaPersona);
					this.agenda.agregarPersona(nuevaPersona);
					
					this.ventanaPersona.dispose();
					this.llenarTabla();
				}

			}
			else if(!(this.ventanaPersona==null) && e.getSource()== this.ventanaPersona.getBtnABMLocalidad())
			{
				
				this.ventanaABMLocalidades = new VentanaABMLocalidades(controladorABMLocalidades);
				this.controladorABMLocalidades=new ControladorABMLocalidades(ventanaABMLocalidades,agenda,this);
			
			}
			else if (!(this.ventanaPersona==null) && e.getSource()==this.ventanaPersona.getBtnABMTipo())
			{
				this.ventanaABMTipos = new VentanaABMTipos(controladorABMTipos);
				this.controladorABMTipos=new ControladorABMTipos(ventanaABMTipos,agenda,this);
				
			}

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

		private PersonaDTO crearPersona(VentanaAMPersona ventana) {
			
			
			Tipo nuevoTipo=null;
			Localidad nuevaLocalidad=null;
			List <Tipo> tipos=agenda.obtenerTipos();
			List<Localidad> localidades=agenda.obtenerLocalidades();
			
			for (int i = 0; i < tipos.size(); i ++){
						
			if (tipos.get(i).getNombre().equals(ventana.getComboBoxTipo().getSelectedItem().toString()))
			{

				nuevoTipo=new Tipo(tipos.get(i).getIdTipo(),tipos.get(i).getNombre());
			}
			}
			
			for (int i = 0; i < localidades.size(); i ++)
			{
						
				if (localidades.get(i).getNombre().equals(ventana.getComboBoxLocalidad().getSelectedItem().toString()))
				{

					nuevaLocalidad=new Localidad(localidades.get(i).getIdLocalidad(),localidades.get(i).getNombre());
				}
			}
			
			
			
			return new PersonaDTO(0,ventana.getTextFieldNombreApellido().getText(), ventana.getTextFieldTelefono().getText(),ventana.getTextFieldEmail().getText(),ventana.getTextFieldAño().getText()+"-"+ventana.getTextFieldMes().getText()+"-"+ventana.getTextFieldDia().getText(),nuevoTipo,nuevaLocalidad,ventana.getTextFieldCalle().getText(),ventana.getTextFieldAltura().getText(),ventana.getTextFieldPiso().getText(),ventana.getTextFieldDepartamento().getText());
			
			
				
		}

		

		
		private boolean verificarCamposObligatorios(VentanaAMPersona ventana) 
		{
			
			if (ventana.getTextFieldNombreApellido().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Falta completar el nombre");
				return false;
			}
			if (ventana.getTextFieldTelefono().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Falta completar el numero");
				return false;
			}
			if (ventana.getComboBoxLocalidad().getSelectedItem() == null)
			{
				JOptionPane.showMessageDialog(null, "Falta completar la localidad");
				return false;
			}
			if (ventana.getComboBoxTipo().getSelectedItem() == null)
			{
				JOptionPane.showMessageDialog(null, "Falta completar el tipo de contacto");
				return false;
			}
			if (ventana.getTextFieldDia().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Falta completar el dia de su cumpleaños");
				return false;
			}
			if (ventana.getTextFieldMes().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Falta completar el mes de su cumpleaños");
				return false;
			}
			
			if (ventana.getTextFieldAño().getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Falta completar el año de su cumpleaños");
				return false;
			}
			if (!verificarDate(ventana.getTextFieldDia().getText()+"-"+ventana.getTextFieldMes().getText()+"-"+ventana.getTextFieldAño().getText()))
			{
				
				JOptionPane.showMessageDialog(null, "Ingrese una fecha valida");
				return false;
			}
			
			return true;
			
		}


		@SuppressWarnings("deprecation")
		private boolean verificarDate(String cumpleaños)
		{	
			
			SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date utilDate = new java.util.Date();
			
			
			try {
				
				
				utilDate= formato.parse(cumpleaños);
				
			
				
				String[] parts = cumpleaños.split("-");
				
				
				if (!(Integer.parseInt(parts[0])==utilDate.getDate()))
				{
					
					return false;
				}
				
				if (!(Integer.parseInt(parts[1])==(utilDate.getMonth()+1)))
				{
				
					return false;
				}

				

				if (!(Integer.parseInt(parts[2])==(utilDate.getYear()+1900)))
				{
					
					
			
					return false;
				}
				
				
				
				return true;
			} 
			catch (ParseException e) 
			{
				
				return false;
			}
			
			
		}

		private void actualizarDatosEditados() 
		{

			PersonaDTO persona=personas_en_tabla.get(this.vista.getTablaPersonas().getSelectedRow());
			
			
			
			
			if (this.ventanaEditar.getTextFieldEmail().getText().isEmpty())
				persona.setEmail("");
			else
				persona.setEmail(this.ventanaEditar.getTextFieldEmail().getText());
			
			persona.setNombre(this.ventanaEditar.getTextFieldNombreApellido().getText());
			persona.setTelefono(this.ventanaEditar.getTextFieldTelefono().getText());
			
			persona.setCumpleaños(this.ventanaEditar.getTextFieldAño().getText()+"-"+this.ventanaEditar.getTextFieldMes().getText()+"-"+this.ventanaEditar.getTextFieldDia().getText());
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
			
			agenda.actualizarContacto(persona);
		}

		private void llenarCamposEditables(int indice) {
			
				
				
				PersonaDTO persona=personas_en_tabla.get(indice);		
				ventanaEditar.setTextFieldEmail(persona.getEmail());
				ventanaEditar.setTextFieldNombreApellido(persona.getNombre());
				ventanaEditar.setTextFieldTelefono(persona.getTelefono());				
				ventanaEditar.setTextFieldAño(String.valueOf(persona.getCumpleaños().getYear()+1900));
				ventanaEditar.setTextFieldMes(String.valueOf(persona.getCumpleaños().getMonth()+1));
				ventanaEditar.setTextFieldDia(String.valueOf(persona.getCumpleaños().getDate()));
				ventanaEditar.setTextFieldCalle(persona.getCalle());
				ventanaEditar.setTextFieldAltura(persona.getAltura());
				ventanaEditar.setTextFieldPiso(persona.getPiso());
				ventanaEditar.setTextFieldDepartamento(persona.getDepartamento());
				
				
				this.llenarComboBoxEditables(persona.getLocalidad(),persona.getTipo());
		
		}
		
		
		
		private List<PersonaReporte> generarListaReporte(List<PersonaDTO> obtenerPersonas) {
		
		ordenarFechaNacimiento(obtenerPersonas);	
			
		List<PersonaReporte> personasReporte=new ArrayList<>();
		Map<String,ArrayList<PersonaReporte>> personasReporteOrdenado=new TreeMap<>();
		
		
		for(PersonaDTO persona: obtenerPersonas)
		{
			personasReporte.add(new PersonaReporte(persona));
			
		}
		
		
		for(PersonaReporte persona:personasReporte)
		{
			if (!personasReporteOrdenado.containsKey(persona.getSigno()))
			{
				personasReporteOrdenado.put(persona.getSigno(),new ArrayList<PersonaReporte>());
				
			}
			personasReporteOrdenado.get(persona.getSigno()).add(persona);
			
		}
		
	
		
		personasReporte=new ArrayList<>();
		
		for(String signo: personasReporteOrdenado.keySet())
		{
			personasReporte.addAll(personasReporteOrdenado.get(signo));
			
		}
		
		
		
		
		
		return personasReporte;
			
			
		}

		private void ordenarFechaNacimiento(List<PersonaDTO> obtenerPersonas) {
			Collections.sort(obtenerPersonas, new Comparator<PersonaDTO>() {
				   public int compare(PersonaDTO obj1, PersonaDTO obj2) {
				      return obj1.getCumpleaños().compareTo(obj2.getCumpleaños());
				   }
				});
			
		
		}

		

	
		}

