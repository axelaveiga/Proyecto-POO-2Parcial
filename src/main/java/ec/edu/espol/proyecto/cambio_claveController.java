/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto;

import static ec.edu.espol.clases.Hash.getSHA;
import static ec.edu.espol.clases.Hash.toHexString;
import ec.edu.espol.clases.Persona;
import ec.edu.espol.clases.Utilitaria;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author dayan
 */
public class cambio_claveController implements Initializable {

    @FXML
    private Button aceptar;
    @FXML
    private ImageView imageview30;

    @FXML
    private PasswordField anterior;

    @FXML
    private Button cancelar;

    @FXML
    private PasswordField nueva;

    @FXML
    private Button btRetroceder;

    @FXML
    private ImageView imageview31;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarImagen();

    }

    public void cambioClave() {
        String claveActual = nueva.getText();
        String claveAnterior = anterior.getText();
        String clave_nueva = null;
        String contrasenaHash = null;
        if (nueva.getText().isBlank() || anterior.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debe llenar la información solicitada.");
            alert.showAndWait();
        }
        else{
            
        try {
            contrasenaHash = toHexString(getSHA(claveAnterior));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        String vCorreo = AutentificarController.vCorreo;
        ArrayList<Persona> listaUsuario = Utilitaria.usuarioSerializable("usuario.ser");
        for (Persona p : listaUsuario) {
            if (p.getCorreoElectronico().equals(vCorreo)) {
                if (p.getClave().equals(contrasenaHash)) {
                    try {
                        clave_nueva = toHexString(getSHA(claveActual));
                    } catch (NoSuchAlgorithmException ex) {
                        ex.printStackTrace();
                    }

                    p.setClave(clave_nueva);
                    System.out.println(p.getClave());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("Cambio de clave exitoso.");
                    alert.showAndWait();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("Ingresar clave anterior correcta.");
                    alert.showAndWait();
                }
            }
        }
        Utilitaria.archivoSerializable("usuario.ser", listaUsuario);
    }
    }

    @FXML
    private void retroceder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/perfil.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage mystage = (Stage) this.btRetroceder.getScene().getWindow();
            mystage.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void mostrarImagen() {

        Image image30 = new Image("/imagenes/rosalogo.png");
        imageview30.setImage(image30);
        Image image31 = new Image("/imagenes/flecha.png");
        imageview31.setImage(image31);
    }

}
