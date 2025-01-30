package com.autenticacion;

public class UsuarioService {

	// Se tiene una variable de referencia final del tipo de la interfaz
	private final AutenticacionService autenticacionService;
	
	// Se hace la inyección por constructor
	public UsuarioService(AutenticacionService autenticacionService) {
		this.autenticacionService = autenticacionService;
	}
	
	// El método proporciona los datos y los pasa al método de las clases que implementan
	// la interfaz
	public void ingresar(String usuario, String credenciales) {
		autenticacionService.autenticar(usuario, credenciales);
	}
}
