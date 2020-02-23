package Chat;

import listaenlazada.*;
import java.io.IOException;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Clase Main
 * 
 * Se ejecuta cada vez que se abre el programa
 * Muestra la interfaz de javaFX
 * 
 * @author gatge
 * @version 1.0
 */
public class Main extends Application{
    /**
     * Ventana principal del programa
     */
    private final Stage root = new Stage ();
    static GridPane mensajes;
    static BorderPane layout;
    static Scene principal;
    static Button nuevoMensaje;
    static ScrollPane scrollContactos;
    static ScrollPane scrollHistorial;
    static int posicion;
    static Lista listaHistorial = new Lista ();
    
    static Random rand = new Random ();
    static int puerto = rand.nextInt((6555 - 1024)+1) + 1024;

    
    /**
     * String para el puerto que se utilizará
     */
    private static String titulo = "Puerto: " + puerto;
    
    public static void main(String[] args) throws IOException {
        Runnable server = new Server ();
        new Thread (server).start();
        launch(args); 
    }
    @Override
    public void start(Stage root) throws Exception {
        /**
         * Configuraciones iniciales de la ventana
         */
      root.setTitle(titulo);
      root.setHeight(500);
      root.setWidth(350);
      root.setResizable(false);
      
      /**
       * Boton que abre una ventana 
       * donde se enviará un mensaje nuevo
       */
      nuevoMensaje = new Button ();
      nuevoMensaje.setOnAction(e -> VentanaNuevoMensaje.mostrar());
      nuevoMensaje.setText("+");
      nuevoMensaje.setFont(new Font ("Arial", 20));
      nuevoMensaje.setMinWidth(334);
      
      /**
       * Layout donde se mostrarán
       * los mensajes recibidos
       */
      mensajes = new GridPane ();
      mensajes.setGridLinesVisible(true);
      mensajes.setVgap(10);
      
      
      scrollContactos = new ScrollPane();
      scrollContactos.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
      scrollContactos.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
      scrollContactos.setMinWidth(100);
      scrollContactos.setContent(mensajes);
      
      scrollHistorial = new ScrollPane ();
      scrollHistorial.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
      scrollHistorial.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
      scrollHistorial.setMinWidth (234);
      
      /**
       * Layout donde se colocarán
       * los mensajes y el botón
       * para enviar un nuevo mensaje
       */
      layout = new BorderPane ();
      layout.setLeft(scrollContactos);
      layout.setBottom(nuevoMensaje);
      layout.setCenter(scrollHistorial);
      
      /**
       * Scene con el layout de la ventana principal
       */
      principal = new Scene(layout, 500, 300);
      
      root.setScene(principal);
      root.setOnCloseRequest(e -> System.exit(0));
      root.show();
    }
    
    public static void actualizarRecibido (String msj, String puerto){
        if (listaHistorial.getLength() != 0){
            for (int i = 0; i < listaHistorial.getLength(); i++){
                Lista sublista = (Lista) listaHistorial.getPos(i);
                int puertoChat = (int) sublista.getPos(1);
                if (puertoChat == Integer.parseInt(puerto)){
                    actualizarHistorial (msj, Integer.parseInt(puerto));
                    return;
                }
            }    
            crearRecibido (msj, puerto);            
        }else{
            crearRecibido (msj, puerto);             
        }
    }    
    
    public static void crearRecibido (String msj, String emisor){
        Text puerto = new Text ();
        puerto.setFont(new Font ("Arial", 20));
        puerto.setText(emisor);
        puerto.setWrappingWidth(100);
        puerto.setTextAlignment(TextAlignment.CENTER);
        mensajes.add(puerto, 0, posicion);
        posicion += 1;            
        puerto.setOnMouseClicked(e -> mostrarHistorial (Integer.parseInt(puerto.getText())));
        crearHistorial (msj, Integer.parseInt(emisor));
    }
    
    public static void actualizarHistorial (String msj, int puerto){
        for (int i = 0; i < listaHistorial.getLength(); i++){
            Lista sublista = (Lista) listaHistorial.getPos(i);
            int puertoChat = (int) sublista.getPos(1);
            VBox mensajesChat = (VBox) sublista.getPos(0);
            if (puertoChat == puerto){
                mensajesChat.getChildren().add(new Label (msj));
                return;
            }
        }
        System.out.println ("Hola");
        crearHistorial (msj, puerto);
    }
    
    public static void crearHistorial (String msj, int puerto){
        VBox historial = new VBox ();
        historial.getChildren().add(new Label (msj));
        Lista chat = new Lista ();
        chat.add(historial);
        chat.add(puerto);
        listaHistorial.add(chat);   
    }
    
    public static void mostrarHistorial (int puerto){
        for (int i = 0; i < listaHistorial.getLength(); i++){
            Lista sublista = (Lista) listaHistorial.getPos(i);
            int puertoChat = (int) sublista.getPos(1);
            VBox mensajesChat = (VBox) sublista.getPos(0);
            if (puertoChat == puerto){
                scrollHistorial.setContent(mensajesChat);
            }
        }
    }
}
