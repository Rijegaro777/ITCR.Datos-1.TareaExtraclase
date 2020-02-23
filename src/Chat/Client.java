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
    
    public static void conectar (String IP, int puerto) throws IOException{
        Socket client = new Socket (IP, puerto);
        OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        writer.write(Main.puerto + "%" + VentanaNuevoMensaje.entryMensaje.getText());
        writer.flush();
        client.close();
    }
}
