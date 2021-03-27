package com.algaworks.algamoney.api.service;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria atualizar(@PathVariable Long codigo, @RequestBody Categoria categoria) {

        Categoria categoriaSalva = buscarCategoriaPorCodigo(codigo);


        BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");

        return this.categoriaRepository.save(categoriaSalva);
    }

    private Categoria buscarCategoriaPorCodigo(Long codigo) {
        Categoria categoriaSalva = this.categoriaRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        return categoriaSalva;
    }
}
