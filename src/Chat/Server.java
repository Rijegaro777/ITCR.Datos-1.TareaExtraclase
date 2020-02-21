package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *Clase Server
 * 
 * Crea un socket para recibir mensajes
 * 
 * @author gatge
 */
public class Server implements Runnable{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private final boolean active = true;
    String mensaje;
    
    public void start (int port) throws IOException{
        while (active){
            System.out.println("Listening");
            serverSocket = new ServerSocket (port);
            clientSocket = serverSocket.accept();
            BufferedReader lector = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
            mensaje = lector.readLine();
            Platform.runLater(new Runnable (){
                @Override
                public void run() {
                    Main.agregarMensaje (mensaje);
                }
                
            });
            System.out.println(clientSocket.getPort ());
            serverSocket.close();
        }
    }
    
    @Override
    public void run() {
        try {
            this.start(Main.puerto);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}