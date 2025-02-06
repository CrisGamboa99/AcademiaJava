package com.optional;

import java.util.Optional;

class Estudiante {
	private String nombre;
	private String apellido;
	private int edad;
	
	public Estudiante(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}
	
}

public class Principal {

	public static void main(String[] args) {

		Estudiante estudiante = null;
		String st1 = "Hola";
		String st2 = null;
		
		// Se usa Optional.ofNullable para envolver el objeto
		Optional<Object> e1 = Optional.ofNullable(new Estudiante("Cristian", "Gamboa", 26));
		Optional<Object> e2 = Optional.ofNullable(new Estudiante("Eduardo", "Escobedo", 22));
		Optional<Object> e3 = Optional.ofNullable(estudiante);
		Optional<Object> s1 = Optional.ofNullable(st1);
		Optional<Object> s2 = Optional.ofNullable(st2);
		
		// El método get lanzará una excepción si no hay valor
		//e3.get();
		
		Object[] lista = {e1,e2,e3,s1,s2};
		
		// Se itera en el array
		// En el caso de que se tenga un null se muestra Optional.empty
		for (Object o : lista) {
			System.out.println(o);
		}
	}

}
