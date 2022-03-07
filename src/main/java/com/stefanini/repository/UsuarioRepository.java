package com.stefanini.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.stefanini.dao.UsuarioDAO;
import com.stefanini.dto.UsuarioDTO;
import com.stefanini.entities.UsuarioEntity;

@ApplicationScoped
public class UsuarioRepository {
    
    @Inject
    UsuarioDAO usuarioDAO;

    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioDTO> listNull = null;
        List<UsuarioEntity> list = usuarioDAO.listAll();
        if (list.isEmpty()) {
            return listNull;
        }
        return list.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO BuscarUsuarioPorId(Long idUsuario) {
        return new UsuarioDTO(usuarioDAO.findById(idUsuario));
    }

    @Transactional
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioDAO.save(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioDAO.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public void excluirUsuario(Long idUsuario) {
        usuarioDAO.delete(idUsuario);
    }
}
