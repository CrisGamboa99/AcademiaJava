package com.escuela;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		
		// Se crea lista de profesores para añadirla como atributo al bjeto de Escuela
		Set<Profesor> profesores = new HashSet<>();
		
		// Se añaden elementos a la lista
		profesores.add(new Profesor("Cristian", "Gamboa"));
		profesores.add(new Profesor("Eduardo", "Escobedo"));
		profesores.add(new Profesor("Juan", "Pérez"));
		
		// Se crea el objeto Escuela
		Escuela escuela = new Escuela("Benito Juárez", profesores);
		
		// Se añaden elementos de Aula (clase que tiene la relación de composición con Escuela)
		escuela.setAula(new Aula("1° A", 20));
		escuela.setAula(new Aula("3° C", 30));
		escuela.setAula(new Aula("1° B", 26));
		escuela.setAula(new Aula("2° A", 21));
		escuela.setAula(new Aula("4° C", 25));
		
		Profesor profesor = getProfesor(profesores, "Cristian","Gamboa");
		
		// Se añade una Materia por medio de la delegación
		profesor.setMateria(new Materia("Programación"));
		
		if(profesor!=null) {
			profesor.materiaAsignada();
		}
	}

	// Método para obtener un profesor
	private static Profesor getProfesor(Set<Profesor> profesores, String nombre, String apellido) {
		Iterator<Profesor> i = profesores.iterator();
		
		while(i.hasNext()) {
			Profesor profesor = i.next();
			if(nombre.equals(profesor.getNombre()) && apellido.equals(profesor.getApellido()))
				return profesor;
		}
		
		return null;
	}
}
