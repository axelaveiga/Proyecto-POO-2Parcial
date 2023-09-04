/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import ec.edu.espol.clases.Utilitaria;
import ec.edu.espol.clases.Vehiculo;
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
import javafx.scene.control.ChoiceBox;
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
    private ChoiceBox<String> btTipo;
    
    @FXML
    private Label myLabel;
    
    @FXML
    private String[] opciones = {"auto", "moto", "camioneta"}; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btTipo.getItems().addAll(opciones);
       // btTipo.setOnAction(this::buscar);
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
    private void buscar_vehiculo(ActionEvent event) {
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
           // ArrayList<Vehiculo> listaVehiculoFiltrada = Utilitaria.filtrarVehiculo("camioneta", Double.parseDouble(recorridoInicio.getText()), Double.parseDouble(recorridoFinal.getText() ), Integer.parseInt(anioInicio.getText()), Integer.parseInt(anioFinal.getText()), Double.parseDouble(precioInicio.getText()), Double.parseDouble(precioFinal.getText()), listaVehiculo);
           // Utilitaria.archivoVehiculoSerializable("listaFiltrada.ser", listaVehiculoFiltrada);
            
            
            System.out.println(listaVehiculo.get(0).toString());

            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        

    }
    
    @FXML
    public void getTipo(ActionEvent event){
        String myOpcion = btTipo.getValue();
        myLabel.setText(myOpcion);
    }
    
    
    
    
    
}
