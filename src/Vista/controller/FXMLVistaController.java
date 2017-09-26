/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.controller;


import Vista.Index;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author andresvizcaino
 */
public class FXMLVistaController implements Initializable {
    
    @FXML
    public JFXDrawer lienzo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    void cambiarScene(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();
        VBox box = null;
        switch(btn.getText())
        {
            case "Contactos":
                System.out.println("Contactos");
                box = FXMLLoader.load(Index.class.getResource("fxml/FXMLContactos.fxml"));
                break;
            case "Agregar":
                System.out.println("Agregar");
                box = FXMLLoader.load(Index.class.getResource("fxml/FXMLAgregar.fxml"));
                break;
            case "Estadisticas":
                System.out.println("Estadistica");
                box = FXMLLoader.load(Index.class.getResource("fxml/FXMLEstadisticas.fxml"));
                break;
        }
        lienzo.setSidePane(box);
        lienzo.open();
    }
    

}
