package com.mycompany.ed_p1_grupo12_parcial2;

import ClasesNormales.Jugador;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
    @FXML private TextField nombreArchivoPreguntas;
    @FXML private TextField nombreArchivoRespuestas;
    @FXML private ImageView gif;
    @FXML private Label mensaje;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Cargar el GIF animado desde el directorio de recursos
        Image gifImage = new Image(getClass().getResourceAsStream("/Images/guessAnimal.gif"));
        gif.setImage(gifImage);
    }
    
    private boolean verificaArchivos(String archivo1,String archivo2){
        String carpeta = "src/main/resources/Saved_files/";

        // Crea objetos File para los archivos
        File file1 = new File(carpeta + archivo1+".txt");
        File file2 = new File(carpeta + archivo2+".txt");

        // Verifica si ambos archivos existen
        return file1.exists() && file2.exists();
    }
    
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
        String nombre = nombreJugador.getText();
        String cantidadPre = cantidadPreguntas.getText();
        String archivoPre = nombreArchivoPreguntas.getText();
        String archivoRe = nombreArchivoRespuestas.getText();
        
        boolean nombreNoVacio = nombre != null && !nombre.isEmpty();
        boolean cantidadNoVacia = cantidadPre != null && !cantidadPre.isEmpty();
        boolean archivoPreNoVacio = archivoPre != null && !archivoPre.isEmpty();
        boolean archivoReNoVacio = archivoRe != null && !archivoRe.isEmpty();
        
        if(nombreNoVacio && cantidadNoVacia && archivoPreNoVacio && archivoReNoVacio){
            Jugador jugador = new Jugador(nombre);
            boolean verificarArchivos=verificaArchivos(archivoPre,archivoRe);
            if(verificarArchivos){
                App.setRoot("Juego");
            }else{
                mensaje.setText("!Ingrese los Nombres de los archivos correctamente!");}
        }else{
            mostrarAlerta("Debe llenar los campos",Alert.AlertType.WARNING);}  
    }
    
    public int getCantidadPreguntas(){
        int cantidad=Integer.parseInt(cantidadPreguntas.getText());
        return cantidad;
    }
    public String getArchivoPreguntas(){
        String carpeta = "src/main/resources/saved_files/";
        return carpeta+nombreArchivoPreguntas.getText()+".txt";
    }
    
    public String getArchivoRespuestas(){
        String carpeta = "src/main/resources/saved_files/";
        return carpeta+nombreArchivoRespuestas.getText()+".txt";
    }
    
}
