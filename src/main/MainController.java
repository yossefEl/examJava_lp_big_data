package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {
    @FXML private VBox vBoxContent;
//    @FXML private VBox vbx;


    public  void loader() throws Exception{
        VBox vBox= FXMLLoader.load(MainController.class.getResource("../societes/view.fxml"));
        System.out.println(vBox.getChildren());
        System.out.println(vBoxContent);


//        vBoxContent.getChildren().clear();
//        vBoxContent.getChildren().setAll(vBox.getChildren());
    }
}
