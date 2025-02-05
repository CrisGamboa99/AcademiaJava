package com.generics;

public class Revista {

	private String nombre;
	private int numero;
	
	public Revista(String nombre, int numero) {
		this.nombre = nombre;
		this.numero = numero;
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

	@Override
	public String toString() {
		return "Revista [nombre=" + nombre + ", numero=" + numero + "]";
	}
	
}
