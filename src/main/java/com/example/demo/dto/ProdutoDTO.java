package com.example.demo.DTO;

import javax.validation.constraints.*;

import com.example.demo.entities.ProdutoEntity;

public class ProdutoDTO {
    
    private Long id;

    @NotNull(message = "Informe o Nome!")
    private String nome;

    @NotNull(message = "Informe o Valor!")
    private double valor;

    public ProdutoDTO() {}

    public ProdutoDTO(ProdutoEntity produtoEntity) {
        this.id = produtoEntity.getId();
        this.nome = produtoEntity.getNome();
        this.valor = produtoEntity.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
