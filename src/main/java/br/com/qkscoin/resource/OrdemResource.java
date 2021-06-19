package br.com.qkscoin.resource;

import java.time.LocalDate;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.qkscoin.model.Ordem;
import br.com.qkscoin.repository.OrdemRepository;

@Path("/ordem")
public class OrdemResource {
	
	private static final String ENVIADA = "ENVIADA";
	
	@Inject
	OrdemRepository ordemRepository;
	
	@POST
	@Transactional
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Ordem ordem) {
		ordem.setData(LocalDate.now());
		ordem.setStatus(ENVIADA);
		ordemRepository.persist(ordem);
	}

}
