package dto;

import java.sql.Date;

public class PersonaReporte 
{
	private String nombre;
	private java.sql.Date cumpleaños;
	private String signo;
	
	
	public PersonaReporte(PersonaDTO persona)
	{
		this.nombre=persona.getNombre();
		this.cumpleaños=persona.getCumpleaños();
		this.signo=getSigno(cumpleaños);
		
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





	public java.sql.Date getCumpleaños() {
		return cumpleaños;
	}





	public void setCumpleaños(java.sql.Date cumpleaños) {
		this.cumpleaños = cumpleaños;
	}





	public String getSigno() {
		return signo;
	}





	public void setSigno(String signo) {
		this.signo = signo;
	}
	
	
	
}