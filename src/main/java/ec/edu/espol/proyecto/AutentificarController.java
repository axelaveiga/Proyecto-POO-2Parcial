/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import ec.edu.espol.clases.Utilitaria;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Axel
 */
public class AutentificarController implements Initializable {
    
    @FXML
    private ImageView imageview1;
    @FXML
    private ImageView imageview2;
    @FXML
    private ImageView imageview3;
    @FXML
    private ImageView imageview4;
    @FXML
    private ImageView imageview5;
    
    @FXML
    private PasswordField contrasena;
    @FXML
    private TextField correo;
    @FXML
    private Button btRetroceder;
    @FXML
    private Button btConfirmarUsuario;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarImagen();
        // TODO
    }
    
    public void closeWindows(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/proyecto.fxml"));
            Parent root = loader.load();
          
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            Stage mystage = (Stage) this.btRetroceder.getScene().getWindow();
            mystage.close();
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    @FXML
    private void mostrarImagen(){
         Image image1 = new Image("/imagenes/image4.png");
         imageview1.setImage(image1);
         Image image2 = new Image("/imagenes/image1.png");
         imageview2.setImage(image2);
         Image image3 = new Image("/imagenes/image2.png");
         imageview3.setImage(image3);
         Image image4 = new Image("/imagenes/image3.png");
         imageview4.setImage(image4);
         Image image5 = new Image("/imagenes/flecha.png");
         imageview5.setImage(image5);
         
    }


    @FXML
    private void retroceder(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/proyecto.fxml"));
            Parent root = loader.load();
          
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            Stage mystage = (Stage) this.btRetroceder.getScene().getWindow();
            mystage.close();
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    

    @FXML
    private void confirmarUsuario(ActionEvent event) {
        try {
            boolean validar =Utilitaria.validarUsuario(correo.getText(), contrasena.getText());
            if( validar == true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Autentificación Correcta");
                alert.showAndWait();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/menu_vehiculo.fxml"));
            Parent root = loader.load();
    

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

           
            Stage mystage = (Stage) this.btConfirmarUsuario.getScene().getWindow();
            mystage.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }                
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Contraseña o Usuario Incorrecto");
                alert.showAndWait();
            
        }
            
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
  
}
