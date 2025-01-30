package com.operaciones;

// Se implementa la interfaz Operaciones
public class Principal implements Operaciones {

	// Cuando se usan excepciones checked se debe definir al inicio del método con 
	// trows y dentro se arroja con throw new. Otra forma es con try-catch
	public int suma(int num1, int num2) throws NegativeNumberException { // Excepción checked
		if (num1 < 0) // Si el número es negativo arroja la excepción
			throw new NegativeNumberException("El primer número no puede ser negativo");
		return num1 + num2;
	}
	
	public int resta(int num1, int num2) throws NumeroMayorException { // Excepción checked
		if (num1 < num2) // Si el primer número es menor que el segundo, arroja la excepxión
			throw new NumeroMayorException("El sustraendo no debe de ser mayor que el minuendo");
		return num1 - num2;
	}
	
	public int multiplicacion(int num1, int num2) throws UnsupportedOperationException {
		if (num1 < 1 || num2 < 1) // Si cualquiera de los números es 0 o negativo arroja la excepción
			throw new UnsupportedOperationException();
		return num1 * num2;
	}
	
	// Al ser una excepción unchecked no es necesario indicarla con trows
	public int division(int num1, int num2) {
		if (num2 == 0)  // Si el segundo número es 0 arroja la excepción
			throw new ArithmeticException("No es posible dividir entre 0");
		return num1 / num2;
	}
	
	public static void main(String[] args) {
		
		// Se crea un objeto para poder ejecutar los métodos
		Operaciones op = new Principal();
		
		// Es necesario definir el try-catch para las excepciones checked
		// o usar trows al inicio del método. Para las excepciones unchecked no es
		// necesario usar try-catch pero es posible
		try {
			
			System.out.println("suma: " + op.suma(2, 3));
			System.out.println("resta: " + op.resta(5, 2));
			System.out.println("multiplicación: " + op.multiplicacion(7, 4));
			System.out.println("división: " + op.division(10, 0));
			
		} catch(ArithmeticException e) {
			System.out.println(e);
		} catch(UnsupportedOperationException e) {
			e.printStackTrace();
		} catch(NegativeNumberException e) {
			System.out.println(e);
		} catch(NumeroMayorException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
