/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyecto;

import ec.edu.espol.clases.Persona;
import ec.edu.espol.clases.Utilitaria;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author dayan
 */
public class PerfilController implements Initializable {

    @FXML
    private Label nombreR;
    @FXML
    private Label apellidoR;
    @FXML
    private Label correoR;
    @FXML
    private Label organizacionR;
    @FXML
    private Label claveR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cPerfil();
        // TODO
    } 
    public void cPerfil(){
        String vCorreo = AutentificarController.vCorreo;
        ArrayList<Persona> listaUsuario = Utilitaria.usuarioSerializable("usuario.ser");
        for(Persona p: listaUsuario){
            if(p.getCorreoElectronico().equals(vCorreo)){
                nombreR.setText(p.getNombre());
                apellidoR.setText(p.getApellidos());
                correoR.setText(p.getCorreoElectronico());
                organizacionR.setText(p.getClave());
            }
        }
    }
    
}
