package com.maisprati.codifica.alucar.Util.FileReader;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public interface PDFUtils {

    @SuppressWarnings("all")
    static byte[] convertFileToBytes(String filePath) throws IOException{
        File pdfFile = new File(filePath);
        try (FileInputStream fis = new FileInputStream(pdfFile)){
            byte[] data = new byte[(int) pdfFile.length()];
            fis.read(data);
            return data;
        }
    }
    static Path convertBytesToFile(byte[] pdfbytes) throws IOException {
        Path tempFilePath = Files.createTempFile("tempDoc" , ".pdf");
        Files.write(tempFilePath , pdfbytes);
        return tempFilePath;
    }
    static String extractField(String text, String fieldName) {
        int startIndex = text.indexOf(fieldName);
        if (startIndex == -1) {
            return "Campo " + fieldName + " não encontrado.";
        }
        startIndex += fieldName.length();
        int endIndex = text.indexOf("\n", startIndex);
        if (endIndex == -1) {
            endIndex = text.length();
        }
        return text.substring(startIndex, endIndex).trim();
    }

    static void createCNH_PDFfile(
            String Nome , String DocIdentidade , String ORGemissor , String UF ,
            String CPF , String DataNascimento , String FiliacaoPai , String FiliacaoMae ,
            String NumeroRegistro , String Validade , String PrimeiraHabilitacao , String Categoria)
    {
        try {
            String dest = "src/main/java/com/maisprati/codifica/alucar/Util/FileReader/CNH_exemplo.pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Adiciona parágrafos e texto ao documento
            document.add(new Paragraph("NOME:" + Nome + "\n"));
            document.add(new Paragraph("DOC. IDENTIDADE:" + DocIdentidade + "\n"));
            document.add(new Paragraph("ORG. EMISSOR:" + ORGemissor + "\n"));
            document.add(new Paragraph("UF:" + UF + "\n"));
            document.add(new Paragraph("CPF:" + CPF + "\n"));
            document.add(new Paragraph("DATA NASCIMENTO:" + DataNascimento + "\n"));
            document.add(new Paragraph("FILIAÇÃO NOME DO PAI:" + FiliacaoPai + "\n"));
            document.add(new Paragraph("FILIAÇÃO NOME DA MAE:" + FiliacaoMae + "\n"));
            document.add(new Paragraph("Nº REGISTRO:" + NumeroRegistro + "\n"));
            document.add(new Paragraph("VALIDADE:" + Validade + "\n"));
            document.add(new Paragraph("1ª HABILITAÇÃO:" + PrimeiraHabilitacao + "\n"));
            document.add(new Paragraph("CAT. HAB.:" + Categoria + "\n"));

            document.close();
            System.out.println("Documento PDF gerado com sucesso!" + "\n");
        } catch (IOException e) {e.fillInStackTrace();}
    }

}
