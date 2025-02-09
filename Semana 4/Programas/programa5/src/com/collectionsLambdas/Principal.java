package com.collectionsLambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {

	public static void main(String[] args) {
		
		List<String> peliculas = new ArrayList<>();
		peliculas.add("Star Wars");
		peliculas.add("Spider-Man");
		peliculas.add("Batman");
		peliculas.add("Kill Bill");
		peliculas.add("1917");
		
		Map<Integer, String> cliente = new HashMap<>();
		cliente.put(1,"Cristian");
		cliente.put(5,"Eduardo");
		cliente.put(7,"Daniel");
		cliente.put(12,"Pedro");
		
		System.out.println("-----Método forEach()");
		// El método forEach() toma un Consumer (el consumer no devuelve nada)
		// En este caso el consumer es de Strings
		peliculas.forEach(x -> System.out.println(x)); // Se recibe un String y se imprime
		
		System.out.println("-----Método forEach() en HashMap");
		// El método forEach() en un HashMap toma un BiConsumer (el BiConsumer no devuelve nada)
		// En este caso el BiConsumer es de Integers y Strings
		cliente.forEach((x,y) -> System.out.println("Cliente: " + x + ": " + y)); // Se recibe un Integer y un String y se imprime
		
		System.out.println("-----Método removeIf()");
		// removeIf() recibe un Predicate, que en este caso recibe un String
		peliculas.removeIf(z -> z.length() > 8); // El Predicate devuelve el elemento si su longitud es mayor a 8 y lo remueve
		peliculas.forEach(x -> System.out.println(x));
		
		System.out.println("-----Método computeIfAbsent()");
		int n = 2;
		// Es para un Map. Recibe un Function()
		cliente.computeIfAbsent(n,x -> "Roberto"); // Si el key no existe en el HashMap lo agrega
		cliente.forEach((x,y) -> System.out.println("Cliente: " + x + ": " + y));
		
		System.out.println("-----Método computeIfPresent()");
		// Es similar a un computeIfAbsent() pero usa un BiFunction
		cliente.computeIfPresent(n,(x,y) -> "Martin"); // Si el key existe en el HashMap modifica su valor
		cliente.forEach((x,y) -> System.out.println("Cliente: " + x + ": " + y));
	}

}
