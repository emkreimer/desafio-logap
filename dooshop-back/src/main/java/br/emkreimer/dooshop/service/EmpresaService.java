package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.model.Empresa;
import br.emkreimer.dooshop.domain.model.Produto;
import br.emkreimer.dooshop.repository.EmpresaRepository;
import br.emkreimer.dooshop.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public Empresa cadastrar(Empresa empresa) {

        validarEmpresa(empresa);

        for (Produto produto : empresa.getProdutos()) {
            Optional<Produto> p = produtoRepository.findById(produto.getId());
            if (p.isPresent()) {
                p.get().getFornecedores().add(empresa);
                produtoRepository.save(p.get());
            }
        }
        return empresaRepository.save(empresa);
    }

    @Transactional
    public Iterable<Empresa> updateProdutosEmpresa(Produto produto) {
        for (Empresa e : produto.getFornecedores()) {
            if (!e.getProdutos().contains(produto)) {
                e.getProdutos().add(produto);
            }
        }
        return empresaRepository.saveAll(produto.getFornecedores());
    }

    public void validarEmpresa(Empresa empresa) {
        if (empresa.getNome() == null || empresa.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da empresa deve ser preenchido!");
        }
    }

    public List<Empresa> getAllFornecedores() {
        return empresaRepository.findAll();
    }

    public List<Empresa> getFornecedoresSemEstoque() {
        return empresaRepository.getAllSemEstoque();
    }
}
