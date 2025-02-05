package com.generics;

import java.time.LocalDate;

public class Periodico {

	private String nombre;
	private int numero;
	private LocalDate fechaPublicacion;
	
	public Periodico(String nombre, int numero, LocalDate fechaPublicacion) {
		this.nombre = nombre;
		this.numero = numero;
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Override
	public String toString() {
		return "Periodico [nombre=" + nombre + ", numero=" + numero + ", fechaPublicacion=" + fechaPublicacion + "]";
	}
	
}
