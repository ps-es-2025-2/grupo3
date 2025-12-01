package model;

import java.util.Map;

public class GeradorPDF {
    private String template;
    private String outputPath;

    public String gerarPDF(Map<String, Object> dados) {
        return "Arquivo gerado com sucesso";
    }

    public Boolean gerarPDFLaudo(Laudo laudo) {
        System.out.println("Gerando PDF do laudo ID: " + laudo.getConteudo());
        return true;
    }
}