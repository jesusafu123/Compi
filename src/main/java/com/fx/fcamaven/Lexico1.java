package com.fx.fcamaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lexico1 {
    
    private LinkedList<Error> LE = new LinkedList();
    private LinkedList<Token> LT = new LinkedList();
    LinkedList<Token> Comentarios = new LinkedList();
    private String codigo;
    int[][] matriz;
    int complexx = 0;
    LinkedList<String> caracteres = new LinkedList();
    private LinkedList<String> palabrasReservadas = new LinkedList();
    
    public void analizar() {
        String lexema = "", auxiliar = "";
        char caracter = '@';
        int posicion = 0, estado = 0, columna, complemas = 0;
        Boolean b = true, com = true;
        
        while (posicion <= codigo.length()) {
            
            if (posicion < codigo.length()) {
                if (b) {
                    caracter = this.getCodigo().charAt(posicion);
                }
                b = true;
                columna = calcularColumna(caracter);
            } else {
                columna = fin();
            }
            estado = calcularEstado(estado, columna);
            if (estado == 14 || estado == 15 || estado == 16 || estado == 18 || estado == 26) {
                auxiliar += caracter;
            }
            if (estado < 0) {
                auxiliar = "";
                if (estado == -1 && palabrasReservadas.contains(lexema.trim().toLowerCase())) {
                    estado = (palabrasReservadas.indexOf(lexema.trim().toLowerCase()) + 52) * -1;
                    if (lexema.trim().equals("while")) {
                        System.out.println("asdasd");
                        System.out.println(lexema.length());
                        System.out.println(quitarEspacios(lexema).length());
                        for (int i = 0; i < lexema.length(); i++) {
                            System.out.println(lexema.charAt(i) + ": " + (int)lexema.charAt(i));
                        }
                    }
                    LT.add(new Token(calcularLinea(posicion, quitarEspacios(lexema).length()), estado, lexema.trim()));
                    if (LT.getLast().lexema.trim().equals("while")) {
                        System.out.println("WHILE.linea: " + LT.getLast().numeroLinea);
                    }
                    estado = 0;
                    lexema = "";
                    b = false;
                } else {
                    if (estado != -100) {
                        LT.add(new Token(calcularLinea(posicion, quitarEspacios(lexema).length()), estado, lexema));
                        if (LT.getLast().lexema.trim().equals("while")) {
                            System.out.println("WHILE.linea: " + LT.getLast().numeroLinea);
                        }
                    }
                    estado = 0;
                    lexema = "";
                    b = true;
                }
            } else {
                if (estado >= 500) {
                    int pos = posicion;
                    if (estado == 500) {
                        lexema += caracter;
                        posicion++;
                        b = true;
                        LE.add(new Error(calcularLinea(pos, lexema.length()), estado, lexema.trim(), "L"));
                        estado = 0;
                        lexema = "";
                    } else {
//                        PRUEBA DE COMPLEJOS AQUI
                        if (estado == 550) {
                            estado = 82;
                            posicion = complexx;
                            codigo = codigo.substring(0, posicion) + " " + codigo.substring(posicion);
                            lexema = "(";
                            b = false;
                        } else {
                            if (estado == 560) {
                                if (auxiliar.contains(".")) {
                                    estado = 84;
                                } else {
                                    estado = 83;
                                }
                                posicion = complemas - 1;
                                codigo = codigo.substring(0, posicion) + " " + codigo.substring(posicion);
                                lexema = auxiliar;
                                auxiliar = "";
                                com = true;
                                b = true;
                            } else {
                                LE.add(new Error(calcularLinea(pos, lexema.length()), estado, lexema.trim(), "L"));
                                estado = 0;
                                lexema = "";
                                b = false;
                            }
                        }
                    }
                } else {
                    if (caracter == ' ' || caracter == '\n' || caracter == '\t') {//quitar los espacios 
                        caracter = '\00';
                        lexema += caracter;
                        posicion++;
                    } else if (caracter != ' ') {
                        lexema += caracter;
                        posicion++;
                        if (caracter >= '0' && caracter <= '9' && com == true) {
                            com = false;
                        }
                        if (caracter == '(') {
                            complexx = posicion;
                        }
                        if (caracter == '+') {
                            complemas = posicion;
                        }
                    }
                }
            }
        }
    }
    
    public String quitarEspacios(String string) {
        String resultado = "";
        for(int i = 0; i < string.length(); i++) {
            int n = (int)string.charAt(i);
            if (n != 10 && n != 0) {
                resultado += string.charAt(i);
            }
        }
        return resultado;
    }

//    public void imprimirTokens() {
//        int contador = 1;
////        System.out.println("\n****** No de tokens: " + LT.size() + " ******");
//        for (Token token : LT) {
//            System.out.println("\nToken# " + contador + ":\n\tToken: " + token.numeroToken + "\n\tLexema: " + token.lexema + "\n\tLinea: " + token.numeroLinea);
//            contador++;
//        }
//    }
//    public void imprimirErrores() {
//        int contador = 1;
//        System.out.println("\n****** No de Errores: " + LE.size() + " ******");
//        for (Error error : LE) {
//            System.out.println("\nError# " + contador + ":\n\tError: " + error.numeroError + "\n\tLexema: " + error.lexema + "\n\tLinea: " + error.numeroLinea + "\n\tTipo: " + error.tipo);
//            contador++;
//        }
//    }
    public int fin() {
        return caracteres.indexOf("FIN");
    }
    
    public int calcularEstado(int estado, int columna) {
        return matriz[estado][columna];
    }
    
    public int calcularColumna(char a) {
        if (caracteres.contains(String.valueOf(a))) {
            return caracteres.indexOf(String.valueOf(a));
        } else if (String.valueOf(a).equals("\n")) {
            return caracteres.indexOf("\\n");
        } else if (String.valueOf(a).equals(" ") || String.valueOf(a).equals("\r") || String.valueOf(a).equals("\t")) {
            return caracteres.indexOf("esp");
        } else if (a == 'O') {
            return 79;
        }
//        else if (a=='\t') {
//            return caracteres.indexOf("\\t");
//        }
        return caracteres.indexOf("oc");
    }
    
    public int calcularLinea(int posicion, int longitud) {
        int contador = 1;
        int comienzo = posicion - longitud + 1;
        for (int i = 0; i < comienzo; i++) {
//            if (contador == 10) {
//                System.out.println(codigo.charAt(i) + ": " + (int) codigo.charAt(i));
//            }
            if (codigo.charAt(i) == '\n' || codigo.charAt(i) == '\r') {
                contador++;
            }
        }
        return contador;
    }
    
    public void llenarMatriz(String direccion) {
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
        caracteres.clear();
        LinkedList col = new LinkedList();
        LinkedList fil = new LinkedList();
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
                    if (currentCell.getColumnIndex() != 0) {
                        if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                            if (!col.contains(currentCell.getColumnIndex())) {
                                col.add(currentCell.getColumnIndex());
                            }
                            if (!fil.contains(currentCell.getRowIndex())) {
                                fil.add(currentCell.getRowIndex());
                            }
                            val.add(new Double(currentCell.getNumericCellValue()).intValue());
                        } else if (currentCell.getCellTypeEnum() == CellType.STRING) {
                            caracteres.add(currentCell.getStringCellValue());
                        }
                    }
                }
            }
            matriz = new int[fil.size()][col.size()];
            int contador = 0;
            for (int i = 0; i < fil.size(); i++) {
                for (int j = 0; j < col.size(); j++) {
                    matriz[i][j] = val.get(contador);
                    contador++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void imprimirMatriz() {
//        System.out.println("matriz.length = " + matriz.length + " x " + matriz[0].length);
//        for (int i = 0; i < caracteres.size(); i++) {
//            System.out.print("[" + caracteres.get(i) + "]");
//        }
//        System.out.println("");
//        for (int i = 0; i < matriz.length; i++) {
//            System.out.print("matriz[" + i + "][0] = ");
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.print("[" + matriz[i][j] + "]");
//            }
//            System.out.println("");
//        }
//    }
    public LinkedList<Error> getLE() {
        return LE;
    }
    
    public void setLE(LinkedList<Error> LE) {
        this.LE = LE;
    }
    
    public LinkedList<Token> getLT() {
        return LT;
    }
    
    public void setLT(LinkedList<Token> LT) {
        this.LT = LT;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void leerCodigoTxt(String direccion) {
        File file = new File(direccion);
        try {
            codigo = new Scanner(file).useDelimiter("\\Z").next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String leerCodigoTxt(File file) {
        StringBuilder stringBuffer = new StringBuilder();
        StringBuilder stringBuffer2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            
            bufferedReader = new BufferedReader(new FileReader(file));
            
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text + "\n");
            }
            for (int i = 0; i < stringBuffer.length() - 1; i++) {
                stringBuffer2.append(stringBuffer.charAt(i));
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return stringBuffer2.toString();
    }
    
    private static int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }
}
