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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                    Alert a = new Alert(Alert.AlertType.ERROR, "Usted ha ofertado por el vehiculo");
                    a.show();
                }
            }
            
            
            
            
        }
    }
    
}
