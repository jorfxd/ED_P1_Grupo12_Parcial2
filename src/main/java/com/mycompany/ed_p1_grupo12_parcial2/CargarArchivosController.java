package com.mycompany.ed_p1_grupo12_parcial2;

import ClasesNormales.Data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class CargarArchivosController implements Initializable {
    
    private final BooleanProperty preguntas = new SimpleBooleanProperty(false);
    private final BooleanProperty respuestas = new SimpleBooleanProperty(false);
    
    @FXML private Button loadFileButton;
    @FXML private Label fileNameLabel;
    @FXML private Button loadFileButton2;
    @FXML private Label fileNameLabel2;
    @FXML private Button loadFileButton3;
    @FXML private Button next;
    @FXML private Button btc1;
    @FXML private Button btc2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    //Utilizando la tecnica extraer metodo
    private String cargarArchivoComun(Button boton,Label label,BooleanProperty archivo){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo TXT");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        // Obtener la ventana actual
        Stage stage = (Stage) boton.getScene().getWindow();

        // Mostrar el cuadro de diálogo para seleccionar un archivo
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            label.setText("Archivo seleccionado: " + selectedFile.getName());

            // Define la ruta de destino dentro de tu proyecto
            Path destinationPath = Path.of("src/main/resources/Saved_files", selectedFile.getName());

            try {
                // Crea el directorio si no existe
                Files.createDirectories(destinationPath.getParent());

                // Copia el archivo seleccionado a la ruta de destino
                Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

                archivo.set(true);
                label.setText("ARCHIVO GUARDADO\nCON ÉXITO");
                return destinationPath.toString(); //Si esto no funciona: App.pathFiles+selectedFile.getName();
            } catch (IOException e) {
                e.printStackTrace();
                label.setText("ERROR AL GUARDAR\nEL ARCHIVO");
            }
        } else {
            label.setText("NO SE SELECCIONÓ\nNINGÚN ARCHIVO");
        }
        return null;
    }
    
    @FXML
    private void loadFilePreguntas() {
        String archivo=cargarArchivoComun(loadFileButton,fileNameLabel,preguntas);
        if (archivo != null) {
            Data.setArchivoPreguntas(archivo);
        }
    }
    
    @FXML
    private void loadFileRespuestas() {
        String archivo=cargarArchivoComun(loadFileButton2,fileNameLabel2,respuestas);
        if (archivo != null) {
            Data.setArchivoRespuestas(archivo);
        }
    }
    
    private void mostrarAlerta(String mensaje, AlertType tipoAlerta) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        boolean ingresoArchivoPreguntas = preguntas.get();
        boolean ingresoArchivoRespuestas = respuestas.get();
        if(ingresoArchivoPreguntas && ingresoArchivoRespuestas){
            App.setRoot("Menu");
        }else{
            mostrarAlerta("Debe cargar los archivos de preguntas y respuestas antes de continuar.",AlertType.WARNING);
        }
        
    }
    
    @FXML
    private void switchToInstrucciones()throws IOException{
        App.setRoot("Instrucciones");
    }
}
