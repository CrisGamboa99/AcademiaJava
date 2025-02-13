package programa3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Activar la extensión de Mockito
@ExtendWith(MockitoExtension.class)
class CalculadoraTest {

	// Inyectara las dependencias o las clases marcadas como @Mock
	@InjectMocks
	Calculadora calculadora = new Calculadora();
	
	// Anotación para decir que CalculadoraOracleCloud sea gestionado por Mockito
	// Se genera una instancia como Mock
	@Mock CalculadoraOracleCloud calculadoraOracleCloud;
	
	// Para cuando es posible inyectar dependencias (por constructor)
//	@BeforeEach
//	public void init() {
//		calculadora = new Calculadora(calculadoraOracleCloud);
//	}
	
	@Test
	public void probarSumaEnLaNube() {
		when(calculadoraOracleCloud.sumarEnOracleCloud(5.0,20.0)).thenReturn(25.0);
		// lenient() indica que se puede o no ejecutar
		lenient().when(calculadoraOracleCloud.sumarEnOracleCloud(5.0,5.0)).thenReturn(10.0);
		
		assertEquals(25.0, calculadora.sumarEnLaNube(5.0, 20.0));
	}

}
