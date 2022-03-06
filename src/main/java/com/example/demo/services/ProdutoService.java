package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.example.demo.dto.ProdutoDTO;
import com.example.demo.entities.ProdutoEntity;
import com.example.demo.repositories.ProdutoRepository;

@Stateless
public class ProdutoService {
    
    @EJB
    ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarProdutos() {
        List<ProdutoEntity> list = produtoRepository.listarProdutos();
        return list.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
    
    public ProdutoDTO pegarProdutoPorId(Long idProduto) {
        return new ProdutoDTO(produtoRepository.pegarProdutoPorId(idProduto));
    }
    
    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        return new ProdutoDTO(produtoRepository.criarProduto(produtoDTO));
    }

    public ProdutoDTO atualizarProduto(ProdutoDTO produtoDTO) {
        return produtoRepository.atualizarProduto(produtoDTO);
    }

    public void deletarProduto(Long idProduto) {
        produtoRepository.deletarProduto(idProduto);
    }

}
