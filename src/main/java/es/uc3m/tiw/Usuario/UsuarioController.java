package es.uc3m.tiw.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.dominios.Usuario;
import es.uc3m.tiw.repositorio.UsuarioDao;

@RestController
public class UsuarioController {

@Autowired
private UsuarioDao usuarioDao;

	@RequestMapping(value="/registroUsuario", method = RequestMethod.POST)
	public @ResponseBody Usuario registrarUsuario(@RequestBody Usuario usuarioARegistrar){
	usuarioDao.save(usuarioARegistrar); //guardar, editar, borrar, findbyOne(Primary key) son métodos que vienen implementados ya en el CrudRepository
	return usuarioARegistrar;
	}
	
	@RequestMapping(value="/eliminarUsuario", method = RequestMethod.DELETE)
    public @ResponseBody Usuario eliminarUsuario(Usuario usuarioAEliminar){
    usuarioDao.delete(usuarioAEliminar);
    return usuarioAEliminar;
    }

	@RequestMapping(value="/login" ,method = RequestMethod.POST)
	public  @ResponseBody Usuario login(@RequestBody Usuario usuarioPendiente){
	Usuario usuarioLogeado = null;
	List <Usuario> usuarios = usuarioDao.findAll();
	usuarioLogeado = comprobarUsuario(usuarios, usuarioPendiente.getEmail(),usuarioPendiente.getPassword()); 
	return usuarioLogeado;
	}
	
    private Usuario comprobarUsuario( List<Usuario> usuarios, String email, String password) {
            Usuario u = null;
            for (Usuario usuario : usuarios) {
                    if (email.equals(usuario.getEmail()) && password.equals(usuario.getPassword())){
                            u = usuario;
                            //break;
                    }
            }
            return u;
    	} 
    
}