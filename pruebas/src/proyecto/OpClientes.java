package proyecto;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author Carlos
 */
public class OpClientes {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String localidad;
    private int cp;
    private String dni;
    private String email;
    private int telefono;
    private String admitido;
    private String reserva;
    private String matricula;
    private String rConsulta ="Nombre\tApellido1\tApellido2\tLocalidad\tCpostal\tDNI\tE-mail\t\tTelefono\tAdmitido\tReservado\tMatriculado\n\n";
    

    OpClientes() {
    }

    public OpClientes(String nombre, String apellido1, String apellido2, String localidad, int cp, String dni, String email, int telefono, String admitido, String reserva, String matricula) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.localidad = localidad;
        this.cp = cp;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.admitido = admitido;
        this.reserva = reserva;
        this.matricula = matricula;
        
    }

    
    
    /**
     * Este metodo inserta datos en la tabla clientes
     */

    public void insertar() {
        
         Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
    conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();

            //se insertan datos en la tabla
            s.executeUpdate("INSERT INTO clientes VALUES ('" + nombre + "','" + apellido1 + "','" + apellido2 + "','" + localidad + "','" + cp + "','" + dni + "','" + email + "','" + telefono + "','" + admitido + "','" + reserva + "','" + matricula + "')");
            

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
     * @param dni el dni del usuario que se va a eliminar
     * Este método elimina un cliente
     */
    public void eliminar(String dni){
        this.dni=dni;
        
        Connection conexion = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");

            // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");

            // Se crea un Statement, para realizar el query
            Statement s = conexion.createStatement();

            //se borran datos del sistema
            s.executeUpdate("DELETE FROM clientes WHERE dni ='" + dni + "'");
            

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
    public void consultar() {
  
        //BBDD
        
        Connection conexion = null;
        
         try {
            //Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conexion
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/comercial", "root", "root");
            Statement s = conexion.createStatement();

            //realiza la consulta
            ResultSet rs = s.executeQuery("select * from clientes");

            //recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
                rConsulta+=rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)+ "\t" + rs.getString(4)+ "\t" + rs.getString(5)+ "\t" + rs.getString(6)+ "\t" + rs.getString(7)+ "\t" + rs.getInt(8)+ "\t" + rs.getString(9)+ "\t" + rs.getString(10)+"\t" + rs.getString(11)+"\n" ;
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
     * @return 
     */
    
    public String getConsulta(){
        
        return rConsulta;
    }    
}
