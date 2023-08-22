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
        for (int i = 0; i < Utilitaria.usuarioSerializable("usuario.ser").size(); i++) {
            String correoArchivo = Utilitaria.usuarioSerializable("usuario.ser").get(i).getCorreoElectronico();
            String contrasenaArchivo = Utilitaria.usuarioSerializable("usuario.ser").get(i).getClave();

            if (correoArchivo.equals(correo) && contrasenaHash.equals(contrasenaArchivo)) {
                validar = true;
            }
        }
        return validar;
    }

    //Retorna True si el correo  está guardado
    public static boolean validarCorreo(Persona usuario) {
        boolean validar = false;
        //Buscando Correo de usuario
        for (int i = 0; i < Utilitaria.usuarioSerializable("usuario.ser").size(); i++) {
            String correoArchivo = Utilitaria.usuarioSerializable("usuario.ser").get(i).getCorreoElectronico();
            if (correoArchivo.equals(usuario.getCorreoElectronico())) {
                validar = true;
            }
        }
        return validar;
    }

    //Guarda Objeto Persona en archivo Serializable
    public static void archivoSerializable(String nombre, ArrayList<Persona> lista) {
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
    public static ArrayList<Persona> usuarioSerializable(String nombre) {
        ArrayList<Persona> objeto = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(nombre);
            ObjectInputStream entrada = new ObjectInputStream(file);
            objeto = (ArrayList<Persona>) entrada.readObject();
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    //Guarda Objeto Persona 
    public static void guardarSerializable(String nombre, Persona objetoAgregar) {

        File archivo = new File(nombre);
        ArrayList<Persona> lista = new ArrayList<>();
        //Verifica si existe el archivo
        if (!archivo.exists()) {
            lista.add(objetoAgregar);
            Utilitaria.archivoSerializable(nombre, lista);
        } else {
            //Guarda el Usuario en un ArrayList
            ArrayList<Persona> objeto = Utilitaria.usuarioSerializable(nombre);

            for (int i = 0; i < objeto.size(); i++) {
                lista.add(objeto.get(i));
            }
            lista.add(objetoAgregar);
            Utilitaria.archivoSerializable(nombre, lista);
        }

    }
    //Retorna True si la placa está guardado
    public static boolean validarPlaca(Vehiculo placa) {
        boolean validar = false;
        //Buscando placa de heviculo
        for (int i = 0; i < Utilitaria.vehiculoSerializable("placa.ser").size(); i++) {
            String placaArchivo = Utilitaria.vehiculoSerializable("placa.ser").get(i).getPlaca();
            if (placaArchivo.equals(placa.getPlaca())) {
                validar = true;
            }
        }
        return validar;
    }

    //Guarda Objeto Vehiculo en archivo Serializable
    public static void archivoVehiculoSerializable(String nombre, ArrayList<Vehiculo> lista) {
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

    //Retorna Objeto Vehiculo
    public static ArrayList<Vehiculo> vehiculoSerializable(String nombre) {
        ArrayList<Vehiculo> objeto = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(nombre);
            ObjectInputStream entrada = new ObjectInputStream(file);
            objeto = (ArrayList<Vehiculo>) entrada.readObject();
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return objeto;
    }

    //Guarda Objeto Vehiculo
    public static void guardarSerializable_Vehiculo(String nombre, Vehiculo objetoAgregar) {

        File archivo = new File(nombre);
        ArrayList<Vehiculo> lista = new ArrayList<>();
        //Verifica si existe el archivo
        if (!archivo.exists()) {
            lista.add(objetoAgregar);
            Utilitaria.archivoVehiculoSerializable(nombre, lista);
        } else {
            //Guarda el Vehiculo en un ArrayList
            ArrayList<Vehiculo> objeto = Utilitaria.vehiculoSerializable(nombre);

            for (int i = 0; i < objeto.size(); i++) {
                lista.add(objeto.get(i));
            }
            lista.add(objetoAgregar);
            Utilitaria.archivoVehiculoSerializable(nombre, lista);
        }

    }
    
    //Filtra Vehiculo
    public static ArrayList<Vehiculo> filtrarVehiculo(String tipo, double recorridoInicial, double recorridoFinal, int anioInicial, int  anioFinal, double precioInicial, double precioFinal, ArrayList<Vehiculo> lista){
        ArrayList<Vehiculo> listaFinal = new ArrayList<>();
        
        ArrayList<Vehiculo> listaTipo = new ArrayList<>();
        ArrayList<Vehiculo> listaRecorrido = new ArrayList<>();
        ArrayList<Vehiculo> listaAnio = new ArrayList<>();
        
        for( int i=0; i< lista.size(); i++){
            if( tipo.equals("camioneta")){
                if( lista.get(i) instanceof Camioneta){
                    listaTipo.add(lista.get(i));
                    
                    for( int j=0; j< listaTipo.size(); j++){
                        if( recorridoInicial <= listaTipo.get(j).getRecorrido()  &&  listaTipo.get(j).getRecorrido()<= recorridoFinal){
                            listaRecorrido.add(listaTipo.get(j));
                            
                            for( int k=0; k< listaRecorrido.size(); k++){
                                if( anioInicial <= listaRecorrido.get(k).getAnio() && listaRecorrido.get(k).getAnio() <= anioFinal ){
                                    listaAnio.add(listaRecorrido.get(k));
                                    
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    }
                                }
                                else{
                                    listaAnio.add(listaRecorrido.get(k));
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    } 
                                }
                            }
                        }
                        else{
                            listaRecorrido.add(listaTipo.get(j));
                            for( int k=0; k< listaRecorrido.size(); k++){
                                if( anioInicial <= listaRecorrido.get(k).getAnio() && listaRecorrido.get(k).getAnio() <= anioFinal ){
                                    listaAnio.add(listaRecorrido.get(k));
                                    
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    }
                                }
                                else{
                                    listaAnio.add(listaRecorrido.get(k));
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    } 
                                }
                            }   
                        }
                    }
                }
            }
            if( tipo.equals("auto")){
                if( lista.get(i) instanceof Auto){
                    listaTipo.add(lista.get(i));
                    for( int j=0; j< listaTipo.size(); j++){
                        if( recorridoInicial <= listaTipo.get(j).getRecorrido()  &&  listaTipo.get(j).getRecorrido()<= recorridoFinal){
                            listaRecorrido.add(listaTipo.get(j));
                            
                            for( int k=0; k< listaRecorrido.size(); k++){
                                if( anioInicial <= listaRecorrido.get(k).getAnio() && listaRecorrido.get(k).getAnio() <= anioFinal ){
                                    listaAnio.add(listaRecorrido.get(k));
                                    
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    }
                                }
                                else{
                                    listaAnio.add(listaRecorrido.get(k));
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    } 
                                }
                            }
                        }
                        else{
                            listaRecorrido.add(listaTipo.get(j));
                            for( int k=0; k< listaRecorrido.size(); k++){
                                if( anioInicial <= listaRecorrido.get(k).getAnio() && listaRecorrido.get(k).getAnio() <= anioFinal ){
                                    listaAnio.add(listaRecorrido.get(k));
                                    
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    }
                                }
                                else{
                                    listaAnio.add(listaRecorrido.get(k));
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    } 
                                }
                            }   
                        }
                    }
                }
            }
            if( tipo.equals("moto")){
                if( lista.get(i) instanceof Vehiculo){
                    listaTipo.add(lista.get(i));
                    for( int j=0; j< listaTipo.size(); j++){
                        if( recorridoInicial <= listaTipo.get(j).getRecorrido()  &&  listaTipo.get(j).getRecorrido()<= recorridoFinal){
                            listaRecorrido.add(listaTipo.get(j));
                            
                            for( int k=0; k< listaRecorrido.size(); k++){
                                if( anioInicial <= listaRecorrido.get(k).getAnio() && listaRecorrido.get(k).getAnio() <= anioFinal ){
                                    listaAnio.add(listaRecorrido.get(k));
                                    
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    }
                                }
                                else{
                                    listaAnio.add(listaRecorrido.get(k));
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    } 
                                }
                            }
                        }
                        else{
                            listaRecorrido.add(listaTipo.get(j));
                            for( int k=0; k< listaRecorrido.size(); k++){
                                if( anioInicial <= listaRecorrido.get(k).getAnio() && listaRecorrido.get(k).getAnio() <= anioFinal ){
                                    listaAnio.add(listaRecorrido.get(k));
                                    
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    }
                                }
                                else{
                                    listaAnio.add(listaRecorrido.get(k));
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    } 
                                }
                            }   
                        }
                    }
                }
            }
            else{
                listaTipo.add(lista.get(i));
                for( int j=0; j< listaTipo.size(); j++){
                        if( recorridoInicial <= listaTipo.get(j).getRecorrido()  &&  listaTipo.get(j).getRecorrido()<= recorridoFinal){
                            listaRecorrido.add(listaTipo.get(j));
                            
                            for( int k=0; k< listaRecorrido.size(); k++){
                                if( anioInicial <= listaRecorrido.get(k).getAnio() && listaRecorrido.get(k).getAnio() <= anioFinal ){
                                    listaAnio.add(listaRecorrido.get(k));
                                    
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    }
                                }
                                else{
                                    listaAnio.add(listaRecorrido.get(k));
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    } 
                                }
                            }
                        }
                        else{
                            listaRecorrido.add(listaTipo.get(j));
                            for( int k=0; k< listaRecorrido.size(); k++){
                                if( anioInicial <= listaRecorrido.get(k).getAnio() && listaRecorrido.get(k).getAnio() <= anioFinal ){
                                    listaAnio.add(listaRecorrido.get(k));
                                    
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    }
                                }
                                else{
                                    listaAnio.add(listaRecorrido.get(k));
                                    for(int m=0 ; m < listaAnio.size() ; m++){
                                        if( precioInicial <= listaAnio.get(m).getAnio() && listaAnio.get(m).getPrecio() <=  precioFinal){
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                        else{
                                            listaFinal.add(listaAnio.get(m));
                                        }
                                    } 
                                }
                            }   
                        }
                    }
            }
        }
        
        return listaFinal;
    }
    

}
