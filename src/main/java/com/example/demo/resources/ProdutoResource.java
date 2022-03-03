package com.example.demo.resources;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.entities.ProdutoEntity;
import com.example.demo.services.ProdutoService;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @EJB
    ProdutoService produtoService;
    
    @GET
    public Response ListarProdutos() {
        List<ProdutoDTO> listarProdutos = produtoService.listarProdutos();
        return Response.status(Response.Status.OK).entity(listarProdutos).build();
    }
    
    @GET
    @Path("/{idProduto}")
    public Response pegarProdutoPorId(@PathParam("idProduto") Long idProduto) {
        ProdutoDTO produtoDTO = produtoService.pegarProdutoPorId(idProduto);
        return Response.status(Response.Status.OK).entity(produtoDTO).build();
    }

    @POST
    public Response criarProduto(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produtoService.criarProduto(produtoDTO));
        if(Objects.nonNull(produtoEntity)) {
            return Response.ok(new ProdutoDTO(produtoEntity)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Ocorreu um erro ao processar sua requisição").build();
    }

    @PUT 
    public Response atualizarProduto(ProdutoDTO produtoDTO) {
        ProdutoDTO produtoDto = produtoService.atualizarProduto(produtoDTO);
        return Response.status(Response.Status.OK).entity(produtoDto).build();
        //return Response.status(Response.Status.NO_CONTENT).entity(dto).build();
    }

    @DELETE
    @Path("/{idProduto}")
    public Response deletarProduto(@PathParam("idProduto") Long idProduto) {
        produtoService.deletarProduto(idProduto);
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
