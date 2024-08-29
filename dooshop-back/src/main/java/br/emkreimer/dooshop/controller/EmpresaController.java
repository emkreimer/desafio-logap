package br.emkreimer.dooshop.controller;

import br.emkreimer.dooshop.domain.model.Empresa;
import br.emkreimer.dooshop.service.EmpresaService;
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

    @PostMapping()
    // trocar p/ empresaDTO
    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody Empresa empresa) {
        return new ResponseEntity<>(empresaService.cadastrar(empresa), HttpStatus.OK);
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
