package es.uc3m.tiw;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uc3m.tiw.Daos.AdministradorRepository;
import es.uc3m.tiw.dominios.Administrador;



@SpringBootApplication
public class ClienteSpringApplication {

	
	@Autowired
	private AdministradorRepository repositoryadmin;

	public static void main(String[] args) {
		SpringApplication.run(ClienteSpringApplication.class, args);
	}
	

	
	
	@PostConstruct
	public void init() {
		Set<Administrador> admin = new HashSet<>();
		
		admin.add(new Administrador(0,  "admin","admin@admin.es"));
		repositoryadmin.save(admin);
		

	}
	

}
