package presentacion.reportes;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class ReporteAgenda
{
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	private Logger log = Logger.getLogger(ReporteAgenda.class);
	private String reportSource = "reportes" + File.separator + "ReporteAgenda.jrxml";
	//Recibe la lista de personas para armar el reporte
    public ReporteAgenda(List<PersonaReporte> list)
    {
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
    	try		{
    	
    		JasperCompileManager.compileReportToFile(reportSource,"reportes" + File.separator + "ReporteAgenda.jasper");
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile("reportes" + File.separator + "ReporteAgenda.jasper");
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(list));
			
    		log.info("Se cargÃ³ correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("OcurriÃ³ un error mientras se cargaba el archivo ReporteAgenda.Jasper", ex);
			
		}
    }       
    
    public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
   
}	