import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.MainController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("main/main_view.fxml"));

        primaryStage.setTitle("Gestion societes & employes");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);

    }
}
