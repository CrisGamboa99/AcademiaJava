package com.operaciones;

public class Principal implements Operaciones {

	public int suma(int num1, int num2) throws NegativeNumberException {
		if (num1 < 0)
			throw new NegativeNumberException("El primer número no puede ser negativo");
		return num1 + num2;
	}
	
	public int resta(int num1, int num2) throws NumeroMayorException {
		if (num1 < num2)
			throw new NumeroMayorException("El sustraendo no debe de ser mayor que el minuendo");
		return num1 - num2;
	}
	
	public int multiplicacion(int num1, int num2) throws UnsupportedOperationException {
		if (num1 < 1 || num2 < 1)
			throw new UnsupportedOperationException();
		return num1 * num2;
	}
	
	public int division(int num1, int num2) {
		if (num2 == 0) 
			throw new ArithmeticException("No es posible dividir entre 0");
		return num1 / num2;
	}
	
	public static void main(String[] args) {
		
		Operaciones op = new Principal();
		
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
