package br.com.qkscoin.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.qkscoin.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped //chama uma única vez
public class OrdemRepository implements PanacheRepository<Ordem> {

}
