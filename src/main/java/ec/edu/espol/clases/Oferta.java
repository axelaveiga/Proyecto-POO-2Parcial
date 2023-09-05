/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.clases;

import java.util.ArrayList;

/**
 *
 * @author Axel
 */
public class Oferta {
    private Persona persona;
    private Vehiculo vehiculo;
    private double precio;

    public Oferta(Persona persona, Vehiculo vehiculo, double precio) {
        this.persona = persona;
        this.vehiculo = vehiculo;
        this.precio = precio;
    }

    public Persona getPersona() {
        return persona;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public static ArrayList<Oferta> ordernarOfertas (ArrayList<Oferta> ofertas) throws NullPointerException{
        
        for(int i=0; i < ofertas.size();i++){
            for(int j=0; j<ofertas.size();j++){
                if(ofertas.get(j).getPrecio()< ofertas.get(i).getPrecio()){
                    Oferta anterior = ofertas.get(i);
                    Oferta nuevoMayor = ofertas.get(j);
                    ofertas.set(i,nuevoMayor );
                    ofertas.set(j, anterior);
                }
            }
    }
        return ofertas;
    }
}

