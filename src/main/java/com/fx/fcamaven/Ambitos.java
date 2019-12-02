package com.fx.fcamaven;

import javafx.beans.property.SimpleStringProperty;

public class Ambitos {

    SimpleStringProperty identificador, ambito, tipo, clase, tamanioArreglo, dimensionArreglo, posicionParametro, funcionOrigen, cantidadParametros, ambitoCreado, avance, llave;

    public Ambitos(String identificador, String ambito, String tipo, String clase, String tamanioArreglo, String dimensionArreglo, String posicionParametro, String funcionOrigen, String cantidadParametros, String ambitoCreado, String avance, String llave) {
        this.identificador = new SimpleStringProperty(identificador);
        this.ambito = new SimpleStringProperty(ambito);
        this.tipo = new SimpleStringProperty(tipo);
        this.clase = new SimpleStringProperty(clase);
        this.tamanioArreglo = new SimpleStringProperty(tamanioArreglo);
        this.dimensionArreglo = new SimpleStringProperty(dimensionArreglo);
        this.posicionParametro = new SimpleStringProperty(posicionParametro);
        this.funcionOrigen = new SimpleStringProperty(funcionOrigen);
        this.cantidadParametros = new SimpleStringProperty(cantidadParametros);
        this.ambitoCreado = new SimpleStringProperty(ambitoCreado);
        this.avance = new SimpleStringProperty(avance);
        this.llave = new SimpleStringProperty(llave);
    }

    public String getIdentificador() {
        return identificador.get();
    }

    public String getAmbito() {
        return ambito.get();
    }

    public String getTipo() {
        return tipo.get();
    }

    public String getClase() {
        return clase.get();
    }

    public String getTamanioArreglo() {
        return tamanioArreglo.get();
    }

    public String getDimensionArreglo() {
        return dimensionArreglo.get();
    }

    public String getPosicionParametro() {
        return posicionParametro.get();
    }

    public String getFuncionOrigen() {
        return funcionOrigen.get();
    }

    public String getCantidadParametros() {
        return cantidadParametros.get();
    }

    public String getAmbitoCreado() {
        return ambitoCreado.get();
    }

    public String getAvance() {
        return avance.get();
    }

    public String getLlave() {
        return llave.get();
    }

    public void setIdentificador(String s) {
        identificador.set(s);
    }

    public void setAmbito(String s) {
        ambito.set(s);
    }

    public void setTipo(String s) {
        tipo.set(s);
    }

    public void setClase(String s) {
        clase.set(s);
    }

    public void setTamanioArreglo(String s) {
        tamanioArreglo.set(s);
    }

    public void setDimensionArreglo(String s) {
        dimensionArreglo.set(s);
    }

    public void setPosicionParametro(String s) {
        posicionParametro.set(s);
    }

    public void setFuncionOrigen(String s) {
        funcionOrigen.set(s);
    }

    public void setCantidadParametros(String s) {
        cantidadParametros.set(s);
    }

    public void setAmbitoCreado(String s) {
        ambitoCreado.set(s);
    }

    public void setAvance(String s) {
        avance.set(s);
    }

    public void setLlave(String s) {
        llave.set(s);
    }
}
