/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesNormales;

public class Data {
    private static String archivoPreguntas;
    private static String archivoRespuestas;
    private static int cantidadPreguntas;
    private static BinaryTree<String> arbolPreguntas;

    public static String getArchivoPreguntas() {
        return archivoPreguntas;
    }

    public static BinaryTree<String> getArbolPreguntas() {
        return arbolPreguntas;
    }

    public static void setArbolPreguntas(BinaryTree<String> arbolPreguntas) {
        Data.arbolPreguntas = arbolPreguntas;
    }

    public static void setArchivoPreguntas(String archivo) {
        archivoPreguntas = archivo;
    }
    
    public static String getArchivoRespuestas() {
        return archivoRespuestas;
    }

    public static void setArchivoRespuestas(String archivo) {
        archivoRespuestas = archivo;
    }
    
    public static int getCantidadPreguntas() {
        return cantidadPreguntas;
    }

    public static void setCantidadPreguntas(int numero) {
        cantidadPreguntas = numero;
    }

}
