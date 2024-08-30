package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.model.Empresa;
import br.emkreimer.dooshop.domain.model.Produto;
import br.emkreimer.dooshop.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EmpresaService empresaService;

    @Transactional
    public Produto cadastrar(Produto produto) {
        Produto novo = validarProduto(produto);

        produtoRepository.save(novo);
        if (!novo.getFornecedores().isEmpty()) {
            empresaService.updateProdutosEmpresa(produto);
        }
        return novo;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public List<Produto> getProdutosFaltantes() { return produtoRepository.getProdutosFaltantes(); }

    public List<Produto> getProdutosByFornecedor(Integer id) {
        return produtoRepository.getProdutosByFornecedor(id);
    }

    public List<Object[]> getCategoriaWithCounts() {
        return produtoRepository.countProductsByCategoria();
    }

    public List<Object[]> getEstoqueByCategoria() {
        return produtoRepository.getEstoqueGroupedByCategoria();
    }

    public String deleteProdutoById(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.deleteById(id);
            return "Produto deletado com sucesso!";
        }
        return "Produto não encontrado.";
    }

    private Produto validarProduto(Produto produto) {
        if(produto.getId() != null) {
            List<Empresa> fornecedores = produtoRepository.findById(produto.getId()).get().getFornecedores();
            produto.setFornecedores(fornecedores);
        } else {
            produto.setFornecedores(new ArrayList<>());
        }

        return produto;
    }
}
