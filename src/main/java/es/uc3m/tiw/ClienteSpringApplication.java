package es.uc3m.tiw;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uc3m.tiw.Daos.AdministradorRepository;
import es.uc3m.tiw.Daos.UsuarioRepository;
import es.uc3m.tiw.dominios.Usuario;
import es.uc3m.tiw.dominios.Administrador;


@SpringBootApplication
public class ClienteSpringApplication {

	@Autowired
	private UsuarioRepository repositoryUsuarios;
	private AdministradorRepository repositoryAdmin;
	
	public static void main(String[] args) {
		SpringApplication.run(ClienteSpringApplication.class, args);
	}
	
	
	@PostConstruct
	public void init() {
		Set<Usuario> usuarios = new HashSet<>();
		Set<Administrador> administrador = new HashSet<>();
		
		usuarios.add(new Usuario(0, "Miguel", "Torrejón", "Madrid", "mi@gmail.com", "1234"));
		usuarios.add(new Usuario(0, "Miguel", "Torrejón", "Madrid", "mi@gmail.com", "1234"));
		usuarios.add(new Usuario(0, "Miguel", "Torrejón", "Madrid", "mi@gmail.com", "1234"));
		usuarios.add(new Usuario(0, "Miguel", "Torrejón", "Madrid", "mi@gmail.com", "1234"));
		
		administrador.add(new Administrador(0, "admin@admin.admin", "admin"));

		repositoryUsuarios.save(usuarios);
		repositoryUsuarios.flush();
		
		repositoryAdmin.save(administrador);
		repositoryAdmin.flush();
	}

}
