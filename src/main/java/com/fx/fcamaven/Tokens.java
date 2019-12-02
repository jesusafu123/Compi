/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.fcamaven;

import javafx.beans.property.SimpleStringProperty;

public class Tokens {
   private final SimpleStringProperty numero;
   private final SimpleStringProperty lexema;
   private final SimpleStringProperty linea;

    public Tokens(String numero, String lexema, String linea) {
        this.numero = new SimpleStringProperty(numero);
        this.lexema = new SimpleStringProperty(lexema);
        this.linea = new SimpleStringProperty(linea);
    }

    public String getNumero() {
        return numero.get();
    }

    public String getLexema() {
        return lexema.get();
    }

    public String getLinea() {
        return linea.get();
    }
   
    public void setNumero(String string) {
        numero.set(string);
    }
    public void setLexema(String string) {
        lexema.set(string);
    }
    public void setLinea(String string) {
        linea.set(string);
    }
   
}
