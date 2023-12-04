package modelos;

public class Pokemon {
	private int id;
	private String nombre;
	private int region;

	public Pokemon(int id, String nombre, int region) {
		this.id = id;
		this.nombre = nombre;
		this.region = region;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", region=" + region + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}
}
