package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.repositories.UsuarioRepository;

@Stateless
public class UsuarioService {
    
    @EJB
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
        return usuarioRepository.atualizarUsuario(usuarioDTO);
    }

    public void deletarUsuario(Long idUsuario) {
        usuarioRepository.deletarUsuario(idUsuario);
    }

}
