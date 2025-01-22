package programa1;

import java.util.ArrayList;

class Biblioteca {
	private String cancion;
	private String artista;
	
	public Biblioteca(String cancion, String artista) {
		this.cancion = cancion;
		this.artista = artista;
	}
	
	public String getCancion() {
		return cancion;
	}

	public String getArtista() {
		return artista;
	}
}

public class Canciones {

	static void buscarCancion(String titulo, 
			ArrayList<Biblioteca> canciones) {
		int i = 1;
		for (Biblioteca c : canciones) {
			if (c.getCancion().equals(titulo)) {
				System.out.println("Canción #" + i 
						+ ": " + c.getCancion());
			}
			i++;
		}
	}
	
	static void buscarArtista(String artista, 
			ArrayList<Biblioteca> canciones) {
		System.out.println("Canciones de " + artista + ":");
		for (Biblioteca c : canciones) {
			if (c.getArtista().equals(artista)) {
				System.out.println(c.getCancion());
			}
		}
	}
	
	static void mostrarCanciones(ArrayList<Biblioteca> canciones) {
		for (int i = 0; i < canciones.size(); i++) {
			int num = 1 + i;
			System.out.println("#" + num + ": " 
					+ canciones.get(i).getCancion() + " - "
					+ canciones.get(i).getArtista());
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Biblioteca> canciones = new ArrayList<>();
		canciones.add(new Biblioteca("Echoes","Pink Floyd"));
		canciones.add(new Biblioteca("Tron","Foals"));
		canciones.add(new Biblioteca("Under The Pressure","The War On Drugs"));
		canciones.add(new Biblioteca("Time","Pink Floyd"));
		canciones.add(new Biblioteca("On The Luna","Foals"));
		
		String titulo = "Tron";
		String artista = "Foals";
	
		buscarCancion(titulo, canciones);
		
		System.out.println("----------");
		
		mostrarCanciones(canciones);
		
		System.out.println("----------");
		
		buscarArtista(artista, canciones);
	}
}
