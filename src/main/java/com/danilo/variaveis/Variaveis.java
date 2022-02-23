package com.danilo.variaveis;


public class Variaveis {
	
	public static void main(String[] args) {
		
		byte numByte = 123; //-128 a 127 (8 bits)
		short numShort = 12321; // -32768 a 32767 (16 bits)
		int numInt = 2147483647; // -2.147.483.648 a 2.147.483.647 (32 bits)
		long numLong = 2147483647; // -9.223.372.036.854.770.00 a 9.223.372.036.854.770.000 (64 bits)
		
		float numFloat = 10.000f; // -1,4024E-37 a 3.40282347E+38 (32 bits)
		double numDouble = 1000000000000000.000; // -4,94E-307 a 1.79769313486231570E+308 (64 bits)
		
		char varChar = 'F'; //0 a 65535 (16 bits)
		boolean varBoolean = true; //true ou false (1 bits)
		
		String text = "Hello IDE!";
		Integer numeroConta = 4000;
		Long numeroLongo = 1213123L;
		
		// Ele deve come�ar com uma letra min�scula. Exemplo: nome
		// N�o deve come�ar com caracteres especiais como & (e comercial), $ (d�lar), _ (sublinhado). Exemplo: _nome
		// Se o nome for composto por mais de uma palavra, inicie-se a primeira palavra com a letra min�scula seguido po ruma letra mai�scula. -
		// -Exemplo: nomeCompleto
		
		String nome = "Danilo";

		System.out.println(numByte);
		System.out.println(numShort);
		System.out.println(numInt);
		System.out.println(numLong);
		System.out.println(numFloat);
		System.out.println(numDouble);
		System.out.println(varChar);
		System.out.println(varBoolean);
		System.out.println(text);
		System.out.println(numeroConta);
		System.out.println(numeroLongo);
		System.out.println(nome);
		
	}
}
