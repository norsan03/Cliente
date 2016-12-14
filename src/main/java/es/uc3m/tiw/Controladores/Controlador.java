package es.uc3m.tiw.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.Daos.AdministradorRepository;
import es.uc3m.tiw.Daos.UsuarioRepository;
import es.uc3m.tiw.dominios.Administrador;
import es.uc3m.tiw.dominios.Usuario;

@RestController
public class Controlador {

@Autowired
private UsuarioRepository usuarioDao;
private AdministradorRepository administradorDao;


	
	@RequestMapping(value="/registroUsuario", method = RequestMethod.POST)
	public @ResponseBody Usuario registrarUsuario(@RequestBody Usuario usuarioARegistrar){
	usuarioDao.save(usuarioARegistrar); //guardar, editar, borrar, findbyOne(Primary key) son métodos que vienen implementados ya en el CrudRepository
	return usuarioARegistrar;
	}
	
	@RequestMapping(value="/editarUsuario", method = RequestMethod.POST)
    public @ResponseBody Usuario editarUsuario(Usuario usuarioAEditar){
	        usuarioAEditar.setNombre(usuarioAEditar.getNombre());
	        usuarioAEditar.setApellidos(usuarioAEditar.getApellidos());
	        usuarioAEditar.setCiudad(usuarioAEditar.getCiudad());
	        usuarioAEditar.setEmail(usuarioAEditar.getEmail());
	        usuarioAEditar.setPassword(usuarioAEditar.getPassword());
	        usuarioDao.save(usuarioAEditar);	        
    return usuarioAEditar;
    }
	
	@RequestMapping(value="/eliminarUsuario", method = RequestMethod.DELETE)
    public @ResponseBody Usuario eliminarUsuario(Usuario usuarioAEliminar){
    usuarioDao.delete(usuarioAEliminar);
    return usuarioAEliminar;
    }

	@RequestMapping(value="/validar" ,method = RequestMethod.POST)
	public  @ResponseBody Usuario loginUsuario(@RequestBody Usuario usuarioPendiente){
	Usuario usuarioLogeado = null;
	List <Usuario> usuarios = usuarioDao.findAll();
	usuarioLogeado = comprobarUsuario(usuarios, usuarioPendiente.getEmail(),usuarioPendiente.getPassword()); 
	return usuarioLogeado;
	}
	
	@RequestMapping(value="/verPerfilUsuario", method = RequestMethod.GET)
    public @ResponseBody Usuario verPerfilUsuario(Usuario usuarioAMostrar){
		usuarioAMostrar.getNombre();
		usuarioAMostrar.getApellidos();
		usuarioAMostrar.getCiudad();
		usuarioAMostrar.getEmail();
		usuarioAMostrar.getPassword();
    return usuarioAMostrar;
    }
	
	@RequestMapping(value="/loginAdministrador" ,method = RequestMethod.POST)
    public  @ResponseBody Administrador loginAdministrador(@RequestBody Administrador administradorPendiente){
		Administrador administradorLogeado = null;
    	List <Administrador> administradores = administradorDao.findAll();
    	administradorLogeado = comprobarAdministrador(administradores, administradorPendiente.getEmail(),administradorPendiente.getPassword());
    	return administradorLogeado;
    }
	
    private Usuario comprobarUsuario( List<Usuario> usuarios, String email, String password) {
            Usuario u = null;
            for (Usuario usuario : usuarios) {
                    if (email.equals(usuario.getEmail()) && password.equals(usuario.getPassword())){
                            u = usuario;
                            break;
                    		}
            		}
            return u;
    	} 
 
    private Administrador comprobarAdministrador( List<Administrador> administradores, String email, String password) {
        Administrador ad = null;
        for (Administrador administrador : administradores) {
                if (email.equals(administrador.getEmail()) && password.equals(administrador.getPassword())){
                        ad = administrador;
                        //break;
                		}
        		}
        return ad;
	}
}
