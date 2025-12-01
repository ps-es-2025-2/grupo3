package model;

import java.util.Date;

public class Autenticacao {
    private String token;
    private Date dataExpiracao;
    private Long usuarioId;

    public Boolean validarCredenciais(String email, String senha) {
        return true;
    }

    public String gerarToken() {
        this.token = "token_criptografado_exemplo";
        return this.token;
    }
}