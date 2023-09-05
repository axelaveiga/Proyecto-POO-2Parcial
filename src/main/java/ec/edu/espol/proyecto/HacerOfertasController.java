/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import ec.edu.espol.clases.Oferta;
import ec.edu.espol.clases.Persona;
import ec.edu.espol.clases.Utilitaria;
import ec.edu.espol.clases.Vehiculo;
import static ec.edu.espol.proyecto.AutentificarController.vCorreo;
import static ec.edu.espol.proyecto.Buscar_vehiculoController.vehiculo;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Morales
 */
public class HacerOfertasController implements Initializable {

    @FXML
    private TextField precioOferta;
    @FXML
    private Label textoVehiculo;
    @FXML
    private Button btRetroceder;

    @FXML
    private ImageView imageview15;

    @FXML
    private ImageView imageview16;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarImagen();
        textoVehiculo.setText(vehiculo.getModelo() + "-" + vehiculo.getPlaca());
        
    }    

    @FXML
    private void COferta(ActionEvent event) {
        if(precioOferta.getText().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR, "Debe ingresar su oferta");
            a.show();
        }else{
            ArrayList<Oferta> ofertas = new ArrayList<>();
            ArrayList<Persona> personas = Utilitaria.usuarioSerializable("usuario.ser");
            for(Persona p: personas){
                if(vCorreo.equals(p.getCorreoElectronico())){
                    Oferta ofertita = new Oferta(p, vehiculo, Double.parseDouble(precioOferta.getText()));
                    ofertas.add(ofertita);
                    Utilitaria.archivoOfertasSerializable("ofertas.ser", ofertas);
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Usted ha ofertado por el vehiculo");
                    a.show();
                }
            }
            
            
            
            
        }
    }
   @FXML
    private void retroceder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/menu_vehiculo.fxml"));
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
        Image image15 = new Image("/imagenes/flecha.png");
        imageview15.setImage(image15);
        Image image16 = new Image("/imagenes/rosalogo.png");
        imageview16.setImage(image16);


    }
    
}
