package com.danilo.orientacaoaobjetos.entidades;

import com.danilo.orientacaoaobjetos.Carro;

public class Tesla extends Carro {
	
	private boolean dirigirSozinho;

	public Tesla() {
		super();
	}
	
	@Override
	public double calcularTaxaAceleracao(double velocidadeFinal, double tempoFinal) {
		System.out.println("Tesla Sobrescrita");
		return velocidadeFinal * tempoFinal;
	}

	public Tesla(String marca, String modelo) {
		super(marca, modelo);
	}

	public boolean isDirigirSozinho() {
		return dirigirSozinho;
	}

	public void setDirigirSozinho(boolean dirigirSozinho) {
		this.dirigirSozinho = dirigirSozinho;
	}
	
	@Override
	public void piscarAlerta() {
		System.out.println("Tesla piscando alerta...");
	}
	
}
