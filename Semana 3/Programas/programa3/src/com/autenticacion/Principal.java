package com.autenticacion;

public class Principal {

	public static void main(String[] args) {
		
		UsuarioService usuario = Inyector.getUsuarioService();
		
		usuario.ingresar("Eduardo", "Pa$$w0rd123");
	}
}
