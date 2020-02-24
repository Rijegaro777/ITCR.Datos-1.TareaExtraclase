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
    /**
     * Muestra la ventana de error con el mensaje que se le indique
     * como parámetro.
     * @param msg String con el mensaje que se mostrará en la ventana.
     */
    public static void display (String msg){
        Stage rootAlerta;
        Button buttonOK;
        Text text;
        VBox layoutAlerta;
        Scene scene;
        
        rootAlerta = new Stage ();
        rootAlerta.setAlwaysOnTop(true);
        rootAlerta.setTitle ("Error!");
        rootAlerta.setMinWidth(200);
        rootAlerta.setMinHeight(100);
        rootAlerta.setResizable(false);
        
        text = new Text (msg);
        text.setTextAlignment(TextAlignment.CENTER);
        
        buttonOK = new Button ("OK");
        buttonOK.setOnAction(e -> rootAlerta.close ());
        
        layoutAlerta = new VBox (10);
        layoutAlerta.getChildren().addAll (text, buttonOK);
        layoutAlerta.setAlignment(Pos.CENTER);
        
        scene = new Scene (layoutAlerta, 200, 100);
        
        rootAlerta.setScene (scene);
        
        rootAlerta.showAndWait ();
    }

    @Override
    public void start(Stage stage) throws Exception {        
    }
}
