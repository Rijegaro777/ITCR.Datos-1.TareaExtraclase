package Chat;

import java.io.IOException;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    static ScrollPane scroll;
    static int posicion;
    
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
      
      
      scroll = new ScrollPane();
      scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
      scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
      scroll.setContent(mensajes);
      
    
      
      
      /**
       * Layout donde se colocarán
       * los mensajes y el botón
       * para enviar un nuevo mensaje
       */
      layout = new BorderPane ();
      layout.setCenter(scroll);
      layout.setBottom(nuevoMensaje);
      
      /**
       * Scene con el layout de la ventana principal
       */
      principal = new Scene(layout, 500, 300);
      
      root.setScene(principal);
      root.setOnCloseRequest(e -> System.exit(0));
      root.show();
    }
    
    public static void agregarMensaje (String msj){
        Text mensaje = new Text ();
        mensaje.setFont(new Font ("Arial", 16));
        mensaje.setText(msj);
        mensaje.setWrappingWidth(332);
        mensaje.setTextAlignment(TextAlignment.LEFT);
        mensajes.add(mensaje, 0, posicion);
        posicion += 1;
    }    
}
