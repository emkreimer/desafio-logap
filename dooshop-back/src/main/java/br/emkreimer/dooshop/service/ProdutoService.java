package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.enums.Categoria;
import br.emkreimer.dooshop.domain.model.Produto;
import br.emkreimer.dooshop.repository.EmpresaRepository;
import br.emkreimer.dooshop.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EmpresaService empresaService;

    List<Produto> novosProdutos = new ArrayList<>();

    @Transactional
    public Produto cadastrar(Produto produto) {
        //validar
        Produto novo = produtoRepository.save(produto);
        empresaService.updateProdutosEmpresa(produto);
        return novo;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public List<Produto> getProdutosByCategoria(Categoria categoria) {
        return null;

    }
}
