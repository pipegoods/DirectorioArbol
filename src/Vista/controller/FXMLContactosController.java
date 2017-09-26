/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.controller;

import Logica.Nodo;
import Vista.Index;
import com.jfoenix.controls.JFXListView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author andresvizcaino
 */
public class FXMLContactosController implements Initializable {

    @FXML
    private JFXListView<Label> tabla;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabla.setExpanded(false);
        for (Nodo object : Index.DIR.inorden()) {
            Label label = new Label("   " + object.getDatos().getNOMBRE());
            label.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.USER).setStyleClass("custom-jfx-list-view-icon"));
            tabla.getItems().add(label);
        }
    }

    @FXML
    void expandirOff(MouseEvent event) {
        tabla.setStyle("-jfx-expanded: false");
        tabla.depthProperty().set(0);
        tabla.setExpanded(false);
    }

    @FXML
    void expandirOn(MouseEvent event) {
        tabla.setStyle("-jfx-expanded: true");
        tabla.depthProperty().set(1);
        tabla.setExpanded(true);
    }

}
