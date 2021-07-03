package br.com.qkscoin.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.qkscoin.model.Bitcoin;

@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api") //informar que esse “BitcoinService” aqui ele pode ser injetado, que ele vai ser injetado em algum recurso da nossa aplicação
public interface BitcoinService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar();

}
