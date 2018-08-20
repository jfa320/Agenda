package persistencia.dao.interfaz;

import java.util.List;

import dto.Localidad;


public interface LocalidadDAO {
	
	public boolean insert(Localidad localidad);

	public boolean delete(Localidad localidad_a_eliminar);
	
	public List<Localidad> readAll();
}
