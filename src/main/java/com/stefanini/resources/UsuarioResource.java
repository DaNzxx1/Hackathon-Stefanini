package com.stefanini.resources;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.services.UsuarioService;

@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    UsuarioService usuarioService;

    //CRUD
    @GET
    public Response listarUsuarios() {
        List<UsuarioDTO> listaUsuarios = usuarioService.listarUsuarios();
        if (Objects.nonNull(listaUsuarios)) {
            return Response.status(Response.Status.OK).entity(listaUsuarios).build();
        }
        return Response.status(Response.Status.NO_CONTENT).entity(listaUsuarios).build();
    }

    @GET
    @Path("/id/{idUsuario}")
    public Response buscarUsuarioPorId(@PathParam("idUsuario") Long idUsuario) {
        UsuarioDTO usuario = usuarioService.BuscarUsuarioPorId(idUsuario);
        if (Objects.nonNull(usuario)) {
            return Response.status(Response.Status.NO_CONTENT).entity(usuario).build();
        }
        return Response.status(Response.Status.OK).entity(usuario).build();
    }

    @POST
    @Valid
    public Response salvarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioService.salvarUsuario(usuarioDTO);
        if (Objects.nonNull(usuario)) {
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Ocorreu um erro na sua requisição").build();
    }

    @PUT
    @Valid
    public Response alterarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = usuarioService.alterarUsuario(usuarioDTO);
        return Response.status(Response.Status.OK).entity(usuario).build();
    }

    @DELETE
    @Path("/{idUsuario}")
    public Response excluirUsuario(@PathParam("idUsuario") Long idUsuario) {
        usuarioService.excluirUsuario(idUsuario);
        return Response.status(Response.Status.ACCEPTED).entity("Deletado!").build();
    }

    //Outras funções
    @GET
    @Path("/aniversarios")
    public Response mesAniversario() {
        List<UsuarioDTO> listaAniversariantes = usuarioService.mesAniversario();
        if (listaAniversariantes.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity(listaAniversariantes).build();
        }   
        return Response.status(Response.Status.OK).entity(listaAniversariantes).build();
    }

    @GET
    @Path("/provedores")
    public Response provedores() {
        List<String> listaProvedores = usuarioService.provedores();
        if (listaProvedores.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity(listaProvedores).build();
        }   
        return Response.status(Response.Status.OK).entity(listaProvedores).build();
    }

    @GET
    @Path("/inicial/{inicial}")
    public Response listarIniciais(@PathParam("inicial") String inicial) {
        List<String> listaNomes = usuarioService.listarIniciais(inicial);
        if (listaNomes.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity(listaNomes).build();
        }   
        return Response.status(Response.Status.OK).entity(listaNomes).build();
    }

}
