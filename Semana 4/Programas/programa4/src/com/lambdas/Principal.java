package com.lambdas;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Principal {
	
	public static void main(String[] args) {

		String[] nombres = {"Cristian","Roberto","Brandon","Eduardo"};
		int[] numeros = {3,6,2,8,5};
		Object[] productos = {"Libros","Lapices","Gomas","Plumas"};
		
		// El UnaryOperator recibe un String y devuelve un String
		// UnaryOperator<T> = T -> T
		UnaryOperator<String> bienvenida = x -> "Hola " + x; // Devuelve un String concatenando "Hola" con el parámetro
		// Function recibe un String y devuelve un Integer
		// Function<T,U> = T -> U
		Function<String, Integer> longitud = s -> s.length(); // Devuelve la longitud del String
		// BinaryOperator recibe dos Integer y devuelve dos Integer
		// BinaryOperator<T> = (T,T) -> T
		BinaryOperator<Integer> suma = (x,y) -> x + y; // Devuelve la suma de los dos parámetros
		// Supplier no recibe nada y devuelve un double
		// Supplier<T> = () -> T
		Supplier<Double> temperatura = () -> {
			Random numAleatorio = new Random();
			return numAleatorio.nextDouble(15.0,30.0); // Devuelve un número aleatorio entre 15 y 30
		};
		// BiConsumer recibe un Array y un Random y no devuelve nada
		// BiConsumer<T,U> = (T,U) -> ()
		BiConsumer<Object[], Random> cantidad = (a,b) -> { 
			for(Object o : a) 
				System.out.println("Cantidad de " + o + ": " + b.nextInt(50)); // Itera sobre el array e imprime
		};
		
		// Se itera sobre el arreglo de nombres para poder aplicar el InaryOperator a cada elemento
		for(String n : nombres) {
			System.out.println(bienvenida.apply(n)); // Se usa el método aplly() para ejecutar el UnaryOperator
			System.out.println("Tu nombre tiene " + longitud.apply(n) + " letras"); // Se usa aplly() para Function
		}
		
		for(int i = 0; i < numeros.length -1; i++)
			System.out.println("La suma de " + numeros[i] 
								+ " y " + numeros[i+1] + " es: " + 
								suma.apply(numeros[i], numeros[i+1])); // Se usa aplly() para el BinaryOperator
		
		System.out.println("Temperatura actual: " + temperatura.get()); // Se usa get() para el Supplier
		
		
		cantidad.accept(productos, new Random()); // Se usa accept() para el BitConsumer
		
	}
}
