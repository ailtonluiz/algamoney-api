package com.algaworks.algamoney.api.service;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.model.Pessoa;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import com.algaworks.algamoney.api.repository.LancamentoRepository;
import com.algaworks.algamoney.api.repository.PessoaRepository;
import com.algaworks.algamoney.api.service.exception.CadastroInexistenteOuInativoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(@Valid Lancamento lancamento) {
       Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if (!pessoa.isPresent() || pessoa.get().isInativo()) {
            throw new CadastroInexistenteOuInativoException();
        }

        Optional<Categoria> categoria = categoriaRepository.findById(lancamento.getCategoria().getCodigo());
        if(!categoria.isPresent() || categoria.get().isInativo()){
            throw new CadastroInexistenteOuInativoException();
        }

        return lancamentoRepository.save(lancamento);
    }


}
