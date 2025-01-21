package com.calificaciones;

public class Calificaciones {
	// Se hace el overloading al tener dos métodos con el mismo 
	// nombre, pero diferente firma
	// Se hace unboxing, ya que las variables de la firma (parametros)
	// en ambos métodos son de tipo int, pero las variables que se 
	// pasan desde la otra clase son Integer
	// Los métodos son estáticos
	static void calificaciones(int cal1, int cal2, int cal3) {
		double total = (cal1 + cal2+ cal3)/3;
		Double promedio = total; // Autoboxing
		System.out.println("El promedio es " + promedio); // Imprime el promedio de calificaciones
	}
	
	static void calificaciones(String nombre, 
			int cal1, int cal2, int cal3) {
		System.out.println(nombre 
				+ ", tus calificaciones son: " 
				+ cal1 + ", " + cal2 + ", " + cal3); // Imprime el String
	}
}
