package br.com.qkscoin.resource;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

}
