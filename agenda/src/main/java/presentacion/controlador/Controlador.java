package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaTipo;
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
		private VentanaLocalidad ventanaLocalidad;
		private VentanaTipo ventanaTipo;
		private Agenda agenda;
		private List<Localidad> localidades_en_tabla;
		private List<Tipo> tipos_en_tabla;
		
		
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
		
		private void llenarComboBox(){
			this.ventanaPersona.getComboBoxLocalidad().removeAllItems();
			this.ventanaPersona.getComboBoxTipo().removeAllItems();
			this.localidades_en_tabla=agenda.obtenerLocalidades();
			
			for (int i = 0; i < this.localidades_en_tabla.size(); i ++){

				this.ventanaPersona.getComboBoxLocalidad().addItem(this.localidades_en_tabla.get(i).getNombre());
			}
			
			this.tipos_en_tabla=agenda.obtenerTipos();
			for (int i = 0; i < this.tipos_en_tabla.size(); i ++){
				
				this.ventanaPersona.getComboBoxTipo().addItem(this.tipos_en_tabla.get(i).getTipo());
			}
			
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = {this.personas_en_tabla.get(i).getNombre(), this.personas_en_tabla.get(i).getTelefono(),this.personas_en_tabla.get(i).getEmail(),this.personas_en_tabla.get(i).getCumpleaños()};
				this.vista.getModelPersonas().addRow(fila);
			}			
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				System.out.println(agenda);
				System.out.println("Ventana persona");
				
				this.ventanaPersona = new VentanaPersona(this);
				this.llenarComboBox();
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
				
				nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText(),ventanaPersona.getTxtCalle().getText(),ventanaPersona.getTxtCumple().getText());
				
				this.agenda.agregarPersona(nuevaPersona);
				this.llenarTabla();
				this.ventanaPersona.dispose();
			}
			else if(e.getSource()== this.ventanaPersona.getBtnAgregarLocalidad())
			{
				System.out.println("ventanalocalidad");
				this.ventanaLocalidad = new VentanaLocalidad(this);
			}
			else if (e.getSource()==this.ventanaPersona.getBtnAgregarTipo())
			{
				System.out.println("ventanaTipo");
				this.ventanaTipo = new VentanaTipo(this);
			}
			else if (!(this.ventanaTipo==null) && e.getSource()==this.ventanaTipo.getBtnConfirmarTipo()  )
			{
				
				Tipo nuevoTipo;
				nuevoTipo=new Tipo(0,ventanaTipo.getTxtNombre().getText());
				this.agenda.agregarTipo(nuevoTipo);
				this.llenarComboBox();
				this.ventanaTipo.dispose();
			}
			
			else if (e.getSource()==this.ventanaLocalidad.getBtnConfirmarLocalidad())
			{
				Localidad nuevaLocalidad;
				
				System.out.println(agenda);
				nuevaLocalidad=new Localidad(0,ventanaLocalidad.getTxtNombre().getText());
				
				this.agenda.agregarLocalidad(nuevaLocalidad);
				this.llenarComboBox();
				this.ventanaLocalidad.dispose();
			}
			
			
			
			
			
		}

}