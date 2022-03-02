package com.example.demo.repositories;

import java.util.List;

import javax.ejb.Stateless;

import com.example.demo.DAO.UsuarioDAO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.entities.UsuarioEntity;

@Stateless
public class UsuarioRepository extends UsuarioDAO {
    
    public List<UsuarioEntity> listarUsuarios() {
        return list();
    }
    
    public UsuarioEntity pegarUsuarioPorId(Long idUsuario) {
        return findById(idUsuario);
    }
    
    public UsuarioEntity criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        insert(usuarioEntity);
        return usuarioEntity;
    }

    public UsuarioEntity atualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        return update(usuarioEntity);
    }
    
    public UsuarioEntity deletarUsuario(UsuarioDTO usuarioDTO) { 
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        remove(usuarioEntity);
        return usuarioEntity;
    }

}
