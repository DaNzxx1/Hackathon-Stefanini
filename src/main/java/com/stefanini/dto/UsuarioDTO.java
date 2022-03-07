package com.stefanini.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.stefanini.entities.UsuarioEntity;


public class UsuarioDTO {

    private Long id;
    
    private String nome;

    private String email;

    private String login;

    private String senha;

    private LocalDate dataNascimento;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    public UsuarioDTO() { }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
        this.login = usuarioEntity.getLogin();
        this.email = usuarioEntity.getEmail();
        this.senha = usuarioEntity.getSenha();
        this.dataNascimento = usuarioEntity.getDataNascimento();
        this.dataCriacao = usuarioEntity.getDataCriacao();
        this.dataAtualizacao = usuarioEntity.getDataAtualizacao();
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    

}
