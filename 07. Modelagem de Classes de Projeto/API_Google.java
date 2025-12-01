package model;

import java.util.Map;

public class API_Google {
    private String clientId;
    private String clientSecret;

    public Boolean autenticarGoogle() {
        return true; 
    }

    public String gerarLinkMeet() {
        return "https://meet.google.com/abc-defg-hij"; 
    }
    
    public Map<String, String> obterDadosUsuario() {
        return null;
    }
}