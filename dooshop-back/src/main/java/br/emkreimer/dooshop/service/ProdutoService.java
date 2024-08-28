package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.enums.Categoria;
import br.emkreimer.dooshop.domain.model.Produto;
import br.emkreimer.dooshop.repository.EmpresaRepository;
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

    public List<Produto> getProdutosFaltantes() { return produtoRepository.getProdutosFaltantes(); }

    public List<Map<Categoria, Long>> getCategoriaWithCounts() {
        List<Object[]> counts = produtoRepository.countProductsByCategoria();
        List<Map<Categoria, Long>> categorias = new ArrayList<>();

        for(Object[] c : counts) {
            int categoriaId = (Integer) c[0];
            long count = ((Number) c[1]).longValue();
            Categoria categoria = Categoria.fromId(categoriaId);
            Map<Categoria, Long> map = new HashMap<>();
            map.put(categoria, count);
            categorias.add(map);
        }
        return categorias;
    }

    public String deleteProdutoById(Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.deleteById(id);
            return "Produto deletado com sucesso!";
        }
        return "Produto não encontrado.";
    }

    public List<Produto> getProdutosByCategoria(Categoria categoria) {
        return null;

    }
}
