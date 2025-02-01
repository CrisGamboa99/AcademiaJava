package com.escuela;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Escuela {
	
	private String nombre;
	private List<Aula> listaAulas;
	private Set<Profesor> listaProfesores;
	
	public Escuela(String nombre, Set<Profesor> listaProfesores) {
		this.nombre = nombre;
		listaAulas = new ArrayList<>();
		this.listaProfesores = listaProfesores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Aula getAula(String grupo, int numBancas) {
		int i = listaAulas.indexOf(new Aula(grupo, numBancas));
		Aula aula = null;
		if (i == -1)
			return null;
		else
			aula = listaAulas.get(i);
		return new Aula(aula.getGrupo(), aula.getNumBancas());
	}

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
