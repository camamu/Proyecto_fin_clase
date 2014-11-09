/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class Xml {
    /**
     * Crea un XML de la tabla clientes
     */
    public void exportarClientes(){
         Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from clientes");
            
            //generamos el reporte
             PrintWriter informe = new PrintWriter("C:/Informes/clientes.xml");
             informe.println("<clientes>\n"); 

       while(rs.next()){
           informe.println("<cliente>");
           informe.println("<nombre>" + rs.getString(1) + "</nombre>");
           informe.println("<apellido1>" + rs.getString(2) + "</apellido1>");
           informe.println("<apellido2>" + rs.getString(3) + "</apellido2>");
           informe.println("<localidad>" + rs.getString(4) + "</localidad>");
           informe.println("<cpostal>" + rs.getInt(5) + "</cpostal>");
           informe.println("<dni>" + rs.getString(6) + "</dni>");
           informe.println("<email>" + rs.getString(7) + "</email>");
           informe.println("<telefono>" + rs.getInt(8) + "</telefono>");
           informe.println("<admitido>" + rs.getString(9) + "</admitido>");
           informe.println("<reserva>" + rs.getString(10) + "</reserva>");
           informe.println("<matricula>" + rs.getString(11) + "</matricula>");
           informe.println("</cliente>");
         }
       informe.println("</clientes>");
             informe.flush();
             informe.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (FileNotFoundException e) {
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
     * Crea un XML de la tabla Usuarios
     */
    public void exportarUsuarios(){
        Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from usuarios");
            
            //generamos el reporte
             PrintWriter informe = new PrintWriter("C:/Informes/usuarios.xml");
             informe.println("<usuarios>\n"); 

       while(rs.next()){
           informe.println("<usuario>");
           informe.println("<nusuario>" + rs.getString(1) + "</nusuario>");
           informe.println("<contraseña>" + rs.getString(2) + "</contraseña>");
           informe.println("<correo>" + rs.getString(3) + "</correo>");
           informe.println("<administrador>" + rs.getString(4) + "</administrador>");
           informe.println("</usuario>");
         }
       informe.println("</usuarios>");
             informe.flush();
             informe.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (FileNotFoundException e) {
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
