package es.uc3m.tiw.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

	List<Usuario> findAll();
	
	Usuario findByNombre(String nombre);
	
	Usuario findById(int id);
}
