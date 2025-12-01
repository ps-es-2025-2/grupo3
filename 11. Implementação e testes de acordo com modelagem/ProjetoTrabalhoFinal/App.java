import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
        Parent root = fxmlLoader.load();
        
        scene = new Scene(root, 400, 300); 
        stage.setScene(scene);
        stage.setTitle("Login - Psicologia Escolar");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}