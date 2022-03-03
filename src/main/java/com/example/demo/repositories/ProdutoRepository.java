package com.example.demo.repositories;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import com.example.demo.DAO.ProdutoDAO;
import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.entities.ProdutoEntity;

@Stateless
public class ProdutoRepository {

    @EJB
    ProdutoDAO produtoDAO;
    
    public List<ProdutoEntity> listarProdutos() {
        return produtoDAO.list();
    }
    
    public ProdutoEntity pegarProdutoPorId(Long idProdudo) {
        return produtoDAO.findById(idProdudo);
    }

    @Transactional
    public ProdutoEntity criarProduto(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produtoDTO);
        produtoDAO.insert(produtoEntity);
        return produtoEntity;
    }

    @Transactional
    public ProdutoDTO atualizarProduto(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produtoDTO);
        produtoEntity =  produtoDAO.update(produtoEntity);
        return new ProdutoDTO(produtoEntity);
    }
    
    @Transactional
    public void deletarProduto(Long idProdudo) { 
        ProdutoEntity produtoEntity = produtoDAO.findById(idProdudo);
        produtoDAO.remove(produtoEntity);
    }

}
