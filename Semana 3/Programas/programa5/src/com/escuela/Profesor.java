package com.escuela;

import java.time.LocalTime;
import java.util.Objects;

public class Profesor {

	private String nombre;
	private String apellido;
	private Materia materia;

	public Profesor(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Profesor(String nombre, String apellido, Materia materia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.materia = materia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, apellido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	public void materiaAsignada() {
		System.out.println("Profesor: " + nombre + " " + apellido);
		materia.asignarMateria();
	}
}
