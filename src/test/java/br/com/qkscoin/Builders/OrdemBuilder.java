package br.com.qkscoin.Builders;

import java.time.LocalDate;

import br.com.qkscoin.model.Ordem;

public class OrdemBuilder {
	
	public static final Long ID = 2L;
	public static final Long USER_ID = 1L;
	public static final Double PRECO = 99.20;
	public static final String TIPO = "COMPRA";
	public static final LocalDate DATA = LocalDate.now();
	public static final String STATUS = "ENVIADO";
	
	private Ordem Ordem;
	
	public OrdemBuilder() {}
	
	public static OrdemBuilder ordem() {
		OrdemBuilder builder = new OrdemBuilder();
		builder.Ordem = new Ordem.Builder(PRECO,TIPO,DATA,STATUS)
				.userId(USER_ID)
				.id(ID)
				.build();
		return builder;
	}
	
	public OrdemBuilder setId(Long id) {
		Ordem.setId(id);
		return this;
	}
	
	public OrdemBuilder setUserId(Long id) {
		Ordem.setUserId(id);
		return this;
	}
	
	public Ordem agora() {
		return Ordem;
	}

}
