package com.autenticacion;

public class TokenService implements AutenticacionService {

	// El array contiene los datos válidos para ingresar
	String[] usuarioValido = {"Cristian","TOKEN123"};
	
	// Ya que implementa la interfaz, debe sobrescribir el método
	@Override
	public void autenticar(String usuario, String credenciales) {
		// Se usa un if para verificar que los datos sean correctos
		if (usuarioValido[0].equals(usuario) 
				&& usuarioValido[1].equals(credenciales))
			System.out.println("Bienvenido " + usuario 
					+ ". Autenticación por Token correcta");
		else
			System.out.println("Credenciales incorrectas");
	}

}
