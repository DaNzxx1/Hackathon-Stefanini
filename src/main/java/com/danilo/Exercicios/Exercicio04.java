package com.danilo.Exercicios;

import java.util.Scanner;

public class Exercicio04 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma palavra ou frase: (Digite 1 para sair)");
		String palavra = sc.nextLine();
		String palindromo = "";
		
		for (int i = palavra.length() -1; i >= 0; i--) {
			palindromo += palavra.charAt(i);
		}
		
		if (palindromo.equals(palavra)) {
			System.out.println(palindromo +" é um palindromo!");
			
		} else {
			System.out.println(palindromo +" Não e um palindromo!");
		}
		
		sc.close();
	}
	
}
