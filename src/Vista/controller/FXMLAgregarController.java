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
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.Notifications;

/**
 * FXML AgregarController class
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
        
        txt_tel.lengthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (newValue.intValue() > oldValue.intValue()) {
                char ch = txt_tel.getText().charAt(oldValue.intValue());
                if (!(ch >= '0' && ch <= '9')) {
                    txt_tel.setText(txt_tel.getText().substring(0, txt_tel.getText().length() - 1));
                }
            }
        });
    }

    /**
     * Metodo guardar Guarda cada atributo del formulario de registro y llama a
     * la funcion manipulaDirectorio 'agregarContacto'
     */
    @FXML
    void guardar(ActionEvent event) {
        String nombre = txt_nombre.getText();
        String t = txt_tel.getText() == null ? "0" : txt_tel.getText();
        long tel = Long.parseLong(t);
        String dir = txt_dir.getText() == null ? " N/A " : txt_dir.getText();
        String email = txt_email.getText() == null ? " N/A " : txt_email.getText();
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

    /**
     * Metodo clear Limpia las celdas del formulario
     */
    private void clearCell() {
        txt_nombre.setText(null);
        txt_tel.setText(null);
        txt_dir.setText(null);
        txt_email.setText(null);
    }

}
