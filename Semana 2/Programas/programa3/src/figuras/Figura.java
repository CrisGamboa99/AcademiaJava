package figuras;

public abstract class Figura {
	
	int x;
	int y;
	int z;
	
	// Se hace overloading de constructores 
	// para tomar los atributos necesarios dependiendo de la figura
	public Figura(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Figura(int x) {
		this.x = x;
	}
	
	//Metodos abstractos que todas las clases deben implementar
	abstract double area();
	
	abstract double perimetro();
}
