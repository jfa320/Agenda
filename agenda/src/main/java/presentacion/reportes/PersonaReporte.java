package presentacion.reportes;

import java.sql.Date;

import dto.PersonaDTO;

public class PersonaReporte 
{
	private String nombre;
	private String cumpleaños;
	private String signo;
	private String telefono;
	
	
	public PersonaReporte(PersonaDTO persona)
	{
		this.nombre=persona.getNombre();
		this.cumpleaños=this.convertirFecha(persona.getCumpleaños());
		this.signo=getSigno(persona.getCumpleaños());
		this.telefono=persona.getTelefono();
	}
	
	
	
	
	
	public String getSigno(Date nacimiento)
	{
        String horoscopo = "";
       
        int resto = (nacimiento.getYear()+1900) % 12;
        System.out.println(resto);
        switch (resto) {
            case 0: horoscopo = "Mono"; break;
            case 1: horoscopo = "Gallo"; break;
            case 2: horoscopo = "Perro"; break;
            case 3: horoscopo = "Cerdo"; break;
            case 4: horoscopo = "Rata"; break;
            case 5: horoscopo = "Buey"; break;
            case 6: horoscopo = "Tigre"; break;
            case 7: horoscopo = "Conejo"; break;
            case 8: horoscopo = "Dragon"; break;
            case 9: horoscopo = "Serpiente"; break;
            case 10: horoscopo = "Caballo"; break;
            case 11: horoscopo = "Cabra"; break;
        }
        return horoscopo;
}





	@Override
	public String toString() {
		return "PersonaReporte [nombre=" + nombre + ", cumpleaños=" + cumpleaños + ", signo=" + signo + "]";
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getCumpleaños() {
		return cumpleaños;
	}





	public void setCumpleaños(java.sql.Date cumpleaños) {
		this.cumpleaños = this.convertirFecha(cumpleaños);
	}





	public String getSigno() {
		return signo;
	}





	public void setSigno(String signo) {
		this.signo = signo;
	}
	
	public String getTelefono(){
		return this.telefono;
	}
	
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	private String convertirFecha(Date cumpleaños) {
		return String.valueOf(cumpleaños.getDate()) + "/" + (String.valueOf(cumpleaños.getMonth()+1)) + "/" +(String.valueOf(cumpleaños.getYear()+1900));
	}
	
}