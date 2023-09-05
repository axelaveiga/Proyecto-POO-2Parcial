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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller class
 *
 * @author Morales
 */
public class OfertasController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private VBox datos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try (ObjectInputStream ofertas = new ObjectInputStream(new FileInputStream("ofertas.ser"))) {
            ArrayList<Oferta> ofertasT = (ArrayList<Oferta>) ofertas.readObject();
            Oferta.ordernarOfertas(ofertasT);
            for (Oferta of : ofertasT) {
                if (of.getVehiculo().getPersona().getCorreoElectronico().equals(vCorreo)) {
                    Text t1 = new Text(of.getPersona().getCorreoElectronico());
                    Text t2 = new Text(of.getVehiculo().getPlaca());
                    Text t3 = new Text(String.valueOf(of.getPrecio()));
                    t1.setWrappingWidth(270);
                    t2.setWrappingWidth(270);
                    t3.setWrappingWidth(270);
                    t1.setTextAlignment(TextAlignment.JUSTIFY);
                    t2.setTextAlignment(TextAlignment.JUSTIFY);
                    t3.setTextAlignment(TextAlignment.JUSTIFY);
                    vbox.getChildren().add(t1);
                    vbox.getChildren().add(t2);
                    vbox.getChildren().add(t3);
                    vbox.setSpacing(10);
                }

            }
            if (vbox.getChildren().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.ERROR, "No hay ofertas");
                        a.show();
                    } else {
                        vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event t) -> {
                            Text correo = (Text) vbox.getChildren().get(0);
                            Text precio = (Text) vbox.getChildren().get(2);
                            correo.setWrappingWidth(300);
                            precio.setWrappingWidth(300);
                            correo.setTextAlignment(TextAlignment.CENTER);
                            precio.setTextAlignment(TextAlignment.CENTER);
                            datos.getChildren().addAll(correo, precio);
                        });
                    }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    @FXML
    private void AceptarOferta(MouseEvent event) {
        if(datos.getChildren().isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR, "Seleccione alguna oferta disponible");
            a.show();
        }else{  
            try (ObjectInputStream ofertas = new ObjectInputStream(new FileInputStream("ofertas.ser"))) {
            
            ArrayList<Oferta> ofertasT = (ArrayList<Oferta>) ofertas.readObject();
            Oferta.ordernarOfertas(ofertasT);
            
            for(Oferta ofT: ofertasT){
                if(ofT.getPersona().getCorreoElectronico().equals(String.valueOf(datos.getChildren().get(0))))
                    Persona.aceptarOferta(ofT);
            }
            
            
        }   catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }catch (IOException ex) {
            } 

    }
}
}
