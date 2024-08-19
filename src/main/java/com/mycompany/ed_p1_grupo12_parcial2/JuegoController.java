package com.mycompany.ed_p1_grupo12_parcial2;

import ClasesNormales.BinaryTree;
import ClasesNormales.Data;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JuegoController implements Initializable {
    
    @FXML private Button si;
    @FXML private Button no;
    @FXML private Button opciones;
    @FXML private Label texto;
    
    private BinaryTree<String> arbolPreguntas;
    private int preguntasRestantes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arbolPreguntas = Data.getArbolPreguntas(); 
        preguntasRestantes = Data.getCantidadPreguntas();

        if (arbolPreguntas != null && arbolPreguntas.getRoot() != null) {
            texto.setText(arbolPreguntas.getRoot().getContent());
        }
//        //Ver numero de pregunta 
//        contador.setText("Preguntas restantes: " + preguntasRestantes);
    }
    @FXML
    private void OpcionSi() {
        avanzarJuego(true);
    }
    @FXML
    private void OpcionNo() {
        avanzarJuego(false);
    }
    
    private boolean juegoTerminado(){
        return true;
    }
    
    private void avanzarJuego(boolean si) {
        if (arbolPreguntas != null) {
            if (si) {
                arbolPreguntas = arbolPreguntas.getRoot().getLeft();
            } else {
                arbolPreguntas = arbolPreguntas.getRoot().getRight();
            }

            preguntasRestantes--;


            if (preguntasRestantes > 0 && arbolPreguntas != null && !arbolPreguntas.isLeaf()) {
                texto.setText(arbolPreguntas.getRoot().getContent());
//                contador.setText("Resta: " + preguntasRestantes);
            } else {
                terminarJuego();
            }
        }
    }
    
    private void terminarJuego() {
        if (arbolPreguntas != null && arbolPreguntas.isLeaf()) {
            texto.setText("Respuesta final: " + arbolPreguntas.getRoot().getContent());
        } else  { //Aqui se implementar crear lista de animales que
            texto.setText("No preguntas");
        }
        si.setDisable(true);
        no.setDisable(true);
    }
    
    @FXML
    private void switchToOpciones() throws IOException {
        Thread thread = new Thread(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Opciones.fxml"));
                Parent root = loader.load();
                
                Platform.runLater(() -> {
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Opciones");
                    stage.show();
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
    
}
