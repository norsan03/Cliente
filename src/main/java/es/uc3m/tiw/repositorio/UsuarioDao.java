package es.uc3m.tiw.repositorio;

import java.util.List;
import org.springframework.*;
import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioDao  extends CrudRepository<Usuario, Long> {

	List<Usuario> findAll();
	
	Usuario findByNombre(String nombre);
}
