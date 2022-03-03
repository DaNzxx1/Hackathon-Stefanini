package com.example.demo.resources;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.entities.UsuarioEntity;
import com.example.demo.services.UsuarioService;

@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @EJB
    UsuarioService usuarioService;
    
    @GET
    public Response listarUsuarios() {
        List<UsuarioDTO> listaUsuarios = usuarioService.listarUsuarios();
        return Response.status(Response.Status.OK).entity(listaUsuarios).build();
    }
    
    @GET
    @Path("/{idUsuario}")
    public Response pegarUsuarioPorId(@PathParam("idUsuario") Long idUsuario) {
        UsuarioDTO usuarioDTO = usuarioService.pegarUsuarioPorId(idUsuario);
        return Response.status(Response.Status.OK).entity(usuarioDTO).build();
    }

    @POST
    public Response criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioService.criarUsuario(usuarioDTO));
        if(Objects.nonNull(usuarioEntity)) {
            return Response.ok(new UsuarioDTO(usuarioEntity)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Ocorreu um erro ao processar sua requisição").build();
    }

    @PUT 
    public Response atualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioDto = usuarioService.atualizarUsuario(usuarioDTO);
        return Response.status(Response.Status.OK).entity(usuarioDto).build();
        //return Response.status(Response.Status.NO_CONTENT).entity(dto).build();
    }

    @DELETE
    @Path("/{idUsuario}")
    public Response deletarUsuario(@PathParam("idUsuario") Long idUsuario) {
        usuarioService.deletarUsuario(idUsuario);
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
