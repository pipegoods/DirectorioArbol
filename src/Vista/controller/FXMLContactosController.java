/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.controller;

import Logica.Contacto;
import Logica.Nodo;
import Vista.Index;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.controlsfx.control.Notifications;

/**
 * FXML ContactosController class
 *
 * @author andresvizcaino
 */
public class FXMLContactosController implements Initializable {

    @FXML
    private JFXListView<Label> tabla;
    private final JFXPopup pop = new JFXPopup();
    private String nom;
    @FXML
    private JFXTextField txt_buscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txt_buscar.setDisable(true);
        initTabla();
        // Listener de la tabla
        tabla.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends Label> observable, Label oldValue, Label newValue) -> {
                    nom = newValue.getText().replace("   ", "") != null ? newValue.getText().replace("   ", "") : "";
                });
        tabla.setExpanded(true);
        initPopup();

    }

    /**
     * Metodo initPop Crear la opcion del click derecho de la tabla
     */
    private void initPopup() {
        JFXButton elim = new JFXButton("Eliminar Contacto", new MaterialDesignIconView(MaterialDesignIcon.DELETE));
        JFXButton showI = new JFXButton("Ver en detalle", new MaterialDesignIconView(MaterialDesignIcon.PIG));
        elim.setOnMouseClicked((e) -> {
            eliminar();
        });
        showI.setOnMouseClicked((e) -> {
            showInformation();
        });
        elim.setPadding(new Insets(10));
        showI.setPadding(new Insets(10));
        VBox box = new VBox(elim, showI);
        pop.setPopupContent(box);
    }

    /**
     * Metodo clickDerecho Abre el pop
     */
    @FXML
    void abrirPOP(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY && !"No hay informacion".equals(nom)) {
            pop.show(tabla, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, event.getX(), event.getY());
        }
    }

    /**
     * Metodo eliminar LLama al metodo 'eliminarContacto' de manipulaDirectorio
     */
    private void eliminar() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Seguro quieres eliminar a: " + nom + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            if (nom != null) {
                Index.DIR.removerContacto(nom);
                nom = "";
                Notifications not = Index.notFX("Accion exitosa", "Contacto eliminado correctamente");
                not.showInformation();
                initTabla();
            } else {
                Notifications not = Index.notFX("Accion Denegada", "Debes soleccionar primero a un contacto");
                not.showError();
            }
        }
    }

    /**
     * Metodo initTAbla Actualiza la tabla con la lista de contactos
     */
    private void initTabla() {
        tabla.getItems().clear();
        Label a = new Label("No hay informacion", new FontAwesomeIconView(FontAwesomeIcon.ANGELLIST));
        tabla.getItems().add(a);
        for (Nodo object : Index.DIR.inorden()) {
            Label label = new Label("   " + object.getDatos().getNOMBRE());
            label.setStyle("-fx-font-size: 1.2em ; -fx-font-weight: bold;");
            label.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.USER).setStyleClass("custom-jfx-list-view-icon"));
            tabla.getItems().add(label);
        }
        if (tabla.getItems().size() > 1) {
            tabla.getItems().remove(a);
            txt_buscar.setDisable(false);
        }
    }

    /**
     * Metodo mostrarInformacion Muestra la informacion del contacto
     * seleccionado
     */
    private void showInformation() {
        if (nom != null) {
            Contacto info = Index.DIR.buscar(nom);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacion del contacto: " + nom);
            alert.setHeaderText(nom);
            alert.setContentText("\n\tTelefono: " + info.getTelefono()
                    + "\n\tDireccion: " + info.getDireccion()
                    + "\n\tEmail: " + info.getEmail());

            alert.showAndWait();
        }

    }

    /**
     * Metodo buscar evento KeyTyped, cada vez que el usuario digite busca en la
     * listade contacto por palabra clave
     */
    @FXML
    void buscar(KeyEvent event) {
        tabla.getItems().clear();
        Label a = new Label("No hay informacion", new FontAwesomeIconView(FontAwesomeIcon.ANGELLIST));
        tabla.getItems().add(a);
        for (Nodo object : Index.DIR.inorden()) {
            if ((object.getDatos().getNOMBRE()).toLowerCase().startsWith(txt_buscar.getText().toLowerCase())) {
                Label label = new Label("   " + object.getDatos().getNOMBRE());
                label.setStyle("-fx-font-size: 1.2em ; -fx-font-weight: bold;");
                label.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.USER).setStyleClass("custom-jfx-list-view-icon"));
                tabla.getItems().add(label);
            }
        }
        if (tabla.getItems().size() > 1) {
            tabla.getItems().remove(a);
        }
    }

    /**
     * Pequeña informacion!
     */
    @FXML
    void darInfo(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setHeaderText("Opciones de la tabla");
        alert.setContentText("Para las opciones de 'eliminar' y 'ver informacion'\n"
                + ", debes dar click derecho sobre \nel contacto, y elegir la opcion deseada");

        alert.showAndWait();
    }

}
