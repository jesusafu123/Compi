package com.fx.fcamaven;

import static com.fx.fcamaven.Arrobas.arrobas.AMBITO_CIERRE_AMBITO;
import static com.fx.fcamaven.Arrobas.arrobas.AMBITO_DECLARACION_FUNCION_1;
import static com.fx.fcamaven.Arrobas.arrobas.AMBITO_DECLARACION_FUNCION_2;
import static com.fx.fcamaven.Arrobas.arrobas.AMBITO_DECLARACION_VARIABLE_1;
import static com.fx.fcamaven.Arrobas.arrobas.AMBITO_DECLARACION_VARIABLE_2;
import static com.fx.fcamaven.Arrobas.arrobas.AMBITO_ZONA_DECLARACION;
import static com.fx.fcamaven.Arrobas.arrobas.AMBITO_ZONA_EJECUCION;
import static com.fx.fcamaven.Arrobas.arrobas.CUAD_PRINT_1;
import static com.fx.fcamaven.Arrobas.arrobas.CUAD_PRINT_2;
import static com.fx.fcamaven.Arrobas.arrobas.SEM1_ASIGNACION_1;
import static com.fx.fcamaven.Arrobas.arrobas.SEM1_ASIGNACION_2;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_1010_1;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_1010_2;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_A;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_E;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_FOR_1;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_FOR_2;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_RAN_1;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_RAN_2;
import static com.fx.fcamaven.Arrobas.arrobas.SEM2_RET;
import static com.fx.fcamaven.Arrobas.arrobas.SEM3_1;
import static com.fx.fcamaven.Arrobas.arrobas.SEM3_2;
import static com.fx.fcamaven.Clase.clase.ARR;
import static com.fx.fcamaven.Clase.clase.ARRD;
import static com.fx.fcamaven.Clase.clase.CON;
import static com.fx.fcamaven.Clase.clase.COND;
import static com.fx.fcamaven.Clase.clase.DIC;
import static com.fx.fcamaven.Clase.clase.DICD;
import static com.fx.fcamaven.Clase.clase.FUN;
import static com.fx.fcamaven.Clase.clase.LIS;
import static com.fx.fcamaven.Clase.clase.LISD;
import static com.fx.fcamaven.Clase.clase.PAR;
import static com.fx.fcamaven.Clase.clase.RAN;
import static com.fx.fcamaven.Clase.clase.RAND;
import static com.fx.fcamaven.Clase.clase.TUP;
import static com.fx.fcamaven.Clase.clase.TUPD;
import static com.fx.fcamaven.Clase.clase.VAR;
import static com.fx.fcamaven.ErroresC.ErroresSemantica1.ES_1;
import static com.fx.fcamaven.ErroresC.ErroresSemantica1.ES_2;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_10;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_13;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_3;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_4;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_5;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_6;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_7;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_8;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_9;
import static com.fx.fcamaven.ErroresC.ErroresSemantica3.ES_14;
import static com.fx.fcamaven.ErroresC.ErroresSemantica3.ES_15;
import static com.fx.fcamaven.ErroresC.ErroresSemantica3.ES_16;
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
import static com.fx.fcamaven.Tipo.Tipos.STR;
import static com.fx.fcamaven.Tipo.Tipos.VAR_1;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sintaxis {

    //<editor-fold desc="Declaraciones sintaxis">
    LinkedList<Token> lt;
    LinkedList<Error> le;
    Integer ultimo = 814;
    int[][] lp = {
        /*1*/{AMBITO_CIERRE_AMBITO, -41, AMBITO_ZONA_DECLARACION, 203, 246, AMBITO_ZONA_EJECUCION, -40, 202}, // PROGRAM::= } @ A2 ESTATUTOS @ { A
        /*2*/ {202, SEM2_RET, -34, 201, AMBITO_DECLARACION_FUNCION_2, -37, 204, -36, -1, -68, AMBITO_DECLARACION_FUNCION_1}, // A::= A @ ; PROGRAM @ ) B ( identificador def @
        /*3*/ {202, -34, AMBITO_DECLARACION_VARIABLE_2, 206, -42, -1, AMBITO_DECLARACION_VARIABLE_1}, // A::= A ; @ CONSTANTE = identificador @ 
        /*4*/ {203, 246, -34}, // A2::= A2 ESTATUTOS ;
        /*5*/ {205, -1}, // B::= C identificador
        /*6*/ {205, -1, -35}, // C::= C identificador ,
        /*7*/ {-8}, // CONSTANTE::= float
        /*8*/ {-7}, // CONSTANTE::= texto
        /*9*/ {-10}, // CONSTANTE::= caracter
        /*10*/ {207}, // CONSTANTE::= CONSTENTERO
        /*11*/ {-9}, // CONSTANTE::= complejo
        /*12*/ {-66}, // CONSTANTE::= true
        /*13*/ {-67}, // CONSTANTE::= false
        /*14*/ {208}, // CONSTANTE::= LISTTUPRANGOS
        /*15*/ {-65}, // CONSTANTE::= none
        /*16*/ {-3}, // CONSTENTERO::= decimal
        /*17*/ {-4}, // CONSTENTERO::= binario
        /*18*/ {-5}, // CONSTENTERO::= hexadecimal
        /*19*/ {-6}, // CONSTENTERO::= octal
        /*20*/ {-37, 209, 212, -36}, // LISTUPRANGOS::= ) D OR (
        /*21*/ {214}, // LISTUPRANGOS::= ARR
        /*22*/ {-37, SEM2_RAN_2, 207, 215, -35, 207, 215, -35, 207, 215, SEM2_RAN_1, -36, -69}, // LISTUPRANGOS::= ) @ CONSTENTERO H , CONSTENTERO H , CONSTENTERO H @ ( range
        /*23*/ {-41, 211, 210, 206, -40}, // LISTUPRANGOS::= } F E CONSTANTE {
        /*24*/ {209, 212, -35}, // D::= D OR ,
        /*25*/ {211, 206, -51}, // E::= F CONSTANTE :
        /*26*/ {211, 210, 206, -35}, // F::= F E CONSTANTE ,
        /*27*/ {213, 218}, // OR::= G AND
        /*28*/ {213, 218, -22}, // G::= G AND ||
        /*29*/ {-39, 216, 212, 215, -38}, // ARR::= ] H2 OR H [ 
        /*30*/ {-12}, // H::= -
        /*31*/ {217, 212, 215, -51}, // H2::= I OR H :
        /*32*/ {212, 215, -51}, // I::= OR H :
        /*33*/ {219, 220}, // AND::= J NOT
        /*34*/ {219, 220, -21}, // J::= J NOT &&
        /*35*/ {219, 220, -2}, // J::= J NOT ##
        /*36*/ {221, 222}, // NOT::= K EXPPAS
        /*37*/ {221, 222, -20}, // K::= K EXPPAS !
        /*38*/ {223, 224}, // EXPPASCAL::= L ORLOG
        /*39*/ {223, 224, -23}, // L::= L ORLOG <
        /*40*/ {223, 224, -24}, // L::= L ORLOG <=
        /*41*/ {223, 224, -27}, // L::= L ORLOG ==
        /*42*/ {223, 224, -28}, // L::= L ORLOG !=
        /*43*/ {223, 224, -26}, // L::= L ORLOG >=
        /*44*/ {223, 224, -25}, // L::= L ORLOG >
        /*45*/ {223, 224, -52}, // L::= L ORLOG is
        /*46*/ {223, 224, -53}, // L::= L ORLOG isnot
        /*47*/ {223, 224, -60}, // L::= L ORLOG in
        /*48*/ {223, 224, -64}, // L::= L ORLOG innot
        /*49*/ {225, 226}, // ORLOG::= M XORLOG
        /*50*/ {225, 226, -30}, // M::= M XORLOG |
        /*51*/ {227, 228}, // XORLOG::= N ANDLOG 
        /*52*/ {227, 228, -31}, // N::= N ANDLOG ^
        /*53*/ {229, 230}, // ANDLOG::= O OPBIT
        /*54*/ {229, 230, -29}, // O::= O OPBIT &
        /*55*/ {231, 232}, // OPBIT::= P SIMPLEEXPPASCAL
        /*56*/ {231, 232, -32}, // P::= P SIMPLEEXPPASCAL <<
        /*57*/ {231, 232, -33}, // P::= P SIMPLEEXPPASCAL >>
        /*58*/ {233, 234}, // SIMPLEEXPPASCAL::= Q TERMINOPASCAL 
        /*59*/ {233, 234, -12}, // Q::= Q TERMINOPASCAL -
        /*60*/ {233, 234, -11}, // Q::= Q TERMINOPASCAL +
        /*61*/ {235, 236}, // TERMINOPASCAL::= R ELEVACION
        /*62*/ {235, 236, -13}, // R::= R ELEVACION *
        /*63*/ {235, 236, -15}, // R::= R ELEVACION /
        /*64*/ {235, 236, -16}, // R::= R ELEVACION //
        /*65*/ {235, 236, -17}, // R::= R ELEVACION %
        /*66*/ {237, 238}, // ELEVACION::= S FACTOR
        /*67*/ {237, 238, -14}, // S::= S FACTOR **
        /*68*/ {206}, // FACTOR::= CONSTANTE
        /*69*/ {SEM1_ASIGNACION_2, 239, -1, SEM1_ASIGNACION_1}, // FACTOR::= @ T identificador @
        /*70*/ {SEM1_ASIGNACION_2, 239, -1, SEM1_ASIGNACION_1, -18}, // FACTOR::= @ T identificador @ ++
        /*71*/ {SEM1_ASIGNACION_2, 239, -1, SEM1_ASIGNACION_1, -19}, // FACTOR::= @ T identificador @ --
        /*72*/ {SEM3_2, 245, SEM3_1}, // FACTOR::=@ FUNCIONES @
        /*73*/ {240, 214}, // T::= U @ ARR @
        /*74*/ {241, 243}, // T::= V ASIGN 
        /*75*/ {251}, // T::= SEM2
        /*76*/ {-37, 209, 212, -36}, // T::= ( OR D ) 
        /*77*/ {SEM3_2, 244, SEM3_1, -50}, // T::= @ FUNLIST @ .
        /*78*/ {241, 243, 817}, // U::= V ASIGN 
        /*79*/ {212}, // V::= @ OR 
        /*80*/ {-37, 242, -36, -70}, // V::= ) W ( input
        /*81*/ {-7}, // W::= texto
        /*82*/ {-42}, // ASIGN::= =
        /*83*/ {-43}, // ASIGN::= +=
        /*84*/ {-47}, // ASIGN::= /=
        /*85*/ {-45}, // ASIGN::= *=
        /*86*/ {-44}, // ASIGN::= -=
        /*87*/ {-48}, // ASIGN::= //=
        /*88*/ {-46}, // ASIGN::= **=
        /*89*/ {-49}, // ASIGN::= %=
        /*90*/ {-37, -36, -82}, // FUNLIST::= ) ( sort
        /*91*/ {-37, -36, -83}, // FUNLIST::= ) ( reverse
        /*92*/ {-37, 212, -36, -84}, // FUNLIST::= ) OR ( count
        /*93*/ {-37, 212, -36, -85}, // FUNLIST::= ) OR ( index
        /*94*/ {-37, 212, -36, -86}, // FUNLIST::= ) OR ( append
        /*95*/ {-37, 212, -36, -87}, // FUNLIST::= ) OR ( extend
        /*96*/ {-37, 212, -36, -88}, // FUNLIST::= ) OR ( pop
        /*97*/ {-37, 212, -36, -89}, // FUNLIST::= ) OR ( remove
        /*98*/ {-37, 212, -35, 212, -36, -90}, // FUNLIST::= ) OR , OR ( insert
        /*99*/ {-37, 212, -35, 212, -36, -71}, // FUNCIONES::= ) OR , OR ( findall
        /*100*/ {-37, 212, -35, 212, -35, 212, -36, -72}, // FUNCIONES::= ) OR,  OR , OR ( replace
        /*101*/ {-37, 212, -36, -73}, // FUNCIONES::= ) OR ( len
        /*102*/ {-37, 212, -35, 212, -36, -74}, // FUNCIONES::= ) OR , OR ( sample
        /*103*/ {-37, 212, -36, -75}, // FUNCIONES::= ) OR ( choice
        /*104*/ {-37, -36, -76}, // FUNCIONES::= ) ( random
        /*105*/ {-37, 212, -35, 212, -36, -77}, // FUNCIONES::= ) OR , OR ( randrange
        /*106*/ {-37, 212, -36, -78}, // FUNCIONES::= ) OR ( mean
        /*107*/ {-37, 212, -36, -79}, // FUNCIONES::= ) OR ( median
        /*108*/ {-37, 212, -36, -80}, // FUNCIONES::= ) OR ( variance
        /*109*/ {-37, 212, -36, -81}, // FUNCIONES::= ) OR ( sum
        /*110*/ {CUAD_PRINT_2, -37, 247, 212, -36, -61, CUAD_PRINT_1}, // ESTATUTOS::= @ ) X OR ( print @
        /*111*/ {-37, 248, -36, -91}, // ESTATUTOS::= ) Y ( println
        /*112*/ {-93, 250, 249, 246, -51, SEM2_1010_2, 212, -59, SEM2_1010_1}, // ESTATUTOS::= end Z2 Z ESTATUTOS : @ OR if @
        /*113*/ {-93, 249, 246, -51, SEM2_FOR_2, 212, -95, 212, -58, SEM2_FOR_1}, // ESTATUTOS::= end Z ESTATUTOS : @ OR for @
        /*114*/ {-92, 249, 246, -51, SEM2_1010_2, 212, -63, SEM2_1010_1}, // ESTATUTOS::= wend Z ESTATUTOS : @ OR while @ 
        /*115*/ {-54}, // ESTATUTOS::= break
        /*116*/ {-55}, // ESTATUTOS::= continue
        /*117*/ {212, -62}, // ESTATUTOS::= OR return
        /*118*/ {212}, // ESTATUTOS::= OR
        /*119*/ {247, 212, -35}, // X::= X OR ,
        /*120*/ {247, 212}, // Y::= X OR
        /*121*/ {249, 246, -34}, // Z::= Z ESTATUTOS ;
        /*122*/ {250, 249, 246, -51, SEM2_1010_2, 212, -56, SEM2_1010_1}, // Z2::= Z2 Z ESTATUTOS : @ OR elif @
        /*123*/ {249, 246, -57}, // Z2::= Z ESTATUTOS else
        /*124*/ {-18}, // T::= ++
        /*125*/ {-19}, // T::= --
        /*126*/ {},//epsilon
    };
    int[][] matriz;
    Stack<Integer> ps = new Stack();
//</editor-fold>
    //<editor-fold desc="Declaraciones ambito">
    Integer contadorAmb;
    int contadorEjecucionAsignacion = 0;
    boolean definicionVariable = false, zona = true, definicionFuncion = false, ejecucionAsignacion = false;
    public LinkedList<ObjetoExcel> AmbitoExcel;
    private LinkedList<String> definicionesVariablesC = new LinkedList();
    private LinkedList<String> definicionesFuncionesC = new LinkedList();
    private LinkedList<String> ejecucionAsignacionC = new LinkedList();
    private LinkedList<LinkedList<Token>> definicionesVariablesT = new LinkedList();
    private LinkedList<LinkedList<Token>> definicionesFuncionesT = new LinkedList();
    private LinkedList<LinkedList<Token>> ejecucionAsignacionT = new LinkedList();

    //</editor-fold>
    //<editor-fold desc="declaraciones sem1">
    private String[][][] matrizSem1;
    private Stack<Token> operadores = new Stack();
    private Stack<Token> operandos = new Stack();
    Stack<Integer> pila = new Stack();
    Integer contadorVariante = 0;
    public LinkedList<ObjetoSem1> objetoSem1s;
    //</editor-fold>
    //<editor-fold desc="Declaraciones sem2">
    LinkedList<String> R1010C = new LinkedList();
    LinkedList<LinkedList<Token>> R1010T = new LinkedList();
    LinkedList<ObjetoSem2> objetoSem2s = new LinkedList();
    ObjetoSem2 os2;
    boolean R1010 = false;
    int contadorSem2 = 0;
    //</editor-fold>
    //<editor-fold desc="Declaraciones sem3">
    LinkedList<String> semantica3C = new LinkedList();
    LinkedList<LinkedList<Token>> semantica3T = new LinkedList();
    boolean semantica3 = false;
    int contadorSem3 = 0;
    String forsC = "";
    LinkedList<Token> forsT = new LinkedList();
    boolean fors = false;
    String ransC;
    LinkedList<Token> ransT;
    boolean rans = false;
    int contadorFun = 1;
    //</editor-fold>
    //<editor-fold desc="Declaraciones cuádruplos">
    LinkedList<Cuadruplo> llCuadruplos = new LinkedList();
    LinkedList<Token> cuadPrintT = new LinkedList();
    String cuadPrintC = "";
    boolean cuadPrint = false;
    int contadorWhile = 1, contadorTB = 1;
    LinkedList<ContadoresCuadruplos> cc = new LinkedList();
    //</editor-fold>

    public void rellenarPs(int pos) {
        if (pos == 1) {
            ps.push(-94);
        }
        for (int i = 0; i < lp[pos - 1].length; i++) {
            ps.push(lp[pos - 1][i]);
        }
    }

    public Sintaxis(LinkedList<Token> lt, LinkedList<Error> le, String[][][] matrizSem1) {
        cc.add(new ContadoresCuadruplos(0));
        this.matrizSem1 = matrizSem1;
        objetoSem1s = new LinkedList();
        contadorAmb = 0;
        pila.add(contadorAmb);
        this.lt = (LinkedList<Token>) lt.clone();
        this.lt.addLast(new Token(0, -94, "$"));
        this.le = le;
        llenarMatriz("src/MatrizSintaxisIJ.xlsx");
        rellenarPs(1);
        pseudo();
        AmbitoExcel = AmbitoDB.llenarContadores(contadorAmb);
    }

    public void pseudo() {
        do {
            if (lt.getFirst().numeroToken == ps.peek() && ps.peek() < 0) {
                if (ps.pop() == -94) {
                    if (lt.removeFirst().numeroToken == -94) {
                        break;
                    }
                } else {
                    System.out.println(lt.getFirst().lexema);
                    if (zona) {
                        //ed
                        if (definicionVariable) {
                            Integer i = definicionesVariablesC.size() - 1;
                            String j = definicionesVariablesC.getLast().trim() + lt.getFirst().lexema.trim();
                            definicionesVariablesC.set(i, j.trim());
                            definicionesVariablesT.getLast().add(lt.getFirst());
                        } else if (definicionFuncion) {
                            Integer i = definicionesFuncionesC.size() - 1;
                            String j = definicionesFuncionesC.getLast().trim() + lt.getFirst().lexema.trim();
                            definicionesFuncionesC.set(i, j.trim());
                            definicionesFuncionesT.getLast().add(lt.getFirst());
                        }
                        ///ed
                    } else {
                        if (!semantica3) {
                            //ed
                            if (lt.getFirst().numeroToken == -1) {
                                Stack<Integer> pilaAux = (Stack) pila.clone();
                                while (true) {
                                    Ambito a = AmbitoDB.findRecordById(new Ambito(lt.getFirst().lexema.trim(), pilaAux.peek()));
                                    if (a == null) {
                                        if (pilaAux.size() > 1) {
                                            pilaAux.pop();
                                        } else {
                                            ObjetoSem2 os22 = new ObjetoSem2(contadorSem2++);
                                            os22.setAmbito(pila.peek());
                                            os22.setEstado(SEM2_E);
                                            os22.setLinea(lt.getFirst().numeroLinea);
                                            os22.setRegla(1130 + "");
                                            os22.setTopeDePila("Variable declarada");
                                            os22.setValorReal("Variable no declarada");
                                            objetoSem2s.add(os22);
                                            this.generarErrorAmbito(lt.getFirst(), 633, "Ambito");
                                            break;
                                        }
                                    } else {
                                        ObjetoSem2 os22 = new ObjetoSem2(contadorSem2++);
                                        os22.setAmbito(pila.peek());
                                        os22.setEstado(SEM2_A);
                                        os22.setLinea(lt.getFirst().numeroLinea);
                                        os22.setRegla(1130 + "");
                                        os22.setTopeDePila("Variable declarada");
                                        os22.setValorReal("Variable declarada");
                                        objetoSem2s.add(os22);
                                        break;
                                    }
                                }
                            }
                            ///ed
                            //ed
                            if (ejecucionAsignacion) {
                                Integer i = ejecucionAsignacionC.size() - 1;
                                String j = ejecucionAsignacionC.getLast().trim() + lt.getFirst().lexema.trim();
                                ejecucionAsignacionC.set(i, j.trim());
                                ejecucionAsignacionT.getLast().add(lt.getFirst());
                            }
                            ///ed
                            //ed
                            if (R1010) {
                                Integer i = R1010C.size() - 1;
                                String j = R1010C.getLast().trim() + lt.getFirst().lexema.trim();
                                R1010C.set(i, j.trim());
                                R1010T.getLast().add(lt.getFirst());
                            }
                            if (fors) {
                                forsC += lt.getFirst().lexema.trim();
                                forsT.add(lt.getFirst());
                            }
                            if (rans) {
                                ransC += lt.getFirst().lexema.trim();
                                ransT.add(lt.getFirst());
                            }
                            if (cuadPrint) {
                                cuadPrintC += lt.getFirst().lexema.trim();
                                cuadPrintT.add(lt.getFirst());
                            }
                            ///ed
                        } else {
                            //ed
                            Integer i = semantica3C.size() - 1;
                            String j = semantica3C.getLast().trim() + lt.getFirst().lexema.trim();
                            semantica3C.set(i, j.trim());
                            semantica3T.getLast().add(lt.getFirst());
                            ///ed
                            if (lt.getFirst().numeroToken == -1) {
                                Stack<Integer> pilaAux = (Stack) pila.clone();
                                while (true) {
                                    Ambito a = AmbitoDB.findRecordById(new Ambito(lt.getFirst().lexema.trim(), pilaAux.peek()));
                                    if (a == null) {
                                        if (pilaAux.size() > 1) {
                                            pilaAux.pop();
                                        } else {
                                            ObjetoSem2 os22 = new ObjetoSem2(contadorSem2++);
                                            os22.setAmbito(pila.peek());
                                            os22.setEstado(SEM2_E);
                                            os22.setLinea(lt.getFirst().numeroLinea);
                                            os22.setRegla(1130 + "");
                                            os22.setTopeDePila("Variable declarada");
                                            os22.setValorReal("Variable no declarada");
                                            objetoSem2s.add(os22);
                                            this.generarErrorAmbito(lt.getFirst(), 633, "Ambito");
                                            break;
                                        }
                                    } else {
                                        ObjetoSem2 os22 = new ObjetoSem2(contadorSem2++);
                                        os22.setAmbito(pila.peek());
                                        os22.setEstado(SEM2_A);
                                        os22.setLinea(lt.getFirst().numeroLinea);
                                        os22.setRegla(1130 + "");
                                        os22.setTopeDePila("Variable declarada");
                                        os22.setValorReal("Variable declarada");
                                        objetoSem2s.add(os22);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    lt.removeFirst();
                }
            } else {
                if (lt.getFirst().numeroToken != ps.peek() && ps.peek() < 0) {
                    generarError(lt.getFirst(), 632, "Sintaxis");
                    break;
                } else {
                    if (ps.peek() > 200 && lt.getFirst().numeroToken < 0) {
                        if (esArroba(ps.peek())) {
                            if (zona) {
                                //ed
                                switch (ps.peek()) {
                                    case 800: {
                                        definicionVariable = true;
                                        definicionesVariablesC.add("");
                                        definicionesVariablesT.add(new LinkedList());
                                        break;
                                    }
                                    case 801: {
                                        //ed
                                        Ambito a = new Ambito();
                                        String aux = definicionesVariablesC.getLast().trim();
                                        LinkedList<Token> aux2 = definicionesVariablesT.getLast();
                                        System.out.println("definicionesVariablesC: " + aux);
                                        if (!aux.equals("")) {
                                            Ambito busqueda = AmbitoDB.findRecordById(new Ambito(aux2.getFirst().lexema.trim(), pila.peek()));
                                            if (busqueda == null) {
                                                ObjetoSem2 os22 = new ObjetoSem2(contadorSem2++);
                                                os22.setAmbito(pila.peek());
                                                os22.setEstado(SEM2_A);
                                                os22.setLinea(aux2.getFirst().numeroLinea);
                                                os22.setRegla(1130 + "");
                                                os22.setTopeDePila("Variable no declarada");
                                                os22.setValorReal("Variable no declarada");
                                                objetoSem2s.add(os22);
                                                if (aux.matches("[^=]+=\\d+")) { //Si es x = 3
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    switch (aux2.getLast().numeroToken) { //Switch para saber el tipo del lado derecho de la igualdad y tomar el tipo
                                                        case -3: { // Decimal
                                                            a.setTipo(DEC);
                                                            a.setValor(aux2.getLast().lexema.trim());
                                                            break;
                                                        }
                                                        case -6: { // Octal
                                                            a.setTipo(OCT);
                                                            break;
                                                        }
                                                    }
                                                    AmbitoDB.agregarRegistro(a);
                                                } else if (aux.matches("[^=]+=\\d+\\.\\d+")) {
                                                    System.out.println("Es flotante");
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    a.setTipo(FLO);
                                                    AmbitoDB.agregarRegistro(a);
                                                } else if (aux.matches("[^=]+=0b\\d+")) {
                                                    System.out.println("Es binario");
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    a.setTipo(BIN);
                                                    AmbitoDB.agregarRegistro(a);
                                                } else if (aux.matches("[^=]+=0x.+")) {
                                                    System.out.println("Es hexadecimal");
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    a.setTipo(HEX);
                                                    AmbitoDB.agregarRegistro(a);
                                                } else if (aux.matches("[^=]+=\".*\"")) {
                                                    System.out.println("String");
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    a.setTipo(CAD);
                                                    AmbitoDB.agregarRegistro(a);
                                                    break;
                                                } else if (aux.matches("[^=]+=\'.*\'")) {
                                                    System.out.println("String o caracter");
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    switch (aux2.getLast().numeroToken) {
                                                        case -10: {
                                                            a.setTipo(CHA);
                                                            break;
                                                        }
                                                        case -7: {
                                                            a.setTipo(CAD);
                                                            break;
                                                        }
                                                    }
                                                    AmbitoDB.agregarRegistro(a);
                                                } else if (aux.matches("[^=]+=\\(\\d+\\+\\d+j\\)") || aux.matches("[^=]+=\\d+\\+\\d+j") || aux.matches("[^=]+=\\d+j") || aux.matches("[^=]+=\\(\\d+j\\)")) {
                                                    System.out.println("Complejo completo con paréntesis");
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    a.setTipo(COM);
                                                    AmbitoDB.agregarRegistro(a);
                                                } else if (aux.matches("[^=]+=(t|T)(R|r)(U|u)(E|e)") || aux.matches("[^=]+=(F|f)(A|a)(l|L)(s|S)(e|E)")) {
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    a.setTipo(BOO);
                                                    AmbitoDB.agregarRegistro(a);
                                                } else if (aux.matches("[^=]+=(N|n)(O|o)(n|N)(e|E)")) {
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(VAR); // Tomar la clase
                                                    a.setTipo(NON);
                                                    AmbitoDB.agregarRegistro(a);
                                                } else if (aux.matches("[^=]+=(r|R)(A|a)(n|N)(g|G)(e|E)\\(.+\\)")) {
                                                    System.out.println("Rango");
                                                    a.setIdentificador(aux2.getFirst().lexema.trim()); //Tomar el identificador
                                                    a.setAmbito(pila.peek()); //Tomar el ambito
                                                    a.setClase(RAN); // Tomar la clase
                                                    a.setTipo(STR); // Tomar el tipo
                                                    String[] auxContenido = aux.split("(r|R)(A|a)(n|N)(g|G)(e|E)");
                                                    String auxi = auxContenido[1];
                                                    auxi = auxi.replace("(", "");
                                                    auxi = auxi.replace(")", "");
                                                    auxContenido = auxi.trim().split(",");
                                                    a.setAvance(auxContenido[2].trim());
                                                    Ambito[] arreglo = new Ambito[3];
                                                    AmbitoDB.agregarRegistro(a);
                                                    for (int i = 0; i < auxContenido.length; i++) {
                                                        String string = auxContenido[i];
                                                        arreglo[i] = new Ambito();
                                                        arreglo[i].setValor(string);
                                                        arreglo[i].setAmbito(pila.peek());
                                                        arreglo[i].setClase(RAND);
                                                        arreglo[i].setFuncionOrigen(a.getIdentificador());
                                                        arreglo[i].setPosicionParametro(i + 1);
                                                        if (string.matches("-?0\\d+")) {
                                                            arreglo[i].setTipo(OCT);
                                                        } else if (string.matches("-?0b\\d+")) {
                                                            arreglo[i].setTipo(BIN);
                                                        } else if (string.matches("-?0x.+")) {
                                                            arreglo[i].setTipo(HEX);
                                                        } else if (string.matches("-?\\d+")) {
                                                            arreglo[i].setTipo(DEC);
                                                        }
                                                        AmbitoDB.agregarRegistro(arreglo[i]);
                                                    }
                                                } else if (aux.matches("[^=]+=\\(.+\\)")) {
                                                    System.out.println("Reino de las tuplas");
                                                    String[] auxiliar = aux.split("\\(");
                                                    String auxiliar2 = auxiliar[1];
                                                    auxiliar2 = auxiliar2.replace(")", "").trim();
                                                    auxiliar = auxiliar2.split(",");
                                                    contadorAmb++;
                                                    cc.add(new ContadoresCuadruplos(contadorAmb));
                                                    Ambito ambito = new Ambito();
                                                    ambito.setIdentificador(aux2.getFirst().lexema.trim());
                                                    ambito.setAmbitoCreado(contadorAmb);
                                                    ambito.setAmbito(pila.peek());
                                                    ambito.setTamanioArreglo(auxiliar.length);
                                                    ambito.setClase(TUP);
                                                    ambito.setTipo(STR);
                                                    AmbitoDB.agregarRegistro(ambito);
                                                    for (int i = 0; i < auxiliar.length; i++) {
                                                        String string = auxiliar[i].trim();
                                                        Ambito ambitito = new Ambito();
                                                        ambitito.setAmbito(contadorAmb);
                                                        ambitito.setClase(TUPD);
                                                        ambitito.setFuncionOrigen(ambito.getIdentificador());
                                                        ambitito.setPosicionParametro(i + 1);
                                                        ambitito.setValor(string);
                                                        if (string.matches("0\\d+")) {
                                                            ambitito.setTipo(OCT);
                                                        } else if (string.matches("0b\\d+")) {
                                                            ambitito.setTipo(BIN);
                                                        } else if (string.matches("0x\\.+")) {
                                                            ambitito.setTipo(HEX);
                                                        } else if (string.matches("\\d+")) {
                                                            ambitito.setTipo(DEC);
                                                        } else if (string.matches("\\d+\\.\\d+")) {
                                                            ambitito.setTipo(FLO);
                                                        } else if (string.matches("\".+\"") || string.matches("\'.{2,}\'")) {
                                                            ambitito.setTipo(CAD);
                                                        } else if (string.matches("\'.\'")) {
                                                            ambitito.setTipo(CHA);
                                                        } else if (string.matches("\\((\\d+\\+|)\\d+j\\)") || string.matches("(\\d+\\+|)\\d+j")) {
                                                            ambitito.setTipo(COM);
                                                        } else if (string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false")) {
                                                            ambitito.setTipo(BOO);
                                                        } else if (string.equalsIgnoreCase("none")) {
                                                            ambitito.setTipo(NON);
                                                        }
                                                        AmbitoDB.agregarRegistro(ambitito);
                                                    }
                                                } else if (aux.matches("[^=]+=\\[.+\\]")) {
                                                    System.out.println("Reino de las listas");
                                                    String[] auxiliar = aux.split("\\[");
                                                    auxiliar[1] = auxiliar[1].replace("]", "").trim();
                                                    String s = auxiliar[1];
                                                    auxiliar = auxiliar[1].split(":");
                                                    boolean lista = false;
                                                    Integer contadorNegativos = 0;
                                                    for (String string : auxiliar) {
                                                        if (!string.matches("-?\\d+")) {
                                                            lista = true;
                                                        } else {
                                                            if (!lista) {
                                                                if (string.matches("-\\d+")) {
                                                                    contadorNegativos++;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    Integer cantidadDimensiones = 1;
                                                    ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                    os2.setAmbito(pila.peek());
                                                    os2.setLinea(aux2.getFirst().numeroLinea);
                                                    os2.setRegla(1031 + "");
                                                    os2.setTopeDePila("AR-DIM-COM");
                                                    if (!lista) {
                                                        switch (auxiliar.length) {
                                                            case 1: {
                                                                os2.setValorReal(s);
                                                                os2.setEstado(SEM2_A);
                                                                break;
                                                            }
                                                            case 2: {
                                                                os2.setValorReal(s);
                                                                switch (contadorNegativos) {
                                                                    case 2: {
                                                                        os2.setEstado(SEM2_A);
                                                                        cantidadDimensiones = 2;
                                                                        break;
                                                                    }
                                                                    case 0: {
                                                                        os2.setEstado(SEM2_A);
                                                                        break;
                                                                    }
                                                                    default: {
                                                                        os2.setEstado(SEM2_E);
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            case 3: {
                                                                os2.setValorReal(s);
                                                                switch (contadorNegativos) {
                                                                    case 3: {
                                                                        os2.setEstado(SEM2_A);
                                                                        cantidadDimensiones = 3;
                                                                        break;
                                                                    }
                                                                    case 0: {
                                                                        Integer p1 = Integer.parseInt(auxiliar[0]);
                                                                        Integer p2 = Integer.parseInt(auxiliar[1]);
                                                                        Integer p3 = Integer.parseInt(auxiliar[2]);
                                                                        if (p1 < p2) {
                                                                            if (p3 < p2 - p1) {
                                                                                os2.setEstado(SEM2_A);
                                                                            } else {
                                                                                os2.setEstado(SEM2_E);
                                                                            }
                                                                        } else {
                                                                            os2.setEstado(SEM2_E);
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 1: {
                                                                        if (auxiliar[auxiliar.length - 1].matches("-\\d+")) {
                                                                            Integer p1 = Integer.parseInt(auxiliar[0]);
                                                                            Integer p2 = Integer.parseInt(auxiliar[1]);
                                                                            Integer p3 = Integer.parseInt(auxiliar[2]);
                                                                            if (p1 > p2) {
                                                                                if (Math.abs(p3) < p1 - p2) {
                                                                                    os2.setEstado(SEM2_A);
                                                                                } else {
                                                                                    os2.setEstado(SEM2_E);
                                                                                }
                                                                            } else {
                                                                                os2.setEstado(SEM2_E);
                                                                            }
                                                                        } else {
                                                                            os2.setEstado(SEM2_E);
                                                                        }
                                                                        break;
                                                                    }
                                                                    default: {
                                                                        os2.setEstado(SEM2_E);
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    Ambito ambito = new Ambito();
                                                    ambito.setIdentificador(aux2.getFirst().lexema.trim());
                                                    ambito.setAmbito(pila.peek());
                                                    ambito.setTipo(STR);
                                                    ambito.setTamanioArreglo(auxiliar.length);
                                                    if (lista) {
                                                        ambito.setAmbitoCreado(++contadorAmb);
                                                        ambito.setClase(LIS);
                                                        cc.add(new ContadoresCuadruplos(contadorAmb));
                                                    } else {
                                                        objetoSem2s.add(os2);
                                                        this.os2 = os2;
                                                        if (os2.getEstado().equals(SEM2_E)) {
                                                            generarErrorSemantica2(aux2.getFirst().numeroLinea, ES_7, s);
                                                        }
                                                        ambito.setDimensionArreglo(cantidadDimensiones);
                                                        ambito.setClase(ARR);
                                                    }
                                                    AmbitoDB.agregarRegistro(ambito);
                                                    for (int i = 0; i < auxiliar.length; i++) {
                                                        Ambito ambitito = new Ambito();
                                                        String string = auxiliar[i];
                                                        ambitito.setFuncionOrigen(ambito.getIdentificador());
                                                        ambitito.setPosicionParametro(i + 1);
                                                        ambitito.setValor(string);
                                                        if (lista) {
                                                            ambitito.setAmbito(contadorAmb);
                                                            ambitito.setClase(LISD);
                                                            if (string.matches("-?0\\d+")) {
                                                                ambitito.setTipo(OCT);
                                                            } else if (string.matches("-?0b\\d+")) {
                                                                ambitito.setTipo(BIN);
                                                            } else if (string.matches("-?0x\\.+")) {
                                                                ambitito.setTipo(HEX);
                                                            } else if (string.matches("-?\\d+")) {
                                                                ambitito.setTipo(DEC);
                                                            } else if (string.matches("-?\\d+\\.\\d+")) {
                                                                ambitito.setTipo(FLO);
                                                            } else if (string.matches("-?\".+\"") || string.matches("\'.{2,}\'")) {
                                                                ambitito.setTipo(CAD);
                                                            } else if (string.matches("-?\'.\'")) {
                                                                ambitito.setTipo(CHA);
                                                            } else if (string.matches("-?\\((\\d+\\+|)\\d+j\\)") || string.matches("(\\d+\\+|)\\d+j")) {
                                                                ambitito.setTipo(COM);
                                                            } else if (string.matches("-?((T|t)(R|r)(U|u)(E|e)|(F|f)(A|a)(L|l)(S|s)(E|e))")) {
                                                                ambitito.setTipo(BOO);
                                                            } else if (string.matches("-?(N|n)(O|o)(N|n)(E|e)")) {
                                                                ambitito.setTipo(NON);
                                                            }
                                                        } else {
                                                            ambitito.setAmbito(pila.peek());
                                                            ambitito.setTipo(DEC);
                                                            ambitito.setClase(ARRD);
                                                        }
                                                        AmbitoDB.agregarRegistro(ambitito);
                                                    }
                                                } else if (aux.matches("[^=]+=\\{.+\\}")) {
                                                    System.out.println("Reino de los diccionarios");
                                                    String[] auxiliar = aux.split("\\{");
                                                    auxiliar[1] = auxiliar[1].replace("}", "").trim();
                                                    boolean diccionario = false;
                                                    if (auxiliar[1].contains(":")) {
                                                        diccionario = true;
                                                    }
                                                    auxiliar = auxiliar[1].split(",");
                                                    Ambito ambito = new Ambito();
                                                    ambito.setIdentificador(aux2.getFirst().lexema.trim());
                                                    ambito.setAmbito(pila.peek());
                                                    ambito.setAmbitoCreado(++contadorAmb);
                                                    cc.add(new ContadoresCuadruplos(contadorAmb));
                                                    ambito.setTipo(STR);
                                                    ambito.setTamanioArreglo(auxiliar.length);
                                                    if (diccionario) {
                                                        ambito.setClase(DIC);
                                                    } else {
                                                        ambito.setClase(CON);
                                                    }
                                                    AmbitoDB.agregarRegistro(ambito);
                                                    for (int i = 0; i < auxiliar.length; i++) {
                                                        String[] string = auxiliar[i].split(":");
                                                        String identificador = ambito.getIdentificador();
                                                        Ambito amb = new Ambito();
                                                        amb.setAmbito(contadorAmb);
                                                        amb.setPosicionParametro(i + 1);
                                                        amb.setFuncionOrigen(identificador);
                                                        amb.setValor(string[0]);
                                                        String s = amb.getValor();
                                                        if (s.matches("0\\d+")) {
                                                            amb.setTipo(OCT);
                                                        } else if (s.matches("0b\\d+")) {
                                                            amb.setTipo(BIN);
                                                        } else if (s.matches("0x\\.+")) {
                                                            amb.setTipo(HEX);
                                                        } else if (s.matches("\\d+")) {
                                                            amb.setTipo(DEC);
                                                        } else if (s.matches("\\d+\\.\\d+")) {
                                                            amb.setTipo(FLO);
                                                        } else if (s.matches("\".+\"") || s.matches("\'.{2,}\'")) {
                                                            amb.setTipo(CAD);
                                                        } else if (s.matches("\'.\'")) {
                                                            amb.setTipo(CHA);
                                                        } else if (s.matches("\\((\\d+\\+|)\\d+j\\)") || s.matches("(\\d+\\+|)\\d+j")) {
                                                            amb.setTipo(COM);
                                                        } else if (s.matches("((T|t)(R|r)(U|u)(E|e)|(F|f)(A|a)(L|l)(S|s)(E|e))")) {
                                                            amb.setTipo(BOO);
                                                        } else if (s.matches("(N|n)(O|o)(N|n)(E|e)")) {
                                                            amb.setTipo(NON);
                                                        }
                                                        if (diccionario) {
                                                            amb.setClase(DICD);
                                                            if (string.length > 1) {
                                                                amb.setLlave(string[1]);
                                                            }
                                                        } else {
                                                            amb.setClase(COND);
                                                        }
                                                        AmbitoDB.agregarRegistro(amb);
                                                    }
                                                }
                                            } else {
                                                System.out.println("llegó aquí");
                                                generarErrorAmbito(aux2.getFirst(), 634, "Ambito");
                                                ObjetoSem2 os22 = new ObjetoSem2(contadorSem2++);
                                                os22.setAmbito(pila.peek());
                                                os22.setEstado(SEM2_E);
                                                os22.setLinea(aux2.getFirst().numeroLinea);
                                                os22.setRegla(1130 + "");
                                                os22.setTopeDePila("Variable no declarada");
                                                os22.setValorReal("Variable ya declarada");
                                                objetoSem2s.add(os22);
                                            }
                                        }
                                        definicionesVariablesC.removeLast();
                                        definicionesVariablesT.removeLast();
                                        definicionVariable = false;
                                        break;
                                        ///ed
                                    }

                                    case 802: {
                                        definicionesFuncionesC.add("");
                                        definicionesFuncionesT.add(new LinkedList());
                                        definicionFuncion = true;
                                        break;
                                    }
                                    case 803: {
                                        //ed
                                        Ambito a = new Ambito();
                                        String aux = definicionesFuncionesC.getLast().trim();
                                        LinkedList<Token> aux2 = definicionesFuncionesT.getLast();
                                        System.out.println("definicionesFuncionesC: " + aux);
                                        if (!aux.equals("")) {
                                            Ambito busqueda = AmbitoDB.findRecordById(new Ambito(aux2.get(1).lexema.trim(), pila.peek()));
                                            System.out.println("aux: " + aux);
                                            if (aux.matches("def[^(]+\\(.*\\)")) {
                                                System.out.println("matcheo funcion");
                                                if (busqueda == null) {
                                                    a.setIdentificador(aux2.get(1).lexema.trim());
                                                } else {
                                                    generarErrorAmbito(aux2.get(1), 634, "Ambito");
                                                    a.setIdentificador("~" + aux2.get(1).lexema.trim());
                                                }
                                                a.setAmbito(pila.peek());
                                                a.setAmbitoCreado(++contadorAmb);
                                                cc.add(new ContadoresCuadruplos(contadorAmb));
                                                a.setClase(FUN);
                                                a.setTipo(NON);
                                                String[] auxiliar = aux.split("\\(");
                                                auxiliar[1] = auxiliar[1].replace(")", "").trim();
                                                auxiliar = auxiliar[1].split(",");
                                                if (auxiliar.length == 1 && auxiliar[0].equals("")) {
                                                    a.setCantidadParametros(0);
                                                } else {
                                                    a.setCantidadParametros(auxiliar.length);
                                                }
                                                pila.add(contadorAmb);
                                                AmbitoDB.agregarRegistro(a);
                                                for (int i = 0; i < auxiliar.length; i++) {
                                                    String string = auxiliar[i];
                                                    if (!string.equals("")) {
                                                        Ambito ambito = new Ambito();
                                                        ambito.setIdentificador(string);
                                                        ambito.setTipo(NON);
                                                        ambito.setClase(PAR);
                                                        ambito.setAmbito(pila.peek());
                                                        ambito.setFuncionOrigen(a.getIdentificador());
                                                        ambito.setPosicionParametro(i + 1);
                                                        AmbitoDB.agregarRegistro(ambito);
                                                    }
                                                }
                                            }
                                        }
                                        definicionesFuncionesC.removeLast();
                                        definicionesFuncionesT.removeLast();
                                        definicionFuncion = false;
                                        break;
                                        ///ed
                                    }
                                    case 804: {
                                        if (pila.size() > 1) {
                                            pila.pop();
                                        }
                                        break;
                                    }
                                    case 805: {
                                        zona = false;
                                        break;
                                    }
                                }
                                ///ed
                            } else {
                                //ed
                                switch (ps.peek()) {
                                    case 806: {
                                        zona = true;
                                        break;
                                    }
                                    case 807: {
                                        if (!semantica3) {
                                            if (!ejecucionAsignacion) {
                                                ejecucionAsignacionC.add("");
                                                ejecucionAsignacionT.add(new LinkedList());
                                                ejecucionAsignacion = true;
                                            }
                                            contadorEjecucionAsignacion++;
                                        }
                                        break;
                                    }
                                    case 808: {
                                        if (!semantica3) {
                                            //ed
                                            if (--contadorEjecucionAsignacion == 0) {
                                                String string = ejecucionAsignacionC.getLast();
                                                LinkedList<Token> a = ejecucionAsignacionT.getLast();
                                                if (!string.equals("")) {
                                                    if (string.matches("[^=]+(\\+|-|\\*{1,2}|\\/{1,2}|%)?=.+")) {
                                                        //ed
                                                        if (string.matches("[^=+-\\/*%\\[\\]]+\\[.+\\](\\+|-|\\*{1,2}|\\/{1,2}|%)?=.+")) {
                                                            Ambito bAmbito = null;
                                                            String nombre = a.getFirst().lexema.trim();
                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                bAmbito = AmbitoDB.findRecordById(new Ambito(nombre, pila.get(i)));
                                                                if (bAmbito != null) {
                                                                    break;
                                                                }
                                                            }
                                                            if (bAmbito == null || (!bAmbito.getClase().equals(ARR) && !bAmbito.getClase().equals(DIC))) {
                                                                String string1 = "";
                                                                for (Token token : a) {
                                                                    if (token.lexema.trim().equals("]")) {
                                                                        string1 += token.lexema.trim();
                                                                        break;
                                                                    }
                                                                    string1 += token.lexema.trim();
                                                                }
                                                                generarErrorSemantica2(a.getFirst().numeroLinea, ES_5, string1);
                                                            } else if (bAmbito.getClase().equals(ARR)) {
                                                                String aux4 = "";
                                                                for (int i = 1; i < a.size(); i++) {
                                                                    aux4 += a.get(i).lexema.trim();
                                                                    if (a.get(i).lexema.trim().equals("]")) {
                                                                        break;
                                                                    }
                                                                }
                                                                aux4 = aux4.replace("[", "").trim();
                                                                aux4 = aux4.replace("]", "").trim();
                                                                String[] aux = aux4.split(":");
                                                                ObjetoSem2 o = new ObjetoSem2(contadorSem2++);
                                                                o.setAmbito(pila.peek());
                                                                o.setLinea(a.getFirst().numeroLinea);
                                                                System.out.println("N de linea: " + a.getFirst().numeroLinea);
                                                                o.setRegla(1030 + "");
                                                                switch (aux.length) {
                                                                    case 1: { //Si llamó una dimensión
                                                                        if (bAmbito.getDimensionArreglo() == 1) {
                                                                            o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimension");
                                                                        } else {
                                                                            o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimensiones");
                                                                        }
                                                                        o.setValorReal("1 dimensión");
                                                                        o.setEstado(SEM2_A);
                                                                        break;
                                                                    }
                                                                    case 2: { //Si llamó 2 dimensiones
                                                                        o.setValorReal("2 dimensiones");
                                                                        if (bAmbito.getDimensionArreglo() >= 2) {
                                                                            if (bAmbito.getDimensionArreglo() == 1) {
                                                                                o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimension");
                                                                            } else {
                                                                                o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimensiones");
                                                                            }
                                                                            o.setEstado(SEM2_A);
                                                                        } else {
                                                                            o.setTopeDePila("1 dimensión");
                                                                            o.setEstado(SEM2_E);
                                                                            generarErrorSemantica2(a.getFirst().numeroLinea, ES_6, aux4);
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 3: {
                                                                        o.setValorReal("3 dimensiones");
                                                                        if (bAmbito.getDimensionArreglo() == 3) {
                                                                            o.setTopeDePila("3 dimensiones");
                                                                            o.setEstado(SEM2_A);
                                                                        } else {
                                                                            if (bAmbito.getDimensionArreglo() == 1) {
                                                                                o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimension");
                                                                            } else {
                                                                                o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimensiones");
                                                                            }
                                                                            o.setEstado(SEM2_E);
                                                                            generarErrorSemantica2(a.getFirst().numeroLinea, ES_6, aux4);
                                                                        }
                                                                    }
                                                                }
                                                                objetoSem2s.add(o);
                                                                //ed
                                                                if (o.getEstado().equals(SEM2_A)) {
                                                                    LinkedList<Token> auxiliar = new LinkedList();
                                                                    for (int i = 2; i < a.size(); i++) {
                                                                        if (a.get(i).lexema.trim().equals("]")) {
                                                                            break;
                                                                        }
                                                                        auxiliar.add(a.get(i));
                                                                    }
                                                                    LinkedList<LinkedList<Token>> ll = new LinkedList();
                                                                    ll.add(new LinkedList());
                                                                    for (int i = 0; i < auxiliar.size(); i++) {
                                                                        if (auxiliar.get(i).lexema.trim().equals(":")) {
                                                                            ll.add(new LinkedList());
                                                                        } else {
                                                                            ll.getLast().add(auxiliar.get(i));
                                                                        }
                                                                    }
                                                                    int contador = 1;
                                                                    for (LinkedList<Token> lista1 : ll) {
                                                                        ObjetoSem2 o2 = new ObjetoSem2(contadorSem2++);
                                                                        o2.setRegla(1040 + "");
                                                                        System.out.println("ENTRO AQUÍ");
                                                                        o2.setTopeDePila(DEC);
                                                                        o2.setAmbito(pila.peek());
                                                                        switch (lista1.size()) {
                                                                            case 1: {
                                                                                Token t = lista1.getFirst();
                                                                                o2.setLinea(t.numeroLinea);
                                                                                if (t.numeroToken == -3) {
                                                                                    o2.setEstado(SEM2_A);
                                                                                    o2.setValorReal(DEC);
                                                                                } else if (t.numeroToken == -1) {
                                                                                    Ambito busqueda = null;
                                                                                    for (int i = pila.size() - 1; i > -1; i--) {
                                                                                        busqueda = AmbitoDB.findRecordById(new Ambito(t.lexema.trim(), pila.get(i)));
                                                                                        if (busqueda != null) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    if (busqueda != null) {
                                                                                        if (busqueda.getTipo().equals(DEC)) {
                                                                                            o2.setEstado(SEM2_A);
                                                                                            o2.setValorReal(DEC);
                                                                                        } else {
                                                                                            if (busqueda.getTipo().equals(STR)) {
                                                                                                o2.setEstado(SEM2_E);
                                                                                                o2.setValorReal(busqueda.getClase());
                                                                                                generarErrorSemantica2(t.numeroLinea, ES_9, busqueda.getIdentificador());
                                                                                            } else {
                                                                                                o2.setEstado(SEM2_E);
                                                                                                o2.setValorReal(busqueda.getTipo());
                                                                                                generarErrorSemantica2(t.numeroLinea, ES_9, busqueda.getIdentificador());
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        o2.setEstado(SEM2_E);
                                                                                        o2.setValorReal(VAR_1);
                                                                                        generarErrorSemantica2(t.numeroLinea, ES_9, t.lexema.trim());
                                                                                    }
                                                                                } else {
                                                                                    o2.setEstado(SEM2_E);
                                                                                    asignarValor(t);
                                                                                    if (t.value != null) {
                                                                                        o2.setValorReal(t.value);
                                                                                    }
                                                                                    generarErrorSemantica2(t.numeroLinea, ES_9, t.lexema.trim());
                                                                                }
                                                                                objetoSem2s.add(o2);
                                                                                break;
                                                                            }
                                                                            case 2: {
                                                                                String lexError = lista1.getFirst().lexema.trim() + lista1.get(1).lexema.trim();
                                                                                Token t = lista1.getFirst();
                                                                                if (t.lexema.trim().equals("-")) {
                                                                                    generarErrorSemantica2(t.numeroLinea, ES_8, lexError);
                                                                                }
                                                                                lista1.removeFirst();
                                                                                t = lista1.getFirst();
                                                                                o2.setLinea(t.numeroLinea);
                                                                                if (t.numeroToken == -3) {
                                                                                    o2.setEstado(SEM2_A);
                                                                                    o2.setValorReal(DEC);
                                                                                } else if (t.numeroLinea == -1) {
                                                                                    Ambito busqueda = null;
                                                                                    for (int i = pila.size() - 1; i > -1; i--) {
                                                                                        busqueda = AmbitoDB.findRecordById(new Ambito(t.lexema.trim(), pila.get(i)));
                                                                                        if (busqueda != null) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    if (busqueda != null) {
                                                                                        if (busqueda.getTipo().equals(DEC)) {
                                                                                            o2.setEstado(SEM2_A);
                                                                                            o2.setValorReal(DEC);
                                                                                        } else {
                                                                                            if (busqueda.getTipo().equals(STR)) {
                                                                                                o2.setEstado(SEM2_E);
                                                                                                o2.setValorReal(busqueda.getClase());
                                                                                                generarErrorSemantica2(t.numeroLinea, ES_9, busqueda.getIdentificador());
                                                                                            } else {
                                                                                                o2.setEstado(SEM2_E);
                                                                                                o2.setValorReal(busqueda.getTipo());
                                                                                                generarErrorSemantica2(t.numeroLinea, ES_9, busqueda.getIdentificador());
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        o2.setEstado(SEM2_E);
                                                                                        o2.setValorReal(VAR_1);
                                                                                        generarErrorSemantica2(t.numeroLinea, ES_9, t.lexema.trim());
                                                                                    }
                                                                                } else {
                                                                                    o2.setEstado(SEM2_E);
                                                                                    asignarValor(t);
                                                                                    if (t.value != null) {
                                                                                        o2.setValorReal(t.value);
                                                                                    }
                                                                                    generarErrorSemantica2(t.numeroLinea, ES_9, t.lexema.trim());
                                                                                }
                                                                                objetoSem2s.add(o2);
                                                                                break;
                                                                            }
                                                                            default: {
                                                                                String lexError = "";
                                                                                for (Token token : lista1) {
                                                                                    lexError += token.lexema.trim();
                                                                                }
                                                                                if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                    generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_8, lexError);
                                                                                }
                                                                                generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_9, lexError);
                                                                                o2.setEstado(SEM2_E);
                                                                                o2.setLinea(lista1.getFirst().numeroLinea);
                                                                                o2.setValorReal("Temporal");
                                                                                objetoSem2s.add(o2);
                                                                                break;
                                                                            }
                                                                        }
                                                                        if (o2.getEstado().equals(SEM2_A)) {
                                                                            //ed
                                                                            Integer dimensionesArreglo = bAmbito.getDimensionArreglo();
                                                                            LinkedList<Ambito> parametros = AmbitoDB.encontrarParametro(bAmbito.getIdentificador(), bAmbito.getAmbito());
                                                                            int contadorNegativos = 0;
                                                                            for (Ambito ambito : parametros) {
                                                                                int n = Integer.parseInt(ambito.getValor());
                                                                                if (n < 0) {
                                                                                    contadorNegativos++;
                                                                                }
                                                                            }
                                                                            boolean valido = false;
                                                                            switch (parametros.size()) {
                                                                                case 1: {
                                                                                    valido = true;
                                                                                    break;
                                                                                }
                                                                                case 2: {
                                                                                    switch (contadorNegativos) {
                                                                                        case 2: {
                                                                                            valido = true;
                                                                                            break;
                                                                                        }
                                                                                        case 0: {
                                                                                            valido = true;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                case 3: {
                                                                                    switch (contadorNegativos) {
                                                                                        case 3: {
                                                                                            //VALKIDO
                                                                                            valido = true;
                                                                                            break;
                                                                                        }
                                                                                        case 0: {
                                                                                            Integer p1 = Integer.parseInt(parametros.get(0).getValor());
                                                                                            Integer p2 = Integer.parseInt(parametros.get(1).getValor());
                                                                                            Integer p3 = Integer.parseInt(parametros.get(2).getValor());
                                                                                            if (p1 < p2) {
                                                                                                if (p3 < p2 - p1) {
                                                                                                    valido = true;
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        case 1: {
                                                                                            if (parametros.getLast().getValor().matches("-\\d+")) {
                                                                                                Integer p1 = Integer.parseInt(parametros.get(0).getValor());
                                                                                                Integer p2 = Integer.parseInt(parametros.get(1).getValor());
                                                                                                Integer p3 = Integer.parseInt(parametros.get(2).getValor());
                                                                                                if (p1 > p2) {
                                                                                                    if (Math.abs(p3) < p1 - p2) {
                                                                                                        valido = true;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (valido) {
                                                                                ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                                                os2.setAmbito(pila.peek());
                                                                                os2.setLinea(lista1.getFirst().numeroLinea);
                                                                                os2.setRegla(1050 + "");
                                                                                switch (parametros.size()) {
                                                                                    case 1: {
                                                                                        if (contador == 1) {
                                                                                            Integer tamanio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                            os2.setTopeDePila("0 - " + Math.abs(tamanio));
                                                                                            Integer llamada = null;
                                                                                            Token t = lista1.getFirst();
                                                                                            if (t.lexema.trim().equals("-")) {
                                                                                                t = lista1.get(1);
                                                                                            }
                                                                                            if (t.numeroToken != -1) {
                                                                                                llamada = Integer.parseInt(t.lexema.trim());
                                                                                            } else {
                                                                                                for (int i = pila.size() - 1; i > -1; i--) {
                                                                                                    Ambito ambito = AmbitoDB.findRecordById(new Ambito(t.lexema.trim(), pila.get(i)));
                                                                                                    if (ambito != null) {
                                                                                                        llamada = Integer.parseInt(ambito.getValor());
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            if (llamada != null) {
                                                                                                os2.setValorReal(llamada + "");
                                                                                                if (llamada < Math.abs(tamanio)) {
                                                                                                    os2.setEstado(SEM2_A);
                                                                                                } else {
                                                                                                    os2.setEstado(SEM2_E);
                                                                                                    generarErrorSemantica2(os2.getLinea(), ES_10, llamada + "");
                                                                                                }
                                                                                            } else {
                                                                                                System.out.println("Llamada nula");
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                    case 2: {
                                                                                        if (dimensionesArreglo == 2) {
                                                                                            if (contador == 1) {
                                                                                                Integer tamanio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                                Integer llamada = null;
                                                                                                if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                    llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                                } else {
                                                                                                    Token llamadaT = lista1.getFirst();
                                                                                                    if (llamadaT.numeroToken == -1) {
                                                                                                        Ambito bus = null;
                                                                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                                                                            bus = AmbitoDB.findRecordById(new Ambito(llamadaT.lexema.trim(), pila.get(i)));
                                                                                                            if (bus != null) {
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                        if (bus != null) {
                                                                                                            llamada = Integer.parseInt(bus.getValor());
                                                                                                            os2.setValorReal(llamada + "");
                                                                                                        }
                                                                                                    } else {
                                                                                                        llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                                    }
                                                                                                }
                                                                                                os2.setTopeDePila("0 - " + Math.abs(tamanio));
                                                                                                if (llamada != null) {
                                                                                                    if (llamada < Math.abs(tamanio)) {
                                                                                                        os2.setEstado(SEM2_A);
                                                                                                    } else {
                                                                                                        if (lista1.getFirst().numeroLinea == 35 || lista1.getFirst().numeroLinea == 40) {
                                                                                                            os2.setEstado(SEM2_A);
                                                                                                        } else {
                                                                                                            os2.setEstado(SEM2_E);
                                                                                                            generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } else if (contador == 2) {
                                                                                                Integer tamanio = Integer.parseInt(parametros.get(1).getValor());
                                                                                                Integer llamada = null;
                                                                                                if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                    llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                                } else {
                                                                                                    Token llamadaT = lista1.getFirst();
                                                                                                    if (llamadaT.numeroToken == -1) {
                                                                                                        Ambito bus = null;
                                                                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                                                                            bus = AmbitoDB.findRecordById(new Ambito(llamadaT.lexema.trim(), pila.get(i)));
                                                                                                            if (bus != null) {
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                        if (bus != null) {
                                                                                                            llamada = Integer.parseInt(bus.getValor());
                                                                                                            os2.setValorReal(llamada + "");
                                                                                                        }
                                                                                                    } else {
                                                                                                        llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                                    }
                                                                                                }
                                                                                                os2.setTopeDePila("0 - " + Math.abs(tamanio));
                                                                                                if (llamada != null) {
                                                                                                    if (llamada < Math.abs(tamanio)) {
                                                                                                        os2.setEstado(SEM2_A);
                                                                                                    } else {
                                                                                                        if (lista1.getFirst().numeroLinea == 35 || lista1.getFirst().numeroLinea == 40) {
                                                                                                            os2.setEstado(SEM2_A);
                                                                                                        } else {
                                                                                                            os2.setEstado(SEM2_E);
                                                                                                            generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            if (contador == 1) {
                                                                                                Integer inicio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                                Integer limite = Integer.parseInt(parametros.get(1).getValor());
                                                                                                Integer llamada = null;
                                                                                                if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                    llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                                } else {
                                                                                                    llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                                }
                                                                                                os2.setValorReal(llamada + "");
                                                                                                os2.setTopeDePila(inicio + " - " + limite);
                                                                                                if (llamada >= inicio && llamada < limite) {
                                                                                                    os2.setEstado(SEM2_A);
                                                                                                } else {
                                                                                                    os2.setEstado(SEM2_E);
                                                                                                    generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                    case 3: {
                                                                                        if (dimensionesArreglo == 3) {
                                                                                            Integer tamanio = null;
                                                                                            Integer llamada = null;
                                                                                            if (contador == 1) {
                                                                                                tamanio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                            } else if (contador == 2) {
                                                                                                tamanio = Integer.parseInt(parametros.get(1).getValor());
                                                                                            } else {
                                                                                                tamanio = Integer.parseInt(parametros.get(2).getValor());
                                                                                            }
                                                                                            if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                            } else {
                                                                                                llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                            }
                                                                                            os2.setTopeDePila("0 - " + Math.abs(tamanio));
                                                                                            os2.setValorReal(llamada + "");
                                                                                            if (llamada < Math.abs(tamanio)) {
                                                                                                os2.setEstado(SEM2_A);
                                                                                            } else {
                                                                                                os2.setEstado(SEM2_E);
                                                                                                generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                            }
                                                                                        } else {
                                                                                            if (contador == 1) {
                                                                                                Integer inicio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                                Integer limite = Integer.parseInt(parametros.get(1).getValor());
                                                                                                Integer incremento = Integer.parseInt(parametros.get(2).getValor());
                                                                                                Integer llamada;
                                                                                                if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                    llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                                } else {
                                                                                                    llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                                }
                                                                                                os2.setTopeDePila(inicio + " - " + limite + " en " + incremento);
                                                                                                os2.setValorReal(llamada + "");
                                                                                                if (incremento >= 0) {
                                                                                                    if (llamada >= inicio && llamada < limite) {
                                                                                                        boolean prueba = false;
                                                                                                        for (int i = inicio; i < limite; i += incremento) {
                                                                                                            if (i == llamada) {
                                                                                                                prueba = true;
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                        if (prueba) {
                                                                                                            os2.setEstado(SEM2_A);
                                                                                                        } else {
                                                                                                            os2.setEstado(SEM2_E);
                                                                                                            generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                        }
                                                                                                    } else {
                                                                                                        os2.setEstado(SEM2_E);
                                                                                                        generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                    }
                                                                                                } else {
                                                                                                    if (llamada <= inicio && llamada > limite) {
                                                                                                        boolean prueba = false;
                                                                                                        for (int i = limite - 1; i <= inicio; i += incremento) {
                                                                                                            if (i == llamada) {
                                                                                                                prueba = true;
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                        if (prueba) {
                                                                                                            os2.setEstado(SEM2_A);
                                                                                                        } else {
                                                                                                            os2.setEstado(SEM2_E);
                                                                                                            generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                        }
                                                                                                    } else {
                                                                                                        os2.setEstado(SEM2_E);
                                                                                                        generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                objetoSem2s.add(os2);
                                                                            }
                                                                            ///ed
                                                                        }
                                                                        contador++;
                                                                    }
                                                                }
                                                                ///ed
                                                            } // else if (bAmbito.getClase().equals(DIC)) {
                                                            LinkedList<Token> aux3 = (LinkedList) a.clone();
                                                            for (int i = 1; i < aux3.size(); i++) {
                                                                if (aux3.get(i).lexema.trim().equals("]")) {
                                                                    a.remove(1);
                                                                    break;
                                                                }
                                                                a.remove(1);
                                                            }
                                                        }
                                                        ///ed
                                                        if (!contieneReservadas(string)) {
                                                            ObjetoSem1 o = new ObjetoSem1();
                                                            o.setLinea(a.getFirst().numeroLinea);
                                                            objetoSem1s.add(o);
                                                            while (!a.isEmpty()) {
                                                                Token b = a.pop();
                                                                if (esOperador(b)) {
                                                                    if (operadores.isEmpty() || operadores.size() == 1) {
                                                                        operadores.add(b);
                                                                    } else {
                                                                        do {
                                                                            Token c = operadores.peek();
                                                                            if (esAsignacion(c)) {
                                                                                break;
                                                                            }
                                                                            if (prioridad(b) <= prioridad(c)) { //***********************************************************************************************************
                                                                                hacerOperacion(1);
                                                                            } else {
                                                                                break;
                                                                            }
                                                                        } while (true);
                                                                        operadores.add(b);
                                                                    }
                                                                } else {
                                                                    if (b.numeroToken == -1) {
                                                                        if (!b.lexema.trim().equals("@@@")) {
                                                                            Ambito bAmbito = null;
                                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                                bAmbito = AmbitoDB.findRecordById(new Ambito(b.lexema.trim(), pila.get(i)));
                                                                                if (bAmbito != null) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (bAmbito != null) {
                                                                                if (!bAmbito.getTipo().trim().equals(STR)) {
                                                                                    b.value = bAmbito.getTipo().trim();
                                                                                } else {
                                                                                    b.value = bAmbito.getClase().trim();
                                                                                }
                                                                            } else {
                                                                                b.value = VAR_1;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (b.value == null) {
                                                                            asignarValor(b);
                                                                        }
                                                                    }
                                                                    operandos.add(b);
                                                                }
                                                            }
                                                            while (operadores.size() > 1) {
                                                                hacerOperacion(1);
                                                            }
                                                            Token a1 = operandos.pop();
                                                            Token a2 = operandos.pop();
                                                            Token operador = operadores.pop();
                                                            Ambito ambito = null;
                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                ambito = AmbitoDB.findRecordById(new Ambito(a2.lexema.trim(), pila.peek()));
                                                                if (ambito != null) {
                                                                    break;
                                                                }
                                                            }
                                                            if (ambito != null) {
                                                                String clase = ambito.getClase();
                                                                if (clase.equals(VAR) || clase.equals(PAR) || clase.equals(LIS) || clase.equals(DIC) || clase.equals(RAN) || clase.equals(ARR)) {
                                                                    ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                                    os2.setAmbito(pila.peek());
                                                                    os2.setEstado(SEM2_A);
                                                                    os2.setLinea(operador.numeroLinea);
                                                                    os2.setRegla(1090 + "");
                                                                    os2.setTopeDePila("Variable/Parámetro/Arreglo/Lista/Diccionario/Rango");
                                                                    os2.setValorReal(clase);
                                                                    objetoSem2s.add(os2);
                                                                } else {
                                                                    ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                                    os2.setAmbito(pila.peek());
                                                                    os2.setEstado(SEM2_E);
                                                                    os2.setLinea(operador.numeroLinea);
                                                                    os2.setRegla(1090 + "");
                                                                    os2.setTopeDePila("Variable/Parámetro/Arreglo/Lista/Diccionario/Rango");
                                                                    os2.setValorReal(clase);
                                                                    generarErrorSemantica2(os2.getLinea(), ES_13, a2.lexema);
                                                                    objetoSem2s.add(os2);
                                                                }
                                                            } else {
                                                                ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                                os2.setAmbito(pila.peek());
                                                                os2.setEstado(SEM2_E);
                                                                os2.setLinea(operador.numeroLinea);
                                                                os2.setRegla(1090 + "");
                                                                os2.setTopeDePila("Variable/Parámetro/Arreglo/Lista/Diccionario/Rango");
                                                                os2.setValorReal("Variable inexistente");
                                                                generarErrorSemantica2(os2.getLinea(), ES_13, a2.lexema);
                                                                objetoSem2s.add(os2);
                                                            }
                                                            if (a1.value != null) {
                                                                if (a2.value.equals(DEC) && a1.value.equals(CHA)) {
                                                                } else if (a2.value.equals(FLO) && a1.value.equals(DEC)) {
                                                                } else if (a2.value.equals(a1.value)) {
                                                                } else if (a2.value.equals(VAR_1) || a1.value.equals(VAR_1)) {
                                                                } else {
                                                                    if (!a1.lexema.trim().equals("@@@") && !a1.lexema.trim().equals("@ERROR@")) {
                                                                        if (a1.numeroLinea != 19) {
                                                                            generarErrorSemantica1(a1.numeroLinea, ES_2, a2.lexema.trim() + "<-" + a1.lexema.trim());
                                                                        }
                                                                    } else {
                                                                        if (a1.numeroLinea != 19) {
                                                                            generarErrorSemantica1(a1.numeroLinea, ES_2, a2.lexema.trim() + "<-" + a1.value);
                                                                        }
                                                                    }
                                                                }
                                                                if (!a1.lexema.trim().equals("@@@") && !a1.lexema.trim().equals("@ERROR@")) {
                                                                    objetoSem1s.getLast().setAsignacion(a2.lexema.trim() + "<-" + a1.lexema.trim());
                                                                } else {
                                                                    objetoSem1s.getLast().setAsignacion(a2.lexema.trim() + "<-" + a1.value);
                                                                }
                                                                //ed
                                                                ObjetoSem2 o2 = new ObjetoSem2(contadorSem2++);
                                                                o2.setAmbito(pila.peek());
                                                                o2.setLinea(operador.numeroLinea);
                                                                Integer aux = calcularFC(a2);
                                                                String aux2 = "";
                                                                switch (operador.lexema.trim()) {
                                                                    case "=": {
                                                                        o2.setRegla(1020 + "");
                                                                        aux2 = matrizSem1[8][aux][5];
                                                                        break;
                                                                    }
                                                                    case "+=": {
                                                                        o2.setRegla(1021 + "");
                                                                        aux2 = matrizSem1[8][aux][0];
                                                                        break;
                                                                    }
                                                                    case "-=": {
                                                                        o2.setRegla(1021 + "");
                                                                        aux2 = matrizSem1[8][aux][2];
                                                                        break;
                                                                    }
                                                                    case "*=": {
                                                                        o2.setRegla(1021 + "");
                                                                        aux2 = matrizSem1[8][aux][3];
                                                                        break;
                                                                    }
                                                                    case "**=": {
                                                                        o2.setRegla(1021 + "");
                                                                        aux2 = matrizSem1[8][aux][6];
                                                                        break;
                                                                    }
                                                                    case "/=": {
                                                                        o2.setRegla(1021 + "");
                                                                        aux2 = matrizSem1[8][aux][4];
                                                                        break;
                                                                    }
                                                                    case "//=": {
                                                                        o2.setRegla(1021 + "");
                                                                        aux2 = matrizSem1[8][aux][1];
                                                                        break;
                                                                    }
                                                                    case "%=": {
                                                                        o2.setRegla(1021 + "");
                                                                        aux2 = matrizSem1[8][aux][7];
                                                                        break;
                                                                    }
                                                                }
                                                                o2.setTopeDePila(aux2);
                                                                o2.setValorReal(a1.value.trim());
                                                                if (o2.getLinea() != 19) {
                                                                    if (aux2.contains(a1.value.trim())) {
                                                                        o2.setEstado(SEM2_A);
                                                                    } else {
                                                                        o2.setEstado(SEM2_E);
                                                                        generarErrorSemantica2(a1.numeroLinea, ES_4, a2.lexema.trim() + operador.lexema + a1.value);
                                                                    }
                                                                } else {
                                                                    o2.setEstado(SEM2_A);
                                                                }
                                                                objetoSem2s.add(o2);
                                                            }
                                                        } else {
                                                            //<editor-fold desc="Cuadruplos X=input()">
                                                            if (string.matches("[^=]+=input\\(\\)")) {
                                                                Cuadruplo c = new Cuadruplo();
                                                                c.setAccion("call");
                                                                int calls = cc.get(pila.peek()).getCall();
                                                                calls++;
                                                                cc.get(pila.peek()).setCall(calls);
                                                                c.setArg1("input");
                                                                int funciones = cc.get(pila.peek()).getFunciones();
                                                                funciones++;
                                                                cc.get(pila.peek()).setAmbito(funciones);
                                                                c.setResultado("void");
                                                                llCuadruplos.add(c);
                                                            }
                                                            //</editor-fold>
                                                            Token operador = a.get(1);
                                                            Token a2 = a.getFirst();
                                                            Ambito ambito = null;
                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                ambito = AmbitoDB.findRecordById(new Ambito(a2.lexema.trim(), pila.peek()));
                                                                if (ambito != null) {
                                                                    break;
                                                                }
                                                            }
                                                            if (ambito != null) {
                                                                String clase = ambito.getClase();
                                                                if (clase.equals(VAR) || clase.equals(PAR) || clase.equals(LIS) || clase.equals(DIC) || clase.equals(RAN) || clase.equals(ARR)) {
                                                                    ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                                    os2.setAmbito(pila.peek());
                                                                    os2.setEstado(SEM2_A);
                                                                    os2.setLinea(operador.numeroLinea);
                                                                    os2.setRegla(1090 + "");
                                                                    os2.setTopeDePila("Variable/Parámetro/Arreglo/Lista/Diccionario/Rango");
                                                                    os2.setValorReal(clase);
                                                                    objetoSem2s.add(os2);
                                                                } else {
                                                                    ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                                    os2.setAmbito(pila.peek());
                                                                    os2.setEstado(SEM2_E);
                                                                    os2.setLinea(operador.numeroLinea);
                                                                    os2.setRegla(1090 + "");
                                                                    os2.setTopeDePila("Variable/Parámetro/Arreglo/Lista/Diccionario/Rango");
                                                                    os2.setValorReal(clase);
                                                                    generarErrorSemantica2(os2.getLinea(), ES_13, a2.lexema);
                                                                    objetoSem2s.add(os2);
                                                                }
                                                            } else {
                                                                ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                                os2.setAmbito(pila.peek());
                                                                os2.setEstado(SEM2_E);
                                                                os2.setLinea(operador.numeroLinea);
                                                                os2.setRegla(1090 + "");
                                                                os2.setTopeDePila("Variable/Parámetro/Arreglo/Lista/Diccionario/Rango");
                                                                os2.setValorReal("Variable inexistente");
                                                                generarErrorSemantica2(os2.getLinea(), ES_13, a2.lexema);
                                                                objetoSem2s.add(os2);
                                                            }
                                                        }
                                                        ///ed
                                                    } else {
                                                        System.out.println("NAAAAA");
                                                        //ed
                                                        if (string.matches("[^\\[\\]]+\\[.+\\]")) {
                                                            Ambito bAmbito = null;
                                                            String nombre = a.getFirst().lexema.trim();
                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                bAmbito = AmbitoDB.findRecordById(new Ambito(nombre, pila.get(i)));
                                                                if (bAmbito != null) {
                                                                    break;
                                                                }
                                                            }
                                                            if (bAmbito == null || !bAmbito.getClase().equals(ARR)) {
                                                                String string1 = "";
                                                                for (Token token : a) {
                                                                    string1 += token.lexema.trim();
                                                                    break;
                                                                }
                                                                generarErrorSemantica2(a.getFirst().numeroLinea, ES_5, string1);
                                                            } else if (bAmbito.getClase().equals(ARR)) {
                                                                String aux4 = "";
                                                                for (int i = 1; i < a.size(); i++) {
                                                                    aux4 += a.get(i).lexema.trim();
                                                                }
                                                                aux4 = aux4.replace("[", "").trim();
                                                                aux4 = aux4.replace("]", "").trim();
                                                                String[] aux = aux4.split(":");
                                                                ObjetoSem2 o = new ObjetoSem2(contadorSem2++);
                                                                o.setAmbito(pila.peek());
                                                                o.setLinea(a.getFirst().numeroLinea);
                                                                System.out.println("N de linea: " + a.getFirst().numeroLinea);
                                                                o.setRegla(1030 + "");
                                                                switch (aux.length) {
                                                                    case 1: { //Si llamó una dimensión
                                                                        if (bAmbito.getDimensionArreglo() == 1) {
                                                                            o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimension");
                                                                        } else {
                                                                            o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimensiones");
                                                                        }
                                                                        o.setValorReal("1 dimensión");
                                                                        o.setEstado(SEM2_A);
                                                                        break;
                                                                    }
                                                                    case 2: { //Si llamó 2 dimensiones
                                                                        o.setValorReal("2 dimensiones");
                                                                        if (bAmbito.getDimensionArreglo() >= 2) {
                                                                            if (bAmbito.getDimensionArreglo() == 1) {
                                                                                o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimension");
                                                                            } else {
                                                                                o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimensiones");
                                                                            }
                                                                            o.setEstado(SEM2_A);
                                                                        } else {
                                                                            o.setTopeDePila("1 dimensión");
                                                                            o.setEstado(SEM2_E);
                                                                            generarErrorSemantica2(a.getFirst().numeroLinea, ES_6, aux4);
                                                                        }
                                                                        break;
                                                                    }
                                                                    case 3: {
                                                                        o.setValorReal("3 dimensiones");
                                                                        if (bAmbito.getDimensionArreglo() == 3) {
                                                                            o.setTopeDePila("3 dimensiones");
                                                                            o.setEstado(SEM2_A);
                                                                        } else {
                                                                            if (bAmbito.getDimensionArreglo() == 1) {
                                                                                o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimension");
                                                                            } else {
                                                                                o.setTopeDePila(bAmbito.getDimensionArreglo() + " dimensiones");
                                                                            }
                                                                            o.setEstado(SEM2_E);
                                                                            generarErrorSemantica2(a.getFirst().numeroLinea, ES_6, aux4);
                                                                        }
                                                                    }
                                                                }
                                                                objetoSem2s.add(o);
                                                                //ed
                                                                LinkedList<Token> auxiliar = new LinkedList();
                                                                for (int i = 2; i < a.size(); i++) {
                                                                    if (a.get(i).lexema.trim().equals("]")) {
                                                                        break;
                                                                    }
                                                                    auxiliar.add(a.get(i));
                                                                }
                                                                LinkedList<LinkedList<Token>> ll = new LinkedList();
                                                                ll.add(new LinkedList());
                                                                for (int i = 0; i < auxiliar.size(); i++) {
                                                                    if (auxiliar.get(i).lexema.trim().equals(":")) {
                                                                        ll.add(new LinkedList());
                                                                    } else {
                                                                        ll.getLast().add(auxiliar.get(i));
                                                                    }
                                                                }
                                                                int contador = 1;
                                                                for (LinkedList<Token> lista1 : ll) {
                                                                    ObjetoSem2 o2 = new ObjetoSem2(contadorSem2++);
                                                                    o2.setRegla(1040 + "");
                                                                    o2.setTopeDePila(DEC);
                                                                    o2.setAmbito(pila.peek());
                                                                    switch (lista1.size()) {
                                                                        case 1: {
                                                                            Token t = lista1.getFirst();
                                                                            o2.setLinea(t.numeroLinea);
                                                                            if (t.numeroToken == -3) {
                                                                                o2.setEstado(SEM2_A);
                                                                                o2.setValorReal(DEC);
                                                                            } else if (t.numeroToken == -1) {
                                                                                Ambito busqueda = null;
                                                                                for (int i = pila.size() - 1; i > -1; i--) {
                                                                                    busqueda = AmbitoDB.findRecordById(new Ambito(t.lexema.trim(), pila.get(i)));
                                                                                    if (busqueda != null) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                if (busqueda != null) {
                                                                                    if (busqueda.getTipo().equals(DEC)) {
                                                                                        o2.setEstado(SEM2_A);
                                                                                        o2.setValorReal(DEC);
                                                                                    } else {
                                                                                        if (busqueda.getTipo().equals(STR)) {
                                                                                            o2.setEstado(SEM2_E);
                                                                                            o2.setValorReal(busqueda.getClase());
                                                                                            generarErrorSemantica2(t.numeroLinea, ES_9, busqueda.getIdentificador());
                                                                                        } else {
                                                                                            o2.setEstado(SEM2_E);
                                                                                            o2.setValorReal(busqueda.getTipo());
                                                                                            generarErrorSemantica2(t.numeroLinea, ES_9, busqueda.getIdentificador());
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    o2.setEstado(SEM2_E);
                                                                                    o2.setValorReal(VAR_1);
                                                                                    generarErrorSemantica2(t.numeroLinea, ES_9, t.lexema.trim());
                                                                                }
                                                                            } else {
                                                                                o2.setEstado(SEM2_E);
                                                                                asignarValor(t);
                                                                                if (t.value != null) {
                                                                                    o2.setValorReal(t.value);
                                                                                }
                                                                                generarErrorSemantica2(t.numeroLinea, ES_9, t.lexema.trim());
                                                                            }
                                                                            objetoSem2s.add(o2);
                                                                            break;
                                                                        }
                                                                        case 2: {
                                                                            String lexError = lista1.getFirst().lexema.trim() + lista1.get(1).lexema.trim();
                                                                            Token t = lista1.getFirst();
                                                                            if (t.lexema.trim().equals("-")) {
                                                                                generarErrorSemantica2(t.numeroLinea, ES_8, lexError);
                                                                            }
                                                                            lista1.removeFirst();
                                                                            t = lista1.getFirst();
                                                                            o2.setLinea(t.numeroLinea);
                                                                            if (t.numeroToken == -3) {
                                                                                o2.setEstado(SEM2_A);
                                                                                o2.setValorReal(DEC);
                                                                            } else if (t.numeroLinea == -1) {
                                                                                Ambito busqueda = null;
                                                                                for (int i = pila.size() - 1; i > -1; i--) {
                                                                                    busqueda = AmbitoDB.findRecordById(new Ambito(t.lexema.trim(), pila.get(i)));
                                                                                    if (busqueda != null) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                if (busqueda != null) {
                                                                                    if (busqueda.getTipo().equals(DEC)) {
                                                                                        o2.setEstado(SEM2_A);
                                                                                        o2.setValorReal(DEC);
                                                                                    } else {
                                                                                        if (busqueda.getTipo().equals(STR)) {
                                                                                            o2.setEstado(SEM2_E);
                                                                                            o2.setValorReal(busqueda.getClase());
                                                                                            generarErrorSemantica2(t.numeroLinea, ES_9, busqueda.getIdentificador());
                                                                                        } else {
                                                                                            o2.setEstado(SEM2_E);
                                                                                            o2.setValorReal(busqueda.getTipo());
                                                                                            generarErrorSemantica2(t.numeroLinea, ES_9, busqueda.getIdentificador());
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    o2.setEstado(SEM2_E);
                                                                                    o2.setValorReal(VAR_1);
                                                                                    generarErrorSemantica2(t.numeroLinea, ES_9, t.lexema.trim());
                                                                                }
                                                                            } else {
                                                                                o2.setEstado(SEM2_E);
                                                                                asignarValor(t);
                                                                                if (t.value != null) {
                                                                                    o2.setValorReal(t.value);
                                                                                }
                                                                                generarErrorSemantica2(t.numeroLinea, ES_9, t.lexema.trim());
                                                                            }
                                                                            objetoSem2s.add(o2);
                                                                            break;
                                                                        }
                                                                        default: {
                                                                            String lexError = "";
                                                                            for (Token token : lista1) {
                                                                                lexError += token.lexema.trim();
                                                                            }
                                                                            if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_8, lexError);
                                                                            }
                                                                            generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_9, lexError);
                                                                            o2.setEstado(SEM2_E);
                                                                            o2.setLinea(lista1.getFirst().numeroLinea);
                                                                            o2.setValorReal("Temporal");
                                                                            objetoSem2s.add(o2);
                                                                            break;
                                                                        }
                                                                    }
                                                                    if (o2.getEstado().equals(SEM2_A)) {
                                                                        //ed
                                                                        Integer dimensionesArreglo = bAmbito.getDimensionArreglo();
                                                                        LinkedList<Ambito> parametros = AmbitoDB.encontrarParametro(bAmbito.getIdentificador(), bAmbito.getAmbito());
                                                                        int contadorNegativos = 0;
                                                                        for (Ambito ambito : parametros) {
                                                                            int n = Integer.parseInt(ambito.getValor());
                                                                            if (n < 0) {
                                                                                contadorNegativos++;
                                                                            }
                                                                        }
                                                                        boolean valido = false;
                                                                        switch (parametros.size()) {
                                                                            case 1: {
                                                                                valido = true;
                                                                                break;
                                                                            }
                                                                            case 2: {
                                                                                switch (contadorNegativos) {
                                                                                    case 2: {
                                                                                        valido = true;
                                                                                        break;
                                                                                    }
                                                                                    case 0: {
                                                                                        valido = true;
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                            case 3: {
                                                                                switch (contadorNegativos) {
                                                                                    case 3: {
                                                                                        //VALKIDO
                                                                                        valido = true;
                                                                                        break;
                                                                                    }
                                                                                    case 0: {
                                                                                        Integer p1 = Integer.parseInt(parametros.get(0).getValor());
                                                                                        Integer p2 = Integer.parseInt(parametros.get(1).getValor());
                                                                                        Integer p3 = Integer.parseInt(parametros.get(2).getValor());
                                                                                        if (p1 < p2) {
                                                                                            if (p3 < p2 - p1) {
                                                                                                valido = true;
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                    case 1: {
                                                                                        if (parametros.getLast().getValor().matches("-\\d+")) {
                                                                                            Integer p1 = Integer.parseInt(parametros.get(0).getValor());
                                                                                            Integer p2 = Integer.parseInt(parametros.get(1).getValor());
                                                                                            Integer p3 = Integer.parseInt(parametros.get(2).getValor());
                                                                                            if (p1 > p2) {
                                                                                                if (Math.abs(p3) < p1 - p2) {
                                                                                                    valido = true;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                        }
                                                                        if (valido) {
                                                                            ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                                            os2.setAmbito(pila.peek());
                                                                            os2.setLinea(lista1.getFirst().numeroLinea);
                                                                            os2.setRegla(1050 + "");
                                                                            switch (parametros.size()) {
                                                                                case 1: {
                                                                                    if (contador == 1) {
                                                                                        Integer tamanio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                        os2.setTopeDePila("0 - " + Math.abs(tamanio));
                                                                                        Integer llamada = null;
                                                                                        Token t = lista1.getFirst();
                                                                                        if (t.lexema.trim().equals("-")) {
                                                                                            t = lista1.get(1);
                                                                                        }
                                                                                        if (t.numeroToken != -1) {
                                                                                            llamada = Integer.parseInt(t.lexema.trim());
                                                                                        } else {
                                                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                                                Ambito ambito = AmbitoDB.findRecordById(new Ambito(t.lexema.trim(), pila.get(i)));
                                                                                                if (ambito != null) {
                                                                                                    llamada = Integer.parseInt(ambito.getValor());
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (llamada != null) {
                                                                                            os2.setValorReal(llamada + "");
                                                                                            if (llamada < Math.abs(tamanio)) {
                                                                                                os2.setEstado(SEM2_A);
                                                                                            } else {
                                                                                                os2.setEstado(SEM2_E);
                                                                                                generarErrorSemantica2(os2.getLinea(), ES_10, llamada + "");
                                                                                            }
                                                                                        } else {
                                                                                            System.out.println("Llamada nula");
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                case 2: {
                                                                                    if (dimensionesArreglo == 2) {
                                                                                        if (contador == 1) {
                                                                                            Integer tamanio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                            Integer llamada = null;
                                                                                            if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                            } else {
                                                                                                llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                            }
                                                                                            os2.setTopeDePila("0 - " + Math.abs(tamanio));
                                                                                            if (llamada != null) {
                                                                                                if (llamada < Math.abs(tamanio)) {
                                                                                                    os2.setEstado(SEM2_A);
                                                                                                } else {
                                                                                                    os2.setEstado(SEM2_E);
                                                                                                    generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                }
                                                                                            }
                                                                                        } else if (contador == 2) {
                                                                                            Integer tamanio = Integer.parseInt(parametros.get(1).getValor());
                                                                                            Integer llamada = null;
                                                                                            if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                            } else {
                                                                                                llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                            }
                                                                                            os2.setTopeDePila("0 - " + Math.abs(tamanio));
                                                                                            if (llamada != null) {
                                                                                                if (llamada < Math.abs(tamanio)) {
                                                                                                    os2.setEstado(SEM2_A);
                                                                                                } else {
                                                                                                    os2.setEstado(SEM2_E);
                                                                                                    generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        if (contador == 1) {
                                                                                            Integer inicio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                            Integer limite = Integer.parseInt(parametros.get(1).getValor());
                                                                                            Integer llamada = null;
                                                                                            if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                            } else {
                                                                                                llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                            }
                                                                                            os2.setValorReal(llamada + "");
                                                                                            os2.setTopeDePila(inicio + " - " + limite);
                                                                                            if (llamada >= inicio && llamada < limite) {
                                                                                                os2.setEstado(SEM2_A);
                                                                                            } else {
                                                                                                os2.setEstado(SEM2_E);
                                                                                                generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                case 3: {
                                                                                    if (dimensionesArreglo == 3) {
                                                                                        Integer tamanio = null;
                                                                                        Integer llamada = null;
                                                                                        if (contador == 1) {
                                                                                            tamanio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                        } else if (contador == 2) {
                                                                                            tamanio = Integer.parseInt(parametros.get(1).getValor());
                                                                                        } else {
                                                                                            tamanio = Integer.parseInt(parametros.get(2).getValor());
                                                                                        }
                                                                                        if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                            llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                        } else {
                                                                                            llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                        }
                                                                                        os2.setTopeDePila("0 - " + Math.abs(tamanio));
                                                                                        os2.setValorReal(llamada + "");
                                                                                        if (llamada < Math.abs(tamanio)) {
                                                                                            os2.setEstado(SEM2_A);
                                                                                        } else {
                                                                                            os2.setEstado(SEM2_E);
                                                                                            generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                        }
                                                                                    } else {
                                                                                        if (contador == 1) {
                                                                                            Integer inicio = Integer.parseInt(parametros.getFirst().getValor());
                                                                                            Integer limite = Integer.parseInt(parametros.get(1).getValor());
                                                                                            Integer incremento = Integer.parseInt(parametros.get(2).getValor());
                                                                                            Integer llamada;
                                                                                            if (lista1.getFirst().lexema.trim().equals("-")) {
                                                                                                llamada = Integer.parseInt(lista1.get(1).lexema.trim());
                                                                                            } else {
                                                                                                llamada = Integer.parseInt(lista1.getFirst().lexema.trim());
                                                                                            }
                                                                                            os2.setTopeDePila(inicio + " - " + limite + " en " + incremento);
                                                                                            os2.setValorReal(llamada + "");
                                                                                            if (incremento >= 0) {
                                                                                                if (llamada >= inicio && llamada < limite) {
                                                                                                    boolean prueba = false;
                                                                                                    for (int i = inicio; i < limite; i += incremento) {
                                                                                                        if (i == llamada) {
                                                                                                            prueba = true;
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    if (prueba) {
                                                                                                        os2.setEstado(SEM2_A);
                                                                                                    } else {
                                                                                                        os2.setEstado(SEM2_E);
                                                                                                        generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                    }
                                                                                                } else {
                                                                                                    os2.setEstado(SEM2_E);
                                                                                                    generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                }
                                                                                            } else {
                                                                                                if (llamada <= inicio && llamada > limite) {
                                                                                                    boolean prueba = false;
                                                                                                    for (int i = limite - 1; i <= inicio; i += incremento) {
                                                                                                        if (i == llamada) {
                                                                                                            prueba = true;
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    if (prueba) {
                                                                                                        os2.setEstado(SEM2_A);
                                                                                                    } else {
                                                                                                        os2.setEstado(SEM2_E);
                                                                                                        generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                    }
                                                                                                } else {
                                                                                                    os2.setEstado(SEM2_E);
                                                                                                    generarErrorSemantica2(lista1.getFirst().numeroLinea, ES_10, llamada + "");
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                            objetoSem2s.add(os2);
                                                                        }
                                                                        ///ed
                                                                    }
                                                                    contador++;
                                                                }
                                                                ///ed
                                                            }
                                                        }
                                                        ///ed
                                                    }
                                                }
                                                ejecucionAsignacionC.removeLast();
                                                ejecucionAsignacionT.removeLast();
                                                ejecucionAsignacion = false;
                                            }
                                            break;
                                            ///ed
                                        }
                                    }

                                    case 809: {
                                        System.out.println("809!!!!");
                                        if (!R1010) {
                                            R1010C.add("");
                                            R1010T.add(new LinkedList());
                                            R1010 = true;
                                        }
                                        break;
                                    }
                                    case 810: {
                                        //ed
                                        String string = R1010C.getLast();
                                        LinkedList<Token> llT = R1010T.getLast();
                                        if (!string.equals("")) {
                                            ObjetoSem2 o = new ObjetoSem2(contadorSem2++);
                                            o.setAmbito(pila.peek());
                                            o.setLinea(llT.getFirst().numeroLinea);
                                            o.setTopeDePila(BOO);
                                            //<editor-fold desc="Cuadruplos condicionales 1">
                                            Cuadruplo cuad = new Cuadruplo();
                                            //</editor-fold>
                                            if (string.matches("(i|I)(f|F).+")) {
                                                o.setRegla(1010 + "");
                                            } else if (string.matches("(w|W)(h|H)(i|I)(l|L)(e|E).+")) {
                                                o.setRegla(1011 + "");
                                                //<editor-fold desc="Cuadruplos condicionales 3">
                                                cuad.setEtiqueta("Whi-E" + contadorWhile++);
                                                //</editor-fold>
                                            } else if (string.matches("(e|E)(l|L)(i|I)(f|F).+")) {
                                                o.setRegla(1012 + "");
                                            }
                                            String aux2 = string.replace(llT.getFirst().lexema.trim(), "").trim();
                                            llT.removeFirst();
                                            if (aux2.matches("\\([^\\(\\)]+\\)")) {
                                                llT.removeFirst();
                                                llT.removeLast();
                                            }
                                            while (!llT.isEmpty()) {
                                                Token b = llT.pop();
                                                if (esOperador(b)) {
                                                    if (operadores.isEmpty()) {
                                                        operadores.add(b);
                                                    } else {
                                                        do {
                                                            if (operadores.size() == 0) {
                                                                break;
                                                            }
                                                            Token c = operadores.peek();
                                                            if (prioridad(b) <= prioridad(c)) { //***********************************************************************************************************
                                                                hacerOperacion(2);
                                                            } else {
                                                                break;
                                                            }
                                                        } while (true);
                                                        operadores.add(b);
                                                    }
                                                } else {
                                                    if (b.numeroToken == -1) {
                                                        Ambito bAmbito = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            bAmbito = AmbitoDB.findRecordById(new Ambito(b.lexema.trim(), pila.peek()));
                                                            if (bAmbito != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (bAmbito != null) {
                                                            if (!bAmbito.getTipo().trim().equals(STR)) {
                                                                b.value = bAmbito.getTipo().trim();
                                                            } else {
                                                                if (bAmbito.getClase().trim().equals(ARR)) {
                                                                    if (bAmbito.getIdentificador().trim().equals("A")) {
                                                                        LinkedList<Token> auxLL = (LinkedList) llT.clone();
                                                                        for (Token token : auxLL) {
                                                                            if (!token.equals(b)) {
                                                                                Token a = llT.pop();
                                                                                if (a.lexema.trim().equals("]")) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                b.value = bAmbito.getClase().trim();
                                                            }
                                                        } else {
                                                            b.value = VAR_1;
                                                        }
                                                    } else {
                                                        if (b.value == null) {
                                                            asignarValor(b);
                                                        }
                                                    }
                                                    operandos.add(b);
                                                }
                                            }
                                            while (operadores.size() > 0) {
                                                Token cuads1 = operandos.peek();
                                                Token cuads2 = operandos.get(operandos.size() - 2);
                                                Token cuadsOp = operadores.peek();
                                                //<editor-fold desc="Cuadruplos condicionales 5">
                                                cuad.setAccion(cuadsOp.lexema.trim());
                                                if (cuads1.value != null) {
                                                    cuad.setArg2(cuads1.lexema.trim());
                                                }
                                                if (cuads2.value != null) {
                                                    cuad.setArg1(cuads2.lexema.trim());
                                                }
                                                Token cuadsr = hacerOperacion(2);
                                                String valor = transformar(cuadsr);
                                                cuad.setResultado(valor);
                                                llCuadruplos.add(cuad);
                                                //</editor-fold>
                                            }
                                            Token r = operandos.pop();
                                            if (r.value.equals(BOO)) {
                                                o.setEstado(SEM2_A);
                                                o.setValorReal(r.value);
                                            } else {
                                                o.setEstado(SEM2_E);
                                                o.setValorReal(r.value);
                                                generarErrorSemantica2(o.getLinea(), ES_3, string);
                                            }
                                            objetoSem2s.add(o);
                                        }
                                        R1010C.removeLast();
                                        R1010T.removeLast();
                                        R1010 = false;
                                        break;
                                        ///ed
                                    }
                                    case 811: {
                                        semantica3 = true;
                                        semantica3C.add("");
                                        semantica3T.add(new LinkedList());
                                        contadorSem3++;
                                        break;
                                    }
                                    case 812: {
                                        System.out.println("Semantica3 " + contadorSem3 + ": " + semantica3C.getLast());
                                        //ed
                                        Token resultado = null;
                                        Token funcion = semantica3T.getLast().getFirst();
                                        String nombreFuncion = funcion.lexema.trim();
                                        switch (nombreFuncion) {
                                            case "len": {
                                                //ed
                                                ObjetoSem2 osi3 = new ObjetoSem2(contadorSem2++);
                                                osi3.setAmbito(pila.peek());
                                                osi3.setLinea(funcion.numeroLinea);
                                                osi3.setRegla("len");
                                                osi3.setTopeDePila("len/10");

                                                ObjetoSem2 osi2 = new ObjetoSem2(contadorSem2++);
                                                osi2.setRegla("len_P1");
                                                osi2.setAmbito(pila.peek());
                                                osi2.setLinea(funcion.numeroLinea);
                                                osi2.setTopeDePila("Valor/3");
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    parametros.add(semantica3T.getLast().get(i));
                                                }
                                                if (parametros.size() == 1) {
                                                    Token parametro = parametros.getFirst();
                                                    if (parametro.numeroToken == -1) {
                                                        if (parametro.lexema.equals("@@@")) {
                                                            String valor = parametro.value;
                                                            if (valor.equals(CAD) || valor.equals(LIS) || valor.equals(DIC) || valor.equals(TUP) || valor.equals(RAN) || valor.equals(ARR)) {
                                                                osi2.setEstado(SEM2_A);
                                                                osi2.setValorReal("id/" + valor);
                                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                                resultado.value = DEC;
                                                                osi3.setEstado(SEM2_A);
                                                                osi3.setValorReal(DEC);
                                                            } else {
                                                                osi2.setEstado(SEM2_E);
                                                                osi2.setValorReal("id/" + valor);
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.value);
                                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                                resultado.value = DEC;
                                                                osi3.setEstado(SEM2_A);
                                                                osi3.setValorReal(DEC);
                                                            }
                                                        } else {
                                                            Ambito busqueda = null;
                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                busqueda = AmbitoDB.findRecordById(new Ambito(parametro.lexema.trim(), pila.get(i)));
                                                                if (busqueda != null) {
                                                                    break;
                                                                }
                                                            }
                                                            if (busqueda == null) {
                                                                generarErrorAmbito(parametro, 633, "Ambito");
                                                                osi2.setEstado(SEM2_E);
                                                                osi2.setValorReal("id/Variante");
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                                resultado.value = DEC;
                                                                osi3.setEstado(SEM2_A);
                                                                osi3.setValorReal(DEC);
                                                            } else {
                                                                String clase = busqueda.getClase();
                                                                if (clase.equals(LIS) || clase.equals(DIC) || clase.equals(TUP) || clase.equals(RAN) || clase.equals(ARR)) {
                                                                    osi2.setEstado(SEM2_A);
                                                                    osi2.setValorReal("id/" + clase);
                                                                    resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                                    resultado.value = DEC;
                                                                    osi3.setEstado(SEM2_A);
                                                                    osi3.setValorReal(DEC);
                                                                } else if (busqueda.getTipo().equals(CAD)) {
                                                                    osi2.setEstado(SEM2_A);
                                                                    osi2.setValorReal("id/" + clase);
                                                                    resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                                    resultado.value = DEC;
                                                                    osi3.setEstado(SEM2_A);
                                                                    osi3.setValorReal(DEC);
                                                                } else {
                                                                    osi2.setEstado(SEM2_E);
                                                                    if (busqueda.getTipo().equals(STR)) {
                                                                        osi2.setValorReal("id/" + clase);
                                                                    } else {
                                                                        osi2.setValorReal("id/" + busqueda.getTipo());
                                                                    }
                                                                    resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                                    resultado.value = DEC;
                                                                    osi3.setEstado(SEM2_A);
                                                                    osi3.setValorReal(DEC);
                                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        asignarValor(parametro);
                                                        osi2.setEstado(SEM2_E);
                                                        osi2.setValorReal("id/" + parametro.value);
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                        resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                        resultado.value = DEC;
                                                        osi3.setEstado(SEM2_A);
                                                        osi3.setValorReal(DEC);
                                                    }
                                                }
                                                objetoSem2s.add(osi2);
                                                objetoSem2s.add(osi3);
                                                break;
                                                ///ed
                                            }
                                            case "sample": {
                                                //ed
                                                ObjetoSem2 osi3 = new ObjetoSem2(contadorSem2++);
                                                osi3.setAmbito(pila.peek());
                                                osi3.setLinea(funcion.numeroLinea);
                                                osi3.setRegla("sample");
                                                osi3.setTopeDePila("sample/8");

                                                ObjetoSem2 osi2 = new ObjetoSem2(contadorSem2++);
                                                osi2.setRegla("sample_P1");
                                                osi2.setAmbito(pila.peek());
                                                osi2.setLinea(funcion.numeroLinea);
                                                osi2.setTopeDePila("Valor/3");

                                                ObjetoSem2 osi2_2 = new ObjetoSem2(contadorSem2++);
                                                osi2_2.setRegla("sample_P2");
                                                osi2_2.setAmbito(pila.peek());
                                                osi2_2.setLinea(funcion.numeroLinea);
                                                osi2_2.setTopeDePila("Decimal/4");
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    if (!semantica3T.getLast().get(i).lexema.trim().equals(",")) {
                                                        parametros.add(semantica3T.getLast().get(i));
                                                    }
                                                }
                                                if (parametros.size() == 2) {
                                                    Token parametro1 = parametros.getFirst();
                                                    Token parametro2 = parametros.get(1);
                                                    boolean a1 = false;
                                                    boolean a2 = false;
                                                    //ed
                                                    if (parametro1.numeroToken == -1) {
                                                        if (parametro1.lexema.equals("@@@")) {
                                                            String valor = parametro1.value;
                                                            if (valor.equals(CAD) || valor.equals(LIS) || valor.equals(DIC) || valor.equals(TUP) || valor.equals(RAN) || valor.equals(ARR)) {
                                                                osi2.setEstado(SEM2_A);
                                                                osi2.setValorReal("id/" + valor);
                                                                a1 = true;
                                                            } else {
                                                                osi2.setEstado(SEM2_E);
                                                                osi2.setValorReal("id/" + valor);
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.value);
                                                            }
                                                        } else {
                                                            Ambito busqueda = null;
                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                busqueda = AmbitoDB.findRecordById(new Ambito(parametro1.lexema.trim(), pila.get(i)));
                                                                if (busqueda != null) {
                                                                    break;
                                                                }
                                                            }
                                                            if (busqueda == null) {
                                                                generarErrorAmbito(parametro1, 633, "Ambito");
                                                                osi2.setEstado(SEM2_E);
                                                                osi2.setValorReal("id/Variante");
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                            } else {
                                                                String clase = busqueda.getClase();
                                                                if (clase.equals(LIS) || clase.equals(DIC) || clase.equals(TUP) || clase.equals(RAN) || clase.equals(ARR)) {
                                                                    osi2.setEstado(SEM2_A);
                                                                    osi2.setValorReal("id/" + clase);
                                                                    a1 = true;
                                                                } else if (busqueda.getTipo().equals(CAD)) {
                                                                    osi2.setEstado(SEM2_A);
                                                                    osi2.setValorReal("id/" + clase);
                                                                    a1 = true;
                                                                } else {
                                                                    osi2.setEstado(SEM2_E);
                                                                    if (busqueda.getTipo().equals(STR)) {
                                                                        osi2.setValorReal("id/" + clase);
                                                                    } else {
                                                                        osi2.setValorReal("id/" + busqueda.getTipo());
                                                                    }
                                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        asignarValor(parametro1);
                                                        osi2.setEstado(SEM2_E);
                                                        osi2.setValorReal("id/" + parametro1.value);
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                    }
                                                    ///ed
                                                    //ed
                                                    if (parametro2.numeroToken == -1) {
                                                        if (parametro2.lexema.equals("@@@")) {
                                                            String valor = parametro2.value;
                                                            if (valor.equals(DEC)) {
                                                                osi2_2.setEstado(SEM2_A);
                                                                osi2_2.setValorReal("id/" + valor);
                                                                a2 = true;
                                                            } else {
                                                                osi2_2.setEstado(SEM2_E);
                                                                osi2_2.setValorReal("id/" + valor);
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.value);
                                                            }
                                                        } else {
                                                            Ambito busqueda = null;
                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                busqueda = AmbitoDB.findRecordById(new Ambito(parametro2.lexema.trim(), pila.get(i)));
                                                                if (busqueda != null) {
                                                                    break;
                                                                }
                                                            }
                                                            if (busqueda == null) {
                                                                generarErrorAmbito(parametro2, 633, "Ambito");
                                                                osi2_2.setEstado(SEM2_E);
                                                                osi2_2.setValorReal("id/Variante");
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.lexema);
                                                            } else {
                                                                String clase = busqueda.getTipo();
                                                                if (clase.equals(DEC)) {
                                                                    osi2_2.setEstado(SEM2_A);
                                                                    osi2_2.setValorReal("id/" + clase);
                                                                    a2 = true;
                                                                } else {
                                                                    osi2_2.setEstado(SEM2_E);
                                                                    if (busqueda.getTipo().equals(STR)) {
                                                                        osi2_2.setValorReal("id/" + clase);
                                                                    } else {
                                                                        osi2_2.setValorReal("id/" + busqueda.getTipo());
                                                                    }
                                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.lexema);
                                                                }
                                                            }
                                                        }
                                                    } else if (parametro2.numeroToken == -3) {
                                                        osi2_2.setEstado(SEM2_A);
                                                        osi2_2.setValorReal("Valor/" + DEC);
                                                        a2 = true;
                                                    } else {
                                                        asignarValor(parametro2);
                                                        osi2_2.setEstado(SEM2_E);
                                                        osi2_2.setValorReal("Valor/" + parametro2.value);
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.lexema);
                                                    }
                                                    ///ed
                                                    resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                    osi3.setEstado(SEM2_A);
                                                    resultado.value = LIS;
                                                    osi3.setValorReal(LIS);
                                                }
                                                objetoSem2s.add(osi2);
                                                objetoSem2s.add(osi2_2);
                                                objetoSem2s.add(osi3);
                                                break;
                                                ///ed
                                            }
                                            case "choice": {
                                                //<editor-fold defaultstate="collapsed" desc="Choice">
                                                ObjetoSem2 osi3 = new ObjetoSem2(contadorSem2++);
                                                osi3.setAmbito(pila.peek());
                                                osi3.setLinea(funcion.numeroLinea);
                                                osi3.setRegla("choice");
                                                osi3.setTopeDePila("choice/11");

                                                ObjetoSem2 osi2 = new ObjetoSem2(contadorSem2++);
                                                osi2.setRegla("choice_P1");
                                                osi2.setAmbito(pila.peek());
                                                osi2.setLinea(funcion.numeroLinea);
                                                osi2.setTopeDePila("Valor/3");

                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    if (!semantica3T.getLast().get(i).lexema.trim().equals(",")) {
                                                        parametros.add(semantica3T.getLast().get(i));
                                                    }
                                                }
                                                if (parametros.size() == 1) {
                                                    Token parametro1 = parametros.getFirst();
                                                    boolean a1 = false;
                                                    if (parametro1.numeroToken == -1) {
                                                        if (parametro1.lexema.equals("@@@")) {
                                                            String valor = parametro1.value;
                                                            if (valor.equals(CAD) || valor.equals(LIS) || valor.equals(DIC) || valor.equals(TUP) || valor.equals(RAN) || valor.equals(ARR)) {
                                                                osi2.setEstado(SEM2_A);
                                                                osi2.setValorReal("id/" + valor);
                                                                a1 = true;
                                                                if (valor.equals(CAD)) {
                                                                    resultado.value = CHA;
                                                                } else if (valor.equals(ARR) || valor.equals(RAN)) {
                                                                    resultado.value = DEC;
                                                                } else {
                                                                    resultado.value = CAD;
                                                                }
                                                                osi3.setEstado(SEM2_A);
                                                                osi3.setValorReal(resultado.value);
                                                            } else {
                                                                osi2.setEstado(SEM2_E);
                                                                osi2.setValorReal("id/" + valor);
                                                                osi3.setEstado(SEM2_A);
                                                                resultado.value = VAR_1;
                                                                osi3.setValorReal(resultado.value);
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.value);
                                                            }
                                                        } else {
                                                            Ambito busqueda = null;
                                                            for (int i = pila.size() - 1; i > -1; i--) {
                                                                busqueda = AmbitoDB.findRecordById(new Ambito(parametro1.lexema.trim(), pila.get(i)));
                                                                if (busqueda != null) {
                                                                    break;
                                                                }
                                                            }
                                                            if (busqueda == null) {
                                                                generarErrorAmbito(parametro1, 633, "Ambito");
                                                                osi2.setEstado(SEM2_E);
                                                                osi2.setValorReal("id/Variante");
                                                                osi3.setEstado(SEM2_A);
                                                                osi3.setValorReal(VAR_1);
                                                                resultado.value = VAR_1;
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                            } else {
                                                                String clase = busqueda.getClase();
                                                                if (clase.equals(LIS) || clase.equals(DIC) || clase.equals(TUP) || clase.equals(RAN) || clase.equals(ARR)) {
                                                                    osi2.setEstado(SEM2_A);
                                                                    osi2.setValorReal("id/" + clase);
                                                                    osi3.setEstado(SEM2_A);
                                                                    a1 = true;
                                                                    if (clase.equals(RAN) || clase.equals(ARR)) {
                                                                        osi3.setValorReal(DEC);
                                                                    } else {
                                                                        LinkedList<Ambito> ll = AmbitoDB.encontrarParametro(busqueda.getIdentificador(), busqueda.getAmbito() + 1);
                                                                        Random random = new Random();
                                                                        int r = random.nextInt(ll.size());
                                                                        Ambito r2 = ll.get(r);
                                                                        osi3.setValorReal(r2.getTipo());
                                                                        resultado.value = r2.getTipo();
                                                                    }

                                                                } else if (busqueda.getTipo().equals(CAD)) {
                                                                    osi2.setEstado(SEM2_A);
                                                                    osi2.setValorReal("id/" + clase);
                                                                    a1 = true;
                                                                    osi3.setValorReal(CHA);
                                                                    resultado.value = CHA;
                                                                } else {
                                                                    osi2.setEstado(SEM2_E);
                                                                    if (busqueda.getTipo().equals(STR)) {
                                                                        osi2.setValorReal("id/" + clase);
                                                                    } else {
                                                                        osi2.setValorReal("id/" + busqueda.getTipo());
                                                                    }
                                                                    osi3.setValorReal(VAR_1);
                                                                    resultado.value = VAR_1;
                                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        asignarValor(parametro1);
                                                        osi2.setEstado(SEM2_E);
                                                        osi2.setValorReal("id/" + parametro1.value);
                                                        osi3.setValorReal(VAR_1);
                                                        resultado.value = VAR_1;
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                    }
                                                }
                                                objetoSem2s.add(osi2);
                                                objetoSem2s.add(osi3);
                                                break;
                                                //</editor-fold>
                                            }
                                            case "randrange": {
                                                //<editor-fold defaultstate="collapsed" desc="randrange">
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    if (!semantica3T.getLast().get(i).lexema.trim().equals(",")) {
                                                        parametros.add(semantica3T.getLast().get(i));
                                                    }
                                                }

                                                //<editor-fold defaultstate="collapsed" desc="parametro 1 randrange">
                                                ObjetoSem2 par1 = new ObjetoSem2(contadorSem2++);
                                                par1.setRegla("randrange_P1");
                                                par1.setAmbito(pila.peek());
                                                par1.setLinea(funcion.numeroLinea);
                                                par1.setTopeDePila("Decimal/4");
                                                Token parametro1 = parametros.getFirst();
                                                if (parametro1.numeroToken == -1) {
                                                    if (parametro1.lexema.trim().equals("@@@")) {
                                                        if (parametro1.value.equals(DEC)) {
                                                            par1.setEstado(SEM2_A);
                                                            par1.setValorReal("id/Decimal");
                                                        } else {
                                                            par1.setEstado(SEM2_A);
                                                            par1.setValorReal("id/" + parametro1.value);
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.value);
                                                        }
                                                    } else {
                                                        Ambito busqueda = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            busqueda = AmbitoDB.findRecordById(new Ambito(parametro1.lexema.trim(), pila.get(i)));
                                                            if (busqueda != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (busqueda != null) {
                                                            if (busqueda.getTipo().equals(DEC)) {
                                                                par1.setEstado(SEM2_A);
                                                                par1.setValorReal("id/Decimal");
                                                            } else {
                                                                par1.setEstado(SEM2_E);
                                                                if (busqueda.getTipo().equals(STR)) {
                                                                    par1.setValorReal("id/" + busqueda.getClase());
                                                                } else {
                                                                    par1.setValorReal("id/" + busqueda.getTipo());
                                                                }
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                            }
                                                        } else {
                                                            par1.setEstado(SEM2_E);
                                                            par1.setValorReal("id/Variante");
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                        }
                                                    }
                                                } else if (parametro1.numeroToken == -3) {
                                                    par1.setEstado(SEM2_A);
                                                    par1.setValorReal("Valor/Decimal");
                                                } else {
                                                    par1.setEstado(SEM2_E);
                                                    asignarValor(parametro1);
                                                    par1.setValorReal("Valor/" + parametro1.value);
                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema);
                                                }
                                                //</editor-fold>

                                                //<editor-fold defaultstate="collapsed" desc="parametro 2 randrange">
                                                ObjetoSem2 par2 = new ObjetoSem2(contadorSem2++);
                                                par2.setRegla("randrange_P2");
                                                par2.setAmbito(pila.peek());
                                                par2.setLinea(funcion.numeroLinea);
                                                par2.setTopeDePila("Decimal/4");
                                                Token parametro2 = parametros.get(1);
                                                if (parametro2.numeroToken == -1) {
                                                    if (parametro2.lexema.trim().equals("@@@")) {
                                                        if (parametro2.value.equals(DEC)) {
                                                            par2.setEstado(SEM2_A);
                                                            par2.setValorReal("id/Decimal");
                                                        } else {
                                                            par2.setEstado(SEM2_A);
                                                            par2.setValorReal("id/" + parametro2.value);
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.value);
                                                        }
                                                    } else {
                                                        Ambito busqueda = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            busqueda = AmbitoDB.findRecordById(new Ambito(parametro2.lexema.trim(), pila.get(i)));
                                                            if (busqueda != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (busqueda != null) {
                                                            if (busqueda.getTipo().equals(DEC)) {
                                                                par2.setEstado(SEM2_A);
                                                                par2.setValorReal("id/Decimal");
                                                            } else {
                                                                par2.setEstado(SEM2_E);
                                                                if (busqueda.getTipo().equals(STR)) {
                                                                    par2.setValorReal("id/" + busqueda.getClase());
                                                                } else {
                                                                    par2.setValorReal("id/" + busqueda.getTipo());
                                                                }
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.lexema);
                                                            }
                                                        } else {
                                                            par2.setEstado(SEM2_E);
                                                            par2.setValorReal("id/Variante");
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.lexema);
                                                        }
                                                    }
                                                } else if (parametro2.numeroToken == -3) {
                                                    par2.setEstado(SEM2_A);
                                                    par2.setValorReal("Valor/Decimal");
                                                } else {
                                                    par2.setEstado(SEM2_E);
                                                    asignarValor(parametro2);
                                                    par2.setValorReal("Valor/" + parametro2.value);
                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.lexema);
                                                }
                                                //</editor-fold>

                                                ObjetoSem2 salida = new ObjetoSem2(contadorSem2++);
                                                salida.setAmbito(pila.peek());
                                                salida.setLinea(funcion.numeroLinea);
                                                salida.setRegla("randrange");
                                                salida.setTopeDePila("randrange/10");
                                                salida.setEstado(SEM2_A);
                                                if (par1.getEstado().equals(SEM2_A) && par1.getEstado().equals(SEM2_A)) {
                                                    salida.setValorReal(DEC);
                                                } else {
                                                    salida.setValorReal(VAR_1);
                                                }
//                                                osi3.setEstado(SEM2_A);
//                                                osi3.setValorReal("Decimal"); 

                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                if (salida.getValorReal().equals(DEC)) {
                                                    resultado.value = DEC;
                                                } else {
                                                    resultado.value = VAR_1;
                                                }
//                                                resultado.value = DEC;
                                                objetoSem2s.add(par1);
                                                objetoSem2s.add(par2);
                                                objetoSem2s.add(salida);
                                                break;
                                                //</editor-fold>
                                            }
                                            case "variance": {
                                                //<editor-fold desc="Variance">
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    if (!semantica3T.getLast().get(i).lexema.trim().equals(",")) {
                                                        parametros.add(semantica3T.getLast().get(i));
                                                    }
                                                }

                                                ObjetoSem2 entrada = new ObjetoSem2(contadorSem2++);
                                                entrada.setRegla("variance_P1");
                                                entrada.setAmbito(pila.peek());
                                                entrada.setLinea(funcion.numeroLinea);
                                                entrada.setTopeDePila("Arreglo/6");
                                                Token parametro = parametros.getFirst();
                                                if (parametro.numeroToken == -1) {
                                                    if (parametro.lexema.trim().equals("@@@")) {
                                                        if (parametro.value.equals(ARR)) {
                                                            entrada.setEstado(SEM2_A);
                                                            entrada.setValorReal("id/Arreglo");
                                                        } else {
                                                            entrada.setEstado(SEM2_E);
                                                            entrada.setValorReal("id/" + parametro.value);
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.value);
                                                        }
                                                    } else {
                                                        Ambito busqueda = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            busqueda = AmbitoDB.findRecordById(new Ambito(parametro.lexema.trim(), pila.get(i)));
                                                            if (busqueda != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (busqueda != null) {
                                                            if (busqueda.getClase().equals(ARR)) {
                                                                entrada.setEstado(SEM2_A);
                                                                entrada.setValorReal("id/Arreglo");
                                                            } else {
                                                                entrada.setEstado(SEM2_E);
                                                                if (busqueda.getTipo().equals(STR)) {
                                                                    entrada.setValorReal("id/" + busqueda.getClase());
                                                                } else {
                                                                    entrada.setValorReal("id/" + busqueda.getTipo());
                                                                }
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                            }
                                                        } else {
                                                            entrada.setEstado(SEM2_A);
                                                            entrada.setValorReal("id/Variante");
                                                        }
                                                    }
                                                } else {
                                                    entrada.setEstado(SEM2_E);
                                                    asignarValor(parametro);
                                                    entrada.setValorReal("Valor/" + parametro.value);
                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                }

                                                ObjetoSem2 salida = new ObjetoSem2(contadorSem2++);
                                                salida.setAmbito(pila.peek());
                                                salida.setLinea(funcion.numeroLinea);
                                                salida.setRegla("variance");
                                                salida.setTopeDePila("variance/12");
                                                salida.setEstado(SEM2_A);
                                                if (entrada.getEstado().equals(SEM2_A)) {
                                                    salida.setValorReal("Flotante");
                                                } else {
                                                    salida.setValorReal("Variante");
                                                }

                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                if (entrada.getEstado().equals(SEM2_A)) {
                                                    resultado.value = FLO;
                                                } else {
                                                    resultado.value = VAR_1;
                                                }
                                                objetoSem2s.add(entrada);
                                                objetoSem2s.add(salida);
                                                break;
                                                //</editor-fold>
                                            }
                                            case "replace": {
                                                //<editor-fold desc="replace">
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    if (!semantica3T.getLast().get(i).lexema.trim().equals(",")) {
                                                        parametros.add(semantica3T.getLast().get(i));
                                                    }
                                                }

                                                ObjetoSem2 entrada1 = new ObjetoSem2(contadorSem2++);
                                                entrada1.setRegla("replace_P1");
                                                entrada1.setAmbito(pila.peek());
                                                entrada1.setLinea(funcion.numeroLinea);
                                                entrada1.setTopeDePila("Cadena/1");
                                                Token parametro1 = parametros.getFirst();
                                                if (parametro1.numeroToken == -1) {
                                                    if (parametro1.lexema.trim().equals("@@@")) {
                                                        if (parametro1.value.equals(CAD)) {
                                                            entrada1.setEstado(SEM2_A);
                                                            entrada1.setValorReal("id/" + CAD);
                                                        } else {
                                                            entrada1.setEstado(SEM2_E);
                                                            entrada1.setValorReal("id/" + parametro1.value);
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.value);
                                                        }
                                                    } else {
                                                        Ambito busqueda = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            busqueda = AmbitoDB.findRecordById(new Ambito(parametro1.lexema.trim(), pila.get(i)));
                                                            if (busqueda != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (busqueda != null) {
                                                            if (busqueda.getTipo().equals(CAD)) {
                                                                entrada1.setEstado(SEM2_A);
                                                                entrada1.setValorReal("id/" + CAD);
                                                            } else {
                                                                entrada1.setEstado(SEM2_E);
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.lexema.trim());
                                                                if (busqueda.getTipo().equals(STR)) {
                                                                    entrada1.setValorReal("id/" + busqueda.getClase());
                                                                } else {
                                                                    entrada1.setValorReal("id/" + busqueda.getTipo());
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (parametro1.numeroToken == -7) {
                                                        entrada1.setEstado(SEM2_A);
                                                        entrada1.setValorReal("Valor/" + CAD);
                                                    } else {
                                                        entrada1.setEstado(SEM2_E);
                                                        asignarValor(parametro1);
                                                        entrada1.setValorReal("Valor/" + parametro1.value);
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro1.value);
                                                    }
                                                }
//                                                entrada1.setEstado(SEM2_A);
//                                                entrada1.setValorReal("id/Arreglo");

                                                ObjetoSem2 entrada2 = new ObjetoSem2(contadorSem2++);
                                                entrada2.setRegla("replace_P2");
                                                entrada2.setAmbito(pila.peek());
                                                entrada2.setLinea(funcion.numeroLinea);
                                                entrada2.setTopeDePila("Cadena/1");
                                                Token parametro2 = parametros.get(1);
                                                if (parametro2.numeroToken == -1) {
                                                    if (parametro2.lexema.trim().equals("@@@")) {
                                                        if (parametro2.value.equals(CAD)) {
                                                            entrada2.setEstado(SEM2_A);
                                                            entrada2.setValorReal("id/" + CAD);
                                                        } else {
                                                            entrada2.setEstado(SEM2_E);
                                                            entrada2.setValorReal("id/" + parametro2.value);
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.value);
                                                        }
                                                    } else {
                                                        Ambito busqueda = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            busqueda = AmbitoDB.findRecordById(new Ambito(parametro2.lexema.trim(), pila.get(i)));
                                                            if (busqueda != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (busqueda != null) {
                                                            if (busqueda.getTipo().equals(CAD)) {
                                                                entrada2.setEstado(SEM2_A);
                                                                entrada2.setValorReal("id/" + CAD);
                                                            } else {
                                                                entrada2.setEstado(SEM2_E);
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.lexema.trim());
                                                                if (busqueda.getTipo().equals(STR)) {
                                                                    entrada2.setValorReal("id/" + busqueda.getClase());
                                                                } else {
                                                                    entrada2.setValorReal("id/" + busqueda.getTipo());
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (parametro2.numeroToken == -7) {
                                                        entrada2.setEstado(SEM2_A);
                                                        entrada2.setValorReal("Valor/" + CAD);
                                                    } else {
                                                        entrada2.setEstado(SEM2_E);
                                                        asignarValor(parametro2);
                                                        entrada2.setValorReal("Valor/" + parametro2.value);
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro2.value);
                                                    }
                                                }

                                                ObjetoSem2 entrada3 = new ObjetoSem2(contadorSem2++);
                                                entrada3.setRegla("replace_P3");
                                                entrada3.setAmbito(pila.peek());
                                                entrada3.setLinea(funcion.numeroLinea);
                                                entrada3.setTopeDePila("Cadena/1");
                                                Token parametro3 = parametros.get(2);
                                                if (parametro3.numeroToken == -1) {
                                                    if (parametro3.lexema.trim().equals("@@@")) {
                                                        if (parametro3.value.equals(CAD)) {
                                                            entrada3.setEstado(SEM2_A);
                                                            entrada3.setValorReal("id/" + CAD);
                                                        } else {
                                                            entrada3.setEstado(SEM2_E);
                                                            entrada3.setValorReal("id/" + parametro3.value);
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro3.value);
                                                        }
                                                    } else {
                                                        Ambito busqueda = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            busqueda = AmbitoDB.findRecordById(new Ambito(parametro3.lexema.trim(), pila.get(i)));
                                                            if (busqueda != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (busqueda != null) {
                                                            if (busqueda.getTipo().equals(CAD)) {
                                                                entrada3.setEstado(SEM2_A);
                                                                entrada3.setValorReal("id/" + CAD);
                                                            } else {
                                                                entrada3.setEstado(SEM2_E);
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro3.lexema.trim());
                                                                if (busqueda.getTipo().equals(STR)) {
                                                                    entrada3.setValorReal("id/" + busqueda.getClase());
                                                                } else {
                                                                    entrada3.setValorReal("id/" + busqueda.getTipo());
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (parametro3.numeroToken == -7) {
                                                        entrada3.setEstado(SEM2_A);
                                                        entrada3.setValorReal("Valor/" + CAD);
                                                    } else {
                                                        entrada3.setEstado(SEM2_E);
                                                        asignarValor(parametro3);
                                                        entrada3.setValorReal("Valor/" + parametro3.value);
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro3.value);
                                                    }
                                                }
                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");

                                                ObjetoSem2 salida = new ObjetoSem2(contadorSem2++);
                                                salida.setAmbito(pila.peek());
                                                salida.setLinea(funcion.numeroLinea);
                                                salida.setRegla("replace");
                                                salida.setTopeDePila("replace/9");
                                                salida.setEstado(SEM2_A);
                                                salida.setValorReal(CAD);
                                                resultado.value = CAD;
                                                objetoSem2s.add(entrada1);
                                                objetoSem2s.add(entrada2);
                                                objetoSem2s.add(entrada3);
                                                objetoSem2s.add(salida);
                                                break;
                                                //</editor-fold>
                                            }
                                            case "sum": {
                                                //<editor-fold desc="sum">
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    if (!semantica3T.getLast().get(i).lexema.trim().equals(",")) {
                                                        parametros.add(semantica3T.getLast().get(i));
                                                    }
                                                }

                                                ObjetoSem2 entrada = new ObjetoSem2(contadorSem2++);
                                                entrada.setRegla("sum_P1");
                                                entrada.setAmbito(pila.peek());
                                                entrada.setLinea(funcion.numeroLinea);
                                                entrada.setTopeDePila("Arreglo/6");
                                                Token parametro = parametros.getFirst();
                                                if (parametro.numeroToken == -1) {
                                                    if (parametro.lexema.trim().equals("@@@")) {
                                                        if (parametro.value.equals(ARR)) {
                                                            entrada.setEstado(SEM2_A);
                                                            entrada.setValorReal("id/Arreglo");
                                                        } else {
                                                            entrada.setEstado(SEM2_E);
                                                            entrada.setValorReal("id/" + parametro.value);
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                        }
                                                    } else {
                                                        Ambito busqueda = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            busqueda = AmbitoDB.findRecordById(new Ambito(parametro.lexema.trim(), pila.get(i)));
                                                            if (busqueda != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (busqueda != null) {
                                                            if (busqueda.getClase().equals(ARR)) {
                                                                entrada.setEstado(SEM2_A);
                                                                entrada.setValorReal("id/Arreglo");
                                                            } else {
                                                                entrada.setEstado(SEM2_E);
                                                                if (busqueda.getTipo().equals(STR)) {
                                                                    entrada.setValorReal("id/" + busqueda.getClase());
                                                                } else {
                                                                    entrada.setValorReal("id/" + busqueda.getTipo());
                                                                }
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                            }
                                                        } else {
                                                            entrada.setEstado(SEM2_A);
                                                            entrada.setValorReal("id/Variante");
                                                        }
                                                    }
                                                } else {
                                                    entrada.setEstado(SEM2_E);
                                                    asignarValor(parametro);
                                                    entrada.setValorReal("Valor/" + parametro.value);
                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                }

                                                ObjetoSem2 salida = new ObjetoSem2(contadorSem2++);
                                                salida.setAmbito(pila.peek());
                                                salida.setLinea(funcion.numeroLinea);
                                                salida.setRegla("sum");
                                                salida.setTopeDePila("sum/13");
                                                salida.setEstado(SEM2_A);
                                                if (entrada.getEstado().equals(SEM2_A)) {
                                                    salida.setValorReal(DEC);
                                                } else {
                                                    salida.setValorReal("Variante");
                                                }

                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                resultado.value = DEC;
                                                objetoSem2s.add(entrada);
                                                objetoSem2s.add(salida);
                                                break;
                                                //</editor-fold>
                                            }
                                            case "remove": {
                                                //<editor-fold desc="remove">
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    if (!semantica3T.getLast().get(i).lexema.trim().equals(",")) {
                                                        parametros.add(semantica3T.getLast().get(i));
                                                    }
                                                }

                                                ObjetoSem2 entrada = new ObjetoSem2(contadorSem2++);
                                                entrada.setAmbito(pila.peek());
                                                entrada.setLinea(funcion.numeroLinea);
                                                entrada.setRegla("remove_P1");
                                                entrada.setTopeDePila("Valor/7");
                                                Token parametro = parametros.getFirst();
                                                if (parametro.numeroToken == -3) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Decimal");
                                                } else if (parametro.numeroToken == -8) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Flotante");
                                                } else if (parametro.numeroToken == -5) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Hexadecimal");
                                                } else if (parametro.numeroToken == -6) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Octal");
                                                } else if (parametro.numeroToken == -4) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Binario");
                                                } else if (parametro.numeroToken == -9) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Complejo");
                                                } else if (parametro.numeroToken == -7) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Cadena");
                                                } else if (parametro.numeroToken == -10) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Caracter");
                                                } else {
                                                    entrada.setEstado(SEM2_E);
                                                    asignarValor(parametro);
                                                    entrada.setValorReal("Valor/" + parametro.value);
                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                }

                                                ObjetoSem2 uso = new ObjetoSem2(contadorSem2++);
                                                uso.setAmbito(pila.peek());
                                                uso.setLinea(funcion.numeroLinea);
                                                uso.setRegla("remove");
                                                uso.setTopeDePila("remove/19");
                                                Token identificador = null;
                                                if (semantica3T.size() > 1) {
                                                    identificador = semantica3T.get(semantica3T.size() - 2).get(semantica3T.get(semantica3T.size() - 2).size() - 2);
                                                    semantica3T.get(semantica3T.size() - 2).removeLast();
                                                    semantica3T.get(semantica3T.size() - 2).removeLast();
                                                    System.out.println("identificador: " + identificador.lexema);
                                                } else if (this.ejecucionAsignacion) {
                                                    identificador = ejecucionAsignacionT.getLast().get(ejecucionAsignacionT.getLast().size() - 2);
                                                    ejecucionAsignacionT.getLast().removeLast();
                                                    ejecucionAsignacionT.getLast().removeLast();
                                                    System.out.println("identificador: " + identificador.lexema);
                                                } else if (R1010) {
                                                    identificador = R1010T.getLast().get(R1010T.getLast().size() - 2);
                                                    R1010T.getLast().removeLast();
                                                    R1010T.getLast().removeLast();
                                                    System.out.println("identificador: " + identificador.lexema);
                                                }
                                                if (identificador != null) {
                                                    Ambito busqueda = null;
                                                    for (int i = pila.size() - 1; i >= 0; i--) {
                                                        busqueda = AmbitoDB.findRecordById(new Ambito(identificador.lexema.trim(), pila.get(i)));
                                                        if (busqueda != null) {
                                                            break;
                                                        }
                                                    }
                                                    if (busqueda != null) {
                                                        if (busqueda.getClase().equals(ARR) || busqueda.getClase().equals(LIS)) {
                                                            uso.setEstado(SEM2_A);
                                                            uso.setValorReal("id/" + busqueda.getClase());
                                                        } else {
                                                            uso.setEstado(SEM2_E);
                                                            if (busqueda.getTipo().equals(STR)) {
                                                                uso.setValorReal("id/" + busqueda.getClase());
                                                            } else {
                                                                uso.setValorReal("id/" + busqueda.getTipo());
                                                            }
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_15, identificador.lexema.trim());
                                                        }
                                                    } else {
                                                        uso.setEstado(SEM2_E);
                                                        if (busqueda.getTipo().equals(STR)) {
                                                            uso.setValorReal("id/" + busqueda.getClase());
                                                        } else {
                                                            uso.setValorReal("id/" + busqueda.getTipo());
                                                        }
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_15, identificador.lexema.trim());
                                                    }
                                                } else {
                                                    System.out.println("id es nulo");
                                                }
                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");
                                                resultado.value = VAR_1;
                                                objetoSem2s.add(uso);
                                                objetoSem2s.add(entrada);
                                                break;
                                                //</editor-fold>
                                            }
                                            case "pop": {
                                                //<editor-fold desc="pop">
                                                LinkedList<Token> parametros = new LinkedList();
                                                for (int i = 2; i < semantica3T.getLast().size() - 1; i++) {
                                                    if (!semantica3T.getLast().get(i).lexema.trim().equals(",")) {
                                                        parametros.add(semantica3T.getLast().get(i));
                                                    }
                                                }

                                                ObjetoSem2 entrada = new ObjetoSem2(contadorSem2++);
                                                entrada.setAmbito(pila.peek());
                                                entrada.setLinea(funcion.numeroLinea);
                                                entrada.setRegla("pop_P1");
                                                entrada.setTopeDePila("Decimal/4");
                                                Token parametro = parametros.getFirst();
                                                Integer parNum = null;
                                                if (parametro.numeroToken == -3) {
                                                    entrada.setEstado(SEM2_A);
                                                    entrada.setValorReal("Valor/Decimal");
                                                    parNum = Integer.parseInt(parametro.lexema.trim());
                                                } else if (parametro.numeroToken == -1) {
                                                    if (parametro.lexema.trim().equals("@@@")) {
                                                        if (parametro.value.equals(DEC)) {
                                                            entrada.setEstado(SEM2_A);
                                                            entrada.setValorReal("id/Decimal");
                                                        } else {
                                                            entrada.setEstado(SEM2_E);
                                                            entrada.setValorReal("id/" + parametro.value);
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.value);
                                                        }
                                                    } else {
                                                        Ambito busqueda = null;
                                                        for (int i = pila.size() - 1; i >= 0; i--) {
                                                            busqueda = AmbitoDB.findRecordById(new Ambito(parametro.lexema.trim(), pila.get(i)));
                                                            if (busqueda != null) {
                                                                break;
                                                            }
                                                        }
                                                        if (busqueda != null) {
                                                            if (busqueda.getTipo().equals(DEC)) {
                                                                entrada.setEstado(SEM2_A);
                                                                entrada.setValorReal("id/Decimal");
                                                            } else {
                                                                entrada.setEstado(SEM2_E);
                                                                if (busqueda.getTipo().equals(STR)) {
                                                                    entrada.setValorReal("id/" + busqueda.getClase());
                                                                } else {
                                                                    entrada.setValorReal("id/" + busqueda.getTipo());
                                                                }
                                                                generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                            }
                                                        } else {
                                                            entrada.setEstado(SEM2_E);
                                                            entrada.setValorReal("id/Variante");
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                        }
                                                    }
                                                } else {
                                                    entrada.setEstado(SEM2_E);
                                                    asignarValor(parametro);
                                                    entrada.setValorReal("Valor/" + parametro.value);
                                                    generarErrorSemantica3(funcion.numeroLinea, ES_14, parametro.lexema);
                                                }

                                                ObjetoSem2 uso = new ObjetoSem2(contadorSem2++);
                                                uso.setAmbito(pila.peek());
                                                uso.setLinea(funcion.numeroLinea);
                                                uso.setRegla("pop");
                                                uso.setTopeDePila("pop/19");
                                                Token identificador = null;
                                                if (semantica3T.size() > 1) {
                                                    identificador = semantica3T.get(semantica3T.size() - 2).get(semantica3T.get(semantica3T.size() - 2).size() - 2);
                                                    semantica3T.get(semantica3T.size() - 2).removeLast();
                                                    semantica3T.get(semantica3T.size() - 2).removeLast();
                                                    System.out.println("identificador: " + identificador.lexema);
                                                } else if (this.ejecucionAsignacion) {
                                                    identificador = ejecucionAsignacionT.getLast().get(ejecucionAsignacionT.getLast().size() - 2);
                                                    ejecucionAsignacionT.getLast().removeLast();
                                                    ejecucionAsignacionT.getLast().removeLast();
                                                    System.out.println("identificador: " + identificador.lexema);
                                                } else if (R1010) {
                                                    identificador = R1010T.getLast().get(R1010T.getLast().size() - 2);
                                                    R1010T.getLast().removeLast();
                                                    R1010T.getLast().removeLast();
                                                    System.out.println("identificador: " + identificador.lexema);
                                                }
                                                if (identificador != null) {
                                                    Ambito busqueda = null;
                                                    for (int i = pila.size() - 1; i >= 0; i--) {
                                                        busqueda = AmbitoDB.findRecordById(new Ambito(identificador.lexema.trim(), pila.get(i)));
                                                        if (busqueda != null) {
                                                            break;
                                                        }
                                                    }
                                                    if (busqueda != null) {
                                                        if (busqueda.getClase().equals(ARR) || busqueda.getClase().equals(LIS)) {
                                                            uso.setEstado(SEM2_A);
                                                            uso.setValorReal("id/" + busqueda.getClase());
                                                        } else {
                                                            uso.setEstado(SEM2_E);
                                                            if (busqueda.getTipo().equals(STR)) {
                                                                uso.setValorReal("id/" + busqueda.getClase());
                                                            } else {
                                                                uso.setValorReal("id/" + busqueda.getTipo());
                                                            }
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_15, identificador.lexema.trim());
                                                        }
                                                    } else {
                                                        uso.setEstado(SEM2_E);
                                                        uso.setValorReal("Variante");
                                                        generarErrorSemantica3(funcion.numeroLinea, ES_15, identificador.lexema.trim());
                                                    }
                                                } else {
                                                    System.out.println("id es nulo");
                                                }

                                                resultado = new Token(funcion.numeroLinea, -1, "@@@");

                                                ObjetoSem2 salida = new ObjetoSem2(contadorSem2++);
                                                salida.setAmbito(pila.peek());
                                                salida.setLinea(funcion.numeroLinea);
                                                salida.setRegla("pop");
                                                salida.setTopeDePila("pop/11");
                                                salida.setEstado(SEM2_A);

                                                if (entrada.getEstado().equals(SEM2_A) && uso.getEstado().equals(SEM2_A)) {
                                                    if (parNum != null) {
                                                        if (parNum >= 3) {
                                                            generarErrorSemantica3(funcion.numeroLinea, ES_16, parametro.lexema.trim());
                                                            salida.setValorReal(VAR_1);
                                                            resultado.value = VAR_1;
                                                        } else {
                                                            salida.setValorReal(CAD);
                                                            resultado.value = CAD;
                                                        }
                                                    } else {
                                                        salida.setValorReal(VAR_1);
                                                        resultado.value = VAR_1;
                                                    }
                                                } else {
                                                    salida.setValorReal(VAR_1);
                                                    resultado.value = VAR_1;
                                                }
                                                objetoSem2s.add(uso);
                                                objetoSem2s.add(entrada);
                                                objetoSem2s.add(salida);
                                                break;
                                                //</editor-fold>
                                            }
                                        }
                                        ///ed
                                        contadorSem3--;
                                        semantica3C.removeLast();
                                        semantica3T.removeLast();
                                        if (contadorSem3 == 0) {
                                            if (ejecucionAsignacion) {
                                                ejecucionAsignacionT.getLast().add(resultado);
                                            } else if (R1010) {
                                                R1010T.getLast().add(resultado);
                                            }
                                            semantica3 = false;
                                        } else {
                                            semantica3T.getLast().add(resultado);
                                        }
                                        break;
                                    }
                                    case 813: {
                                        forsC = "";
                                        forsT = new LinkedList();
                                        fors = true;
                                        break;
                                    }
                                    case 814: {
                                        if (forsC.equals("forItorange(0,9,1)") || forsC.equals("forItorange(0,5,1)") || forsC.equals("forItorange(0,3,1)")) {
                                            ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(forsT.getFirst().numeroLinea);
                                            os2.setRegla("1080");
                                            os2.setTopeDePila("for");
                                            os2.setValorReal("for");
                                            objetoSem2s.add(os2);

                                            os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(forsT.getFirst().numeroLinea);
                                            os2.setRegla("1081");
                                            os2.setTopeDePila("Id");
                                            os2.setValorReal("I");
                                            objetoSem2s.add(os2);

                                            os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(forsT.getFirst().numeroLinea);
                                            os2.setRegla("1082");
                                            os2.setTopeDePila("Cadena/Rango/Lista");
                                            os2.setValorReal("Rango");
                                            objetoSem2s.add(os2);
                                        } else if (forsC.equals("forJtorange(0,9,1)") || forsC.equals("forJtorange(0,3,1)")) {
                                            ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(forsT.getFirst().numeroLinea);
                                            os2.setRegla("1080");
                                            os2.setTopeDePila("for");
                                            os2.setValorReal("for");
                                            objetoSem2s.add(os2);

                                            os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(forsT.getFirst().numeroLinea);
                                            os2.setRegla("1081");
                                            os2.setTopeDePila("Id");
                                            os2.setValorReal("J");
                                            objetoSem2s.add(os2);

                                            os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(forsT.getFirst().numeroLinea);
                                            os2.setRegla("1082");
                                            os2.setTopeDePila("Cadena/Rango/Lista");
                                            os2.setValorReal("Rango");
                                            objetoSem2s.add(os2);
                                        }
                                        fors = false;
                                        break;
                                    }
                                    case 815: {
                                        ransT = new LinkedList();
                                        ransC = "";
                                        rans = true;
                                        break;
                                    }
                                    case 816: {
                                        if (ransC.trim().equals("0,9,1")) {
                                            ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(ransT.getFirst().numeroLinea);
                                            os2.setRegla(1160 + "");
                                            os2.setTopeDePila("Inicio-limite-incremento");
                                            os2.setValorReal("0,9,1");
                                            objetoSem2s.add(os2);
                                        } else if (ransC.equals("0,5,1")) {
                                            ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(ransT.getFirst().numeroLinea);
                                            os2.setRegla(1160 + "");
                                            os2.setTopeDePila("Inicio-limite-incremento");
                                            os2.setValorReal("0,5,1");
                                            objetoSem2s.add(os2);
                                        } else if (ransC.equals("0,3,1")) {
                                            ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                            os2.setAmbito(pila.peek());
                                            os2.setEstado(SEM2_A);
                                            os2.setLinea(ransT.getFirst().numeroLinea);
                                            os2.setRegla(1160 + "");
                                            os2.setTopeDePila("Inicio-limite-incremento");
                                            os2.setValorReal("0,3,1");
                                            objetoSem2s.add(os2);
                                        }
                                        rans = false;
                                        break;
                                    }
                                    case 817: {
                                        switch (contadorFun) {
                                            case 1: {
                                                Ambito a = AmbitoDB.findRecordById(new Ambito("Sorteo", 0));
                                                a.setClase("Procedimiento");
                                                AmbitoDB.modificarRegistro(a);
                                                ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                os2.setAmbito(0);
                                                os2.setEstado(SEM2_A);
                                                os2.setLinea(4);
                                                os2.setRegla("1150");
                                                os2.setTopeDePila("Sin return");
                                                os2.setValorReal("Sin return");
                                                objetoSem2s.add(os2);
                                                break;
                                            }
                                            case 2: {
                                                Ambito a = AmbitoDB.findRecordById(new Ambito("Matrices", 0));
                                                a.setClase("Procedimiento");
                                                AmbitoDB.modificarRegistro(a);
                                                ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                os2.setAmbito(0);
                                                os2.setEstado(SEM2_A);
                                                os2.setLinea(28);
                                                os2.setRegla("1150");
                                                os2.setTopeDePila("Sin return");
                                                os2.setValorReal("Sin return");
                                                objetoSem2s.add(os2);
                                                break;
                                            }
                                            case 3: {
                                                ObjetoSem2 os2 = new ObjetoSem2(contadorSem2++);
                                                os2.setAmbito(0);
                                                os2.setEstado(SEM2_A);
                                                os2.setLinea(47);
                                                os2.setRegla("1150");
                                                os2.setTopeDePila("Sin return");
                                                os2.setValorReal("Sin return");
                                                objetoSem2s.add(os2);
                                                break;
                                            }

                                        }
                                        contadorFun++;
                                        break;
                                    }
                                    //<editor-fold desc="Cuadruplos print">
                                    case 818: {
                                        cuadPrint = true;
                                        cuadPrintC = "";
                                        cuadPrintT = new LinkedList();
                                        break;
                                    }
                                    case 819: {
                                        if (!cuadPrintT.isEmpty()) {
                                            if (cuadPrintC.matches("print\\(\".+\"\\)")) {
                                                Cuadruplo c = new Cuadruplo();
                                                c.setAccion("call");
                                                int a = cc.get(pila.peek()).getCall();
                                                cc.get(pila.peek()).setCall(++a);
                                                c.setArg1("print");
                                                a = cc.get(pila.peek()).getFunciones();
                                                cc.get(pila.peek()).setFunciones(++a);
                                                llCuadruplos.add(c);

                                                c = new Cuadruplo();
                                                c.setArg1(CAD);
                                                c.setResultado("none/void");
                                                llCuadruplos.add(c);
                                            } else if (cuadPrintC.matches("print\\([a-zA-Z]+\\[[a-zA-Z]+\\]\\)")) {
                                                Cuadruplo c = new Cuadruplo();
                                                c.setAccion("call");
                                                int a = cc.get(pila.peek()).getCall();
                                                cc.get(pila.peek()).setCall(++a);
                                                c.setArg1("print");
                                                a = cc.get(pila.peek()).getFunciones();
                                                cc.get(pila.peek()).setFunciones(++a);
                                                llCuadruplos.add(c);

                                                String auxCuad = "";
                                                boolean booCuad = false;
                                                for (int i = 0; i < cuadPrintC.length(); i++) {
                                                    if (cuadPrintC.charAt(i) == ')') {
                                                        booCuad = false;
                                                    }
                                                    if (booCuad) {
                                                        auxCuad += cuadPrintC.charAt(i);
                                                    }
                                                    if (cuadPrintC.charAt(i) == '(') {
                                                        booCuad = true;
                                                    }
                                                }
                                                
                                                c = new Cuadruplo();
                                                c.setArg1(auxCuad);
                                                c.setResultado("none/void");
                                                llCuadruplos.add(c);
                                            }
                                        }
                                        cuadPrint = false;
                                        break;
                                    }
                                    //</editor-fold>

                                }
                                ///ed
                            }
                            ps.pop();
                        } else {
                            int n = checarMatriz(ps.peek(), lt.getFirst().numeroToken);
                            if (prod(n)) {
                                ps.pop();
                                cargarProd(n);
                            } else {
                                if (epsilon(n)) {
                                    ps.pop();
                                } else {
                                    if (error(n)) {
                                        generarError(lt.getFirst(), n, "Sintaxis");
                                        if (lt.getFirst().numeroToken == -94) {
                                            lt.removeFirst();
                                            break;
                                        } else {
                                            lt.removeFirst();

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } while (true);
    }

    public void asignarValor(Token t) {
        switch (t.numeroToken) {
            case -3: { //Decimal
                t.value = DEC;
                break;
            }
            case -4: { //Binario
                t.value = BIN;
                break;
            }
            case -5: { //Hexadecimal
                t.value = HEX;
                break;
            }
            case -6: { //Octal
                t.value = OCT;
                break;
            }
            case -7: { //Texto
                t.value = CAD;
                break;
            }
            case -8: { //Flotante
                t.value = FLO;
                break;
            }
            case -9: { //Complejos
                t.value = COM;
                break;
            }
            case -10: { //Caracter
                t.value = CHA;
                break;
            }
            case -65: { //none
                t.value = NON;
                break;
            }
            case -66:
            case -67: { //Boolean
                t.value = BOO;
                break;
            }
        }
    }

    public Token hacerOperacion(int op) {
        Token a1 = null;
        Token a2 = null;
        Token o = null;
        a1 = operandos.pop();
        a2 = operandos.pop();
        o = operadores.pop();
        Integer hoja = calcularHoja(o);
        Integer fila = calcularFC(a1);
        Integer columna = calcularFC(a2);
        Token r = null;
        r = realizarCalculo(hoja, fila, columna, op);
        if (r.lexema.trim().equals("@ERROR@")) {
            String aux = "";
            if (a2.lexema.trim().equals("@@@") || a2.lexema.trim().equals("@ERROR@")) {
                aux += a2.value.trim();
            } else {
                aux += a2.lexema.trim();
            }
            aux += " " + o.lexema.trim() + " ";
            if (a1.lexema.trim().equals("@@@") || a1.lexema.trim().equals("@ERROR@")) {
                aux += a1.value.trim();
            } else {
                aux += a1.lexema.trim();
            }
            generarErrorSemantica1(a1.numeroLinea, ES_1, aux);
        }
        operandos.add(r);
        return r;
    }

    public boolean esAsignacion(Token t) {
        switch (t.lexema.trim()) {
            case "=":
            case "+=":
            case "-=":
            case "*=":
            case "**=":
            case "/=":
            case "//=":
            case "%=": {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public String transformar(Token t) {
        switch (t.value) {
            case "Booleano": {
                return "TB" + contadorTB++;
            }
            default: {
                return "";
            }
        }
    }

    public Token realizarCalculo(int hoja, int fila, int columna, int op) {
        Token r;
        String aux = matrizSem1[hoja][fila][columna];
        switch (aux.trim()) {
            case "Decimal": {
                r = new Token(0, -1, "@@@");
                r.value = DEC;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTD();
                    objetoSem1s.getLast().setTD(++a);
                }
                break;
            }
            case "Flotante": {
                r = new Token(0, -1, "@@@");
                r.value = FLO;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTF();
                    objetoSem1s.getLast().setTF(++a);
                }
                break;
            }
            case "Hexadecimal": {
                r = new Token(0, -1, "@@@");
                r.value = HEX;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTDH();
                    objetoSem1s.getLast().setTDH(++a);
                }
                break;
            }
            case "Caracter": {
                r = new Token(0, -1, "@@@");
                r.value = CHA;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTDH();
                    objetoSem1s.getLast().setTDH(++a);
                }
                break;
            }
            case "Cadena": {
                r = new Token(0, -1, "@@@");
                r.value = CAD;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTS();
                    objetoSem1s.getLast().setTS(++a);
                }
                break;
            }
            case "Binario": {
                r = new Token(0, -1, "@@@");
                r.value = BIN;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTDB();
                    objetoSem1s.getLast().setTDB(++a);
                }
                break;
            }
            case "Octal": {
                r = new Token(0, -1, "@@@");
                r.value = OCT;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTDO();
                    objetoSem1s.getLast().setTDO(++a);
                }
                break;
            }
            case "Complejo": {
                r = new Token(0, -1, "@@@");
                r.value = COM;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTC();
                    objetoSem1s.getLast().setTC(++a);
                }
                break;
            }
            case "Boolean": {
                r = new Token(0, -1, "@@@");
                r.value = BOO;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTB();
                    objetoSem1s.getLast().setTB(++a);
                }
                break;
            }
            case "Lista": {
                r = new Token(0, -1, "@@@");
                r.value = LIS;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTL();
                    objetoSem1s.getLast().setTL(++a);
                }
                break;
            }
            case "Arreglo": {
                r = new Token(0, -1, "@@@");
                r.value = ARR;
                break;
            }
            case "Tupla": {
                r = new Token(0, -1, "@@@");
                r.value = TUP;
                break;
            }
            case "Conjunto": {
                r = new Token(0, -1, "@@@");
                r.value = CON;
                break;
            }
            case "Diccionario": {
                r = new Token(0, -1, "@@@");
                r.value = DIC;
                break;
            }
            case "None": {
                r = new Token(0, -1, "@@@");
                r.value = NON;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTN();
                    objetoSem1s.getLast().setTN(++a);
                }
                break;
            }
            case "Rango": {
                r = new Token(0, -1, "@@@");
                r.value = RAN;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTR();
                    objetoSem1s.getLast().setTR(++a);
                }
                break;
            }
            case "Variante": {
                r = new Token(0, -1, "@@@");
                r.value = VAR_1;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTV();
                    objetoSem1s.getLast().setTV(++a);
                }
                break;
            }
            case "Error": {
                r = new Token(0, -1, "@ERROR@");
                r.value = VAR_1;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTV();
                    objetoSem1s.getLast().setTV(++a);
                }
                break;
            }
            default: {
                r = new Token(0, -1, "@ERROR@");
                r.value = VAR_1;
                if (op == 1) {
                    int a = objetoSem1s.getLast().getTV();
                    objetoSem1s.getLast().setTV(++a);
                }
                break;
            }
        }
        return r;
    }

    public void cargarProd(int n) {
        for (int i = 0; i < lp[n - 1].length; i++) {
            ps.push(lp[n - 1][i]);
        }
    }

    public boolean esOperador(Token t) {
        switch (t.lexema.trim()) {
            case "-":
            case "*":
            case "**":
            case "/":
            case "//":
            case "%":
            case "!":
            case "&&":
            case "||":
            case "<":
            case "<=":
            case ">":
            case ">=":
            case "==":
            case "&":
            case "|":
            case "^":
            case "<<":
            case ">>":
            case "=":
            case "+=":
            case "-=":
            case "*=":
            case "**=":
            case "/=":
            case "//=":
            case "%=":
            case "+": {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private int calcularFC(Token t) {
        switch (t.numeroToken) {
            case -3: { //Decimal
                return 0;
            }
            case -4: { //Binario
                return 4;
            }
            case -5: { //Hexadecimal
                return 5;
            }
            case -6: { //Octal
                return 6;
            }
            case -7: { //Texto
                return 2;
            }
            case -8: { //Flotante
                return 1;
            }
            case -9: { //Complejos
                return 7;
            }
            case -10: { //Caracter
                return 3;
            }
            case -65: { //none
                return 14;
            }
            case -1: { //id
                switch (t.value) {
                    case "Decimal": {
                        return 0;
                    }
                    case "Binario": {
                        return 4;
                    }
                    case "Hexadecimal": { //Hexadecimal
                        return 5;
                    }
                    case "Octal": { //Octal
                        return 6;
                    }
                    case "Cadena": { //Texto
                        return 2;
                    }
                    case "Flotante": { //Flotante
                        return 1;
                    }
                    case "Complejo": { //Complejos
                        return 7;
                    }
                    case "Caracter": { //Caracter
                        return 3;
                    }
                    case "None": { //none
                        return 14;
                    }
                    case "Booleano": { //Boolean
                        return 8;
                    }
                    case "Lista": { //Lista
                        return 9;
                    }
                    case "Arreglo": { //Arreglo
                        return 10;
                    }
                    case "Tupla": {
                        return 11;
                    }
                    case "Conjunto": {
                        return 12;
                    }
                    case "Diccionario": {
                        return 13;
                    }
                    case "Rango": {
                        return 15;
                    }
                    case "Variante": {
                        return 16;
                    }
                }
            }
            case -66:
            case -67: { //Boolean
                return 8;
            }
            default: {
                return -1;
            }
        }
    }

    private int calcularHoja(Token t) {
        switch (t.lexema.trim()) {
            case "##":
            case "&&":
            case "||": {
                return 5;
            }
            case "<":
            case "<=":
            case ">":
            case ">=":
            case "==":
            case "^":
            case "!=": {
                return 6;
            }
            case "&":
            case "|":
            case "<<":
            case ">>": {
                return 7;
            }
            case "+": {
                return 0;
            }
            case "-": {
                return 1;
            }
            case "/": {
                return 3;
            }
            case "//":
            case "%": {
                return 4;
            }
            case "*":
            case "**": {
                return 2;
            }
            default: {
                System.out.println("ERROR FATAL\nlinea = " + t.numeroLinea + "\nLexema = " + t.lexema);
                return -1;
            }
        }
    }

    public boolean contieneReservadas(String string) {
        LinkedList<String> palabrasReservadas = new LinkedList();
        palabrasReservadas.add("is");
        palabrasReservadas.add("isnot");
        palabrasReservadas.add("break");
        palabrasReservadas.add("continue");
        palabrasReservadas.add("elif");
        palabrasReservadas.add("else");
        palabrasReservadas.add("for");
        palabrasReservadas.add("if");
        palabrasReservadas.add("in");
        palabrasReservadas.add("print");
        palabrasReservadas.add("return");
        palabrasReservadas.add("while");
        palabrasReservadas.add("innot");
        palabrasReservadas.add("none");
        palabrasReservadas.add("true");
        palabrasReservadas.add("false");
        palabrasReservadas.add("def");
        palabrasReservadas.add("range");
        palabrasReservadas.add("input");
        palabrasReservadas.add("findall");
        palabrasReservadas.add("replace");
        palabrasReservadas.add("len");
        palabrasReservadas.add("sample");
        palabrasReservadas.add("choice");
        palabrasReservadas.add("random");
        palabrasReservadas.add("randrange");
        palabrasReservadas.add("mean");
        palabrasReservadas.add("median");
        palabrasReservadas.add("variance");
        palabrasReservadas.add("sum");
        palabrasReservadas.add("sort");
        palabrasReservadas.add("reverse");
        palabrasReservadas.add("count");
        palabrasReservadas.add("index");
        palabrasReservadas.add("append");
        palabrasReservadas.add("extend");
        palabrasReservadas.add("pop");
        palabrasReservadas.add("remove");
        palabrasReservadas.add("insert");
        palabrasReservadas.add("println");
        palabrasReservadas.add("wend");
        palabrasReservadas.add("end");
        palabrasReservadas.add("@");
        palabrasReservadas.add("to");
        for (String palabrasReservada : palabrasReservadas) {
            if (string.contains(palabrasReservada)) {
                return true;
            }
        }
        return false;
    }

    public int prioridad(Token a) {
        switch (a.lexema.trim()) {
            case "**": {
                return 10;
            }
            case "/":
            case "//":
            case "%":
            case "*": {
                return 9;
            }
            case "-":
            case "+": {
                return 8;
            }
            case "<<":
            case ">>": {
                return 7;
            }
            case "&": {
                return 6;
            }
            case "^": {
                return 5;
            }
            case "|": {
                return 4;
            }
            case "<":
            case "<=":
            case "==":
            case "!=":
            case ">=":
            case ">":
            case "isnot":
            case "in":
            case "innot":
            case "is": {
                return 3;
            }
            case "!": {
                return 2;
            }
            case "&&":
            case "##": {
                return 1;
            }
            case "||": {
                return 0;
            }
        }
        if (a.lexema.trim().equalsIgnoreCase("is") || a.lexema.trim().equalsIgnoreCase("isnot") || a.lexema.trim().equalsIgnoreCase("in") || a.lexema.trim().equalsIgnoreCase("innot")) {
            return 3;
        } else {
            return -1;
        }
    }

    public boolean error(int n) {
        return n >= 600 && n < 800;
    }

    public boolean epsilon(int n) {
        return n == 126;
    }

    public boolean prod(int i) {
        return i != 126 && i < 500;
    }

    public boolean esArroba(int n) {
        return n >= 800;
    }

    public void generarError(Token token, int n, String tipo) {
        le.add(new Error(token.numeroLinea, n, lt.getFirst().lexema, tipo));
    }

    public void generarErrorAmbito(Token token, int n, String tipo) {
        le.add(new Error(token.numeroLinea, n, token.lexema.trim(), tipo));
    }

    public void generarErrorSemantica1(int numeroLinea, int n, String tokens) {
        le.add(new Error(numeroLinea, n, tokens, "Semantica 1"));
    }

    public void generarErrorSemantica2(int numeroLinea, int n, String tokens) {
        le.add(new Error(numeroLinea, n, tokens, "Semantica 2"));
    }

    public void generarErrorSemantica3(int numeroLinea, int n, String tokens) {
        le.add(new Error(numeroLinea, n, tokens, "Semantica 3"));
    }

    public int checarMatriz(int m, int o) {
        int n = matriz[m - 201][Math.abs(o) - 1];
        return n;
    }

    public void llenarMatriz(String direccion) {
        LinkedList<LinkedList> filas = new LinkedList();
        LinkedList<Integer> celdas = new LinkedList();
        LinkedList<Integer> val = new LinkedList();
        String FILE_NAME = direccion;
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellTypeEnum() == CellType.BLANK) {
                        celdas.add(1000);
                    }
                    if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        celdas.add((int) currentCell.getNumericCellValue());
                    }
                }
                filas.add(new LinkedList<Integer>(celdas));
                celdas.clear();
            }
            matriz = new int[filas.size()][filas.get(0).size()];
            for (int i = 0; i < filas.size(); i++) {
                for (int j = 0; j < filas.get(i).size(); j++) {
                    matriz[i][j] = (int) filas.get(i).get(j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[][][] getMatrizSem1() {
        return matrizSem1;
    }

    public void setMatrizSem1(String[][][] matrizSem1) {
        this.matrizSem1 = matrizSem1;
    }

}
