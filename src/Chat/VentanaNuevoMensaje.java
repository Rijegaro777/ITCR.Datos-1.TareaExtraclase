package Chat;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
    private static Stage stage = new Stage ();
    static TextField entryMensaje;
    static TextField entryPuerto;
    static Label puerto;
    static Label mensaje;
    static Button enviar;
    static VBox datos;
    static Scene scene;
    
    /**
     * Muestra la ventana donde se indicará
     * a qué puerto enviar un mensaje.
     */
    public static void mostrar (){
        stage.setTitle("Nuevo Mensaje");
        stage.setResizable(false);
        stage.setHeight(255);
        stage.setWidth (350);
 
        puerto = new Label ();
        puerto.setText("Puerto:");
        puerto.setFont(new Font ("Arial", 20));
        
        entryPuerto = new TextField ();
        entryPuerto.setFont(new Font ("Arial", 20));
        entryPuerto.setAlignment(Pos.CENTER);
               
        mensaje = new Label ();
        mensaje.setText("Mensaje:");
        mensaje.setFont(new Font ("Arial", 20));
               
        entryMensaje = new TextField ();
        entryMensaje.setFont(new Font ("Arial", 20));
        entryMensaje.setAlignment(Pos.CENTER_LEFT);
        
        enviar = new Button ();
        /**
         * Al presionar el boton enviar verifica
         * que no estén vacíos los campos de mensaje
         * o puerto, luego crea el ClientSocket
         * que enviará el mensaje y agrega el mensaje enviado
         * a la ventana principal; Abre ventanas de error en 
         * caso de que no se logre establecer la conexion.
         */
        enviar.setOnAction(e -> {
            if (entryPuerto.getText().trim().isBlank()){
                Alerta.display("Error al enviar el mensaje: \n Debe indicar un puerto.");
            }else if (Integer.parseInt(entryPuerto.getText()) == Main.puerto) {
                Alerta.display("Error al enviar el mensaje: \n El puerto debe ser diferente.");
            }else if (entryMensaje.getText().trim().isBlank ()) {
                Alerta.display("Error al enviar el mensaje: \n El mensaje debe tener contenido.");
            }else{
                try {
                    Client.conectar("127.0.0.1", Integer.parseInt(entryPuerto.getText()));
                    Main.crearMensajePropio(entryMensaje.getText (), Integer.parseInt(entryPuerto.getText()));
                } catch (IOException ex) {
                    Alerta.display("Error al enviar el mensaje: \n Puerto inválido.");
                }                
            }
            stage.close ();
        });
        enviar.setText("Enviar");
        enviar.setFont(new Font ("Arial", 20));        
        
        datos = new VBox ();
        datos.setPadding(new Insets (10,5,10,5));
        datos.setSpacing(10);
        datos.getChildren().addAll(puerto, entryPuerto, mensaje, entryMensaje, enviar);
        
        scene = new Scene (datos, 300, 300);        
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {        
    }
}