package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.example.demo.dto.ProdutoDTO;

@Entity
@Table(name = "produto")
public class ProdutoEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double valor;

    public ProdutoEntity() {}

    public ProdutoEntity(ProdutoDTO produtoDTO) {
        this.id = produtoDTO.getId();
        this.nome = produtoDTO.getNome();
        this.valor = produtoDTO.getValor();
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
