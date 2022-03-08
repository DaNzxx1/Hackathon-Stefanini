package com.stefanini.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.entities.UsuarioEntity;


public class UsuarioDTO {

    private Long id;
    
    @Size(max = 50)
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String nome;

    @Size(min = 4, max = 20)
    @NotEmpty(message = "Login não pode ser vazio!")
    private String login;
    
    @Size(min = 10)
    @Email
    @NotEmpty(message = "Email não pode ser vazio!")
    private String email;

    @Size(min = 4, max = 10)
    @NotEmpty(message = "Senha não pode ser vazio!")
    private String senha;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriacao;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
