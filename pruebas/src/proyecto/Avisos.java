/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos
 * 
 */

public class Avisos {
    private String contenido;
    /**
     * 
     * @param correo correo de destino al que se mandará elaviso
     * @param dni DNI del cliente del que tratará el aviso
     * 
     */
    // este metodo se encarga de mandar un aviso cuando es admitido un nuevo cliente
    public void aAdmision(String correo, String dni){
        Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from clientes where dni = '" + dni + "'");

            //recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                contenido="Pedir a "+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" con DNI: "+rs.getString(6)+" la documentación y la reserva de plaza";
                Correo enviar = new Correo("desarrollador.93.04.17@gmail.com", "nezsesszqpuqxcuk", correo, "Alarma: Admisión", contenido);
                enviar.sendMail();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { // Se cierra la conexión con la base de datos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * 
     * @param correo correo de destino al que se mandará elaviso
     * @param dni DNI del cliente del que tratará el aviso
     * 
     */
     // este metodo se encarga de mandar un aviso cuando reserva un nuevo cliente
    public void aReserva(String correo, String dni){
        Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from clientes where dni = '" + dni + "'");

            //recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                contenido="Pedir a "+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" con DNI: "+rs.getString(6)+" que eche la matricula";
                Correo enviar = new Correo("desarrollador.93.04.17@gmail.com", "nezsesszqpuqxcuk", correo, "Alarma: Reserva plaza", contenido);
                enviar.sendMail();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { // Se cierra la conexión con la base de datos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * 
     * @param correo correo de destino al que se mandará elaviso
     * @param dni DNI del cliente del que tratará el aviso
     * 
     */
     // este metodo se encarga de mandar un aviso cuando se matricula un nuevo cliente
    public void aMatricula(String correo, String dni){
        Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from clientes where dni = '" + dni + "'");

            //recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                contenido="Decir a "+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" con DNI: "+rs.getString(6)+" que está matriculado en el centro";
                Correo enviar = new Correo("desarrollador.93.04.17@gmail.com", "nezsesszqpuqxcuk", correo, "Alarma: Matricula", contenido);
                enviar.sendMail();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally { // Se cierra la conexión con la base de datos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
