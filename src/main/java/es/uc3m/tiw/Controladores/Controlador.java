package es.uc3m.tiw.Controladores;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.Daos.AdministradorRepository;
import es.uc3m.tiw.Daos.UsuarioRepository;
import es.uc3m.tiw.dominios.Administrador;
import es.uc3m.tiw.dominios.Producto;
import es.uc3m.tiw.dominios.Usuario;

@RestController
public class Controlador {

@Autowired
private UsuarioRepository usuarioDao;
@Autowired
private AdministradorRepository administradorDao;




	
	@RequestMapping(value="/registroUsuario", method = RequestMethod.POST)
	public @ResponseBody Usuario registrarUsuario(@RequestBody Usuario usuarioARegistrar){
	usuarioDao.save(usuarioARegistrar); //guardar, editar, borrar, findbyOne(Primary key) son métodos que vienen implementados ya en el CrudRepository
	return usuarioARegistrar;
	}
	
	@RequestMapping(value = "/modificarUsuario", method = RequestMethod.POST)
	public @ResponseBody Usuario modificarUsuario (@RequestBody Usuario usuarioModificado){
		usuarioDao.saveAndFlush(usuarioModificado);
		return usuarioModificado;
	}

	
	/*@RequestMapping(value="/eliminarUsuario/{id}", method=RequestMethod.POST)
	public void eliminarUsuario(@PathVariable(value = "id") Integer id){
		Usuario usuarioABorrar = usuarioDao.findById(id);
		usuarioDao.delete(usuarioABorrar);
		return;
	}*/
	
	@RequestMapping(value="/eliminarUsuario/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void eliminarUsuario(@PathVariable long id){	
    	usuarioDao.delete(id);
    	
    	
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