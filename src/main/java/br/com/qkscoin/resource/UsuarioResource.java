package br.com.qkscoin.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.qkscoin.model.Usuario;

@Path("/usuario")
public class UsuarioResource {
	
	@POST
	@Transactional
	@PermitAll
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		Usuario.adicionar(usuario);
	}
	
	@GET
	@Path("/lista")
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() {
		return Usuario.listAll();
	}

}
