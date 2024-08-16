package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PresentacionController implements Initializable {

    @FXML private Button button1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    
    @FXML
    private void switchToInstrucciones() throws IOException {
        App.setRoot("Instrucciones");
    }
    
}
