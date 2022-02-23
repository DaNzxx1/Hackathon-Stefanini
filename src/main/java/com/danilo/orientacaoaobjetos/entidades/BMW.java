package com.danilo.orientacaoaobjetos.entidades;

import com.danilo.orientacaoaobjetos.Carro;
import com.danilo.orientacaoaobjetos.Conversivel;
import com.danilo.orientacaoaobjetos.Utilitario;

public class BMW extends Carro implements Conversivel, Utilitario {
	
	public BMW() {
		super();
	}
		
	@Override
	public double calcularTaxaAceleracao(double velocidadeFinal, double tempoFinal) {
		System.out.println("BMW Sobrescrita");
		return velocidadeFinal / tempoFinal;
	}
	
	@Override
	public void piscarAlerta() {
		System.out.println("BMW piscando alerta...");
	}

	@Override
	public void acionarTurbo() {
		System.out.println("VRUUUUUUUUUUUUUM");
	}

	@Override
	public void abrirCapo() {
		System.out.println("Doguinhoo");
	}

	@Override
	public void passear() {
		// TODO Auto-generated method stub
		
	}
		
}
