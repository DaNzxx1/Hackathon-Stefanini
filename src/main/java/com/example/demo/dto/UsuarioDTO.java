package com.example.demo.dto;

import javax.validation.constraints.NotNull;

import com.example.demo.entities.ProdutoEntity;
import com.example.demo.entities.UsuarioEntity;

public class UsuarioDTO {
    
    private Long id;

    @NotNull(message = "Informe o Nome!")
    private String nome;

    @NotNull(message = "Informe o Email!")
    private String email;

    @NotNull(message = "Informe a Senha!")
    private String senha;

    @NotNull(message = "Informe o Produto!")
    private ProdutoEntity produto;

    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
        this.email = usuarioEntity.getEmail();
        this.senha = usuarioEntity.getSenha();
        this.produto = usuarioEntity.getProduto();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

}
