/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dayan
 */
public class Comprador_vendedorController implements Initializable {

    @FXML
    private ImageView imageview23;
    @FXML
    private ImageView imageview22;
    @FXML
    private ImageView imageview24;
    @FXML
    private Button bvender;
    @FXML
    private Button bperfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarImagen();
        // TODO
    }
    
    @FXML
    private void ir_vendedor(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/menu_vehiculo.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage mystage = (Stage) this.bvender.getScene().getWindow();
            mystage.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
   

    }
        @FXML
    private void mostrarImagen(){

         Image image22 = new Image("/imagenes/Compra_1.png");
         imageview22.setImage(image22);
         Image image23 = new Image("/imagenes/perfil.png");
         imageview23.setImage(image23);
         Image image24 = new Image("/imagenes/vender_1.png");
         imageview24.setImage(image24);
         
    }

        @FXML
    private void ir_perfil(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/perfil.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage mystage = (Stage) this.bperfil.getScene().getWindow();
            mystage.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    

}
