package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.Tipo;
import presentacion.vista.VentanaABMTipos;
import modelo.Agenda;


public class ControladorABMTipos implements ActionListener {

	private VentanaABMTipos vistaABM;
	private Agenda agenda;
	private List<Tipo> tipos;



	public ControladorABMTipos(VentanaABMTipos vistaABM, Agenda agenda)
	{
		this.vistaABM = vistaABM;
		
		this.agenda = agenda;
		this.tipos=agenda.obtenerTipos();
		
		
		this.llenarTabla();
		this.vistaABM.getBtnAgregar().addActionListener(this);
		this.vistaABM.getBtnEditar().addActionListener(this);
		this.vistaABM.getBtnBorrar().addActionListener(this);
	}
	
	
	
	private void llenarTabla() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
