package figuras;

public class Circulo extends Figura {

	// El constructor toma solo una variable 
	// Solo se toma el valor del radio
	public Circulo(int x) {
		super(x);
	}

	// Se hace Override de los metodos abstractos de la clase Figura
	@Override
	double area() {
		return Math.PI*Math.pow(x, 2); // El area es igual al radio al cuadrado multiplicado por π
	}
	
	@Override
	double perimetro() {
		return Math.PI*2*x; // El perimetro es igual a π multiplicado por el diametro (2 veces el radio)
	}

}
