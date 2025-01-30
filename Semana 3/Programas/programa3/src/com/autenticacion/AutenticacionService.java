package com.autenticacion;

public interface AutenticacionService {

	// Se indica un método que deberán sobrescribir las clases que implementen la interfaz
	void autenticar(String usuario, String credenciales);
}
