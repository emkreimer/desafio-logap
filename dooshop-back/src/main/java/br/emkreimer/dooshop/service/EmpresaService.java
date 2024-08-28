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

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    List<Empresa> fornecedores = new ArrayList<>();

    @Transactional
    public Empresa cadastrar(Empresa empresa) {

        validarEmpresa(empresa);

        for (Produto produto : empresa.getProdutos()) {
            produto.getFornecedores().add(empresa);
        }
        fornecedores.add(empresa);
        empresa.getProdutos().forEach(p -> p.setFornecedores(fornecedores));

        Empresa nova = empresaRepository.save(empresa);
        produtoRepository.saveAll(empresa.getProdutos());
        return nova;
    }

    @Transactional
    public Iterable<Empresa> updateProdutosEmpresa(Produto produto) {
        for(Empresa e : produto.getFornecedores()) {
            e.getProdutos().add(produto);
        }
        return empresaRepository.saveAll(produto.getFornecedores());
    }

    public void validarEmpresa(Empresa empresa) {
        if (empresa.getNome() == null || empresa.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da empresa deve ser preenchido!");
        }
    }

    public List<Empresa> getFornecedoresSemEstoque() {
        return empresaRepository.getAllSemEstoque();
    }
}
