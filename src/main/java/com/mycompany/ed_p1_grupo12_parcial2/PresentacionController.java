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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author jorge
 */
public class PresentacionController implements Initializable {
    
    @FXML
    private ImageView myImageView;
    
    @FXML
    private Button button1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Cargar el GIF animado desde el directorio de recursos
        Image gifImage = new Image(getClass().getResourceAsStream("/images/hojas.gif"));
        myImageView.setImage(gifImage);
    }
    
    @FXML
    private void switchToCargarArchivos() throws IOException {
        App.setRoot("CargarArchivos");
    }
    
}
