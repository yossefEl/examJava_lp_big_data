package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private VBox vBoxContent;
    @FXML private HBox hb;

//    @FXML private VBox vbx;



    public  void loader() throws Exception{
        VBox vBox= FXMLLoader.load(MainController.class.getResource("../societes/view.fxml"));
        System.out.println(vBox.getChildren());
        System.out.println(vBoxContent);
        System.out.println(hb);
        vBoxContent.getChildren().clear();
        vBoxContent.getChildren().setAll(vBox.getChildren());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
