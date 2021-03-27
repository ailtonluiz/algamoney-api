package com.algaworks.algamoney.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "pessoa")
public class Pessoa {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank
    @Size(min = 4, max = 150)
    private String nome;

    @NotNull
    private Boolean ativo;

    @Embedded
    private Endereco endereco;


    @JsonIgnore
    @Transient
    public boolean isInativo() {
        return !this.ativo;
    }

}
