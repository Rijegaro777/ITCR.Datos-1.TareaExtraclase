package Chat;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *Clase Client
 * 
 * Crea un socket para enviar un mensaje
 * @author gatge
 */
public class Client implements Runnable{
    private Socket client;
    
    public void conectar (String IP, int puerto) throws IOException{
        Socket client = new Socket (IP, 6666);
        OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("Hola\n");
        writer.flush();
        client.close();
    }

    @Override
    public void run() {
        try {
            this.conectar("127.0.0.1", Main.puerto);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
