package br.emkreimer.dooshop.controller;

import br.emkreimer.dooshop.domain.enums.Categoria;
import br.emkreimer.dooshop.domain.model.Produto;
import br.emkreimer.dooshop.service.ProdutoService;
import br.emkreimer.dooshop.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ProdutoController {

    @Autowired ProdutoService produtoService;

    @Autowired RelatorioService relatorioService;

    @PostMapping()
    //mudar para produtoDTO
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.cadastrar(produto), HttpStatus.OK);
    }

    @GetMapping()
    public List<Produto> getProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/produtos-faltantes")
    public List<Produto> getProdutosFaltantes() {
        return produtoService.getProdutosFaltantes();
    }

    @GetMapping("/categorias")
    public List<Object[]> getCountByCategoria() {
        return produtoService.getCategoriaWithCounts();
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduto(@RequestParam Integer id) {
        return new ResponseEntity<>(produtoService.deleteProdutoById(id), HttpStatus.OK);
    }

    ///////////////// Relatório ////////////////////////
    @GetMapping("/relatorio")
    public ResponseEntity<byte[]> gerarRelatorio() {
        ByteArrayOutputStream pdfStream = relatorioService.createPdf();

        byte[] pdfBytes = pdfStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "produto_report.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
