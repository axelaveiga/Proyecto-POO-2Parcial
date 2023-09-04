/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import ec.edu.espol.clases.Persona;
import ec.edu.espol.clases.Utilitaria;
import ec.edu.espol.clases.ValidarException;
import java.io.IOException;
import java.net.URL;
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
public class RegistrarController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField correo;
    @FXML
    private TextField organizacion;
    @FXML
    private PasswordField clave;
    @FXML
    private Button btRetroceder;
    @FXML
    private Button btConfirmarRegistro;
    @FXML
    private ImageView imageview6;
    @FXML
    private ImageView imageview7;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        visualimagen();
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
    private void confirmarRegistro(ActionEvent event) {
        
        
        Persona usuario = new Persona( nombre.getText(), apellido.getText(),  organizacion.getText(),correo.getText(), clave.getText());
        
        if( nombre.getText().equals("") || apellido.getText().equals("") ||  organizacion.getText().equals("") ||correo.getText().equals("") ||clave.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Llenar Todos los campos");
            alert.showAndWait();
        }
        
        else{
        boolean validar = Utilitaria.validarCorreo(usuario);
        if( validar == false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Usuario Registrado");
            alert.showAndWait();
            Utilitaria.guardarSerializable("usuario.ser", usuario);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Usuario No Disponible");
            alert.showAndWait();

        }
        }
    }
    
     @FXML
    private void visualimagen(){
         Image image6 = new Image("/imagenes/flecha.png");
         imageview6.setImage(image6);
         Image image7 = new Image("/imagenes/rosalogo.png");
         imageview7.setImage(image7);

    }

  
}
