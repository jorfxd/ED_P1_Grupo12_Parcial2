package com.mycompany.ed_p1_grupo12_parcial2;

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
    @FXML private TextField nombreArchivoPreguntas;
    @FXML private TextField nombreArchivoRespuestas;
    
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
        
        if(nombreNoVacio && cantidadNoVacia && apodoNoVacio){
            
            boolean verificar = crearJugador(nombre, apodo, apodosRegistrados, App.pathFiles + "Jugadores.txt");
            if(verificar){
                App.setRoot("Juego");
            } else {
                apodoJugador.setText("Este apodo ya existe.");
            }
        }else{
            mostrarAlerta("Debe llenar todos los campos",Alert.AlertType.WARNING);}  
    }
    
    public int getCantidadPreguntas(){
        int cantidad = Integer.parseInt(cantidadPreguntas.getText());
        return cantidad;
    }
    public String getArchivoPreguntas(){
        String carpeta = "src/main/resources/saved_files/";
        return carpeta + nombreArchivoPreguntas.getText()+".txt";
    }
    
    public String getArchivoRespuestas(){
        String carpeta = "src/main/resources/saved_files/";
        return carpeta + nombreArchivoRespuestas.getText()+".txt";
    }
    
}
