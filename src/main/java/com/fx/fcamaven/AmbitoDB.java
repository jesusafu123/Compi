/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.fcamaven;

import static com.fx.fcamaven.Clase.clase.ARR;
import static com.fx.fcamaven.Clase.clase.CON;
import static com.fx.fcamaven.Clase.clase.DIC;
import static com.fx.fcamaven.Clase.clase.LIS;
import static com.fx.fcamaven.Clase.clase.RAN;
import static com.fx.fcamaven.Clase.clase.TUP;
import static com.fx.fcamaven.Tipo.Tipos.BIN;
import static com.fx.fcamaven.Tipo.Tipos.BOO;
import static com.fx.fcamaven.Tipo.Tipos.CAD;
import static com.fx.fcamaven.Tipo.Tipos.CHA;
import static com.fx.fcamaven.Tipo.Tipos.COM;
import static com.fx.fcamaven.Tipo.Tipos.DEC;
import static com.fx.fcamaven.Tipo.Tipos.FLO;
import static com.fx.fcamaven.Tipo.Tipos.HEX;
import static com.fx.fcamaven.Tipo.Tipos.NON;
import static com.fx.fcamaven.Tipo.Tipos.OCT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;

public class AmbitoDB {

    public static void agregarRegistro(Ambito o) {
        try {
            PreparedStatement ps = BaseDatos.getConexion().prepareStatement("insert into objeto (identificador, ambito, tipo, clase, tamanioArreglo, dimensionArreglo, posicionParametro, funcionOrigen, cantidadParametros, ambitoCreado, avance, valor, llave) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            if (o.getIdentificador() != null) {
                ps.setString(1, o.getIdentificador());
            } else {
                ps.setNull(1, Types.VARCHAR);
            }
            ps.setInt(2, o.getAmbito());
            ps.setString(3, o.getTipo().trim());
            ps.setString(4, o.getClase().trim());
            if (o.getTamanioArreglo() != null) {
                ps.setInt(5, o.getTamanioArreglo());
            } else {
                ps.setNull(5, Types.INTEGER);
            }
            if (o.getDimensionArreglo() != null) {
                ps.setInt(6, o.getDimensionArreglo());
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            if (o.getPosicionParametro() != null) {
                ps.setInt(7, o.getPosicionParametro());
            } else {
                ps.setNull(7, Types.INTEGER);
            }
            if (o.getFuncionOrigen() != null) {
                ps.setString(8, o.getFuncionOrigen());
            } else {
                ps.setNull(8, Types.VARCHAR);
            }
            if (o.getCantidadParametros() != null) {
                ps.setInt(9, o.getCantidadParametros());
            } else {
                ps.setNull(9, Types.INTEGER);
            }
            if (o.getAmbitoCreado() != null) {
                ps.setInt(10, o.getAmbitoCreado());
            } else {
                ps.setNull(10, Types.INTEGER);
            }
            if (o.getAvance() != null) {
                ps.setString(11, o.getAvance());
            } else {
                ps.setNull(11, Types.VARCHAR);
            }
            if (o.getValor() != null) {
                ps.setString(12, o.getValor());
            } else {
                ps.setNull(12, Types.VARCHAR);
            }
            if (o.getLlave() != null) {
                ps.setString(13, o.getLlave());
            } else {
                ps.setNull(13, Types.VARCHAR);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Ambito> enlistarRegistros() {
        try {
            LinkedList<Ambito> ll = new LinkedList();
            Statement s;
            s = BaseDatos.getConexion().createStatement();
            ResultSet r;
            r = s.executeQuery("SELECT * FROM objeto");
            while (r.next()) {
                Ambito aux = new Ambito(
                        r.getInt("codigo"),
                        r.getInt("ambito"),
                        r.getInt("tamanioArreglo"),
                        r.getInt("dimensionArreglo"),
                        r.getInt("posicionParametro"),
                        r.getInt("cantidadParametros"),
                        r.getInt("ambitoCreado"),
                        r.getString("identificador"),
                        r.getString("tipo"),
                        r.getString("clase"),
                        r.getString("funcionOrigen"),
                        r.getString("avance"),
                        r.getString("valor"),
                        r.getString("llave")
                );
                ll.add(aux);
            }
            return ll;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void modificarRegistro(Ambito o) {
        try {
            PreparedStatement ps;
            ps = BaseDatos.getConexion().prepareStatement("UPDATE objeto SET "
                    + "tipo=?,"
                    + "clase=?,"
                    + "tamanioArreglo=?,"
                    + "dimensionArreglo=?,"
                    + "posicionParametro=?,"
                    + "funcionOrigen=?,"
                    + "cantidadParametros=?,"
                    + "ambitoCreado=?,"
                    + "avance=?,"
                    + "llave=?,"
                    + "valor=? "
                    + "WHERE identificador = ? AND ambito = ?");
            ps.setString(1, o.getTipo());
            ps.setString(2, o.getClase());
            ps.setInt(3, o.getTamanioArreglo());
            ps.setInt(4, o.getDimensionArreglo());
            ps.setInt(5, o.getPosicionParametro());
            ps.setString(6, o.getFuncionOrigen());
            ps.setInt(7, o.getCantidadParametros());
            ps.setInt(8, o.getAmbitoCreado());
            ps.setString(9, o.getAvance());
            ps.setString(10, o.getLlave());
            ps.setString(11, o.getValor());
            ps.setString(12, o.getIdentificador());
            ps.setInt(13, o.getAmbito());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void borrarRegistro(Ambito oa) {
        try {
            PreparedStatement ps;
            ps = BaseDatos.getConexion().prepareStatement("DELETE FROM objeto WHERE identificador = ? AND ambito = ?");
            ps.setString(1, oa.getIdentificador());
            ps.setInt(2, oa.getAmbito());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Ambito findRecordById(Ambito id) {
        try {
            PreparedStatement s;
            s = BaseDatos.getConexion().prepareStatement("SELECT * FROM objeto WHERE identificador=? AND ambito=?");
            s.setString(1, id.getIdentificador());
            s.setInt(2, id.getAmbito());
            ResultSet r;
            r = s.executeQuery();
            if (r.next()) {
                Ambito aux = new Ambito(
                        r.getInt("codigo"),
                        r.getInt("ambito"),
                        r.getInt("tamanioArreglo"),
                        r.getInt("dimensionArreglo"),
                        r.getInt("posicionParametro"),
                        r.getInt("cantidadParametros"),
                        r.getInt("ambitoCreado"),
                        r.getString("identificador"),
                        r.getString("tipo"),
                        r.getString("clase"),
                        r.getString("funcionOrigen"),
                        r.getString("avance"),
                        r.getString("valor"),
                        r.getString("llave")
                );
                return aux;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LinkedList<Ambito> encontrarParametro(String funcionOrigen, int ambito) {
        LinkedList<Ambito> a = new LinkedList();
        try {
            PreparedStatement s;
            s = BaseDatos.getConexion().prepareStatement("SELECT * FROM objeto WHERE funcionOrigen=? AND ambito=?");
            s.setString(1, funcionOrigen);
            s.setInt(2, ambito);
            ResultSet r;
            r = s.executeQuery();
            while (r.next()) {
                Ambito auxiliar = new Ambito();
                auxiliar.setAmbito(ambito);
                auxiliar.setIdentificador(r.getString("identificador"));
                auxiliar.setTipo(r.getString("tipo"));
                auxiliar.setClase(r.getString("clase"));
                auxiliar.setAmbitoCreado(r.getInt("ambitoCreado"));
                auxiliar.setAvance(r.getString("avance"));
                auxiliar.setCantidadParametros(r.getInt("cantidadParametros"));
                auxiliar.setDimensionArreglo(r.getInt("dimensionArreglo"));
                auxiliar.setFuncionOrigen(funcionOrigen);
                auxiliar.setPosicionParametro(r.getInt("posicionParametro"));
                auxiliar.setTamanioArreglo(r.getInt("tamanioArreglo"));
                auxiliar.setLlave(r.getString("llave"));
                auxiliar.setValor(r.getString("valor"));
                a.add(auxiliar);
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static int contarTipo(int ambito, String tipo) {
        try {
            PreparedStatement s;
            s = BaseDatos.getConexion().prepareStatement("SELECT COUNT(*) FROM objeto WHERE ambito=? and tipo = ? and clase <> ?");
            s.setString(2, tipo);
            s.setInt(1, ambito);
            s.setString(3, ARR);
            ResultSet r;
            r = s.executeQuery();
            while (r.next()) {
                return r.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static int contarTotalTipo(String tipo) {
        try {
            PreparedStatement s;
            s = BaseDatos.getConexion().prepareStatement("SELECT COUNT(*) FROM objeto WHERE tipo = ? and clase <> ?");
            s.setString(1, tipo);
            s.setString(2, ARR);
            ResultSet r;
            r = s.executeQuery();
            while (r.next()) {
                return r.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static int contarClase(int ambito, String clase) {
        try {
            PreparedStatement s;
            s = BaseDatos.getConexion().prepareStatement("SELECT COUNT(*) FROM objeto WHERE ambito=? and clase = ?");
            s.setString(2, clase);
            s.setInt(1, ambito);
            ResultSet r;
            r = s.executeQuery();
            while (r.next()) {
                return r.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static int contarTotalClase(String clase) {
        try {
            PreparedStatement s;
            s = BaseDatos.getConexion().prepareStatement("SELECT COUNT(*) FROM objeto WHERE clase = ?");
            s.setString(1, clase);
            ResultSet r;
            r = s.executeQuery();
            while (r.next()) {
                return r.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static LinkedList<ObjetoExcel> llenarContadores(int ambitos) {
        LinkedList<ObjetoExcel> aux = new LinkedList();
        for (int i = 0; i <= ambitos; i++) {
            ObjetoExcel aux2 = new ObjetoExcel(i);
            aux2.setDecimal(contarTipo(i, DEC));
            aux2.setBinario(contarTipo(i, BIN));
            aux2.setOctal(contarTipo(i, OCT));
            aux2.setHexadecimal(contarTipo(i, HEX));
            aux2.setFlotante(contarTipo(i, FLO));
            aux2.setCadena(contarTipo(i, CAD));
            aux2.setCaracter(contarTipo(i, CHA));
            aux2.setCompleja(contarTipo(i, COM));
            aux2.setBooleana(contarTipo(i, BOO));
            aux2.setNone(contarTipo(i, NON));
            aux2.setArreglo(contarClase(i, ARR));
            aux2.setTuplas(contarClase(i, TUP));
            aux2.setLista(contarClase(i, LIS));
            aux2.setRegistro(0);
            aux2.setRango(contarClase(i, RAN));
            aux2.setConjuntos(contarClase(i, CON));
            aux2.setDiccionarios(contarClase(i, DIC));
            aux2.setTotal(
                    aux2.getDecimal() + aux2.getBinario() + aux2.getOctal() + aux2.getHexadecimal() + aux2.getFlotante() + aux2.getCadena() + aux2.getCaracter() + aux2.getCompleja() + aux2.getBooleana()
                    + aux2.getNone()
                    + aux2.getArreglo()
                    + aux2.getTuplas()
                    + aux2.getLista()
                    + aux2.getRegistro()
                    + aux2.getRango()
                    + aux2.getConjuntos()
                    + aux2.getDiccionarios()
            );
            aux.add(aux2);
        }
        ObjetoExcel aux2 = new ObjetoExcel(0);
        aux2.setDecimal(contarTotalTipo(DEC));
        aux2.setBinario(contarTotalTipo(BIN));
        aux2.setOctal(contarTotalTipo(OCT));
        aux2.setHexadecimal(contarTotalTipo(HEX));
        aux2.setFlotante(contarTotalTipo(FLO));
        aux2.setCadena(contarTotalTipo(CAD));
        aux2.setCaracter(contarTotalTipo(CHA));
        aux2.setCompleja(contarTotalTipo(COM));
        aux2.setBooleana(contarTotalTipo(BOO));
        aux2.setNone(contarTotalTipo(NON));
        aux2.setArreglo(contarTotalClase(ARR));
        aux2.setTuplas(contarTotalClase(TUP));
        aux2.setLista(contarTotalClase(LIS));
        aux2.setRegistro(0);
        aux2.setRango(contarTotalClase(RAN));
        aux2.setConjuntos(contarTotalClase(CON));
        aux2.setDiccionarios(contarTotalClase(DIC));
        aux2.setTotal(
                aux2.getDecimal() + aux2.getBinario() + aux2.getOctal() + aux2.getHexadecimal() + aux2.getFlotante() + aux2.getCadena() + aux2.getCaracter() + aux2.getCompleja() + aux2.getBooleana()
                + aux2.getNone()
                + aux2.getArreglo()
                + aux2.getTuplas()
                + aux2.getLista()
                + aux2.getRegistro()
                + aux2.getRango()
                + aux2.getConjuntos()
                + aux2.getDiccionarios()
        );
        aux.add(aux2);
        return aux;
    }

    public static void borrarTodos() {
        try {
            Statement ps;
            ps = BaseDatos.getConexion().createStatement();
            ps.execute("DELETE FROM objeto");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
