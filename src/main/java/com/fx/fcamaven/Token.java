package com.fx.fcamaven;

public class Token {
    int numeroLinea, numeroToken;
    String lexema, value = null;

    public Token(int numeroLinea, int numeroToken, String lexema) {
        this.numeroLinea = numeroLinea;
        this.numeroToken = numeroToken;
        this.lexema = lexema;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public int getNumeroToken() {
        return numeroToken;
    }

    public void setNumeroToken(int numeroToken) {
        this.numeroToken = numeroToken;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
}