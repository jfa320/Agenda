package persistencia.dao.interfaz;

import java.util.List;

import dto.Tipo;



public interface TipoDAO {
	
	public boolean insert(Tipo tipo);

	public boolean delete(Tipo tipo_a_eliminar);
	
	public List<Tipo> readAll();
}
