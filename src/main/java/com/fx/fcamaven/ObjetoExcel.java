/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.fcamaven;

/**
 *
 * @author jesus
 */
public class ObjetoExcel {

    private int ambito, decimal, binario, octal, hexadecimal, flotante, cadena, caracter, compleja, booleana, none, arreglo, tuplas, lista, registro, rango, conjuntos, diccionarios, total;

    public ObjetoExcel(int ambito) {
        this.ambito = ambito;
        decimal = 0;
        binario = 0;
        octal = 0;
        hexadecimal = 0;
        flotante = 0;
        cadena = 0;
        caracter = 0;
        compleja = 0;
        booleana = 0;
        none = 0;
        arreglo = 0;
        tuplas = 0;
        lista = 0;
        registro = 0;
        rango = 0;
        conjuntos = 0;
        diccionarios = 0;
        total = 0;
    }
    
    public ObjetoExcel(ObjetoExcel ae) {
        ambito = ae.getAmbito();
        decimal = ae.getDecimal();
        binario = ae.getBinario();
        octal = ae.getOctal();
        hexadecimal = ae.getHexadecimal();
        flotante = ae.getFlotante();
        cadena = ae.getCadena();
        caracter = ae.getCaracter();
        compleja = ae.getCompleja();
        booleana = ae.getBooleana();
        none = ae.getNone();
        arreglo = ae.getArreglo();
        tuplas = ae.getTuplas();
        lista = ae.getLista();
        registro = ae.getRegistro();
        rango = ae.getRango();
        conjuntos = ae.getConjuntos();
        diccionarios = ae.getDiccionarios();
        total = ae.getTotal();
    }

    public int getAmbito() {
        return ambito;
    }

    public void setAmbito(int ambito) {
        this.ambito = ambito;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public int getBinario() {
        return binario;
    }

    public void setBinario(int binario) {
        this.binario = binario;
    }

    public int getOctal() {
        return octal;
    }

    public void setOctal(int octal) {
        this.octal = octal;
    }

    public int getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(int hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public int getFlotante() {
        return flotante;
    }

    public void setFlotante(int flotante) {
        this.flotante = flotante;
    }

    public int getCadena() {
        return cadena;
    }

    public void setCadena(int cadena) {
        this.cadena = cadena;
    }

    public int getCaracter() {
        return caracter;
    }

    public void setCaracter(int caracter) {
        this.caracter = caracter;
    }

    public int getCompleja() {
        return compleja;
    }

    public void setCompleja(int compleja) {
        this.compleja = compleja;
    }

    public int getBooleana() {
        return booleana;
    }

    public void setBooleana(int booleana) {
        this.booleana = booleana;
    }

    public int getNone() {
        return none;
    }

    public void setNone(int none) {
        this.none = none;
    }

    public int getArreglo() {
        return arreglo;
    }

    public void setArreglo(int arreglo) {
        this.arreglo = arreglo;
    }

    public int getTuplas() {
        return tuplas;
    }

    public void setTuplas(int tuplas) {
        this.tuplas = tuplas;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public int getConjuntos() {
        return conjuntos;
    }

    public void setConjuntos(int conjuntos) {
        this.conjuntos = conjuntos;
    }

    public int getDiccionarios() {
        return diccionarios;
    }

    public void setDiccionarios(int diccionarios) {
        this.diccionarios = diccionarios;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public void setTotal() {
        total = decimal + binario + octal + hexadecimal + flotante + cadena + caracter + compleja + booleana + none + arreglo + tuplas + lista + registro + rango + conjuntos + diccionarios;
    }

}
