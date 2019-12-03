/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fx.fcamaven;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jesus
 */
public class Excelsior {

//    C:\Users\jesus\Documents
    public static final String DIRECCION_SEMANTICA_1 = "src/Excelazo.xlsx";
    public static final String DIRECCION_SEMANTICA_2 = "src/Excelazo.xlsx";
    public static final String FILE_DIR = "C:/Users/jesus/Documents/";
    public static final String FILE_NAME = "JesusFigueroa15130145.xlsx";
    public static String aux = "";

    public static void jalarSemantica1(String[][][] ll) {
        try {
            Workbook workbook;
            workbook = WorkbookFactory.create(new File(DIRECCION_SEMANTICA_1));
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            Sheet sheet;
            Row row;
            Cell cell;
            Iterator<Row> rowIterator;
            Iterator<Cell> cellIterator;
            int conRows;
            int conSheets = 0;
            int conCells;
            while (sheetIterator.hasNext()) {
                sheet = sheetIterator.next();
                rowIterator = sheet.rowIterator();
                conRows = 0;
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    if (conRows != 0) {
                        cellIterator = row.cellIterator();
                        conCells = 0;
                        while (cellIterator.hasNext()) {
                            cell = cellIterator.next();
                            if (conCells != 0) {
                                ll[conSheets][conRows - 1][conCells - 1] = cell.getStringCellValue();
                            }
                            conCells++;
                        }
                    }
                    conRows++;
                }
                conSheets++;
            }
//            imprimirMatriz(ll);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void imprimirMatriz(String[][][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                for (int k = 0; k < matriz[i][j].length; k++) {
                    System.out.println("Matriz[" + i + "][" + j + "][" + k + "] = " + matriz[i][j][k]);
                }
            }
        }
    }

    public static void excel(ObservableList<Errores> e, LinkedList<ObjetoExcel> a, LinkedList<ObjetoSem1> sem1, LinkedList<ObjetoSem2> sem2, LinkedList<Cuadruplo> cuad, LinkedList<ContadoresCuadruplos> ccuad) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Errores");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Token");
        cell = row.createCell(1);
        cell.setCellValue("Descripción");
        cell = row.createCell(2);
        cell.setCellValue("Lexema");
        cell = row.createCell(3);
        cell.setCellValue("Tipo de error");
        cell = row.createCell(4);
        cell.setCellValue("Línea");
        for (int i = 0; i < e.size(); i++) {
            row = sheet.createRow(i + 1);
            cell = row.createCell(0);
            cell.setCellValue(e.get(i).getNumero());
            cell = row.createCell(1);
            cell.setCellValue(e.get(i).getDescripcion());
            cell = row.createCell(2);
            cell.setCellValue(e.get(i).getLexema());
            cell = row.createCell(3);
            cell.setCellValue(e.get(i).getTipo());
            cell = row.createCell(4);
            cell.setCellValue(e.get(i).getLinea());
        }
        sheet = workbook.createSheet("Cont_Amb");
        row = sheet.createRow(0);
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("Ambito");
        cell = row.createCell(1);
        cell.setCellValue("Decimal");
        cell = row.createCell(2);
        cell.setCellValue("binario");
        cell = row.createCell(3);
        cell.setCellValue("octal");
        cell = row.createCell(4);
        cell.setCellValue("Hexadecimal");
        cell = row.createCell(5);
        cell.setCellValue("flotante");
        cell = row.createCell(6);
        cell.setCellValue("cadena");
        cell = row.createCell(7);
        cell.setCellValue("carácter");
        cell = row.createCell(8);
        cell.setCellValue("compleja");
        cell = row.createCell(9);
        cell.setCellValue("booleana");
        cell = row.createCell(10);
        cell.setCellValue("None");
        cell = row.createCell(11);
        cell.setCellValue("arreglo");
        cell = row.createCell(12);
        cell.setCellValue("tuplas");
        cell = row.createCell(13);
        cell.setCellValue("Lista");
        cell = row.createCell(14);
        cell.setCellValue("registro");
        cell = row.createCell(15);
        cell.setCellValue("rango");
        cell = row.createCell(16);
        cell.setCellValue("conjuntos");
        cell = row.createCell(17);
        cell.setCellValue("Diccionarios");
        cell = row.createCell(18);
        cell.setCellValue("Total/Amb");

        for (int i = 0; i < a.size(); i++) {
            row = sheet.createRow(i + 2);
            cell = row.createCell(0);
            if (i < a.size() - 1) {
                cell.setCellValue(a.get(i).getAmbito());
            }
            cell = row.createCell(1);
            cell.setCellValue(a.get(i).getDecimal());
            cell = row.createCell(2);
            cell.setCellValue(a.get(i).getBinario());
            cell = row.createCell(3);
            cell.setCellValue(a.get(i).getOctal());
            cell = row.createCell(4);
            cell.setCellValue(a.get(i).getHexadecimal());
            cell = row.createCell(5);
            cell.setCellValue(a.get(i).getFlotante());
            cell = row.createCell(6);
            cell.setCellValue(a.get(i).getCadena());
            cell = row.createCell(7);
            cell.setCellValue(a.get(i).getCaracter());
            cell = row.createCell(8);
            cell.setCellValue(a.get(i).getCompleja());
            cell = row.createCell(9);
            cell.setCellValue(a.get(i).getBooleana());
            cell = row.createCell(10);
            cell.setCellValue(a.get(i).getNone());
            cell = row.createCell(11);
            cell.setCellValue(a.get(i).getArreglo());
            cell = row.createCell(12);
            cell.setCellValue(a.get(i).getTuplas());
            cell = row.createCell(13);
            cell.setCellValue(a.get(i).getLista());
            cell = row.createCell(14);
            cell.setCellValue(0);
            cell = row.createCell(15);
            cell.setCellValue(a.get(i).getRango());
            cell = row.createCell(16);
            cell.setCellValue(a.get(i).getConjuntos());
            cell = row.createCell(17);
            cell.setCellValue(a.get(i).getDiccionarios());
            cell = row.createCell(18);
            cell.setCellValue(a.get(i).getTotal());
        }

        sheet = workbook.createSheet("Contadores de Semantica 1");
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell = row.createCell(1);
        cell.setCellValue("TD");
        cell = row.createCell(2);
        cell.setCellValue("TDB");
        cell = row.createCell(3);
        cell.setCellValue("TDO");
        cell = row.createCell(4);
        cell.setCellValue("TDH");
        cell = row.createCell(5);
        cell.setCellValue("TF");
        cell = row.createCell(6);
        cell.setCellValue("TS");
        cell = row.createCell(7);
        cell.setCellValue("TCH");
        cell = row.createCell(8);
        cell.setCellValue("TC");
        cell = row.createCell(9);
        cell.setCellValue("TB");
        cell = row.createCell(10);
        cell.setCellValue("TN");
        cell = row.createCell(11);
        cell.setCellValue("TL");
        cell = row.createCell(12);
        cell.setCellValue("TR");
        cell = row.createCell(13);
        cell.setCellValue("TV");

        for (int j = 0; j < sem1.size(); j++) {
            row = sheet.createRow(j + 1);
            cell = row.createCell(0);
            cell.setCellValue(sem1.get(j).getLinea());
            cell = row.createCell(1);
            cell.setCellValue(sem1.get(j).getTD());
            cell = row.createCell(2);
            cell.setCellValue(sem1.get(j).getTDB());
            cell = row.createCell(3);
            cell.setCellValue(sem1.get(j).getTDO());
            cell = row.createCell(4);
            cell.setCellValue(sem1.get(j).getTDH());
            cell = row.createCell(5);
            cell.setCellValue(sem1.get(j).getTF());
            cell = row.createCell(6);
            cell.setCellValue(sem1.get(j).getTS());
            cell = row.createCell(7);
            cell.setCellValue(sem1.get(j).getTCH());
            cell = row.createCell(8);
            cell.setCellValue(sem1.get(j).getTC());
            cell = row.createCell(9);
            cell.setCellValue(sem1.get(j).getTB());
            cell = row.createCell(10);
            cell.setCellValue(sem1.get(j).getTN());
            cell = row.createCell(11);
            cell.setCellValue(sem1.get(j).getTL());
            cell = row.createCell(12);
            cell.setCellValue(sem1.get(j).getTR());
            cell = row.createCell(13);
            cell.setCellValue(sem1.get(j).getTV());
            cell = row.createCell(14);
            cell.setCellValue(sem1.get(j).getAsignacion());
        }
        sheet = workbook.createSheet("Contadores de Semantica 2");
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("Regla");
        cell = row.createCell(1);
        cell.setCellValue("Tope de pila");
        cell = row.createCell(2);
        cell.setCellValue("Valor real");
        cell = row.createCell(3);
        cell.setCellValue("Linea");
        cell = row.createCell(4);
        cell.setCellValue("Estado");
        cell = row.createCell(5);
        cell.setCellValue("Ambito");
        for (int j = 0; j < sem2.size(); j++) {
            row = sheet.createRow(j + 1);
            cell = row.createCell(0);
            cell.setCellValue(sem2.get(j).getRegla());
            cell = row.createCell(1);
            cell.setCellValue(sem2.get(j).getTopeDePila());
            cell = row.createCell(2);
            cell.setCellValue(sem2.get(j).getValorReal());
            cell = row.createCell(3);
            cell.setCellValue(sem2.get(j).getLinea());
            cell = row.createCell(4);
            cell.setCellValue(sem2.get(j).getEstado());
            cell = row.createCell(5);
            cell.setCellValue(sem2.get(j).getAmbito());
        }

        sheet = workbook.createSheet("Cuádruplos");
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("Etiquetas");
        cell = row.createCell(1);
        cell.setCellValue("Acción");
        cell = row.createCell(2);
        cell.setCellValue("Arg1");
        cell = row.createCell(3);
        cell.setCellValue("Arg2");
        cell = row.createCell(4);
        cell.setCellValue("Resultado");
        if (cuad != null) {
            for (int j = 0; j < cuad.size(); j++) {
                row = sheet.createRow(j + 1);
                cell = row.createCell(0);
                cell.setCellValue(cuad.get(j).getEtiqueta());
                cell = row.createCell(1);
                cell.setCellValue(cuad.get(j).getAccion());
                cell = row.createCell(2);
                cell.setCellValue(cuad.get(j).getArg1());
                cell = row.createCell(3);
                cell.setCellValue(cuad.get(j).getArg2());
                cell = row.createCell(4);
                cell.setCellValue(cuad.get(j).getResultado());
            }
        }

        sheet = workbook.createSheet("Contadores Cuádruplos");
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("Ambitos");
        cell = row.createCell(1);
        cell.setCellValue("Aritmeticos");
        cell = row.createCell(2);
        cell.setCellValue("logicos");
        cell = row.createCell(3);
        cell.setCellValue("relacionales");
        cell = row.createCell(4);
        cell.setCellValue("listas");
        cell = row.createCell(5);
        cell.setCellValue("asignaciones");
        cell = row.createCell(6);
        cell.setCellValue("call");
        cell = row.createCell(7);
        cell.setCellValue("metodos");
        cell = row.createCell(8);
        cell.setCellValue("Funciones");
        cell = row.createCell(9);
        cell.setCellValue("JF");
        cell = row.createCell(10);
        cell.setCellValue("If-E");
        cell = row.createCell(11);
        cell.setCellValue("Tfor");
        cell = row.createCell(12);
        cell.setCellValue("Tforb");
        cell = row.createCell(13);
        cell.setCellValue("For-E");
        cell = row.createCell(14);
        cell.setCellValue("Whi-E");
        cell = row.createCell(15);
        cell.setCellValue("def");
        cell = row.createCell(16);
        cell.setCellValue("enddef");
        cell = row.createCell(17);
        cell.setCellValue("TdefXXX");
        cell = row.createCell(18);
        cell.setCellValue("TD");
        cell = row.createCell(19);
        cell.setCellValue("TDB");
        cell = row.createCell(20);
        cell.setCellValue("TDO");
        cell = row.createCell(21);
        cell.setCellValue("TDH");
        cell = row.createCell(22);
        cell.setCellValue("TF");
        cell = row.createCell(23);
        cell.setCellValue("TS");
        cell = row.createCell(24);
        cell.setCellValue("TCH");
        cell = row.createCell(25);
        cell.setCellValue("TC");
        cell = row.createCell(26);
        cell.setCellValue("TB");
        cell = row.createCell(27);
        cell.setCellValue("TN");
        cell = row.createCell(28);
        cell.setCellValue("TL");
        cell = row.createCell(29);
        cell.setCellValue("TR");
        cell = row.createCell(30);
        cell.setCellValue("Total");

        if (ccuad != null) {
            for (int i = 0; i < ccuad.size(); i++) {
                row = sheet.createRow(i + 1);
                cell = row.createCell(0);
                cell.setCellValue(ccuad.get(i).getAmbito());
                cell = row.createCell(1);
                cell.setCellValue(ccuad.get(i).getAritmeticos());
                cell = row.createCell(2);
                cell.setCellValue(ccuad.get(i).getLogicos());
                cell = row.createCell(3);
                cell.setCellValue(ccuad.get(i).getRelacionales());
                cell = row.createCell(4);
                cell.setCellValue(ccuad.get(i).getListas());
                cell = row.createCell(5);
                cell.setCellValue(ccuad.get(i).getAsignaciones());
                cell = row.createCell(6);
                cell.setCellValue(ccuad.get(i).getCall());
                cell = row.createCell(7);
                cell.setCellValue(ccuad.get(i).getMetodos());
                cell = row.createCell(8);
                cell.setCellValue(ccuad.get(i).getFunciones());
                cell = row.createCell(9);
                cell.setCellValue(ccuad.get(i).getJf());
                cell = row.createCell(10);
                cell.setCellValue(ccuad.get(i).getIf_e());
                cell = row.createCell(11);
                cell.setCellValue(ccuad.get(i).getTfor());
                cell = row.createCell(12);
                cell.setCellValue(ccuad.get(i).getTforb());
                cell = row.createCell(13);
                cell.setCellValue(ccuad.get(i).getFor_e());
                cell = row.createCell(14);
                cell.setCellValue(ccuad.get(i).getWhi_e());
                cell = row.createCell(15);
                cell.setCellValue(ccuad.get(i).getDef());
                cell = row.createCell(16);
                cell.setCellValue(ccuad.get(i).getEnddef());
                cell = row.createCell(17);
                cell.setCellValue(ccuad.get(i).getTdefxxx());
                cell = row.createCell(18);
                cell.setCellValue(ccuad.get(i).getTd());
                cell = row.createCell(19);
                cell.setCellValue(ccuad.get(i).getTdb());
                cell = row.createCell(20);
                cell.setCellValue(ccuad.get(i).getTdo());
                cell = row.createCell(21);
                cell.setCellValue(ccuad.get(i).getTdh());
                cell = row.createCell(22);
                cell.setCellValue(ccuad.get(i).getTf());
                cell = row.createCell(23);
                cell.setCellValue(ccuad.get(i).getTs());
                cell = row.createCell(24);
                cell.setCellValue(ccuad.get(i).getTch());
                cell = row.createCell(25);
                cell.setCellValue(ccuad.get(i).getTc());
                cell = row.createCell(26);
                cell.setCellValue(ccuad.get(i).getTb());
                cell = row.createCell(27);
                cell.setCellValue(ccuad.get(i).getTn());
                cell = row.createCell(28);
                cell.setCellValue(ccuad.get(i).getTl());
                cell = row.createCell(29);
                cell.setCellValue(ccuad.get(i).getTr());
                cell = row.createCell(30);
                ccuad.get(i).setTotal();
                cell.setCellValue(ccuad.get(i).getTotal());
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(aux);
            workbook.write(fos);
            workbook.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean crearArchivo(int a) {
        LocalDateTime now = LocalDateTime.now();
        if (a > 0) {
            aux = FILE_DIR + now.getDayOfMonth() + "-" + now.getMonthValue() + "-" + now.getYear() + "JesusFigueroa15130145" + "(" + a + ")" + ".xlsx";
        } else {
            aux = FILE_DIR + now.getDayOfMonth() + "-" + now.getMonthValue() + "-" + now.getYear() + FILE_NAME;
        }
        File file = new File(aux);
        try {
            if (!file.createNewFile()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
