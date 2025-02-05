package com.generics;

// Se define una clase con un generic
public class Biblioteca <E>{

	// Se tiene un atributo de tipo generic
	private E e;

	// Se definen su constructor y getters y setters
	public Biblioteca(E e) {
		this.e = e;
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return e.getClass().getSimpleName() + " [e=" + e + "]";
	}
}
