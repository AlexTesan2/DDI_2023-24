package modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entrenador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private boolean active;
	private String username;

	public Entrenador(Long id, String nombre, boolean active, String username) {
		this.id = id;
		this.nombre = nombre;
		this.active = active;
		this.username = username;
	}

	public Entrenador() {

	}

	@Override
	public String toString() {
		return "Entrenador [id=" + id + ", nombre=" + nombre + ", active=" + active + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}