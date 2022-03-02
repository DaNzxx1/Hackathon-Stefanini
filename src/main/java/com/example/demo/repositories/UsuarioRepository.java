package com.example.demo.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

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

    @Transactional
    public UsuarioEntity criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        insert(usuarioEntity);
        return usuarioEntity;
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioEntity =  update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }
    
    @Transactional
    public void deletarUsuario(Long idUsuario) { 
        UsuarioEntity usuarioEntity = findById(idUsuario);
        remove(usuarioEntity);
    }

}
