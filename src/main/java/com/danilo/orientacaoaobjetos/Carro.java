package com.danilo.orientacaoaobjetos;

public abstract class Carro {
	
	/*
	 Modificadores de acesso
	 default => n�o uma palavra chave (palavra reservada). Acessivel pr�pria classe ou classe de um mesmo pacote
	 public => , todas as demais classes
	 private => Acess�vel pr�pria classe
	 protected => Acess�vel pr�pria classe, classe mesmo pacote, subclasses (extends)
	 */
	
	private String marca;
	private String modelo;
	private int velocidadeMaxima;
	private int taxaAceleracao;
	private double quilometrosPorLitro;
	
	public Carro() {
		System.out.println("Construindo Carro...");
	}
	
	public Carro(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(int velocidadeMaxima) throws NegocioException {
		if (velocidadeMaxima < 0) {
			throw new NegocioException("Valor � inv�lido!");
		} else {
			this.velocidadeMaxima = velocidadeMaxima;
		}
	}

	public int getTaxaAceleracao() {
		return taxaAceleracao;
	}

	public void setTaxaAceleracao(int taxaAceleracao) {
		this.taxaAceleracao = taxaAceleracao;
	}

	public double getQuilometrosPorLitro() {
		return quilometrosPorLitro;
	}

	public void setQuilometrosPorLitro(double quilometrosPorLitro) {
		this.quilometrosPorLitro = quilometrosPorLitro;
	}

	void acelerar() {
		System.out.println("Acelerando... VRUM");
	}
	
	void frear() {
		System.out.println("Freando...");
	}
	
	public abstract void piscarAlerta();
	
	double calcularTaxaAceleracao(double velocidadeFinal, double velocidadeInicial, double tempoInicial, double tempoFinal) {
		return (velocidadeFinal - velocidadeInicial) / (tempoFinal - tempoInicial) * 3.6;
	}
	
	public double calcularTaxaAceleracao(double velocidadeFinal, double tempoFinal) {
		return (velocidadeFinal - 0) / (tempoFinal - 0) * 3.6;
	}
	
}
