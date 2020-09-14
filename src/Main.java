import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dbHelpers.*;
import main.MainController;

public class Main extends Application {
    DatabaseHelper dbh;
    @Override
    public void start(Stage primaryStage) throws Exception{
        dbh=new DatabaseHelper();
//        dbh.getStatement().executeQuery("INSERT INTO societes (nom, adrr) VALUES ('SAHAM','Casa') ");


        Parent root = FXMLLoader.load(getClass().getResource("main/main_view.fxml"));

        primaryStage.setTitle("Gestion societes & employes");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();






    }


    public static void main(String[] args) {
        launch(args);

    }
}
