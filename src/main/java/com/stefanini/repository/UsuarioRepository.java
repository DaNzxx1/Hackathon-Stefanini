package com.stefanini.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.UsuarioDTO;
import com.stefanini.entities.UsuarioEntity;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<UsuarioEntity, Long> {

    //CRUD
    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioEntity> listaUsuarios = this.listAll();
        return listaUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO BuscarUsuarioPorId(Long idUsuario) {
        return new UsuarioDTO(this.findById(idUsuario));
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
        this.delete(idUsuario);
    }

    //Outras funções

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
