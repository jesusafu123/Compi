package com.fx.fcamaven;

/**
 *
 * @author jesus
 */
public class ObjetoSem2 {

    private int linea, ambito, id;
    private String regla, topeDePila, valorReal, estado;

    public ObjetoSem2(String regla, int linea, int ambito, String topeDePila, String valorReal, String estado) {
        this.regla = regla;
        this.linea = linea;
        this.ambito = ambito;
        this.topeDePila = topeDePila;
        this.valorReal = valorReal;
        this.estado = estado;
    }

    public ObjetoSem2(int id) {
        this.id = id;
    }

    public String getRegla() {
        return regla;
    }

    public void setRegla(String regla) {
        this.regla = regla;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getAmbito() {
        return ambito;
    }

    public void setAmbito(int ambito) {
        this.ambito = ambito;
    }

    public String getTopeDePila() {
        return topeDePila;
    }

    public void setTopeDePila(String topeDePila) {
        this.topeDePila = topeDePila;
    }

    public String getValorReal() {
        return valorReal;
    }

    public void setValorReal(String valorReal) {
        this.valorReal = valorReal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
