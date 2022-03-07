package com.stefanini.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.stefanini.dto.UsuarioDTO;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O campo Nome não pode ser vazio!")
    @Column(nullable = false, length = 50)
    private String nome;
    
    @NotEmpty(message = "O campo Login não pode ser vazio!")
    @Size(min = 5, max = 20)
    @Column(nullable = false, unique = true,  length = 20)
    private String login;

    @Size(min = 10)
    @NotEmpty(message = "O campo Email não pode ser vazio!")
    @Email
    @Column(nullable = false)
    private String email;

    @NotEmpty(message = "O campo Senha não pode ser vazio!")
    @Column(nullable = false)
    private String senha;

    @Column(name = "data_nascimento", nullable = true)
    private LocalDate dataNascimento;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = true)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", nullable = true)
    private LocalDateTime dataAtualizacao;

    public UsuarioEntity() { }

    public UsuarioEntity(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.getId();
        this.nome = usuarioDTO.getNome();
        this.login = usuarioDTO.getLogin();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.dataNascimento = usuarioDTO.getDataNascimento();
        this.dataCriacao = usuarioDTO.getDataCriacao();
        this.dataAtualizacao = usuarioDTO.getDataAtualizacao();
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
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
