package com.stefanini.services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioService {
    
    @Inject
    UsuarioRepository usuarioRepository;

    //CRUD
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    public UsuarioDTO BuscarUsuarioPorId(Long idUsuario) {
        return usuarioRepository.BuscarUsuarioPorId(idUsuario);
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        if (Objects.nonNull(usuarioDTO.getId())) {
            throw new RuntimeException("Ao cadastrar não mande ID");
        }
        
        String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
        usuarioDTO.setSenha(senha);
        return usuarioRepository.salvarUsuario(usuarioDTO);

    }

    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO) {
        if (!Objects.nonNull(usuarioDTO.getId())) {
            throw new RuntimeException("Ao alterar mande um ID");
        }

        if (!usuarioDTO.getSenha().isEmpty()) {
            //Criptografando a senha caso ela seja nova
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);
        }

        return usuarioRepository.alterarUsuario(usuarioDTO);
    }

    public void excluirUsuario(Long idUsuario) {
        usuarioRepository.excluirUsuario(idUsuario);
    }

    //Outras funções
    public List<UsuarioDTO> aniversariantesDoMes() {
        return usuarioRepository.aniversariantesDoMes();
    }

    public List<String> provedores() {
        List<String> listaProvedores = new ArrayList<>();
        for(UsuarioDTO usuario : usuarioRepository.listarUsuarios()) {
            String provedor = usuario.getEmail().substring(usuario.getEmail().indexOf("@"));
            listaProvedores.add(provedor);
        }

        return listaProvedores;
    }

    public List<UsuarioDTO> listarIniciais(String inicial) {
        return usuarioRepository.listarIniciais(inicial);
    }

}
