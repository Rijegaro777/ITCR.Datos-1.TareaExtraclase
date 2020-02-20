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
      root.setTitle(puerto);
      root.setHeight(500);
      root.setWidth(350);
      root.setResizable(false);
      
      Button nuevoMensaje = new Button ();
      nuevoMensaje.setOnAction(e -> VentanaNuevoMensaje.mostrar());
      nuevoMensaje.setText("+");
      nuevoMensaje.setFont(new Font ("Arial", 20));
      nuevoMensaje.setMinWidth(334);
      
      VBox mensajes = new VBox ();
      mensajes.setSpacing(5);
      
      BorderPane layout = new BorderPane ();
      layout.setCenter(mensajes);
      layout.setBottom(nuevoMensaje);
      
      Scene principal = new Scene(layout, 500, 300);
      
      root.setScene(principal);
      root.show();
    }
}
