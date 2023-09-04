/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import ec.edu.espol.clases.Persona;
import ec.edu.espol.clases.Utilitaria;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dayan
 */
public class PerfilController implements Initializable {
    
    @FXML
    private ImageView imageview27;
    @FXML
    private ImageView imageview28;
    @FXML
    private ImageView imageview29;
    @FXML
    private Label nombreR;
    @FXML
    private Label apellidoR;
    @FXML
    private Label correoR;
    @FXML
    private Label organizacionR;
    @FXML
    private Label nombreini;
    @FXML
    private Label claveR;
    @FXML
    private Button btRetroceder;
    @FXML
    private Button cla;
    @FXML
    private ImageView imageview40;

    @FXML
    private ImageView imageview41;

    @FXML
    private ImageView imageview42;

    @FXML
    private ImageView imageview43;

    @FXML
    private ImageView imageview44;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cPerfil();
        mostrarImagen();
        // TODO
    } 
    @FXML
    public void cPerfil(){
        String vCorreo = AutentificarController.vCorreo;
        ArrayList<Persona> listaUsuario = Utilitaria.usuarioSerializable("usuario.ser");
        for(Persona p: listaUsuario){
            if(p.getCorreoElectronico().equals(vCorreo)){
                nombreR.setText(p.getNombre());
                apellidoR.setText(p.getApellidos());
                correoR.setText(p.getCorreoElectronico());
                organizacionR.setText(p.getOrganizacion());
            }
        }
    }
        @FXML
    private void mostrarImagen(){

         Image image27 = new Image("/imagenes/flechab.png");
         imageview27.setImage(image27);
         Image image28 = new Image("/imagenes/perfil.png");
         imageview28.setImage(image28);
         Image image29 = new Image("/imagenes/logoblanco.png");
         imageview29.setImage(image29);
         Image image40 = new Image("/imagenes/apellido.png");
         imageview40.setImage(image40);
         Image image41 = new Image("/imagenes/apellido.png");
         imageview41.setImage(image41);
         Image image42 = new Image("/imagenes/correo.png");
         imageview42.setImage(image42);
         Image image43 = new Image("/imagenes/organizacion.png");
         imageview43.setImage(image43);
         Image image44 = new Image("/imagenes/cclave.png");
         imageview44.setImage(image44);

         

    }
        @FXML
    private void retroceder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/comprador_vendedor.fxml"));
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
        private void clave(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/cambio_clave.fxml"));
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



    
}
