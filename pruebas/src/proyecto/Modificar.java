package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Carlos
 */
public class Modificar {
    //atributos clientes
    private String nombre;
    private String apellidos;
    private String localidad;
    private int cp;
    private String dni;
    private String email;
    private int telefono;
    private String admitido;
    private String reserva;
    private String matricula;
    //atributos usuarios
    private String usuario;
    private String contraseña;
    private String correo;
    
    
    public Modificar() {
    }
/**
 * 
 * @param nAdmitido aqui estara el nuevo valor del campo admitido
 * @param dni aqui estará el DNI del usuario a modificar
 * Este método sirver para modificar el campo admitido de la tabla clientes
 */
    public void setAdmitido(String nAdmitido, String dni){
        Connection conexion = null;
        String dnii;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            // Queremos obtener el id del primer contacto con nombre Juan
            ResultSet rs = s.executeQuery("SELECT dni FROM clientes WHERE dni='" + dni + "'");
           
            
            if(rs.next()){   //Si rs.next() devuelve true significa que al menos hay un registro
               dnii = rs.getString("dni");  //se obtienen su dni
               //se actualiza el registro
               s.executeUpdate("UPDATE clientes SET admitido='" + nAdmitido + "' WHERE dni='" + dni + "'");
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
     * @param nMatricula aqui estara el nuevo valor del campo matricula
     * @param dni aqui estará el DNI del usuario a modificar
     * Este método sirver para modificar el campo matricula de la tabla clientes
     */
    public void setMatricula(String nMatricula, String dni){
        Connection conexion = null;
        String dnii;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            // Queremos obtener el id del primer contacto con nombre Juan
            ResultSet rs = s.executeQuery("SELECT dni FROM clientes WHERE dni='" + dni + "'");
           
            
            if(rs.next()){   //Si rs.next() devuelve true significa que al menos hay un registro
               dnii = rs.getString("dni");  //se obtienen su dni
               //se actualiza el registro
               s.executeUpdate("UPDATE clientes SET matricula='" + nMatricula + "' WHERE dni='" + dni + "'");
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
     * @param nReserva aqui estara el nuevo valor del campo reserva
     * @param dni aqui estará el DNI del usuario a modificar
     * Este método sirver para modificar el campo reserva de la tabla clientes
     */
    public void setReserva(String nReserva, String dni){
        Connection conexion = null;
        String dnii;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            // Queremos obtener el id del primer contacto con nombre Juan
            ResultSet rs = s.executeQuery("SELECT dni FROM clientes WHERE dni='" + dni + "'");
           
            
            if(rs.next()){   //Si rs.next() devuelve true significa que al menos hay un registro
               dnii = rs.getString("dni");  //se obtienen su dni
               //se actualiza el registro
               s.executeUpdate("UPDATE clientes SET reserva='" + nReserva + "' WHERE dni='" + dni + "'");
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
     * @param usuario nombre de usuario actual
     * @param nUsuario nombre de usuario nuevo
     * Este método sirver para modificar el nombre de usuario
     */
    public void setUsuario(String usuario, String nUsuario){
        this.usuario = usuario;
        Connection conexion = null;
        String usuarioOr;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            // Queremos obtener el id del primer contacto con nombre Juan
            ResultSet rs = s.executeQuery("SELECT * FROM usuarios WHERE usuario='" + usuario + "'");
           
            
            if(rs.next()){
               usuarioOr = rs.getString(1);  //se obtiene el nombre de ususario
               //se actualiza el registro
               s.executeUpdate("UPDATE usuarios SET usuario='" + nUsuario + "' WHERE usuario='" + usuario + "'");
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
     * @param usuario nombre de usuario al que se le va a modificar la contraseña
     * @param nContraseña contraseña nueva
     * este método sirve para cambiar la contraseña de un usuario
     */
    public void setContraseña(String usuario, String nContraseña){
        this.usuario = usuario;
        Connection conexion = null;
        String contraseñaOr;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            // Queremos obtener el id del primer contacto con nombre Juan
            ResultSet rs = s.executeQuery("SELECT * FROM usuarios WHERE usuario='" + usuario + "'");
           
            
            if(rs.next()){
               contraseñaOr = rs.getString(2);  //se obtiene el nombre de ususario
               //se actualiza el registro
               s.executeUpdate("UPDATE usuarios SET contraseña='" + nContraseña + "' WHERE usuario='" + usuario + "'");
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
     * @param usuario nombre de usuario al que se le va a modificar
     * @param nCorreo nuevo correo de usuario
     * Este método sirve para poder modificar el correo del usuario
     */
    public void setCorreo(String usuario, String nCorreo){
        this.usuario = usuario;
        Connection conexion = null;
        String correoOr;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            // Queremos obtener el id del primer contacto con nombre Juan
            ResultSet rs = s.executeQuery("SELECT * FROM usuarios WHERE usuario='" + usuario + "'");
           
            
            if(rs.next()){
               correoOr = rs.getString(3);  //se obtiene el nombre de ususario
               //se actualiza el registro
               s.executeUpdate("UPDATE usuarios SET email='" + nCorreo + "' WHERE usuario='" + usuario + "'");
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
