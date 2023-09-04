/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import ec.edu.espol.clases.LlenarException;
import ec.edu.espol.clases.Utilitaria;
import ec.edu.espol.clases.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Axel
 */
public class FiltrarController implements Initializable {
    @FXML
    private Button btRetroceder;
    
    @FXML
    private TextField precioFinal;

    @FXML
    private TextField precioInicio;

    @FXML
    private TextField recorridoFinal;

    @FXML
    private TextField recorridoInicio;
    
    @FXML
    private TextField anioFinal;

    @FXML
    private TextField anioInicio;

    @FXML
    private Button btBuscar;
    
    @FXML
    private ComboBox<String> btTipo;
    
    private Label myLabel;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btTipo.setItems(FXCollections.observableArrayList("moto", "auto", "camioneta"));
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
    private void buscar_vehiculo(ActionEvent event) throws LlenarException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/buscar_vehiculo.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage mystage = (Stage) this.btBuscar.getScene().getWindow();
            mystage.close();
            
            
            ArrayList<Vehiculo> listaVehiculo = Utilitaria.vehiculoSerializable("placa.ser");
            
            try{
                if(  btTipo.getValue().equals("")|| recorridoInicio.getText().equals("") ||recorridoFinal.getText().equals("") || anioInicio.getText().equals("") || anioFinal.getText().equals("") || precioInicio.getText().equals("") || precioFinal.getText().equals("") ){
                    throw new LlenarException("Llenar campos");
                }
            
                ArrayList<Vehiculo> listaVehiculoFiltrada = Utilitaria.filtrarVehiculo(btTipo.getValue(), Double.parseDouble(recorridoInicio.getText()), Double.parseDouble(recorridoFinal.getText() ), Integer.parseInt(anioInicio.getText()), Integer.parseInt(anioFinal.getText()), Double.parseDouble(precioInicio.getText()), Double.parseDouble(precioFinal.getText()), listaVehiculo);
                Utilitaria.archivoListaSerializable("listaFiltrada.ser", listaVehiculoFiltrada);
          
            }
            catch(NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ingresar solo números en Año, Recorrido, Precio");
            alert.showAndWait();
            }
            catch( LlenarException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Llenar todos los campos");
            alert.showAndWait(); 
        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        

    }
    
    @FXML
    public void getTipo(ActionEvent event){
        
    }
    
    
    
    
    
}
