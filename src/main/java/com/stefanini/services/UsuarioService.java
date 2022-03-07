package com.stefanini.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
        List<UsuarioDTO> listNull = null;
        List<UsuarioDTO> listaUsuarios = usuarioRepository.listarUsuarios();
        if (listaUsuarios.isEmpty()) {
            return listNull;
        }
        return listaUsuarios;
    }

    public UsuarioDTO BuscarUsuarioPorId(Long idUsuario) {
        return usuarioRepository.BuscarUsuarioPorId(idUsuario);
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioNull = null;
        
        if (usuarioDTO.getSenha().length() >= 4 && usuarioDTO.getSenha().length() <= 10) {
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);
            return usuarioRepository.salvarUsuario(usuarioDTO);

        } else {
            return usuarioNull;
        }

    }

    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioRepository.BuscarUsuarioPorId(usuarioDTO.getId());
        usuarioDTO.setDataCriacao(usuario.getDataCriacao());

        if (usuarioDTO.getSenha().isEmpty()) {
            usuarioDTO.setSenha(usuario.getSenha());

            return usuarioRepository.alterarUsuario(usuarioDTO);

        } else {
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);

            return usuarioRepository.alterarUsuario(usuarioDTO);
        }

    }

    public String excluirUsuario(Long idUsuario) {
        return usuarioRepository.excluirUsuario(idUsuario);
    }

    //Outras funções
    public List<UsuarioDTO> mesAniversario() {
        List<UsuarioDTO> listarUsuarios = new ArrayList<>();
        for (UsuarioDTO usuarioDTO : usuarioRepository.listarUsuarios()) {
            LocalDate usuarioMonth = usuarioDTO.getDataNascimento();
            if (usuarioMonth.getMonth() == LocalDate.now().getMonth()) {
                listarUsuarios.add(usuarioDTO);
            }
        }
        return listarUsuarios;
    }

    public List<String> provedores() {
        List<String> listaProvedores = new ArrayList<>();
        for(UsuarioDTO usuario : usuarioRepository.listarUsuarios()) {
            String provedor = usuario.getEmail().substring(usuario.getEmail().indexOf("@"));
            listaProvedores.add(provedor);
        }

        return listaProvedores;
    }

    public List<String> listarIniciais(String inicial) {
        List<String> listaNomes = new ArrayList<>();
        for(UsuarioDTO usuario : usuarioRepository.listarUsuarios()) {
            String inicialUsuario = usuario.getNome().valueOf(usuario.getNome().charAt(0));
            
            if (inicial.toLowerCase().equals(inicialUsuario.toLowerCase())) {
                listaNomes.add(usuario.getNome());
            }
        }

        return listaNomes;
    }

}
