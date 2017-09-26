package Vista;

import Logica.ManipulaDirectorio;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Index extends Application {

    public static ManipulaDirectorio DIR = new ManipulaDirectorio();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Object page = FXMLLoader.load(Index.class.getResource("fxml/FXMLVista.fxml"));
        Scene scene = new Scene((Parent) page);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static Notifications notFX(String titulo, String texto){
        Notifications not = Notifications.create()
                    .title(titulo)
                    .text(texto)
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BASELINE_LEFT);
        return not;
    }
    
}
