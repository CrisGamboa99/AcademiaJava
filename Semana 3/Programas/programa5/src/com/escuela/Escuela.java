package com.escuela;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Escuela {
	
	// HAS-A
	private String nombre;
	
	// Se tiene una relación de composición con Aula
	private List<Aula> listaAulas;
	
	// Se tiene una relación de agregación con Profesor
	private Set<Profesor> listaProfesores;
	
	public Escuela(String nombre, Set<Profesor> listaProfesores) {
		this.nombre = nombre;
		
		// Al tener la relación de composición, se crea directamente la listaAulas desde el constructor
		listaAulas = new ArrayList<>();
		this.listaProfesores = listaProfesores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// El método getAula devolverá una copia del objeto
	public Aula getAula(String grupo, int numBancas) {
		int i = listaAulas.indexOf(new Aula(grupo, numBancas));
		Aula aula = null;
		if (i == -1)
			return null;
		else
			aula = listaAulas.get(i);
		return new Aula(aula.getGrupo(), aula.getNumBancas());
	}

	// Se añade un elemento directamente a la lista ya creada para evitar que sea independiente
	public void setAula(Aula aula) {
		listaAulas.add(aula);
	}

	public Set<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(Set<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
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
		Escuela other = (Escuela) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Escuela [nombre=" + nombre + ", listaAulas=" + listaAulas + ", listaProfesores=" + listaProfesores + "]";
	}
	
}
