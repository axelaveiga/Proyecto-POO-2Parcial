package ec.edu.espol.clases;

import static ec.edu.espol.clases.Hash.getSHA;
import static ec.edu.espol.clases.Hash.toHexString;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Utilitaria {

    // Retorna true si el correo coincide con la contraseña
    public static boolean validarUsuario(String correo, String contrasena) throws NoSuchAlgorithmException {
        
        String contrasenaHash = toHexString(getSHA(contrasena));
        boolean validar = false;
                
        //Buscando usuario por Correo y validando Contraseña
        for(int i= 0; i<Utilitaria.usuarioSerializable("usuario.ser").size(); i++){
            String correoArchivo = Utilitaria.usuarioSerializable("usuario.ser").get(i).getCorreoElectronico();
            String contrasenaArchivo = Utilitaria.usuarioSerializable("usuario.ser").get(i).getClave();
            
            if( correoArchivo.equals(correo) &&  contrasenaHash.equals(contrasenaArchivo)){
                    validar = true;
                }
            } 
        return validar;
        }
        
    
    
    //Retorna True si el correo  está guardado
    public static boolean validarCorreo(Persona usuario){
        boolean validar = false;
        //Buscando Correo de usuario
        for(int i= 0; i<Utilitaria.usuarioSerializable("usuario.ser").size(); i++){
            String correoArchivo = Utilitaria.usuarioSerializable("usuario.ser").get(i).getCorreoElectronico();
            if( correoArchivo.equals(usuario.getCorreoElectronico())){
                validar = true;
            } 
        }
        return validar;
    }

 
    
    //Guarda Objeto Persona en archivo Serializable
    public static void archivoSerializable( String nombre , ArrayList<Persona> lista){
        try {
            FileOutputStream file = new FileOutputStream(nombre);
            ObjectOutputStream salida = new ObjectOutputStream(file);
            salida.writeObject(lista);
            salida.flush();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
    }
    
    //Retorna Objeto Usuario
    
    public static ArrayList<Persona> usuarioSerializable(String nombre){
        ArrayList<Persona> objeto = new ArrayList<>();
        try{
            FileInputStream file = new FileInputStream(nombre);
            ObjectInputStream entrada = new ObjectInputStream( file);
            objeto =(ArrayList<Persona>)entrada.readObject();
            entrada.close();
            }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }
    
    //Guarda Objeto Persona 
    public static void guardarSerializable(String nombre, Persona objetoAgregar){
        
        File archivo = new File(nombre);
        ArrayList<Persona> lista = new ArrayList<>();
        //Verifica si existe el archivo
        if (!archivo.exists()) {
            lista.add(objetoAgregar);
            Utilitaria.archivoSerializable(nombre, lista);
        }
        else{
        //Guarda el Usuario en un ArrayList
        ArrayList<Persona> objeto= Utilitaria.usuarioSerializable(nombre);
        
        for(int i=0; i < objeto.size(); i++){
            lista.add(objeto.get(i));
        }
        lista.add(objetoAgregar);
        Utilitaria.archivoSerializable(nombre, lista);
        }
        
     
    }
    
    
}
