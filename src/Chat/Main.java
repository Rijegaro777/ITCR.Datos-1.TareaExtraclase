package Chat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
    /**
     * String para el puerto que se utilizará
     */
    private String puerto = "Puerto: " + "0000";
    
    public static void main(String[] args) {
       launch(args); 
    }
    @Override
    public void start(Stage root) throws Exception {
        /**
         * Configuraciones iniciales de la ventana
         */
      root.setTitle(puerto);
      root.setHeight(500);
      root.setWidth(350);
      root.setResizable(false);
      
      /**
       * Boton que abre una ventana 
       * donde se enviará un mensaje nuevo
       */
      Button nuevoMensaje = new Button ();
      nuevoMensaje.setOnAction(e -> VentanaNuevoMensaje.mostrar());
      nuevoMensaje.setText("+");
      nuevoMensaje.setFont(new Font ("Arial", 20));
      nuevoMensaje.setMinWidth(334);
      
      /**
       * Layout donde se mostrarán
       * los mensajes recibidos
       */
      VBox mensajes = new VBox ();
      mensajes.setSpacing(5);
      
      /**
       * Layout donde se colocarán
       * los mensajes y el botón
       * para enviar un nuevo mensaje
       */
      BorderPane layout = new BorderPane ();
      layout.setCenter(mensajes);
      layout.setBottom(nuevoMensaje);
      
      /**
       * Scene con el layout de la ventana principal
       */
      Scene principal = new Scene(layout, 500, 300);
      
      root.setScene(principal);
      root.show();
    }
}
