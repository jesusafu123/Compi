package com.fx.fcamaven;

import static com.fx.fcamaven.ErroresC.ErroresSemantica1.ES_1;
import static com.fx.fcamaven.ErroresC.ErroresSemantica1.ES_2;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_10;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_11;
import static com.fx.fcamaven.ErroresC.ErroresSemantica2.ES_12;
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
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

public class MainApp extends Application {

    private String[][][] semArr = new String[9][17][17];
    ;
    CodeArea ca;
    Button btnGenerar, btnCompilar, btnCargar;
    Desktop desktop = Desktop.getDesktop();
    TableView tablaE, tablaT, tablaA;
    LinkedList<ObjetoExcel> excelAmbito;
    LinkedList<ObjetoSem1> excelSem1;
    LinkedList<ObjetoSem2> excelSem2;
    LinkedList<Cuadruplo> excelCuad;
    Lexico1 l;
    private static final String KEYWORD_PATTERN = ".*\\n";
    private static final String DOS_PATTERN = ".*";
    private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
            + "|(?<DOS>" + DOS_PATTERN + ")"
    );
    private ExecutorService executor;
    private int[] contadores = new int[21];

    String[] lonooool = {
        "Caracter no válido",
        "Error con salto de línea",
        "Se espera ' (Comilla simple)",
        "Se espera número 0-9",
        "Se espera - (menos) o número 0-9",
        "Se espera 0 ó 1",
        "Se espera a-f ó 0-9",
        "Error con salto de línea, se espera \"",
        "Error"
    };

    String[] lonooool2 = {
        "Se puso de mas",
        "Se espera def id {",
        "Se espera def id ",
        "Se espera ;",
        "Se espera id",
        "Se espera ,",
        "Se espera decimal binario hexadecimal octal constcadena constflotante constcompleja constcaracter ( [ { none true false range",
        "Se espera decimal binario hexadecimal octal",
        "Se espera ( [ range {",
        "Se espera :",
        "Se espera constflotante constcadena constcaracter decimal binario hexadecimal octal constcompleja true false ( [ range { none id ++ -- findall replace len sample choice random randrange mean median variance sum",
        "Se espera ||",
        "Se espera [",
        "Se espera -",
        "Se espera && ##",
        "Se espera !",
        "Se espera < <= == != >= > is isnot in innot",
        "Se espera |",
        "Se espera ^",
        "Se espera &",
        "Se espera << >>",
        "Se espera -  +",
        "Se espera * / // %",
        "Se espera **",
        "Se espera ++ -- [ = += -= *= **= /= //= %= .",
        "Se espera =  +=  /=  *=  -=  //=  **=  %=",
        "Se espera id decimal binario hexadecimal octal constcadena constflotante constcompleja constcaracter ++ -- ( [ { none true false range input findall replace len sample choice random randrange mean median variance sum",
        "Se espera constcadena",
        "Se espera sort reverse count index append extend pop remove insert",
        "Se espera findall replace len sample choice random randrange mean median variance sum",
        "Se espera id decimal binario hexadecimal octal constcadena constflotante constcompleja constcaracter ++ -- ( [ { break continue for if print return while none true false range findall replace len sample choice random randrange mean median variance sum println",
        "Se espera elif else",
        "Error de fuerza bruta" //Error número 632
    };

    String[] lonol3 = {
        "Variable no declarada",
        "Variable duplicada"
    };

    Label lblContadores;
    Label lblIdentificadores;
    Label lblComentarios;
    Label lblReservadas;
    Label lblCE_Dec;
    Label lblCtexto;
    Label lblCE_Hex;
    Label lblCE_Oct;
    Label lblCFlotante;
    Label lblCNComp;
    Label lblCCar;
    Label lblAritmeticos;
    Label lblMonogamos;
    Label lblLogicos;
    Label lblBits;
    Label lblPuntuacion;
    Label lblAgrupacion;
    Label lblAsignacion;
    Label lblRelacionales;
    Label lblCE_Bin;
    Label lblIdentidad;
    Label lblErrores;
    ObservableList<Integer> options;
    ComboBox<Integer> cb;

    @Override
    public void start(Stage primaryStage) {
        /*if, while, do, for, Var, const, func, Proc Switch, int, String, float, char, Boolean, true, false */
        Pane root = new Pane();

        executor = Executors.newSingleThreadExecutor();
        final ObservableList<Errores> errores = FXCollections.observableArrayList(
                new Errores("linea", "descripcion", "numero", "tipo", "lexema")
        );
        final ObservableList<Tokens> tokens = FXCollections.observableArrayList(
                new Tokens("linea", "lexema", "numero")
        );
        final ObservableList<Ambitos> ambitos = FXCollections.observableArrayList(
                new Ambitos("identificador", "ambito", "tipo", "clase", "tamanioArreglo", "dimensionArreglo", "posicionParametro", "funcionOrigen", "cantidadParametros", "ambitoCreado", "avance", "llave")
        );
        Excelsior.jalarSemantica1(semArr);
        l = new Lexico1();
        l.llenarMatriz("src/calarxd.xlsx");
        l.leerCodigoTxt("src/Codigo.txt");
        ca = new CodeArea(/*l.getCodigo()*/);
        ca.setWrapText(true);
        ca.setPrefSize(500, 1000);
        IntFunction<Node> numberFactory = LineNumberFactory.get(ca);
        IntFunction<Node> arrowFactory = new ArrowFactory(ca.currentParagraphProperty());
        IntFunction<Node> graphicFactory = line -> {
            HBox hbox = new HBox(numberFactory.apply(line), arrowFactory.apply(line));
            hbox.setAlignment(Pos.CENTER_LEFT);
            return hbox;
        };
        ca.setParagraphGraphicFactory(graphicFactory);
        ca.richChanges()
                .filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
                .successionEnds(Duration.ofMillis(500))
                .supplyTask(this::computeHighlightingAsync)
                .awaitLatest(ca.richChanges())
                .filterMap(t -> {
                    if (t.isSuccess()) {
                        return Optional.of(t.get());
                    } else {
                        t.getFailure().printStackTrace();
                        return Optional.empty();
                    }
                })
                .subscribe(this::applyHighlighting);

        btnCargar = new Button("Cargar");
        btnCargar.setOnAction((ActionEvent e) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Elegir txt");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                l.setCodigo(l.leerCodigoTxt(file));
            }
            ca.replaceText(l.getCodigo());
        });
        btnCompilar = new Button("Compilar");
        btnCompilar.setOnAction((ActionEvent e) -> {
            System.out.println("***********************************************************\n\n\n\n\n\n");
            AmbitoDB.borrarTodos();
            compilado(errores, tokens, ambitos);
            if (cb.getValue() != null && !cb.getValue().toString().isEmpty()) {
                for (int i = 0; i < contadores.length; i++) {
                    contadores[i] = 0;
                }
                for (Token token : l.getLT()) {
                    if (cb.getValue() != 0 && (token.numeroLinea == cb.getValue())) {
                        sumarContadores(token.numeroToken);
                    } else {
                        sumarContadores(token.numeroToken);
                    }
                }
                for (Error error : l.getLE()) {
                    if (cb.getValue() != 0 && (error.numeroLinea == cb.getValue())) {
                        sumarContadores(error.numeroError);
                    } else {
                        sumarContadores(error.numeroError);
                    }
                }
                actualizarTextfields();
            }
        });
        btnGenerar = new Button("Generar Excel");
        btnGenerar.setOnAction((ActionEvent e) -> {
            int contador = 0;
            do {
                if (Excelsior.crearArchivo(contador)) {
                    Excelsior.excel(errores, excelAmbito, excelSem1, excelSem2, excelCuad);
                    excelCuad = null;
                    break;
                } else {
                    contador++;
                }
            } while (true);
        });

        tablaE = new TableView();
        tablaE.setEditable(false);
        TableColumn NumeroCol = new TableColumn("Numero");
        NumeroCol.setCellValueFactory(
                new PropertyValueFactory<Errores, String>("numero")
        );
        TableColumn DescripcionCol = new TableColumn("Descripcion");
        DescripcionCol.setCellValueFactory(
                new PropertyValueFactory<Errores, String>("descripcion")
        );
        TableColumn LexemaCol = new TableColumn("Lexema");
        LexemaCol.setCellValueFactory(
                new PropertyValueFactory<Errores, String>("lexema")
        );
        TableColumn TipoCol = new TableColumn("Tipo");
        TipoCol.setCellValueFactory(
                new PropertyValueFactory<Errores, String>("tipo")
        );
        TableColumn LineaCol = new TableColumn("Linea");
        LineaCol.setCellValueFactory(
                new PropertyValueFactory<Errores, String>("linea")
        );
        tablaE.setItems(errores);
        tablaE.getColumns().addAll(NumeroCol, LexemaCol, TipoCol, LineaCol, DescripcionCol);

        tablaT = new TableView();
        tablaT.setEditable(false);
        TableColumn numeroCol = new TableColumn("Numero");
        numeroCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("numero")
        );
        TableColumn lexemaCol = new TableColumn("Lexema");
        lexemaCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("lexema")
        );
        TableColumn lineaCol = new TableColumn("Linea");
        lineaCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("linea")
        );
        tablaT.setItems(tokens);
        tablaT.getColumns().addAll(numeroCol, lineaCol, lexemaCol);

        tablaA = new TableView();
        tablaA.setEditable(false);
//        identificador, ambito, tipo, clase, tamanioArreglo, dimensionArreglo, posicionParametro, funcionOrigen, cantidadParametros, ambitoCreado, avance, llave
        TableColumn identificadorCol = new TableColumn("Identificador");
        identificadorCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("identificador")
        );
        TableColumn ambitoCol = new TableColumn("Ámbito");
        ambitoCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("ambito")
        );
        TableColumn tipoCol = new TableColumn("Tipo");
        tipoCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("tipo")
        );
        TableColumn claseCol = new TableColumn("Clase");
        claseCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("clase")
        );
        TableColumn tamanioArregloCol = new TableColumn("Tamaño arreglo");
        tamanioArregloCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("tamanioArreglo")
        );
        TableColumn dimensionArregloCol = new TableColumn("Dimensión arreglo");
        dimensionArregloCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("dimensionArreglo")
        );
        TableColumn posicionParametroCol = new TableColumn("Posición parámetro");
        posicionParametroCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("posicionParametro")
        );
        TableColumn funcionOrigenCol = new TableColumn("Función origen");
        funcionOrigenCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("funcionOrigen")
        );
        TableColumn cantidadParametrosCol = new TableColumn("Cantidad parámetros");
        cantidadParametrosCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("cantidadParametros")
        );
        TableColumn ambitoCreadoCol = new TableColumn("Ámbito creado");
        ambitoCreadoCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("ambitoCreado")
        );
        TableColumn avanceCol = new TableColumn("Avance");
        avanceCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("avance")
        );
        TableColumn llaveCol = new TableColumn("Llave");
        llaveCol.setCellValueFactory(
                new PropertyValueFactory<Tokens, String>("llave")
        );
        tablaA.setItems(ambitos);
        tablaA.getColumns().addAll(identificadorCol, ambitoCol, tipoCol, claseCol, tamanioArregloCol, dimensionArregloCol, posicionParametroCol, funcionOrigenCol, cantidadParametrosCol, ambitoCreadoCol, avanceCol, llaveCol);

        tablaE.setRowFactory(tv -> {
            TableRow<Errores> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if ((!row.isEmpty())) {

                }
            });
            return row;
        });
        VBox vbContadores = new VBox();
        vbContadores.setPadding(new Insets(10, 10, 10, 10));
        vbContadores.setSpacing(10);
        lblContadores = new Label("Contadores:\n\n");
        lblIdentificadores = new Label("Identificadores: 0");
        lblComentarios = new Label("Comentarios: 0");
        lblReservadas = new Label("Reservadas: 0");
        lblCE_Dec = new Label("CE-Dec: 0");
        lblCtexto = new Label("CTexto: 0");
        lblCE_Hex = new Label("CE-Hex: 0");
        lblCE_Oct = new Label("CE-Oct: 0");
        lblCFlotante = new Label("CFlotante: 0");
        lblCNComp = new Label("CNComp: 0");
        lblCCar = new Label("CCar: 0");
        lblAritmeticos = new Label("Aritméticos: 0");
        lblMonogamos = new Label("Monógamos: 0");
        lblLogicos = new Label("Lógicos: 0");
        lblBits = new Label("Bits: 0");
        lblPuntuacion = new Label("Puntuación: 0");
        lblAgrupacion = new Label("Agrupación: 0");
        lblAsignacion = new Label("Asignación: 0");
        lblRelacionales = new Label("Relacionales: 0");
        lblCE_Bin = new Label("CE-Bin: 0");
        lblIdentidad = new Label("Identidad: 0");
        lblErrores = new Label("Errores: 0");
        options = FXCollections.observableArrayList(0);
        cb = new ComboBox(options);
        cb.setValue(0);
        vbContadores.getChildren().addAll(cb,
                lblContadores,
                lblIdentificadores,
                lblComentarios,
                lblReservadas,
                lblCE_Dec,
                lblCtexto,
                lblCE_Hex,
                lblCE_Oct,
                lblCFlotante,
                lblCNComp,
                lblCCar,
                lblAritmeticos,
                lblMonogamos,
                lblLogicos,
                lblBits,
                lblPuntuacion,
                lblAgrupacion,
                lblAsignacion,
                lblRelacionales,
                lblCE_Bin,
                lblIdentidad,
                lblErrores);

        BorderPane p1 = new BorderPane();
        p1.setTranslateX(50);
        p1.setTranslateY(30);
        p1.setMaxSize(520, 800);
        p1.setMinSize(520, 800);
        p1.setCenter(new VirtualizedScrollPane<>(ca));

        tablaE.setTranslateX(600);
        tablaE.setTranslateY(430);
        tablaE.setMaxSize(630, 398);
        tablaE.setMinSize(630, 398);
        tablaE.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tablaT.setTranslateX(1235);
        tablaT.setTranslateY(430);
        tablaT.setMaxSize(635, 398);
        tablaT.setMinSize(635, 398);
        tablaT.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tablaA.setTranslateX(600);
        tablaA.setTranslateY(30);
        tablaA.setMaxSize(1270, 385);
        tablaA.setMinSize(1270, 385);
        tablaA.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        btnCompilar.setMaxSize(150, 30);
        btnCompilar.setMinSize(150, 30);
        btnCompilar.setTranslateX(885);
        btnCompilar.setTranslateY(920);

        btnCargar.setMaxSize(150, 30);
        btnCargar.setMinSize(150, 30);
        btnCargar.setTranslateX(720);
        btnCargar.setTranslateY(920);

        btnGenerar.setMaxSize(150, 30);
        btnGenerar.setMinSize(150, 30);
        btnGenerar.setTranslateX(1050);
        btnGenerar.setTranslateY(920);

        root.getChildren().addAll(p1, tablaE, tablaT, tablaA, btnCargar, btnCompilar, btnGenerar/*, vbContadores*/);

        Scene scene = new Scene(root, 1920, 1080);
        scene.getStylesheets().add(JavaKeywordsAsync.class.getResource("/styles/java-keywords.css").toExternalForm());

        primaryStage.setTitle("Léxico");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void compilado(ObservableList<Errores> errores, ObservableList<Tokens> tokens, ObservableList<Ambitos> ambitos) {
        l.getLE().clear();
        l.getLT().clear();
        errores.clear();
        tokens.clear();
        ambitos.clear();
        l.analizar();
        String a = "";
        for (Token token : l.getLT()) {
            tokens.add(new Tokens("" + token.numeroToken, token.lexema, "" + token.numeroLinea));
        }
        LinkedList<Token> copyLT = (LinkedList) l.getLT().clone();
        Sintaxis synth = new Sintaxis(l.getLT(), l.getLE(), semArr);
        for (Error error : l.getLE()) {
            if (error.tipo.equals("Sintaxis")) {
                errores.add(
                        new Errores("" + error.numeroLinea, lonooool2[error.numeroError - 600], "" + error.numeroError, error.tipo, error.lexema)
                );
            } else if (error.tipo.equals("L")) {
                errores.add(
                        new Errores("" + error.numeroLinea, lonooool[error.numeroError - 500], "" + error.numeroError, "Lexico", error.lexema)
                );
            } else if (error.tipo.equals("Ambito")) {
                errores.add(
                        new Errores("" + error.numeroLinea, lonol3[error.numeroError - 633], "" + error.numeroError, error.tipo, error.lexema)
                );
            } else if (error.tipo.equals("Semantica 1")) {
                if (error.numeroError == ES_1) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Operacion \"" + error.lexema + "\" es incompatible", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_2) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Asignacion \"" + error.lexema + "\" es incompatible", "" + error.numeroError, error.tipo, error.lexema)
                    );
                }
            } else if (error.tipo.equals("Semantica 2")) {
                if (error.numeroError == ES_3) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Se esperaba un booleano", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_1) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Operación \"" + error.lexema + "\" es incompatible", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_4) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Asignacion \"" + error.lexema + "\" es incompatible", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_5) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Variable " + error.lexema + " no es arreglo ni diccionario.", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_6) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Dimension " + error.lexema + " no es correcta.", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_7) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Definicion de arreglo inválida", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_8) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Posición de arreglo negativa", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_9) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Posicion de arreglo no entera", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_10) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Posición fuera de rango", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_11) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Diccionaro no válido", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_12) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Parámetro negativo", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_13) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Asignación no válida", "" + error.numeroError, error.tipo, error.lexema)
                    );
                }
            } else if (error.tipo.equals("Semantica 3")) {
                if (error.numeroError == ES_14) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Parámetro inválido", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_15) {
                    errores.add(
                            new Errores("" + error.numeroLinea, error.lexema.trim() + " no contiene al método", "" + error.numeroError, error.tipo, error.lexema)
                    );
                } else if (error.numeroError == ES_16) {
                    errores.add(
                            new Errores("" + error.numeroLinea, "Valor fuera de rango", "" + error.numeroError, error.tipo, error.lexema)
                    );
                }
            }
        }
        if (l.getLE().isEmpty()) {
            this.excelCuad = synth.llCuadruplos;
            System.out.println("WUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        }
        this.excelAmbito = synth.AmbitoExcel;
        this.excelSem1 = synth.objetoSem1s;
        this.excelSem2 = synth.objetoSem2s;
        for (Ambito r : AmbitoDB.enlistarRegistros()) {
            ambitos.add(
                    //                    identificador, ambito, tipo, clase, tamanioArreglo, dimensionArreglo, posicionParametro, funcionOrigen, cantidadParametros, ambitoCreado, avance, llave
                    new Ambitos(r.getIdentificador(), r.getAmbito() + "", r.getTipo(), r.getClase(), r.getTamanioArreglo() + "", r.getDimensionArreglo() + "", r.getPosicionParametro() + "", r.getFuncionOrigen(), r.getCantidadParametros() + "", r.getAmbitoCreado() + "", r.getAvance() + "", r.getLlave())
            );
        }

    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    MainApp.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

    @Override
    public void stop() {
        executor.shutdown();
    }

    private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
        options.clear();
        l.setCodigo(ca.getText());
        int a = countLines(l.getCodigo());
        options.add(0);
        for (int i = 1; i <= a; i++) {
            options.add(i);
        }
        cb.setValue(0);
        String text = ca.getText();
        Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
            @Override
            protected StyleSpans<Collection<String>> call() throws Exception {
                return computeHighlighting(text);
            }
        };
        executor.execute(task);
        return task;
    }

    private void applyHighlighting(StyleSpans<Collection<String>> highlighting) {
        ca.setStyleSpans(0, highlighting);
    }

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        int contador = 1;
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while (matcher.find()) {
            if (contador % 2 == 0) {
                String styleClass
                        = matcher.group("KEYWORD") != null ? "par"
                        : matcher.group("DOS") != null ? "par"
                        : null;
                /* never happens */ assert styleClass != null;
                spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
                spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
                lastKwEnd = matcher.end();
            } else {
                String styleClass
                        = matcher.group("KEYWORD") != null ? "impar"
                        : matcher.group("DOS") != null ? "impar"
                        : null;
                /* never happens */ assert styleClass != null;
                spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
                spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
                lastKwEnd = matcher.end();
            }
            contador++;
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

    public void sumarContadores(int estado) {
        if (estado >= 500 && estado <= 640) {
            ++contadores[0];
        }
        if (estado == -1) {
            ++contadores[1];
//            identificador++;
        }
        if (estado == -52 || estado == -53) {
            ++contadores[17];
        }
        if (estado <= -54 && estado >= -94) {
//            palabrasreservadas++;
            ++contadores[3];
        }
        if (estado == -3) {
//            cedec++;
            ++contadores[4];
        }
        if (estado == -4) {
//            cebin++;
            ++contadores[5];
        }
        if (estado == -5) {
//            cehex++;
            ++contadores[6];
        }
        if (estado == -6) {
//            ceoct++;
            ++contadores[7];
        }
        if (estado == -7) {
//            ctexto++;
            ++contadores[8];
        }
        if (estado == -8) {
//            cfloat++;
            ++contadores[9];
        }
        if (estado == -9) {
//            cncomp++;
            ++contadores[10];
        }
        if (estado == -10) {
//            ccar++;
            ++contadores[11];
        }
        if (estado <= -11 && estado >= -17) {
//            aritmeticos++;
            ++contadores[12];
        }
        if (estado <= -18 && estado >= -19) {
//            monogamo++;
            ++contadores[13];
        }
        if (estado <= -20 && estado >= -22 || estado == -2) {
//            logico++;
            ++contadores[14];
        }
        if (estado <= -23 && estado >= -28) {
//            relacionales++;
            ++contadores[15];
        }
        if (estado <= -29 && estado >= -33) {
//            bit++;
            ++contadores[16];
        }

        if (estado <= -34 && estado >= -35 || estado == -50 || estado == -51) {
//            puntuacion++;
            ++contadores[18];
        }
        if (estado <= -36 && estado >= -41) {
//            agrupacion++;
            ++contadores[19];
        }
        if (estado <= -42 && estado >= -49) {
//            asignacion++;
            ++contadores[20];
        }
    }

    private static int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }

    public void actualizarTextfields() {
        lblIdentificadores.setText("Identificadores: " + contadores[1]);
        lblReservadas.setText("Reservadas: " + contadores[3]);
        lblCE_Dec.setText("CE-Dec: " + contadores[4]);
        lblCtexto.setText("CTexto: " + contadores[8]);
        lblCE_Hex.setText("CE-Hex: " + contadores[6]);
        lblCE_Oct.setText("CE-Oct: " + contadores[7]);
        lblCFlotante.setText("CFlotante: " + contadores[9]);
        lblCNComp.setText("CNComp: " + contadores[10]);
        lblCCar.setText("CCar: " + contadores[11]);
        lblAritmeticos.setText("Aritméticos: " + contadores[12]);
        lblMonogamos.setText("Monógamos: " + contadores[13]);
        lblLogicos.setText("Lógicos: " + contadores[14]);
        lblBits.setText("Bits: " + contadores[16]);
        lblPuntuacion.setText("Puntuación: " + contadores[18]);
        lblAgrupacion.setText("Agrupación: " + contadores[19]);
        lblAsignacion.setText("Asignación: " + contadores[20]);
        lblRelacionales.setText("Relacionales: " + contadores[15]);
        lblCE_Bin.setText("CE-Bin: " + contadores[5]);
        lblIdentidad.setText("Identidad: " + contadores[17]);
        lblErrores.setText("Errores: " + contadores[0]);
    }

    private List<Error> errors;
    private List<Token> tokenes;
    private List<Integer> contadors;
//    private List<Integer> contadors;

//    @Before
    public void setUp() throws Exception {
        errors = new ArrayList<>();
        for (Error error : l.getLE()) {
            errors.add(error);
        }

        tokenes = new ArrayList<>();
        for (Token token : l.getLT()) {
            tokenes.add(token);
        }

        contadors = new ArrayList<>();
        Integer c1 = new Integer(1);
        Integer c2 = new Integer(2);
        Integer c3 = new Integer(3);
        Integer c4 = new Integer(4);
        contadors.add(c1);
        contadors.add(c2);
        contadors.add(c3);
        contadors.add(c4);
    }

    public void testWriteToExcelInMultiSheets() {
        writeToExcelInMultiSheets("src/Jesus Alonso Figueroa Urias 02052018.xlsx",
                "Error Details", errors, countLines(l.getCodigo()), contadores, l.getLE(), l.getLT(), l.Comentarios);
    }

    private static String capitalize(String s) {
        if (s.length() == 0) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public <T> void writeToExcelInMultiSheets(final String fileName, final String sheetName,
            final List<T> data/*, List<String> fieldNames*/, int n, int[] contadores, LinkedList<Error> errores, LinkedList<Token> tokens, LinkedList<Token> Comentarios) {
        File file = null;
        OutputStream fos = null;
        XSSFWorkbook workbook = null;
        try {
            file = new File(fileName);
            Sheet sheet = null;
            if (file.exists()) {
                workbook = (XSSFWorkbook) WorkbookFactory.create(new FileInputStream(file));
            } else {
                workbook = new XSSFWorkbook();
            }

            Sheet Sh = workbook.getSheet("Hoja 1");
            if (Sh != null) {
                int index = workbook.getSheetIndex(Sh);
                workbook.removeSheetAt(index);
            }

            Sheet Sh1 = workbook.getSheet("Error Details");
            if (Sh1 != null) {
                int index = workbook.getSheetIndex(Sh1);
                workbook.removeSheetAt(index);
            }

            Sheet Sh2 = workbook.getSheet("Token Details");
            if (Sh2 != null) {
                int index = workbook.getSheetIndex(Sh2);
                workbook.removeSheetAt(index);
            }

            Sheet ShContadores = workbook.getSheet("Contadores");
            if (ShContadores != null) {
                int index = workbook.getSheetIndex(ShContadores);
                workbook.removeSheetAt(index);
            }
            ShContadores = workbook.createSheet("Contadores");

            Sheet ShTokens = workbook.getSheet("Tokens");
            if (ShTokens != null) {
                int index = workbook.getSheetIndex(ShTokens);
                workbook.removeSheetAt(index);
            }
            ShTokens = workbook.createSheet("Tokens");

            Sheet ShErrores = workbook.getSheet("Errores");
            if (ShErrores != null) {
                int index = workbook.getSheetIndex(ShErrores);
                workbook.removeSheetAt(index);
            }
            ShErrores = workbook.createSheet("Errores");

            Row row = ShContadores.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("     ");
            cell = row.createCell(1);
            cell.setCellValue("Id");
            cell = row.createCell(2);
            cell.setCellValue("Comentarios");
            cell = row.createCell(3);
            cell.setCellValue("Palabras reservadas");
            cell = row.createCell(4);
            cell.setCellValue("ENTERAS");
            cell = row.createCell(5);
            cell.setCellValue("Texto");
            cell = row.createCell(6);
            cell.setCellValue("Decimal");
            cell = row.createCell(7);
            cell.setCellValue("Caracter");
            cell = row.createCell(8);
            cell.setCellValue("Matemáticos");
            cell = row.createCell(9);
            cell.setCellValue("Monógamos");
            cell = row.createCell(10);
            cell.setCellValue("Lógicos");
            cell = row.createCell(11);
            cell.setCellValue("Relacionales");
            cell = row.createCell(12);
            cell.setCellValue("Desplazamiento");
            cell = row.createCell(13);
            cell.setCellValue("Signos de puntuación");
            cell = row.createCell(14);
            cell.setCellValue("Signos de agrupacion");
            cell = row.createCell(15);
            cell.setCellValue("Errores");
            cell = row.createCell(16);
            cell.setCellValue("Signos de asignación");
            cell = row.createCell(17);
            cell.setCellValue("Exponencial");
            for (int i = 1; i < n + 1; i++) {
//                llenarContadores(tokens, errores, Comentarios, i);
                row = ShContadores.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue("Linea " + (i));
                cell = row.createCell(1);
                cell.setCellValue("" + contadores[9]);
                cell = row.createCell(2);
                cell.setCellValue("" + contadores[3]);
                cell = row.createCell(3);
                cell.setCellValue("" + contadores[14]);
                cell = row.createCell(4);
                cell.setCellValue("" + contadores[10]);
                cell = row.createCell(5);
                cell.setCellValue("" + contadores[15]);
                cell = row.createCell(6);
                cell.setCellValue("" + contadores[11]);
                cell = row.createCell(7);
                cell.setCellValue("" + contadores[13]);
                cell = row.createCell(8);
                cell.setCellValue("" + contadores[0]);
                cell = row.createCell(9);
                cell.setCellValue("" + contadores[1]);
                cell = row.createCell(10);
                cell.setCellValue("" + contadores[5]);
                cell = row.createCell(11);
                cell.setCellValue("" + contadores[4]);
                cell = row.createCell(12);
                cell.setCellValue("" + contadores[6]);
                cell = row.createCell(13);
                cell.setCellValue("" + contadores[8]);
                cell = row.createCell(14);
                cell.setCellValue("" + contadores[7]);
                cell = row.createCell(15);
                cell.setCellValue("" + contadores[16]);
                cell = row.createCell(16);
                cell.setCellValue("" + contadores[2]);
                cell = row.createCell(17);
                cell.setCellValue("" + contadores[12]);
            }
//            llenarContadores(tokens, errores, Comentarios);
            row = ShContadores.createRow(n + 1);
            cell = row.createCell(0);
            cell.setCellValue("Total");
            cell = row.createCell(1);
            cell.setCellValue("" + contadores[9]);
            cell = row.createCell(2);
            cell.setCellValue("" + contadores[3]);
            cell = row.createCell(3);
            cell.setCellValue("" + contadores[14]);
            cell = row.createCell(4);
            cell.setCellValue("" + contadores[10]);
            cell = row.createCell(5);
            cell.setCellValue("" + contadores[15]);
            cell = row.createCell(6);
            cell.setCellValue("" + contadores[11]);
            cell = row.createCell(7);
            cell.setCellValue("" + contadores[13]);
            cell = row.createCell(8);
            cell.setCellValue("" + contadores[0]);
            cell = row.createCell(9);
            cell.setCellValue("" + contadores[1]);
            cell = row.createCell(10);
            cell.setCellValue("" + contadores[5]);
            cell = row.createCell(11);
            cell.setCellValue("" + contadores[4]);
            cell = row.createCell(12);
            cell.setCellValue("" + contadores[6]);
            cell = row.createCell(13);
            cell.setCellValue("" + contadores[8]);
            cell = row.createCell(14);
            cell.setCellValue("" + contadores[7]);
            cell = row.createCell(15);
            cell.setCellValue("" + contadores[16]);
            cell = row.createCell(16);
            cell.setCellValue("" + contadores[2]);
            cell = row.createCell(17);
            cell.setCellValue("" + contadores[12]);

            row = ShTokens.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue("Token");
            cell = row.createCell(1);
            cell.setCellValue("Lexema");
            cell = row.createCell(2);
            cell.setCellValue("Linea");
            cell = row.createCell(3);
            cell.setCellValue("Incluido");
            for (int i = 0; i < tokens.size(); i++) {
                row = ShTokens.createRow(i + 1);
                cell = row.createCell(0);
                cell.setCellValue(tokens.get(i).numeroToken);
                cell = row.createCell(1);
                cell.setCellValue(tokens.get(i).lexema);
                cell = row.createCell(2);
                cell.setCellValue(tokens.get(i).numeroLinea);
                cell = row.createCell(3);
                cell.setCellValue("Si");
            }
            for (int i = 0; i < Comentarios.size(); i++) {
                row = ShTokens.createRow(i + tokens.size() + 1);
                cell = row.createCell(0);
                cell.setCellValue(Comentarios.get(i).numeroToken);
                cell = row.createCell(1);
                cell.setCellValue(Comentarios.get(i).lexema);
                cell = row.createCell(2);
                cell.setCellValue(Comentarios.get(i).numeroLinea);
                cell = row.createCell(3);
                cell.setCellValue("No");
            }

            row = ShErrores.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue("Token");
            cell = row.createCell(1);
            cell.setCellValue("Descipción");
            cell = row.createCell(2);
            cell.setCellValue("Lexema");
            cell = row.createCell(3);
            cell.setCellValue("Tipo");
            cell = row.createCell(4);
            cell.setCellValue("Linea");
            for (int i = 0; i < errores.size(); i++) {
                String a = "";
                a = lonooool[errores.get(i).numeroError - 500];
                row = ShErrores.createRow(i + 1);
                cell = row.createCell(0);
                cell.setCellValue(errores.get(i).numeroError);
                cell = row.createCell(1);
                cell.setCellValue(a);
                cell = row.createCell(2);
                cell.setCellValue(errores.get(i).lexema);
                cell = row.createCell(3);
                cell.setCellValue(errores.get(i).tipo);
                cell = row.createCell(4);
                cell.setCellValue(errores.get(i).numeroLinea);
            }
            fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
