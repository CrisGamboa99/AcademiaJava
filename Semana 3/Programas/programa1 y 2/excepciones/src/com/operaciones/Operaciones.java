package com.operaciones;

public interface Operaciones {

	// Las clases que implementan la interfaz deben definir 
	//un método suma con una excepción checked o ninguna excepción
	int suma(int num1, int num2) throws Exception; // Excepción checked
	
	// Se debe definir un método resta con una excepción checked (NumeroMayorException)
	int resta(int num1, int num2) throws NumeroMayorException; // Excepción checked
	
	// Para una excepción unchecked no es necesario definirla en el método (con trows)
	// Pero es posible
	int division(int num1, int num2) throws ArithmeticException; // Excepción unchecked
	
	int multiplicacion(int num1, int num2);
}
