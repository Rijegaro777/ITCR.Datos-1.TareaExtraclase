package Chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *Clase Client
 * 
 * Crea un socket para enviar un mensaje
 * @author gatge
 */
public class Client{
    private Socket client;
    
    /**
     * Se conecta a la IP y al puerto que se le indiquen
     * y envía el puerto del ServerSocket con un marcador
     * que luego será procesado por el ServerSocket que lo reciba.
     * @param IP
     * @param puerto
     * @throws IOException 
     */
    public static void conectar (String IP, int puerto) throws IOException{
        Socket client = new Socket (IP, puerto);
        OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        writer.write(Main.puerto + "%" + VentanaNuevoMensaje.entryMensaje.getText());
        writer.flush();
        client.close();
    }
}
