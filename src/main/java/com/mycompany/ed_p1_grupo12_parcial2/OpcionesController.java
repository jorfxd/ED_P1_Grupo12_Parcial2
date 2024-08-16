package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpcionesController implements Initializable {

    @FXML private Button jugarDenuevo;
    @FXML private Button irAMenu;
    @FXML private Button irArchivos;
    @FXML private Button salir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToCargarArchivos() throws IOException {
        App.setRoot("CargarArchivos");
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("Menu");
    }
    
    @FXML
    private void switchToJuego() throws IOException {
        App.setRoot("Juego");
    }
    
    @FXML
    private void salir() {
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();
    }
}
