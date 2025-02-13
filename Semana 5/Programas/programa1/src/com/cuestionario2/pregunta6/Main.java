package com.cuestionario2.pregunta6;

class Counter {
	private int count = 0;
	
	// synchronized evita que dos hilos accedan al método al mismo tiempo
	public synchronized void increment() {
		count++; // Incrementa en uno la variable
	}
	
	public int getCount() {
		return count;
	}
}

// La clase de la que se crearan los hilos
class MyThread extends Thread {
	private Counter counter; // Se crea una variable de tipo Counter
	
	public MyThread(Counter counter) {
		this.counter = counter;
	}
	
	// El método que se ejecuta al iniciar el hilo
	public void run() {
		for (int i = 0; i < 1000; i++) {
			counter.increment(); // LLama al método increment de counter hasta que i = 1000
		}
	}
}

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		Counter counter = new Counter();
		
		// Se crean dos hilos
		// Ambos usan el mismo objeto counter
		Thread t1 = new MyThread(counter);
		Thread t2 = new MyThread(counter);
		
		// Se inician ambos hilos
		t1.start(); // incrementa count 1000 veces
		t2.start(); // incrementa count 1000 veces
		
		// Se usa join para decirle al hilo de main que espere hasta que finalicen
		t1.join();
		t2.join();
		
		// Al usar el mismo objeto, ambos hilos incrementaran la misma variable count
		System.out.println(counter.getCount()); // El resultado es 2000
		
	}
}
