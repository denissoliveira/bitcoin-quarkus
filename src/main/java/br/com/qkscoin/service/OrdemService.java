package br.com.qkscoin.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.qkscoin.model.Ordem;
import br.com.qkscoin.model.Usuario;
import br.com.qkscoin.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {
	
	private static final String ENVIADA = "ENVIADA";
	
	@Inject OrdemRepository ordemRepository;
	
	public void inserir(SecurityContext securityContext, Ordem ordem) {
		Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
		var usuario = usuarioOptional.orElseThrow();
		if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
			throw new RuntimeException("O usuário logado é diferente do userId");
		}
		ordem.setData(LocalDate.now());
		ordem.setStatus(ENVIADA);
		ordemRepository.persist(ordem);
	}

	public List<Ordem> listar() {
		return ordemRepository.listAll();
	}

}
