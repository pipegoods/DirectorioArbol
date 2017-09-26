/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.controller;

import Vista.Index;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author andresvizcaino
 */
public class FXMLEstadisticasController implements Initializable {
    @FXML
    private Label txt_hojas;

    @FXML
    private Label txt_padres;

    @FXML
    private Label txt_niveles;

    @FXML
    private Label txt_altura;

    @FXML
    private Label txt_cantidad;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }    
    
    private void refresh(){
        txt_hojas.setText(String.valueOf(Index.DIR.retornarCantidadHojas()));
        txt_padres.setText(String.valueOf(Index.DIR.retornarCantidad() - Index.DIR.retornarCantidadHojas()));
        txt_niveles.setText(String.valueOf(Index.DIR.retornarAltura()-1) );
        txt_altura.setText(String.valueOf(Index.DIR.retornarAltura()));
        txt_cantidad.setText(String.valueOf(Index.DIR.retornarCantidad()));
    }
    
}
