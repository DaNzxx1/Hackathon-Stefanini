package com.example.demo.repositories;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import com.example.demo.DAO.UsuarioDAO;
import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.entities.UsuarioEntity;

@Stateless
public class UsuarioRepository {

    @EJB
    UsuarioDAO usuarioDAO;
    
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioDAO.list();
    }
    
    public UsuarioEntity pegarUsuarioPorId(Long idUsuario) {
        return usuarioDAO.findById(idUsuario);
    }

    @Transactional
    public UsuarioEntity criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioDAO.insert(usuarioEntity);
        return usuarioEntity;
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioEntity =  usuarioDAO.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }
    
    @Transactional
    public void deletarUsuario(Long idUsuario) { 
        UsuarioEntity usuarioEntity = usuarioDAO.findById(idUsuario);
        usuarioDAO.remove(usuarioEntity);
    }

}
