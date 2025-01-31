package com.escuela;

import java.time.LocalTime;
import java.util.Objects;

public class Materia {

	private String nombre;
	private LocalTime horario;
	
	public Materia(String nombre, LocalTime horario) {
		this.nombre = nombre;
		this.horario = horario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
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
		return "Materia [nombre=" + nombre + ", horario=" + horario + "]";
	}
	
}
