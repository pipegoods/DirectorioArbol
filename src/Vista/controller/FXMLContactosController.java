/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.controller;

import Logica.Nodo;
import Vista.Index;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author andresvizcaino
 */
public class FXMLContactosController implements Initializable {

    @FXML
    private JFXListView<Label> tabla;
    private JFXPopup pop = new JFXPopup();
    private String nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTabla();

        tabla.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Label>() {
                    public void changed(ObservableValue<? extends Label> observable,
                            Label oldValue, Label newValue) {
                        nom = newValue.getText().replace("   ", "") != null ? newValue.getText().replace("   ", "") : "";
                        System.out.println(nom);
                    }
                });

        tabla.setExpanded(true);

        initPopup();

    }

    private void initPopup() {
        JFXButton elim = new JFXButton("Eliminar Contacto", new MaterialDesignIconView(MaterialDesignIcon.DELETE));
        elim.setOnMouseClicked((e) -> {
            eliminar();
        });
        elim.setPadding(new Insets(10));
        VBox box = new VBox(elim);
        pop.setPopupContent(box);
    }

    @FXML
    void abrirPOP(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY && !"No hay informacion".equals(nom)) {
            pop.show(tabla, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, event.getX(), event.getY());
        }
    }

    private void eliminar() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + nom + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            if (nom != null) {
                Index.DIR.removerContacto(nom);
                nom = "";
                initTabla();
            }
        }
    }

    private void initTabla() {
        tabla.getItems().clear();
        Label a = new Label("No hay informacion", new FontAwesomeIconView(FontAwesomeIcon.ANGELLIST));
        tabla.getItems().add(a);
        for (Nodo object : Index.DIR.inorden()) {
            Label label = new Label("   " + object.getDatos().getNOMBRE());
            //label.setStyle("-fx-font-size: 1.5em ; -fx-font-weight: bold;");
            label.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.USER).setStyleClass("custom-jfx-list-view-icon"));

            tabla.getItems().add(label);
        }
        if (tabla.getItems().size()>1) {
            tabla.getItems().remove(a);
        }
    }

}
