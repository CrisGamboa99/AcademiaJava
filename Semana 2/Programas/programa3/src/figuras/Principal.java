package figuras;

public class Principal {

	public static void main(String[] args) {
		
		// Se crea una variable de referencia de tipo Figura que apunta 
		// a un objeto del tipo de la clase que hereda a Figura
		Figura cuadrado = new Cuadrado(6); // El 6 es equivalente al lado del cuadrado
		
		Figura triangulo = new Triangulo(6,8,9); // Los numeros son los valores de los lados de un triangulo
		
		Figura circulo = new Circulo(9); // El numero corresponde al radio
		
		// Se llama a los metodos del cuadrado y se imprime el resultado
		System.out.println("-----Cuadrado-----");
		System.out.println("Area: " + cuadrado.area());
		System.out.println("Perimetro: " + cuadrado.perimetro());
		
		// Se llama a los metodos del triangulo y se imprime el resultado
		System.out.println("-----Triangulo-----");
		System.out.println("Area: " + triangulo.area());
		System.out.println("Perimetro: " + triangulo.perimetro());
		
		// Se llama a los metodos del circulo y se imprime el resultado
		System.out.println("-----Circulo-----");
		System.out.println("Area: " + circulo.area());
		System.out.println("Perimetro: " + circulo.perimetro());
	}

}
