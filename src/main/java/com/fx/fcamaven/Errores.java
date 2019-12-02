package com.fx.fcamaven;

import javafx.beans.property.SimpleStringProperty;

public class Errores {
    SimpleStringProperty linea, descripcion, numero, tipo, lexema;
    public Errores(String linea, String descripcion, String numero, String tipo, String lexema) {
        this.linea = new SimpleStringProperty(linea);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.numero = new SimpleStringProperty(numero);
        this.tipo = new SimpleStringProperty(tipo);
        this.lexema = new SimpleStringProperty(lexema);
    }
    
    public String getLinea() {
        return linea.get();
    }
    public String getDescripcion() {
        return descripcion.get();
    }
    public String getNumero() {
        return numero.get();
    }
    public String getTipo() {
        return tipo.get();
    }
    public String getLexema() {
        return lexema.get();
    }
    
    public void setLinea(String s) {
        linea.set(s);
    }
    
    public void setNumero(String s) {
        numero.set(s);
    }
    
    public void setTipo(String s) {
        tipo.set(s);
    }
    
    public void setLexema(String s) {
        lexema.set(s);
    }
    
    public void setDescripcion(String s) {
        descripcion.set(s);
    }
}
