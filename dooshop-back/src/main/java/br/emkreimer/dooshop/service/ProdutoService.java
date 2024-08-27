package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.model.Produto;
import br.emkreimer.dooshop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }
}
