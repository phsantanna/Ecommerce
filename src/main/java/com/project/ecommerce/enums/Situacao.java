package com.project.ecommerce.enums;

public enum Situacao {
    ANALISANDO("analisando"),
    APROVADO("aprovado");
    private final String situacao;

    Situacao(String situacao) {
        this.situacao = situacao;
    }
    public String getSituacao() {
        return situacao;
    }
}
