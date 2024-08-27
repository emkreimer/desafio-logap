package br.emkreimer.dooshop.controller;

import br.emkreimer.dooshop.domain.model.Produto;
import br.emkreimer.dooshop.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProdutoController {

    @Autowired ProdutoService produtoService;

    @PostMapping()
    //mudar para produtoDTO
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.cadastrar(produto), HttpStatus.OK);
    }

    @GetMapping()
    public List<Produto> getProdutos() {
        return produtoService.getAllProdutos();
    }
}
