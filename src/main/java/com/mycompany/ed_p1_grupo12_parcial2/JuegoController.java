package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class JuegoController implements Initializable {
    
    @FXML private Button si;
    @FXML private Button no;
    @FXML private Button opciones;
    @FXML private Label texto;
    @FXML private Label contador;
    @FXML private TextField respuesta;

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
        App.setRoot("Opciones");
    } 
    
}
