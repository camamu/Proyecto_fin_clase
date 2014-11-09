/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author Carlos
 */
public class GenInforme {
    /**
     * 
     * @throws FileNotFoundException excepcion por si no encuentra el archivo
     * Genera un html con una tabla donde se pueden ver los clientes admitidos
     */
    public void admitido() throws FileNotFoundException{
        Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from clientes WHERE admitido = 'si'");
            
            //generamos el reporte
             PrintWriter informe = new PrintWriter("C:/Informes/admitido.html");
             informe.println("<!DOCTYPE html SYSTEM \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <title>Informe de Admitidos</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1 align=\"center\">Informe de Admitidos</h1>\n" +
"        <hr/>\n" +
"        <table align=\"center\" border=\"2\">\n" +
"            <tr>\n" +
"                <th>Nombre</th>\n" +
"                <th>Apellido1</th>\n" +
"                <th>Apellido2</th>\n" +
"                <th>Localidad</th>\n" +
"                <th>C&oacute;digo postal</th>\n" +
"                <th>DNI</th>\n" +
"                <th>E-mail</th>\n" +
"                <th>Tel&eacute;fono</th>\n" +
"            </tr>\n");
       while(rs.next()){
           informe.println("<tr>");
           informe.println("<td>" + rs.getString(1) + "</td>");
           informe.println("<td>" + rs.getString(2) + "</td>");
           informe.println("<td>" + rs.getString(3) + "</td>");
           informe.println("<td>" + rs.getString(4) + "</td>");
           informe.println("<td>" + rs.getInt(5) + "</td>");
           informe.println("<td>" + rs.getString(6) + "</td>");
           informe.println("<td>" + rs.getString(7) + "</td>");
           informe.println("<td>" + rs.getInt(8) + "</td>");
           informe.println("</tr>");
         }
       informe.println(
"       </table>\n" +
"    </body>\n" +
"</html>"
       );
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
     * Genera un html con una tabla donde se pueden ver los clientes que tienen reserva de plaza 
     */
    public void reservado(){
        Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from clientes WHERE reserva = 'si'");
            
            //generamos el reporte
             PrintWriter informe = new PrintWriter("C:/Informes/reservado.html");
             informe.println("<!DOCTYPE html SYSTEM \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <title>Informe de reservados</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1 align=\"center\">Informe de reservados</h1>\n" +
"        <hr/>\n" +
"        <table align=\"center\" border=\"2\">\n" +
"            <tr>\n" +
"                <th>Nombre</th>\n" +
"                <th>Apellido1</th>\n" +
"                <th>Apellido2</th>\n" +
"                <th>Localidad</th>\n" +
"                <th>C&oacute;digo postal</th>\n" +
"                <th>DNI</th>\n" +
"                <th>E-mail</th>\n" +
"                <th>Tel&eacute;fono</th>\n" +
"            </tr>\n");
       while(rs.next()){
           informe.println("<tr>");
           informe.println("<td>" + rs.getString(1) + "</td>");
           informe.println("<td>" + rs.getString(2) + "</td>");
           informe.println("<td>" + rs.getString(3) + "</td>");
           informe.println("<td>" + rs.getString(4) + "</td>");
           informe.println("<td>" + rs.getInt(5) + "</td>");
           informe.println("<td>" + rs.getString(6) + "</td>");
           informe.println("<td>" + rs.getString(7) + "</td>");
           informe.println("<td>" + rs.getInt(8) + "</td>");
           informe.println("</tr>");
         }
       informe.println(
"       </table>\n" +
"    </body>\n" +
"</html>"
       );
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
     * Genera un html con una tabla donde se pueden ver los clientes matriculados
     */
    public void matriculado(){
        Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from clientes WHERE matricula = 'si'");
            
            //generamos el reporte
             PrintWriter informe = new PrintWriter("C:/Informes/matriculado.html");
             informe.println("<!DOCTYPE html SYSTEM \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"    <head>\n" +
"        <title>Informe de Matriculados</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1 align=\"center\">Informe de Matriculados</h1>\n" +
"        <hr/>\n" +
"        <table align=\"center\" border=\"2\">\n" +
"            <tr>\n" +
"                <th>Nombre</th>\n" +
"                <th>Apellido1</th>\n" +
"                <th>Apellido2</th>\n" +
"                <th>Localidad</th>\n" +
"                <th>C&oacute;digo postal</th>\n" +
"                <th>DNI</th>\n" +
"                <th>E-mail</th>\n" +
"                <th>Tel&eacute;fono</th>\n" +
"            </tr>\n");
       while(rs.next()){
           informe.println("<tr>");
           informe.println("<td>" + rs.getString(1) + "</td>");
           informe.println("<td>" + rs.getString(2) + "</td>");
           informe.println("<td>" + rs.getString(3) + "</td>");
           informe.println("<td>" + rs.getString(4) + "</td>");
           informe.println("<td>" + rs.getInt(5) + "</td>");
           informe.println("<td>" + rs.getString(6) + "</td>");
           informe.println("<td>" + rs.getString(7) + "</td>");
           informe.println("<td>" + rs.getInt(8) + "</td>");
           informe.println("</tr>");
         }
       informe.println(
"       </table>\n" +
"    </body>\n" +
"</html>"
       );
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
