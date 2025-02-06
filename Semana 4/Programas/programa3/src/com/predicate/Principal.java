package com.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Calificacion {
	private String materia;
	private double calificacion;
	private int parcial;
	
	public Calificacion(String materia, double calificacion, int parcial) {
		this.materia = materia;
		this.calificacion = calificacion;
		this.setParcial(parcial);
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public int getParcial() {
		return parcial;
	}

	public void setParcial(int parcial) {
		this.parcial = parcial;
	}

	@Override
	public String toString() {
		return "Calificacion [materia=" + materia + ", calificacion=" + calificacion + ", parcial=" + parcial + "]";
	}
	
}

public class Principal {

	public static void main(String[] args) {
		
		List<Calificacion> calificaciones = new ArrayList<>();
		
		calificaciones.add(new Calificacion("Matemáticas", 8, 1));
		calificaciones.add(new Calificacion("Matemáticas", 7, 2));
		calificaciones.add(new Calificacion("Programacion", 10, 1));
		calificaciones.add(new Calificacion("Inglés", 7, 1));
		calificaciones.add(new Calificacion("Programacion", 9, 2));
		
		// Se define una variable de referencia de tipo predicate
		//Se define el contrato. Se recibe un valor del tipo definido por el generic y regresa un booleano
		Predicate<Calificacion> pr1 = c -> c.getParcial() == 1; // Regresa true si el percial es 1
		Predicate<Calificacion> pr2 = c -> c.getCalificacion() > 7; // Regresa true si la calificación es mayor a 7
		Predicate<Calificacion> pr3 = c -> c.getMateria().startsWith("P"); // Regresa true si la materia inicia con P
		
		System.out.println("-----Materia que inicia con P-----");
		mostrar(calificaciones, pr3);
		
		System.out.println("-----Primer parcial-----");
		mostrar(calificaciones, pr1);
		
		System.out.println("-----Calificaciones mayores a 7-----");
		mostrar(calificaciones, pr2);
	}

	// Se define un método estático para iterar sobre la lista 
	// y mostrar solo los elementos que cumplan con lo definido por los predicate
	static void mostrar(List<Calificacion> lista, Predicate<Calificacion> pr) {
		for (Calificacion c : lista) {
			if (pr.test(c)) // El método test es definido por la interfaz Predicate
				System.out.println(c);
		}
	}
}
