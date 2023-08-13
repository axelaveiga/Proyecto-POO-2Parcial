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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Axel
 */
public class ProyectoController implements Initializable {

    @FXML
    private Button btAuntentificar;
    @FXML
    private ImageView imageview;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void autentificar(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/autentificar.fxml"));
            Parent root = loader.load();
            AutentificarController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage mystage = (Stage) this.btAuntentificar.getScene().getWindow();
            mystage.close();
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void registrar(MouseEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/registrar.fxml"));
            Parent root = loader.load();
            RegistrarController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage mystage = (Stage) this.btAuntentificar.getScene().getWindow();
            mystage.close();
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
}
