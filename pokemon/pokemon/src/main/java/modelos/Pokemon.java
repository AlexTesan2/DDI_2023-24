package modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;

	public Pokemon(Long id, String nombre, Region region) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.region = region;
	}

	public Pokemon() {

	}


	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", region=" + region + "]";
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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}

