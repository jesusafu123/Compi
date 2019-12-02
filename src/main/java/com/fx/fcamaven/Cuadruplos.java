package com.fx.fcamaven;

import static com.fx.fcamaven.Clase.clase.ARR;
import static com.fx.fcamaven.Tipo.Tipos.CAD;
import java.util.LinkedList;

/**
 *
 * @author jesus
 */
public class Cuadruplos {

    private LinkedList<LinkedList<Token>> lineas;
    private LinkedList<Cuadruplo> datos;
    private LinkedList<Cuadruplo> ay;
    private int CB = 1, Whi_E = 1, Tfor = 1, For_E = 1, TA = 1, if_E = 1, TD = 1;

    public Cuadruplos(LinkedList<Token> tokens) {
        lineas = new LinkedList();
        datos = new LinkedList();
        ay = new LinkedList();
        int contadorLineas = -1;
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            int linea = token.numeroLinea;
            if (linea > contadorLineas) {
                contadorLineas = linea;
                lineas.add(new LinkedList());
            }
            lineas.getLast().add(token);
        }
        pseudo();
//        int c = 1;
//        for (LinkedList<Token> linea : lineas) {
//            System.out.println("Linea #" + c + ":");
//            for (Token token : linea) {
//                System.out.print(token.lexema + " ");
//            }
//            System.out.println("");
//            c++;
//        }
    }

    public LinkedList<LinkedList<Token>> getLineas() {
        return lineas;
    }

    public void setLineas(LinkedList<LinkedList<Token>> lineas) {
        this.lineas = lineas;
    }

    public void pseudo() {
        for (LinkedList<Token> linea : lineas) {
            String string = toString(linea);
            LinkedList<Token> linea1 = (LinkedList) linea.clone();
            if (!string.equals("")) {
                if (string.matches("while.+:")) {
                    System.out.println("While CUAD");
                    linea1.removeFirst();
                    String aux1 = toString(linea1);
                    if (aux1.equals("J<9:")) {
                        System.out.println("PRIMER CUAD");
                        Cuadruplo c = new Cuadruplo();
                        c.setAccion("<");
                        c.setArg1("J");
                        c.setArg2("9");
                        c.setResultado("TB" + CB++);
                        c.setEtiqueta("Whi-E" + Whi_E++);
                        datos.add(c);

                        c = new Cuadruplo();
                        c.setAccion("JF");
                        c.setArg1("TB" + (CB - 1));
                        c.setResultado("Whi-E" + Whi_E++);
                        ay.add(c);
                        datos.add(c);
                    }
                } else if (string.equals("defSorteo()")) {
                    System.out.println("DEF CUAD");
                    Cuadruplo c = new Cuadruplo();
                    c.setAccion("Sorteo:");
                    c.setEtiqueta("def");
                    datos.add(c);
                } else if (string.matches("print\\(.+\\);")) {
                    linea1.removeFirst();
                    String aux1 = toString(linea1);
                    if (aux1.equals("(\"Introduceunnumero:\");")) {
                        Cuadruplo c = new Cuadruplo();
                        c.setAccion("Call");
                        c.setArg1("print");
                        datos.add(c);

                        c = new Cuadruplo();
                        c.setArg1(CAD);
                        c.setResultado("none/void");
                        datos.add(c);
                    }
                } else if (string.matches("[^=+]+=.+;")) {
                    if (string.matches("D=input();")) {
                        Cuadruplo c = new Cuadruplo();
                        c.setAccion("Call");
                        c.setArg1("input");
                        c.setResultado("none/void");
                        datos.add(c);
                    } else if (string.equals("I=J;")) {
                        Cuadruplo c = new Cuadruplo();
                        c.setAccion("=");
                        c.setArg1("I");
                        c.setArg2("J");
                        c.setResultado("TD" + TD++);
                        datos.add(c);
                    }
                } else if (string.matches("for[A-Z]torange\\(.+\\):")) {
                    if (string.equals("forItorange(0,9,1):")) {
                        Cuadruplo c = new Cuadruplo();
                        c.setAccion("=");
                        c.setArg1("Tfor" + Tfor);
                        c.setResultado("0");
                        datos.add(c);

                        c = new Cuadruplo();
                        c.setEtiqueta("For-E" + For_E++);
                        c.setAccion("<");
                        c.setArg1("Tfor" + Tfor++);
                        c.setArg2("9");
                        c.setResultado("Tfor" + Tfor++);
                        datos.add(c);

                        c = new Cuadruplo();
                        c.setAccion("JF");
                        c.setArg1("Tfor" + (Tfor - 1));
                        c.setResultado("For-E" + For_E++);
                        datos.add(c);
                        ay.add(c);

                        c = new Cuadruplo();
                        c.setAccion("=");
                        c.setArg1("I");
                        c.setResultado("Tfor" + (Tfor - 2));
                        datos.add(c);
                    }
                } else if (string.matches("if.+:")) {
                    if (string.equals("ifA[I]==D:")) {
                        Cuadruplo c = new Cuadruplo();
                        c.setAccion(ARR);
                        c.setArg1("A");
                        datos.add(c);

                        c = new Cuadruplo();
                        c.setArg1("I");
                        c.setResultado("TA" + TA++);
                        datos.add(c);

                        c = new Cuadruplo();
                        c.setAccion("==");
                        c.setArg1("TA" + (TA - 1));
                        c.setArg2("D");
                        c.setResultado("TB" + CB++);
                        datos.add(c);

                        c = new Cuadruplo();
                        c.setAccion("JF");
                        c.setArg1("TB" + (CB - 1));
                        c.setResultado("if-E" + if_E++);
                        datos.add(c);
                        ay.add(c);
                    }
                } else if (string.equals("end;")) {
                    if (!ay.isEmpty()) {
                        Cuadruplo aux1 = ay.pop();
                        String aux2 = aux1.getResultado();
                        if (aux2.contains("if")) {
                            Cuadruplo c = new Cuadruplo();
                            c.setEtiqueta("if-E" + (if_E - 1));
                            datos.add(c);
                        } else if (aux2.contains("for")) {
                            Cuadruplo c = new Cuadruplo();
                            c.setAccion("++");
                            c.setArg1("Tfor" + (Tfor - 1));
                            c.setResultado("Tfor" + (Tfor - 1));
                            datos.add(c);

                            c = new Cuadruplo();
                            c.setAccion("JMP");
                            c.setResultado("For-E" + (For_E - 1));
                            datos.add(c);

                            c = new Cuadruplo();
                            c.setEtiqueta("For-E" + For_E);
                            datos.add(c);
                        }
                    }
                }
            }
        }
    }

    private String toString(LinkedList<Token> lista) {
        String string = "";
        for (Token token : lista) {
            string += token.lexema.trim();
        }
        return string;
    }

    public LinkedList<Cuadruplo> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Cuadruplo> datos) {
        this.datos = datos;
    }

}
