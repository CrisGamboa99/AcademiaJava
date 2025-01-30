package com.hashset;

import java.util.Objects;

public class Canciones {

	// Se crean variables de instancia para el objeto
	private String cancion;
	private String artista;
	private int year;
	
	// Un constructor para asignar valores a las variables de instancia
	public Canciones(String cancion, String artista, int year) {
		super();
		this.cancion = cancion;
		this.artista = artista;
		this.year = year;
	}

	// Se sobrescribe el hashcode para asignar un identificador a las variables cancion
	// de los objetos creados
	@Override
	public int hashCode() {
		return Objects.hash(cancion);
	}

	// Se sobrescribe equals para saber comparar los valores de los objetos
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Canciones other = (Canciones) obj;
		return Objects.equals(artista, other.artista) && Objects.equals(cancion, other.cancion) && year == other.year;
	}

	@Override
	public String toString() {
		return "Canciones [cancion=" + cancion + ", artista=" + artista + ", year=" + year + "]";
	}
	
	
}
