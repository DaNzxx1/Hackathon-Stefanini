package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.repositories.UsuarioRepository;

@Stateless
public class UsuarioService {
    
    @Inject
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioEntity> list = usuarioRepository.listarUsuarios();
        return list.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
    
    public UsuarioDTO pegarUsuarioPorId(Long idUsuario) {
        return new UsuarioDTO(usuarioRepository.pegarUsuarioPorId(idUsuario));
    }
    
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        return new UsuarioDTO(usuarioRepository.criarUsuario(usuarioDTO));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        return new UsuarioDTO(usuarioRepository.atualizarUsuario(usuarioDTO));
    }

    public UsuarioDTO deletarUsuario(UsuarioDTO UsuarioDTO) {
        return new UsuarioDTO(usuarioRepository.deletarUsuario(UsuarioDTO));
    }

}
