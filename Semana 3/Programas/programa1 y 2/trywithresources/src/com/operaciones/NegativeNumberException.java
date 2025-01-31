package com.operaciones;

// Hereda de la clase Exception para poder ser usada como excepción
public class NegativeNumberException extends Exception {
	
	// Se define el constructor de la clase y se le pasa un String a la clase padre
	NegativeNumberException(String e){
		super(e);
	}
}
