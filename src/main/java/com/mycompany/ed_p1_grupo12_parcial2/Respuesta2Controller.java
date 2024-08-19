package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Respuesta2Controller implements Initializable {

    @FXML Button opciones;
    @FXML Button btnNoRespuesta;
    @FXML Button btnSiRespuesta;
    @FXML ListView listaPosible;
    
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
    private void switchTo3() throws IOException {
        App.setRoot("Respuesta3");
    }

}
