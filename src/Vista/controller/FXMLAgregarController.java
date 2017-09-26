/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.controller;

import Vista.Index;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author andresvizcaino
 */
public class FXMLAgregarController implements Initializable {

    @FXML
    private JFXTextField txt_nombre;

    @FXML
    private JFXTextField txt_email;

    @FXML
    private JFXTextField txt_tel;

    @FXML
    private JFXTextArea txt_dir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clearCell();
    }

    @FXML
    void guardar(ActionEvent event) {
        String nombre = txt_nombre.getText();
        String t = txt_tel.getText() == null ? "0" : txt_tel.getText();
        long tel = Long.parseLong(t);
        String dir = txt_dir.getText() == null ? " N/A " :  txt_dir.getText();
        String email = txt_email.getText() == null ? " N/A " :  txt_email.getText();
        if (nombre != null) {
            if (Index.DIR.agregarContacto(nombre, tel, dir, email)) {
                Notifications not = Index.notFX("Accion exitosa", "Contacto guardado correctamente");
                not.showConfirm();
            } else {
                Notifications not = Index.notFX("Accion Denegada", "El contacto ya existe");
                not.showError();
            }
            clearCell();
        } else {
            Notifications not = Index.notFX("Accion Denegada", "Es importante colocar un nombre!");
            not.showError();
        }

    }

    private void clearCell() {
        txt_nombre.setText(null);
        txt_tel.setText(null);
        txt_dir.setText(null);
        txt_email.setText(null);
    }

}
