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
		
		UnaryOperator<String> bienvenida = x -> "Hola " + x;
		Function<String, Integer> longitud = s -> s.length();
		BinaryOperator<Integer> suma = (x,y) -> x + y;
		Supplier<Double> temperatura = () -> {
			Random numAleatorio = new Random();
			return numAleatorio.nextDouble(15.0,30.0);
		};
		BiConsumer<Object[], Random> cantidad = (a,b) -> { 
			for(Object o : a) 
				System.out.println("Cantidad de " + o + ": " + b.nextInt(50));
		};
		
		for(String n : nombres) {
			System.out.println(bienvenida.apply(n));
			System.out.println("Tu nombre tiene " + longitud.apply(n) + " letras");
		}
		
		for(int i = 0; i < numeros.length -1; i++)
			System.out.println("La suma de " + numeros[i] 
								+ " y " + numeros[i+1] + " es: " + 
								suma.apply(numeros[i], numeros[i+1]));
		
		System.out.println("Temperatura actual: " + temperatura.get());
		
		
		cantidad.accept(productos, new Random());
		
	}
}
