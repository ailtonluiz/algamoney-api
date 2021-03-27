package com.algaworks.algamoney.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/***
 * Model de categorias
 * nessa classe estão definidos os
 * atributos
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "categoria")
public class Categoria {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;


    @NotNull
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    private Boolean ativo = true;

    @JsonIgnore
    @Transient
    public boolean isInativo(){
        return !this.ativo;
    }


}
