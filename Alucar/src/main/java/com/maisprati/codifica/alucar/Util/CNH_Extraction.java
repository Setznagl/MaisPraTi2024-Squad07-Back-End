package com.maisprati.codifica.alucar.Util;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CNH_Extraction implements PDFUtils {

    public static Map<String , String> extractValuesFromPDF(byte[] pdfbytes) throws IOException {
        Path tempFile = PDFUtils.convertBytesToFile(pdfbytes);
        try (PDDocument document = Loader.loadPDF(Files.newInputStream(tempFile).readAllBytes())) {
            PDFTextStripper pdfstripper = new PDFTextStripper();
            String text = pdfstripper.getText(document);

            // Extraindo campos específicos
            String[] lines = text.split("\\r?\\n");
            Map<String , String> extractedFields = new HashMap<>();

            for (String line : lines){
                if (line.contains("NOME:")) extractedFields.put("Nome", PDFUtils.extractField(line, "NOME:"));
                if (line.contains("DOC. IDENTIDADE:")) extractedFields.put("Doc. Identidade", PDFUtils.extractField(line, "DOC. IDENTIDADE:"));
                if (line.contains("ORG. EMISSOR:")) extractedFields.put("Orgao Emissor", PDFUtils.extractField(line, "ORG. EMISSOR:"));
                if (line.contains("UF")) extractedFields.put("Unidade Federativa" , PDFUtils.extractField(line, "UF"));
                if (line.contains("CPF:")) extractedFields.put("CPF", PDFUtils.extractField(line, "CPF:"));
                if (line.contains("DATA NASCIMENTO:")) extractedFields.put("Data de Nascimento", PDFUtils.extractField(line, "DATA NASCIMENTO:"));
                if (line.contains("FILIAÇÃO NOME DO PAI:")) extractedFields.put("Filiação pai", PDFUtils.extractField(line, "FILIAÇÃO NOME DO PAI:"));
                if (line.contains("FILIAÇÃO NOME DA MAE:")) extractedFields.put("Filiação mae", PDFUtils.extractField(line, "FILIAÇÃO NOME DA MAE:"));
                if (line.contains("Nº REGISTRO:")) extractedFields.put("Número de Registro", PDFUtils.extractField(line, "Nº REGISTRO:"));
                if (line.contains("VALIDADE:")) extractedFields.put("Validade", PDFUtils.extractField(line, "VALIDADE:"));
                if (line.contains("1ª HABILITAÇÃO:")) extractedFields.put("Primeira Habilitação", PDFUtils.extractField(line, "1ª HABILITAÇÃO:"));
                if (line.contains("CAT. HAB.:")) extractedFields.put("Categoria de Habilitação", PDFUtils.extractField(line, "CAT. HAB.:")); }

            return extractedFields;
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }
}
