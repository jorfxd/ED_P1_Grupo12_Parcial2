/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ed_p1_grupo12_parcial2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jorge
 */
public class OpcionesController implements Initializable {

    @FXML
    private Button jugarDenuevo;
    @FXML
    private Button irAMenu;
    @FXML
    private Button irArchivos;
    @FXML
    private Button salir;
    
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
        App.setRoot("juego");
    }
    @FXML
    private void salir() {
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();
    }
}
