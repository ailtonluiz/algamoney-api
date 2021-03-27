package com.algaworks.algamoney.api.repository.lancamento;

import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {


    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
