package com.danilo.estruturacontrole;

public class IfElse {
	public static void main(String[] args) {
		
		int idade = 17;
		
		if (idade >= 18) {
			System.out.println("Maior de Idade!");
			
		}
		
		if (idade >= 18) {
			System.out.println("Maior de Idade!");
			
		} else {
			System.out.println("Menor de Idade!");
		}
		
		if (idade >= 100) {
			System.out.println("Virou uma mumia!");
			
		} else if (idade >= 18) {
			System.out.println("Maior de Idade!");
		
		} else {
			System.out.println("Menor de Idade!");
		}
		
		if (idade >= 18)  
			System.out.println("Maior de Idade!");
		
		System.out.println("Sua Idade: "+ idade);
		
	}
}
