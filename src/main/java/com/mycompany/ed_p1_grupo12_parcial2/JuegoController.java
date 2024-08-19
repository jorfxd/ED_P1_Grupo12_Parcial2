package com.mycompany.ed_p1_grupo12_parcial2;

import ClasesNormales.BinaryTree;
import ClasesNormales.Data;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
            texto.setText(" No preguntas");
        }
        si.setDisable(true);
        no.setDisable(true);
    }
    
    @FXML
    private void switchToOpciones() throws IOException {
        VBox root = new VBox();             
        Scene g = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(g);
        stage.setTitle("Detalles de Ubicación");
        stage.show();

        Thread thread = new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                int finalI = i;
                Platform.runLater(() -> {
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        Platform.runLater(() -> stage.close());
        });

        thread.start();
    } 
    
}
