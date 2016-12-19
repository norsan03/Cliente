package es.uc3m.tiw.dominios;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMINISTRADORES")
public class Administrador {
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		@Column(length = 25, nullable = false)
		private String email;
		@Column(length = 25, nullable = false)
		private String password;
			
		
		public Administrador() {
		}
			
		public Administrador(long id, String password, String email) {
			super();
			this.id = id;
			this.password = password;
			this.email = email;
			}
			
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}		
		public String getPassword() {
			return password;
		}		
		public void setPassword(String password) {
			this.password = password;
		}		
		public String getEmail() {
			return email;
		}		
		public void setEmail(String email) {
			this.email = email;
		}
}
