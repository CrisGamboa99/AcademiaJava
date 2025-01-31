package com.escuela;

import java.util.Objects;

public class Aula {

	private String grupo;
	private int numBancas;
	
	public Aula(String grupo, int numBancas) {
		this.grupo = grupo;
		this.numBancas = numBancas;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getNumBancas() {
		return numBancas;
	}

	public void setNumBancas(int numBancas) {
		this.numBancas = numBancas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(grupo, other.grupo);
	}

	@Override
	public String toString() {
		return "Aula [grupo=" + grupo + ", numBancas=" + numBancas + "]";
	}
}
