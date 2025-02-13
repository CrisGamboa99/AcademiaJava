package com.cuestionario2.pregunta9;

class SharedResource {
	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public synchronized void decrement() {
		count--;
	}
	
	public int getCount() {
		return count;
	}
}

// La clase para incrementar la variable count
class IncrementThread extends Thread {
	private SharedResource resource;
	
	public IncrementThread(SharedResource resource) {
		this.resource = resource;
	}
	
	// El método que se ejecuta al iniciar el hilo
	public void run() {
		for (int i = 0; i < 1000; i++) {
			resource.increment(); // Se ejecuta 1000 veces el método
		}
	}
}

//La clase para decrementar la variable count
class DecrementThread extends Thread {
	private SharedResource resource;
	
	public DecrementThread(SharedResource resource) {
		this.resource = resource;
	}
	
	// El método que se ejecuta al iniciar el hilo
	public void run() {
		for (int i = 0; i < 1000; i++) {
			resource.decrement(); // Se ejecuta 1000 veces el método
		}
	}
}

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		SharedResource resource = new SharedResource();
		
		// Se crean dos hilos que usan el mismo objeto
		Thread t1 = new IncrementThread(resource); // Objeto de la clase IncrementThread
		Thread t2 = new DecrementThread(resource); // Objeto de la clase DecrementThread
		
		// Se inician los hilos
		t1.start(); // incrementa count 1000 veces
		t2.start(); // decrementa count 1000 veces
		
		// Se usa join para decirle al hilo de main que espere hasta que finalicen
		t1.join();
		t2.join();
		
		System.out.println(resource.getCount()); // Se imprime el número 0
	
	}
}
