package com.cuestionario2.pregunta2;

// Se crea una clase que hereda de Thread, para poder definir un hilo
class MyThread extends Thread {
	
	// Se sobrescribe el metodo run() de Threads
	public void run() {
		System.out.println("Thread is running");
	}
}

public class Main {
	
	public static void main(String[] args) {
		// Se crean dos hilos de la clase MyThread
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		// Se inician los hilos con start()
		t1.start(); // Thread is running
		t2.start(); // Thread is running
		// Se imprimen ambos mensajes sin un orden definido
	}
}
