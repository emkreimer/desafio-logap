package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.model.Produto;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class RelatorioService {

    public ByteArrayOutputStream createPdf(List<Produto> produtos) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(25, 700);
            contentStream.showText("Doo Relatório");
            contentStream.newLine();

            for (Produto produto : produtos) {
                contentStream.showText("ID: " + produto.getId() + ", Name: " + produto.getNome());
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();

            document.save(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputStream;
    }
}

