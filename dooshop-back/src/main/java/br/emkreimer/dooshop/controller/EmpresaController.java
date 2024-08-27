package br.emkreimer.dooshop.controller;

import br.emkreimer.dooshop.domain.model.Empresa;
import br.emkreimer.dooshop.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
