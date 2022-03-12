package com.stefanini.resources;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.stefanini.dto.LoginDTO;
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
        return Response.status(Response.Status.OK).entity(usuarioService.listarUsuarios()).build();
    }

    @GET
    @Path("/{idUsuario}")
    public Response buscarUsuarioPorId(@PathParam("idUsuario") Long idUsuario) {
        UsuarioDTO usuario = usuarioService.buscarUsuarioPorId(idUsuario);
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

    @POST
    @Path("/login")
    public Response login(@Valid @NotNull LoginDTO login) {
        return Response.status(Response.Status.OK).entity(usuarioService.login(login)).build();
    }

    //Outras funções
    @GET
    @Path("/aniversariantes")
    public Response aniversariantesDoMes() {
        return Response.status(Response.Status.OK).entity(usuarioService.aniversariantesDoMes()).build();
    }

    @GET
    @Path("/provedores")
    public Response provedores() {
        return Response.status(Response.Status.OK).entity(usuarioService.provedores()).build();
    }

    @GET
    @Path("/inicial/{inicial}")
    public Response listarIniciais(@PathParam("inicial") String inicial) {
        return Response.status(Response.Status.OK).entity(usuarioService.listarIniciais(inicial)).build();
    }

}
