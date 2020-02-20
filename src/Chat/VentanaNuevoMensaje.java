package Chat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *Clase VentanaNuevoMensaje
 * 
 *Es la ventana donde se ingresará el puerto y
 * el mensaje que se desea enviar
 * 
 * @author gatge
 * @version 1.0
 */
public class VentanaNuevoMensaje extends Application {
    public static void mostrar (){
        Stage stage = new Stage ();
        stage.setTitle("Nuevo Mensaje");
        stage.setResizable(false);
        stage.setHeight(255);
        stage.setWidth (350);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        Button enviar = new Button ();
        enviar.setText("Enviar");
        enviar.setFont(new Font ("Arial", 20));
        
        Label puerto = new Label ();
        puerto.setText("Puerto:");
        puerto.setFont(new Font ("Arial", 20));
        
        TextField entryPuerto = new TextField ();
        entryPuerto.setFont(new Font ("Arial", 20));
        entryPuerto.setAlignment(Pos.CENTER);
        
        Label mensaje = new Label ();
        mensaje.setText("Mensaje:");
        mensaje.setFont(new Font ("Arial", 20));
        
        TextField entryMensaje = new TextField ();
        entryMensaje.setFont(new Font ("Arial", 20));
        entryMensaje.setAlignment(Pos.CENTER_LEFT);
        
        VBox datos = new VBox ();
        datos.setPadding(new Insets (10,5,10,5));
        datos.setSpacing(10);
        datos.getChildren().addAll(puerto, entryPuerto, mensaje, entryMensaje, enviar);
                
        Scene scene = new Scene (datos, 300, 300);        
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {        
    }
}