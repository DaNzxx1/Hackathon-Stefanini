package com.danilo.brakcontinue;

public class BreakContinue {
	public static void main(String[] args) {
		
		String[] carros = new String[] {"I320", "C180", "M3", "AMG", "Tesla Model S"};
		
		for (int i = 0; i < carros.length; i++) {
			if (carros[i] == "I320") {
				System.out.println(carros[i]);
				//break;
				continue;
			}
			
			System.out.println("Quero esse carro!");
			System.out.println(carros[i]);
		}
		
	}
}
