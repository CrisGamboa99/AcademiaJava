package estudiante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Para que sea inmutable, la clase es final
public final class Estudiante {
	
	// Los atributos son private y final
	private final StringBuilder nombre;
	private final StringBuilder apellido;
	private final LocalDate fechaNacimiento;
	private final List<String> materias;
	
	public Estudiante(StringBuilder nombre, StringBuilder apellido,
			LocalDate fechaNacimiento, List<String> materias) {
		// Ya que se usan StringBuilder, se crea una copia para que no se puedan modificar
		this.nombre = new StringBuilder(nombre);
		this.apellido = new StringBuilder(apellido);
		this.fechaNacimiento = fechaNacimiento;
		// También se crea una copia del ArrayList para que no se modifique
		this.materias = new ArrayList<String>(materias);
	}

	// Se crean los getters de los atributos
	// Para que sea inmutable no se pueden crear setters
	public StringBuilder getNombre() {
		return new StringBuilder(nombre); // Regresa una copia del StringBuilder
	}

	public StringBuilder getApellido() {
		return new StringBuilder(apellido);
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public List<String> getMaterias() {
		return new ArrayList<String>(materias); // Regresa una copia del ArrayList
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" 
				+ apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", materias=" + materias + "]";
	}
	
}
