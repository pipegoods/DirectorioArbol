package Vista;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Index extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println(Index.class.getResource("fxml/FXMLVista.fxml"));
        Object page = FXMLLoader.load(Index.class.getResource("fxml/FXMLVista.fxml"));
        Scene scene = new Scene((Parent) page);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
