package figuras;

public class Triangulo extends Figura {

	// Se usa un constructor que toma 3 variables
	// Se toman los valores de los tres lados del triangulo
	public Triangulo(int x, int y, int z) {
		super(x, y, z);
	}

	// Se hace Override de los metodos abstractos de la clase Figura
	@Override
	double area() {
		return (x*y)/2; // El area se obtiene al multiplicar la base por la altura y el resultado dividirlo por 2
	}
	
	@Override
	double perimetro() {
		return x+y+z; // El perimetro es la suma de todos los lados
	}
}
