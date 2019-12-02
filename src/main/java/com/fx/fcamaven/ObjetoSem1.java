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
public class ObjetoSem1 {

    private int linea, TD, TDB, TDO, TDH, TF, TS, TCH, TC, TB, TN, TL, TR, TV;
    private String asignacion;

    public ObjetoSem1(int linea, int TD, int TDB, int TDO, int TDH, int TF, int TS, int TCH, int TC, int TB, int TN, int TL, int TR, int TV, String asignacion) {
        this.linea = linea;
        this.TD = TD;
        this.TDB = TDB;
        this.TDO = TDO;
        this.TDH = TDH;
        this.TF = TF;
        this.TS = TS;
        this.TCH = TCH;
        this.TC = TC;
        this.TB = TB;
        this.TN = TN;
        this.TL = TL;
        this.TR = TR;
        this.TV = TV;
        this.asignacion = asignacion;
    }

    public ObjetoSem1() {
        TD = 0;
        TD = 0;
        TDB = 0;
        TDO = 0;
        TDH = 0;
        TF = 0;
        TS = 0;
        TCH = 0;
        TC = 0;
        TB = 0;
        TN = 0;
        TL = 0;
        TR = 0;
        TV = 0;
        asignacion = "";
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getTD() {
        return TD;
    }

    public void setTD(int TD) {
        this.TD = TD;
    }

    public int getTDB() {
        return TDB;
    }

    public void setTDB(int TDB) {
        this.TDB = TDB;
    }

    public int getTDO() {
        return TDO;
    }

    public void setTDO(int TDO) {
        this.TDO = TDO;
    }

    public int getTDH() {
        return TDH;
    }

    public void setTDH(int TDH) {
        this.TDH = TDH;
    }

    public int getTF() {
        return TF;
    }

    public void setTF(int TF) {
        this.TF = TF;
    }

    public int getTS() {
        return TS;
    }

    public void setTS(int TS) {
        this.TS = TS;
    }

    public int getTCH() {
        return TCH;
    }

    public void setTCH(int TCH) {
        this.TCH = TCH;
    }

    public int getTC() {
        return TC;
    }

    public void setTC(int TC) {
        this.TC = TC;
    }

    public int getTB() {
        return TB;
    }

    public void setTB(int TB) {
        this.TB = TB;
    }

    public int getTN() {
        return TN;
    }

    public void setTN(int TN) {
        this.TN = TN;
    }

    public int getTL() {
        return TL;
    }

    public void setTL(int TL) {
        this.TL = TL;
    }

    public int getTR() {
        return TR;
    }

    public void setTR(int TR) {
        this.TR = TR;
    }

    public int getTV() {
        return TV;
    }

    public void setTV(int TV) {
        this.TV = TV;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

}
