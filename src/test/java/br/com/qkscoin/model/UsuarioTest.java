package br.com.qkscoin.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qkscoin.Builders.UsuarioBuilder;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
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
	@DisplayName("Se findByIdOptional retorna Usuario correto")
	void testSeFindByIdOptionalRetornaUsuarioCorreto() {
		PanacheMock.mock(Usuario.class);
		Usuario u = new Usuario();
		Optional<PanacheEntityBase> usuario = Optional.of(u);
		when(Usuario.findByIdOptional(UsuarioBuilder.ID)).thenReturn(usuario);
		Assertions.assertSame(u, Usuario.findByIdOptional(UsuarioBuilder.ID).get());
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
