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
    @FXML public static VBox vBoxContent;
    MainController mainController;
    @Override
    public void start(Stage primaryStage) throws Exception{
        mainController=new MainController();
        Parent root = FXMLLoader.load(getClass().getResource("main/main_view.fxml"));

        primaryStage.setTitle("Gestion societes & employes");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();

        mainController.loader();


    }


    public static void main(String[] args) {
        launch(args);
        System.out.println(vBoxContent);
    }
}
