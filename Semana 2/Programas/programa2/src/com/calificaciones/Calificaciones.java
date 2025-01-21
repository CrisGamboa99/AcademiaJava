package com.calificaciones;

public class Calificaciones {
	
	static void calificaciones(int cal1, int cal2, int cal3) {
		double total = (cal1 + cal2+ cal3)/3;
		Double promedio = total;
		System.out.println("El promedio es " + promedio);
	}
	
	static void calificaciones(String nombre, 
			int cal1, int cal2, int cal3) {
		System.out.println(nombre 
				+ ", tus calificaciones son: " 
				+ cal1 + ", " + cal2 + ", " + cal3);
	}
}
