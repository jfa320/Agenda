package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.Domicilio;
import dto.Localidad;
import dto.PersonaDTO;
import dto.Tipo;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.agenda = agenda;
			this.personas_en_tabla = null;
		}
		
		public void inicializar()
		{
			this.llenarTabla();
			this.vista.show();
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = {this.personas_en_tabla.get(i).getNombre(), this.personas_en_tabla.get(i).getTelefono()};
				this.vista.getModelPersonas().addRow(fila);
			}			
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				this.ventanaPersona = new VentanaPersona(this);
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
			else if(e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{	
				PersonaDTO nuevaPersona;
				
				if(agenda.obtenerPersonas().isEmpty()){
					
					Localidad nuevaLocalidad=new Localidad(0,ventanaPersona.getComboBox_localidad());
					
					Domicilio nuevoDomicilio= new Domicilio(0,ventanaPersona.getTxtCalle().getText(),ventanaPersona.getTxtAltura().getText(),nuevaLocalidad);
					
					Tipo nuevoTipo=new Tipo(0,ventanaPersona.getComboBox_tipoContacto());
					
					 nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText(),nuevoTipo,nuevoDomicilio,"cumple","mail");
				}
				else{
					Localidad nuevaLocalidad=new Localidad(0,ventanaPersona.getComboBox_localidad());
					
					Domicilio nuevoDomicilio= new Domicilio(0,ventanaPersona.getTxtCalle().getText(),ventanaPersona.getTxtAltura().getText(),nuevaLocalidad);
					
					Tipo nuevoTipo=new Tipo(0,ventanaPersona.getComboBox_tipoContacto());
					
					nuevaPersona = new PersonaDTO(agenda.obtenerPersonas().size(),this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText(),nuevoTipo,nuevoDomicilio,"cumple","mail");
				}
				this.agenda.agregarPersona(nuevaPersona);
				this.llenarTabla();
				this.ventanaPersona.dispose();
			}
		}

}