package br.emkreimer.dooshop.controller;

import br.emkreimer.dooshop.domain.model.Empresa;
import br.emkreimer.dooshop.domain.model.Produto;
import br.emkreimer.dooshop.service.EmpresaService;
import br.emkreimer.dooshop.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @Autowired
    ProdutoService produtoService;

    @PostMapping()
    // trocar p/ empresaDTO
    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody Empresa empresa) {
        return new ResponseEntity<>(empresaService.cadastrar(empresa), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public List<Produto> getProdutosByEmpresa(@PathVariable Integer id) {
        return produtoService.getProdutosByFornecedor(id);
    }

    @GetMapping("/estoque/{id}")
    public Integer getEstoqueByFornecedor(@PathVariable Integer id) {
        return empresaService.getEstoqueByFornecedor(id);
    }

    @GetMapping()
    public List<Empresa> getEmpresas() {
        return empresaService.getAllFornecedores();
    }

    @GetMapping("/sem-estoque")
    public List<Empresa> getEmpresasSemEstoque() {
        return empresaService.getFornecedoresSemEstoque();
    }
}
