package com.stefanini.dto;

import javax.validation.constraints.*;

public class LoginDTO {
    
    @Size(min = 5, max = 20, message = "Tamanho do Login deve ser entre 5 e 20")
    @NotEmpty(message = "Login não pode ser vazio!")
    private String login;
    
    @Size(min = 4, max = 10, message = "Tamanho da Senha deve ser entre 4 e 10")
    @NotEmpty(message = "Senha não pode ser vazio!")
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
