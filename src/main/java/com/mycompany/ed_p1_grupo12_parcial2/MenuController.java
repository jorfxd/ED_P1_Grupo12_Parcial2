package com.mycompany.ed_p1_grupo12_parcial2;

import ClasesNormales.Data;
import ClasesNormales.Jugador;
import static ClasesNormales.Jugador.crearJugador;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MenuController implements Initializable {
    
    @FXML Button juego;
    @FXML Button retroceder;
    @FXML private TextField nombreJugador;
    @FXML private TextField cantidadPreguntas;
    @FXML private TextField apodoJugador;
    
    static ArrayList<Jugador> apodosRegistrados = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombreJugador.setStyle("-fx-text-fill: #325887;");
        cantidadPreguntas.setStyle("-fx-text-fill: #325887;");
        apodoJugador.setStyle("-fx-text-fill: #325887;");
        //TODO
    }
    
//    private boolean verificaArchivos(String archivo1,String archivo2){
//        String carpeta = "src/main/resources/Saved_files/";
//
//        // Crea objetos File para los archivos
//        File file1 = new File(carpeta + archivo1+".txt");
//        File file2 = new File(carpeta + archivo2+".txt");
//
//        // Verifica si ambos archivos existen
//        return file1.exists() && file2.exists();
//    }
    
    private void mostrarAlerta(String mensaje, Alert.AlertType tipoAlerta) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    @FXML
    private void switchToCargarArchivos() throws IOException {
        App.setRoot("CargarArchivos");  
    }
    
    @FXML
    private void switchToJuego() throws IOException {
        apodosRegistrados = Jugador.objetoJugadores(App.pathFiles + "Jugadores.txt");
        String nombre = nombreJugador.getText();
        String apodo = apodoJugador.getText();
        String cantidadPre = cantidadPreguntas.getText();

        boolean nombreNoVacio = nombre != null && !nombre.isEmpty();
        boolean apodoNoVacio = apodo != null && !apodo.isEmpty();
        boolean cantidadNoVacia = cantidadPre != null && !cantidadPre.isEmpty();

        if (nombreNoVacio && cantidadNoVacia && apodoNoVacio) {
            try {
                int cantpre = Integer.parseInt(cantidadPre);  

                if (rango(cantpre)) {  // Se verifica si está en el rango permitido
                    boolean verificar = crearJugador(nombre, apodo, apodosRegistrados, App.pathFiles + "Jugadores.txt");
                    setCantidadPreguntas(cantidadPre);

                    if (verificar) {
                        App.setRoot("Juego");
                    } else {
                        apodoJugador.setText("Este apodo ya existe.");
                    }
                } else {
                    cantidadPreguntas.setText("Las preguntas deben ser > 0 y <= 20.");
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Por favor ingrese un número válido para la cantidad de preguntas.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Debe llenar todos los campos", Alert.AlertType.WARNING);
        }
    }
    
    public void setCantidadPreguntas(String cantidadPre){
        
            int cantidad = Integer.parseInt(cantidadPre);
            if(rango(cantidad)){
                Data.setCantidadPreguntas(cantidad);
            
            
        } 
    }
    
    public boolean rango(int cantidad){
        return cantidad > 0 && cantidad <= 20;
    }
    
}
