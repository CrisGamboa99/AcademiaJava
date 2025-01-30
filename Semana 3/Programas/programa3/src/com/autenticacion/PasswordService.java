package com.autenticacion;

public class PasswordService implements AutenticacionService {

	String[] usuarioValido = {"Eduardo","Pa$$w0rd123"};
	
	@Override
	public void autenticar(String usuario, String credenciales) {
			if (usuarioValido[0].equals(usuario) 
					&& usuarioValido[1].equals(credenciales))
				System.out.println("Bienvenido " + usuario 
						+ ". Autenticación por contraseña correcta");
			else
				System.out.println("Credenciales incorrectas");
	}

}
