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
public class ErroresC {

    public static class ErroresSemantica1 {

        public static Integer ES_1 = 635; //Error de incompatibilidad operacion
        public static Integer ES_2 = 636; //Error de incompatibilidad asignacion
    }

    public static class ErroresSemantica2 {

        public static Integer ES_3 = 637; //Error booleano if, while, elif
        public static Integer ES_4 = 638; //Incompatibilidad asignación
        public static Integer ES_5 = 639; //No es un arreglo
        public static Integer ES_6 = 640; //Dimensiones incorrectas
        public static Integer ES_7 = 641; //Definicion arreglo incorrecta
        public static Integer ES_8 = 642; //Posicion negativa arreglo
        public static Integer ES_9 = 643; //Posicion no entera
        public static Integer ES_10 = 644; //Posicion fuera de rango
        public static Integer ES_11 = 645; //Diccionario inválido
        public static Integer ES_12 = 646; //diccionario parametro negativo
        public static Integer ES_13 = 647; //Asignación no válida

    }

    public static class ErroresSemantica3 {

        public static Integer ES_14 = 648; //Parametro no válido
        public static Integer ES_15 = 649; //No es lista
        public static Integer ES_16 = 650; //Pop valor fuera de rango
    }
}
