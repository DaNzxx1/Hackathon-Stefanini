package com.example.demo.resouces;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.services.UsuarioService;

@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResouce {

    @Inject
    UsuarioService usuarioService;
    
    @GET
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
    
    @GET
    @Path("/{idUsuario}")
    public UsuarioDTO pegarUsuarioPorId(@PathParam("idUsuario") long idUsuario) {
        return usuarioService.pegarUsuarioPorId(idUsuario);
    }

    @POST
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        return usuarioService.criarUsuario(usuarioDTO);
    }

    @PUT 
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        return usuarioService.atualizarUsuario(usuarioDTO);
    }

    @DELETE
    public UsuarioDTO deletarUsuario(UsuarioDTO usuarioDTO) {
        return usuarioService.deletarUsuario(usuarioDTO);
    }

}
