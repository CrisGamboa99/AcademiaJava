package com.operaciones;

// Se implementa la interfaz AutoCloseable para el tryWithResources
public class Principal implements Operaciones,AutoCloseable {

	// Se sobrescribe el método close de la interfaz AutoCloseable
	@Override
	public void close() throws Exception {
		System.out.println("Fin de programa");
	}
	
	public int suma(int num1, int num2) throws NegativeNumberException { 
		if (num1 < 0) // Si el número es negativo arroja la excepción
			throw new NegativeNumberException("El primer número no puede ser negativo");
		return num1 + num2;
	}
	
	public int resta(int num1, int num2) throws NumeroMayorException { 
		if (num1 < num2) // Si el primer número es menor que el segundo, arroja la excepxión
			throw new NumeroMayorException("El sustraendo no debe de ser mayor que el minuendo");
		return num1 - num2;
	}
	
	public int multiplicacion(int num1, int num2) throws UnsupportedOperationException {
		if (num1 < 1 || num2 < 1) // Si cualquiera de los números es 0 o negativo arroja la excepción
			throw new UnsupportedOperationException();
		return num1 * num2;
	}
	
	public int division(int num1, int num2) {
		if (num2 == 0)  // Si el segundo número es 0 arroja la excepción
			throw new ArithmeticException("No es posible dividir entre 0");
		return num1 / num2;
	}
	
	public static void main(String[] args) {
		
		// Se crea el objeto dentro de paréntesis en el try
		try (Principal op = new Principal()) {
			
			System.out.println("suma: " + op.suma(2, 3));
			System.out.println("resta: " + op.resta(5, 2));
			System.out.println("multiplicación: " + op.multiplicacion(7, 4));
			System.out.println("división: " + op.division(10, 1));
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
