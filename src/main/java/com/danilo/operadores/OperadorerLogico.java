package com.danilo.operadores;

public class OperadorerLogico {
	public static void main(String[] args) {
		
		/* 
		 AND
		 V and V => V
		 V and F => F 
		 F and V => F
		 F and F => F
		 
		 OR
		 V or V => V
		 V or F => V
		 F or V => V
		 F or F => F
		 
		 XOR
		 V xor V => F
		 V xor F => V
		 F xor V => V
		 F xor F => F
		 
		 NEGACAO
		 !V => F
		 !F => V
		 */
		
		// &&
		System.out.println(true && true);
		
		// ||
		System.out.println(false || true);
		
		// !=
		System.out.println(true != false);
		
		// !
		System.out.println(!false);
		
	}
}
