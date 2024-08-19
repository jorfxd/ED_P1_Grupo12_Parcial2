package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Respuesta1Controller implements Initializable {

    @FXML Button opciones;
    @FXML Label nombreAnimal;
    @FXML Button btnCorrecto;
    @FXML Button btnIncorrecto;
    @FXML ImageView imagenAnimal;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void switchToOpciones() throws IOException {
        
    }
    
    @FXML
    private void switchToCorrecto() throws IOException {
        App.setRoot("Correcto");
    }
    
    @FXML
    private void switchToIncorrecto() throws IOException {
        App.setRoot("Incorrecto");
    }


}
