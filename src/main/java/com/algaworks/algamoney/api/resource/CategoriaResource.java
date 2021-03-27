package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.event.RecursoCriadoEvent;
import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping
    public List<Categoria> listar() {

        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);


        applicationEventPublisher.publishEvent(new RecursoCriadoEvent(this, response, categoria.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);

    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(codigo);
        return categoria.isPresent() ?
                ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {

        categoriaRepository.deleteById(codigo);

    }

    @PutMapping("/{codigo}")
    public Categoria atualizar(@PathVariable Long codigo, @RequestBody Categoria categoria) {

        Categoria categoriaSalva = this.categoriaRepository.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");

        return this.categoriaRepository.save(categoriaSalva);
    }

}
