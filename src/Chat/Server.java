package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
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
    String [] mensaje;
    
    public void start (int port) throws IOException{
        while (active){
            serverSocket = new ServerSocket (port);
            clientSocket = serverSocket.accept();
            BufferedReader lector = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
            mensaje = lector.readLine().split("%");
            procesarTexto (mensaje);
            serverSocket.close();
        }
    }
    
    public void procesarTexto (String [] mensaje){
        Platform.runLater(new Runnable (){
            @Override
            public void run() {               
                Main.actualizarRecibido(mensaje [1], mensaje [0]);
            }
        });        
    }
    
    @Override
    public void run() {
        try {
            this.start(Main.puerto);
        } catch (IOException ex) {
            Main.puerto = new Random ().nextInt((6555 - 1024)+1) + 1024;
        }
    }
}