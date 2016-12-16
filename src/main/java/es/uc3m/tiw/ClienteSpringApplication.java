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


	
	public static void main(String[] args) {
		SpringApplication.run(ClienteSpringApplication.class, args);
	}
	


}
