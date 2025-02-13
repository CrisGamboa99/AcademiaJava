package usuarios;

import java.util.Objects;

public class UsuarioDto {

	final Long id;
	final String nombre;
	
	public UsuarioDto(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDto other = (UsuarioDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
}
