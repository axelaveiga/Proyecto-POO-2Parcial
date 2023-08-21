/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dayan
 */
public class Registrar_vehiculoController implements Initializable {

    @FXML
    private Button btRetroceder;
    @FXML
    private ImageView imageview12;
    @FXML
    private ImageView imageview13;
    @FXML
    private ImageView imageview14;
    @FXML
    private RadioButton carro;
    @FXML
    private RadioButton camioneta;
    @FXML
    private RadioButton moto;
    @FXML
    private TextField traccion;
    @FXML
    private TextField transmision;
    @FXML
    private TextField vidrios;
    @FXML
    private Label textC;
    @FXML
    private Label textCa;
    @FXML
    private Label textM;
    @FXML
    private Label textt;
    @FXML
    private Label imagen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        visualimagen();
        // TODO
    }

    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ec/edu/espol/proyecto/proyecto.fxml"));
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
    private void seleccion() {
        ToggleGroup botones = new ToggleGroup();
        carro.setToggleGroup(botones);
        camioneta.setToggleGroup(botones);

        moto.setToggleGroup(botones);
        if (botones.getSelectedToggle().equals(camioneta)) {
            textC.setVisible(false);
            textCa.setVisible(true);
            textM.setVisible(false);
            textt.setVisible(false);
            traccion.setVisible(true);
            vidrios.setVisible(true);
            transmision.setVisible(true);
        }
        if (botones.getSelectedToggle().equals(carro)) {
            textC.setVisible(true);
            textCa.setVisible(false);
            textM.setVisible(false);
            textt.setVisible(false);
            traccion.setVisible(false);
            vidrios.setVisible(true);
            transmision.setVisible(true);
        }
        if (botones.getSelectedToggle().equals(moto)) {
            textC.setVisible(false);
            textCa.setVisible(false);
            textM.setVisible(true);
            textt.setVisible(false);
            traccion.setVisible(false);
            vidrios.setVisible(false);
            transmision.setVisible(false);
        }
    }

    @FXML
    public void subirArchivo(ActionEvent event) {
        FileChooser subir = new FileChooser();
        File selectedFile = subir.showOpenDialog(null);
        String filePath = "file:" + selectedFile.getAbsolutePath();
        String separator = "\\";
        String[] arreglo = filePath.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
        filePath = arreglo[arreglo.length - 1];
        System.out.println(filePath);
        imagen.setText(filePath);

    }

    @FXML
    private void visualimagen() {
        Image image12 = new Image("/imagenes/flecha.png");
        imageview12.setImage(image12);
        Image image13 = new Image("/imagenes/rosalogo.png");
        imageview13.setImage(image13);
        Image image14 = new Image("/imagenes/Subir.png");
        imageview14.setImage(image14);
        textt.setVisible(true);
        textC.setVisible(false);
        textCa.setVisible(false);
        textM.setVisible(false);

    }
}
