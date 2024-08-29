package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.enums.Categoria;
import br.emkreimer.dooshop.domain.model.Empresa;
import br.emkreimer.dooshop.domain.model.Produto;
import com.lowagie.text.*;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired ProdutoService produtoService;

    @Autowired EmpresaService empresaService;

    public ByteArrayOutputStream createPdf() {
        List<Produto> produtos = produtoService.getProdutosFaltantes();
        List<Empresa> empresas = empresaService.getFornecedoresSemEstoque();
        List<Object[]> categorias = produtoService.getEstoqueByCategoria();

        String[] produtoHeaders = new String[] {"ID", "Nome", "Valor (R$)", "Categoria", "Estoque"};
        String[] empresaHeaders = new String[] {"ID", "Nome"};
        String[] categoriaHeaders = new String[] {"Categoria", "Estoque"};

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Relatório de Doo Serviços LTDA", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            PdfPTable produtosEmFalta = new PdfPTable(5);
            PdfPTable fornecedoresSemEstoque = new PdfPTable(2);
            PdfPTable categoriaEstoque = new PdfPTable(2);

            produtosEmFalta.setWidthPercentage(100);
            fornecedoresSemEstoque.setWidthPercentage(100);
            categoriaEstoque.setWidthPercentage(100);

            addTableHeader(produtosEmFalta, produtoHeaders);
            addTableHeader(fornecedoresSemEstoque, empresaHeaders);
            addTableHeader(categoriaEstoque, categoriaHeaders);

            addRowsProduto(produtosEmFalta, produtos);
            addRowsEmpresa(fornecedoresSemEstoque, empresas);
            addRowsCategoria(categoriaEstoque, categorias);

            document.add(categoriaEstoque);
            document.add(new Paragraph("\n\n\n\n\n"));
            document.add(fornecedoresSemEstoque);
            document.add(new Paragraph("\n\n\n\n\n"));
            document.add(produtosEmFalta);
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }

        return out;
    }

    private void addTableHeader(PdfPTable table, String[] headers) {
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell(new Paragraph(header, headerFont));
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);
        }
    }

    private void addRowsProduto(PdfPTable table, List<Produto> produtos) {
        Font rowFont = new Font(Font.HELVETICA, 10);
        if (produtos.isEmpty()) {
            table.addCell(new PdfPCell(new Paragraph("Não há nenhum produto sem estoque!", rowFont)));
        } else {
            for (Produto produto : produtos) {
                table.addCell(new PdfPCell(new Paragraph(produto.getId().toString(), rowFont)));
                table.addCell(new PdfPCell(new Paragraph(produto.getNome(), rowFont)));
                table.addCell(new PdfPCell(new Paragraph(produto.getValor().toString(), rowFont)));
                table.addCell(new PdfPCell(new Paragraph(produto.getCategoria().toString(), rowFont)));
                table.addCell(new PdfPCell(new Paragraph(produto.getEstoque().toString(), rowFont)));
            }
        }
    }

    private void addRowsEmpresa(PdfPTable table, List<Empresa> empresas) {
        Font rowFont = new Font(Font.HELVETICA, 10);
        if (empresas.isEmpty()) {
            table.addCell(new PdfPCell(new Paragraph("Não há fornecedores sem estoque!", rowFont)));
        } else {
            for (Empresa e: empresas) {
                table.addCell(new PdfPCell(new Paragraph(e.getId().toString(), rowFont)));
                table.addCell(new PdfPCell(new Paragraph(e.getNome(), rowFont)));
            }
        }
    }

    private void addRowsCategoria(PdfPTable table, List<Object[]> categorias) {
        Font rowFont = new Font(Font.HELVETICA, 10);
        for (Object c : categorias) {

            Object[] data = (Object[]) c;
            Categoria categoria = (Categoria) data[0];
            Long estoqueSum = (Long) data[1];

            table.addCell(new PdfPCell(new Paragraph(categoria.toString(), rowFont)));
            table.addCell(new PdfPCell(new Paragraph(estoqueSum.toString(), rowFont)));
        }
    }
}

