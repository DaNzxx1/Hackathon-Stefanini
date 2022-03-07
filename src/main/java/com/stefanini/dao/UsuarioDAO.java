package com.stefanini.dao;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.stefanini.entities.UsuarioEntity;

@ApplicationScoped
public class UsuarioDAO extends GenericDAO<UsuarioEntity, Long> {
    
    public List<UsuarioEntity> mesAniversario(int mes){
        return getEntityManager()
                .createNamedQuery("Usuario.mesAniversario", UsuarioEntity.class)
                .setParameter("mes", mes)
                .getResultList();
    }

}
