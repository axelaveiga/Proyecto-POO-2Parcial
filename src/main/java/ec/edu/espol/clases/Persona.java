/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.clases;

import static ec.edu.espol.clases.Hash.getSHA;
import static ec.edu.espol.clases.Hash.toHexString;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Axel
 */
public class Persona implements Serializable{
    private String nombres;
    private String apellidos;
    private String organizacion;
    private String correoElectronico;
    private String clave;
    private ArrayList<Vehiculo> vehiculos;
    public static final long serialVersionUID = 1245678L;

    public Persona(String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        this.nombres = nombre;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        try {
            this.clave = toHexString(getSHA(clave));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    
    public static void aceptarOferta(Oferta ofer) throws FileNotFoundException, IOException {

        enviarConGMail(ofer.getPersona().getCorreoElectronico(), "Notificación", "Se aceptado la oferta");

        
        String lineToRemove = null;
        ArrayList<Vehiculo> veh= new ArrayList<>();
        try (ObjectInputStream sc = new ObjectInputStream(new FileInputStream("placa.ser"))) {
                 veh = (ArrayList<Vehiculo>) sc.readObject();
                for(Vehiculo v: veh){
                    if(ofer.getVehiculo().getPlaca().equals(v.getPlaca())){
                        veh.remove(v);
                    }
                        
                }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        File inputFile = new File("vehiculos.txt");
        File tempFile = new File("myTempFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);

    }

    
    
    
    private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        String usuario= "";
        String clave="";
        try (InputStream inputStream = new FileInputStream("cuentaenvio.properties")) {
                Properties prop = new Properties();
                prop.load(inputStream);
                
                usuario = prop.getProperty("prop.usuario");
                clave = prop.getProperty("prop.clave");
            } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            } catch (IOException ex) {
            ex.printStackTrace();
        }
        //La dirección de correo de envío
        String remitente = usuario;
        //La clave de aplicación obtenida según se explica en este artículo:
        String claveemail = clave;

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

       /* Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveemail);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
*/
    }
}
