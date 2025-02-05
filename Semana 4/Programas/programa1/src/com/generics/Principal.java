package com.generics;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		
		// Se crea un objeto indicando en el generic que será de tipo Libro
		Biblioteca<Libro> b1 = new Biblioteca<>
							(new Libro("El señor de los anillos","J.R.R Tolkien"));
		
		// El siguiente objeto será de tipo Periodico
		Biblioteca<Periodico> b2 = new Biblioteca<>
							(new Periodico("El Universal",500,LocalDate.of(2025, 02, 04)));
		
		// El último objeto de tipo Revista
		Biblioteca<Revista> b3 = new Biblioteca<>(new Revista("Revista1",50));
		
		// El primer objeto es de tipo Libro, se puede asignar a una variable de ese mismo tipo
		// El método getE() permite obtener el objeto
		Libro libro = b1.getE();
		System.out.println(libro); // Imprime la información del objeto de tipo Libro (toString)
		
		// También es posible obtener atributos
		System.out.println("Periodico: " + b2.getE().getNombre()); // Imprime solo el atributo nombre del objeto Periodico
		
		System.out.println(b3.getE());
		
		// Se define un arreglo de objetos
		Object[] biblioteca = {b1,b2,b3,"hola"};
		// Se llama al método para iterar y mostrar los elementos del arreglo
		mostrar(biblioteca);
	}
	
	// Se define un generic en un método
	// Recibe un arreglo de cualquier tipo
	public static <E> void mostrar(E[] lista){
		System.out.println("----------");
		for (E e : lista) {
			System.out.println(e); // Imprime los elementos del arreglo
		}
	}
}
