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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dayan
 */
public class Buscar_vehiculoController implements Initializable {

    @FXML
    private Button btRetroceder;
    Integer index;

    @FXML
    private Button btBuscar;

    @FXML
    private ImageView imageview15;

    @FXML
    private ImageView imageview16;

    @FXML
    private TableView tabla;

    @FXML
    private TextField anioFinal;

    @FXML
    private TextField anioInicio;

    @FXML
    private TextField precioFinal;

    @FXML
    private TextField precioInicio;

    @FXML
    private TextField recorridoFinal;

    @FXML
    private TextField recorridoInicio;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> placaColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> marcaColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> modeloColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> motorColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> anioColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> recorridoColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> colorColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> combustibleColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> precioColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> transmisionColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> vidriosColumna;

    @FXML
    private TableColumn<Vehiculo, SimpleStringProperty> traccionColumna;
    @FXML
    private ObservableList<Vehiculo> vehiculos;
    @FXML
    private ObservableList<Vehiculo> filtrovehiculos;
    @FXML
    private ComboBox<String> tipo;

    public static Vehiculo vehiculo;

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipo.setItems(FXCollections.observableArrayList("moto", "auto", "camioneta"));
        //vehiculos=FXCollections.observableArrayList();
        //filtrovehiculos=FXCollections.observableArrayList();
        //this.tabla.setItems(vehiculos);
        visualimagen();
        cargarTabla();
        //placaColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("placa"));
        //marcaColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("marca"));
        // modeloColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("modelo"));
        // motorColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("tipoMotor"));
        // anioColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("anio"));
        // recorridoColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("recorrido"));
        //colorColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("color"));
        // combustibleColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("combustible"));
        //  precioColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("precio"));
        // transmisionColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("transmicion"));
        // vidriosColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("vidrios"));
        // traccionColumna.setCellValueFactory(new PropertyValueFactory<Vehiculo, SimpleStringProperty>("traccion"));

        //tabla.setItems( getVehiculo());
    }

    @FXML
    private void retroceder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/menu_comprador.fxml"));
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
    private void visualimagen() {
        Image image15 = new Image("/imagenes/flecha.png");
        imageview15.setImage(image15);
        Image image16 = new Image("/imagenes/rosalogo.png");
        imageview16.setImage(image16);
    }

    public ObservableList<Vehiculo> getVehiculo() {
        ObservableList<Vehiculo> vehiculo = FXCollections.observableArrayList();
        ArrayList<Vehiculo> lista = Utilitaria.vehiculoSerializable("placa.ser");
        vehiculo.add(new Vehiculo("f", "afsd", "fd", "ffadsf", 1, 1, "fasdf", "dAD", 1));
        //for( int i=0 ; i< lista.size(); i++){
        // vehiculo.add(lista.get(i));
        //}
        return vehiculo;

    }

    @FXML
    private void buscar_vehiculo(ActionEvent event) throws LlenarException {

        ArrayList<Vehiculo> listaVehiculo = Utilitaria.vehiculoSerializable("placa.ser");

        try {
            if (tipo.getValue().equals("") || recorridoInicio.getText().equals("") || recorridoFinal.getText().equals("") || anioInicio.getText().equals("") || anioFinal.getText().equals("") || precioInicio.getText().equals("") || precioFinal.getText().equals("")) {
                throw new LlenarException("Llenar campos");
            }

            ArrayList<Vehiculo> listaVehiculoFiltrada = Utilitaria.filtrarVehiculo(tipo.getValue(), Double.parseDouble(recorridoInicio.getText()), Double.parseDouble(recorridoFinal.getText()), Integer.parseInt(anioInicio.getText()), Integer.parseInt(anioFinal.getText()), Double.parseDouble(precioInicio.getText()), Double.parseDouble(precioFinal.getText()), listaVehiculo);
            Utilitaria.archivoListaSerializable("listaFiltrada.ser", listaVehiculoFiltrada);
            tabla.getItems().clear();
            for (Vehiculo p : listaVehiculoFiltrada) {
                tabla.getItems().add(p);
            }
            vehiculo = (Vehiculo) tabla.getSelectionModel().getSelectedItem();
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ingresar solo números en Año, Recorrido, Precio");
            alert.showAndWait();
        } catch (LlenarException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Llenar todos los campos");
            alert.showAndWait();
        }

    }

    public void cargarTabla() {

        ArrayList<Vehiculo> vehiculoSerializable = Utilitaria.vehiculoSerializable("placa.ser");

        placaColumna.setCellValueFactory(
                new PropertyValueFactory<>("placa"));

        marcaColumna.setCellValueFactory(
                new PropertyValueFactory<>("marca"));

        modeloColumna.setCellValueFactory(
                new PropertyValueFactory<>("modelo"));

        motorColumna.setCellValueFactory(
                new PropertyValueFactory<>("tipoMotor"));

        anioColumna.setCellValueFactory(
                new PropertyValueFactory<>("anio"));

        recorridoColumna.setCellValueFactory(
                new PropertyValueFactory<>("recorrido"));

        colorColumna.setCellValueFactory(
                new PropertyValueFactory<>("color"));

        combustibleColumna.setCellValueFactory(
                new PropertyValueFactory<>("combustible"));

        precioColumna.setCellValueFactory(
                new PropertyValueFactory<>("precio"));

        transmisionColumna.setCellValueFactory(
                new PropertyValueFactory<>("transmicion"));

        vidriosColumna.setCellValueFactory(
                new PropertyValueFactory<>("vidrios"));

        traccionColumna.setCellValueFactory(
                new PropertyValueFactory<>("traccion"));

        tabla.getColumns().addAll(placaColumna, marcaColumna, modeloColumna, motorColumna, anioColumna, recorridoColumna, colorColumna, combustibleColumna, precioColumna, transmisionColumna, vidriosColumna, traccionColumna);

        for (Vehiculo p : vehiculoSerializable) {
            System.out.println(p);
            tabla.getItems().add(p);

        }

    }

    public void filtrarTabla() {
        ArrayList<Vehiculo> listaFiltrada = Utilitaria.vehiculoSerializable("listaFiltrada.ser");
        for (Vehiculo p : listaFiltrada) {
            System.out.println(p);
        }

        tabla.getItems().clear();
        for (Vehiculo p : listaFiltrada) {

            tabla.getItems().add(p);
        }

    }

    @FXML
    void getItem(MouseEvent event) {
        index = tabla.getSelectionModel().getSelectedIndex();

        if (index <= -1) {
            return;
        }

        ArrayList<Vehiculo> listaVehiculo = Utilitaria.vehiculoSerializable("placa.ser");

        for (Vehiculo v : listaVehiculo) {
            if (v.getPlaca().equals(placaColumna.getCellData(index))) {
                vehiculo = v;
            }
        }

    }

}
