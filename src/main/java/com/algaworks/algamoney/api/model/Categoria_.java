package com.algaworks.algamoney.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, Long> codigo;
	public static volatile SingularAttribute<Categoria, Boolean> ativo;
	public static volatile SingularAttribute<Categoria, String> nome;

	public static final String CODIGO = "codigo";
	public static final String ATIVO = "ativo";
	public static final String NOME = "nome";

}

