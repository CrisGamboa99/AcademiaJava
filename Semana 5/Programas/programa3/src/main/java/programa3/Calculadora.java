package programa3;

public class Calculadora {

	private CalculadoraOracleCloud calculadoraOracleCloud;
	
	// Inyección por constructor
//	public Calculadora(CalculadoraOracleCloud calculadoraOracleCloud) {
//		this.calculadoraOracleCloud = calculadoraOracleCloud;
//	}
	
	public double sumarEnLaNube(double a, double b) {
		// Dependencia
		return calculadoraOracleCloud.sumarEnOracleCloud(a,b);
	}
}
