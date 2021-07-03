package br.com.qkscoin.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.qkscoin.contants.Constants;
import br.com.qkscoin.model.Bitcoin;
import br.com.qkscoin.service.BitcoinService;

@Path(Constants.V1 + Constants.BITCOINS)
public class BitcoinResource {
	
	@Inject
	@RestClient
	BitcoinService bitcoinService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar() {
		return bitcoinService.listar();
	}

}
