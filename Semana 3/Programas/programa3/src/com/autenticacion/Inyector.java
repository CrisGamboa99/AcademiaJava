package com.autenticacion;

public class Inyector {

	public static UsuarioService getUsuarioService() {
		
		// Se crean objetos para hacer la inyección
		AutenticacionService passAutenticacion = new PasswordService();
		AutenticacionService tokenAutenticacion = new TokenService();
		
		// Se inyecta uno de los objetos a un nuevo objeto de tipo UsuarioService
		return new UsuarioService(passAutenticacion);
	}
}
