package br.com.qkscoin.Builders;

import br.com.qkscoin.model.Usuario;

public class UsuarioBuilder {
	
	public static final Long ID = 1L;
	public static final String NOME = "José Luan Brito";
	public static final String CPF = "43.633.362-4";
	public static final String USERNAME = "ze";
	public static final String PASSWORD = "123";
	
	private Usuario usuario;
	
	public UsuarioBuilder() {}
	
	public static UsuarioBuilder usuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		builder.usuario = new Usuario.Builder(NOME, CPF)
				.id(ID)
				.password(PASSWORD)
				.username(USERNAME)
				.build();
		return builder;
	}
	
	public UsuarioBuilder setPassWord(String senha) {
		usuario.setPassword(senha);
		return this;
	}
	
	public UsuarioBuilder setUserName(String user) {
		usuario.setUsername(user);
		return this;
	}
	
	public Usuario agora() {
		return usuario;
	}

}
