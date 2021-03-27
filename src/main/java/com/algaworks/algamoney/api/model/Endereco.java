package com.algaworks.algamoney.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Getter
@Setter
@Embeddable
public class Endereco {

    @Size(min = 5, max = 150)
    private String logradouro;

    @Size(min = 1, max = 4)
    private String numero;

    @Size(min = 5, max = 150)
    private String complemento;

    @Size(min = 5, max = 150)
    private String bairro;

    private String cep;

    @Size(min = 5, max = 150)
    private String cidade;

    @Size(min = 5, max = 150)
    private String estado;


}
