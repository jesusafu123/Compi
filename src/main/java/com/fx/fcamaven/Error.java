package com.fx.fcamaven;

public class Error {
    int numeroLinea, numeroError;
    String lexema, tipo;

    public Error(int numeroLinea, int numeroError, String lexema, String tipo) {
        this.numeroLinea = numeroLinea;
        this.numeroError = numeroError;
        this.lexema = lexema;
        this.tipo = tipo;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public int getNumeroError() {
        return numeroError;
    }

    public void setNumeroError(int numeroError) {
        this.numeroError = numeroError;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
