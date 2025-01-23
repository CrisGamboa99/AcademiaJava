package figuras;

public class Cuadrado extends Figura {

	// El constructor toma solo una variable 
	// ya que todos los lados de un cuadrado son iguales
	public Cuadrado(int x) {
		super(x);
	}

	// Override de los métodos abstractos de la clase Figura
	// Define como se calcula el area de un cuadrado y devuelve el resultado
	@Override
	double area() {
		return Math.pow(x,2); //Se multiplica el lado por si mismo
	}
	
	// Define como se calcula el perimetro de un cuadrado y devuelve el resultado
	@Override
	double perimetro() {
		return 4*x; // El resultado de la suma de los 4 lados o multiplicar el lado por 4
	}
}
