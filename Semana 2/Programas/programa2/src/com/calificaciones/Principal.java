package com.calificaciones;

import java.util.Scanner;

public class Principal {

	// Variables estáticas que le pertenecen a la clase
	static Scanner sc = new Scanner(System.in);
	static Integer cal1,cal2,cal3;
	static String nombre;
	
	public static void main(String[] args) {
		
		System.out.println("Ingresa tu nombre:");
		nombre = sc.next();
		
		System.out.println("Calificación del primer periodo:");
		cal1 = sc.nextInt();
		
		System.out.println("Calificación del segundo periodo:");
		cal2 = sc.nextInt();
		
		System.out.println("Calificación del tercer periodo:");
		cal3 = sc.nextInt();
		sc.close();
		
		// Se llama al método estático por medio de su clase
		// Se le pasan los parámetros de tipo Integer
		Calificaciones.calificaciones(nombre, cal1, cal2, cal3); // Imprime un String con el nombre y calificaciones
		
		Calificaciones.calificaciones(cal1, cal2, cal3); // Imprime el promedio
		
		
	}

}
