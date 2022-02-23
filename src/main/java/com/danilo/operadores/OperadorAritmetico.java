package com.danilo.operadores;

public class OperadorAritmetico {
	
	public static void main(String[] args) {
		
		// soma
		int soma = 10 + 20;
		
		// subtracao
		int subtracao = 20 - 10;
		 
		// multiplicacao
		int multiplicacao = 20 * 10;
		
		// divis�o 
		int divisao = 20 / 10;
		
		// modular 
		int modulo = 20 % 10;
		
		// operador unario
		int unario = 10;
		//unario++; //postfix
		//++unario; //prefix
		
		System.out.println(unario++ == 11);
		
		// -
		System.out.println(-unario);

		System.out.println(soma);
		System.out.println(subtracao);
		System.out.println(multiplicacao);
		System.out.println(divisao);
		System.out.println(modulo);
	}
}
