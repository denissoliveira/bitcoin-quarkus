package br.com.qkscoin.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.qkscoin.Builders.OrdemBuilder;
import br.com.qkscoin.model.Ordem;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
class OrdemRepositoryTest {
	
	@InjectMock private OrdemRepository ordemRepository;
	private Ordem primeiraOrdem;
	private Ordem segundaOrdem;

	@BeforeEach
	void setUp() throws Exception {
		primeiraOrdem = OrdemBuilder.ordem().setId(1L).setUserId(1L).agora();
		segundaOrdem = OrdemBuilder.ordem().setId(2L).setUserId(1L).agora();
		List<Ordem> ordens = Arrays.asList(primeiraOrdem,segundaOrdem);
		when(ordemRepository.listAll()).thenReturn(ordens);
	}

	@Test
	void testSeListAllRetornaOrdensCorretas() {
		assertEquals(segundaOrdem, ordemRepository.listAll().get(1));
	}

}
