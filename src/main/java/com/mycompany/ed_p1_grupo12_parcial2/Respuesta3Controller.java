package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Respuesta3Controller implements Initializable {

    @FXML Button btnVolver;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void switchToPresentacion() throws IOException {
        App.setRoot("Presentacion");
    }

}
