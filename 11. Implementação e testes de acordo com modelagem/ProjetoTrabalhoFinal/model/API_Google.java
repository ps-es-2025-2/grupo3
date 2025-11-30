package model;

import java.util.Map;

public class API_Google {
    private String clientId;
    private String clientSecret;

    public Boolean autenticarGoogle() {
        return true; // Simulação
    }

    public String gerarLinkMeet() {
        return "https://meet.google.com/abc-defg-hij"; // Link simulado
    }
    
    public Map<String, String> obterDadosUsuario() {
        return null;
    }
}