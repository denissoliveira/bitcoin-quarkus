package br.com.qkscoin.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qkscoin.Builders.OrdemBuilder;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class OrdemTest {
	
	private Ordem ordem;

	@BeforeEach
	void setUp() throws Exception {
		ordem = OrdemBuilder.ordem()
				.setId(OrdemBuilder.ID)
				.setUserId(OrdemBuilder.USER_ID)
				.agora();
		ordem.setData(OrdemBuilder.DATA);
		ordem.setId(OrdemBuilder.ID);
		ordem.setPreco(OrdemBuilder.PRECO);
		ordem.setStatus(OrdemBuilder.STATUS);
		ordem.setTipo(OrdemBuilder.TIPO);
		ordem.setUserId(OrdemBuilder.USER_ID);
	}

	@Test
	@DisplayName("Teste de instancia")
	void testOrdem() {
		assertNotNull(new Ordem());
	}

	@Test
	void testGetId() {
		assertEquals(OrdemBuilder.ID, ordem.getId(), "Verificando ID");
	}

	@Test
	void testGetPreco() {
		assertEquals(OrdemBuilder.PRECO, ordem.getPreco());
	}

	@Test
	void testGetTipo() {
		assertEquals(OrdemBuilder.TIPO, ordem.getTipo());
	}

	@Test
	void testGetData() {
		assertEquals(OrdemBuilder.DATA, ordem.getData());
	}

	@Test
	void testGetStatus() {
		assertEquals(OrdemBuilder.STATUS, ordem.getStatus());
	}

	@Test
	void testGetUserId() {
		assertEquals(OrdemBuilder.USER_ID, ordem.getUserId());
	}

}
