package estudiante;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		// Se crean las variables que se pasarán como parámetros del objeto
		StringBuilder nombre = new StringBuilder("Cristian");
		StringBuilder apellido = new StringBuilder("Gamboa");
		LocalDate nacimiento = LocalDate.of(1999, 01, 18);
		
		List<String> materias = new ArrayList<>();
		materias.add("Español");
		materias.add("Matemáticas");
		materias.add("Inglés");
		materias.add("Programación");
		
		// Se inicializa el objeto y se imprime
		Estudiante est = new Estudiante(nombre, apellido, nacimiento, materias);
		System.out.println(est);
		
		// Se intenta cambiar el valor de los objetos
		// No hay un cambio ya que la clase es inmutable
		nombre.append(" Eduardo");
		apellido.append(" Escobedo");
		nacimiento = nacimiento.plusMonths(2);
		materias.remove(0);
		System.out.println(est);
	}

}
