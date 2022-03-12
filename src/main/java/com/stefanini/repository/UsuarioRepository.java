package com.stefanini.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.LoginDTO;
import com.stefanini.dto.UsuarioDTO;
import com.stefanini.entities.UsuarioEntity;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<UsuarioEntity, Long> {

    //CRUD
    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioEntity> listaUsuarios = this.listAll();
        return listaUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO buscarUsuarioPorId(Long idUsuario) {
        try {
            return new UsuarioDTO(this.findById(idUsuario));
            
        } catch (Exception e) {
            throw new RuntimeException("Usuário não existe!");
        }
    }

    @Transactional
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.save(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public void excluirUsuario(Long idUsuario) {
        try {
            this.delete(idUsuario);
            
        } catch (Exception e) {
            throw new RuntimeException("Usuário não existe!");
        }
    }

    //Outras funções

    public UsuarioDTO login(LoginDTO login) {
        UsuarioEntity usuario = null;
        try {
            Query nativeQuery = this.createNativeQuery("SELECT * FROM usuarios WHERE login = ? AND senha = ?");
            nativeQuery.setParameter(1, login.getLogin());
            nativeQuery.setParameter(2, login.getSenha());
            usuario = (UsuarioEntity) nativeQuery.getResultList().get(0);
            return new UsuarioDTO(usuario);

        } catch (Exception erro) {
            throw new RuntimeException("Login ou Senha incorretos!");
        }
    }

    public List<UsuarioDTO> aniversariantesDoMes() {
        Query nativeQuery = this.createNativeQuery("SELECT * FROM usuarios WHERE month(data_nascimento) = ?");
        nativeQuery.setParameter(1, LocalDate.now().getMonthValue());
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> provedores() {
        Query nativeQuery = this.createNativeQuery("Select distinct substring(email, instr(email, '@'), length (email)) as email from usuarios");
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarIniciais(String inicial) {
        Query nativeQuery = this.createNativeQuery("SELECT * FROM usuarios WHERE nome LIKE ?");
        nativeQuery.setParameter(1, inicial+"%");
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
}
