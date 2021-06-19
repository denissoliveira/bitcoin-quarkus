package br.com.qkscoin.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qkscoin.Builders.UsuarioBuilder;

/*
 * Teste para cobertura de código
 */
class UsuarioTest {
	
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		usuario = new Usuario(UsuarioBuilder.ID, 
				UsuarioBuilder.NOME, UsuarioBuilder.CPF, 
				UsuarioBuilder.USERNAME, UsuarioBuilder.PASSWORD);
		usuario.setCpf(UsuarioBuilder.CPF);
		usuario.setId(UsuarioBuilder.ID);
		usuario.setNome(UsuarioBuilder.NOME);
		usuario.setPassword(UsuarioBuilder.PASSWORD);
		usuario.setUsername(UsuarioBuilder.USERNAME);
	}
	

	@Test
	@DisplayName("Verificando os metodos do modelo")
	void test() {
		assertEquals(UsuarioBuilder.ID, usuario.getId());
		assertEquals(UsuarioBuilder.NOME, usuario.getNome());
		assertEquals(UsuarioBuilder.CPF, usuario.getCpf());
		assertEquals(UsuarioBuilder.USERNAME, usuario.getUsername());
		assertEquals(UsuarioBuilder.PASSWORD, usuario.getPassword());
	}
	
	@Test
	void testInstancia() {
		assertNotNull(new Usuario());
	}
	
	@Test
	@DisplayName("Testando o Builder :)")
	void testBuilder() {
		assertNotNull(new Usuario.Builder( 
				UsuarioBuilder.NOME, 
				UsuarioBuilder.CPF)
				.id(UsuarioBuilder.ID)
				.username(UsuarioBuilder.NOME)
				.password(UsuarioBuilder.PASSWORD)
				.build());
	}

}
