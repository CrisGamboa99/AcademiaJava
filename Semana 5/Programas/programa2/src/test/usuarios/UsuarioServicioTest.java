package test.usuarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import usuarios.UsuarioDto;
import usuarios.UsuarioServicio;

class UsuarioServicioTest {

	private UsuarioServicio usuarioServicio;
	
	// @BeforeEach para ejecutar un método antes de que se ejecute el test
	@BeforeEach
	public void setUp() {
		usuarioServicio = new UsuarioServicio();
		usuarioServicio.crearUsuario(0L, "Cristian");
		usuarioServicio.crearUsuario(1L, "Usuario dos");
	}
	
	// @DisplayName permite dar un nombre al test
	@DisplayName("Dado un usuario que queremos crear, "
			+ "esperamos que cuando llamamos a 'crearUsuario' "
			+ "el usuario este creado")
	// @Test indica que es un test
	@Test
	public void test1() {
		UsuarioDto esperado = new UsuarioDto(1L, "Cristian");
		final UsuarioDto resultado = usuarioServicio.crearUsuario(1L, "Cristian");
		
		// El id de ambos objetos debe ser igual para pasar la prueba
		assertEquals(esperado.getId(), resultado.getId());
		
		// El nombre de ambos objetos debe ser igual para pasar la prueba
		assertEquals(esperado.getNombre(), resultado.getNombre(), 
				"Los nombres son diferentes"); // Se puede poner un mensaje en el caso de que la prueba falle
		
		// Ambos objetos deben ser iguales para pasar la prueba
		assertEquals(esperado, resultado); 
	}
	
	@DisplayName("Dado un usuario que queremos crear, "
			+ "esperamos que cuando llamamos a 'crearUsuario' "
			+ "el usuario no este creado")
	@Test
	public void test2() {
		UsuarioDto esperado = new UsuarioDto(1L, "Eduardo");
		final UsuarioDto resultado = usuarioServicio.crearUsuario(1L, "Cristian");
		assertEquals(esperado.getId(), resultado.getId()); // El id debe ser igual
		assertNotEquals(esperado.getNombre(), resultado.getNombre(), 
				"Los nombres no son diferentes"); // Los nombres deben ser diferentes
		assertNotEquals(esperado, resultado); // Los objetos no deben ser iguales
	}

	@DisplayName("Dado un usuario que queremos obtener, "
			+ "esperamos que cuando llamamos a 'obtenerUsuario' "
			+ "el usuario no este creado")
	@Test
	public void test3() {
		final UsuarioDto resultado = usuarioServicio.obtenerUsuario(3L);
		assertEquals(null, resultado); // Ambos valores deben ser null
	}
	
	@DisplayName("Dado un usuario que queremos obtener, "
			+ "esperamos que cuando llamamos a 'obtenerUsuario' "
			+ "el usuario este creado")
	@Test
	public void test4() {
		UsuarioDto esperado = new UsuarioDto(0L, "Cristian");
		final UsuarioDto resultado = usuarioServicio.obtenerUsuario(0L);
		assertEquals(esperado, resultado); // El usuario debe existir
	}
}
