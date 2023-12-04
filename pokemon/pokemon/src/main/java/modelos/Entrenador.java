package modelos;
public class Entrenador {
	private Long id;

	private String nombre;
	private boolean active;

	@Override
	public String toString() {
		return "Entrenador [id=" + id + ", nombre=" + nombre + ", active=" + active + "]";
	}

	public Entrenador(Long id, String nombre, boolean active) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.active = active;
	}

	public Entrenador() {

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
}