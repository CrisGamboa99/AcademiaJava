package com.escuela;

import java.time.LocalTime;
import java.util.Objects;

public class Materia {

	private String nombre;
	
	public Materia(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + "]";
	}
	
	public void asignarMateria() {
		System.out.println("Materia asignada: " + nombre);
	}
}
