package com.fx.fcamaven;

public class Ambito implements java.io.Serializable {

    private Integer codigo, ambito, tamanioArreglo, dimensionArreglo, posicionParametro, cantidadParametros, ambitoCreado;
    private String identificador, tipo, clase, funcionOrigen, avance, valor, llave;

    public Ambito(Integer codigo, Integer ambito, Integer tamanioArreglo, Integer dimensionArreglo, Integer posicionParametro, Integer cantidadParametros, Integer ambitoCreado, String identificador, String tipo, String clase, String funcionOrigen, String avance, String valor, String llave) {
        this.codigo = codigo;
        this.ambito = ambito;
        this.tamanioArreglo = tamanioArreglo;
        this.dimensionArreglo = dimensionArreglo;
        this.posicionParametro = posicionParametro;
        this.cantidadParametros = cantidadParametros;
        this.ambitoCreado = ambitoCreado;
        this.identificador = identificador;
        this.tipo = tipo;
        this.clase = clase;
        this.funcionOrigen = funcionOrigen;
        this.avance = avance;
        this.valor = valor;
        this.llave = llave;
    }

    public Ambito() {
    }
    
    public Ambito(String identificador, Integer ambito) {
        this.identificador = identificador;
        this.ambito = ambito;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAmbito() {
        return ambito;
    }

    public void setAmbito(Integer ambito) {
        this.ambito = ambito;
    }

    public Integer getTamanioArreglo() {
        return tamanioArreglo;
    }

    public void setTamanioArreglo(Integer tamanioArreglo) {
        this.tamanioArreglo = tamanioArreglo;
    }

    public Integer getDimensionArreglo() {
        return dimensionArreglo;
    }

    public void setDimensionArreglo(Integer dimensionArreglo) {
        this.dimensionArreglo = dimensionArreglo;
    }

    public Integer getPosicionParametro() {
        return posicionParametro;
    }

    public void setPosicionParametro(Integer posicionParametro) {
        this.posicionParametro = posicionParametro;
    }

    public Integer getCantidadParametros() {
        return cantidadParametros;
    }

    public void setCantidadParametros(Integer cantidadParametros) {
        this.cantidadParametros = cantidadParametros;
    }

    public Integer getAmbitoCreado() {
        return ambitoCreado;
    }

    public void setAmbitoCreado(Integer ambitoCreado) {
        this.ambitoCreado = ambitoCreado;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getFuncionOrigen() {
        return funcionOrigen;
    }

    public void setFuncionOrigen(String funcionOrigen) {
        this.funcionOrigen = funcionOrigen;
    }

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

}
