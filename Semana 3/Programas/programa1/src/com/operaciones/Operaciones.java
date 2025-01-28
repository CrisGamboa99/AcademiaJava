package com.operaciones;

public interface Operaciones {

	int suma(int num1, int num2) throws Exception;
	
	int resta(int num1, int num2) throws NumeroMayorException;
	
	int division(int num1, int num2);
	
	int multiplicacion(int num1, int num2);
}
