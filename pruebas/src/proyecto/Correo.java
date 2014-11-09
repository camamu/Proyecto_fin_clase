package proyecto;

import com.sun.mail.util.MailSSLSocketFactory;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane; 
/**
 * 
 * @author Carlos
 */
public class Correo {
    
   String usuarioCorreo;
    String password;
    
    String rutaArchivo;
    String nombreArchivo;
    
    String destinatario;
    String asunto;
    String mensaje;
    /**
     * 
     * @param usuarioCorreo correo de origen
     * @param password contraseña del correo de origen
     * @param rutaArchivo ruta de archivo adjunto
     * @param nombreArchivo nombre del archivo
     * @param destinatario destinatario
     * @param asunto asunto
     * @param mensaje cuerpo del mensaje
     */
    public Correo(String usuarioCorreo, String password, String rutaArchivo, String nombreArchivo, String destinatario, String asunto,String mensaje) {
        this.usuarioCorreo = usuarioCorreo;
        this.password = password;
        this.rutaArchivo = rutaArchivo;
        this.nombreArchivo = nombreArchivo;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
    
    public Correo(String usuarioCorre,String password,String destinatario,String mensaje){
        this(usuarioCorre,password,"","",destinatario,"",mensaje);
    }
    
    public Correo(String usuarioCorre,String password,String destinatario,String asunto,String mensaje){
        this(usuarioCorre,password,"","",destinatario,asunto,mensaje);
    }

/**
 * metodo que se encarga de generar y mandar el correo
 * @return si esta todo correcto devuelve true y manda el correo
 */
    public boolean sendMail(){
        try
        {
      
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", usuarioCorreo);
            props.setProperty("mail.smtp.auth", "true");
            
            //Excepcion SSL para que no salte el antivirus
            MailSSLSocketFactory socketFactory =  new  MailSSLSocketFactory(); 
            socketFactory.setTrustAllHosts ( true ); 
            props.put( "mail.smtp.ssl.socketFactory" , socketFactory );
            
            
            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            if (!rutaArchivo.equals("")){
                 adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(rutaArchivo)));
                adjunto.setFileName(nombreArchivo);                
            }

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (!rutaArchivo.equals("")){
                multiParte.addBodyPart(adjunto);
            }

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuarioCorreo));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(destinatario));
                message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(usuarioCorreo, password);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }        
    }
    
    
    
}
