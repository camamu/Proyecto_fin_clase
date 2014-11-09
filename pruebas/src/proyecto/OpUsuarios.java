package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class OpUsuarios {
    
    private String usuario;
    private String contraseña;
    private String correo;
    private String administrador;

    public OpUsuarios() {
    }

    public OpUsuarios(String usuario, String contraseña, String correo, String administrador) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.administrador = administrador;
    }

    /**
     * Este método crea un nuevo usuario
     */
    public void crear(){
        
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();

            //se insertan datos en la tabla
            s.executeUpdate("INSERT INTO usuarios VALUES ('" + usuario + "','" + contraseña + "','" + correo + "','" + administrador + "')");
            

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
     * @param usuario nombre de usuario al que vas a eliminar
     * elimina un usuario
     */
    public void eliminar(String usuario){
        this.usuario=usuario;
        
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();

            //se borran datos del sistema
            s.executeUpdate("DELETE FROM usuarios WHERE usuario ='" + usuario + "'");
            

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
     * recuperar contraseña de usuario
     * @param usuario nombre deusuario del que quieres recuperar la contraseña
     */
    
    public void recContraseña(String usuario){
        this.usuario=usuario;
        String correo="";
        
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            ResultSet rs = s.executeQuery("SELECT * FROM usuarios WHERE usuario='" + usuario + "'");
           
            
            if(rs.next()){
               correo = rs.getString(3);  //se obtiene su correo
               contraseña = rs.getString(2);  //se obtiene su contraseña
               //se manda el correo
              Correo rcontraseña = new Correo("desarrollador.93.04.17@gmail.com", "nezsesszqpuqxcuk", correo, "Recuperacion de contraseña:", "Su contraseña es: "+contraseña);
              rcontraseña.sendMail();
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
     * este método sirve para loguearse
     * @param usuario nombre usuario
     * @param contraseña contraseña usuario
     * @return devuelve true si coincide usuario y contraseña
     */
    public boolean login(String usuario, String contraseña){
        this.usuario=usuario;
        this.contraseña=contraseña;
        Connection conexion = null;
        boolean validUser = false;
        
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            ResultSet rs = s.executeQuery("SELECT * FROM usuarios WHERE usuario='" + usuario + "'");
           
            
            if(rs.next()){
               String cValida = rs.getString(2);
               validUser = (contraseña.equals(cValida));
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
        return validUser;
    }
    /**
     * Compueba si eres administrador
     * @param usuario nombre de usuario
     * @return si eres administrador devuelve true
     */
    public boolean administrador(String usuario){
        boolean admin = false;
        Connection conexion = null;
        boolean validUser = false;
        
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();
           
            // Se realiza la consulta
            ResultSet rs = s.executeQuery("SELECT * FROM usuarios WHERE administrador='si' AND usuario='" + usuario + "'");
           
            
            if(rs.next()){
               admin = true;
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
        return admin;
    }
}
