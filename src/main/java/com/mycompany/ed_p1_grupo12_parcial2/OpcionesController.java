package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpcionesController implements Initializable {

    @FXML private Button volverJuego;
    @FXML private Button irArchivos;
    @FXML private Button irAPre;
    @FXML private Button salir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToJuego() throws IOException {
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void switchToCargarArchivos() throws IOException {
        App.setRoot("CargarArchivos");
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void switchToPresentacion() throws IOException {
        App.setRoot("Presentacion");
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void salir() {
        Platform.exit();
    }
}
