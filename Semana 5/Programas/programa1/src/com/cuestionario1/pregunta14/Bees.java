package com.cuestionario1.pregunta14;

public class Bees {
	
	synchronized public static void main(String[] args) {
		try {
			new Bees().go();
		} catch (Exception e) {
			System.out.println("thrown to main");
		}
	}

	synchronized void go() throws InterruptedException {
		Thread t1 = new Thread();
		t1.start();
		System.out.println("1 ");
		t1.wait(5000);
		System.out.println("2 ");
	}
}
