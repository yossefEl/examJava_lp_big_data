package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {
    @FXML private VBox vBoxContent;
    @FXML private VBox vbx;
    public MainController() throws IOException {
        VBox vBox= FXMLLoader.load(getClass().getResource("../societes/view.fxml"));
        System.out.println(vBox.getChildren());
        System.out.println(vbx);

//        vBoxContent.getChildren().clear();
//        vBoxContent.getChildren().setAll(vBox.getChildren());
    }
}
