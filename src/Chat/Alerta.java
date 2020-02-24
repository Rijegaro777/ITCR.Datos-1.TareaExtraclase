package Chat;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Alerta extends Application {
    public static void display (String msg){//Funcion para mostrar la ventana
        // Instancias de los widgets
        Stage rootAlerta;
        Button buttonOK;
        Text text;
        VBox layoutAlerta;
        Scene scene;
        
        rootAlerta = new Stage ();//Crea el Stage
        rootAlerta.setAlwaysOnTop(true);
        rootAlerta.setTitle ("Error!");
        //Dimensiones de la ventana
        rootAlerta.setMinWidth(200);
        rootAlerta.setMinHeight(100);
        rootAlerta.setResizable(false); //No deja que la ventana se cambie de tamano
        
        text = new Text (msg);
        text.setTextAlignment(TextAlignment.CENTER);
        
        buttonOK = new Button ("OK");
        buttonOK.setOnAction(e -> rootAlerta.close ());
        
        layoutAlerta = new VBox (10);
        layoutAlerta.getChildren().addAll (text, buttonOK);
        layoutAlerta.setAlignment(Pos.CENTER); //Alinea todo en el centro
        
        scene = new Scene (layoutAlerta, 200, 100);
        
        rootAlerta.setScene (scene);
        
        rootAlerta.showAndWait (); //Similar al grab_set () de Tkinter 
    }

    @Override
    public void start(Stage stage) throws Exception {        
    }
}
