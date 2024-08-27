package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.model.Empresa;
import br.emkreimer.dooshop.repository.EmpresaRepository;
import br.emkreimer.dooshop.repository.ProdutoRepository;
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

    public Empresa cadastrar(Empresa empresa) {

        validarEmpresa(empresa);

        Empresa novaEmpresa = new Empresa();
        novaEmpresa.setNome(empresa.getNome());
        novaEmpresa.setProdutos(empresa.getProdutos());

        if(!novaEmpresa.getProdutos().isEmpty()) {
            fornecedores.add(novaEmpresa);
            novaEmpresa.getProdutos().forEach(p -> p.setFornecedores(fornecedores));
            produtoRepository.saveAll(novaEmpresa.getProdutos());
        }
        empresaRepository.save(novaEmpresa);
        return novaEmpresa;
    }

    public void validarEmpresa(Empresa empresa) {
        if (empresa.getNome() == null || empresa.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da empresa deve ser preenchido!");
        }
    }
}
