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
    /**
     * Muestra la ventana donde se indicará
     * a qué puerto enviar un mensaje
     */
    public static void mostrar (){
        /**
         * Configuraciones iniciales de la ventana
         */
        Stage stage = new Stage ();
        stage.setTitle("Nuevo Mensaje");
        stage.setResizable(false);
        stage.setHeight(255);
        stage.setWidth (350);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        /**
         * Boton para enviar el mensaje
         * al puerto ingresado
         */
        Button enviar = new Button ();
        enviar.setOnAction(e -> {
            Runnable client = new Client ();
            new Thread (client).start();
        });
        enviar.setText("Enviar");
        enviar.setFont(new Font ("Arial", 20));
        
        /**
         * Label que indica donde ingresar
         * el puerto donde se enviará
         * el mensaje
         */
        Label puerto = new Label ();
        puerto.setText("Puerto:");
        puerto.setFont(new Font ("Arial", 20));
        
        /**
         * Entrada de texto donde
         * se escribirá el puerto
         * al que se enviará el mensaje
         */
        TextField entryPuerto = new TextField ();
        entryPuerto.setFont(new Font ("Arial", 20));
        entryPuerto.setAlignment(Pos.CENTER);
        
        /**
         * Label que indica donde ingresar
         * el mensaje que se enviará
         */        
        Label mensaje = new Label ();
        mensaje.setText("Mensaje:");
        mensaje.setFont(new Font ("Arial", 20));
        
        /**
         * Entrada de texto donde
         * se escribirá el mensaje
         * que se enviará
         */        
        TextField entryMensaje = new TextField ();
        entryMensaje.setFont(new Font ("Arial", 20));
        entryMensaje.setAlignment(Pos.CENTER_LEFT);
        
        /**
         * Layout donde se colocarán
         * todos los elementos de la ventana
         */
        VBox datos = new VBox ();
        datos.setPadding(new Insets (10,5,10,5));
        datos.setSpacing(10);
        datos.getChildren().addAll(puerto, entryPuerto, mensaje, entryMensaje, enviar);
        
        /**
         * scene de la ventana
         */
        Scene scene = new Scene (datos, 300, 300);        
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {        
    }
}