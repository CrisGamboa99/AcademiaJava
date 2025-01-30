package com.hashset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		
		// Se crean algunos objetos, algunos con valores duplicados
		Canciones cancion1 = new Canciones("Time","Pink Floyd",1973);
		Canciones cancion2 = new Canciones("Under The Pressure","The War On Drugs",2014);
		Canciones cancion3 = new Canciones("The Cedar Room","Doves",2000);
		Canciones cancion4 = new Canciones("Quadrophenia","The Who",1973);
		Canciones cancion5 = new Canciones("Under The Pressure","The War On Drugs",2014);
		Canciones cancion6 = new Canciones("The Cedar Room","Doves",2000);
		Canciones cancion7 = new Canciones("Quadrophenia","The Who",1973);
		
		// Se crea una lista con los objetos creados
		List<Canciones> listaCanciones = List.of(cancion1,cancion2,
				cancion3,cancion4,cancion5,cancion6,cancion7);
		
		// Se asigna la lista a un hashSet
		Set<Canciones> canciones = new HashSet<>(listaCanciones);
		
		// Se itera el hashSet para mostrar sus valores
		// Ya que se implementaron el hashCode y el equals los objetos con valores 
		// repetidos se eliminaran
		for (Canciones c : canciones) {
			System.out.println(c);
		}
	}

}
