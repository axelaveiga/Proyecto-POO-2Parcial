package ec.edu.espol.proyecto;

import ec.edu.espol.clases.Auto;
import ec.edu.espol.clases.Camioneta;
import ec.edu.espol.clases.Moto;
import ec.edu.espol.clases.Utilitaria;
import ec.edu.espol.clases.Vehiculo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    @Override
    public  void start(Stage stage) throws IOException {
        
        //Prueba de los archivos Serializables
        /*
        Vehiculo v1 = new Moto( "123qwe", "Chevrolet", "Grande", "diesel", 2023, 1000, "rojof", "eco", 1000);
        Vehiculo v2 = new Moto("1234", "NIssa", "Grand3e", "dieself", 1023, 2000, "red", "super", 10000);
         Vehiculo v22 = new Moto("123445", "NIfasdssa", "Grafsdnd3e", "didasfeself", 10223, 20030, "red", "super", 9000);
        Vehiculo v3 = new Auto( "1512", "Hola", "Grande2", "dieselfa", 1023, 2000, "razul", "extra", "si", "si", 20000);
        Vehiculo v4 = new Camioneta( "1512fasd", "Holfdsaa", "Grande1", "diesel1", 1023, 2000, "rojo1", "eco", "si", "si", "si", 20000);
        
        Utilitaria.guardarSerializable_Vehiculo("placa.ser", v22);
        Utilitaria.guardarSerializable_Vehiculo("placa.ser", v1);
        Utilitaria.guardarSerializable_Vehiculo("placa.ser", v3);
        Utilitaria.guardarSerializable_Vehiculo("placa.ser", v4);
        for( int i=0; i< Utilitaria.vehiculoSerializable("placa.ser").size(); i++){
           System.out.println(Utilitaria.vehiculoSerializable("placa.ser").get(i).getPlaca());
        }
       */
        
        ArrayList<Vehiculo> filtro= Utilitaria.filtrarVehiculo("camioneta", 0, 1111110, 0, 11111110, 0, 111110,Utilitaria.vehiculoSerializable("placa.ser") );
        
        for( int i=0; i< filtro.size(); i++){
            System.out.println(filtro.get(i).getPlaca());
            
        }
        
        scene = new Scene(loadFXML("buscar_vehiculo"), 300, 400);
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}