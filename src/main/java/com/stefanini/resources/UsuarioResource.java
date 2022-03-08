package com.stefanini.resources;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.services.UsuarioService;

import io.smallrye.common.constraint.NotNull;

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
    @Path("/{idUsuario}")
    public Response buscarUsuarioPorId(@PathParam("idUsuario") Long idUsuario) {
        UsuarioDTO usuario = usuarioService.BuscarUsuarioPorId(idUsuario);
        return Response.status(Response.Status.OK).entity(usuario).build();
    }

    @POST 
    public Response salvarUsuario(@Valid @NotNull UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.CREATED).entity(usuarioService.salvarUsuario(usuarioDTO)).build();
    }

    @PUT
    public Response alterarUsuario(@Valid UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.OK).entity(usuarioService.alterarUsuario(usuarioDTO)).build();
    }

    @DELETE
    @Path("/{idUsuario}")
    public Response excluirUsuario(@PathParam("idUsuario") Long idUsuario) {
        usuarioService.excluirUsuario(idUsuario);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    //Outras funções
    @GET
    @Path("/aniversariantes")
    public Response aniversariantesDoMes() {
        List<UsuarioDTO> listaAniversariantes = usuarioService.aniversariantesDoMes();
        /* if (listaAniversariantes.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity(listaAniversariantes).build();
        } */
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
        return Response.status(Response.Status.OK).entity(usuarioService.listarIniciais(inicial)).build();
    }

}
