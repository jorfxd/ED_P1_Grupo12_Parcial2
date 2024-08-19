package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JuegoController implements Initializable {
    
    @FXML private Button si;
    @FXML private Button no;
    @FXML private Button opciones;
    @FXML private Label contador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void OpcionSi() {
        
    }
    
    private void OpcionNo() {
        
    }
    
    private boolean juegoTerminado(){
        boolean valor = true;
        return valor;
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
